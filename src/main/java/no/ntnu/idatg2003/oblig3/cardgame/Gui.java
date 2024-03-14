package no.ntnu.idatg2003.oblig3.cardgame;

import java.util.Collection;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Gui extends Application {

  private DeckOfCards deck;
  private Collection<PlayingCard> hand;
  @Override
  public void start(Stage stage) throws Exception {
    deck = new DeckOfCards();
    Button dealHandButton = new Button("Deal Hand");
    Button checkHandButton = new Button("Check Hand");

    dealHandButton.setOnAction(e -> hand = deck.dealHand(5));
    checkHandButton.setOnAction(e -> {
      if (hand == null) {
        System.out.println("No hand dealt yet");
      } else {
        for (PlayingCard card : hand) {
          System.out.println(card.getAsString());
        }
      }
    });

  }
}
