package dao_factory;

import footballer.*;
import football_team.*;

public class MysqlDAOFactory extends DAOFactory {
    public FootballerDAO getFootballerDAO() {
      return new MysqlFootballerDAO();
    }
    
    public FootballTeamDAO getFootballTeamDAO() {
      return new MysqlFootballTeamDAO();
    }
  }