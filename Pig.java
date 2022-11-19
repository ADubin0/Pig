
public class Pig {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Die D6 = new Die();
		Player[] players = new Player[2];
		players[0] = new Player("Player 1");
		players[1] = new Player("Player 2");
		while (true) {
			players[0].takeTurn(D6);
			if (players[1].checkWinner(players[0]).equals(players[0])) {
				// sudden death for player 2
				if (players[1].suddenDeath(D6)) {
					System.out.println(players[1].name + " wins.");
					break;
				}
				else {System.out.println(players[0].name + " wins."); break;}
			}
			players[1].takeTurn(D6);
			if (players[0].checkWinner(players[1]).equals(players[1])) {
				// sudden death for player 1
				if (players[0].suddenDeath(D6)) {
					System.out.println(players[0].name + " wins.");
					break;
				}
				else {System.out.println(players[1].name + " wins."); break;}
			}
		}
	}

}
