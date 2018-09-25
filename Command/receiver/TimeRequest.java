package receiver;

import remote_request.RequestSender;

public class TimeRequest {

  public static void getCountryFormattedTime(String continent, String capital) {
    String[] fields = { "formatted" };
    String res = formatURLAndSendRequest(continent, capital, fields);
    String[] values = getFieldsValues(res, fields);
    String stringToPrint = "Time for " + capital + ": " + values[0];
    System.out.println(stringToPrint);
  }

  public static void getCountryTimeZoneAbbreviation(String continent, String capital) {
    String[] fields = { "abbreviation" };
    String res = formatURLAndSendRequest(continent, capital, fields);
    String[] values = getFieldsValues(res, fields);
    String stringToPrint = "Time zone abbreviation for " + capital + ": " + values[0];
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

  private static String[] getFieldsValues(String wholeString, String fields[]) {
    String[] values = new String[fields.length];
    
    int fieldIndex = 0;
    for(String field:fields) {
      int fieldPosition = wholeString.indexOf(field);
      // it considers ":" after field name
      int valuePosition = fieldPosition + field.length() + 3;
      int i = valuePosition;
      String value = "";
      while (wholeString.charAt(i) != '\"') {
        value += wholeString.charAt(i);
        i++;
      }
      values[fieldIndex] = value;
      fieldIndex++;
    }
    return values;
  }
}