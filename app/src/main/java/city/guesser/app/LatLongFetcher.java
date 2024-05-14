package city.guesser.app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;

public class LatLongFetcher {
  public static String fetchCitiesAPI(String latitude, String longitude) {
    String url = "https://www.latlong.net/c/?";
    url = url + "lat=" + latitude;
    url = url + "&long=" + longitude;
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(url))
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
