package cop2805;

public class ThreadExample extends Thread{
	
	
	public boolean shutdown = false;
	public Integer userCount = 0; 
	public void run() {
		for (int i = 1; i <= 1000; i++) {
			if (shutdown) {
				break;

			}
			//System.out.println("Thread: " + i);
			synchronized(userCount) {
				
			
			userCount++;
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
			}
		}
		System.out.println("Thread user count :" + userCount);
	}
	public static void main(String[] args) {
		ThreadExample example = new ThreadExample();
		example.start();
		(new ThreadExample()).start();
		for(int i=1; i<= 1000;i++)
		{
			synchronized(example.userCount){
				example.userCount++;
			}
		//	System.out.println("Main function: " + i);
			try {
				sleep(1);
			} catch (InterruptedException e) {
			}
		}
		//System.out.println("Send signal to shutdown therad");
		//example.shutdown = true;
		System.out.println("Main user count   :" + example.userCount);
	}
}
