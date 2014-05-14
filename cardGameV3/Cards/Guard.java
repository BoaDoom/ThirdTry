package cardGameV3.Cards;
import cardGameV3.Players;
import cardGameV3.SingleCards;


public class Guard extends SingleCards{
	

	public Guard()
	{
		super();
		valueOfCard = 1;
		nameOfCard = "Guard";
	}
	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer)
	{		
		System.out.println("Player " + AttackingPlayer.playerName + ", what card do you think Player " + DefendingPlayer.playerName + "\nhas in his hand? Here is a listing of the cards\nOnce you decide you must announce it before entering it");
		System.out.println("\n1.Guard INVALID You cannot choose a guard to attack a guard" + "\n2.Priest" + "\n3.Baron" + "\n4.Handmaid" + "\n5.Prince" + "\n6.King" + "\n7.Countess" + "\n8.Princess");
		choice =  keyboard.nextInt();
		while (choice < 2 || choice > 8)
		{
			System.out.println("That is an invalid choice, please try again");
			choice =  keyboard.nextInt();
		}
		if (choice == DefendingPlayer.cardA.valueOfCard)
		{
			DefendingPlayer.setPlayerStateOff();
			System.out.println("You guessed right! Player "+ DefendingPlayer.playerName + " is knocked out of the round");
			return 1;
		}
		
		System.out.println("You guessed wrong. Player "+ DefendingPlayer.playerName + " does not have a " + nameThisCard(choice)); 
		return 0;
		}
	
	{
		
	}

}
