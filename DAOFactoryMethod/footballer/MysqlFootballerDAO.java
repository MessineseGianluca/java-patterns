package footballer;

import dao_factory.MysqlDAOFactory;
import footballer.FootballerTO;
import java.util.List;
import java.util.LinkedList;

import java.sql.*;

public class MysqlFootballerDAO implements FootballerDAO {
  private String tableName = "footballer";

  private String insertSQL = "INSERT INTO " + tableName + "(name, nationality, teamId) VALUES (?, ?, ?)";
  private String updateSQL = "UPDATE " + tableName + " SET name = ?, nationality = ?, teamId = ? WHERE id = ?";
  private String deleteSQL = "DELETE FROM " + tableName + " WHERE id = ?";
  private String selectSQL = "SELECT * FROM " + tableName + " WHERE id = ?";
  private String selectFootballersOfTeamSQL = "SELECT * FROM " + tableName + " WHERE teamId = ?";

  public boolean insertFootballer(FootballerTO footballer) {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    boolean result = false;

    try {
      conn = MysqlDAOFactory.getConnection();
      prepStatement = conn.prepareStatement(insertSQL);
      prepStatement.setString(1, footballer.getName());
      prepStatement.setString(2, footballer.getNationality());
      prepStatement.setInt(3, footballer.getTeamId());
      int insertedRows = prepStatement.executeUpdate();
      result = (insertedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public boolean updateFootballer(FootballerTO footballer) {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    boolean result = false;

    try {
      conn = MysqlDAOFactory.getConnection();
      prepStatement = conn.prepareStatement(updateSQL);
      prepStatement.setString(1, footballer.getName());
      prepStatement.setString(2, footballer.getNationality());
      prepStatement.setInt(3, footballer.getId());
      prepStatement.setInt(4, footballer.getTeamId());
      int updatedRows = prepStatement.executeUpdate();
      result = (updatedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public boolean deleteFootballer(int footballerId) {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    boolean result = false;

    try {
      conn = MysqlDAOFactory.getConnection();
      prepStatement = conn.prepareStatement(deleteSQL);
      prepStatement.setInt(1, footballerId);
      int deletedRows = prepStatement.executeUpdate();
      result = (deletedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public FootballerTO getFootballerInfo(int footballerId) {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    ResultSet result = null;
    FootballerTO footballer = null;

    try {
      conn = MysqlDAOFactory.getConnection();
      prepStatement = conn.prepareStatement(selectSQL);
      prepStatement.setInt(1, footballerId);
      result = prepStatement.executeQuery();
      if (result.next()) {
        footballer = new FootballerTO(result.getInt(1), result.getString(2), result.getString(3), result.getInt(4));
      }
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement, result);
    }
    return footballer;
  }

  public List<FootballerTO> getFootballersOfTeam(int teamId) {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    ResultSet result = null;
    List<FootballerTO> footballers = new LinkedList<FootballerTO>();

    try {
      conn = MysqlDAOFactory.getConnection();
      prepStatement = conn.prepareStatement(selectFootballersOfTeamSQL);
      prepStatement.setInt(1, teamId);
      result = prepStatement.executeQuery();
      while (result.next()) {
        FootballerTO footballer = new FootballerTO(result.getInt(1), result.getString(2), result.getString(3),
            result.getInt(4));
        footballers.add(footballer);
      }
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement, result);
    }
    return footballers;
  }

  private void finallyBlock(Connection conn, PreparedStatement prepStatement) {
    try {
      conn.close();
      prepStatement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void finallyBlock(Connection conn, PreparedStatement prepStatement, ResultSet result) {
    try {
      conn.close();
      prepStatement.close();
      result.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}