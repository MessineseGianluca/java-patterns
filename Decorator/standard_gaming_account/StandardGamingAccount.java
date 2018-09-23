package standard_gaming_account;

import gaming_account.GamingAccountInterface;
import gaming_account_extension.*;
import java.util.Timer;
import java.lang.Thread;

public class StandardGamingAccount extends GamingAccountDecorator {
  public StandardGamingAccount(GamingAccountInterface baseGamingAccount) {
    this.baseGamingAccount = baseGamingAccount;
  }

  public void playGameDLCForAGivenTime(int delay) {
    if (isBanned()) {
      System.out.println(getUsername() + " can't play because it's banned!");
    } else if (!isPlaying()) {
      System.out.println(getUsername() + " is playing game DLC trial.");
      playForAGivenTime(delay);
    } else {
      System.out.println(getUsername() + " can't play game DLC trial because it's already playing.");
    }
  }

  public void playForAGivenTime(int delay) {
    setIsPlaying(true);
    EndGameDLC endGameTask = new EndGameDLC();
    Timer endGameTimer = new Timer();
    endGameTimer.schedule(endGameTask, delay);

    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
      System.out.println(e);
    }
    endGameTimer.cancel();
    setIsPlaying(false);
  }
}