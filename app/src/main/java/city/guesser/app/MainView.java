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

    return GeoCityFetcher.fetchCitiesAPI();

  }
}
