package no.ntnu.idatg2003.oblig3.cardgame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckOfCardsTest {
  DeckOfCards deck;

  @BeforeEach
  void setUp() {
    deck = new DeckOfCards();
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void dealHand() {
    assertEquals(5,deck.dealHand(5).size());
  }

  @Test
  void hasFlushPositive() {
    ArrayList<PlayingCard> card = new ArrayList<>();
    card.add(new PlayingCard('H', 1));
    card.add(new PlayingCard('H', 2));
    card.add(new PlayingCard('H', 3));
    card.add(new PlayingCard('H', 4));
    card.add(new PlayingCard('H', 5));
    assertTrue(deck.hasFlush(card));
  }
  @Test
  void hasFlushNegative() {
    ArrayList<PlayingCard> card = new ArrayList<>();
    card.add(new PlayingCard('H', 1));
    card.add(new PlayingCard('C', 2));
    card.add(new PlayingCard('D', 3));
    card.add(new PlayingCard('H', 4));
    card.add(new PlayingCard('S', 5));
    assertFalse(deck.hasFlush(card));
  }

  @Test
  void hasQueenOfSpadesPositive() {
    ArrayList<PlayingCard> card = new ArrayList<>();
    card.add(new PlayingCard('S', 12));
    card.add(new PlayingCard('C', 2));
    card.add(new PlayingCard('D', 3));
    card.add(new PlayingCard('H', 4));
    card.add(new PlayingCard('S', 5));
    assertTrue(deck.hasQueenOfSpades(card));
  }
  @Test
  void hasQueenOfSpadesNegative() {
    ArrayList<PlayingCard> card = new ArrayList<>();
    card.add(new PlayingCard('S', 11));
    card.add(new PlayingCard('C', 12));
    card.add(new PlayingCard('D', 1));
    card.add(new PlayingCard('H', 4));
    card.add(new PlayingCard('S', 13));
    assertFalse(deck.hasQueenOfSpades(card));
  }

  @Test
  void sumOfHand() {
    ArrayList<PlayingCard> card = new ArrayList<>();
    card.add(new PlayingCard('S', 12));
    card.add(new PlayingCard('C', 2));
    card.add(new PlayingCard('D', 3));
    card.add(new PlayingCard('H', 4));
    card.add(new PlayingCard('S', 5));
    assertEquals(26,deck.sumOfHand(card));
  }

  @Test
  void heartsInHandPositive() {
    ArrayList<PlayingCard> card = new ArrayList<>();
    card.add(new PlayingCard('S', 12));
    card.add(new PlayingCard('C', 2));
    card.add(new PlayingCard('D', 3));
    card.add(new PlayingCard('H', 4));
    card.add(new PlayingCard('S', 5));
    assertEquals("H4", deck.heartsInHand(card));
  }
  @Test
  void heartsInHandNegative() {
    ArrayList<PlayingCard> card = new ArrayList<>();
    card.add(new PlayingCard('S', 12));
    card.add(new PlayingCard('C', 2));
    card.add(new PlayingCard('D', 3));
    card.add(new PlayingCard('S', 4));
    card.add(new PlayingCard('S', 5));
    assertEquals("No hearts in hand", deck.heartsInHand(card));
  }
}