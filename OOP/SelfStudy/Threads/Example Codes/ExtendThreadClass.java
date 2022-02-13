//Extending Thread class
class NewThread1 extends Thread {
	NewThread1(){
		super("Demo Thread");
		System.out.println("Child Thread : " + this);
		start();
	}
	public void run(){
		try {
			for (int i=0;i<5;i++) {
				System.out.println("Child Thread : " + i);
				sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Exception caught in child thread");
		}
		System.out.println("Exiting child thread");
	}
}
class Main {
	public static void main(String[] args) {
		new NewThread1();
		try {
			for(int i=0;i<5;i++){
				System.out.println("Main thread : " + i);
				Thread.sleep(3000);
			}
			
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		System.out.println("Exiting Main thread");
	}
}