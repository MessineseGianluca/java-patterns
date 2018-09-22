package switch_logic;

public abstract class Switch {

  protected SwitchClient switchUser;
  protected boolean state;

  public Switch(SwitchClient switchUser) {
    this.switchUser = switchUser;
    state = false;
  }

  public abstract void detectOn();

  public abstract void detectOff();
}