package io.github.alantcote.playingcards.javafx;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.alantcote.playingcards.Card;
import io.github.alantcote.playingcards.Rank;
import io.github.alantcote.playingcards.Suit;
import javafx.scene.image.Image;

/**
 * Test case for {@link io.github.alantcote.playingcards.javafx.CardViewFactory}.
 */
public class CardViewFactoryTest {

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#CardViewFactory()}.
	 */
	@Test
	public void testCardViewFactory() {
		CardViewFactory fixture = new CardViewFactory();
		
		assertNotNull(fixture);
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#CardViewFactory(double)}.
	 */
	@Test
	public void testCardViewFactoryDouble() {
		CardViewFactory fixture = new CardViewFactory(CardViewFactory.DEFAULT_MAX_DIM);
		
		assertNotNull(fixture);
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#getBackView(io.github.alantcote.playingcards.Card)}.
	 */
	@Test
	public void testGetBackView() {
		CardViewFactory fixture = new CardViewFactory();
		Card testCard = new Card(Rank.ACE, Suit.CLUB);
		
		assertNotNull(fixture.getBackView(testCard));
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#getDimensions()}.
	 */
	@Test
	public void testGetDimensions() {
		CardViewFactory fixture = new CardViewFactory();
		
		assertNotNull(fixture.getDimensions());
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#getFrontView(io.github.alantcote.playingcards.Card)}.
	 */
	@Test
	public void testGetFrontView() {
		CardViewFactory fixture = new CardViewFactory();
		Card testCard = new Card(Rank.ACE, Suit.CLUB);
		
		assertNotNull(fixture.getFrontView(testCard));
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#getHeight(javafx.scene.image.Image)}.
	 */
	@Test
	public void testGetHeight() {
		CardViewFactory fixture = new CardViewFactory();
		Image testImage;
		String url;
		double width, height;
		
		url = fixture.getResource(CardViewFactory.RSRC_BACK_IMAGE);
		testImage = fixture.imageFactory.getImage(url);
		width = fixture.getWidth(testImage);
		height = fixture.getHeight(testImage);
		
		assertTrue(0 < height);
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#getResource(java.lang.String)}.
	 */
	@Test
	public void testGetResource() {
		CardViewFactory fixture = new CardViewFactory();
		
		assertNotNull(fixture.getResource(CardViewFactory.RSRC_BACK_IMAGE));
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#getWidth(javafx.scene.image.Image)}.
	 */
	@Test
	public void testGetWidth() {
		CardViewFactory fixture = new CardViewFactory();
		Image testImage;
		String url;
		double width, height;
		
		url = fixture.getResource(CardViewFactory.RSRC_BACK_IMAGE);
		testImage = fixture.imageFactory.getImage(url);
		width = fixture.getWidth(testImage);
		height = fixture.getHeight(testImage);
		
		assertTrue(0 < width);
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#imageURL(io.github.alantcote.playingcards.Card)}.
	 */
	@Test
	public void testImageURL() {
		CardViewFactory fixture = new CardViewFactory();
		Card testCard = new Card(Rank.ACE, Suit.CLUB);
		
		assertNotNull(fixture.imageURL(testCard));
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#newCardView(io.github.alantcote.playingcards.Card, javafx.scene.image.Image)}.
	 */
	@Test
	public void testNewCardView() {
		CardViewFactory fixture = new CardViewFactory();
		Card testCard = new Card(Rank.ACE, Suit.CLUB);
		Image testImage = fixture.imageFactory.getImage(fixture.imageURL(testCard));
		
		assertNotNull(fixture.newCardView(testCard, testImage));
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#newDimension2D(double, double)}.
	 */
	@Test
	public void testNewDimension2D() {
		CardViewFactory fixture = new CardViewFactory();
		
		assertNotNull(fixture.newDimension2D(CardViewFactory.DEFAULT_MAX_DIM, CardViewFactory.DEFAULT_MAX_DIM));
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#newImageFactory(double)}.
	 */
	@Test
	public void testNewImageFactory() {
		CardViewFactory fixture = new CardViewFactory();
		
		assertNotNull(fixture.newDimension2D(CardViewFactory.DEFAULT_MAX_DIM, CardViewFactory.DEFAULT_MAX_DIM));
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#rankString(io.github.alantcote.playingcards.Card)}.
	 */
	@Test
	public void testRankString() {
		CardViewFactory fixture = new CardViewFactory();
		Card testCard = new Card(Rank.ACE, Suit.CLUB);
		
		assertNotNull(fixture.rankString(testCard));
	}

	/**
	 * Test method for {@link io.github.alantcote.playingcards.javafx.CardViewFactory#suitString(io.github.alantcote.playingcards.Card)}.
	 */
	@Test
	public void testSuitString() {
		CardViewFactory fixture = new CardViewFactory();
		Card testCard = new Card(Rank.ACE, Suit.CLUB);
		
		assertNotNull(fixture.suitString(testCard));
	}

}
