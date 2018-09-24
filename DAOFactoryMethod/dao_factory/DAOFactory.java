package dao_factory;

import football_team.FootballTeamDAO;
import footballer.FootballerDAO;

public abstract class DAOFactory {
  public abstract FootballerDAO getFootballerDAO();

  public abstract FootballTeamDAO getFootballTeamDAO();
}