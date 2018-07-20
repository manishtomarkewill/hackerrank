public class TClass {
  
      private volatile int counter = 0;
	  
      private class MyRunnable extends Thread {
	  
		  @Override
		  public void run() {
			  if (counter++ == 0) {
				   System.out.println("Found 0");
			  }
		  }
	  }
	  
	  public void doSomething() {
	      new Thread(new MyRunnable()).start();
		  new Thread(new MyRunnable()).start();
	  }
	  
	  
  }