package premium_gaming_account;

import gaming_account.GamingAccountInterface;

public class PremiumGamingAccount extends GamingAccountDecorator {  
  
  public PremiumGamingAccount(GamingAccountInterface baseGamingAccount) {
    this.baseGamingAccount = baseGamingAccount;
  }
  
  public void playGameDLC() {
    if(isBanned()) {
      System.out.println(username + " can't play because it's banned!");
    } else if(!isPlaying()) {
      System.out.println(username + " is playing game DLC.");
      setIsPlaying(true);
    } else {
      System.out.println(username + " can't play DLC because it's already playing.");
    }   
  }
}