/**
 * Support for building programs that use playing cards.
 */
module playingcards {
	exports io.github.alantcote.playingcards;
	exports io.github.alantcote.playingcards.decks;
	exports io.github.alantcote.playingcards.demo;
	exports io.github.alantcote.playingcards.javafx;
	
	requires javafx.swing;
	requires transitive javafx.graphics;
	requires javafx.base;
}