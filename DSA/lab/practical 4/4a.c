/*
Consider a linked list with N integers. Each node of the list is numbered from ‘1’ to ‘N’. Write a program to split the list into 4 lists, so that:
i) First list contains nodes numbered 1, 5, 9, 13, _, _, _
ii) Second list contains nodes numbered 2, 6, 10, 14, _, _, _
iii) Third list contains nodes numbered 3, 7, 11, 15, _, _, _
iv) And fourth list contains nodes numbered 4, 8, 12, 16, _, _, _
*/
#include <stdio.h>
#include <stdlib.h>
struct node{
	int info;
	struct node *next;
};
struct node *START0 = NULL;		//main list
struct node *START1 = NULL;		//1,5,9,13,...
struct node *START2 = NULL;		//2,6,10,14,...
struct node *START3 = NULL;		//3,7,11,15,...
struct node *START4 = NULL;		//4,8,12,16,...
struct node* createNode(){
	struct node *n;
	n = (struct node*)malloc(sizeof(struct node));
	if(n == NULL)
		printf("Memory Allocation Failed :(\n");	
	return n;
}
void insertNode(int information,struct node **START){
	struct node *temp;
	temp = createNode();
	temp->info = information;
	temp->next = NULL;
	if(*START == NULL){
		*START = temp;
	}
	else{
		struct node *t;
		t = *START;
		while(t->next != NULL){
			t = t->next;
		}
		t->next = temp;
	}
}
void viewList(struct node *START){
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
	struct node *t;			//traversing
	if(START == NULL){
		printf("List is empty :(\n");
	}
	else{
		t = START;
		int count=0;
		while(t!=NULL){
			switch(t->info%4){
				case 1:
					insertNode(t->info,&START1);
					break;
				case 2:
					insertNode(t->info,&START2);
					break;
				case 3:
					insertNode(t->info,&START3);
					break;
				case 0:
					insertNode(t->info,&START4);
					break;
			}
//			printf("%d ",t->info);	
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
		insertNode(i,&START0);
	}
	checkAndSplit(START0);
	printf("Main List : ");
	viewList(START0);
	printf("1st List : ");
	viewList(START1);
	printf("2nd List : ");
	viewList(START2);
	printf("3rd List : ");
	viewList(START3);
	printf("4th List : ");
	viewList(START4);
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