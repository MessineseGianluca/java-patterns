import switch_logic.*;

public class AdapterHandler {
  public static void main(String[] args) {

    SwitchClient engineAdapter = new EngineAdapter("Ferrari Engine");
    Switch engineSwitch = new ConcreteSwitch(engineAdapter);

    engineSwitch.detectOn();
    engineSwitch.detectOff();
  }
}