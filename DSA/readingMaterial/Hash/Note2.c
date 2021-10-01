/*
	HASH FUNCTION : 
		-A hash function usually means a function that compresses, meaning the output is shorter than the input.
		-A hash function is any function that can be used to map data of arbitrary size to data of fixed size.
		
	->Parameters of good hash function
		-Easy to compute
		-Even distribution
		-Minimize Collision
		
	->Perfect Hashing
		-Perfect hashing maps each valied input to a different hash value (no collision) : Hypothetical | VARY RARE 
	
		-Division,folding,mid-square,modulo- multiplication methods are used for HASH function
	->Hash function example 1 [division]
		int hash(int x){
			
			return (x%10);
		}
	
	-Hash function example 2 [BINNING/maybe folding]
		-We are given keys in the range 0 to 999, and have a hash table of size 10
			- 0-99 	  slot 0
			- 100-199 slot 1
			- 200-299 slot 2
			- 300-399 slot 3
				...
			- 900-999 slot 9
	
	-Hash function example 3	[MID SQUARE METHOD]
		-A good hash function to use with integer key values is the mid-square method
		-The mid-square method squares the key value, and then takes out the middle r bits of the result, giving a value in the range 0 to 2^r -1
		
		like : 
		1028 ->SQUARE: 1056784 ->MIDDLE VALUE : 6
		2056 ->SQUARE: 4227136 ->MIDDLE VALUE : 7	[we can take more than one values or whatever digits we want ... as per our memory slots]
		
	-Hash function example 4	[String as key value]
		int hash(char s[],int m){
			int i, sum=0;
			for(i=0;s[i];i++)
				sum = sum + s[i];
			return (sum%m);	//well you can understand by seeing this as m can be/must be the number of memory slots
		 }
		
		
	
		
*/
#include <stdio.h>

int main(int argc, char *argv[]) {
	
}