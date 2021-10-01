#include <stdio.h>
#include <stdlib.h>
struct node{
	int info;
	struct node *next;
};
//struct node *START0 = NULL;		//main list
//struct node *START1 = NULL;		//1,5,9,13,...
//struct node *START2 = NULL;		//2,6,10,14,...
//struct node *START3 = NULL;		//3,7,11,15,...
//struct node *START4 = NULL;		//4,8,12,16,...
struct node *STARTarr[5] = {NULL};		//4,8,12,16,...
struct node* createNode(){
	struct node *n;
	n = (struct node*)malloc(sizeof(struct node));
	if(n == NULL)
		printf("Memory Allocation Failed :(\n");	
	return n;
}
void insertNode(int information,struct node *START){
	START = NULL;
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
void viewList(struct node *START){
	START = NULL;
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
void checkAndSplit(struct node *START){
	START = NULL;
	struct node *t;			//traversing
	if(START == NULL){
		printf("List is empty :(\n");
	}
	else{
		t = START;
		int count=0;
		while(t!=NULL){
//			printf("%d ",t->info);	
			if((t->info) == (1+(count*4)))
			insertNode(t->info, STARTarr[1]);
			else if((t->info) == (2+(count*4)))
			insertNode(t->info, STARTarr[2]);
			else if((t->info) == (3+(count*4)))
			insertNode(t->info, STARTarr[3]);
			else if((t->info) == (4+(count*4)))
			insertNode(t->info, STARTarr[4]);
			t = t->next; 
			count++;
		}
	}
//	printf("\n");
}
int main(){
	int N;
	printf("Enter the number of integers : ");
	scanf("%d",&N);
	for(int i=1;i<=N;i++){		//creating main list which will contain integers 1 to N
		insertNode(i,STARTarr[0]);
	}
	checkAndSplit(STARTarr[0]);
	printf("Main List : ");
	viewList(STARTarr[0]);
	printf("1st List : ");
	viewList(STARTarr[1]);
	printf("2nd List : ");
	viewList(STARTarr[2]);
	printf("3rd List : ");
	viewList(STARTarr[3]);
	printf("4th List : ");
	viewList(STARTarr[4]);
	return 0;
}

/*
for(int i=0;i<N;i++){
		if((i+1) == (1+(i*4)))
		insertNode(int information, struct node *START1);
		else if((i+1) == (2+(i*4)))
		insertNode(int information, struct node *START2);
		else if((i+1) == (2+(i*4)))
		insertNode(int information, struct node *START3);
		else if((i+1) == (2+(i*4)))
		insertNode(int information, struct node *START4);
	}
*/