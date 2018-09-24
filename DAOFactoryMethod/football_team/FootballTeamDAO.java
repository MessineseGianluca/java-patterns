package football_team;

public interface FootballTeamDAO {
  public boolean insertFootballTeam(FootballTeamTO team);

  public boolean updateFootballTeam(FootballTeamTO team);

  public boolean deleteFootballTeam(int teamID);

  public FootballTeamTO getFooballTeamInfo();

  public boolean addFootballer(int footballerID);

  public boolean deleteFootballerFromTheTeam(int footballerID);

  public FootballerTO[] getFootballers();
}