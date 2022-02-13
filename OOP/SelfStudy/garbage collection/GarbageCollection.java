/*
Garbage Collection in Java
			
	How memory is managed with new and delete keywords in C++
	
	-Objects that are created dynamically have no name
	
//	Student *p = new Student();
	-use of 'new' keyword -> dynamic allocation 	[remains till program ends]
	-not use of 'new' keyword -> static allocation [this will only work in that specific block]
	
	->We have two blocks for memory allocation in our program code.
		1.Free block
		2.Consumed block
		
		=>creating an object and assiging it to a variable in some function will work fine until the function closed but after the function ends the free block's memory which is consumed by consume block, which have to release so this can be done by garbage collection as variable is destroyed so allocation to the memory to it also have to be destroy!	[avoiding memory leak]
		-In c++, we have to delete the memory by using delete keyword but in java as we have only one option of using new keyword, the memory will be deleted automatically by garbage collection
	
	->In java,
		-In java destruction of object from memory is done automatically by the JVM.
		-No delete keyword in java.
		-When there is no reference to an object, then that object is assumed to be no longer needed and the memory occupied by the object are released.
		-This technique is called Garbage Collection.
		-This is accomplished by the JVM.
		
		-If a object is not referred by anyone then it is called Garbage Block.
	
	->JVM threads 
		-Whenever you run a java program, JVM creates threads
			-main thread
			-thread scheduler
			-Garbage collector thread
		-In these three threads, main thread is a user thread and remaining two are daemon threads which run in background.
				
	
	
		
*/
class GarbageCollection {
	public static void main(String[] args) {
		
	}
}