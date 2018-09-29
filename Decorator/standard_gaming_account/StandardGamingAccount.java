package standard_gaming_account;

import gaming_account.GamingAccountInterface;
import gaming_account_extension.*;
import java.util.Timer;
import java.util.TimerTask;
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

  private void playForAGivenTime(int delay) {
    setIsPlaying(true);
    Timer endGameTimer = new Timer();
    TimerTask endGameTask = new TimerTask() {
      @Override
      public void run() {
        System.out.println("Game DLC trial time expired for " + getUsername());
        setIsPlaying(false);
        endGameTimer.cancel();
      }
    };
    endGameTimer.schedule(endGameTask, delay);
  }
}