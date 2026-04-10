public class DiningPhilosophers3 {

	public static void main(String args[]) {
		GraphicTable3 table = new GraphicTable3();
		
		Chopstick3 c0 = new Chopstick3(0);
		Chopstick3 c1 = new Chopstick3(1);
		Chopstick3 c2 = new Chopstick3(2);
		Chopstick3 c3 = new Chopstick3(3);
		Chopstick3 c4 = new Chopstick3(4);
		
		Philosopher3 p0 = new Philosopher3(0, table, c0, c4);
		Philosopher3 p1 = new Philosopher3(1, table, c1, c0);
		Philosopher3 p2 = new Philosopher3(2, table, c2, c1);
		Philosopher3 p3 = new Philosopher3(3, table, c3, c2);
		Philosopher3 p4 = new Philosopher3(4, table, c4, c3);
		
		p0.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}
}
