package gaming_account_extension;

import gaming_account.GamingAccountInterface;

public abstract class GamingAccountDecorator {
  protected GamingAccountInterface baseGamingAccount;

  public void playGame() {
    baseGamingAccount.playGame();
  }

  public String getUsername() {
    return baseGamingAccount.getUsername();
  }

  public boolean isPlaying() {
    return baseGamingAccount.isPlaying();
  }

  public boolean isBanned() {
    return baseGamingAccount.isBanned();
  }

  public void setIsPlaying(boolean isPlaying) {
    baseGamingAccount.setIsPlaying(isPlaying);
  }
}