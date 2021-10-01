/*
Write a program to implement phone book dictionary using Binary Search Tree which provides following operations: (a) add new entry in phone book, (b) remove entry from phone book, (c) search phone number (d) list all entries in ascending order of name and (e) list all entries in descending order of name.
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct Node{
	char name[20];
	long long int phoneNumber;
	
	struct Node *left;
	struct Node *right;
	int height;
};
int max(int a,int b){
	return ((a>b)?a:b);
}
int height(struct Node *N){
	if(N==NULL)
		return 0;
	return N->height;
}
struct Node* newNode(char name[],long long int phoneNumber){
	struct Node* node = (struct Node*)malloc(sizeof(struct Node));
	strcpy(node->name,name);
	node->phoneNumber = phoneNumber;
	node->left = NULL;
	node->right = NULL;
	node->height = 1;
	return (node);
}
struct Node* rightRotate(struct Node *y){
	struct Node *x = y->left;
	struct Node *xR = x->right;			//xR = x's Right child
	
	x->right = y;
	y->left = xR;
	
	y->height = max(height(y->left),height(y->right)) + 1;
	x->height = max(height(x->left),height(x->right)) + 1;
	
	return x;
}
struct Node* leftRotate(struct Node *y){
	struct Node *x = y->right;
	struct Node *xL = x->left;			//xL = x' Left child
	
	x->left = y;
	y->right = xL;
	
	y->height = max(height(y->left),height(y->right)) + 1;
	x->height = max(height(x->left),height(x->right)) + 1;
	
	return x;
}
int getBalance(struct Node *N){
	if(N==NULL)
	return 0;
	return (height(N->left) - height(N->right));
}
struct Node* insert(struct Node* node, long long int phoneNumber, char name[]){
	
	if(node == NULL)
	return (newNode(name,phoneNumber));
	
	if(strcmp(name, node->name)<0)
		node->left = insert(node->left,phoneNumber,name);
	else if(strcmp(name, node->name)>0)
		node->right = insert(node->right,phoneNumber,name);
	else{
		printf("This contact name is already exists :(\n");
		return node;
	}
	
		//updating height
		node->height = max(height(node->left), height(node->right)) + 1;
		
	// balance factor
	int balance = getBalance(node);
	
	//if balance factor is not equal to -1/0/1 then there are four cases
	
	//Left-Left
	if(balance>1 && (strcmp(name, node->left->name)<0))
		return rightRotate(node);
	//Left-Right
	if(balance>1 && (strcmp(name, node->left->name)>0)){
		node->left = leftRotate(node->left);
		return rightRotate(node);
	}	
	//Right-Right
	if(balance<-1 && (strcmp(name, node->right->name)>0))
		return leftRotate(node);
	//Right-Left
	if(balance<-1 && (strcmp(name,node->right->name)<0)){
		node->right = rightRotate(node->right);
		return leftRotate(node);
	}
		
	return node;	
}
void preOrder(struct Node *root){
	if(root!=NULL){
		printf("Name : %s\nPhone Number : %lld\n\n",root->name,root->phoneNumber);
		preOrder(root->left);
		preOrder(root->right);
	}
}
void postOrder(struct Node *root){
	if(root!=NULL){
		preOrder(root->left);
		preOrder(root->right);
		printf("Name : %s\nPhone Number : %lld\n\n",root->name,root->phoneNumber);
	}
}
void inOrder(struct Node *root){
	if(root!=NULL){
		inOrder(root->left);
		printf("Name : %s\nPhone Number : %lld\n\n",root->name,root->phoneNumber);
		inOrder(root->right);
	}
}
void inOrderReverse(struct Node *root){
	if(root!=NULL){
		inOrderReverse(root->right);
		printf("Name : %s\nPhone Number : %lld\n\n",root->name,root->phoneNumber);
		inOrderReverse(root->left);
	}
}
struct Node *minValueNode(struct Node* node){
	struct Node *current = node;
	
	//finding the left most leaf
	while(current->left!=NULL)
	current = current ->left;
	
	return current;
}
struct Node* deleteNode(struct Node* root,char name[20]){
	
	if(root == NULL)
	return NULL;
	
	if(strcmp(name, root->name)<0)
	root->left = deleteNode(root->left,name);
	else if(strcmp(name, root->name)>0)
	root->right = deleteNode(root->left,name);
	else{
		//node with only one child or no child
		if( (root->left == NULL) || (root->right == NULL) ){
			struct Node *temp = root->left ? root->left : root->right;
			
			//if node has no child 
			if(temp == NULL){
				temp = root;
				root = NULL;
			}
			else{
				*root = *temp;
			}
			free(temp);
		}
		else{
			struct Node *temp = minValueNode(root->right);
			strcpy(root->name, temp->name);
			root->right = deleteNode(root->right, temp->name);
		}
	}
	
	if(root==NULL)
	return root;
	
	//updating height
	root->height = 1 + max(height(root->left), height(root->right));
	//balancefactor
	int balance = getBalance(root);
	
	//Left-Left
	if(balance>1 && getBalance(root->left) >= 0)
	return rightRotate(root);
	
	//Left-Right
	if(balance>1 && getBalance(root->left) < 0){
		root->left = leftRotate(root->left);
		return rightRotate(root);
	}
	
	//Right-Right
	if(balance<-1 && getBalance(root->right) <= 0)
	return leftRotate(root);
	
	//Right-Left
	if(balance<-1 && getBalance(root->right) > 0){
		root->right = leftRotate(root->right);
		return leftRotate(root);
	}
	
	return NULL;
}
struct Node* search(struct Node *root,char name[]){
	if(root == NULL){
//		printf("Contact not found :(\n");
		return NULL;
	}
	
	if(strcmp(name, root->name)<0)
	return (search(root->left, name));
	else if(strcmp(name, root->name)>0)
	return (search(root->right, name));
	
	return (root);
}
int main() {
	struct Node *root = NULL;
	int choice = 0,count;
	long long int phoneNumber,phoneNumber1;
	char name[20];
	while(choice!=6){
		printf("MENU : \n");
		printf("[1.] Insert contact\n");
		printf("[2.] Remove contact\n");
		printf("[3.] Search contact\n");
		printf("[4.] Ascending contact List\n");
		printf("[5.] Descending contact List\n");
		printf("[6.] Exit\n");
		printf("Enter Choice : ");
		scanf("%d",&choice);
		switch(choice){
			case 1:
				printf("Enter name : ");
				scanf(" %[^\n]",name);
				count = 0;
				while(count!=10){
					printf("Enter phone number : ");
					scanf("%lld",&phoneNumber);
					phoneNumber1 = phoneNumber;
					while(phoneNumber1!=0){
						phoneNumber1/=10;
						count++;
					}
					if(count!=10){
						count = 0;
						printf("Enter 10 digit phone number :(\n");
					}	
				}
				root = insert(root, phoneNumber, name);
				printf("Contact added to the list :)\n");
				break;
			case 2:
				if(root==NULL)
				printf("There is no contact in the list :(\n");
				else{
					printf("Enter name : ");
					scanf(" %[^\n]",name);
					struct Node *temp = search(root, name);
					if(temp != NULL){
						root = deleteNode(root, name);
						printf("Contact deleted successfully :)\n");
					}
					else
					printf("Contact not found :(\n");
				}
				break;
			case 3:
				printf("Enter name : ");
				scanf(" %[^\n]",name);
				struct Node *temp = search(root, name);
				if(temp!=NULL){
					printf("Name : %s\nPhone Number : %lld\n",temp->name,temp->phoneNumber);
				}
				else{
					printf("Contact not found :(\n");
				}
				break;
			case 4:
				if(root!=NULL)
				inOrder(root);
				else
				printf("There is no contact in the list :(\n");
				break;
			case 5:
				if(root!=NULL)
				inOrderReverse(root);
				else
				printf("There is no contact in the list :(\n");
				break;
			case 6:
				printf("*** Thank You ***\n");
				break;
			default:
				printf("Invalid Choice :(\n");	
				break;
		}
	}
	
	return 0;
}
/*
z = parent node
y = child of parent node
x = inserted node
*/