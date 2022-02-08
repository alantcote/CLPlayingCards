package io.github.alantcote.playingcards.javafx;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

/**
 * A provider of <code>Image</code> objects. This object maintains a cache of
 * <code>Image</code> objects, for performance reasons.
 */
public class ImageFactory {
	public static final double DEFAULT_MAX_DIM = 100;

	protected Map<String, Image> cache;
	protected double maxDim;

	/**
	 * Construct a new object with default settings.
	 */
	public ImageFactory() {
		this(DEFAULT_MAX_DIM);
	}

	/**
	 * Construct a new object with a specified maximum dimension. While the new
	 * object will preserve aspect ratio, the images produced will be limited in
	 * height and width to the specified maximum dimension.
	 * 
	 * @param maxDim the maximum dimension.
	 */
	public ImageFactory(double maxDim) {
		super();

		this.maxDim = maxDim;

		cache = newMap_String_Image();
	}

	/**
	 * Flush the cache.
	 */
	public void flush() {
		cache.clear();
	}

	/**
	 * Get an image from the given URL.
	 * 
	 * @param url the image source.
	 * @return the image (<code>null</code> if the image cannot be retrieved).
	 */
	public Image getImage(String url) {
		Image image = cache.get(url);

		if (image == null) {
			image = loadImage(url);

			if (image != null) {
				cache.put(url, image);
			}
		}

		return image;
	}

	/**
	 * Load an image from a given URL.
	 * 
	 * @param url the URL.
	 * @return the new object.
	 */
	protected Image loadImage(String url) {
		Image image = newImage(url, maxDim, maxDim, true, true);

		return image;
	}

	/**
	 * Create a new <code>Image</code>.
	 * 
	 * @param url             the string representing the URL to use in fetching the
	 *                        pixel data.
	 * @param requestedWidth  the image's bounding box width.
	 * @param requestedHeight the image's bounding box height.
	 * @param preserveRatio   indicates whether to preserve the aspect ratio of the
	 *                        original image when scaling to fit the image within
	 *                        the specified bounding box.
	 * @param smooth          indicates whether to use a better quality filtering
	 *                        algorithm or a faster one when scaling this image to
	 *                        fit within the specified bounding box.
	 * @return the new object.
	 */
	protected Image newImage(String url, double requestedWidth, double requestedHeight, boolean preserveRatio,
			boolean smooth) {
		return new Image(url, requestedWidth, requestedHeight, preserveRatio, smooth, false);
	}

	/**
	 * Construct a new <code>Map&lt;String, Image&gt;</code>.
	 * 
	 * @return the new object.
	 */
	protected Map<String, Image> newMap_String_Image() {
		return new HashMap<>();
	}
}
