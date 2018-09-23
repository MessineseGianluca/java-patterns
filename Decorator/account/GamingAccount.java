package account;

public class GamingAccount implements GamingAccountInterface {
  private String username;
  private boolean banned;
  private boolean isPlaying;

  public GamingAccount(String username, boolean banned) {
    this.username = username;
    this.banned = banned;
  }

  public void playGame() {
    if (banned) {
      System.out.println(username + " can't play because it's banned!");
    } else if (!isPlaying) {
      System.out.println(username + " is playing the game.");
      isPlaying = true;
    } else {
      System.out.println(username + " is already playing.");
    }
  }

  public String getUsername() {
    return username;
  }

  public boolean isBanned() {
    return banned;
  }

}