package classes;

public class Deck {
	
	public static int numSuits = 4;
	public static int numRanks = 13;
	public static int numCards = numSuits * numRanks;
	
	private PlayingCard[][] cards;
	
	public Deck() {
		cards = new PlayingCard[numSuits][numRanks];
		for (int suit = PlayingCard.DIAMONDS; suit <= PlayingCard.SPADES; suit++) {
			for (int rank = PlayingCard.ACE; rank <= PlayingCard.KING; rank++) {
				cards[suit-1][rank-1] = new PlayingCard(suit, rank);
			}
		}
	}
	
	public PlayingCard getCard(int suit, int rank) {
		return cards[suit][rank];
	}
	
	public static void main (String[] args) {
		Deck deck = new Deck();
		PlayingCard myCard = deck.getCard(3, 10);
		try {
			String cardValue = myCard.rankToString(myCard.getRank());
			String cardSuit = myCard.suitToString(myCard.getSuit());
			System.out.println(cardValue + ' ' + cardSuit);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}		
	}
}
