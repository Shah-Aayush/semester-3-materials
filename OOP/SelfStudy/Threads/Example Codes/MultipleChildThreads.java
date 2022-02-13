class NewThread2 implements Runnable{
	String name;
	Thread t;
	NewThread2(String name){
		this.name = name;
		t = new Thread(this, name);
		System.out.println("New Thread : " + t);
		t.start();
	}
	public void run(){
		try {
			for (int i=0;i<5;i++) {
				System.out.println(name + " : " + i);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + name + " Interrupted");
		}
		System.out.println(name + " Exiting");
	}
}
class Main {
	public static void main(String[] args) {
		new NewThread2("One");
		new NewThread2("Two");
		new NewThread2("Three");
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("Main thread interrupted");
		}
		System.out.println("Main thread exiting");
	}
}