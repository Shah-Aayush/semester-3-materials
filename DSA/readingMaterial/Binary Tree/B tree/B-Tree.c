/*
	B Tree  
	[m means atmost m children possible]
		
	->B tree is a special case of M-way search tree
	->B tree of order M satisfies the following properties
		-Each node has atmost m children
		-Each internal nodes has atleast ceiling of m/2 children
		-Root node has at least 2 children if it is not leaf
		-A non leaf node with k children has k-1 keys.
		-All leaf nodes appear in the same level.
	
	->Operations
		-Insertion		[when searching stops there we have to insert.]
		-Searching
		-Deletion
		
	->Example : https://youtu.be/i_7BPByPRXU?t=558
	
	->In insertion we dont open new child node. we just break the searched node and splits it into parts and middle value after the new node is added (when overflow : more elements then space.) the middle value get into upper side.If the condition of minimum children is not satisfied then we have to shift (that separeted and made new parent node) into its parent node.
	
	
*/
#include <stdio.h>
int main() {
	
}