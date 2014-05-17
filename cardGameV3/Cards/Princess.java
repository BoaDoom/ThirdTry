package cardGameV3.Cards;
import java.util.List;

import cardGameV3.DeckOfCards;
import cardGameV3.Players;
import cardGameV3.SingleCards;
import cardGameV3.TableTop;


public class Princess extends SingleCards{
	
	public Princess()
	{
		super();
		nameOfCard = "Princess";
		valueOfCard = 8;
		descriptionOfCard = "This card has no playable ability. If at any point you are forced to discard her, you are immediately out of the round";
	}
	public int checkForAttack(List<Players> AllPlayers, int turnCount, TableTop Table) //importing all players to check availability for attack with card ability
	{
		System.out.println("The Princess has no attack, if you discard her and are out this round");
		return 1;
	}
	
	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer, DeckOfCards Deck)
	{		
		System.out.println("You are knocked out of the round for discarding the Princess");
		AttackingPlayer.setPlayerStateOff();
		return 1;
	}
}
