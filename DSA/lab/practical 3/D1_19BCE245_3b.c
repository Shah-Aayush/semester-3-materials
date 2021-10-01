/*
Write a program to implement priority queue using an array.
*/
#include<stdio.h>
#include<stdlib.h>
struct Queue{
	int size,rear,front;
	int *priorityQ;
};
void create(struct Queue *q,int size){
	q->size = size;
	q->front = q->rear = -1;
	q->priorityQ = (int*)malloc(q->size*sizeof(int));
}
void check(struct Queue *q,int data){
	int i,j;
	for(i=q->front;i<=q->rear;i++){
		if(data>=q->priorityQ[i]){
			for(j=q->rear+1;j>i;j--){
				q->priorityQ[j]=q->priorityQ[j-1];
			}
			q->priorityQ[i]=data;
			return;
		}
	}
	
}
void enQueue(struct Queue *q,int data){
	if(q->rear == -1 && q->front == -1){
		q->front = q->rear = 0;
		q->priorityQ[q->rear]=data;
	}
	else if(q->rear==(q->size-1)){		//check condition if queue is full
		printf("Queue is FULL !\n");
	}
	else{
		check(q,data);
		/*
		q->rear++;
		q->priorityQ[q->rear]=data;
		*/
	}
}

void display(struct Queue *q){
	if(q->rear == -1 && q->front == -1){
		printf("Queue is Empty :(\n");
	}
	else{
		for(int i=q->front;i<=q->rear;i++){
			printf("%d ",q->priorityQ[i]);
		}
	}
	printf("\n");
}
void deQueue(struct Queue *q){
	int data = -1;
	if(q->rear == -1 && q->front == -1){			//check condition if queue is empty
		printf("Queue is EMPTY !\n");
	}
	else if(q->rear == q->front){			//only one element in the queue
		data = q->priorityQ[q->front];
		q->front = q->rear = -1;
		printf("UserID %d removed from the queue.\n",data);
	}		
	else{
		data = q->priorityQ[q->front];
		q->front++;
		printf("UserID %d removed from the queue.\n",data);
	}
}
void whatIsFront(struct Queue *q){
	if(q->front==q->rear){			//check condition if queue is empty
		printf("Queue is EMPTY !\n");
	}
	else{
		printf("UserID of current user is : %d\n",q->priorityQ[q->front]); 
	}
}
void whatIsRear(struct Queue *q){
	if(q->front==q->rear){			//check condition if queue is empty
		printf("Queue is EMPTY !\n");
	}
	else{
		printf("UserID of last user is : %d\n",q->priorityQ[q->rear]);;
	}
}
int main(){
	struct Queue q;
	int n,choice,data;
	printf("Enter the number of elements : ");
	scanf("%d",&n);
	create(&q, n);
	do{
		printf("MENU : \n");
		printf("[1.] Add Element in the queue	    [press 1]\n");
		printf("[2.] Remove Element from the queue  [press 2]\n");
		printf("[3.] Display Element of the queue	[press 3]\n");
		printf("[4.] Last Element in the queue  	[press 4]\n");
		printf("[5.] First Element in the queue 	[press 5]\n");
		printf("[6.] Exit 		 		[press 6]\n");
		printf("Enter choice : ");	
		scanf("%d",&choice);
		switch (choice) {
			case 1:
				printf("Enter UserID : ");
				scanf("%d",&data);
				enQueue(&q, data);
				break;
			case 2:
				deQueue(&q);
				break;
			case 3:
				display(&q);
				break;
			case 4:
				whatIsRear(&q);
				break;
			case 5:
				whatIsFront(&q);
				break;
			case 6:
				printf("**** THANK YOU FOR USING THE APPLICATION ***\n");
				break;
			default:
				printf("Invalid Choice :(\n");
		}
	}while(choice!=6);
	return 0;
}