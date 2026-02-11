package SEG2106.core;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3369 modeling language!*/



// line 1 "model.ump"
public class TrafficLight implements EventHandler
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TrafficLight State Machines
  public enum Status { initializer, northSouthArrowLow, northSouthGreenLow, northSouthYellowLow, northSouthRedLow, westEastYellowLow, northGreenArrowMid, northYellowMid, southGreenArrowMid, southYellowMid, westEastGreenMid, westEastYellowMid, northGreenArrowHigh, northYellowHigh, southGreenArrowHigh, southYellowHigh, westGreenArrowHigh, westEastGreenHigh, westEastYellowHigh }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  private TrafficLightManager trafficLightManager; 
  public TrafficLight(TrafficLightManager trafficLightManager)
  {
	this.trafficLightManager = trafficLightManager;
	  
	setStatus(Status.initializer);
    
    trafficLightManager.addEventHandler(this);
  }

//------------------------
  // INTERFACE
  //------------------------

  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean lowTraffic()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case initializer:
        setStatus(Status.northSouthArrowLow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean moderateTraffic()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case initializer:
        setStatus(Status.northGreenArrowMid);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean highTraffic()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case initializer:
        setStatus(Status.northGreenArrowHigh);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerGreen()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case northSouthArrowLow:
        setStatus(Status.northSouthGreenLow);
        wasEventProcessed = true;
        break;
      case northSouthGreenLow:
        setStatus(Status.northSouthYellowLow);
        wasEventProcessed = true;
        break;
      case northSouthRedLow:
        setStatus(Status.westEastYellowLow);
        wasEventProcessed = true;
        break;
      case northGreenArrowMid:
        setStatus(Status.northYellowMid);
        wasEventProcessed = true;
        break;
      case southGreenArrowMid:
        setStatus(Status.southYellowMid);
        wasEventProcessed = true;
        break;
      case westEastGreenMid:
        setStatus(Status.westEastYellowMid);
        wasEventProcessed = true;
        break;
      case northGreenArrowHigh:
        setStatus(Status.northYellowHigh);
        wasEventProcessed = true;
        break;
      case southGreenArrowHigh:
        setStatus(Status.southYellowHigh);
        wasEventProcessed = true;
        break;
      case westGreenArrowHigh:
        setStatus(Status.westEastGreenHigh);
        wasEventProcessed = true;
        break;
      case westEastGreenHigh:
        setStatus(Status.westEastYellowHigh);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerYellow()
  {
    boolean wasEventProcessed = false;
    
    Status aStatus = status;
    switch (aStatus)
    {
      case northSouthYellowLow:
        setStatus(Status.northSouthRedLow);
        wasEventProcessed = true;
        break;
      case westEastYellowLow:
        setStatus(Status.northSouthArrowLow);
        wasEventProcessed = true;
        break;
      case northYellowMid:
        setStatus(Status.southGreenArrowMid);
        wasEventProcessed = true;
        break;
      case southYellowMid:
        setStatus(Status.westEastGreenMid);
        wasEventProcessed = true;
        break;
      case westEastYellowMid:
        setStatus(Status.northGreenArrowMid);
        wasEventProcessed = true;
        break;
      case northYellowHigh:
        setStatus(Status.southGreenArrowHigh);
        wasEventProcessed = true;
        break;
      case southYellowHigh:
        setStatus(Status.westGreenArrowHigh);
        wasEventProcessed = true;
        break;
      case westEastYellowHigh:
        setStatus(Status.northGreenArrowHigh);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case northSouthArrowLow:
        // line 17 "model.ump"
        trafficLightManager.northArrow();
        // line 18 "model.ump"
        trafficLightManager.southArrow();
        // line 19 "model.ump"
        trafficLightManager.westRed();
        // line 20 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northSouthGreenLow:
        // line 25 "model.ump"
        trafficLightManager.northGreen();
        // line 26 "model.ump"
        trafficLightManager.southGreen();
        // line 27 "model.ump"
        trafficLightManager.westRed();
        // line 28 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northSouthYellowLow:
        // line 33 "model.ump"
        trafficLightManager.northYellow();
        // line 34 "model.ump"
        trafficLightManager.southYellow();
        // line 35 "model.ump"
        trafficLightManager.westRed();
        // line 36 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northSouthRedLow:
        // line 41 "model.ump"
        trafficLightManager.northRed();
        // line 42 "model.ump"
        trafficLightManager.southRed();
        // line 43 "model.ump"
        trafficLightManager.westGreen();
        // line 44 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westEastYellowLow:
        // line 49 "model.ump"
        trafficLightManager.northRed();
        // line 50 "model.ump"
        trafficLightManager.southRed();
        // line 51 "model.ump"
        trafficLightManager.westYellow();
        // line 52 "model.ump"
        trafficLightManager.eastYellow();
        break;
      case northGreenArrowMid:
        // line 61 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 62 "model.ump"
        trafficLightManager.southRed();
        // line 63 "model.ump"
        trafficLightManager.westRed();
        // line 64 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northYellowMid:
        // line 69 "model.ump"
        trafficLightManager.northYellow();
        // line 70 "model.ump"
        trafficLightManager.southRed();
        // line 71 "model.ump"
        trafficLightManager.westRed();
        // line 72 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southGreenArrowMid:
        // line 77 "model.ump"
        trafficLightManager.northRed();
        // line 78 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 79 "model.ump"
        trafficLightManager.westRed();
        // line 80 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southYellowMid:
        // line 85 "model.ump"
        trafficLightManager.northRed();
        // line 86 "model.ump"
        trafficLightManager.southYellow();
        // line 87 "model.ump"
        trafficLightManager.westRed();
        // line 88 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westEastGreenMid:
        // line 93 "model.ump"
        trafficLightManager.northRed();
        // line 94 "model.ump"
        trafficLightManager.southRed();
        // line 95 "model.ump"
        trafficLightManager.westGreen();
        // line 96 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westEastYellowMid:
        // line 101 "model.ump"
        trafficLightManager.northRed();
        // line 102 "model.ump"
        trafficLightManager.southRed();
        // line 103 "model.ump"
        trafficLightManager.westYellow();
        // line 104 "model.ump"
        trafficLightManager.eastYellow();
        break;
      case northGreenArrowHigh:
        // line 113 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 114 "model.ump"
        trafficLightManager.southRed();
        // line 115 "model.ump"
        trafficLightManager.westRed();
        // line 116 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northYellowHigh:
        // line 121 "model.ump"
        trafficLightManager.northYellow();
        // line 122 "model.ump"
        trafficLightManager.southRed();
        // line 123 "model.ump"
        trafficLightManager.westRed();
        // line 124 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southGreenArrowHigh:
        // line 129 "model.ump"
        trafficLightManager.northRed();
        // line 130 "model.ump"
        trafficLightManager.southGreenAndArrow();
        // line 131 "model.ump"
        trafficLightManager.westRed();
        // line 132 "model.ump"
        trafficLightManager.eastRed();
        break;
      case southYellowHigh:
        // line 137 "model.ump"
        trafficLightManager.northRed();
        // line 138 "model.ump"
        trafficLightManager.southYellow();
        // line 139 "model.ump"
        trafficLightManager.westRed();
        // line 140 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westGreenArrowHigh:
        // line 145 "model.ump"
        trafficLightManager.northRed();
        // line 146 "model.ump"
        trafficLightManager.southRed();
        // line 147 "model.ump"
        trafficLightManager.westGreenAndArrow();
        // line 148 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westEastGreenHigh:
        // line 153 "model.ump"
        trafficLightManager.northRed();
        // line 154 "model.ump"
        trafficLightManager.southRed();
        // line 155 "model.ump"
        trafficLightManager.westGreen();
        // line 156 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westEastYellowHigh:
        // line 161 "model.ump"
        trafficLightManager.northRed();
        // line 162 "model.ump"
        trafficLightManager.southRed();
        // line 163 "model.ump"
        trafficLightManager.westYellow();
        // line 164 "model.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  public void delete()
  {}
}