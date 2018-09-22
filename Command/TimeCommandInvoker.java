import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import command.TimeCommand;

public class TimeCommandInvoker {
  // log of called commands
  private List<String> commandsLog;

  public TimeCommandInvoker() {
    commandsLog = new LinkedList<String>();
  }

  public void executeCommand(TimeCommand cmd) {
    Class commandClass = cmd.getClass();
    String commandName = commandClass.getSimpleName();
    commandsLog.add(commandName);
    cmd.execute();
  }

  public void printCommandLog() {
    Iterator<String> e = commandsLog.iterator();
    while (e.hasNext()) {
      System.out.println(e.next());
    }
  }
}