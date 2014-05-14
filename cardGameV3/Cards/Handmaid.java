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
	}
	public int checkForAttack(List<Players> AllPlayers, int turnCount)
	{
		System.out.println("This card can only be used on yourself, you will become immune to attack until your next turn");
		return turnCount;
	}
	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer)
	{
		AttackingPlayer.setBlockedOn();
		return 0;
	}

}