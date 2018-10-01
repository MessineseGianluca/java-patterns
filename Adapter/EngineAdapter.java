import external_library.Engine;
import switch_logic.SwitchClient;

public class EngineAdapter extends SwitchClient {
  private Engine adaptee;

  public EngineAdapter(String engineName) {
    this.adaptee = new Engine(engineName);
  }

  public void turnOn() {
    adaptee.on();
  }

  public void turnOff() {
    adaptee.off();
  }
}