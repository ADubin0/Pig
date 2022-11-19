import java.util.Scanner;

public class Player {
	
	static int TARGET_SCORE = 5;
	static Player NULL = new Player("NULL");
	
	String name;
	Scanner sc;
	int score;
	public Player(String name) {
		this.name = name;
		sc = new Scanner(System.in);
		score = 0;
	}
	
	public void takeTurn(Die d6) {
		int turnCount = 0;
		while(true) {
			System.out.println(name+ ": Roll or forfeit turn? ('true' to roll)");
			String input = sc.next();
			if (input.contains("true".toLowerCase() )) {
				d6.roll();
				System.out.println("Number rolled: " + d6.getFace());
				if (d6.face != 1) {
					turnCount += d6.face;
					System.out.println(name + " current turn score: " + turnCount);
				}
				else {
					System.out.println("You rolled a 1 - next player");
					return;
				}	
			}
			else {
				System.out.println(turnCount + " added to " + name+"'s score.");
				score += turnCount;
				System.out.println("New current score for " + name + ": " + score);
				return;
			}
			
		}
		
	}
	
	public boolean suddenDeath(Die d) {
		System.out.println("Sudden Death: "+ name + " has one more chance to win.");
		this.takeTurn(d);
		if (score >= TARGET_SCORE) {
			return true;
		}
		else {return false;}
	}
	
	public Player checkWinner(Player p2) {
		if (p2.score >= TARGET_SCORE) {
			return p2;
		}
		else if (score >= TARGET_SCORE) {
			return this;
		}
		else {return NULL;}
	}

}
