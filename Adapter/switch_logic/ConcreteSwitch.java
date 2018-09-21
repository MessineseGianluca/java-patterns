public class ConcreteSwitch extends Switch {
  public ConcreteSwitch(SwitchClient switchUser) {
    super(switchUser);
  }

  public void turnOn() {
    this.state = true;
    switchUser.turnOn();
  }

  public void turnOff() {
    state = false;
    switchUser.turnOff();
  }
}