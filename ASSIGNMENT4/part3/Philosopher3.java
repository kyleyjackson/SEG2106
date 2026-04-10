public class Philosopher3 extends Thread {
	private GraphicTable3 table;
	private Chopstick3 left;
	private Chopstick3 right;
	private int ID;
	final int timeThink_max = 5000;
	final int timeNextFork = 100;
	final int timeEat_max = 5000;
	
	Philosopher3(int ID, GraphicTable3 table, Chopstick3 left, Chopstick3 right) {
		this.ID = ID;
		this.table = table;
		this.left = left;
		this.right = right;
		setName("Philosopher "+ID);
	}
	
	public void run() {
		long x = 100;

		while (true) {

			table.isThinking(ID);
			System.out.println(getName() + " thinks");

			try {
				sleep((long)(Math.random() * timeThink_max));
			} catch(InterruptedException e) {
				System.out.println(e);
			}

			System.out.println(getName() + " finished thinking"); 
			System.out.println(getName() + " is hungry"); 
			table.isHungry(ID);

			boolean gotLeft = false;
			boolean gotRight = false;

			try {
				System.out.println(getName() + " wants left chopstick");

				// attempt to take left
				gotLeft = left.tryTake(x); // ms input here

				if (gotLeft) {
					table.takeChopstick(ID, left.getID());
					System.out.println(getName() + " got left chopstick");

					sleep(timeNextFork);

					System.out.println(getName() + " wants right chopstick");

					// attempt to take right
					gotRight = right.tryTake(x); // here 2

					if (gotRight) {
						table.takeChopstick(ID, right.getID());
						System.out.println(getName() + " got right chopstick");

						// delicious
						System.out.println(getName() + " eats");
						sleep((long)(Math.random() * timeEat_max));
						System.out.println(getName() + " finished eating");
					}
				}

			} catch(InterruptedException e){
				System.out.println(e);
			}

			// release left if failed
			if (gotLeft) {
				table.releaseChopstick(ID, left.getID());
				left.release();
				System.out.println(getName() + " released left chopstick");
			}

			//release right if failed
			if (gotRight) {
				table.releaseChopstick(ID, right.getID());
				right.release();
				System.out.println(getName() + " released right chopstick");
			}

			// make another attempt later
			try {
				sleep(50);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}
