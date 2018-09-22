package command;

import receiver.TimeRequest;

public class GetTimeZoneAbbreviationCommand implements TimeCommand {
  private String continent;
  private String capital;

  public GetTimeZoneAbbreviationCommand(String continent, String capital) {
    this.continent = continent;
    this.capital = capital;
  }

  public void execute() {
    TimeRequest.getCountryTimeZoneAbbreviation(continent, capital);
  }
}