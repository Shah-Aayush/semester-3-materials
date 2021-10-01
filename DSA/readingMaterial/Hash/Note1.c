/*
	HASH 

	->What is hashing in data structure
		-We have seen various data structures like linklist, arrays , trees etc.
		-Searching is a very frequent operation on any data structure
		
	->Searching : Time complexity
		-LinkedList : O(n)
		-Array (unsorted) : O(n)
		-Array (sorted) [Binary Search] : O(log2n)
		-Binary Search Tree : O(log2n)
		-HashTable : O(1)
	
	->Example 1
		-To store the key/value pair, we can use simple array like data structure where keys directly can be used as index to store values
	->Example 2
		-We have 10 complaints indexed with a number ranges from 0 to 9 (say complaint number)
		-We have an array of 10 spaces to store 10 complaints
		-Here we can use complaint number as key and it is nothing but index number in an array
		
	->Hashing 
		-In case when keys are large and can't be directly used as index to store value, we can use technique of Hashing
		-When key values are large and cannot be index of the arrays directly then we will use HASH function in which some formula will be used to calculate given random key value's index.When we pass the key value then it will return its index value after applying some set of formulas like x%10 or anything.and it will also use constant time so that the time complexity is still O(1).
			-In the above function if HASH function returns the same value[i.e. same index] for two different key values then it be called as COLLISION. For this, we will also apply some techniques to encounter this problem.
		-Table used for hashing is called as HASH TABLE and function which converts key values into index is called HASH FUNCTION.
		
	->TERMS
		-HASH TABLE : Mostly it is an array to store database. It is the data structure
		-HASH FUNCTION : 
			-A hash function is any function that can be used to map databset of arbitrary size to dataset of fixed size which falls into the hash table
			-The values returned by a hash function are called hash values, hash codes, hash sums, or simply hashes.
		-HASHING : In hashing, large keys are converted into small ones by using HASH FUNCTIONs and then the values are stored in data structure called HASH TABLEs.
		
		 
*/ 
#include <stdio.h>

int main(int argc, char *argv[]) {
	
}