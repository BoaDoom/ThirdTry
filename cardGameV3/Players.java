package cardGameV3;

import java.util.Scanner;

public class Players {
	//hopefully will store cards for comparison, keep score and do the comparisons
	static int winCondition = 0;
	public SingleCards cardA;
	SingleCards playedCard;
	int nextCard = 0;
	int playerScore = 0;
	public int playerName = 0;
	int playerListCount = 0;
	public int playerState = 0; //false is out of round, true is in
	public int blocked = 0; //handmaiden activation
	public int savedCardValue = 0;

	Scanner keyboard = new Scanner(System.in);
	
	public void setPlayerStateOn()
	{
		playerState = 1;
	}
	public void setPlayerStateOff()
	{
		playerState = 0;
		savedCardValue = 0; //sets card value to 0 to determine winner
	}
	public void setBlockedOn()
	{
		blocked = 1;
	}
	public void setBlockedOff()
	{
		blocked = 0;
	}


	static int setWinCondition(int playerCount)
	{
	if (playerCount == 2)		{ //sets win condition determined by the amount of players
		winCondition = 4;		}
	if (playerCount == 3)		{
		winCondition = 3;		}
	if (playerCount == 4)		{
		winCondition = 2;		}
	return winCondition;
	}
	
	
	public void getNewCard(SingleCards cardB)
	{
		System.out.println("Your turn player number " + playerName);
		System.out.println("Which card would you like to play? the other will be kept");
		System.out.println("1: " + cardA.valueOfCard + " " + cardA.nameOfCard);
		System.out.println("2: " + cardB.valueOfCard + " " + cardB.nameOfCard);
		int cardChoice = keyboard.nextInt();
		while (cardChoice != 1 && cardChoice != 2)
		{
			System.out.println("please choose option 1 or 2");
			cardChoice = keyboard.nextInt();
		}
		playedCard = cardB; //card assigned for being activated and used
		if (cardChoice == 1)
		{
			playedCard = cardA;
			cardA = cardB;
		}
		savedCardValue = cardA.valueOfCard;
	}

	public void princeDiscard()
	{
		System.out.println("The prince has forced you to drop your " + cardA.nameOfCard);
		
	}
	/*
	public boolean compareCards(Players otherPlayers) //unused card comparer
	{
		if (otherPlayers.currentCard < currentCard)
		{
			return true;
		}
		if (otherPlayers.currentCard == currentCard)
		{
			return false;
		}
		return false;
	}
	*/
	public void scored()
	{
		playerScore++;
	}
	public void getStartingCard(SingleCards startingCard)
	{
		cardA = startingCard;
	}
	
	Players(int playerNameTemp)
	{
		playerName = playerNameTemp+1;
	}
}
