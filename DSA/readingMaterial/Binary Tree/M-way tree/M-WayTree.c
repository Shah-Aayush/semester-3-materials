/*
	M way Search Tree
	
	->M-way tree : 
		-A tree with maximum of m children is known as M-way tree. [Generalized way of representation of a tree.]
	
	->M-way Search tree : 
		-M-way search tree are generalized versions of binary search trees.
		
	->M-way search tree : 
		-An M-way search tree T may be an empty tree. If T is non empty, it satisfies the following properties : 
			1.Each node has, at most m child nodes
			2.If a node has k child node where k<=m then the node can have only (k-1) keys K1,K2,K3,...Kk-1		[didnt understand this point!]
			
	->M-way search tree : 
		-For a node A0, (K1,A1),(K2,A2),...(Km-1,Am-1) all key values in the subtree pointed to by Ai are less than the key Ki+1,0<=i<=m-2, and all key values in the subtree pointed to by Am-1 are greater than km-1.
		=Each fo subtree Ai, 0<=i<=m-1 are also m-way search tree.
		
	-Searching in M-way search tree.
	-Insertion in M-way serach tree.
	-Deletion in M-way search tree.
	
	->example : 
	MAKING
	10 60 100 200 40 120 80 90 70 170 180 190
	see picture for ans : https://youtu.be/QgD4_nIwV8w?t=960
	
	DELETION (deleting 90 and then 80)
	-FOR NO CHILD OR ONE CHILD : see picture for ans : https://youtu.be/QgD4_nIwV8w?t=1035
	-FOR TWO CHILD : see largest number in left subtree or smallest number in righ subtree 	[RECURSIVE APPROACH for deletion]
		=>Largest value among left subtree will replace the to be deleted node.
				~OR~
		=>Smallest value among right subtree will replace the to be deleted node.
		
	


*/
#include <stdio.h>
int main() {
	
}