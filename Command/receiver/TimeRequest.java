package receiver;

import remote_request.RequestSender;

public class TimeRequest {

  public static String getCountryFormattedTime(String continent, String capital) {
    String[] fields = { "formatted" };
    String res = formatURLAndSendRequest(continent, capital, fields);
    System.out.println(res);
    return res;
  }

  public static String getCountryTimeZoneAbbreviation(String continent, String capital) {
    String[] fields = { "abbreviation" };
    String res = formatURLAndSendRequest(continent, capital, fields);
    System.out.println(res);
    return res;
  }

  private static String formatURLAndSendRequest(String continent, String capital, String[] fields) {
    String url = URLFormatter.formatTimeURLQuery(continent, capital, fields);
    return sendRequest(url);
  }

  private static String sendRequest(String url) {
    String res = "";
    try {
      res = RequestSender.sendGet(url);
    } catch (Exception e) {
      System.out.println(e);
    }
    return res;
  }
}