package classes;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PlayingCard {
	public static Logger LOG = LogManager.getLogger(PlayingCard.class);
	
	private final int rank;
	private final int suit;
	
	//suits
	public final static int DIAMONDS = 1;
	public final static int CLUBS = 2;
	public final static int HEARTS = 3;
	public final static int SPADES = 4;
	
	//rank
	public final static int ACE = 1;
	public final static int TWO = 2;
	public final static int THREE = 3;
	public final static int FOUR = 4;
	public final static int FIVE = 5;
	public final static int SIX = 6;
	public final static int SEVEN = 7;
	public final static int EIGHT = 8;
	public final static int NINE = 9;
	public final static int TEN = 10;
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;
	
	
	public static void main(String[] args){
		PlayingCard pcard = new PlayingCard(ACE, HEARTS);
		
		/*
		ArrayList<String> suitList = new ArrayList<>(Arrays.asList("Hearts", "Diamonds", "Clubs", "Spades"));
		ArrayList<String> rankList = new ArrayList<>(Arrays.asList("Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "Kind"));
		
		for(String suit : suitList) {
			for(String rank : rankList){
				LOG.debug(new PlayingCard(rank, suit).getCommonName());
			}
		}
		*/
	
	}
	
	//Can't have empty constructor because the final fields are not initialized.
	//This class cannot technically be a bean.
/*
	public PlayingCard() {
		
	}
*/	
	public PlayingCard(int myRank, int mySuit) {
		assert isValidRank(myRank);
		assert isValidSuit(mySuit);
		this.rank = myRank;
		this.suit = mySuit;
	}
	
	private boolean isValidRank(int myRank) {
		return ACE <= myRank && myRank <= KING;
	}
	
	private boolean isValidSuit(int mySuit) {
		return HEARTS <= mySuit && mySuit <= SPADES;
	}
	
	public String getCommonName(){
		StringBuilder commonName = new StringBuilder();
		commonName.append(this.rank);
		commonName.append(" of ");
		commonName.append(this.suit);	
		return commonName.toString();
	}
		
	public int getRank() {
		return this.rank;
	}
		
	public int getSuit() {
		return this.suit;
	}
	
	public String suitToString(int mySuit) throws Exception {
		switch(mySuit){
		case HEARTS :
			return "hearts";
		case CLUBS :
			return "clubs";
		case DIAMONDS :
			return "diamonds";
		case SPADES :
			return "spades";
		default :
			throw new Exception("Could not find a matching suit.");
		}
	}
	
	public String rankToString(int myRank) throws Exception {
		switch(myRank){
		case ACE :
			return "ace";
		case TWO :
			return "clubs";
		case THREE :
			return "diamonds";
		case FOUR :
			return "spades";
		case FIVE :
			return "five";
		case SIX :
			return "six";
		case SEVEN :
			return "seven";
		case EIGHT :
			return "eight";
		case NINE :
			return "nine";
		case TEN :
			return "ten";
		case JACK :
			return "jack";
		case QUEEN :
			return "queen";
		case KING :
			return "king";
		default :
			throw new Exception("Could not find a matching rank.");
		}
	}
}
