/*
Thread using Runnable Interface
	
	->Creating thread : 
		1.Implement the Runnable interface	[java.lang.Runnable]
		2.By extending the Thread class		[java.lang.Thread]
		
	=>WE ARE GOING TO IMPLEMENT THE FIRST METHOD IN THIS NOTE

	->Our objective :
		1.Creating thread
		2.Attach code to the thread
		3.Executing thread
		
	->OS puts all programs into circular queue which gives some time to each program by connecting the thread from Ram's program to the processor.The thread will not joined till the process completes for one program it will disconnect after some time and then come back by repeating and going through circular queue
		-It is not mandatory that each process completes but it can complete in the cycle of circular queue
		
	->For running two or more program parallely we have to create thread
	
		-Creating thread class object
			//creating two threads
			Thread t1 = new Thread();
			Thread t2 = new Thread();
		-Attaching code to thread
			an object of a class should be passed to attach code to the thread, this objedct should be passed in the constructor of the thread.
		->RUNNABLE is predefined interface.
			-includes run method
				=>We have to write the code of that specific method (which we want to attach with thread) in the method named run ().
		->We have to implement Runnable inteface with the class to attach this class's any method to thread.
	
		->We can make reference variable of parent class also. like we cannot make instances of interface so that if intrface is the parent class of class A then we can create reference variable of interface/parent-class with the object of class A.
		->When we pass the runnable object i1 into the thread, it can only run the 'run' method through i1.run();. It cannot run other methods in that class.
		
		
		
		
*/
class A implements Runnable{
	public void run(){
		for (int i=0;i<10;i++) {
			System.out.println("Thread A " + i);
		}
	}
}
class B implements Runnable{		//or we can also use inheritence in this by writing like : class B extends A implements Runnable 	(THIS IS AN ADVANTAGE OVER USING THREAD CLASS)
	public void run(){
		for (int i=0;i<10;i++) {
			System.out.println("Thread B " + i);
		}
	}
}

class Example{
	public static void main(String[] args){
		A A1 = new A();
		B B1 = new B();
		Thread t1 = new Thread(A1);
		Thread t2 = new Thread(B1);
		t2.setPriority(t2.MAX_PRIORITY);
		System.out.println(t1.getPriority() + " " + t2.getPriority());
		t1.start();
		t2.start();
		
		//WE CANNOT DIRECTLY CREATE THE OBJECT OF OUR CLASS AND USE RUN METHOD AS WE USED TO DO IN THREAD-CLASS.
	}
}

//output may change as program can run in any order and sequence.


/*
RUNNABLE INTERFACE
	public interface Runnable{
		void run();
	}
		
		->One way to create a thread in java is to implement the Runnable interface and then instantiate an object of the class
		->We need to override the run() method into our class which is the only method that needs to be implemented.
		
		STEPS :
		->An object of thread class is created by passing a Runnable object as argument to the Thread constructor. The thread object now has a Runnable object that implements the run() method.
		->The start() method is invoked on the the Thread object created in the previous step. The start() method returns immediately after a thread has been spawned.
		
	->The Thread ends when the run() method ends, either by normal completion or by throwing an uncaught exception.
*/