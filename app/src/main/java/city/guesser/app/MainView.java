package city.guesser.app;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.vaadin.flow.component.html.H1;

/// this is the controller, for the routes

// @Route("")
// @RestController
@Controller
public class MainView {

  String getResults = GeoCityFetcher.fetchCitiesAPI();

  Object QCityInfo[] = GeoCityParser.parseGeoCityGetRequest(getResults); // go check the relevant file to refrence data
                                                                         // types

  @RequestMapping(value = "/main")
  public String index(Model model) {
    System.out.println(getResults);
    Object ObjName = QCityInfo[2];
    String cityName = (String) ObjName;
    Object ObjCountry = QCityInfo[3];
    String cityCountry = (String) ObjCountry;
    Object ObjRegion = QCityInfo[4];
    String cityRegion = (String) ObjRegion;
    Object ObjRegionId = QCityInfo[5];
    String cityRegionId = (String) ObjRegionId;

    model.addAttribute("name", cityName);
    model.addAttribute("country", cityCountry);
    model.addAttribute("region", cityRegion);
    model.addAttribute("regionID", cityRegionId);

    return "index";

  }

  @RequestMapping("/map") // looks for this url and responds to it
  @ResponseBody
  public String main() {
    Object ObjLat = QCityInfo[0];
    Double lat = (Double) ObjLat; // brute forced, double check data type beforehand, use instanceof if not sure
    Object ObjLong = QCityInfo[1];
    Double Long = (Double) ObjLong;
    return LatLongFetcher.fetchCitiesAPI(lat, Long);

  }

  // @RequestMapping(value = "/index")
  // public String index(Model model) {
  // String test = "Do you see this? If yes, thats good";
  // int test2 = 1;
  // model.addAttribute("message", test);
  // model.addAttribute("testNum", test2);
  // return "index";

  // }
}
