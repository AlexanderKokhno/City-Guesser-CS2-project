package city.guesser.app;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.vaadin.flow.component.html.H1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/// this is the controller, for the routes

// @Route("")
// @RestController
@Controller
public class MainView {
  public int randomInt() {
    int min = 0;
    int max = 99999;
    int range = max - min + 1;
    return (int) (Math.random() * range) + min;
  }

  @RequestMapping(value = "/main")
  public String index(Model model) {

    String getResults = GeoCityFetcher.fetchCitiesAPI(randomInt());

    String QCityInfo[] = GeoCityParser.parseGeoCityGetRequest(getResults); // go check the relevant file to refrence
                                                                           // data
                                                                           // types
    System.out.println(getResults);

    String map_url = "/map?lat=" + QCityInfo[0] + "&long=" + QCityInfo[1];

    model.addAttribute("lat", QCityInfo[0]);
    model.addAttribute("long", QCityInfo[1]);
    model.addAttribute("name", QCityInfo[2]);
    model.addAttribute("country", QCityInfo[3]);
    model.addAttribute("region", QCityInfo[4]);
    model.addAttribute("regionID", QCityInfo[5]);
    model.addAttribute("map_url", map_url);

    System.out.println("--------------------------------");
    System.out.println(map_url);

    return "index";

  }

  @RequestMapping("/map") // looks for this url and responds to it
  @ResponseBody
  public String map(@RequestParam(value = "lat") String latitude, @RequestParam(value = "long") String longitude) {

    return LatLongFetcher.fetchCitiesAPI(latitude, longitude);

  }

  @GetMapping("/test") // WE CAN SEND STUFF BACK TO BACKEND USING THIS BY PASSING THE VARIABLE THROUGH
                       // URL

  // EXAMPLE: http://localhost:8080/test?testVAR=testingIfThisWorks
  public String testingRequester(@RequestParam("testVAR") String testVAR, Model model) {

    model.addAttribute("testVAR", testVAR);

    return "tester.html";
  }

  // @RequestMapping(value = "/index")
  // public String index(Model model) {
  // String test = "Do you see this? If yes, thats good";
  // int test2 = 1;
  // model.addAttribute("message", test);
  // model.addAttribute("testNum", test2);
  // return "index";

  // }

  @RequestMapping(value = "/test2")
  public String tester2() {

    return "tester2";

  }

  @RequestMapping(value = "/test3")
  public String tester3(@ModelAttribute Tester_3 tester_3) {
    System.out.println(tester_3.toString());
    return "tester2";
  }

}
