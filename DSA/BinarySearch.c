#include<stdio.h>
int searchTheNumber(int ,int ,int,int a[]);
int main(){
	int a[100],number,first,last,search,i;
	printf("How many numbers are there ? ");
	scanf("%d",&number);
	printf("Enter %d numbers : ",number);
	for(i=0;i<number;i++){
		scanf("%d",&a[i]);
	}
	printf("Enter the number to find : ");
	scanf("%d",&search);
	first = 0;
	last = number - 1;
	int middle = (first+last)/2;
	while(first <= last){
		if (a[middle] < search)
			first = middle + 1;
		else if (a[middle] == search) {			
			printf("%d found at location %d.\n", search, middle+1);
			break;
		}
		else
		last = middle - 1;
						
		middle = (first + last)/2;
	}
	if (first > last)
	printf("Not found! %d isn't present in the list.\n", search);
	return 0;
}