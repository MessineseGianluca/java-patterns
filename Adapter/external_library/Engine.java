public class Engine {
    private boolean state;
    private String name;
    
    public Engine(String name) {
      this.name = name;
      off();
    }
    
    public void on() {
      state = true;
    }
    
    public void off() {
      state = false;
    }
    
    public boolean getState() {
      return state;
    }
  }