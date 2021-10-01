#include <stdio.h>
#include <stdlib.h>
//19BCE245 - Aayush Shah
struct BSTNode{
	int data;
	struct BSTNode *left;
	struct BSTNode *right;
};
struct BSTNode *newNode(int value){
	struct BSTNode *temp = (struct BSTNode *)malloc(sizeof(struct BSTNode));
	temp->data = value;
	temp->right = temp->left = NULL;
	return temp;
}
void inOrder(struct BSTNode *root){
	if(root!=NULL){			//if root has NULL then this block won't be executed 
		inOrder(root->left);
		printf("%d ",root->data);
		inOrder(root->right);
	}
}
void preOrder(struct BSTNode *root){
	if(root!=NULL){			//if root has NULL then this block won't be executed 
		printf("%d ",root->data);
		preOrder(root->left);
		preOrder(root->right);
	}
}
void postOrder(struct BSTNode *root){
	if(root!=NULL){			//if root has NULL then this block won't be executed 
		postOrder(root->left);
		postOrder(root->right);
		printf("%d ",root->data);
	}
}
struct BSTNode* insert(struct BSTNode *root,int value){
	if(root == NULL)
	return newNode(value);
	if(value<root->data)
	root->left = insert(root->left,value);
	else if(value>root->data)
	root->right = insert(root->right,value);
	return root;
}
struct BSTNode* findMax(struct BSTNode *root){
	while(root->right!=NULL)
	root = root->right;
	return root;
}
struct BSTNode* Delete(struct BSTNode *root, int value){
	if(root==NULL){
		printf("No such element is exists :(\n");
	}
	else if(value<root->data){
		root->left = Delete(root->left, value);
	}
	else if(value>root->data){
		root->right = Delete(root->right, value);
	}
	else{
		struct BSTNode *temp;
		if(root->left!=NULL && root->right!=NULL){
			temp = findMax(root->left);
			root->data = temp->data;
			root->left = Delete(root->left, root->data);
		}
		else{
			temp = root;
//			root = NULL;	
			if(root == NULL){	//if leaf node is there
				free(temp);
			}
			else if(root->left == NULL){	//if node has one child node and it is in right subtree
				root = root->right;
				free(temp);
			}
			else if(root->right == NULL){	//if node has one child node and it is in left subtree
				root = root->left;
				free(temp);
			}
		}
		return root;
	}
	return root;
}
void displayBST(struct BSTNode *root){
	if(root!=NULL){	
		printf("Root : %d\n",root->data);
		
		if(root->left!=NULL){
			printf("	Left Child : %d\n",root->left->data);
			displayBST(root->left);
		}
		else
		printf("	Left Child is Empty\n");
		
		if(root->right!=NULL){
			printf("	Right Child : %d\n",root->right->data);
			displayBST(root->right);
		}
		else
		printf("	Right Child is Empty\n");	
	}		
}
int main() {
	int choice = 0,value;
//	struct BSTNode *root = NULL;
	

	//example tree : 
		/*
			  1
			 / \
			2   3
		   /\
		  4  5
		*/
	struct BSTNode *root = newNode(1);
	root->left = newNode(2);
	root->right = newNode(3);
	root->left->left = newNode(4);
	root->left->right = newNode(5);
	
	//or you can simply add it from here :
	while(choice!=7){
		printf("MENU : \n");
		printf("[1] Insert node\n");
		printf("[2] Delete node\n");
		printf("[3] Show BST\n");
		printf("[4] Preorder traversal\n");
		printf("[5] Inorder traversal\n");
		printf("[6] Postorder traversal\n");
		printf("[7] Exit\n");
		printf("Enter choice : ");
		scanf("%d",&choice);
		switch(choice){
			case 1:
				printf("Enter value : ");
				scanf("%d",&value);
				root = insert(root, value);
				break;
			case 2:
				printf("Enter value : ");
				scanf("%d",&value);
				root = Delete(root, value);
				break;
			case 3:
				displayBST(root);
				break;
			case 4:
				preOrder(root);
				printf("\n");
				break;
			case 5:
				inOrder(root);
				printf("\n");
				break;
			case 6:
				postOrder(root);
				printf("\n");
				break;
			case 7:
				printf("*** Thank You ***\n");
				break;
			default:
				printf("Invalid Choice :(\n");
		}
	}
	return 0;
}
