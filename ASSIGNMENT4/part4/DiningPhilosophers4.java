public class DiningPhilosophers4 {

	public static void main(String args[]) {
		GraphicTable4 table = new GraphicTable4();
		
		Chopstick4 c0 = new Chopstick4(0);
		Chopstick4 c1 = new Chopstick4(1);
		Chopstick4 c2 = new Chopstick4(2);
		Chopstick4 c3 = new Chopstick4(3);
		Chopstick4 c4 = new Chopstick4(4);
		
		Philosopher4 p0 = new Philosopher4(0, table, c0, c4);
		Philosopher4 p1 = new Philosopher4(1, table, c1, c0);
		Philosopher4 p2 = new Philosopher4(2, table, c2, c1);
		Philosopher4 p3 = new Philosopher4(3, table, c3, c2);
		Philosopher4 p4 = new Philosopher4(4, table, c4, c3);
		
		p0.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}
}
