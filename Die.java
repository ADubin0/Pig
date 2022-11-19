import java.util.Random;

/*
 * Simple D6 class
 */
public class Die {

	Random rand;
	int face;
	public Die() {
		this.face = 1;
		rand = new Random();
	}
	
	public void roll() {
		face = rand.nextInt(5)+1;
	}
	
	public int getFace() {
		return face;
	}

}
