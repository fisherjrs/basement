package classes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import enums.Ranks;
import enums.Suits;

public class Deck2 {
	public static Logger LOG = LoggerFactory.getLogger(Deck2.class);
	
	public static void main (String[] args) {
		LOG.debug(Ranks.values().toString());
		LOG.debug(Suits.values().toString());
		for( Suits suit : Suits.values()) {
			for (Ranks rank : Ranks.values()) {
				PlayingCards3 card3 = new PlayingCards3(rank, suit);
				StringBuilder sbuilder = new StringBuilder();
				sbuilder.append(card3.getRank());
				sbuilder.append(" of ");
				sbuilder.append(card3.getSuit());
				sbuilder.append(".");
				LOG.debug(sbuilder.toString());
			}
		}
	}
}
