import external_library.Engine;

public class EngineAdapter extends SwitchClient {
  private Engine adaptee;

  public EngineAdapter(Engine adaptee) {
    this.adaptee = adaptee;
  }

  public void turnOn() {
    adaptee.on();
  }

  public void turnOff() {
    adaptee.off();
  }
}