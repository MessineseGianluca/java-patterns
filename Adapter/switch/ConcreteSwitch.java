package switch;

public class ConcreteSwitch extends Switch {
  public void turnOn() {
    state = true;
    switchUser.turnOn();
  }
  
  public void turnOff() {
    state = false;
    switchUser.turnOff();
  }
}