package standard_gaming_account;

import java.util.TimerTask;

import gaming_account_extension.GamingAccountDecorator;

import java.util.Timer;

class EndGameDLC extends TimerTask {
  Timer theTimer;
  GamingAccountDecorator game;

  EndGameDLC(Timer theTimer, GamingAccountDecorator game) {
    this.theTimer = theTimer;
    this.game = game;
  }

  public void run() {
    System.out.println("Game DLC trial time expired.");
    game.setIsPlaying(false);
    theTimer.cancel();
  }
}