package cardGameV3.Cards;
import java.util.List;

import cardGameV3.DeckOfCards;
import cardGameV3.Players;
import cardGameV3.SingleCards;


public class Princess extends SingleCards{
	
	public Princess()
	{
		super();
		nameOfCard = "Princess";
		valueOfCard = 8;
	}
	public int checkForAttack(List<Players> AllPlayers, int turnCount) //importing all players to check availability for attack with card ability
	{
		System.out.println("The Princess has no attack, if you discard her you automatically lose this round");
		return 1;
	}
	
	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer, DeckOfCards Deck)
	{		
		System.out.println("You are knocked out of the round for discarding the Princess");
		AttackingPlayer.setPlayerStateOff();
		return 1;
	}
}
