package io.github.alantcote.playingcards.javafx;

import io.github.alantcote.playingcards.Card;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * An <code>ImageView</code> used for painting playing card images.
 */
public class CardView extends ImageView {
	/**
	 * The card this object represents.
	 */
	protected Card card;
	
	/**
	 * Construct a new object from a card and an image.
	 * @param card the card - may be null for a card-back image.
	 * @param image the image.
	 */
	public CardView(Card card, Image image) {
		super(image);
		
		this.card = card;
	}

	/**
	 * Get the card.
	 * @return the card.
	 */
	public Card getCard() {
		return card;
	}
}
