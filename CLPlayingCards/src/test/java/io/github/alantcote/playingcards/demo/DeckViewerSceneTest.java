package io.github.alantcote.playingcards.demo;

import static org.junit.Assert.*;
import javafx.scene.paint.Color;

import org.junit.Test;
import org.junit.runner.RunWith;

import io.github.alantcote.jfxrunner.JavaFxJUnit4ClassRunner;
import io.github.alantcote.playingcards.demo.DeckViewerScene;

@RunWith(JavaFxJUnit4ClassRunner.class)
public class DeckViewerSceneTest {
	@Test
	public void testDeckViewerScene() {
		DeckViewerScene fixture = new DeckViewerScene(Color.DARKGREEN);
		
		assertNotNull(fixture);
	}
}
