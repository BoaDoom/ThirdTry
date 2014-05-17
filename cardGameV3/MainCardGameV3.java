package cardGameV3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCardGameV3 {
	public static final int MINIMUM_NUM_PLAYERS = 2;
	public static final int MAXIMUM_NUM_PLAYERS = 4;
	public static void main(String[] args)
	{

		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		int turnCount = 0;
		int killedPlayers = 0;
		int winCondition = 0;
		int winCount = 0;
		int highCardOwner = 0;

		int cardAttack = 0;

		int HC = 0; //highcard owner
		int HC2 = 0; //secondary high card checker

		System.out.println("How many players? (between " + MINIMUM_NUM_PLAYERS + "-" + MAXIMUM_NUM_PLAYERS + ")"); //asking for the amount of players
		int numOfPlayers = keyboard.nextInt();
		while (numOfPlayers < MINIMUM_NUM_PLAYERS || numOfPlayers > MAXIMUM_NUM_PLAYERS)
		{			
			System.out.println("that is not the right number of players");
			System.out.println("How many players? (between " + MINIMUM_NUM_PLAYERS + "-" + MAXIMUM_NUM_PLAYERS + ")");
			numOfPlayers = keyboard.nextInt();
		}
		winCondition = Players.setWinCondition(numOfPlayers); //sets win condition according to an inexact formula according to amount of players
		DeckOfCards Deck = new DeckOfCards(); //makes a deck object

		Deck.setPlayerCount(numOfPlayers);
		List<Players> AllPlayers = new ArrayList<Players>(); //creates a list of player objects
		
		for (int i = 0; i < numOfPlayers; i++)
		{
			Players PlayerNum = new Players(i); //creates a new object PlayerNum, one for each player count
			AllPlayers.add(PlayerNum);  //adds each player object to the list AllPlayers			
		}
		
		
		while (winCount < winCondition) //Overall loop for each round played. Compares highest score for completion
		{
			highCardOwner = 0; //reseting the counter to track who has the highest hand at the end
			killedPlayers = 0;
			HC = 0;
			turnCount = 0; //resetting the turn counter
			Deck.shuffle(); //shuffling for next hand

			TableTop Table = new TableTop(numOfPlayers, Deck);// = new TableTop(numOfPlayers, Deck); //makes a table object to store discards/burns/hidden

			for (int i = 0; i <numOfPlayers; i++) //first card dealt to all players, plus shows scores
			{
				AllPlayers.get(i).getStartingCard(Deck);
				System.out.println("Player " + (i+1) + "'s score is " + AllPlayers.get(i).playerScore);
				AllPlayers.get(i).setPlayerStateOn(); //reactivates all players state
				Table.makePlayerPile();
			}
			System.out.println("Play until " + winCondition + "\n");
			
			
			while (Deck.cardsDealt < DeckOfCards.cardCount - 1) //Smaller hand dealing Loop. deals until all cards are gone
			{
				int e = 0;

				if (AllPlayers.get(turnCount).playerState != 0) //checks to see if player is out of hand to skip if needed
				{
					SingleCards.confirmingPlayer(AllPlayers, turnCount); //message to confirm that the correct player is looking at the screen
					AllPlayers.get(turnCount).setBlockedOff(); //switches back to off in case handmaiden activation previous turn
					AllPlayers.get(turnCount).getNewCard(Deck);//activates the drawing of a card to cardB variable
					AllPlayers.get(turnCount).chooseCard();
					cardAttack = AllPlayers.get(turnCount).playedCard.checkForAttack(AllPlayers, turnCount); //choosing who to play the card against. cardAttack is the player number chosen
					Table.addToDiscard((turnCount), (AllPlayers.get(turnCount).cardB)); //adds the card played to discard pile infront of player
					if (cardAttack != 0)
					{
						killedPlayers = killedPlayers + AllPlayers.get(turnCount).playedCard.attackWithCard(AllPlayers.get(turnCount), AllPlayers.get(cardAttack-1), Deck, Table); //uses the played cards ability, putting the two players head to head. Returns 1 if knocked out
					}

				}
				while (e < Table.playerDiscard.get(turnCount).size()) //printer for discard pile
				{
					System.out.println("player " + (turnCount+1) + "'s discard pile:" + Table.playerDiscard.get(turnCount).get(e).valueOfCard);
					e++;
				}
				
					turnCount++;
				if (turnCount == numOfPlayers) //rotates between player(0) and player(number of players - 1)
				{
					turnCount = 0;
				}
				if (killedPlayers == AllPlayers.size() - 1)
				{
					Deck.noNeedCards();
				}

				SingleCards.clearingTheScreen();

			}
			
			System.out.println("The round is over! time to compare hands");
			List<Players> HighCardOwners = new ArrayList<Players>();
			HighCardOwners.add(AllPlayers.get(0));
			for (int i = 1; i < (numOfPlayers); i++) //loads up player one, compares their score to the next player, replaces player one if the upcoming player is higher
			{
				if (AllPlayers.get(HC).savedCardValue < AllPlayers.get(i).savedCardValue)
				{
					HC = i;
					HighCardOwners.clear();
					HighCardOwners.add(AllPlayers.get(i));
				}
				else if (AllPlayers.get(HC).savedCardValue > AllPlayers.get(i).savedCardValue)
				{
				}
				else if (AllPlayers.get(HC).savedCardValue == AllPlayers.get(i).savedCardValue)//adds player onto list of high cards if they are equal to the highest
				{
					HighCardOwners.add(AllPlayers.get(i));
				}
			}


			if (HighCardOwners.size() > 1) //contingency for both players having the same value cards at the end of the game
			{
				System.out.println("There was a tie between players with the card " + HighCardOwners.get(HC).savedCardValue + " the winning player will be whoever has the highest card ontop of their discard pile");
				HC = 0;
				for (int i = 1; i < HighCardOwners.size(); i++) //secondary comparing for a tie
				{
					if (Table.playerDiscard.get(HC).get(Table.playerDiscard.get(HC).size()-1).valueOfCard < Table.playerDiscard.get(i).get(Table.playerDiscard.get(i).size()-1).valueOfCard)
					{
						HC = i;
						HC2 = 0;
					}
					if (Table.playerDiscard.get(HC).get(Table.playerDiscard.get(HC).size()-1).valueOfCard > Table.playerDiscard.get(i).get(Table.playerDiscard.get(i).size()-1).valueOfCard)
					{
						
					}
					if (Table.playerDiscard.get(HC).get(Table.playerDiscard.get(HC).size()-1).valueOfCard == Table.playerDiscard.get(i).get(Table.playerDiscard.get(i).size()-1).valueOfCard)
					{
						HC2++;
					}
				}
				if (HC2 > 1)
				{
					System.out.println("Your second cards were equal as well! the chances of that are so low we haven't made rules to account for that, so nobody gets points. Sorry");
				}
				else
				{
					highCardOwner = (AllPlayers.get(HC).playerName-1);
					System.out.println("The winner of this hand is player " + (highCardOwner + 1));
					System.out.println("with a " + (Table.playerDiscard.get(HC).get(Table.playerDiscard.get(HC).size()-1).nameOfCard) + " in their discard pile");
				}
			}
			else
			{
			System.out.println("The winner of this hand is player " + (highCardOwner + 1));
			System.out.println("with a " + AllPlayers.get(highCardOwner).cardA.nameOfCard);
			AllPlayers.get(highCardOwner).scored();
			winCount = AllPlayers.get(highCardOwner).playerScore;
			}
		}
		System.out.println("Congrats to player " + (highCardOwner+1) + ". You've won the game");
	}
}