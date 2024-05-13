package city.guesser.app;

import org.json.JSONObject;
import org.json.JSONArray;
import java.util.Arrays;

public class GeoCityParser {

  public static String[] parseGeoCityGetRequest(String jsonResponse) {
    JSONObject jsonObject = new JSONObject(jsonResponse);
    JSONArray results = jsonObject.getJSONArray("data");
    JSONObject firstResult = results.getJSONObject(0);
    String name = firstResult.getString("name");
    String country = firstResult.getString("country");
    String region = firstResult.getString("region");
    String regionCode = firstResult.getString("regionCode");
    Double latitude = firstResult.getDouble("latitude");
    Double longitude = firstResult.getDouble("longitude");

    Object[] cityInfo = new Object[6];
    cityInfo[0] = latitude;
    cityInfo[1] = longitude;
    cityInfo[2] = name;
    cityInfo[3] = country;
    cityInfo[4] = region;
    cityInfo[5] = regionCode;

    DispInfoMain DIM = new DispInfoMain();
    String[] CI = DIM.dispInfoMain(cityInfo);

    return CI;

  }

}
