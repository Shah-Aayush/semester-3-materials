#include<stdio.h>
#include<stdlib.h>
struct Queue{
	int size,front,rear;
	int *Q;
};
void create(struct Queue *q,int size){
	q->size = size;
	q->front = q->rear = -1;
	q->Q = (int*)malloc(q->size*sizeof(int));
}
void enQueue(struct Queue *q,int data){
	if(q->rear == -1 && q->front == -1){
		q->front = q->rear = 0;
		q->Q[q->rear]=data;
	}
	else if(q->rear==(q->size-1)){		//check condition if queue is full
		printf("Queue is FULL !\n");
	}
	else{
		q->rear++;
		q->Q[q->rear]=data;
	}
}
void display(struct Queue *q){
	if(q->rear == -1 && q->front == -1){
		printf("Queue is Empty :(\n");
	}
	else{
		printf("QUEUE Number   ->   USERID\n");
			for(int i=q->front;i<=q->rear;i++){
				printf("%d -> userID %d \n",i+1,q->Q[i]);
			}
	}
}
void deQueue(struct Queue *q){
	int data = -1;
	if(q->rear == -1 && q->front == -1){			//check condition if queue is empty
		printf("Queue is EMPTY !\n");
	}
	else if(q->rear == q->front){			//only one element in the queue
		data = q->Q[q->front];
		q->front = q->rear = -1;
		printf("UserID %d removed from the queue.\n",data);
	}		
	else{
		data = q->Q[q->front];
		q->front++;
		printf("UserID %d removed from the queue.\n",data);
	}
}
void whatIsFront(struct Queue *q){
	if(q->front==q->rear){			//check condition if queue is empty
		printf("Queue is EMPTY !\n");
	}
	else{
		printf("UserID of current user is : %d\n",q->Q[q->front]); 
	}
}
void whatIsRear(struct Queue *q){
	if(q->front==q->rear){			//check condition if queue is empty
		printf("Queue is EMPTY !\n");
	}
	else{
		printf("UserID of last user is : %d\n",q->Q[q->rear]);;
	}
}

int main(){
	struct Queue q;
	int n,choice,data;
	printf("****PRINTER SPOOLER APPLICATION****\n");
	printf("Enter the number of user : ");		//by default as per question, there are 5 users [enter 5]
	scanf("%d",&n);		//n is the size of the array 
	create(&q, n);		//creating queue
	do{
		printf("MENU : \n");
		printf("[1.] Add user to the Queue 		  [press 1]\n");
		printf("[2.] Remove Current user from the Queue  [press 2]\n");
		printf("[3.] Display current Queue of users 	  [press 3]\n");
		printf("[4.] UserId of Last user from the Queue  [press 4]\n");
		printf("[5.] UserID of Current user of the Queue [press 5]\n");
		printf("[6.] Exit Application		 	  [press 6]\n");
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
