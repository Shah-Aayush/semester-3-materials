/*
A game of cards is played between 4 players. One by one cards out of 52 gets distributed to the each player. Card distribution is random Each player takes card one by one and arrange them sequentially in the hand. Even if we see after 5 cards, sequence can be observed. Once the game starts, a single card is taken out from the sequence. However if we see them again on hand, they maintain ascending or descending sequence. In order to keep cards sequentially in data which particular mechanism can be helpful and how. Implement the given model.  
*/
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>

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
		printf("%d ", root->key);
		printPreOrder(root->left);
		printPreOrder(root->right);
	}
}

//void generateRandom(int deck[]){
//	
//}

int main() {
	//2,3,4,
	int players;
	printf("How many players are there ? : ");
	do {
		scanf("%d",&players);
		if(players<2 || players>17)
			printf("Please enter players between 2 to 17 : ");
	} while (players<2 || players>17);		//If there is more than 17 players then is no meaning of game since some players might have less then 3 cards which means we cannot show sorting/rotation of AVL BST tree
		
	printf("test\n");
	
	struct Node root[players];
	memset(root, '\0', sizeof(root));		//initializing all root/deck as null
	
	printf("test\n");
	
	//assiging (random cards) deck to all players
	int NumberOfCardsUsedInGame = 52-(52%players);
	int count=0;
	int list[52][2];		//list of cards
	for (int i = 0; i < 52; i++) {		//assiging number to every card from 1 to 52.
		list[i][0] = i+1;
		list[i][1] = 0;
	}
	
	printf("test\n");

	struct Node *root1 = NULL;
	struct Node *root2 = NULL;
	struct Node *root3 = NULL;
	struct Node *root4 = NULL;
	
//	srand(time(0));
	int j;
	
	for(int i=0;i<52;i++){
		
		//generating unique random number
		srand(time(0));
		do {
//			srand(time(0));
			j = i+ rand() % (52-i);
		} while (list[j-1][1] == 1);
		list[j-1][1] = 1;
//		int j = i+ rand() % (52-i);
//		int temp = list[i];
//		list[i] = list[j];
//		list[j] = temp;
		printf("i=%d | j=%d\n",i,j);
		if(i%4==0)
		root1 = insertNode(root1, j);
		else if(i%4==1)
		root2 = insertNode(root2,j);
		else if(i%4==2)
		root3 = insertNode(root3,j);
		else
		root4 = insertNode(root4, j);
//		root[count%players] = *insertNode(&root[count%players], j);		//assiging it as a card to each player.
//		count++;
	}
	
	printf("test\n");

	
	printPreOrder(root1);
	printf("\n");
	printPreOrder(root2);
	printf("\n");
	printPreOrder(root3);
	printf("\n");
	printPreOrder(root4);
	
	return 0;
}

/*
VALUEs and Types : 
-1 to 13 : Spades
-14 to 26 : Hearts
-27 to 39 : Clubs
-40 to 52 : Diamonds

-Let us assume that the person which has maximum points in the end is the winner.
->We are assuming that :each card's value can be determined by = spades has 4 points, heart has 3 points, clubs has 2 points and diamond has 1 point. + its value. (Ace has 1 value, 2 has 2 value, 3 has 3 value, ... jack  has 11 value, queen has 12 value and king has 13 value.)

*/


/*
VALUES AND THEIR TYPES/CARD NAMES

1 : Ace of Speads suit.
2 : 2 of Speads suit.
3 : 3 of Speads suit.
4 : 4 of Speads suit.
5 : 5 of Speads suit.
6 : 6 of Speads suit.
7 : 7 of Speads suit.
8 : 8 of Speads suit.
9 : 9 of Speads suit.
10 : 10 of Speads suit.
11 : Jack of Speads suit.
12 : Queen of Speads suit.
13 : King of Speads suit.
14 : Ace of Hearts suit.
15 : 2 of Hearts suit.
16 : 3 of Hearts suit.
17 : 4 of Hearts suit.
18 : 5 of Hearts suit.
19 : 6 of Hearts suit.
20 : 7 of Hearts suit.
21 : 8 of Hearts suit.
22 : 9 of Hearts suit.
23 : 10 of Hearts suit.
24 : Jack of Hearts suit.
25 : Queen of Hearts suit.
26 : King of Hearts suit.
27 : Ace of Clubs suit.
28 : 2 of Clubs suit.
29 : 3 of Clubs suit.
30 : 4 of Clubs suit.
31 : 5 of Clubs suit.
32 : 6 of Clubs suit.
33 : 7 of Clubs suit.
34 : 8 of Clubs suit.
35 : 9 of Clubs suit.
36 : 10 of Clubs suit.
37 : Jack of Clubs suit.
38 : Queen of Clubs suit.
39 : King of Clubs suit.
40 : Ace of Diamonds suit.
41 : 2 of Diamonds suit.
42 : 3 of Diamonds suit.
43 : 4 of Diamonds suit.
44 : 5 of Diamonds suit.
45 : 6 of Diamonds suit.
46 : 7 of Diamonds suit.
47 : 8 of Diamonds suit.
48 : 9 of Diamonds suit.
49 : 10 of Diamonds suit.
50 : Jack of Diamonds suit.
51 : Queen of Diamonds suit.
52 : King of Diamonds suit.

*/