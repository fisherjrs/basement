package classes;

import enums.Ranks;
import enums.Suits;

public class PlayingCards3 {

	private Ranks rank;
	private Suits suit;
	
	public PlayingCards3() {
		
	}
	
	public PlayingCards3(Ranks rank, Suits suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Ranks getRank() {
		return rank;
	}

	public void setRank(Ranks rank) {
		this.rank = rank;
	}

	public Suits getSuit() {
		return suit;
	}

	public void setSuit(Suits suit) {
		this.suit = suit;
	}
	
	
}
