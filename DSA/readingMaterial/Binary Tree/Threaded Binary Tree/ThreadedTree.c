/*
	Threaded Binary Tree
	
	->Threre are two types of threaded binary trees
		-Single threaded
		-Double threaded
	->Single Threaded : Where a NULL right pointers is made to point to the inorder successor (if successor exists) 
	-Double Threaded : Where both left and right NULL pointers are made to point to inorder predecessor and inorder successor respectively.
	[not necessory that it must be binary tree. It can be any tree.]
	
	->Threaded BT : 
		-In a simple threaded binary tree, the NULL right pointers are used to store inorder successor
		-Where-ever a right pointer is NULL, it is used to store inorder successor.
		 
	->Structure for threaded BT
		struct Node{
			int key;
			struct Node *left,*right;
			bool isThreaded;
		};
		
		'isThreaded' is used to indicate whether the right pointer is a normal right pointer or a pointer to inorder successor. 
		
	 ->Benefits of Threaded binary tree
		-The idea of threaded binary tree is to make inorder traversal faster and do it without stack and without recursion.
		
	
	
*/
#include <stdio.h>
int main() {
	
}