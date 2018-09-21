import switch_logic.*;
import external_library.*;

public class AdapterHandler {
  public static void main(String[] args) {
    Engine realEngine = new Engine("Ferrari engine");
    SwitchClient engineAdapter = new EngineAdapter(realEngine);
    Switch engineSwitch = new ConcreteSwitch(engineAdapter);

    engineSwitch.turnOn();
    engineSwitch.turnOff();
  }
}