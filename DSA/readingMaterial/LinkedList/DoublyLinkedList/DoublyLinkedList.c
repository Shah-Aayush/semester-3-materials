/*
DOUBLY LINKED LIST
-> two pointers in each node 
	->We can name them as 'prev' and 'next'.
->List of operations :
	->insert : at starting, ending, after perticular node
	->delete : start, end , perticular node
	->view list :
	->get first : 
	->get last :
	->search a perticular node
	
INSERTION
-> at the start
*/
	#include<stdio.h>
	#include<stdlib.h>
	struct node{
		struct node *prev;
		int info;
		struct node *next;
	};
	void insertStart(struct node **s,int data);
	void insertStart(struct node **s,int data){
		struct node *p;
		p = (struct node *)malloc(sizeof(struct node));
		p->info = data;
		p->prev = NULL;
		if(*s!=NULL && (*s)->next!=NULL)
		(*s)->next->prev = p;
		p->next = *s;	//common for empty and filled linked list
		*s = p;			//common for empty and filled linked list
//		if(*s == NULL){//*s is simply START pointer as **s is double pointer
//			p->next = NULL;
//			*s = p;
//		}		
//		else{
//			p->next = *s;		//this line is same as first line of above if block so simply writing it as common before this block
//			*s = p;
//		}
		//this if block is not needed as the contents of it will be same for if and else both so simply writing them in common
	}
/*
	INSERTION AT LAST	
	->Again there is two posibility that the linkedlist can be empty or filled
		-if empty then simply put null in prev of this node which we are making 
		-If not empty then do the discussed as below.
	->we have to do two operation in this : 
		-put last node[which we will insert]'s address in next of current last node
		-put current last node's address in prev of the node which we are inserting.

*/	
void insertLast(struct node **s, int data){
	struct node *p;
	p = (struct node *)malloc(sizeof(struct node));
	p->next = NULL;
	p->info = data;
//	for p->prev :
	if(*s == NULL){		//list is empty
		p->prev = NULL;
		*s = p;	
	}
	else{		//if list is not empty
		struct node *t;
		t = *s;
		//assigning start's address so that now t will pointing the node which start used to point.
		//if list is empty then t will also points NULL
		//if a node which is t poining to has NULL in next of it then it will be the last node.
		while(t->next!=NULL){
			t = t->next;
		}
		p->prev = t;	//this t is last node of current linked list which will be second last node of linkedlist now on .
		t->next = p;
	}
}
/*
	INSERTION AT AFTER A PERTICULAR NODE
	
	->We must have the address of the node which we want to add our node after that node.
	->so we are also adding parameter of that pointer which value will be stored in pointer named ptr.
	
	-> we have to do following tasks to insert our node just after the node ptr.
		-put address of next pointer after ptr in our node's next
		-put address of our node in ptr's next.
		-put address of ptr in our node's prev.
		-put address of our node in ptr
		's next node 's prev if it is present.
*/
void insertAfter(struct node **s, struct node *ptr,int data);
void insertAfter(struct node **s, struct node *ptr,int data){		
	struct node *p;
	//there can be NULL value in the ptr pointer as if there is no node which contains the data given.
	if(ptr == NULL)
	printf("Invalid Insertion :(\n");
	else{
		p = (struct node *)malloc(sizeof(struct node *));
		p->info = data;
		p->next = ptr->next;
		p->prev = ptr;
		ptr->next = p;
		//if there is null in ptr's next then we dont have to worry because it will also give null to our node's next.
		//if there is no last node then we dont have to put address of our node in that not presenting last node which we are assuming is present.
		// so we will check condition for that if there is last node present then we will assign address of our pointer to it and if not we will just skip it.
		if(ptr->next!=NULL)		//if node after ptr is present then assigning address of our node in ptr's next 's prev.
		p->next->prev = p;
	}
}
/*
SEARCH / FIND 

*/
struct node * find(struct node **s,int data);
struct node * find(struct node **s,int data){
	if(*s == NULL)		//if linkedlist is empty then simply return NULL
	return NULL;
	else{
		struct node *t;
		t = *s;
		while(t->next != NULL){
			if(t->info == data)
			return t;
			t = t->next;
		}
		if(t->info == data)
		return t;
		else
		return NULL;		//if data is not available then it will return null.
	}
}
/*
	DELETION 
	on successfull deletion, we will return 1 otherwise 0.
	->first	
		-put first node's next's address in start
		-put null in this[first node's next] node's prev
		
	->last
		: the node which's next have null is the last pointer
		- we have to assign NULL in the node which points the node which's next has NULL.
		thats it !
		->Again there is possiblity that there are only one node present in the whole linked list 
			- so we have to put null in the start pointer itself.
	->intermediate
		-If we delete the specific node[Intermediate], then the node just behind it , it's next pointer will be Dangling pointer.
		-There are many cases for deleting the intermediate node : 
			->intermediate node is the first node.
				-follow : deleteFirst()
					ptr->prev==NULL
					start = ptr->next
					free(ptr);
			->intermediate node is the really intermediate node.
				-follow deleteLast()
					ptr->prev->next = ptr->next	//that is NULL
					free(ptr)
			->intermediate node is the last node.
				-ptr is the node which we want to delete
				-put :
					ptr->next->prev = ptr->prev
					ptr->prev->next = ptr->next
					free(ptr)
//			->there are only one node in the list
//				follow : deleteFirst()
//				if(start->next == NULL)
//				start=NULL;
//				free(ptr); ----->same as first node
			->list is empty
				-return 0
	
*/
int deleteFirst(struct node **s);
int deleteFirst(struct node **s){
	if(*s==NULL)
	return 0;
	else{
		struct node *t;
		t = *s;	//to avoid memory leak.
		*s = (*s)->next;
		(*s)->prev = NULL;
		free(t);	//free the first node.
		return 1;
	}
}
int deleteLast(struct node **s);
int deleteLast(struct node **s){
	if(*s!=NULL){	//if in linedlist there are 2 or more nodes present then only we have to do this .	
		struct node *t;
		t = *s;
		if((*s)->next == NULL){		//if list has only one node.
			*s=NULL;	//simply assigning null to start.
			free(t);
			return 1;
		}
		else{		//if list has more than one nodes.
			while(t->next!=NULL){
				t = t->next;
			}
			t->prev->next = NULL;
			free(t);
			return 1;
		}
	}		
	else {		//if list is empty
		return 0;
	}
}
int deleteIntermediate(struct node **s,struct node *ptr);
int deleteIntermediate(struct node **s, struct node *ptr){
	if(*s == NULL){	//list is empty
		return 0;
	}
	else if(ptr->prev == NULL){	//ptr is first node
		if(ptr->next!=NULL)
		ptr->next->prev = NULL;
		*s = ptr->next;
		free(ptr);
		return 1;
	}
	else if(ptr->next == NULL){	//ptr is last node
		ptr->prev->next = NULL;
		free(ptr);
		return 1;
	}
	else{	//ptr is intermediate node
		ptr->prev->next = ptr->next;
		ptr->next->prev = ptr->prev;
		free(ptr);
		return 1;
	}
}

