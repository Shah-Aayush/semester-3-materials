/*
	THREADS STATES IN JAVA
	
	->A java thread is always in one of several states which could be running, sleeping, dead etc.
	
	->STATES : 
		1.New thread
		2.Runnable
		3.Not Runnable
		4.Dead		[exception generated which is not handled/ method ends] =>When it reaches at end, it cannot be run again.
	
*/

/*
	1.New thread :
		->A thread is in this state when the instantiation of a Thread object creates a new thread but does not start it running.
		->A thread starts life in the Ready-to-run state.
		->You can call only the start() or stop() methods when thread is in this state.
		->Calling any method besides start() or stop() causes an IllegalThreadStateException. (A descendant class of RuntimeException) 
		
	2.Runnable :
		->When the start() method is invoked on a new Thread() it gets to the runnable state or running state by calling the run() method.
		->A runnable thread may actually be running, or may be awaiting its turn to run.
		
	3.Not Runnable :
		->A thread becomes Not Runnable when one of the following four events occurs :
			1.When sleep() - [requreies the number of milliseconds as an argument.] method is invoked and it sleeps for a specified amount of time.
			2.Wehn suspends() method is invoked.	[this method is not used anymore/DEPRECATED.]
			3.When the wait() method is invoked and the thread waits for notification of a free resource or waits for the completion of another thread or waits to acquire a lock of an object
			4.The thread is blocking on I/O and waits for its completion.		[when user tries to input something then also it will comes in NOT RUNNABLE state]
		
	4.Dead state : 
		->A thread enters this state when the run() method has finished executing or when the stop() method is invoked. Once in this state, the thread cannot ever run again.
*/
		
/*
	Switching from not runnable to runnable
	
		->If a thread has been put to sleep, then the specifed number of milliseconds must elapse (or it must be interrupted).
		->If a thread has been suspended, then its resume() method must be invoked		//this function is also deprecated so we are not using is anymore!
		->If a thread is waiting on a condition owns the variable must relinquish it by calling either notify() or notifyAll().
		->If a thread is blocked on I/O, then the I/O must complete.
		
*/
		
