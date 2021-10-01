//CIRCULAR LINKED LIST

/*
->Here we will make last pointer to store the address of last node instead of start pointer.
->We will connect the last node to the first node by putting the address of first node into the next/link of the last node instead of putting NULL.
*/
#include "stdio.h"
#include "stdlib.h"
struct node{
	int data;
	struct node *next;
};

void display(struct node *last){
	if(last==NULL){
		printf("List is empty :(\n");
	}
	else{
		struct node *t = last->next;
		do{
			printf("%d ",t->data);
			t = t->next;
		}while(t!=last->next);
	}
	printf("\n");
}
struct node* addToEmpty(struct node *last,int value){
	struct node *n = (struct node *)malloc(sizeof(struct node));
	n->data = value;
	n->next = n;
	last = n;
	return (last);
}
struct node* addAtBeg(struct node *last,int value){
	struct node *n = (struct node *)malloc(sizeof(struct node));
	n->data = value;
	n->next = last->next;
	last->next = n;
	return (last);
}
struct node* addAtEnd(struct node *last, int value){
	struct node *n = (struct node *)malloc(sizeof(struct node));
	n->next = last->next;
	n->data = value;
	last->next = n;
	last = n;
	return (last);
}
struct node* createList(struct node *last){
	int n,value;
	printf("How many values you want to enter : ");
	scanf("%d",&n);
	printf("Enter first data : ");
	scanf("%d",&value);
	last = addToEmpty(last, value);
	for(int i = 2;i<=n;i++){
		printf("Enter data : ");
		scanf("%d",&value);
		last = addAtEnd(last, value);
	}
	return (last);
}
struct node* addAfter(struct node *last, int value,int item){
//	printf("Enter value to add after it : ");
//	scanf("%d",&item);
	struct node *t;
	t = last->next;
	//item is the value of the node after which we want to add new node.
	do{
		if(t->data == item)
		break;
		t = t->next;
	}while(t!=last->next);
	if(t==last->next){
		printf("Cannot find data %d :(\n",item);
		return (last);
	}
	struct node *n = (struct node *)malloc(sizeof(struct node));
	n->next = t->next;
	t->next = n;
	n->data = value;
	if(t == last)
	last = n;
	return (last);
}
struct node* del(struct node *last, int value){
	struct node *t;
	if(last == NULL){	//if list is empty
		printf("List is empty :(\n");
		return (last);
	}
	else if(last->next == last && last->data == value){		//if list has only one node and its data is same as value then simply delte it.
		t = last;
		last = NULL;
		free(t);
		return (last);
	}
	else if(last->next->data == value){	//if the node which we want to delete is the first node
		t = last->next;
		last->next = t->next;
		free(t);
		return (last);
	}
	else if(last->data == value){	//if the node which we want to delete is the last node
		t = last;
		struct node *p;
		p = last;
		do{
			if(p->next->data == value)
			break;
			p = p->next;
		}while(p!=last);
		last = p;
		p->next = t->next;
		free(t);
	}
	else{
		t = last->next;
		while(t->next!=last){
			if(t->next->data == value){
				break;
			}
			t = t->next;
		}
		if(t->next == last){
			printf("%d is not found :(\n",value);
			return (last);
		}
		struct node *p = t;
		t = t->next;
		p->next = t->next;
		free(t);
		return (last);
	}
	return (last);
}
int main(){
	int choice=0,value,item;
	struct node *last = NULL;
	while(choice!=8){
		system("clear");
		printf("MENU : \n");
		printf("[1.]Create List\n");
		printf("[2.]Display List\n");
		printf("[3.]Add to empty List\n");
		printf("[4.]Add to beginning List\n");
		printf("[5.]Add to beginning List\n");
		printf("[6.]Add after specific node\n");
		printf("[7.]delete node\n");
		printf("[8.]Exit\n");
		printf("Enter Choice : ");
		scanf("%d",&choice);
		switch (choice) {
			case 1:
				last = createList(last);
				break;
			case 2:
				display(last);
				break;
			case 3:
				printf("Enter data : ");
				scanf("%d",&value);
				last = addToEmpty(last,value);
				break;
			case 4:
				printf("Enter data : ");
				scanf("%d",&value);
				last = addAtBeg(last,value);
				break;
			case 5:
				printf("Enter data : ");
				scanf("%d",&value);
				last = addAtEnd(last,value);
				break;
			case 6:
				printf("Enter data : ");
				scanf("%d",&value);
				printf("Enter item value after which new value will be inserted : ");
				scanf("%d",&item);
				last = addAfter(last,value,item);
				break;
			case 7:
				printf("Enter value of the element to be deleted : ");
				scanf("%d",&value);
				last = del(last, value);
				break;
			case 8:
				printf("***Thank You***\n");
				break;
			default:
				printf("Invalid Choice :(\n");
		}
	}
	return 0;
}