package city.guesser.app;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaadin.flow.component.html.H1;

// @Route("")
@RestController
public class MainView {
  @RequestMapping("/main")

  public String main() {

    String getResults = GeoCityFetcher.fetchCitiesAPI();
    System.out.println(getResults);
    Double ZeroCoordinates[] = GeoCityParser.parseGeoCityGetRequest(getResults);
    return LatLongFetcher.fetchCitiesAPI(ZeroCoordinates[0], ZeroCoordinates[1]);

    /// this is just proof of concept we could use the longitude & latitude tool

  }
}
