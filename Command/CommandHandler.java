import command.*;

public class CommandHandler {
  public static void main(String[] args) {
    String continent = "Europe";
    String capital = "Rome";
    TimeCommandInvoker invoker = new TimeCommandInvoker();

    TimeCommand timeCommand = new GetTimeCommand(continent, capital);
    invoker.executeCommand(timeCommand);

    TimeCommand timeZAbbrCommand = new GetTimeZoneAbbreviationCommand(continent, capital);
    invoker.executeCommand(timeZAbbrCommand);

    invoker.printCommandLog();
  }
}