package city.guesser.app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;

public class GeoCityFetcher {
  public static String fetchCitiesAPI() {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://wft-geo-db.p.rapidapi.com/v1/geo/adminDivisions"))
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
