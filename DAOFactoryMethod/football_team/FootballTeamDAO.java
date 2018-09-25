package football_team;

public interface FootballTeamDAO {
  public boolean insertFootballTeam(FootballTeamTO team);

  public boolean updateFootballTeam(FootballTeamTO team);

  public boolean deleteFootballTeam(int teamId);

  public FootballTeamTO getFooballTeamInfo();

  public boolean addFootballer(int footballerId);

  public boolean deleteFootballerFromTheTeam(int footballerId);

  public FootballerTO[] getFootballers();
}