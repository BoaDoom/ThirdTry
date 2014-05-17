package cardGameV3.Cards;



import cardGameV3.DeckOfCards;
import cardGameV3.Players;
import cardGameV3.SingleCards;
import cardGameV3.TableTop;


public class Priest extends SingleCards{
	
	public Priest()
	{
		super();
		valueOfCard = 2;
		nameOfCard = "Priest";
		descriptionOfCard = "This card is played on another player, it forces them to show you their current card";
	}
	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer, DeckOfCards Deck, TableTop Table)
	{
		System.out.println("Player " + DefendingPlayer.playerName + " card is " + nameThisCard(DefendingPlayer.cardA.valueOfCard) + ", a " + DefendingPlayer.cardA.valueOfCard + "\nyou need to tell this player you know!");
		return 0;
	}
}