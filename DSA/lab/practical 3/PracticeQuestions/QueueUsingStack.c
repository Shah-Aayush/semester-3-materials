#include<stdio.h>
#include<stdlib.h>
struct stack{
	int top;
	int size;
	int *array;
};
int count=0;
void createStack(struct stack *st,int sizeOfArray){
	st->size=sizeOfArray;
	st->array = (int *)malloc((st->size)*sizeof(int));
	st->top = -1;
}
int isEmpty(struct stack *st){
	if(st->top == -1)
	return 1;
	else 
	return 0;
}
int isFull(struct stack *st){
	if(st->top == (st->size-1))
	return 1;
	else 
	return 0;
}
int pop(struct stack *st){
	if(isEmpty(st) == 0){
		int data = st->array[st->top];
		st->top--;
		return data;
	}
	else{
		printf("StackUnderFlow :(\n");
		return 0;
	}
}
void push(struct stack *st,int data){
	if(isFull(st) == 0){
		st->top++;
		st->array[st->top] = data;
	}
	else {
		printf("StackOverFlow :(\n");
	}
}
void displayStack(struct stack *st){
	for(int i=0;i<=st->top;i++){
		printf("%d ",st->array[i]);
	}
}


struct Queue{
	int size,front,rear;
	int *Q;
};
void create(struct Queue *q,int size){
	q->size = size;
	q->front = q->rear = -1;
	q->Q = (int*)malloc(q->size*sizeof(int));
}
void enQueue(struct Queue *q,struct stack *s1,struct stack *s2,int data){
	
	if(s1->top==(s1->size-1)){		//check condition if queue is full
		printf("Queue is FULL !\n");
	}
	else{
		push(s1, data);
		count++;
	}
	/*
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
	*/
}
void display(struct Queue *q,struct stack *s1,struct stack *s2){
//	while(s1->top!=-1){
//		push(s2, pop(s1));
//	}
	displayStack(s1);
	printf("\n");
//	while(s2->top!=-1){
//		push(s1, pop(s2));
//	}
	/*
	if(q->rear == -1 && q->front == -1){
		printf("Queue is Empty :(\n");
	}
	else{
		printf("QUEUE Number   ->   USERID\n");
			for(int i=q->front;i<=q->rear;i++){
				printf("%d -> userID %d \n",i+1,q->Q[i]);
			}
	}
	*/
}
void deQueue(struct Queue *q,struct stack *s1,struct stack *s2){
	if(s1->top == -1 && s2->top == -1){			//check condition if queue is empty
		printf("Queue is EMPTY !\n");
	}
	else{	
		while(s1->top!=-1){
			push(s2, pop(s1));
		}
		int data = pop(s2);
		while(s2->top!=-1){
			push(s1, pop(s2));
		}
		printf("UserID %d removed from the queue.\n",data);	
	}
	
	/*
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
	*/
}
void whatIsFront(struct Queue *q){
//	while(s1->top!=-1){
//		push(s2, pop(s1));
//	}
//	displayStack(s2);
//	while(s2->top!=-1){
//		push(s1, pop(s2));
//	}
	
	/*
	if(q->front==q->rear){			//check condition if queue is empty
		printf("Queue is EMPTY !\n");
	}
	else{
		printf("UserID of current user is : %d\n",q->Q[q->front]); 
	}
	*/
}
void whatIsRear(struct Queue *q){
	
	/*
	if(q->front==q->rear){			//check condition if queue is empty
		printf("Queue is EMPTY !\n");
	}
	else{
		printf("UserID of last user is : %d\n",q->Q[q->rear]);;
	}
	*/
}

int main(){
	struct Queue q;
	struct stack s1,s2;
	int n,choice,data;
	printf("****PRINTER SPOOLER APPLICATION****\n");
	printf("Enter the number of user : ");		//by default as per question, there are 5 users [enter 5]
	scanf("%d",&n);		//n is the size of the array 
	create(&q, n);		//creating queue
	createStack(&s1, n);		//creating stack
	createStack(&s2, n);		//creating stack
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
				enQueue(&q,&s1,&s2, data);
				break;
			case 2:
				deQueue(&q,&s1,&s2);
				break;
			case 3:
				display(&q,&s1,&s2);
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
