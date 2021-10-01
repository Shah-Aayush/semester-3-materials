/*
Write a program to convert fully parenthesized infix expression to postfix expression.
*/

#include "stdio.h"
#include "string.h"
#include "stdlib.h"
struct stack{		//making structure named stack
	int top;
	int size;
	char *array;
};
void create(struct stack *st){		//creates array of stack with size of number of total operators including paranthesis in expression
	st->array = (char *)malloc((st->size)*sizeof(char));
	st->top = -1;
}
int isEmpty(struct stack *st){		//checks whether stack is empty or not 
	if(st->top == -1)
	return 1;
	else 
	return 0;
}
int isFull(struct stack *st){		//checks whether stack is full or not
	if(st->top == (st->size-1))	
	return 1;
	else 
	return 0;
}
char pop(struct stack *st){			//pops a char from stack st
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
void push(struct stack *st,char data){		//pushs a char to stack st
	if(isFull(st) == 0){
		st->top++;
		st->array[st->top] = data;
	}
	else {
		printf("StackOverFlow :(\n");
	}
}
int checkOperatorsNumber(char expression[]){		//calculates the number of operator present in expression including paranthesis
	int count=0;
	for(int i=0;i<strlen(expression);i++){
		if((expression[i]>='a' && expression[i]<='z') || (expression[i]>='A' && expression[i]<='Z'))
		count++;
	}
	return (strlen(expression)-count);
}
int isOperator(char s){		//checks whether a char is a operator or not 
	if((s>='a' && s<='z') || (s>='A' && s<='Z'))
	return 0;
	else
	return 1;
}
char peek(struct stack *st){	//return the pick char from stack st
	if(isEmpty(st) == 0)
	return st->array[st->top];
	else 
	return -1;
}
int checkPrecedence(char s){		//checks the precedence of a char provided in it [precedence value is only for example and chosen by me]
	if(s=='(')
	return 1;
	else if(s==')')
	return 2;
	else if(s=='^')
	return 3;
	else if(s=='*' || s=='/')
	return 4;
	else if(s=='+' || s=='-')
	return 5;
	else 
	return 0;
}
void infixToPostfix(char expression[],struct stack *st){		//function to convert the expression from INFIX to POSTFIX
	st->size=checkOperatorsNumber(expression);
	create(st);
	char expression2[100];		//first we will store the prefix value in this array then at last we will copy it in main string i.e. expression
	int count=0;
	char data;
	for(int i=0;i<strlen(expression);i++){		//for loop which takes every char from main string turn by turn  
		printf("Expression (scanned) : %c\n",expression[i]);
		if(isOperator(expression[i])==1){	//if char is operator than this block will work
			if(isEmpty(st)==1 || checkPrecedence(peek(st))==1){		//if stack is empty or its peek value is '(' then simply push operation will work
				push(st, expression[i]);
			}
			else{		//if stack is not empty than this block will work
				if(checkPrecedence(expression[i])==1){		//if char is '(' then simply pushs it in the stack
					push(st, expression[i]);	
				}
				else if(checkPrecedence(expression[i])==2){		//if char is ')' then pop all char until '(' comes and puts all of them into str2 i.e expression2  
					push(st, expression[i]);
					for(int j=(st->top);st->array[j]!='(';j--){	//poping
						data = pop(st);
						if(isEmpty(st)==0 && data!='(' && data!=')'){
							expression2[count++]=data;
						}
					}
					data = pop(st);	//popping '(' from stack
				}
				else if(checkPrecedence(expression[i])==3){		//if char is '^' then as its associativity is right to left , no matter what operator is present at the top, we will simply push '^' into the stack
					push(st, expression[i]);
				}
				else if(checkPrecedence(expression[i])==4){		//if char is '*' or '/' then we will chech if peek value is ^ then pop all the char until '+' or '-' comes then simply push it into the stack.
					data=peek(st);
					if(checkPrecedence(data)==3){
						while(checkPrecedence(peek(st))==3 || checkPrecedence(peek(st))==4){
							expression2[count++]=pop(st);
						}
						push(st, expression[i]);
					}
					else if(checkPrecedence(data)==4){		
						expression2[count++]=pop(st);
						push(st, expression[i]);
					}
					else if(checkPrecedence(data)==5){
						push(st, expression[i]);
					}
				}
				else if(checkPrecedence(expression[i])==5){		//if char is '+' or '-' then we will  pop all the operator from the stack and then push it in the stack as those have lowest precedence values. 
					data=peek(st);
					if(checkPrecedence(data)==3){
						while(checkPrecedence(peek(st))==3 || checkPrecedence(peek(st))==4 || checkPrecedence(peek(st))==5){
							expression2[count++]=pop(st);
						}
						push(st, expression[i]);
					}
					else if(checkPrecedence(data)==4){
						while(checkPrecedence(peek(st))==4 || checkPrecedence(peek(st))==5){
							expression2[count++]=pop(st);
						}
						push(st, expression[i]);
					}
					else if(checkPrecedence(data)==5){
						expression2[count++]=pop(st);
						push(st, expression[i]);
					}
				}
			}
		}
		else{		//if char is an operands then simply put it into the str2 i.e expression2
			expression2[count++]=expression[i];		//put operand in str2
		}
		int count2=0;
		printf("Stack : ");
		for(int i=0;i<=st->top;i++){
			if(checkPrecedence(st->array[i])>=3)
			count2++;
			printf("%c",st->array[i]);
		}
		printf("\n");
		printf("Postfix : ");
		for(int i=0;i<count;i++){
			printf("%c",expression2[i]);
		}
		printf("\nRank : %d",count2);		//prints the number of operator (excluding parenthesis) present in the stack.
		printf("\n------------------\n");
	}
	while(isEmpty(st)==0){
		expression2[count++]=pop(st);
	}
	expression2[count]='\0';
	strcpy(expression,expression2);
}
int main(){		//main function
	struct stack st;
	char expression[100];
	printf("Enter INFIX expression : ");
	scanf("%s",expression);
	infixToPostfix(expression,&st);
	printf("Expression after Infix To Postfix Coversion : \n%s",expression);
	return 0;
}