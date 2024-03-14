package no.ntnu.idatg2003.oblig3.cardgame;

import static org.junit.jupiter.api.Assertions.*;

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
}