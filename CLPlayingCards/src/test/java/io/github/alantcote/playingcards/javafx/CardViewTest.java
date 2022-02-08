package io.github.alantcote.playingcards.javafx;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.alantcote.playingcards.Card;
import io.github.alantcote.playingcards.Rank;
import io.github.alantcote.playingcards.Suit;

public class CardViewTest {
	
	@Test
	public void testCardView() {
		Card testCard = new Card(Rank.ACE, Suit.CLUB);
		CardView fixture = new CardView(testCard, null);
		
		assertEquals(testCard, fixture.card);
		assertTrue(null == fixture.getImage());
	}

	@Test
	public void testGetCard() {
		Card testCard = new Card(Rank.ACE, Suit.CLUB);
		CardView fixture = new CardView(testCard, null);
		
		fixture.card = testCard;
		
		assertEquals(testCard, fixture.getCard());
	}
}
