package receiver;

import remote_request.RequestSender;

public class TimeRequest {

  public static void getCountryFormattedTime(String continent, String capital) {
    String[] fields = { "formatted" };
    String res = formatURLAndSendRequest(continent, capital, fields);
    String value = getFieldValue(res, fields[0]);
    String stringToPrint = "Time for " + capital + ": " + value;
    System.out.println(stringToPrint);
  }

  public static void getCountryTimeZoneAbbreviation(String continent, String capital) {
    String[] fields = { "abbreviation" };
    String res = formatURLAndSendRequest(continent, capital, fields);
    String value = getFieldValue(res, fields[0]);
    String stringToPrint = "Time zone abbreviation for " + capital + ": " + value;
    System.out.println(stringToPrint);
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

  private static String getFieldValue(String wholeString, String field) {
    String value = "";
    int fieldPosition = wholeString.indexOf(field);

    // it considers ":" after field name
    int valuePosition = fieldPosition + field.length() + 3;

    int i = valuePosition;

    while (wholeString.charAt(i) != '\"') {
      value += wholeString.charAt(i);
      i++;
    }

    return value;
  }
}