package cardGameV3;

import java.util.ArrayList;
import java.util.List;


public class TableTop {

	List<SingleCards> burnedCards = new ArrayList<SingleCards>(); //burned cards for a 2 player game
	List<List<SingleCards>> playerDiscard = new ArrayList<List<SingleCards>>();// an array of arrays, each players discard pile. Player 1's third discard would be playerDiscard.get(0).get(2)...probably
	SingleCards hiddenCard;
	
	public TableTop(int numOfPlayers, DeckOfCards Deck)
	{
		hiddenCard = Deck.dealCard(); //deals and stores hidden card
		if (numOfPlayers == 2)
		{
			burnedCards.add(Deck.dealCard()); //adds one onto each of the burn cards for a 2 player game. Burn cards are now AllCards.get(1-3)
			burnedCards.add(Deck.dealCard());
			burnedCards.add(Deck.dealCard());
		}
	}

}