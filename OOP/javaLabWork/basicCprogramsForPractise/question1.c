/*1. Write a program in C to check whether two given strings are an
anagram. An anagram of a string is another string that contains same
characters, only the order of characters can be different. For example, “abcd”
and “dabc” are anagram of each other.*/
//logic 1 : sort and compare both strings
//logic 2 : compare every char and covert it zero in other string if it is present in second at last if every char is zero in second string then it is anagram otherwise not.
#include<stdio.h>
#include<string.h>
int main(){
	char first[20],second[20];
	printf("Enter the first string : ");
	scanf(" %[^\n]",first);		//taking first string
	printf("Enter the second string : ");
	scanf(" %[^\n]",second);	//taking second string
	int flag=0;				
	if(strlen(first)!=strlen(second)){
		printf("Not Anagram :(\n");		//As length is different
	}
	else{
		for(int pick=0;pick<strlen(first);pick++){
			for(int comp=0;comp<strlen(second);comp++){
				if(first[pick]==second[comp]){
					second[comp]='0';		//matched character with first string is converted in zero
					break;
				}
			}
		}
		flag=0;
		for(int i=0;i<strlen(second);i++){
			if(second[i]=='0')
			continue;
			else {
				printf("Not Anagram :(\n");		//if any char in second string is not zero than returning that its not anagram. as all char are not covered
				flag=1;
				break;
			}
		}
		if(flag==0)
		printf("Anagram :)");	//if all characters matched.
	}
	
	return 0;
}