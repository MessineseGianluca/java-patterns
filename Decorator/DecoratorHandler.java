import gaming_account.*;
import gaming_account_extension.*;
import premium_gaming_account.*;
import standard_gaming_account.*;

public class DecoratorHandler {
  public static void main(String[] args) {
    GamingAccountInterface baseGamer = new GamingAccount("Boris", false);
    baseGamer.playGame();

    GamingAccountInterface baseGamer2 = new GamingAccount("Kartoshka97", false);
    PremiumGamingAccount premiumGamer = new PremiumGamingAccount(baseGamer2);
    premiumGamer.playGameDLC();

    GamingAccountInterface baseGamer3 = new GamingAccount("Dimitri", false);
    StandardGamingAccount standardGamer = new StandardGamingAccount(baseGamer3);
    standardGamer.playGameDLCForAGivenTime(5000);

    standardGamer.playGame();
  }
}