#include<stdio.h>	
#include<stdlib.h>	
struct node{
	int info;
	struct node *link;		
};
struct node *START = NULL;
struct node* createNode(){		
	struct node *n;		
	n = (struct node*)malloc(sizeof(struct node));	
	if(n == NULL)
		printf("Memory Allocation Failed :(\n");	
	return n;
}
void insertNode(){		
	struct node *temp;
	temp = createNode();
	printf("Enter your Number :");
	scanf("%d",&temp->info);
	temp->link = NULL;	
	if(START == NULL){		
		START = temp;
	}
	else{		
		struct node *t;
		t = START;
		while(t->link!=NULL){
			t = t->link;		
		}
		t->link = temp;
	}
}
void deleteNode(){		//deleting first node
	struct node *r;
	if(START == NULL)		
	printf("List is empty");
	else{
		r = START;
		START = START->link;
		free(r); 
	}
}
void viewList(){
	struct node *t;		
	if(START==NULL)
	printf("List is empty :(");
	else{
		t = START;
		while(t!=NULL){
			printf("%d ",t->info);
			t = t->link;
		}
	}
	printf("\n");
} 
int main(){
	int choice = 0;
	while(choice!=4){
			printf("[1.]Add value to the list\n");
			printf("[2.]Delete value from the list\n");
			printf("[3.]View list\n");
			printf("[4.]Exit\n");
			printf("Enter your choice : ");
			scanf("%d",&choice);
		switch (choice) {
			case 1:
				insertNode();
				break;
			case 2:
				deleteNode();
				break;
			case 3:
				viewList();
				break;
			case 4:
				printf("*** THANK YOU ***\n");
				break;
			default:
				printf("Invalid Choice :(\n");
		}
	}
	return 0;
}