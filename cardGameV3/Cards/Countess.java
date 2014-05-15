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
		descriptionOfCard = "This card has no playable ability if used, she will simply be discarded.\n                    If at any point in the game she is in your hand with either the King or the Prince, she will\n                    be forced out of your hand without choice, leaving you with the Prince or King and ending your turn";
	}
	public int checkForAttack(List<Players> AllPlayers, int turnCount) //importing all players to check availability for attack with card ability
	{
		System.out.println("The countess has no ability, you discard her without penalty");
		return 0;
	}

}