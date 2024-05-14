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

/////////// THIS IS NOT THE MAIN, GO TO AppApplication.java

// @Route("")
// @RestController
@Controller
public class MainView {
  public int randomInt() {
    int min = 0;
    int max = 499994;
    int range = max - min + 1;
    return (int) (Math.random() * range) + min;
  }

  public int playerScore = 0;

  public void setPlayerScore(int value) {
    this.playerScore = value;
  }

  public int getPlayerScore() {
    return playerScore;
  }

  public String correctAns;

  public void setCorrectAns(String value) {
    this.correctAns = value;
  }

  public String getCorrectAns() {
    return correctAns;
  }

  public Boolean checkAns(String a) {

    System.out.println("--------------------------------");
    System.out.println(getCorrectAns());
    if (a.equals(getCorrectAns())) {
      return true;
    } else {
      return false;
    }
  }

  @RequestMapping(value = "/main")
  public String index(@ModelAttribute GuessedRandomName guessedRandomName, Model model) {

    System.out.println(getCorrectAns());
    int playerScore = getPlayerScore();
    System.out.println("Testing" + guessedRandomName.toString());
    Boolean isCorrect = (checkAns(guessedRandomName.toString()));
    System.out.println(isCorrect);
    if (isCorrect == true) {
      setPlayerScore(playerScore + 1);
    } else {
      setPlayerScore(0);
    }

    System.out.println(getCorrectAns());

    String getResults = GeoCityFetcher.fetchCitiesAPI(randomInt());

    String[] QCityInfo = GeoCityParser.parseGeoCityGetRequest(getResults);
    DispInfoMain disp = new DispInfoMain();
    setCorrectAns(QCityInfo[2]);
    System.out.println(getCorrectAns());
    String[] randomCityNames = disp.randomNames(QCityInfo);
    System.out.println(getResults);
    System.out.println(getCorrectAns());
    String map_url = "/map?lat=" + QCityInfo[0] + "&long=" + QCityInfo[1];

    model.addAttribute("country", QCityInfo[3]);
    model.addAttribute("region", QCityInfo[4]);
    model.addAttribute("regionID", QCityInfo[5]);

    model.addAttribute("name1", randomCityNames[0]);
    model.addAttribute("name2", randomCityNames[1]);
    model.addAttribute("name3", randomCityNames[2]);
    model.addAttribute("name4", randomCityNames[3]);
    model.addAttribute("name5", randomCityNames[4]);
    model.addAttribute("map_url", map_url);
    model.addAttribute("player_score", playerScore);

    System.out.println("--------------------------------");
    System.out.println(map_url);

    return "index";

  }

  @RequestMapping("/map") // looks for this url and responds to it
  @ResponseBody
  public String map(@RequestParam(value = "lat") String latitude, @RequestParam(value = "long") String longitude) {

    return LatLongFetcher.fetchCitiesAPI(latitude, longitude);

  }

}
