package cardGameV3.Cards;
import java.util.List;

import cardGameV3.Players;
import cardGameV3.SingleCards;


public class Countess extends SingleCards{
	

	public Countess()
	{
		super();
		valueOfCard = 7;
		nameOfCard = "Countess";		
	}
	public int checkForAttack(List<Players> AllPlayers, int turnCount) //importing all players to check availability for attack with card ability
	{
		System.out.println("The countess has no attack, you discard her at your discretion without penalty");
		return 0;
	}

}