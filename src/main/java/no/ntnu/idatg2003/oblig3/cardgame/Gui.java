package no.ntnu.idatg2003.oblig3.cardgame;

import java.util.Collection;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Gui extends Application {

  private DeckOfCards deck;
  private Collection<PlayingCard> hand;
  private boolean hasQueenOfSpades = false;
  private int sumOfHand = 0;
  private String heartsInHand = "No hearts in hand";
  private boolean hasFlush = false;
  @Override
  public void start(Stage stage) throws Exception {
    deck = new DeckOfCards();
    // Create buttons
    Button dealHandButton = new Button("Deal Hand");
    Button checkHandButton = new Button("Check Hand");

    // Create pane and set values
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(10);
    pane.setVgap(10);
    // add buttons to pane
    pane.add(dealHandButton, 1, 2);
    pane.add(checkHandButton, 1, 3);
    // add text to pane
    Text handOfCards = new Text("Hand of cards: " + "Empty");
    handOfCards.setFont(new javafx.scene.text.Font(14));
    pane.add(handOfCards, 0, 0);
    Text queenOfSpadesText = new Text("Has Queen of Spades: " + hasQueenOfSpades);
    pane.add(queenOfSpadesText, 0, 1);
    Text sumOfHandText = new Text("Sum of hand: " + sumOfHand);
    pane.add(sumOfHandText, 0, 2);
    Text heartsInHandText = new Text("Hearts in hand: " + heartsInHand);
    pane.add(heartsInHandText, 0, 3);
    Text flushText = new Text("Has flush: " + hasFlush);
    pane.add(flushText, 0, 4);
    // Create scene
    Scene scene = new Scene(pane, 350, 300);
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
    // Add actions to buttons
    dealHandButton.setOnAction(e -> {
      hand = deck.dealHand(5);
      handOfCards.setText("Hand of cards: " + deck.handToString(hand));});
    checkHandButton.setOnAction(e -> {
      if (hand == null) {
        throw new IllegalStateException("Hand has not been dealt");
      } else {
        queenOfSpadesText.setText("Has Queen of Spades: " + deck.hasQueenOfSpades(hand));
        sumOfHandText.setText("Sum of hand: " + deck.sumOfHand(hand));
        heartsInHandText.setText("Hearts in hand: " + deck.heartsInHand(hand));
        flushText.setText("Has flush: " + deck.hasFlush(hand));
      }
    });
  }

  public static void main(String[] args) {
    launch(args);
  }
}
