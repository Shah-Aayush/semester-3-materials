#include <stdio.h>
#include <stdlib.h>
struct node{
	int info;
	struct node *next;
};
struct node *START = NULL;		
struct node* createNode(){
	struct node *n;
	n = (struct node*)malloc(sizeof(struct node));
	if(n == NULL)
		printf("Memory Allocation Failed :(\n");	
	return n;
}
void insertNode(int information){
	struct node *temp;
	temp = createNode();
	temp->info = information;
	temp->next = NULL;
	if(START == NULL){
		START = temp;
	}
	else{
		struct node *t;
		t = START;
		while(t->next != NULL){
			t = t->next;
		}
		t->next = temp;
	}
}
void viewList(){
	struct node *t;
	if(START == NULL){
		printf("List is empty :(\n");
	}
	else{
		t = START;
		while(t!=NULL){
			printf("%d ",t->info);
			t = t->next; 
		}
	}
	printf("\n");
}
struct node* reverseList(){
	struct node *nextNode = NULL,*prevNode = NULL;
	while(START != NULL){
		nextNode = START->next;
		START->next = prevNode;
		prevNode = START;
		START = nextNode;
	}
	return prevNode;
}
int main() {
	int n,number;
	printf("Enter the number of integers : ");
	scanf("%d",&n);
	printf("Enter integers : ");
	for(int i=0;i<n;i++){
		scanf("%d",&number);
		insertNode(number);
	}
	START = reverseList();
	viewList();
}