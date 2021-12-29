/**
 * @author alantcote
 */
module playingcards {
	exports net.sf.cotelab.playingcards;
	exports net.sf.cotelab.playingcards.decks;
	exports net.sf.cotelab.playingcards.demo;
	exports net.sf.cotelab.playingcards.javafx;
	
	requires transitive javafx.graphics;
}