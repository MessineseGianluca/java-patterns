package switch_logic;

public class ConcreteSwitch extends Switch {
  public ConcreteSwitch(SwitchClient switchUser) {
    super(switchUser);
  }

  public void detectOn() {
    this.state = true;
    switchUser.turnOn();
  }

  public void detectOff() {
    state = false;
    switchUser.turnOff();
  }
}