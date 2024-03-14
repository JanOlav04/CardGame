package no.ntnu.idatg2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class DeckOfCards {
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private final int numberOfCards = 52;
  private ArrayList<PlayingCard> deckOfCards;

  /**
   * Creates a new deck of cards. A deck of cards contains 52 cards, with 13 cards of each
   * suit (Spade, Heart, Diamonds and Clubs), and with face values from 1 to 13.
   */
  public DeckOfCards() {
    deckOfCards = new ArrayList<>(numberOfCards);
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        deckOfCards.add(new PlayingCard(suit, face));
      }
    }

  }

  /**
   * Returns a random selection of n cards from the deck of cards.
   * @param n the number of cards to deal
   * @return a collection of n random cards
   */
  public Collection<PlayingCard> dealHand(int n) {
    if (n < 0 || n > numberOfCards) {
      throw new IllegalArgumentException("Parameter n must be a number between 0 and 52");
    }
    Random random = new Random();
    ArrayList<PlayingCard> hand = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      int cardIndex = random.nextInt(numberOfCards);
      hand.add(deckOfCards.get(cardIndex));
      deckOfCards.remove(cardIndex);
    }
    return hand;
  }

}
