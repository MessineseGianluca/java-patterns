package receiver;

public class TimeRequest {

  public String getCountryFormattedTime(String continent, String capital) {
    String url = URLFormatter(continent, capital, "formatted");
    String res = RequestSender.sendGet(url);
    System.out.println(res);
  }

  public String getCountryTimeZoneAbbreviation(String continent, String capital) {
    String url = URLFormatter(continent, capital, "abbreviation");
    String res = RequestSender.sendGet(url);
    System.out.println(res);
  }
}