package no.ntnu.idatg2003.oblig3.cardgame;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Represents a deck of cards. A deck of cards contains 52 cards, with 13 cards of each suit.
 *
 * @author Jan Olav
 * @version 2024-03-14
 */

public class DeckOfCards {

  private final char[] suits = {'S', 'H', 'D', 'C'};
  private int numberOfCards;
  private ArrayList<PlayingCard> deckOfCards;

  /**
   * Creates a new deck of cards. A deck of cards contains 52 cards, with 13 cards of each suit
   * (Spade, Heart, Diamonds and Clubs), and with face values from 1 to 13.
   */
  public DeckOfCards() {
    numberOfCards = 52;
    deckOfCards = new ArrayList<>(numberOfCards);
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        deckOfCards.add(new PlayingCard(suit, face));
      }
    }

  }

  /**
   * Returns a random selection of n cards from the deck of cards.
   *
   * @param n the number of cards to deal
   * @return a collection of n random cards
   */
  public Collection<PlayingCard> dealHand(int n) {
    if (n < 0 || n > numberOfCards) {
      throw new IllegalArgumentException("Parameter n must be a number between 0 and " + numberOfCards);
    }

    Random random = new Random();
    ArrayList<PlayingCard> hand = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      int cardIndex = random.nextInt(numberOfCards);
      hand.add(deckOfCards.get(cardIndex));
      deckOfCards.remove(cardIndex);
      numberOfCards--;
    }
    return hand;
  }

  /**
   * Check if a hand that has been dealt contains the Queen of Spades.
   *
   * @param hand the hand of cards to check
   * @return true if the hand contains the Queen of Spades, false otherwise
   */
  public boolean hasQueenOfSpades(Collection<PlayingCard> hand) {
    return hand.stream()
        .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }
  /**
   * Returns the sum of a dealt hand of cards.
   *
   * @param hand the hand of cards to sum
   * @return the sum of the hand
   */
  public int sumOfHand(Collection<PlayingCard> hand) {
    return hand.stream()
        .map(PlayingCard::getFace)
        .reduce(0, Integer::sum);
  }

  /**
   * Returns a string representation of the hearts in a hand of cards.
   * @param hand the hand of cards to check
   * @return a string representation of the hearts in the hand
   */
  public String heartsInHand(Collection<PlayingCard> hand) {
    String hearts = hand.stream()
        .filter(card -> card.getSuit() == 'H')
        .map(PlayingCard::getAsString)
        .collect(Collectors.joining(" "));
    if (hearts.isEmpty()) {
      hearts = "No hearts in hand";
    }
    return hearts;
  }

  /**
   * Returns a boolean value indicating if a hand of cards contains a flush.
   * @param hand the hand of cards to check
   * @return true if the hand contains a flush, false otherwise
   */
  public boolean hasFlush(Collection<PlayingCard> hand) {
    return hand.stream()
        .collect(Collectors.groupingBy(PlayingCard::getSuit))
        .values().stream()
        .anyMatch(cards -> cards.size() >= 5);
  }

  /**
   * Returns a string representation of a hand of cards.
   */
  public String handToString(Collection<PlayingCard> hand) {
    return hand.stream()
        .map(PlayingCard::getAsString)
        .collect(Collectors.joining(" "));
  }

  /**
   * Returns the number of cards left in the deck.
   */
  public int getNumberOfCards() {
    return numberOfCards;
  }
}
