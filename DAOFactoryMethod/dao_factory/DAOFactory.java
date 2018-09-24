package dao_factory;

public abstract class DAOFactory {
  public abstract FootballerDAO getFootballerDAO();

  public abstract FootballTeamDAO getFootballTeamDAO();
}