/**
 * 
 */
package io.github.alantcote.playingcards.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import de.saxsys.mvvmfx.testingutils.jfxrunner.TestInJfxThread;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Test case for {@link io.github.alantcote.playingcards.demo.DeckViewer}.
 */
@RunWith(JfxRunner.class)
public class DeckViewerTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewer#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() {
		// Pretty much the standard JavaFX main(). No need to test.
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewer#newScene()}.
	 */
	@Test
	public void testNewScene() {
		DeckViewer fixture = new DeckViewer();

		assertNotNull(fixture.newScene());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewer#setScene(javafx.stage.Stage, javafx.scene.Scene)}.
	 */
	@Test
	@TestInJfxThread
	public void testSetScene() {
		Stage testStage = new Stage();
		SimpleObjectProperty<Scene> sceneProperty = new SimpleObjectProperty<Scene>();
		DeckViewer fixture = new DeckViewer();

		fixture.setScene(testStage, sceneProperty.get());

		assertTrue(sceneProperty.get() == testStage.getScene());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewer#show(javafx.stage.Stage)}.
	 */
	@Test
	public void testShow() {
		// Testing the show() method would open a window. Not acceptable.
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.playingcards.demo.DeckViewer#start(javafx.stage.Stage)}.
	 */
	@Test
	@TestInJfxThread
	public void testStartStage() {
		SimpleIntegerProperty stateProperty = new SimpleIntegerProperty(0);
		Stage testStage = new Stage();
		SimpleObjectProperty<Scene> sceneProperty = new SimpleObjectProperty<Scene>();
		DeckViewer fixture = new DeckViewer() {

			@Override
			protected Scene newScene() {
				assertTrue(0 == stateProperty.get());

				sceneProperty.set(super.newScene());

				stateProperty.set(1);

				return sceneProperty.get();
			}

			@Override
			protected void setScene(Stage stage, Scene scene) {
				assertTrue(1 == stateProperty.get());

				assertTrue(testStage == stage);
				assertTrue(sceneProperty.get() == scene);

				stateProperty.set(2);
			}

			@Override
			protected void show(Stage stage) {
				assertTrue(2 == stateProperty.get());

				assertTrue(testStage == stage);

				stateProperty.set(3);
			}

		};

		stateProperty.set(0);

		fixture.start(testStage);

		assertTrue(3 == stateProperty.get());
	}

}
