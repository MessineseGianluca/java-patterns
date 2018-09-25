package footballer;

public interface FootballerDAO {
  public boolean insertFootballer(FootballerTO footballer);

  public boolean updateFootballer(FootballerTO footballer);

  public boolean deleteFootballer(int footballerId);

  public FootballerTO getFootballerInfo(int FootballerId);
}