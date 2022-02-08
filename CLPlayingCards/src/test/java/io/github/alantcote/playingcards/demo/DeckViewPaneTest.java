package io.github.alantcote.playingcards.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import de.saxsys.mvvmfx.testingutils.jfxrunner.TestInJfxThread;
import io.github.alantcote.playingcards.Card;
import io.github.alantcote.playingcards.Deck;
import io.github.alantcote.playingcards.Rank;
import io.github.alantcote.playingcards.Suit;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;

/**
 * Test case for {@link io.github.alantcote.playingcards.demo.DeckViewPane}.
 */
@RunWith(JfxRunner.class)
public class DeckViewPaneTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#addKids()}.
	 */
	@Test
	@TestInJfxThread
	public void testAddKids() {
		SimpleIntegerProperty stateProperty = new SimpleIntegerProperty(0);
		DeckViewPane fixture = new DeckViewPane() {

			@Override
			protected ObservableList<Node> getKids() {
				assertTrue(1 == stateProperty.get());

				stateProperty.set(2);

				return super.getKids();
			}

			@Override
			protected Deck newDeck() {
				assertTrue(0 == stateProperty.get());

				stateProperty.set(1);

				return super.newDeck();
			}

		};

		stateProperty.set(0);

		fixture.addKids();

		assertTrue(2 == stateProperty.get());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#applyHgap(double)}.
	 */
	@Test
	@TestInJfxThread
	public void testApplyHgap() {
		DeckViewPane fixture = new DeckViewPane();

		fixture.applyHgap(DeckViewPane.DEFAULT_HGAP);

		assertTrue(DeckViewPane.DEFAULT_HGAP == fixture.getHgap());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#applyPadding(javafx.geometry.Insets)}.
	 */
	@Test
	@TestInJfxThread
	public void testApplyPadding() {
		Insets testInsets = new Insets(DeckViewPane.DEFAULT_INSET);
		DeckViewPane fixture = new DeckViewPane();

		fixture.applyPadding(testInsets);

		assertTrue(testInsets == fixture.getPadding());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#applyPrefColumns(int)}.
	 */
	@Test
	@TestInJfxThread
	public void testApplyPrefColumns() {
		DeckViewPane fixture = new DeckViewPane();

		fixture.applyPrefColumns(DeckViewPane.DEFAULT_COLUMNS);

		assertTrue(DeckViewPane.DEFAULT_COLUMNS == fixture.getPrefColumns());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#applyVgap(double)}.
	 */
	@Test
	@TestInJfxThread
	public void testApplyVgap() {
		DeckViewPane fixture = new DeckViewPane();

		fixture.applyVgap(DeckViewPane.DEFAULT_VGAP);

		assertTrue(DeckViewPane.DEFAULT_VGAP == fixture.getVgap());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#DeckViewPane()}.
	 */
	@Test
	@TestInJfxThread
	public void testDeckViewPane() {
		SimpleIntegerProperty stateProperty = new SimpleIntegerProperty(0);
		DeckViewPane fixture = new DeckViewPane() {

			@Override
			protected void addKids() {
				assertTrue(1 == stateProperty.get());

				stateProperty.set(2);
			}

			@Override
			protected void inizLayoutParams() {
				assertTrue(0 == stateProperty.get());

				stateProperty.set(1);
			}

		};

		assertNotNull(fixture);
		assertTrue(2 == stateProperty.get());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#getKids()}.
	 */
	@Test
	@TestInJfxThread
	public void testGetKids() {
		DeckViewPane fixture = new DeckViewPane();

		ObservableList<Node> kids = fixture.getKids();

		assertTrue(kids == fixture.getChildren());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#inizLayoutParams()}.
	 */
	@Test
	@TestInJfxThread
	public void testInizLayoutParams() {
		DeckViewPane fixture = new DeckViewPane();

		fixture.inizLayoutParams();

		assertTrue(DeckViewPane.DEFAULT_HGAP == fixture.getHgap());
		assertTrue(DeckViewPane.DEFAULT_COLUMNS == fixture.getPrefColumns());
		assertTrue(DeckViewPane.DEFAULT_VGAP == fixture.getVgap());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#newCard(io.github.alantcote.playingcards.Rank, io.github.alantcote.playingcards.Suit)}.
	 */
	@Test
	@TestInJfxThread
	public void testNewCard() {
		DeckViewPane fixture = new DeckViewPane();

		Card testCard = fixture.newCard(Rank.ACE, Suit.CLUB);

		assertTrue(Rank.ACE == testCard.getRank());
		assertTrue(Suit.CLUB == testCard.getSuit());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#newCardViewFactory()}.
	 */
	@Test
	@TestInJfxThread
	public void testNewCardViewFactory() {
		DeckViewPane fixture = new DeckViewPane();

		assertNotNull(fixture.newCardViewFactory());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#newDeck()}.
	 */
	@Test
	@TestInJfxThread
	public void testNewDeck() {
		DeckViewPane fixture = new DeckViewPane();

		assertNotNull(fixture.newDeck());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewPane#newInsets(double)}.
	 */
	@Test
	@TestInJfxThread
	public void testNewInsets() {
		DeckViewPane fixture = new DeckViewPane();

		assertNotNull(fixture.newInsets(DeckViewPane.DEFAULT_INSET));
	}

}
