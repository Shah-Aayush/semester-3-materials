/*
Write a program to implement priority queue using an array.
[ LIMITED ]
*/
#include<stdio.h>
#include<stdlib.h>
struct Queue{
	int sizeOfQueue,sizeOfPriority;
	int **Q,*front,*rear;
};
void create(struct Queue *q,int sizeOfQueue,int sizeOfPriority){
	q->sizeOfQueue = sizeOfQueue;
	q->sizeOfPriority = sizeOfPriority;
	q->front = (int*)malloc(q->sizeOfPriority*sizeof(int));
	q->rear = (int*)malloc(q->sizeOfPriority*sizeof(int));
	for(int i=0;i<sizeOfPriority;i++){
		q->front[i] = -1;
		q->rear[i] = -1;
	}
//	q->front = q->rear = -1;
//	q->Q = (int*)malloc(q->sizeOfPriority*q->sizeOfQueue*sizeof(int));
//	q->Q = (int**)malloc(sizeof(q->sizeOfPriority*q->sizeOfQueue));
	q->Q=(int**)malloc(sizeof(int*)*q->sizeOfPriority);
	for(int i=0;i<q->sizeOfPriority;i++){
		q->Q[i]=(int*)malloc(sizeof(int)*q->sizeOfQueue);
	}
}
void enQueue(struct Queue *q,int data, int priority){
	if(q->rear[priority-1] == -1 && q->front[priority-1] == -1){		//if queue is empty
		q->rear[priority-1] = q->front[priority-1] = 0;
		q->Q[priority-1][q->rear[priority-1]] = data;
	}
	else if(q->front[priority-1] == ((q->rear[priority-1]+1)%(q->sizeOfQueue))){		//if queue is full
		printf("The queue of priority %d is full\n",priority);
	}
	else{
		q->rear[priority-1] = ((q->rear[priority-1]+1)%(q->sizeOfQueue));
		q->Q[priority-1][q->rear[priority-1]] = data;
	}
}
void display(struct Queue *q){
	for(int i=0;i<q->sizeOfPriority;i++){
		printf("PRIORITY = %d : ",i+1);
		if(q->rear[i] == -1 && q->front[i] == -1){
				printf("Queue of priority %d is empty !\n",i);
		}
		else{
			int j = q->front[i];
			while(j!=q->rear[i]){
				printf("%d ",q->Q[i][j]);
				j = (j+1)%(q->sizeOfQueue);
			}
			printf("%d \n",q->Q[i][j]);
		}
	}
}
void deQueue(struct Queue *q){
	int data = -1,flag = 0;
	for(int i=0;i<q->sizeOfPriority;i++){
		if(q->rear[i] == -1 && q->front[i] == -1){
				printf("Queue of priority %d is empty !\n",i);
		}
		else if(q->rear[i] == q->front[i]){
			data = q->Q[i][q->front[i]];
			q->front[i] = q->rear[i] = -1;
			printf("%d removed from the priority Queue %d",data,i);
			flag = 1;
		}
		else{
			data = q->Q[i][q->front[i]];
			q->front[i] = ((q->front[i]+1)%(q->sizeOfQueue));
			printf("%d removed from the priority Queue %d",data,i);
			flag = 1;
		}
		if(flag == 1)
		break;
	}
}
int main(){
	int n,n1,choice;
	printf("*** PRIORITY QUEUE [ LIMITED ] ***\n");
	printf("Enter the number of priorities : ");
	scanf("%d",&n1);
	printf("Enter the number of elements : ");
	scanf("%d",&n);
	struct Queue q;
	create(&q,n,n1);
	int data,priority;
//	for(int i=0;i<n;i++){
//		printf("Enter the number : ");
//		scanf("%d",&data);
//		printf("Enter the priority of %d : ",data);
//		scanf("%d",&priority);
//		
//	}
	do{
		printf("MENU : \n");
		printf("[1.] Add integer to the Queue 		  [press 1]\n");
		printf("[2.] Remove Current user from the Queue  [press 2]\n");
		printf("[3.] Display current Queue of integers 	  [press 3]\n");
//		printf("[4.] UserId of Last user from the Queue  [press 4]\n");
//		printf("[5.] UserID of Current user of the Queue [press 5]\n");
		printf("[4.] Exit Application		 	  [press 6]\n");
		printf("Enter choice : ");	
		scanf("%d",&choice);
		switch (choice) {
			case 1:
				printf("Enter the number : ");
				scanf("%d",&data);
				printf("Enter the priority of %d : ",data);
				scanf("%d",&priority);
				enQueue(&q, data, priority);
				break;
			case 2:
				deQueue(&q);
				break;
			case 3:
				display(&q);
				break;
//			case 4:
//				whatIsRear(&q);
//				break;
//			case 5:
//				whatIsFront(&q);
//				break;
			case 4:
				printf("**** THANK YOU FOR USING THE APPLICATION ***\n");
				break;
			default:
				printf("Invalid Choice :(\n");
			}
		}while(choice!=6);
	return 0;
}