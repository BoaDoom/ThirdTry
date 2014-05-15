package cardGameV3.Cards;
import java.util.List;


import cardGameV3.Players;
import cardGameV3.SingleCards;

public class Handmaid extends SingleCards{
	

	public Handmaid()
	{
		super();
		valueOfCard = 4;
		nameOfCard = "Handmaid";
		descriptionOfCard = "This card is played on yourself, it makes you immune to attack until your next turn";
	}
	public int checkForAttack(List<Players> AllPlayers, int turnCount)
	{
		System.out.println("This card is used on yourself, you are immune to attack until your next turn");
		AllPlayers.get(turnCount).setBlockedOn();
		return 0;
	}
/*	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer, DeckOfCards Deck)
	{
		AttackingPlayer.setBlockedOn();
		return 0;
	}
*/
}