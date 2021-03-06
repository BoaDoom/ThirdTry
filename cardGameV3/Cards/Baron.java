package cardGameV3.Cards;


import cardGameV3.DeckOfCards;
import cardGameV3.Players;
import cardGameV3.SingleCards;
import cardGameV3.TableTop;

public class Baron extends SingleCards{
	

	public Baron()
	{
		super();
		valueOfCard = 3;
		nameOfCard = "Baron";
		descriptionOfCard = "This card is played on another player, it forces you to compare hands, highest card in their hand when played, wins, the loser is out of the round";
	}
	public int attackWithCard(Players AttackingPlayer, Players DefendingPlayer, DeckOfCards Deck, TableTop Table)
	{
	if (AttackingPlayer.cardA.valueOfCard > DefendingPlayer.cardA.valueOfCard)
	{
		System.out.println("Player " + AttackingPlayer.playerName + " has the higher card with the " + nameThisCard(AttackingPlayer.cardA.valueOfCard)+ ", the " + AttackingPlayer.cardA.valueOfCard 
				+ "\nversus Player" +  DefendingPlayer.playerName + "'s " +nameThisCard(DefendingPlayer.cardA.valueOfCard) +  ", a " + DefendingPlayer.cardA.valueOfCard);
		System.out.println("You should announce to everyone the value of which card was beaten");
		DefendingPlayer.setPlayerStateOff();
		return 1;
	}
	if (AttackingPlayer.cardA.valueOfCard < DefendingPlayer.cardA.valueOfCard)
	{
		System.out.println("Player " + DefendingPlayer.playerName + " has the higher card with the " + nameThisCard(DefendingPlayer.cardA.valueOfCard)+ ", the " + DefendingPlayer.cardA.valueOfCard 
				+ "\nversus Player " +  AttackingPlayer.playerName + "'s " +nameThisCard(AttackingPlayer.cardA.valueOfCard) +  ", a " + AttackingPlayer.cardA.valueOfCard);
		System.out.println("You should announce to everyone the value of which card was beaten");
		AttackingPlayer.setPlayerStateOff();
		return 1;
	}

		System.out.println("You both have the same card! You don't need to show them this, they should be able to deduce what you have after neither of you are out");
		return 0;
		
	}

}