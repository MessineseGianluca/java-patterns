package standard_gaming_account;

import java.util.TimerTask;

class EndGameDLC extends TimerTask {
  GamingAccountDecorator game;

  EndGameDLC(GamingAccountDecorator game) {
    this.game = game;
  }

  public void run() {
    System.out.println("Game DLC trial time expired.");
    game.setIsPlaying(false);
  }
}