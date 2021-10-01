/*
Write a program to reverse a given string using Stack.
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
struct stack{
	int top;
	int size;
	char *array;
};
void create(struct stack *st){
//	scanf("%d",&st->size);
	st->array = (char *)malloc((st->size)*sizeof(char));
	st->top = -1;
//	printf("An integer array of size %d is created successfully !\n",st->size);
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
char pop(struct stack *st){
	if(isEmpty(st) == 0){
		char data = st->array[st->top];
		st->top--;
		return data;
	}
	else{
		printf("StackUnderFlow :(\n");
		return 0;
	}
}
void push(struct stack *st,char data){
	if(isFull(st) == 0){
		st->top++;
		st->array[st->top] = data;
	}
	else {
		printf("StackOverFlow :(\n");
	}
}
void reverse(char s[],struct stack *st){
	st->size=strlen(s);
	create(st);
	for(int i=0;i<strlen(s);i++){	//pushing
		if(isFull(st)==0){
			push(st, s[i]);
		}
	}
	for(int i=0;i<strlen(s);i++){	//poping
		if(isEmpty(st)==0){
			s[i]=pop(st);
		}
	}
}
int main(){
	struct stack st;
	char s[100];
	printf("Enter a string : ");
	scanf("%[^\n]",s);
	reverse(s,&st);
	printf("Reversed String is : %s",s);
	return 0;
}