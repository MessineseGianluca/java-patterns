import receiver.TimeRequest;

public class CommandHandler {
  public static void main(String[] args) {
    String continent = "Europe";
    String capital = "Rome";
    String time = TimeRequest.getCountryFormattedTime(continent, capital);
    System.out.println(time);
    String timeZoneAbbr = TimeRequest.getCountryTimeZoneAbbreviation(continent, capital);
    System.out.println(timeZoneAbbr);
  }
}