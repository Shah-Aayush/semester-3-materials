/*
->LOGIC : 
	->First we are asking user for entering the polynomial 1
		-This provides following function : 
			1.add term
			2.delete term	[which deletes only first term]
			3.view terms
	->We also provides function for going to next polynomial.
		-after going to the next polynomial user cannot go to back [to the first polynomial].
		-This also provides the same functions as we provided in for first polynomial.
			1.add term
			2.delete term	[which deletes only first term]
			3.view terms
		-At last we provide the function for calculating the addition of the both polynomail.
	->If user move from one polynomial to other, [if user finalize the polynomial] then polynomial will be sorted.
		-from going first polynomial to second polynomial, first polynomial's terms will be sorted in accending order.
		-At the time of calculating the addition of the both polynomial, the second polynomial will also sorted in accending order.
	->Now we will add both polynomial in the function named addLists which has the passing parameters : first polynomial's linkedlist's start pointer and second polynomial's linkedlist's start pointer.
		-LOGIC OF ADDIING BOTH POLYNOMIAL : 
			1. we will use 2 for loops.
				-the first one will traverse the terms of 2nd polynomial.
				-the second one will traverse the terms of 1st polynomial.
			2. we will check every terms of first polynomial from loop number 2 for every terms of second polynomial from loop 1.
				-if we found that both polynomial's term has same exponent, then we will add the coefficient of polynomial 2's term into polynomial 1's term's coefficient.
				-If we cannot find that polynomial 2's term's exponent is not matching with any term's exponent from polynomial 1 then we will add that term from polynomial 2 to polynomial 1.
			3.After the main for loop of polynomial 2 ends, we will sort the terms of polynomial 1 again [so that the addition of new terms(from polynomial 2) are also sorted among the other originally present terms of polynomial 1].
	->At last we will display sorted terms of polynomial 1
								+
								  sorted terms of polynomial 2
								=
								  sorted answer [polynomial 1]
*/

#include "stdio.h"
#include "stdlib.h"
struct node{
	int coefficient;
	int exponent;
	struct node *link;
};
struct node *start1 = NULL;		//for Polynomial 1
struct node *start2 = NULL;		//for Polynomial 2
struct node* createNode(){
//	printf("test1\n");
	struct node *n;		
	n = (struct node*)malloc(sizeof(struct node));	
	if(n == NULL)
		printf("Memory Allocation Failed :(\n");	
	return n;
}
void insertNode(struct node **s){
//	printf("test2\n");		
	struct node *temp;
	int flag = 0,exponent1;
	temp = createNode();
	printf("Enter Coefficient :");
	scanf("%d",&temp->coefficient);
	
	//exponent should not repeat 
	struct node *t;
	t = *s;
	printf("Enter Exponent :");
	scanf("%d",&temp->exponent);
	
	while(flag==0){
		while(t!=NULL){
			if(temp->exponent == t->exponent)
			break;
			t = t->link;		
		}
		if(t!=NULL){
			printf("exponent should not repeat :(\n");
			printf("Enter Exponent again :");
			scanf("%d",&exponent1);
			temp->exponent = exponent1;
			t = *s;
		}
		else{
			flag = 1;
		}
	}
	
	temp->link = NULL;	
	if(*s == NULL){		
		*s = temp;
	}
	else{		
		t = *s;
		while(t->link!=NULL){
			t = t->link;		
		}
		t->link = temp;
	}
}
void deleteNode(struct node **s){		//deleting first node
//	printf("test3\n");
	struct node *r;
	if(*s == NULL)		
	printf("There is no term in the Polynomial :(\n");
	else{
		r = *s;
		*s = (*s)->link;
		free(r); 
	}
}
void viewList(struct node **s){		//view whole list
//	printf("test4\n");
	struct node *t;		
	if(*s==NULL)
	printf("There is no term in the Polynomial :(\n");
	else{
		t = *s;
		while(t!=NULL){
			printf("%dx^(%d) + ",t->coefficient,t->exponent);
			t = t->link;
		}
	}
	printf("\n");
} 
void sortList(struct node **s){
//	printf("test5\n");
	if(*s==NULL)
	return;
	else{
		struct node *pick = NULL;
		struct node *comp = NULL;
		int temp;
		for(pick = *s;pick!=NULL;pick = pick->link){
			for(comp = pick->link;comp!=NULL;comp = comp->link){
				if((pick->exponent)>(comp->exponent)){
					temp = pick->exponent;
					pick->exponent = comp->exponent;
					comp->exponent = temp;
					temp = pick->coefficient;
					pick->coefficient = comp->coefficient;
					comp->coefficient = temp;
				}
			}
		}
	}	
}
void addLists(struct node **s1,struct node **s2){
//	printf("test7\n");
	struct node *index1 = NULL;
	struct node *index2 = NULL;
	int flag = 0,exponent1,coefficient1;
	
	for(index2 = *s2;index2!=NULL;index2=index2->link){
		flag = 0;
		for(index1 = *s1;index1!=NULL;index1=index1->link){
			if(index1->exponent==index2->exponent){
				index1->coefficient += index2->coefficient;
				flag = 1;
				break;
			}
		}
		if(flag == 0){
			struct node *temp;
			struct node *t;
			temp = createNode();
			
			temp->coefficient = index2->coefficient;
			temp->exponent = index2->exponent;
			temp->link = NULL;
			
			t = *s1;
			while(t->link!=NULL){
				t = t->link;		
			}
			t->link = temp;
		}	
	}
	sortList(s1);
}
int main(){
	int choice = 0;
	printf("For Polynomial 1 : \n");
	while(choice!=4){
			printf("[1.]Add term to the Polynomial\n");
			printf("[2.]Delete term from the Polynomial\n");
			printf("[3.]View Polynomial\n");
			printf("[4.]Go to Polynomial 2\n");
			printf("Enter your choice : ");
			scanf("%d",&choice);
		switch (choice) {
			case 1:
				insertNode(&start1);
				break;
			case 2:
				deleteNode(&start1);
				break;
			case 3:
				viewList(&start1);
				break;
			case 4:
				printf("*** Going to polynomial 2 ***\n");
				break;
			default:
				printf("Invalid Choice :(\n");
		}
	}
	
	choice = 0;
	
	printf("Before sorting : ");
	viewList(&start1);
	sortList(&start1);
	printf("After sorting : ");
	viewList(&start1);
	
	while(choice!=4){
			printf("[1.]Add term to the Polynomial\n");
			printf("[2.]Delete term from the Polynomial\n");
			printf("[3.]View Polynomial\n");
			printf("[4.]Exit and Add both polynomial\n");
			printf("Enter your choice : ");
			scanf("%d",&choice);
		switch (choice) {
			case 1:
				insertNode(&start2);
				break;
			case 2:
				deleteNode(&start2);
				break;
			case 3:
				viewList(&start2);
				break;
			case 4:
				printf("*** Adding both Polynomial ***\n");
				break;
			default:
				printf("Invalid Choice :(\n");
		}
	}
	
	printf("Before sorting : ");
	viewList(&start2);
	sortList(&start2);
	printf("After sorting : ");
	viewList(&start2);
	
	viewList(&start1);
	printf(" + \n");
	viewList(&start2);
	printf(" = \n");
	addLists(&start1, &start2);
	viewList(&start1);
	
	return 0;
}