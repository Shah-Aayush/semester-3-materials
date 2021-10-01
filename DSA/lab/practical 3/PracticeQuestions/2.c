/*
2. You are given N numbers and an integer K. Your task is to reverse all the numbers before and after K using dequeue.
*/
#include<stdio.h>
#include<stdlib.h>
struct Queue{
	int size,front,rear;
	char *Q;
};
void create(struct Queue *q,int size){
	q->size = size;
	q->front = q->rear = -1;
	q->Q = (char*)malloc(q->size*sizeof(char));
}
void enQueue(struct Queue *q,int data){
	if(q->rear == -1 && q->front == -1){
		q->front = q->rear = 0;
		q->Q[q->rear]=data;
	}
	else if(q->front==((q->rear+1)%(q->size))){		//check condition if queue is full
		printf("Queue is FULL !\n");
	}
	else{
		q->rear=((q->rear+1)%(q->size));
		q->Q[q->rear]=data;
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
		printf("%d ",data);
	}		
	else{
		data = q->Q[q->front];
		q->front=((q->front+1)%(q->size));
		printf("%d ",data);
	}
}
void display(struct Queue *q){
	if(q->rear == -1 && q->front == -1){
			printf("Queue is Empty :(\n");
		}
	else{
		for(int i=q->front;i<=q->rear;i++){
			printf("%d ",q->Q[i]);
		}
	}
}
int main(){
	struct Queue q1,q2;
//	struct stack st;
	int n,k,data;
	scanf("%d",&n);
	int a[n],indexOfk;
	scanf("%d",&k);
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
		if(k==a[i])
		indexOfk=i;
	}
//	createStack(&st,indexOfk);
	create(&q1, indexOfk);			//creating queue for numbers before k
	create(&q2, n-indexOfk-1);		//creating queue for numbers after k
	for(int i=n-1;i>=0;i--){
		if(i<indexOfk)				//enqueue numbers in q1 which are before number k
		enQueue(&q1, a[i]);			
		else if(i>indexOfk)			//enqueue numbers in q2 which are after number k
		enQueue(&q2, a[i]);
	}
	printf("BEFORE : ");
	for(int i=0;i<n;i++){
		printf("%d ",a[i]);
	}
	printf("\nAFTER  : ");
	for(int i=0;i<n;i++){
		if(i<indexOfk)
		deQueue(&q1);				//dequeue numbers which are before k from q1 
		else if(i>indexOfk)			
		deQueue(&q2);				//dequeue numbers which are after k from q2 
		else
		printf("%d ",a[indexOfk]);
	}
	
	return 0;
}
/*
struct stack{
	int top;
	int size;
	char *array;
};
void createStack(struct stack *st,int sizeOfArray){
	st->size=sizeOfArry;
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
*/