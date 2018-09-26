package football_team;

public class MysqlFootballTeamDAO implements FootballTeamDAO {
  private String tableName = "team";

  private String insertSQL = "INSERT INTO " + tableName + "(id, name) VALUES (?, ?)";
  private String deleteSQL = "DELETE FROM " + tableName + " WHERE id = ?";
  private String updateSQL = "UPDATE" + tableName + " SET name = ? WHERE id = ?";
  private String selectSQL = "SELECT * FROM " + tableName + " WHERE id = ?";

  public boolean insertFootballTeam(FootballTeamTO team) {
    try {
      Connection conn = MysqlDAOFactory.getConnection();
      PreparedStatement prepStatement = conn.prepareStatement(insertSQL);
      prepStatement.setInt(1, team.getId());
      prepStatement.setString(2, team.getName());
      int insertedRows = prepStatement.executeUpdate();
      boolean result = (insertedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public boolean deleteFootballTeam(int teamId) {
    try {
      Connection conn = MysqlDAOFactory.getConnection();
      PreparedStatement prepStatement = conn.prepareStatement(insertSQL);
      prepStatement.setInt(1, teamId);
      int insertedRows = prepStatement.executeUpdate();
      boolean result = (insertedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public boolean updateFootballTeam(FootballTeamTO team) {
    try {
      Connection conn = MysqlDAOFactory.getConnection();
      PreparedStatement prepStatement = conn.prepareStatement(updateSQL);
      prepStatement.setString(1, team.getName());
      prepStatement.setInt(2, team.getId());
      int insertedRows = prepStatement.executeUpdate();
      boolean result = (insertedRows > 0);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement);
    }
    return result;
  }

  public FootballTeamTO getFootballTeamInfo(int teamId) {
    try {
      Connection conn = MysqlDAOFactory.getConnection();
      PreparedStatement prepStatement = conn.prepareStatement(selectSQL);
      prepStatement.setInt(1, teamId);
      ResultSet result = prepStatement.executeQuery();
      if (result.next()) {
        FootballTeamTO footballTeam = new FootballTeamTO(result.getInt(1), result.getString(2));
      }
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } finally {
      finallyBlock(conn, prepStatement, result);
    }
    return footballTeam;
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