package command;

import receiver.TimeRequest;

public class GetTimeCommand implements TimeCommand {

  private String continent;
  private String capital;

  public GetTimeCommand(String continent, String capital) {
    this.continent = continent;
    this.capital = capital;
  }

  public void execute() {
    TimeRequest.getCountryFormattedTime(continent, capital);
  }
}