/*
BINARY TREE

What is tree : 
	->A tree is a hierarchical data structure.
	->A tree is defined as a finite set of one or more date items (node) such that 
		1.There is a special node called the root of the tree.
		2.The remaining nodes are partitioned into n>=0 disjoint subsets, each of which is itself a tree, and they are called sub-trees.
	
More Terminologies : 
	Degree : The number of sub-trees of a node is called its degree.
	Leaf : A node with degree zero is called leaf.
		-Terminal Nodes : The leaf nodes are also called terminal nodes.
	Degree of Tree : The degree of the tree is maximum degree of the nodes in the tree.	
	Ancestors : The ancestors of a node are all the nodes along the path from the root to that node.
	Descendants : The descendants of a node are all the nodes along the path from node to terminal node.
	Level Number : Each node is assigned a level number. The root node of the tree is assigned a level number 0. Every other node assign a level number which is 1 more than the level number of its parent.
	Generation : Nodes with the same level number are said to belong to the same generation.
	Height/Depth : The height or depth of a tree is the maximum number of nodes in a branch.
	Edge : A line drawn from a node N of T to a successor is called an edge.
	Path : Sequence of consecutive edges is called path.
		-Path can be from any node to any node.
	Branch : Path ending is a leaf is called a Branch.
		-Ending of branch must be a leaf.
*/

/*
ACTUAL BINARY TREE
What is Binary Tree : 
	->A binary tree T is defined as a finite set of elements, called nodes, such that 
		1.T is empty(called the null tree or empty tree) or
		2.T contains a distinguished node R, called the root of T, and the remaining nodes of T from an ordered pair of disjoint binary trees T1 and T2.	[ONLY TWO]
	-[above defination is recursive defination]
	-At most two subtrees
	-highest degree possible of any node : 2
	->The root of T is the node A at the top of the diagram.
	->A left downward slanted line from a node N[any node] indicates a left successor of N, and a right downward slanted line from N indicates a right successor of N.
	->The definition of binary tree is recursive since T is defined in terms of the binary subtrees T1 and T2. This means, in particular that every node N of T contains a left and a right subtree.[which means that if a condition is applied on T then it will also applied to its subtrees T1 and T2]
->BINARY TREE TYPES : 
	1.Complete Binary Tree
		->A complete binary Tree is defined as a binary tree whose non leaf nodes have non empty. left and right sub-tree and all leaves are at the same level.
		->Every level is filled.
					*
				   / \
				  *	  *
				 / \ / \
				*  * *  *
	2.Almost Comlete Binary Tree : 
		->A complete binary Tree is defined as a binary tree whose non leaf nodes have non empty left and right sub-tree and all leaves are either at the last level or second last level.
						*
					   / \
					  *	  *
					 / \ / \
					*  * *  *
				   / \ /
				  *  * *
	3.Strict Binary Tree : 
		->A binary tree is called a strictly binary tree is every non leaf node in the binary tree has non empty left and right subtree.
		->It means each node will have either 0 or 2 children.
						*
					   / \
					  *	  *
					 / \ / \
					*  * *  *
				      / \
				     *   * 
		->there is no node which has only 1 child.
	4.Extended Binary Tree :
		->An extended binary tree is a tree that has been transformed into a full binary tree.
		->This transformation is achieved by inserting special "External" nodes such that every "internal" node has exactly two children.
		->SIMPLY, Strictly binary tree is converted into complete binary tree.
*/

/*
Representation of BT
	There are two possible representation of binary tree : 
		1.Array representation 
		2.LinkedList Representation	[this is not linear list,will be used via pointers]
	Condition for any representation :
		-One should have direct access to the root R of T
		-Any node N of T, one should have direct access to the children of N.
	
	->Node structure : 
		->Linked Representation : 
			-Info is any information 
			-Left and right are pointers to child nodes.
			finlly , node has left[pointer], info[variable which will contain data], right[pointer].
	->Root
		-root is a node pointer variable to point root node of the tree.
		-when root contains NULL, tree is empty.
	
	->Structure to represent a binary tree:
		struct BinaryTreeNode{
			int info;
			struct BinaryTreeNode *left;
			struct BinaryTreeNode *right;
		};
		
*/

/*
Traversing Binary Tree	[visiting every node of tree for any reason]
	->Preorder : 
		-Process the root R
		-Traverse Left subtree of R in preorder
		-Traverse Right subtree of R in preorder
	->Inorder : 
		-Traverse Left subtree of R in inorder
		-Process the root R
		-Traverse Right subtree of R in inorder
	->Postorder : 
		-Traverse Left subtree of R in postorder
		-Traverse Right subtree of R in postorder
		-Process the root R
		
		
1.PREORDER TRAVERSAL	
			root
			  |
			node 1
			  /    \
		node 2    node 3
		/\			 /   \			
  node 4  node 5  node 6   node 7

1 LST RST 				[LST : Left sub tree]
root LST RST 				[LST : Left sub tree]
1 2 4 5 RST
1 2 4 5 3 6 7			<-this is preorder traversal

	->RECURSIVE APPROACH : 
	void preOrder(struct BinaryTreeNode *root){
		if(root){			//if root has NULL then this block won't be executed 
			printf("%d",root->info);
			preOrder(root->left);
			preOrder(root->right);
		}
	}

2.INORDER TRAVERSAL
			root
			  |
			node 1
			  /    \
		node 2    node 3
		/\			 /   \			
  node 4  node 5  node 6   node 7

LST 1 RST
4 2 5
4 2 5 1
4 2 5 1 6
4 2 5 1 6 3 7

	void inOrder(struct BinaryTreeNode *root){
			if(root){			//if root has NULL then this block won't be executed 
				inOrder(root->left);
				printf("%d",root->info);
				inOrder(root->right);
			}
		}
		
		
3.POSTORDER TRAVERSAL
			root
			  |
			node 1
			  /    \
		node 2    node 3
		/\			 /   \			
  node 4  node 5  node 6   node 7

LST RST 1
//LST RST root
4
4 5 2
4 5 2 6
4 5 2 6 7 
4 5 2 6 7 3 
4 5 2 6 7 3 1 


	void postOrder(struct BinaryTreeNode *root){
			if(root){			//if root has NULL then this block won't be executed 
				postOrder(root->left);
				postOrder(root->right);
				printf("%d",root->info);
			}
		}
		
*/

