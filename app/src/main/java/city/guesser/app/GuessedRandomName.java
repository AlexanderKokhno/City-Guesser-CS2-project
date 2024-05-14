package city.guesser.app;

import com.vaadin.flow.component.html.Main;

public class GuessedRandomName {
  public String guessName;

  public String getGuessName() {
    return guessName;
  }

  public void setGuessName(String guessName) {
    this.guessName = guessName;
  }

  @Override
  public String toString() {
    return guessName;
  }

}
