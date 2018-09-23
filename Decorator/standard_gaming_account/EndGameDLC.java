package standard_gaming_account;

import java.util.TimerTask;
import gaming_account_extension.*;

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