/*
LEVEL ORDER TRAVERSAL 
	->addresses are shown in brackets
			root
			  |
			node 1[1000]
			  /    \
		node 2[2000]    node 3[3000]
		/\					 /   \			
node 4[4000] node 5 [5000] node 6[6000]   node 7[7000]

-traversing level by level
-at one time traversing through all nodes at that level
1
1 2 3
1 2 3 4 5 6 7 

	ALGO
	->Visit the root.
	->While traversing level L, keep all the elements at level L+1 in queue.
	->Go to the next level and visit all the nodes at that level.
	->Repeat this until all levels are completed.

void levelOrder(struct BinaryTreeNode *root){
	struct BinaryTreeNode *temp;
	struct Queue *Q = createQueue();	//will also enter size 
	if(!root)
	return;
	enQueue(Q,root);
	while(!isEmptyQueue(Q)){
		temp = deQueue(Q);
		printf("%d ",temp->info);
		if(temp->left)
		enQueue(Q,temp->left);
		if(temp->right)
		enQueue(Q,temp->right);
	}
	deleteQueue(Q);
}
*/

/*
BINARY SEARCH TREE

	->In Binary Search Tree, all the left subtree elements should be less than root data and all the right subtree elements should be greater than root data.This is called binary search tree property.
	
	->This property should be satisfied at every node in the tree.
			root
			  |
			  25	
		    /    \
		  12.    35.
		/\	    /   \			
 	   4.  15  30    40 

	->structure to represent a BST
	struct BSTNode{
		int info;
		struct BSTNode *left;
		struct BSTNode *right;
	};
	
	->Elementary Operations :
		-Find
		-Insertion
		-Deletion
	
*/

/*
	Double Ended Queue
	
	->What is Queue : 
		-In Queue, the order in which the data arrives is important.
		-Queue is a line of items waiting to be served in sequential order.
		-A queue is an ordered list in which insertions are done at one end (rear) and deletions are done at other end (front)
		-Working principle is First in First Out (FIFO)
	
	->Double Ended Queue
		-When insertion and deletion can be performed at both ends, it is double ended queue.
		
*/

/*
FIND ELEMENT IN BINARY SEARCH TREE

struct BSTNode* Find(struct BSTNode *root, int data){
	
	if(root == NULL)	//if tree is empty
	return (NULL);
	
	if(data<root->data)
	return(Find(root->left,data));
	else if(data>root->data)
	return(Find(root->right,data));
	
	return (root);
	
//	return (NULL);		//if no element is matched with data. 		
	//the last line is not needed because if there is no element is matched with data then whether it is greater or smalled than the data, it will go in left or right pointer which will also return NULL if there is no element matched !
}

*/

/*
DELETION :
	->Three cases : 
		1.If the element to be deleted is a leaf node.
			->Deletion is simple if we are deleting a leaf node
		2.if the element to be deleted has one child.
		3.if the element to be deleted has both children.
		
1.If the element to be deleted is a leaf node 
	  6
	2 	8
   1 *5*
		->5 is the element to be deleted
	->parent node -> right/left = NULL

2.if the element to be deleted has one child.	
	->parent node -> right/left = node->right/left
		
3.if the element to be deleted has both children.
	->the node which is to be deleted has 2 nodes then we have to find the max element from the left child's sub tree and delete that node from original position and put it into the place of the main node which has to be deleted.
	->for deleting the max node we have to perform the same deletion operation like this.
		->the max node will always have only one node as it is the max node.[no node of it will have value greater than that max node as it is the max node]
		->so this will the one child node operation.	
*/
		#include "stdio.h"
		#include "stdlib.h"
struct BSTNode{
	int data;
	struct BSTNode *left;
	struct BSTNode *right;
};
struct BSTNode* Delete(struct BSTNode *root, int data){
	if(root == NULL){	//if tree is empty
		printf("No such element is exists :(\n");
	}	
	else if(data<root->data){	//if element to be deleted is in the left subtree ->then go to the left subtree
		root->left = Delete(root->left, data);
	}
	else if(data>root->data){	//if element to be deleted is in the right subtree ->then go to the right subtree
		root->right = Delete(root->right, data);
	}
	else{	//if element is found, which is same as data, which to be deleted.
		struct BSTNode *temp;
		if(root->left!=NULL && root->right!=NULL){		//if root has both child
			temp = findMax(root->left);	//will find the max data
			root->data = temp->data;
			root->left = Delete(root->left, root->data);
		}
		else{	//if root has only one child or no child
			temp = root;
			if(root->left==NULL)
			root = root->right;
			else if(root->right==NULL)
			root = root->left;
			free(temp);
		}
		return(root);
	}
}
struct BSTNode* findMax(struct BSTNode* root){
	//method 1 :
		//if(root->right!=NULL)
		//root = findMax(root->right);
	//method 2 : 
		while(root->right!=NULL)
		root = root->right;
	return root;
}
struct BSTNode* findMin(struct BSTNode* root){
	//method 1 :
		//if(root->left!=NULL)
		//root = findMax(root->left);
	//method 2 : 
		while(root->left!=NULL)
		root = root->left;
	return root;
}
/*
	
*/