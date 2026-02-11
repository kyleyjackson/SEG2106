package SEG2106.core;

public class Main {

	public static void main(String [] args){
		// get the singleton object of the traffic light manager
		TrafficLightManager trafficLightManager = TrafficLightManager.getTrafficManager();
		
		// Create the traffic light state machine
		new TrafficLight(trafficLightManager);
		
		String[] args0 = {"hightraffic"};

		// Set the traffic condition
		if (args0.length > 0){
			trafficLightManager.setTrafficCondition(args0[0]);
		}
	}
}
