package io.github.alantcote.playingcards.decks;

import io.github.alantcote.playingcards.Rank;
import io.github.alantcote.playingcards.Suit;

/**
 * A deck comprised of the 52 "normal" cards, plus 2 jokers.
 * This deck incorporates 13 ranks of each of 4 suits and 2 jokers.
 * @author cote
 */
public class StandardDeck extends BridgeDeck {
	/**
	 * Construct a new object.
	 */
	public StandardDeck() {
		super();
	}

	/* (non-Javadoc)
	 * @see io.github.alantcote.playingcards.decks.BridgeDeck#addCards()
	 */
	@Override
	protected void addCards() {
		super.addCards();
		
		add(newCard(Rank.JOKER_LOW, Suit.JOKER));
		add(newCard(Rank.JOKER_HIGH, Suit.JOKER));
	}
}
