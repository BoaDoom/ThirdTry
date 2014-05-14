package cardGameV3.Cards;
import cardGameV3.Players;
import cardGameV3.SingleCards;

public class Prince extends SingleCards{
	

	public Prince()
	{
		super();
		valueOfCard = 5;
		nameOfCard = "Prince";
	}
	
	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer) //note: you need to restructure Player class to get sent the whole deck to deal itself a card
	{
		System.out.println("You've forced Player " + AttackingPlayer.playerName + " to discard his card!\nPress enter when ready and pass to him so he can draw a new card");
		clearingTheScreen();
		System.out.println("The prince has forced you to lose your card, press enter to recieve a new card if you are indeed Player "+ DefendingPlayer.playerName);
		nonkeyboard.nextLine();
		
	}

}
