/*
Heap
	->A heap is a tree with some special properties.
	->The basic requirement of a heap is that the value of a node must be >= (or <=) to the values of its children
	->The heap also has the additional property that all leaves should be at h or h-1 levels (where h is the height of the tree) for some h>0 (complete binary tree/almost complete binary tree as h-1 and h both can be the leaf node)
	
	->COMPLETE BINARY TREE : 
		->We will fill first left and then right node of the parent node.
		->We will fill elements level by level. 
		->We cannot procceed to further node without filling the present node's both child node.
		ex. : 22 31 43 7 6 18 9
					22
				   / \
				31		43
				/\		/\
			   7  6    18  9
			the above tree is COMPLETE BINARY TREE. [all levels must be completed(filled) including last]
			
		
		ex. : 22 31 43 7 6 18 9 11			(further adding 11...)
					22
				   / \
				31		43
				/\		/\
			   7  6    18  9
			  /
			11
			the above tree is ALMOST COMPLETE BINARY TREE.[all levels must be completed excluding last]
			->The above both tree cannot be heap as the value of child node should be greater or less than the parent node.
			
	->heap tree example : 	
					20
				    / \
				  11   15
			      /\	/
			    10  8   12
			[max heap]
		(the above tree is almost complete binary tree and heap)
		->HEAP PROPERTIES : 
			1.Almost complete binary tree
			2.node below the parent node should be either less then or greater then in entier tree.
		
	->Types of heap : 
		1.Max Heap	: root node is greater than all its child node. 
		2.Min Heap 	: root node is less than all its child node.
	
	->Representation of Heap : 
				20(0)
			    / \
			(1)11   15(2)
		      /\	   /
		  (3)10 8(4)   12(5)
		array representation : 
				0	1	2	3	4	5 
				20  11  15  10  8   12
				
	->Determine 
		-Parent of a node
			child node index : x(it can be left child or right child)
			=>PARENT node index from child node index : (x-1)/2 
		-Children of a node
			parent node index : x
			=>CHILD node index from parent node index : 
				1.Left child : 2x + 1
				2.Right child : 2x + 2
	
->INSERTION AND DELETION IN A HEAP 
	->Insertion in a Heap 	[consider max heap here]
					20
				    / \
				  11   15
			      /\	/
			    10  8  12
		adding 21 ...
					20
				    / \
				  11   15
			      /\	/ \
			    10  8  12  21
			-made it complete binary tree (we want to make it complete binary tree if it is still almost complete binary tree then no issue for that)
			-but here after adding 21 and making it as complete binary tree, our tree is not heap now. 
			-Now for balancing it we have to sort it and make it heap so that we will check the parent node of this added new node.
				=>swap if parent node is smaller then the new node =>swap(a[(i-1)/2] , a[i]). => swap(parent node, new node);
				->THIS PROCESS IS RECURSIVE 
			->the above process is called HEAPIFY which means that adjusting the whole heap tree after addition or deletion of one node.
			
			
			
	->Deletion in Heap : 
			20
		    / \
		  11   15
	      /\	/
	    10  8  12
		->we want to delete 20 [only max element which is root node is to be deleted in the deletion]
		->data = 20.	[assiging the value of root node to the variable data]
		->in the root node, the last value in the heap array is assigned
			0	1	2	3	4	5 
			12  11  15  10  8   -
			
			data = 20;
		->Now adjusting the whole heap tree : 
			(if the parent node is smaller then child node)
			the node among the children node of parent node 12, which is greater (here among 11 and 15, 15 is greater) will be the parent node.
			children node among index : 2*i+1 and 2*i+2, where i is the parent index.
			which is greater then other will be parent node. and swapping it with the parent node.
			0	1	2	3	4	5 
			15  11  12  10  8   -
			->This is recursive process
			
		
	
*/
#include <stdio.h>
void swap(int *x, int *y){
	int temp = *x;
	*x = *y;
	*y = temp;
}
void heapify(int arr[], int n, int i){
	int largest = i;		//largest as root
	int l = 2*i + 1;		//left child index
	int r = 2*i + 2;		//right child index
	
	if(l<n && arr[l]>arr[largest])
	largest = l;
	if(r<n && arr[r]>arr[largest])
	largest = r;
	//if right or left child is greater then the root/parent node
	 if(largest!=i){	//if largest is changed then the starting initialization
		swap(&arr[i], &arr[largest]);
		heapify(arr, n, largest);	//recursively heapify the affected sub-tree
	}			
}
int deleteRoot(int arr[], int n){
	n--;
	int lastElement = arr[n];
	arr[0] = lastElement;
	heapify(arr, n, 0);
	return (n);
}
void printArray(int arr[], int n){
	for(int i=0;i<n;i++)
	printf("%d ",arr[i]);
	printf("\n");
}
int main() {
	int arr[] = {10,5,3,2,4};
	int n = sizeof(arr)/sizeof(arr[0]);
	printArray(arr, n);
//	printf("%d\n",n);
//	n--;
	n = deleteRoot(arr, n);
//	printf("%d\n",n);
	printArray(arr, n);
	
	return 0;
}