package classes;

import java.util.*;

public class Deck {

    public static int numSuits = 4;
    public static int numRanks = 13;
    public static int numCards = numSuits * numRanks;

    private PlayingCard[][] PlayingCards;

    public Deck() {
        PlayingCards = new PlayingCard[numSuits][numRanks];
        for (int suit = PlayingCard.DIAMONDS; suit <= PlayingCard.SPADES; suit++) {
            for (int rank = PlayingCard.ACE; rank <= PlayingCard.KING; rank++) {
                PlayingCards[suit-1][rank-1] = new PlayingCard(rank, suit);
            }
        }
    }

    public PlayingCard getPlayingCard(int suit, int rank) {
        return PlayingCards[suit-1][rank-1];
    }
}
