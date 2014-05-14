package cardGameV3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCardGameV3 {
	public static final int MINIMUM_NUM_PLAYERS = 2;
	public static final int MAXIMUM_NUM_PLAYERS = 4;
	public static void main(String[] args) throws IOException 
	{

		Scanner keyboard = new Scanner(System.in);
		int turnCount = 0;
		int killedPlayers = 0;
		int winCondition = 0;
		int winCount = 0;
		int playerScoreFirst = 0;
		int playerScoreSecond = 0;
		int highCardOwner = 0;
		int cardAttack = 0;
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
			turnCount = 0; //resetting the turn counter
			Deck.shuffle(); //shuffling for next hand
			for (int i = 0; i <numOfPlayers; i++) //first card dealt to all players, plus shows scores
			{
				AllPlayers.get(i).getStartingCard(Deck.dealCard());
				System.out.println("Player " + (i+1) + "'s score is " + AllPlayers.get(i).playerScore);
				AllPlayers.get(i).setPlayerStateOn(); //reactivates all players state
			}
			System.out.println("Play till " + winCondition + "\n");
			
			
			while (Deck.cardsDealt < DeckOfCards.cardCount - 1) //Smaller hand dealing Loop. deals until all cards are gone
			{
				if (AllPlayers.get(turnCount).playerState != 0) //checks to see if player is out of hand to skip if needed
				{
					SingleCards.confirmingPlayer(AllPlayers, turnCount);
					AllPlayers.get(turnCount).setBlockedOff(); //switches back to on in case handmaiden activation previous turn
					AllPlayers.get(turnCount).getNewCard(Deck.dealCard());//activates the choosing of the card, returns the card that was played
					cardAttack = AllPlayers.get(turnCount).playedCard.checkForAttack(AllPlayers, turnCount); //choosing who to play the card against
					killedPlayers = killedPlayers + AllPlayers.get(turnCount).playedCard.attackWithCard(AllPlayers.get(turnCount), AllPlayers.get(cardAttack)); //uses the played cards ability, putting the two players head to head. Returns 1 if knocked out
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
			
			
			playerScoreFirst = AllPlayers.get(0).savedCardValue; //setting the initial value for the other cards to be tested against, player 1's card
			for (int i = 1; i < numOfPlayers; i++) //comparing final cards. Starts with player(0) and then replaces it if the next is higher
			{
				playerScoreSecond = AllPlayers.get(i).savedCardValue;
				if (playerScoreFirst < playerScoreSecond)
				{
					playerScoreFirst = playerScoreSecond;
					highCardOwner = i;
				}
			}
			
			
			System.out.println("The winner of this hand is player " + (highCardOwner + 1));
			System.out.println("with a " + AllPlayers.get(highCardOwner).cardA.nameOfCard);
			AllPlayers.get(highCardOwner).scored();
			winCount = AllPlayers.get(highCardOwner).playerScore;
		}
		System.out.println("Congrats to player " + (highCardOwner+1) + ". You've won the game");
	}
}
