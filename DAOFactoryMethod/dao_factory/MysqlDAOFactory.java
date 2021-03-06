package dao_factory;

import footballer.*;
import football_team.*;
import java.sql.*;

public class MysqlDAOFactory extends DAOFactory {
  private static final String DBMS = "jdbc:mysql";
  private static final String SERVER = "localhost";
  private static final String DATABASE = "footballers";
  private static final String PORT = "3306";
  private static final String USER_ID = "root";
  private static final String PASSWORD = "";

  private static Connection conn = null;

  public static Connection getConnection() {
    try {
      String url = DBMS + "://" + SERVER + ":" + PORT + "/" + DATABASE + "?user=" + USER_ID + "&password=" + PASSWORD + "&useSSL=false";
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection(url);
    } catch (SQLException sqlE) {
      sqlE.printStackTrace();
    } catch (ClassNotFoundException classE) {
      classE.printStackTrace();
    }
    return conn;
  }

  public FootballerDAO getFootballerDAO() {
    return new MysqlFootballerDAO();
  }

  public FootballTeamDAO getFootballTeamDAO() {
    return new MysqlFootballTeamDAO();
  }
}