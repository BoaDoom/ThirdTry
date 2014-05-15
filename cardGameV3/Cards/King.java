package cardGameV3.Cards;
import cardGameV3.DeckOfCards;
import cardGameV3.Players;
import cardGameV3.SingleCards;


public class King extends SingleCards{
	

	public King()
	{
		super();
		valueOfCard = 6;
		nameOfCard = "King";
		descriptionOfCard = "This card is played on another player, it forces them to swap their current hand with yours";
	}
	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer, DeckOfCards Deck)
	{
		System.out.println("You've forced Player " + DefendingPlayer.playerName + " to swap his card with yours!\nYou've lost your " + nameThisCard(AttackingPlayer.cardA.valueOfCard)+ ", the " + AttackingPlayer.cardA.valueOfCard + 
				 " to him and gained his " + nameThisCard(DefendingPlayer.cardA.valueOfCard)+ ", the " + DefendingPlayer.cardA.valueOfCard + "\npass to him so he can draw your card");
		clearingTheScreen();
		System.out.println("\npress enter if you are indeed Player "+ DefendingPlayer.playerName);
		nonkeyboard.nextLine();
		System.out.println("You've been forced by Player " + AttackingPlayer.playerName + " to swap his card with yours!\nYou've lost your " + nameThisCard(DefendingPlayer.cardA.valueOfCard)+ ", the " + DefendingPlayer.cardA.valueOfCard + 
				 " to him and gained his " + nameThisCard(AttackingPlayer.cardA.valueOfCard)+ ", the " + AttackingPlayer.cardA.valueOfCard);
		tempCardHolder = AttackingPlayer.cardA;
		AttackingPlayer.cardA = DefendingPlayer.cardA;
		DefendingPlayer.cardA = tempCardHolder;
		System.out.println("It is now the player after Player " + AttackingPlayer.playerName + "'s turn, please pass to them");
		clearingTheScreen();
		return 0;
	}

}