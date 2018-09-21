package switch;

public abstract class Switch {
  
  private SwitchClient switchUser;
  private boolean state;
  
  public Switch(SwitchClient switchUser) { 
    this.switchUser = switchUser;
    state = false;
  }
  
  public abstract detectOn();
  
  public abstract detectOff();
}