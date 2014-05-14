package cardGameV3.Cards;
import java.util.List;

import cardGameV3.Players;
import cardGameV3.DeckOfCards;
import cardGameV3.SingleCards;

public class Prince extends SingleCards{
	

	public Prince()
	{
		super();
		valueOfCard = 5;
		nameOfCard = "Prince";
	}
	
	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer, DeckOfCards Deck)
	{
		System.out.println("You've forced Player " + DefendingPlayer.playerName + " to discard his card!\nPress enter when ready and pass to him so he can draw a new card");
		clearingTheScreen();
		System.out.println("The prince has forced you to lose your card, press enter to recieve a new card if you are indeed Player "+ DefendingPlayer.playerName);
		nonkeyboard.nextLine();
		if (Deck.cardsDealt == DeckOfCards.cardCount - 1)
		{
			System.out.println("There are no more cards left! you've been knocked out of the round");
			DefendingPlayer.setPlayerStateOff();
			return 1;
		}
		else
		{
		DefendingPlayer.getStartingCard(Deck);
		System.out.println("You now have a " + nameThisCard(DefendingPlayer.cardA.valueOfCard) + ", a " + DefendingPlayer.cardA.valueOfCard);
		return 0;
		}
	}
	
	public int checkForAttack(List<Players> AllPlayers, int turnCount) //importing all players to check availability for attack with card ability
	{
		System.out.println("Please pick an availible player you would like to use your card on");
		for (int i = 0; i < AllPlayers.size(); i++)
		{
			if ((AllPlayers.get(i).playerName) == (AllPlayers.get(turnCount).playerName)) //if this is the player himself
			{
				System.out.println((i+1) + ": Player " + (i+1) + " YOU!");
				numberOfNonNullPlayers++;
				continue;
			}
			if ((AllPlayers.get(i).blocked == 1))
			{
				System.out.println((i+1) + ": Player " + (i+1) + " is protected"); //if player has a handmaid
				continue;
			}
			if ((AllPlayers.get(i).playerState == 0))
			{
				System.out.println((i+1) + ": Player " + (i+1) + " is out of the round"); //if player is out of the round
				continue;
			}
			else
			{
				System.out.println((i+1) + ": Player " + (i+1));
				numberOfNonNullPlayers++;
			}
				
		}
		System.out.println();
		if (numberOfNonNullPlayers == 0)
		{
			System.out.println("There is nobody to use this card on, you will have to use it on yourself\n");
			return turnCount;
		}
			
		checkingPlayerChoice(AllPlayers, turnCount);
		numberOfNonNullPlayers = 0; //sets checker back to 0
		return choice;	
	}
	public void checkingPlayerChoice(List<Players> AllPlayers, int turnCount) //checking to make sure the selected player is a valid one, both within the player count and active player pool
	{
		choice =  keyboard.nextInt();
		if ((choice-1) < 0 || (choice-1) > (AllPlayers.size()-1))
		{
			System.out.println("That is not close to a valid player selection, please try again\n\n");
			checkingPlayerChoice(AllPlayers, turnCount);
		}
		if ((AllPlayers.get((choice-1)).playerState == 0))
		{
			System.out.println("That is not a valid player selection at this time, please try again\n\n");
			checkingPlayerChoice(AllPlayers, turnCount);
		}
		
	}

}
