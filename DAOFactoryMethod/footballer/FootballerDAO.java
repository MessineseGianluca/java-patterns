package footballer;

public interface FootballerDAO {
  public boolean insertFootballer(FootballerTO footballer);

  public boolean updateFootballer(FootballerTO footballer);

  public boolean deleteFootballer(int footballerID);

  public FootballerTO getFootballerInfo();
}