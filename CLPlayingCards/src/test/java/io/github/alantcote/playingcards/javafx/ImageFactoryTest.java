package io.github.alantcote.playingcards.javafx;

import static org.junit.Assert.*;

import java.util.Hashtable;
import java.util.Map;

import org.junit.Test;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.image.Image;

public class ImageFactoryTest {
	@Test
	public void testFlush() {
		ImageFactory fixture = new ImageFactory();

		fixture.flush();

		assertTrue(fixture.cache.isEmpty());
	}

	@Test
	public void testGetImage() {
		SimpleIntegerProperty stateProperty = new SimpleIntegerProperty(0);
		ImageFactory fixture = new ImageFactory() {

			@Override
			protected Image loadImage(String url) {
				assertTrue(0 == stateProperty.get());
				stateProperty.set(1);

				return null;
			}

		};

		stateProperty.set(0);

		assertNull(fixture.getImage("url"));

		assertTrue(1 == stateProperty.get());
	}

	@Test
	public void testImageFactory() {
		double expectedMaxDim = ImageFactory.DEFAULT_MAX_DIM;
		final Map<String, Image> testCache = new Hashtable<String, Image>();
		ImageFactory fixture = new ImageFactory() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * io.github.alantcote.playingcards.javafx.ImageFactory#newMap_String_Image()
			 */
			@Override
			protected Map<String, Image> newMap_String_Image() {
				return testCache;
			}
		};

		assertTrue(testCache == fixture.cache);
		assertTrue(expectedMaxDim == fixture.maxDim);
	}

	@Test
	public void testImageFactoryDouble() {
		double expectedMaxDim = ImageFactory.DEFAULT_MAX_DIM;
		final Map<String, Image> testCache = new Hashtable<String, Image>();
		ImageFactory fixture = new ImageFactory(expectedMaxDim) {
			/*
			 * (non-Javadoc)
			 * 
			 * @see
			 * io.github.alantcote.playingcards.javafx.ImageFactory#newMap_String_Image()
			 */
			@Override
			protected Map<String, Image> newMap_String_Image() {
				return testCache;
			}
		};

		assertTrue(testCache == fixture.cache);
		assertTrue(expectedMaxDim == fixture.maxDim);
	}

	@Test
	public void testLoadImage() {
		SimpleIntegerProperty stateProperty = new SimpleIntegerProperty(0);
		String testURL = "testURL";
		ImageFactory fixture = new ImageFactory() {

			@Override
			protected Image newImage(String url, double requestedWidth, double requestedHeight, boolean preserveRatio,
					boolean smooth) {
				assertTrue(0 == stateProperty.get());

				assertEquals(testURL, url);
				assertTrue(ImageFactory.DEFAULT_MAX_DIM == requestedWidth);
				assertTrue(ImageFactory.DEFAULT_MAX_DIM == requestedHeight);
				assertTrue(preserveRatio);
				assertTrue(smooth);

				stateProperty.set(1);

				return null;
			}

		};

		stateProperty.set(0);

		assertNull(fixture.loadImage(testURL));

		assertTrue(1 == stateProperty.get());
	}

	@Test
	public void testNewImage() {
		/**
		 * This method is a wrapper around a constructor, and needs no testing.
		 */
	}

	@Test
	public void testNewMap_String_Image() {
		/**
		 * This method is a wrapper around a constructor, and needs no testing.
		 */
	}
}
