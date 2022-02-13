/*
	THREADS PRIORITY IN JAVA
	
	->In java we can specify the priority of each thread relative to other threads
	->Those threads having higher priority get greater access to available resources then lower priority threads.
	 
	->Thread priority is inherited 
		-A java thread inherits its priority from the thread that created it.
		->PRIORITY NUMBER (by-default) : 5.
		
	->Setting thread priority 
		-You can modify a thread's priority at any time after its creation using the setPriority() method and retrive the thread priority value using getPriority() method.	[ex.: t1.setPriority(4)]
	
	->Thread Priority
		-The following static final integer constants are defined in the Thread class :
			->MIN_PRIORITY (0) Lowest Priority
			->NORM_PRIORITY (5) Default Priority
			->MAX_PRIORITY (10) Highest Priority		[can be used as t1.MAX_PRIORITY / Thread.MAX_PRIORITY]
			=>Thread.currentThread().getName();
			=>Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
			=>Thread.currentThread().getPriority();
			
		
*/
