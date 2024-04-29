package city.guesser.app;

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Arrays;

public class GeoCityParser {

  public static Double[] parseGeoCityGetRequest(String jsonResponse) {
    JSONObject jsonObject = new JSONObject(jsonResponse);
    JSONArray results = jsonObject.getJSONArray("data");
    JSONObject firstResult = results.getJSONObject(0);
    Double latitude = firstResult.getDouble("latitude");
    Double longitude = firstResult.getDouble("longitude");
    Double[] coordinates = { latitude, longitude };

    return coordinates;

  }

}
