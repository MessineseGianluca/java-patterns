package receiver;

import remote_request.RequestSender;

public class TimeRequest {

  public String getCountryFormattedTime(String continent, String capital) {
    String[] fields = { "formatted" };
    String res = formatURLAndSendRequest(continent, capital, fields);
    System.out.println(res);
    return res;
  }

  public String getCountryTimeZoneAbbreviation(String continent, String capital) {
    String[] fields = { "abbreviation" };
    String res = formatURLAndSendRequest(continent, capital, fields);
    System.out.println(res);
    return res;
  }

  private String formatURLAndSendRequest(String continent, String capital, String[] fields) {
    String url = URLFormatter.formatTimeURLQuery(continent, capital, fields);
    String res = "";
    try {
      res = RequestSender.sendGet(url);
    } catch (Exception e) {
      System.out.println(e);
    }
    return res;
  }
}