//implimenting Runnable
class NewThread implements Runnable {
//	public static void main(String[] args) {
		Thread t;
		NewThread(){
			t = new Thread(this, "Demo Thread");
			System.out.println("Child Thread : " + t);		//Demo Thread, 5, main - [name, priority, group which triggered this thread]
			t.start();
		}
	public void run(){
		try {
			for(int i=0;i<5;i++){
				System.out.println("Child thread : " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Exception caught : Child thread Interrupted");
		}
		System.out.println("Exiting child thread");
	}
//	}
}
class Main {
	public static void main(String[] args) {
//		NewThread nt = new NewThread();
		new NewThread();		//2 threads running , newThread and another is main
		try {
			for (int i=0;i<5;i++) {
				System.out.println("Main Thread : " + i);
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) {
			System.out.println("Exception caught : Main thread interrupted");
		}
		System.out.println("End of main thread : " + Thread.currentThread());
	}
}