/*
ADDITIONAL FUNCTIONS : 
	->viewList()
	->getFirst()
	->getLast()
	->main() : Driver program
*/

void viewList(struct node **s){
	if(*s!=NULL){
		struct node *t;
		t = *s;
		while(t->next!=NULL){
			printf("%d ",t->info);
			t = t->next;
		}
		printf("%d ",t->info);
		printf("\n");
	}
	else{
		printf("List is empty :(\n");
	}
}

int getFirst(struct node **s){
	if(*s==NULL){
		printf("List is empty :(\n");
		return -1;
	}
	else{
		return ((*s)->info);
	}
		
}
int getLast(struct node **s){
	if(*s==NULL){
		printf("List is empty :(\n");
		return -1;
	}
	else{
		struct node *t;
		t=*s;
		while(t->next!=NULL){
			t = t->next;
		}
		return (t->info);
	}
}
	int main(){
		struct node *ptr;
		struct node *start = NULL;	//declared in stdio.h 
//		insertStart(&start,10);	//as start itself is a pointer so that we have to make input type of insertStart as double pointer.
//		insertLast(&start,20);
//		viewList(&start);
		// to find the address of the perticular node we will make the function named find which will find the address of the perticular node which we want to add our node after that node.
		//ptr = find(&start,20)   //this is the function to find the address of that perticular node. it will be stored in the pointer named ptr.	
		
		
//		ptr = find(&start, 20);
//		insertAfter(&start,ptr,30);
		
//		insertStart(&start, 10);
//		viewList(&start);
//		insertLast(&start, 30);
//		viewList(&start);
////		ptr = find(&start,10);
////		insertAfter(&start,ptr, 20);
//		insertAfter(&start,find(&start,10), 20);
//		viewList(&start);
		
		
		int choice = 0,data;
		while(choice!=10){
			printf("MENU : \n");
			printf("[1.]Insert Element at Start (press 1)\n");
			printf("[2.]Insert Element at Specific Position (press 2)\n");
			printf("[3.]Insert Element at Last (press 3)\n");
			printf("[4.]Delete First Element (press 4)\n");
			printf("[5.]Delete Specific Element (press 5)\n");
			printf("[6.]Delete Last Element (press 6)\n");
			printf("[7.]View Elements(press 7)\n");
			printf("[8.]View First Element(press 8)\n");
			printf("[9.]View Last Element(press 9)\n");
			printf("[10.]Exit (press 10)\n");
			printf("Enter Choice : ");
			scanf("%d",&choice);
			switch (choice) {
				case 1:
					printf("Enter data : ");
					scanf("%d",&data);
					insertStart(&start, data);
					break;
				case 2:
					printf("Enter data [the new node will be added after it]: ");
					scanf("%d",&data);
					ptr = find(&start, data);
					printf("Enter data : ");
					scanf("%d",&data);
					if(ptr!=NULL && ptr->next==NULL)
					insertLast(&start, data);
					else
					insertAfter(&start, ptr, data);
					break;
				case 3:
					printf("Enter data : ");
					scanf("%d",&data);
					insertLast(&start, data);
					break;
				case 4: 
					data = deleteFirst(&start);
					if(data==0)
					printf("Invalid Deletion :(\n");
					else
					printf("Deletion Successfully :)\n");
					break;
				case 5: 
					printf("Enter data [the node which has this data will be deleted]: ");
					scanf("%d",&data);
					ptr = find(&start, data);
					data = 0;
					if(ptr!=NULL)
					data = deleteIntermediate(&start, ptr);
					if(data==0)
					printf("Invalid Deletion :(\n");
					else
					printf("Deletion Successfully :)\n");
					break;
				case 6: 
					data = deleteLast(&start);
					if(data==0)
					printf("Invalid Deletion :(\n");
					else
					printf("Deletion Successfully :)\n");
					break;
				case 7:
					viewList(&start);
					break;
				case 8:
					data = getFirst(&start);
					if(data != -1)
					printf("First Element is : %d\n",data);
					else
					printf("List is empty :(\n");
					break;
				case 9:
					data = getLast(&start);
					if(data != -1)
					printf("Last Element is : %d\n",data);
					else
					printf("List is empty :(\n");
					break;
				case 10:
					printf("***THANK YOU***\n");
					break;
				default:
					printf("Invalid Choice :(\n");
					break;
			}
		}
		return 0;
	}
/*
*/
