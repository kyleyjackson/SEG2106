public class Chopstick2 {
	private int ID;
	// hint: use a local variable to indicate whether the chopstick is free 
	// (lying on the table), e.g.  private boolean free;

	private boolean free = true; // This simply means the chopstick isn't in use (on the tablee)

	Chopstick2(int ID) {
		  this.ID = ID;
	
	}
	
	synchronized void take() {

		while (!free) { // If chopstick isn't free, so wait until it is
			try { wait(); } //

			catch (InterruptedException exc) {
				System.out.println(exc);
			}

		} free = false; // Once it's taken, change boolean to false
	
	}
	
	synchronized void release() { // Release chopstick and put it back on the table

		free = true;
		notify(); 		// Inform the philosopher waiting for the chopstick
	
	}
	    
	public int getID() {
	    return(ID);
	}
}
