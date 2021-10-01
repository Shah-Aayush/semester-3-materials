/*
MANUAL : 
	->This Application provides most of all the functionalities which actual PlayList should have !
	->In this Application , You can create your own playlist which will have name of the song and length of the song.
	->For First time you add a song, It will be played by default.
	->You can play next song, previous song, specific song [by searching it name], first song, last song 
	->You can also view songs without playing them : You can view full PlayList, only view First Song , only view Last Song , view currenrtly playing song
	->You can create your playlist : You can add song at any position you want like :  you can add song at Starting, at last, at specific position [searching a song and adding after it]
	->You can remove songs from the playlist also : You can remove first song from play list, last song from playlist, specific song from playlist
	->Please expand output window to see full message [as Menu has many options]
	->Enjoy!
	
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
struct node{		//doubly LinkedList
	struct node *prev;
	char songName[20];
	float songLength;	//in minutes
	struct node *next;
};	
struct node *ptrSong;		//current Playing Song
int flag = 0;				//flag -> 0 when there is no song in the playlist [at starting]
void insertStart(struct node **s){			//Add song at starting
	
	//input starts
	char SongName[20];
	float SongLength;
	printf("Enter Song Name : "); 
	scanf(" %[^\n]",SongName);
	printf("Enter Song Length in minutes : ");
	scanf("%f",&SongLength);
	//input ends
	
	struct node *p;
	p = (struct node *)malloc(sizeof(struct node));
	strcpy(p->songName,SongName);
	p->songLength = SongLength;
	p->prev = NULL;
	if(*s!=NULL && (*s)->next!=NULL)
	(*s)->next->prev = p;
	p->next = *s;
	*s = p;
	if(flag==0){
		ptrSong = p;
		flag = 1;
	}	//only assign for first time.
	
}
void insertLast(struct node **s){		//Add song at Last
	
	//input starts
	char SongName[20];
	float SongLength;
	printf("Enter Song Name : ");
	scanf(" %[^\n]",SongName);
	printf("Enter Song Length in minutes : ");
	scanf("%f",&SongLength);
	//input ends
	
	struct node *p;
	p = (struct node *)malloc(sizeof(struct node));
	p->next = NULL;
	p->songLength = SongLength;
	strcpy(p->songName,SongName);
	if(*s == NULL){		//if list is empty
		p->prev = NULL;
		*s = p;
	}
	else{		//list is not empty 
		struct node *t;
		t = *s;
		while(t->next != NULL){
			t = t->next;
		}
		t->next = p;
		p->prev = t;
	}
	if(flag==0){
		ptrSong = p;
		flag = 1;
	}	//only assign for first time
}
void insertAfter(struct node **s, struct node *ptr){		//Add song at specific position
	
	//input starts
	char SongName[20];
	float SongLength;
	printf("Enter Song Name : ");
	scanf(" %[^\n]",SongName);
	printf("Enter Song Length in minutes : ");
	scanf("%f",&SongLength);
	//input ends
	
	struct node *p;
	if(ptr == NULL)
	printf("Cannot find song :(\n");
	else{
		p = (struct node *)malloc(sizeof(struct node *));
		p->songLength = SongLength;
		strcpy(p->songName,SongName);
		p->next = ptr->next;
		p->prev = ptr;
		ptr->next = p;
		if(ptr->next != NULL)
		p->next->prev = p;
	}
	if(flag==0){
		ptrSong = p;
		flag = 1;
	}	//only assign for first time
}
struct node * find(struct node **s){		//find specific song's node's address and return it.
		
	//input starts
	char SongName[20];
	printf("Enter Song Name : ");
	scanf(" %[^\n]",SongName);
	//input ends
	
	if(*s == NULL){
		printf("There is no Song in PlayList :(\n");
		return NULL;
	}
	else{
		struct node *t;
		t = *s;
		while(t->next !=NULL){
			if(strcmp(t->songName, SongName)==0)
			return t;
			t = t->next;
		}
		if(strcmp(t->songName, SongName)==0)
		return t;
		else 
		return NULL;
	}
}
int deleteFirst(struct node **s){		//Removes First Song
	if(*s == NULL){
		flag = 0;			//If there are no song in the playlist then setting flag to zero so that whenever user adds a new song to the playlist, it will be playing as current song by assiging it to ptrSong
		return 0;
	}
	else if((*s)->next == NULL){		//if there is only one song in the PlayList
		struct node *t;
		t = *s;
		free(t);
		*s = NULL;
		return 1;
	}
	else{
		struct node *t;
		t = *s;
		*s = (*s)->next;
		(*s)->prev = NULL;
		free(t);
		if(strcmp((ptrSong)->songName, (*s)->songName)==0)
		ptrSong = *s;
		return 1;
	}
}
int deleteLast(struct node **s){		//Removes Last Song
	if(*s != NULL){
		struct node *t;
		t = *s;
		if((*s)->next == NULL){
			*s=NULL;	
			free(t);
			return 1;
		}
		else{
			while(t->next!=NULL){
				t = t->next;
			}
			t->prev->next = NULL;
			free(t);
			return 1;
		}
	}
	else {		//if list is empty
		flag = 0;
		return 0;
	}
}
int deleteIntermediate(struct node **s, struct node *ptr){		//Removes Specific Song
	if(*s == NULL){	//list is empty
		flag = 0;
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
void viewList(struct node **s){		//View full PlayList
	if(*s!=NULL){
		struct node *t;
		t = *s;
		printf("PLAY LIST : \n");
		while(t->next!=NULL){
			printf("Song Name : %s\nSong Length : %f\n",t->songName,t->songLength);
			printf("----------------------------------\n");
			t = t->next;
		}
		printf("Song Name : %s\nSong Length : %f\n",t->songName,t->songLength);
		printf("----------------------------------\n");
	}
	else{
		printf("There is no song in PlayList :(\n");
	}
}
void getFirst(struct node **s){			//View First Song
	if(*s==NULL){
		printf("There is no song in PlayList :(\\n");
	}
	else{
		printf("Song Name : %s\nSong Length : %f\n",(*s)->songName,(*s)->songLength);
	}
		
}
void getLast(struct node **s){		//View Last Song
	if(*s==NULL){
		printf("There is no song in PlayList :(\n");
	}
	else{
		struct node *t;
		t=*s;
		while(t->next!=NULL){
			t = t->next;
		}
		printf("Song Name : %s\nSong Length : %f\n",t->songName,t->songLength);
	}
}
void getSpecific(struct node *ptr){			//shows the details of specific song
	if(ptr!=NULL){
		printf("Song Name : %s\nSong Length : %f\n",ptr->songName,ptr->songLength);
	}
	else
	printf("Song not available :(\n");
}
int main(){				//Driver Program [MENU DRIVEN]
	struct node *ptr;
//	struct node *ptrSong;
	struct node *start = NULL;
	int choice = 0,data;
	float Length;
	char Name[20];
	while(choice!=16){
		printf("----------------------------------\n");
		printf("PLAYLIST MENU : \n");
		printf("[1.]Add Song at Start (press 1)\n");
		printf("[2.]Add Song at Specific Position (press 2)\n");
		printf("[3.]Add Song at Last (press 3)\n");
		printf("[4.]Remove First Song (press 4)\n");
		printf("[5.]Remove Specific Song (press 5)\n");
		printf("[6.]Remove Last Song (press 6)\n");
		printf("[7.]View full PlayList (press 7)\n");
		printf("[8.]View First Song (press 8)\n");
		printf("[9.]View Last Song (press 9)\n");
		printf("[10.]View current playing Song (press 10)\n");
		printf("[11.]Play Next Song (press 11)\n");
		printf("[12.]Play Previous Song (press 12)\n");
		printf("[13.]Play Specific Song (press 13)\n");
		printf("[14.]Play First Song (press 14)\n");
		printf("[15.]Play Last Song (press 15)\n");
		printf("[16.]Exit (press 16)\n");
		printf("Enter Choice : ");
		scanf("%d",&choice);
		printf("----------------------------------\n");
		switch (choice) {
			case 1:
				insertStart(&start);
				break;
			case 2:
				printf("The new song will be added after this song : \n");
				ptr = find(&start);
				if(ptr!=NULL && ptr->next==NULL)
				insertLast(&start);
				else
				insertAfter(&start, ptr);
				break;
			case 3:
				insertLast(&start);
				break;
			case 4: 
				data = deleteFirst(&start);
				if(data==0)
				printf("Cannot find song :(\n");
				else
				printf("Song removed successfully :)\n");
				break;
			case 5: 
				printf("This song will be removed from the PlayList : \n");
				ptr = find(&start);
				data = 0;
				if(ptr!=NULL)
				data = deleteIntermediate(&start, ptr);
				if(data==0)
				printf("Cannot find Song :(\n");
				else
				printf("Song removed successfully :)\n");
				break;
			case 6: 
				data = deleteLast(&start);
				if(data==0)
				printf("Cannot find Song :(\n");
				else
				printf("Song removed successfully :)\n");
				break;
			case 7:
				viewList(&start);
				break;
			case 8:
				getFirst(&start);
				break;
			case 9:
				getLast(&start);
				break;
			case 10:
				printf("Playing : \n");
				getSpecific(ptrSong);
				break;
			case 11:
				if(ptrSong!=NULL && (ptrSong)->next!=NULL){
					ptrSong = (ptrSong)->next;
					printf("Playing : \n");
					getSpecific(ptrSong);
				}
				else{
					printf("Song not available :(\n");
				}
				break;
			case 12:
				if(ptrSong!=NULL && (ptrSong)->prev!=NULL){
					ptrSong = (ptrSong)->prev;
					printf("Playing : \n");
					getSpecific(ptrSong);
				}
				else{
					printf("Song not available :(\n");
				}
				break;
			case 13:
				ptr = find(&start);
				if(ptr!=NULL){
					printf("Playing : \n");
					ptrSong = ptr;
					getSpecific(ptrSong);
				}
				else{
					printf("Song not available :(\n");
				}
				break;
			case 14:
				ptrSong = start;
				printf("Playing : \n");
				getSpecific(ptrSong);
				break;
			case 15:
				if(start==NULL){
					printf("There is no song in PlayList :(\n");
				}
				else{
					struct node *t;
					t=start;
					while(t->next!=NULL){
						t = t->next;
					}
					ptrSong = t;
					printf("Playing : \n");
					getSpecific(ptrSong);
				}
				break;
			case 16:
				printf("***THANK YOU***\n");
				break;
			default:
				printf("Invalid Choice :(\n");
				break;
		}
	}
	return 0;
}