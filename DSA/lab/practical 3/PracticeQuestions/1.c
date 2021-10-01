/*
1. Simi was learning about strings and Queue. She was writing random strings on paper but got stuck on one. She got fascinated by the string and thought of challenging you for the same. She will provide you with the strings and you have to print the output in the similar format as the given example. Carefully look at the example to understand the format of the writing string. She has also asked you to use Queue for the same.
*/
#include "stdio.h"
#include "stdlib.h"
#include "string.h"
struct Queue{
	int size,front,rear;
	char *Q;
};
void create(struct Queue *q,int size){
	q->size = size;
	q->front = q->rear = -1;
	q->Q = (char*)malloc(q->size*sizeof(char));
}
void enQueue(struct Queue *q,char data){
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
	char data = -1;
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
		q->front=((q->front+1)%(q->size));
		printf("UserID %d removed from the queue.\n",data);
	}
}
void display(struct Queue *q){
	if(q->rear == -1 && q->front == -1){
		printf("Queue is Empty :(\n");
	}
	else{
		int i=q->front;
		while(i!=q->rear){
			printf("%c",q->Q[i]);
			i = ((i+1)%(q->size));
		}
		printf("%c",q->Q[q->rear]);
	}
}
int main(){
	int t;
	char str[1000];
	struct Queue q;
	scanf("%d",&t);
	for(int i=0;i<t;i++){
		scanf(" %[^\n]",str);
		create(&q, strlen(str));
		int j=0,k=strlen(str)-1;
		for(int i=0;i<strlen(str);i++){
			if(i%2==0)
			enQueue(&q, str[j++]);
			else
			enQueue(&q, str[k--]);
		}
		display(&q);
		printf("\n");
	}
	return 0;
}