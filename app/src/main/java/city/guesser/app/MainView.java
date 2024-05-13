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

  String getResults = GeoCityFetcher.fetchCitiesAPI();

  Object QCityInfo[] = GeoCityParser.parseGeoCityGetRequest(getResults); // go check the relevant file to refrence data
                                                                         // types

  @RequestMapping(value = "/main")
  public String index(Model model) {
    System.out.println(getResults);
    DispInfoMain DIM = new DispInfoMain();
    String[] cityInfoArrayS = DIM.dispInfoMain(QCityInfo);
    model.addAttribute("name", cityInfoArrayS[0]);
    model.addAttribute("country", cityInfoArrayS[1]);
    model.addAttribute("region", cityInfoArrayS[2]);
    model.addAttribute("regionID", cityInfoArrayS[3]);

    return "index";

  }

  @RequestMapping("/map") // looks for this url and responds to it
  @ResponseBody
  public String map() {
    Object ObjLat = QCityInfo[0];
    Double lat = (Double) ObjLat; // brute forced, double check data type beforehand, use instanceof if not sure
    Object ObjLong = QCityInfo[1];
    Double Long = (Double) ObjLong;
    return LatLongFetcher.fetchCitiesAPI(lat, Long);

  }

  @RequestMapping("/submission") // looks for this url and responds to it
  @ResponseBody
  public String main() {
    Object ObjLat = QCityInfo[0];
    Double lat = (Double) ObjLat; // brute forced, double check data type beforehand, use instanceof if not sure
    Object ObjLong = QCityInfo[1];
    Double Long = (Double) ObjLong;
    return LatLongFetcher.fetchCitiesAPI(lat, Long);

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
