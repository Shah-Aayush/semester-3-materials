#include "stdio.h"

int MaxSize = 10;
int stack[10];
int top = -1;

int isEmpty(){
	if(top == -1)
	return 1;
	else 
	return 0;
}
int isFull(){
	if(top == MaxSize)
	return 1;
	else
	return 0;
}
int peek(){
	if(isEmpty()==0)
	return stack[top];
	else
	return -1;
}
int pop(){
	int data;
	if(isEmpty() == 0){
		data = stack[top];
		top--;
		return data;
	}
	else{
		printf("StackUnderFlow ! :(\n");
		return -1;
	}
}
void push(int data){
	if(isFull() == 0)
	stack[++top]=data;
	else
	printf("StackOverFlow ! :(\n");
}
int main(){
	int data;
	push(1);
	push(2);
	push(3);
	push(4);
	push(5);
	
	printf("Top element : %d\n",peek());
	printf("Total element : %d\n",top+1);
	printf("Elements : \n");
	while(!isEmpty()){
		int data = pop();
		printf("%d\n",data);
	}
	
		printf("Stack full: %s\n" , isFull()?"true":"false");
		printf("Stack empty: %s\n" , isEmpty()?"true":"false");
	return 0;
}