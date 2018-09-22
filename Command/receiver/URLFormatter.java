package receiver;

class URLFormatter {
  static String formatTimeURLQuery(String continent, String capital, String[] fields) {
    String formattedZone = formatZone(continent, capital);
    String formattedFields = formatFields(fields);
    String key = MyTimeZoneDBKey.getKey();
    return "http://api.timezonedb.com/v2.1/get-time-zone?key=" + key + "&format=json&by=zone&zone=" + formattedZone
        + "&fields=" + formattedFields;
  }

  private static String formatZone(String continent, String capital) {
    return continent + "/" + capital;
  }

  private static String formatFields(String[] fields) {
    String formattedFields = "";
    for (String field : fields) {
      formattedFields += field + ",";
    }
    return formattedFields;
  }
}