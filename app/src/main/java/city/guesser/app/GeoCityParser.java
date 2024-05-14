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

    JSONObject secondResult = results.getJSONObject(1);
    String name2 = secondResult.getString("name");
    JSONObject thirdResult = results.getJSONObject(2);
    String name3 = thirdResult.getString("name");
    JSONObject fourthResult = results.getJSONObject(3);
    String name4 = fourthResult.getString("name");
    JSONObject fifthResult = results.getJSONObject(4);
    String name5 = fifthResult.getString("name");

    Object[] cityInfo = new Object[10];
    cityInfo[0] = latitude;
    cityInfo[1] = longitude;
    cityInfo[2] = name;
    cityInfo[3] = country;
    cityInfo[4] = region;
    cityInfo[5] = regionCode;
    cityInfo[6] = name2;
    cityInfo[7] = name3;
    cityInfo[8] = name4;
    cityInfo[9] = name5;

    DispInfoMain DIM = new DispInfoMain();
    String[] CI = DIM.dispInfoMain(cityInfo);

    return CI;

  }

}
