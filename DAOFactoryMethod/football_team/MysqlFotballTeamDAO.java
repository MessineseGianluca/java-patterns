package football_team;

import java.sql.PreparedStatement;

import football_team.FootballTeamTO;

public class MysqlFootballTeamDAO implements FootballTeamDAO {
  private String tableName = "team";

  private String insertSQL = "INSERT INTO " + tableName + "(id, name) VALUES (?, ?)";
  private String deleteSQL = "DELETE FROM " + tableName + " WHERE id = ?";
  private String updateSQL = "UPDATE" + tableName + " SET name = ? WHERE id = ?";
  private String selectSQL = "SELECT * FROM " + tableName + " WHERE id = ?";

  public boolean insertFootballTeam(FootballTeamTO team) {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    boolean result = false;

    try {
      conn = MysqlDAOFactory.getConnection();
      prepStatement = conn.prepareStatement(insertSQL);
      prepStatement.setInt(1, team.getId());
      prepStatement.setString(2, team.getName());
      int insertedRows = prepStatement.executeUpdate();
      result = (insertedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public boolean deleteFootballTeam(int teamId) {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    boolean result = false;

    try {
      conn = MysqlDAOFactory.getConnection();
      prepStatement = conn.prepareStatement(insertSQL);
      prepStatement.setInt(1, teamId);
      int insertedRows = prepStatement.executeUpdate();
      result = (insertedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public boolean updateFootballTeam(FootballTeamTO team) {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    boolean result = false;

    try {
      conn = MysqlDAOFactory.getConnection();
      prepStatement = conn.prepareStatement(updateSQL);
      prepStatement.setString(1, team.getName());
      prepStatement.setInt(2, team.getId());
      int insertedRows = prepStatement.executeUpdate();
      result = (insertedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public FootballTeamTO getFootballTeamInfo(int teamId) {
    Connection conn = null;
    PreparedStatement prepStatement = null;
    ResultSet result = null;
    FootballTeamTO footballTeam = null;

    try {
      conn = MysqlDAOFactory.getConnection();
      prepStatement = conn.prepareStatement(selectSQL);
      prepStatement.setInt(1, teamId);
      result = prepStatement.executeQuery();
      if (result.next()) {
        footballTeam = new FootballTeamTO(result.getInt(1), result.getString(2));
      }
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement, result);
    }
    return footballTeam;
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