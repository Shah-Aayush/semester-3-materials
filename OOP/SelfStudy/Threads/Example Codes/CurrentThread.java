//MULTITHREADING PROGRAMS : 
//current thread
class CurrentThread{
	public static void main(String[] args){
		Thread t = Thread.currentThread();
		System.out.println("Current Thread : " + t);
		System.out.println("Before : " + t.getName()); 
		t.setName("My Thread");
		System.out.println("After : " + t.getName()); 
		System.out.println("After name changes : " + t);
		
		//methods and its meaning 
		/*
			getName : Obtain a thread's name
			getPriority : Obtain a thread's priority
			isAlive : Determine if a thread is still running
			join : Wait for a thread to terminate
			run : Entry point for the thread
			sleep :  suspend a thread for a period of time
			start : start a thread by calling its run method
		*/
		System.out.println("\nMethods START\n " + t.isAlive());
		System.out.println(t.isAlive());
		System.out.println(t.getName());
		System.out.println(t.getPriority());
		
		System.out.println("Methods ENDS\n");
		try {
			for(int i=0;i<5;i++){
				System.out.println(i);
				Thread.sleep(1000);	//sleeps for 10k milliseconds ~ 10 seconds
				//thorws interruptedException
				
			}
		} catch (InterruptedException e) {
			System.out.println("Current Thread interrupted !");
		}
		
	}
}