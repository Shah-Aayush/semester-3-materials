/*
AAYUSH SHAH - 19BCE245
DEFINITION : A game of cards is played between 4 players. One by one cards out of 52 gets distributed to the each player. Card distribution is random Each player takes card one by one and arrange them sequentially in the hand. Even if we see after 5 cards, sequence can be observed. Once the game starts, a single card is taken out from the sequence. However if we see them again on hand, they maintain ascending or descending sequence. In order to keep cards sequentially in data which particular mechanism can be helpful and how. Implement the given model.  
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

struct Node{		//An AVL tree node
	int key;
	struct Node *left;
	struct Node *right;
	int height;
};

int max(int a, int b){		//A utility function to get maximum of two integers
	return (a>b)?a:b;
}

int height(struct Node *N){		//A utility function to get height of the tree
	if(N==NULL)
		return 0;
	return N->height;
}

struct Node* newNode(int key){
	struct Node *node = (struct Node*)malloc(sizeof(struct Node));
	node->key = key;		//assigning value
	node->left = NULL;
	node->right = NULL;
	node->height = 1;		//because new node is initially added at leaf
	
	return (node);
}

//right rotation : A utility functjon to right rotate subtree rooted with y.
struct Node *rightRotate(struct Node *y){
	struct Node *x = y->left;
	struct Node *T2 = x->right;
	
	//Performoing rotation
	x->right = y;
	y->left = T2;
	
	//Updating heights
	y->height = max(height(y->left), height(y->right)) + 1;
	x->height = max(height(x->left), height(x->right)) + 1;
	
	return x;		//returning new root
}

// Left rotate : A utility function to left rotate subtree rooted with x.
struct Node *leftRotate(struct Node *x) {
	struct Node *y = x->right;
	struct Node *T2 = y->left;
	
	//Performing rotation
	y->left = x;
	x->right = T2;
	
	//Updating heights
	x->height = max(height(x->left), height(x->right)) + 1;
	y->height = max(height(y->left), height(y->right)) + 1;
	
	return y;		//returning new root
}

// A utility function to Get the balance factor of node N
int getBalance(struct Node *N) {
	if (N == NULL)
		return 0;
	return height(N->left) - height(N->right);
}

// Insert node
struct Node *insertNode(struct Node *node, int key) {
	//1. Performing the normal BST rotation.
	// Find the correct position to insertNode the node and insertNode it
	if (node == NULL)
		return (newNode(key));
	
	if (key < node->key)
		node->left = insertNode(node->left, key);
	else if (key > node->key)
		node->right = insertNode(node->right, key);
	else		//as equal keys are not allowed.
		return node;
	
	//2. Updating height of this ancestor node
	node->height = 1 + max(height(node->left),
		height(node->right));
	
	//3.Getting the balance factor of this ancestor node to check whether this node became unbalanced
	int balance = getBalance(node);
	
	//If this node becomes unbalanced, then there are 4 cases :
	
	//Left-Left case
	if (balance > 1 && key < node->left->key)
		return rightRotate(node);
	
	//Right-Right case
	if (balance < -1 && key > node->right->key)
		return leftRotate(node);
	
	//Left-Right case
	if (balance > 1 && key > node->left->key) {
		node->left = leftRotate(node->left);
		return rightRotate(node);
	}
	
	//Right-Left case
	if (balance < -1 && key < node->right->key) {
		node->right = rightRotate(node->right);
		return leftRotate(node);
	}
	
	return node;		//returning the unchanged node pointer
}

//A utility function to get the minimum key value node which can be found in the given non-empty binary search tree. We dont need to search entire binary search tree.
struct Node *minValueNode(struct Node *node) {
	struct Node *current = node;
	
	while (current->left != NULL)
		current = current->left;
	
	return current;
}

//Deletion : A utility function to delete a node with given key fromm subtree with given root which returns root of the modified subtree.
struct Node *deleteNode(struct Node *root, int key) {
	
	//1. Performing standard BST deletion
	if (root == NULL)
		return root;
	
	//If the key to be deleted is smaller than the root's key, then it lies in left subtree
	if (key < root->key)
		root->left = deleteNode(root->left, key);
	
	//If the key to be deleted is greater than the root's key, then it lies in right subtree
	else if (key > root->key)
		root->right = deleteNode(root->right, key);
	
	//If key is same as root's key , then this is the node to be deleted.
	else {
		if ((root->left == NULL) || (root->right == NULL)) {		//node with only 1 child or no child
			struct Node *temp = root->left ? root->left : root->right;
			
			if (temp == NULL) {		//No child case
				temp = root;
				root = NULL;
			} else		//One child case
				*root = *temp;		//copying the contents of the non-empty child into root
			free(temp);		//deallocate the memory
		} else {		//Node with two children
			struct Node *temp = minValueNode(root->right);		//getting the inorder successor which is smallest in the right subtree
			
			root->key = temp->key;		//copying the inorder successor's data to this node.
			
			root->right = deleteNode(root->right, temp->key);		//Deleting the inorder successor.
		}
	}
	
	if (root == NULL)		//If the tree had only one node then returning
		return root;
	
	// 2. Updating the height of the current node
	root->height = 1 + max(height(root->left),
		height(root->right));
	
	// 3.getting the balance factor of this node to check whether this node became unbalanced
	int balance = getBalance(root);
	
	//If this node becomes unbalanced, then there are 4 cases :
	
	//Left-Left case
	if (balance > 1 && getBalance(root->left) >= 0)
		return rightRotate(root);
	
	//Left-Right case
	if (balance > 1 && getBalance(root->left) < 0) {
		root->left = leftRotate(root->left);
		return rightRotate(root);
	}
	
	//Right-Right case
	if (balance < -1 && getBalance(root->right) <= 0)
		return leftRotate(root);
	
	//Right-Left case
	if (balance < -1 && getBalance(root->right) > 0) {
		root->right = rightRotate(root->right);
		return leftRotate(root);
	}
	
	return root;	//returning the root
}

//Print : utility function to print preorder traversal of the tree.
void printPreOrder(struct Node *root) {
	if (root != NULL) {
		printf("%2d ", root->key);
		printPreOrder(root->left);
		printPreOrder(root->right);
	}
}
void printInOrder(struct Node *root) {
	if (root != NULL) {
		printInOrder(root->left);
		printf("%d ", root->key);
		printInOrder(root->right);
	}
}

void generateRandomList(int list[]){
	srand(time(0));		//This will help to generate random numbers every time you compile.
	for (int i = 0; i < 52; i++) {		//just suffling at each random number generated index.
		int j = i + rand() % (52 - i);
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
}

void printDetails(){
	for (int i=0; i<52; i++) {
		printf("Card No.: %2d\t",i+1);
		
		if(i%13==0)
			printf("Ace   of ");
		else if(i%13==10)
			printf("Jack  of ");
		else if(i%13==11)
			printf("Queen of ");
		else if(i%13==12)
			printf("King  of ");
		else 
			printf("%5d of ",(i%13)+1);

		if(i>=0 && i<13)
			printf("Speads   suit.\n");
		else if(i>=13 && i<26)
			printf("Hearts   suit.\n");
		else if(i>=26 && i<39)
			printf("Clubs    suit.\n");
		else
			printf("Diamonds suit.\n");
	}
}
void playGame(){
	int i,j;
	
	int list[52];		//list of cards
	
	for (i = 0; i < 52; i++) {		//assiging number to every card from 1 to 52.
		list[i] = i+1;
	}
	//assiging (random cards) deck to all players
	generateRandomList(list);
	
	//Assuming there are four players. (we can change the player number also!)
	struct Node *root1 = NULL;
	struct Node *root2 = NULL;
	struct Node *root3 = NULL;
	struct Node *root4 = NULL;	
	
	for(i=0;i<52;i++){
		if(i%4==0)
			root1 = insertNode(root1, list[i]);
		else if(i%4==1)
			root2 = insertNode(root2,list[i]);
		else if(i%4==2)
			root3 = insertNode(root3,list[i]);
		else
			root4 = insertNode(root4, list[i]);
		
	}
	
	printf("Alloted decks at starting : \n");
	printf("Player 1 : ");
	printInOrder(root1);
	printf("\n");
	printf("Player 2 : ");
	printInOrder(root2);
	printf("\n");
	printf("Player 3 : ");
	printInOrder(root3);
	printf("\n");
	printf("Player 4 : ");
	printInOrder(root4);
	
	for(i=0;i<52/4-1;i++){
		printf("\n\nAfter round %d\n",i+1);
		root1 = deleteNode(root1, root1->key);
		root2 = deleteNode(root2, root2->key);
		root3 = deleteNode(root3, root3->key);
		root4 = deleteNode(root4, root4->key);
		printf("Player 1 : ");
		printInOrder(root1);
		printf("\n");
		printf("Player 2 : ");
		printInOrder(root2);
		printf("\n");
		printf("Player 3 : ");
		printInOrder(root3);
		printf("\n");
		printf("Player 4 : ");
		printInOrder(root4);
	}
	
	printf("\nGame ended :)\n");
}

int main() {		//MENU DRIVEN
	
	printf("***AAYUSH SHAH - 19BCE245***\n");
	printf("***** Card Game : DSA ******\n");
	
	int choice = 0;
	while(choice!=3){		
		printf("\nMENU : \n");
		printf("[1.] See cards naming convention (press 1)\n");
		printf("[2.] Play Game (press 2)\n");
		printf("[3.] Exit (press 3)\n");
		printf("ENTER CHOICE : ");
		scanf("%d",&choice);
		switch (choice) {
			case 1:
				printDetails();
				break;
			case 2:
				playGame();
				break;
			case 3:
				printf("*** THANK YOU ***");
				break;
			default:
				printf("Invalid Chioce :(\n");
		}
	}
	
	return 0;
}