package cardGameV3;

import java.util.ArrayList;

import cardGameV3.Cards.*;

import java.util.Random;
import java.util.List;

public class DeckOfCards //name of object is Deck
{
	public static final int NUMBER_OF_GUARDS = 5; //first number is amount of cards, second is their value
	public static final int NUMBER_OF_PRIESTS = 2;
	public static final int NUMBER_OF_BARONS = 2;
	public static final int NUMBER_OF_HANDMAIDENS = 2;
	public static final int NUMBER_OF_PRINCES = 2;
	public static final int NUMBER_OF_KINGS = 1;
	public static final int NUMBER_OF_COUNTESSES = 1;
	public static final int NUMBER_OF_PRINCESSES = 1;
	public static final int cardCount = NUMBER_OF_GUARDS + NUMBER_OF_PRIESTS + NUMBER_OF_BARONS + NUMBER_OF_HANDMAIDENS+ NUMBER_OF_PRINCES + NUMBER_OF_KINGS + NUMBER_OF_COUNTESSES + NUMBER_OF_PRINCESSES;
    //previous huge line is the total card count given the previous amount values of each card
	public int cardsDealt = 0;
	public int numOfPlayers = 0;
	Random randomizer = new Random(); //randomizer
	List<SingleCards> AllCards = new ArrayList<SingleCards>();
    
	public void noNeedCards()
	{
		cardsDealt = cardCount;
	}
    public SingleCards dealCard()
    {
    	cardsDealt++; //adjusts number to deal out the next card in the array
    	return AllCards.get(cardsDealt);
    }
    public SingleCards dealLastCard() //part of prince last card deal
    {
    	return AllCards.get(0);
    }
    
    public void shuffle()
    {	
		for (int firstCardCount = cardCount; firstCardCount > 0; firstCardCount--) //shuffles deck array
		{
			int pickedCardNumber = randomizer.nextInt(firstCardCount); //randomizes a number of the deck size
			AllCards.add(AllCards.get(pickedCardNumber)); //assigns random card from AllCards list to end of the list
			AllCards.remove(pickedCardNumber); //removes the card from the list so it wont get picked again
		}
		cardsDealt = 0; //starts at 0, meaning first card drawn will be the second in the array, the very first card will be the burn/hidden card
		if (numOfPlayers == 2)
		{
			cardsDealt = cardsDealt + 3; //adds one onto each of the burn cards for a 2 player game. Burn cards are now AllCards.get(1-3)
		}
    }
    public void setPlayerCount(int playerCount)
    {
    	numOfPlayers = playerCount;
    }
        
	DeckOfCards() //constructor for creating all the cards in the right amount of each
	{
		for (int i = 0; i < NUMBER_OF_GUARDS; i++)
		{
			SingleCards Acard = new Guard(); //creates a sub-object for every guard
			AllCards.add(Acard); //adds card into the array list AllCards
		}
		for (int i = 0; i < NUMBER_OF_PRIESTS; i++)
		{
			SingleCards Acard = new Priest();
			AllCards.add(Acard);
		}
		for (int i = 0; i < NUMBER_OF_BARONS; i++)
		{
			SingleCards Acard = new Baron();
			AllCards.add(Acard);
		}
		for (int i = 0; i < NUMBER_OF_HANDMAIDENS; i++)
		{
			SingleCards Acard = new Handmaid();
			AllCards.add(Acard);
		}
		for (int i = 0; i < NUMBER_OF_PRINCES; i++)
		{
			SingleCards Acard = new Prince();
			AllCards.add(Acard);
		}
		for (int i = 0; i < NUMBER_OF_KINGS; i++)
		{
			SingleCards Acard = new King();
			AllCards.add(Acard);
		}
		for (int i = 0; i < NUMBER_OF_COUNTESSES; i++)
		{
			SingleCards Acard = new Countess();
			AllCards.add(Acard);
		}
		for (int i = 0; i < NUMBER_OF_PRINCESSES; i++)
		{
			SingleCards Acard = new Princess();
			AllCards.add(Acard);
		}
		shuffle();
	}
	
}
