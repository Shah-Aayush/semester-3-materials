/*
	Collision resolution in Hashing data structure
		
	->Collision
		-A situation when the resultant hashes for two or more data elements in the data set, maps to the same location in the hash table, is called a hash collision.
		-In such a situation two or more data elements would qualify to be stored / mapped to the same location in the hash table.
	
	->Hash collision resolution 
		-Two types of collision resolution:
			1.Open Hashing (Chaining)
			2.Closed Hashing (Open Addressing)
		-The difference between the two has to do with
			-Whether collisions are stored outside the table (Open Hashing), or
			-Whether collisions result in storing one of the records at another slot in the table (closed hashing).
		
	->OPEN HASHING : 	[CLOSED ADDRESSING] : chaining method
		-The simplest form of open hashing defines each slot in the hash table to be the head of a linked list.
		-All records that hash to a particular slot are placed on that slot's linked list.
		=>In this type whenever collision occurrs, then we will make a simple LinkedList in which the head pointer will be the first cell of hashtable itself.
	
	->CLOSED HASHING	[OPEN ADDRESSING] : linear, quardratic, double hashing
		->Linear Probing[probing : collecting facts/inspecting]	=>Checking linearly : i+1,i+2,i+3,...
		->Quadratic Probing		=>Checking linearly : i+1,i+4,i+9,,i+16,i+25,...[square of next number]
		->Double Hashing	=> selecting random number and adding it leanerly : like i+5,i+10,i+15,i+20,...
		
		-we will put the data in the same table.
		
	->DEFINITION : 
		where Ki is the value and u is the location of that value and m is the size of memory slots.
		->Linear probing : 
			-Insert Ki at first free location from (u+i)%m where i = 0 to (m-1).
		->Quadratic probing : 
			-Insert Ki at first free location from (u+i^2)%m where i = 0 to (m-1).
		->Double hashing : 
			-Insert Ki at first free location from [u+(v*i)]%m where i = 0 to (m-1).
			-where v = [h2(k)%m]
			-ex.: h1(k) = 2k+3	[from this we can obtain u = h1(k)%m ]
			-ex.: h2(k) = 3k+1 [from this we can obtain v = h2(k)%m ]
*/
#include <stdio.h>

int main(int argc, char *argv[]) {
	
}