package standard_gaming_account;

import gaming_account.GamingAccountInterface;
import java.util.Timer;

public class StandardGamingAccount extends GamingAccountDecorator {
  public StandardGamingAccount(GamingAccountInterface baseGamingAccount) {
    this.baseGamingAccount = baseGamingAccount;
  }

  public void playGameDLCForAGivenTime(int delay) {
    if (isBanned()) {
      System.out.println(username + " can't play because it's banned!");
    } else if (!isPlaying()) {
      System.out.println(username + " is playing game DLC trial.");
      playForAGivenTime(delay);
    } else {
      System.out.println(username + " can't play game DLC trial because it's already playing.");
    }
  }

  public void playForAGivenTime(int delay) {
    setIsPlaying(true);
    EndGameDLC endGameTask = new EndGameDLC();
    Timer endGameTimer = new Timer();
    endGameTimer.schedule(EndGameDLC, delay);
  }
}