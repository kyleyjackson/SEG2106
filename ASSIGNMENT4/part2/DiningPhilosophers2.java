public class DiningPhilosophers2 {

	public static void main(String args[]) {
		GraphicTable2 table = new GraphicTable2();
		
		Chopstick2 c0 = new Chopstick2(0);
		Chopstick2 c1 = new Chopstick2(1);
		Chopstick2 c2 = new Chopstick2(2);
		Chopstick2 c3 = new Chopstick2(3);
		Chopstick2 c4 = new Chopstick2(4);
		
		Philosopher2 p0 = new Philosopher2(0, table, c0, c4);
		Philosopher2 p1 = new Philosopher2(1, table, c1, c0);
		Philosopher2 p2 = new Philosopher2(2, table, c2, c1);
		Philosopher2 p3 = new Philosopher2(3, table, c3, c2);
		Philosopher2 p4 = new Philosopher2(4, table, c4, c3);
		
		p0.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}
}
