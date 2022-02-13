/*
	THREADS USING 'Thread class' IN JAVA

	-Our Objective : 
		1.Creating thread.
		2.Attach code to the thread.
		3.Executing thread.

	->Drawback : 
		->When we use Thread class, 
			-As we know there is no concept of multiple inheritence in java.
			-So If we extends some class then we cannot make other class as a parent of that specific class as we already used thread class's extends and made it as a parent of our class.
			-If we use runnable interface other than this, then we can use extends also!
	
*/

class A extends Thread{
	public void run(){
		int i;
		for (i=1;i<10;i++) {
			System.out.println("i = " + i + " Thread A");
		}
	}
}

class B extends Thread{		//we cannot make another class as a parent of this class as java doesn't support multiple inheritance and we already declared Thread class is the parent class of this class so this is the disadvantage of using Thread class over runnable interface.
	public void run(){
		int i;
		for (i=1;i<10;i++) {
			System.out.println("i = " + i + " Thread B");
		}
	}
}

class Example {
	public static void main(String[] args) throws InterruptedException {		//sleep throws this exception so that it should be thrown!
		A O1 = new A();
		B O2 = new B();
		O1.start();
		O2.start();
//		O1.sleep(10000);		//stops program for 10000 milliseconds ~ 10 seconds !		=>Thread goes in NOT RUNNABLE state.

//		O2.wait(2000);		//this also throws Inturrpted exception.
//		O2.suspend();		//->THIS METHOD IS DEPRECATED
		//WE NEED NOT TO MAKE A OBJECT OF THREAD CLASS AND PASS OUR OBJECT IN IT. WE CAN SIMPLY/DIRECTLY USE THE PARENT CLASS'S METHOD : start() HERE.
		
	}
}
