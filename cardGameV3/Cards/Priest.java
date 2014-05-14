package cardGameV3.Cards;
import java.io.*;

import cardGameV3.Players;
import cardGameV3.SingleCards;

public class Priest extends SingleCards{
	
	public Priest()
	{
		super();
		valueOfCard = 2;
		nameOfCard = "Priest";
	}
	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer) throws IOException
	{
		System.out.println("Player " + DefendingPlayer.playerName + " card is " + nameThisCard(DefendingPlayer.cardA.valueOfCard) + ", a " + DefendingPlayer.cardA.valueOfCard + "\nyou need to tell this player you know!");
		return 0;
	}
}