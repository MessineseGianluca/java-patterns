package external_library;

public class Engine {
  private boolean state;
  private String name;

  public Engine(String name) {
    this.name = name;
    this.state = false;
  }

  public void on() {
    state = true;
    System.out.println(name + " turned on.");
  }

  public void off() {
    state = false;
    System.out.println(name + " turned off.");
  }

  public boolean getState() {
    return state;
  }

  public String getName() {
    return name;
  }
}
