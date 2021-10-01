#include "stdio.h"
#include "stdlib.h"
struct stack{
	int size;
	int top;
	int *s;
};
void display(struct stack *st){
	for(int i=0;i<=st->top;i++){
		printf("element of index %d is %d\n",i,st->s[i]);
	}
}
void create(struct stack *st){
	scanf("%d",&st->size);
	st->s = (int *)malloc((st->size)*sizeof(int));
	st->top = -1;
	printf("An integer array of size %d is created successfully !\n",st->size);
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
int peek(struct stack *st){
	if(isEmpty(st) == 0)
	return st->s[st->top];
	else 
	return -1;
}
int pop(struct stack *st){
	if(isEmpty(st) == 0){
		int data = st->s[st->top];
		st->top--;
		return data;
	}
	else{
		printf("StackUnderFlow :(\n");
		return -1;
	}
}
void push(struct stack *st,int data){
	if(isFull(st) == 0){
		st->top++;
		st->s[st->top] = data;
	}
	else {
		printf("StackOverFlow :(\n");
	}
}
int main(){
	struct stack st;
	int choice,data;
	create(&st);
	printf("Choice : \n[1.]push		(press 1)\n[2.]pop 		(press 2)\n[3.]peek 		(press 3)\n[4.]print elements 	(press 4)\n[5.]exit		(press 5)\n");
	scanf("%d",&choice);
	while(choice != 5){
		if(choice == 1){
			printf("Enter a element to push : ");
			scanf("%d",&data);
			push(&st, data);
		}
		else if(choice == 2){
			printf("element %d popped !\n",pop(&st));
		}
		else if(choice == 3){
			printf("peek element is : %d\n",peek(&st));
		}
		else if(choice == 4){
			display(&st);
		}
		else{
			printf("Invalid Choice :(\n");
		}
		printf("Menu : \n[1.]push		(press 1)\n[2.]pop 		(press 2)\n[3.]peek 		(press 3)\n[4.]print elements	(press 4)\n[5.]exit		(press 5)\n");
		scanf("%d",&choice);
	}
	printf("Thank You from 19BCE245 :)\n");
	return 0;
}
