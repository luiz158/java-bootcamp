package business;

public class Sequence {
	
	  private static Sequence instance;
	  private static int counter;
	  
	  private Sequence(){
	    counter = 0; 
	  }
	  
	  public static synchronized Sequence getInstance(){
	    if(instance == null){
	      instance = new Sequence();
	    }
	    return instance;
	  }
	  
	  public static synchronized int getNext(){
	    return ++counter;
	  }
	}