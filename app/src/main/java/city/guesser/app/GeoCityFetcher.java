package city.guesser.app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;

// https://rapidapi.com/wirefreethought/api/geodb-cities

public class GeoCityFetcher {
  public static String fetchCitiesAPI(int a) {
    String url = "https://wft-geo-db.p.rapidapi.com/v1/geo/cities";
    int offset = a;
    int limit = 2;
    String limitParem = "?limit=" + limit;
    String offSetParem = "&offset=" + offset;
    String sortParem = "&sort=population";
    HttpRequest request = HttpRequest.newBuilder()

        .uri(URI.create(url + limitParem + offSetParem + sortParem))
        .header("X-RapidAPI-Key", "9bd545da8emsh14144bd6cc0419dp1c49e7jsn84fef7b662fe")
        .header("X-RapidAPI-Host", "wft-geo-db.p.rapidapi.com")
        .method("GET", HttpRequest.BodyPublishers.noBody())
        .build();
    try {
      HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
      return response.body();
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      return null; // Simplified error handling|
    }
  }
}
