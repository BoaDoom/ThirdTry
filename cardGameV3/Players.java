package cardGameV3;

import java.util.Scanner;

public class Players {
	//hopefully will store cards for comparison, keep score and do the comparisons
	static int winCondition = 0;
	public SingleCards cardA;
	public SingleCards cardB;
	SingleCards playedCard;
	int nextCard = 0;
	int playerScore = 0;
	public int playerName = 0;
	int playerListCount = 0;
	public int playerState = 0; //false is out of round, true is in
	public int blocked = 0; //handmaiden activation
	public int savedCardValue = 0;
	int cardChoice = 0;

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
	
	
	public void getNewCard(DeckOfCards Deck)
	{
		cardB = Deck.dealCard();
	}
	
	public void chooseCard()
	{
		if ((cardB.valueOfCard == 7 || cardA.valueOfCard == 7) && ((cardA.valueOfCard == 6 || cardA.valueOfCard == 5) || (cardB.valueOfCard == 6 || cardB.valueOfCard == 5))) //countess checking
		{
			System.out.println("You've got a Countess and a King/Prince in your hand! She flees and you can't stop her");
			if (cardA.valueOfCard == 7) //auto setting the 'played' or discard to the countess
			{
				cardChoice = 1; 
			}
			else
			{
				cardChoice = 2;
			}
		}
		else
		{
			if (cardA.valueOfCard == 8 || cardB.valueOfCard == 8) //princess checking
			{
				System.out.println("You've got a Princess in your hand! you cannot play her without losing the round\nYou are forced to play the other card in your hand, a ");
				if (cardA.valueOfCard == 8) //auto setting the 'played' or discard to the countess
				{
					cardChoice = 2;
					System.out.print(cardB.nameOfCard + "\n");
				}
				else
				{
					cardChoice = 1;
					System.out.print(cardA.nameOfCard + "\n");
				}
			}
			else
			{
				System.out.println("Your turn player number " + playerName);
				System.out.println("Which card would you like to play? the other will be kept");
				System.out.println("1: " + cardA.valueOfCard + " " + cardA.nameOfCard + "          " + cardA.descriptionOfCard);
				System.out.println("2: " + cardB.valueOfCard + " " + cardB.nameOfCard + "          " + cardB.descriptionOfCard);
				cardChoice = keyboard.nextInt();
				while (cardChoice != 1 && cardChoice != 2)
				{
					System.out.println("please choose option 1 or 2");
					cardChoice = keyboard.nextInt();
				}
			}
		}
			playedCard = cardB; //card assigned for being activated and used
		if (cardChoice == 1)
		{
			playedCard = cardA;
			cardA = cardB; //variable used for storage for repicking a card after given the option to change
			cardB = playedCard;
		}
		savedCardValue = cardA.valueOfCard;
	}

	public void princeDiscard()
	{
		System.out.println("The prince has forced you to drop your " + cardA.nameOfCard);
		
	}

	public void scored()
	{
		playerScore++;
	}
	public void getStartingCard(DeckOfCards Deck)
	{
		cardA = Deck.dealCard();
	}
	
	Players(int playerNameTemp)
	{
		playerName = playerNameTemp+1;
	}
}
