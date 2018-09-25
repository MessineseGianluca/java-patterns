package footballer;

import dao_factory.MysqlDAOFactory;
import java.sql.*;

public class MysqlFootballerDAO implements FootballerDAO {
  private String tableName = "footballer";

  private String insertSQL = "INSERT INTO " + tableName + "(id, name, nationality) VALUES (?, ?, ?)";
  private String updateSQL = "UPDATE" + tableName + " SET name = ?, nationality = ? WHERE id = ?";
  private String deleteSQL = "DELETE FROM " + tableName + " WHERE id = ?";
  private String readSQL = "SELECT * FROM " + tableName + " WHERE id = ?";

  public boolean insertFootballer(FootballerTO footballer) {
    try {
      Connection conn = MysqlDAOFactory.getConnection();
      PreparedStatement prepStatement = conn.prepareStatement(insertSQL);
      prepStatement.setInt(1, footballer.getId());
      prepStatement.setString(2, footballer.getName());
      prepStatement.setString(3, footballer.getNationality());
      int insertedRows = prepStatement.executeUpdate();
      boolean result = (insertedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public boolean updateFootballer(FootballerTO footballer) {
    try {
      Connection conn = MysqlDAOFactory.getConnection();
      PreparedStatement prepStatement = conn.prepareStatement(updateSQL);
      prepStatement.setString(1, footballer.getName());
      prepStatement.setString(2, footballer.getNationality());
      prepStatement.setInt(3, footballer.getId());
      int updatedRows = prepStatement.executeUpdate();
      boolean result = (updatedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public boolean deleteFootballer(int footballerId) {
    try {
      Connection conn = MysqlDAOFactory.getConnection();
      PreparedStatement prepStatement = conn.prepareStatement(deleteSQL);
      prepStatement.setInt(1, footballerId);
      int deletedRows = prepStatement.executeUpdate();
      boolean result = (deletedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public FootballerTO getFootballerInfo(int footballerId) {
    try {
      Connection conn = MysqlDAOFactory.getConnection();
      PreparedStatement prepStatement = conn.prepareStatement(readSQL);
      prepStatement.setInt(1, footballerId);
      ResultSet result = prepStatement.executeQuery();
      if (result.next()) {
        FootballerTO footballer = new FootballerTO(result.getInt(1), result.getString(2), result.getString(3));
      }
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement, result);
    }
    return result;
  }

  private finallyBlock(Object... objectsToClose) {
    try {  
      for(Object object:objectsToClose) {
        object.close();
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}