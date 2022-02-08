package io.github.alantcote.playingcards.decks;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import io.github.alantcote.playingcards.Card;
import io.github.alantcote.playingcards.Rank;
import io.github.alantcote.playingcards.Suit;
import javafx.beans.property.SimpleIntegerProperty;

public class StandardDeckTest {
	@Test
	public void testAddCards() {
		final SimpleIntegerProperty newCardCountProperty = new SimpleIntegerProperty(0);
		final Suit[] suits = Arrays.copyOf(Suit.values(), Suit.JOKER.ordinal());
		final Rank[] ranks = Arrays.copyOf(Rank.values(), Rank.JOKER_LOW.ordinal());
		final Card[] cards = new Card[2 + suits.length * ranks.length];
		
		for (int s = 0; s < suits.length; ++s) {
			for (int r = 0; r < ranks.length; ++r) {
				cards[r + s * ranks.length] = new Card(ranks[r], suits[s]);
			}
		}
		
		cards[52] = new Card(Rank.JOKER_LOW, Suit.JOKER);
		cards[53] = new Card(Rank.JOKER_HIGH, Suit.JOKER);

		final StandardDeck fixture = new StandardDeck() {

			@Override
			protected Card newCard(Rank rank, Suit suit) {
				int count = newCardCountProperty.get();
				
				assertEquals(cards[count].getRank(), rank);
				assertEquals(cards[count].getSuit(), suit);
				
				newCardCountProperty.set(count + 1);
				
				return super.newCard(rank, suit);
			}
			
		};
		
		assertNotNull(fixture);
	}

	@Test
	public void testStandardDeck() {
		final SimpleIntegerProperty addCardsCountProperty = new SimpleIntegerProperty(0);
		
		StandardDeck fixture = new StandardDeck() {
			/* (non-Javadoc)
			 * @see io.github.alantcote.playingcards.decks.BridgeDeck#addCards()
			 */
			@Override
			protected void addCards() {
				addCardsCountProperty.set(1 + addCardsCountProperty.get());
				super.addCards();
			}
		};
		
		assertNotNull(fixture);
		assertTrue(1 == addCardsCountProperty.get());
	}
}
