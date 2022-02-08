package io.github.alantcote.playingcards.demo;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.scene.paint.Paint;

/**
 * Test case for {@link io.github.alantcote.playingcards.demo.DeckViewerScene}.
 */
public class DeckViewerSceneTest {

	/**
	 * Test method for {@link io.github.alantcote.playingcards.demo.DeckViewerScene#DeckViewerScene(javafx.scene.paint.Paint)}.
	 */
	@Test
	public void testDeckViewerScene() {
		assertNotNull(new DeckViewerScene(DeckViewer.BACKGROUND_COLOR));
	}

}
