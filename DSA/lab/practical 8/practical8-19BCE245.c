#include <stdio.h>
#include <stdlib.h>
//19BCE245 - Aayush Shah
struct Node{
	int data;
	struct Node *left;
	struct Node *right;
};
struct Node* newNode(int value){
	struct Node *temp = (struct Node *)malloc(sizeof(struct Node));
	temp->data = value;
	temp->right = temp->left = NULL;
	return temp;
}
void inOrder(struct Node *root){
	if(root==NULL)
	return;
	inOrder(root->left);
	printf("%d ",root->data);
	inOrder(root->right);
}
// A recursive function to construct Full from pre[] and post[]. 
// preIndex is used to keep track of index in pre[]. 
// l is low index and h is high index for the current subarray in post[] 
struct Node* constructTreeRec (int pre[], int post[], int* preIndex, int l, int h, int size) 
{ 
	// when lower exceed the higher or preIndex i.e. index of the arrays exceed the size of the array.
	if (*preIndex >= size || l > h) 
		return NULL; 

	// Making the first element[for each tree which will defined by the preIndex] of the 'pre' array as the root fo the tree.
	struct Node* root = newNode ( pre[*preIndex] ); 
	++*preIndex; 

	// If this array has only one element i.e. it's lower and higher are same then the element it self is a root. and no need further to reoccur 
	if (l == h) 
		return root; 

	// Search the next element of pre[] in post[] 
	int i; 
	for (i = l; i <= h; ++i) 
		if (pre[*preIndex] == post[i]) 
			break; 

	// Use the index of element found in postorder to divide 
	// postorder array in two parts. i.e. Left subtree and right subtree 
	if (i <= h) 
	{ 
		root->left = constructTreeRec (pre, post, preIndex,l, i, size); 
		root->right = constructTreeRec (pre, post, preIndex,i + 1, h, size); 
	} 

	return root; 
} 
struct Node *constructTree(int pre[],int post[],int size){
	int preIndex = 0;
	return constructTreeRec(pre, post, &preIndex, 0, size-1, size);
}

int main() {
	int size;
	printf("Enter number of nodes : ");
	scanf("%d",&size);
	int pre[size],post[size];
	
	printf("Enter PreOrder : ");
	
	for (int i=0;i<size;i++) 
		scanf("%d",&pre[i]);
	
		
	printf("Enter PostOrder : ");
	
	for (int i=0;i<size;i++) 
		scanf("%d",&post[i]);
	
	struct Node *root;
	root = constructTree(pre, post, size);
	
	printf("The Inorder traversal of the constructed tree : ");
	inOrder(root);
	
	return 0;
}

/*
9
pre : 1 2 4 8 9 5 3 6 7
post : 8 9 4 5 2 6 7 3 1
in : 8 4 9 2 5 1 6 3 7
9
1 2 4 8 9 5 3 6 7
8 9 4 5 2 6 7 3 1
*/
/*

//	return constructTreeRec(pre, post, &preIndex, 0, size-1, size);

//struct Node* constructTreeRec(int pre[],int post[],int *preIndex,int l, int h,int size){
//	
//	if(*preIndex >= size || l > h)
//	return NULL;
//	
////	struct Node *root = newNode(pre[*preIndex++]);
//	struct Node* root = newNode ( pre[*preIndex] ); 
//	++*preIndex; 
//	
//	if(l==h)
//	return root;
//	
//	int i;
////	for(int i=l;i<=h;i++){
//	for(int i=l;i<=h;++i){
//		if(pre[*preIndex] == post[i])
//		break;
//	}
//	
//	if(i<=h){
//		root->left = constructTreeRec(pre, post, preIndex, l, i, size);
//		root->right = constructTreeRec(pre, post, preIndex, i+1, h, size);
//	}
//	
//	return root;
//}
*/