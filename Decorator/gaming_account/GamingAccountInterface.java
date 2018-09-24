package gaming_account;

public interface GamingAccountInterface {
  public void playGame();

  public String getUsername();

  public boolean isPlaying();

  public boolean isBanned();

  public void setIsPlaying(boolean isPlaying);
}