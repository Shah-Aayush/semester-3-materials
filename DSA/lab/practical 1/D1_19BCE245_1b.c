#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>
int checkAnagram(char anagram1[],char anagram2[]);
void result(int);
int main(){
	char anagram1[100],anagram2[100];
	int n,randomNumber,anagramORnot;
	
	printf("How many words do you want to enter : ");
	scanf("%d",&n);
	char stringArray[n][100];
	for(int i=0;i<n;i++){
		printf("[%d.] ",i+1);
		scanf(" %s",stringArray[i]);
	}
	/*
	for showing the entered strings : 
	for(int i=0;i<n;i++){
		printf("%s",stringArray[i]);
		printf("\n");
	}
	*/
	srand(time(0));
	randomNumber = rand() % (n-1);		//generates a random number from 0 to n-1
	
//	printf("Random Number : %d\n",randomNumber+1); //this shows the random number
	strcpy(anagram1,stringArray[randomNumber]);
//	printf("String at randomNumber : %s\n",anagram1); //this shows the string at index random number
	printf("Enter a string for checking the anagram : ");
	scanf(" %s",anagram2);
	
	anagramORnot=checkAnagram(anagram1, anagram2);
	
	printf("random number generated was : %d\n",randomNumber+1);
	printf("string at index random number : %d was : %s\n",randomNumber+1,anagram1);
	
	result(anagramORnot);
	
	return 0;
}
int checkAnagram(char anagram1[],char anagram2[]){
	int flag=0;
	if(strlen(anagram1)!=strlen(anagram2)){
			printf("Not Anagram :(\n");
			return 0;
//		As length is different !
	}
	else{
		for(int pick=0;pick<strlen(anagram1);pick++){
			for(int comp=0;comp<strlen(anagram2);comp++){
				if(anagram1[pick]==anagram2[comp]){
//					same char changed to zero
					anagram2[comp]='0';
					break;
				}
			}
		}
		flag=0;
		for(int i=0;i<strlen(anagram2);i++){
			if(anagram2[i]=='0')
			continue;
			else {
//				if Not Anagram
				flag=1;
				return 0;
				break;
			}
		}
	if(flag==0)
//		if Anagram 
			return 1;
	}
	return 0;
}
void result(int anagramORnot){
	if(anagramORnot==1){
		printf("You won the game !\n");
	}
	else{
		printf("You lost the game !\n");
	}
}

/*
MERGED input-output
How many words do you want to enter : 4
[1.] aayush
[2.] preet
[3.] shivam
[4.] ansh
Enter a string for checking the anagram : shan
Not Anagram :(
random number generated was : 1
string at index random number : 1 was : aayush
You lost the game !
*/