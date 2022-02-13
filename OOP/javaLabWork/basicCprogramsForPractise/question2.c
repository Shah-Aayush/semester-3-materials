/*
2. Add two distances (feet (integer) – inch (float) system) and display the result without the return statement. Use structure and function.
*/
#include<stdio.h>
struct distance{
	int foot;
	int inches;
};
void add(struct distance *D1,struct distance *D2);
int main(){
	struct distance d1,d2;
	printf("Enter the details for the first point : \n");
	printf("Foot   : ");
	scanf("%d",&d1.foot);
	printf("Inches : ");
	scanf("%d",&d1.inches);
	printf("Enter the details for the second point : \n");
	printf("Foot   : ");
	scanf("%d",&d2.foot);
	printf("Inches : ");
	scanf("%d",&d2.inches);
	add(&d1,&d2);
	printf("Answer for adding this two distances is : \n");
	printf("Foot   : %d\nInches : %d",d1.foot,d1.inches);
	return 0;
}
void add(struct distance *D1,struct distance *D2){
	if((D1->inches + D2->inches)<12){	//if addition of inches is less then zero then no need to convert inches into feet.
		D1->inches+=D2->inches;
		D1->foot+=D2->foot;
	}
	else{		////if addition of inches is greated then zero then we have to convert inches into feet and have to display remaining inches.

		D1->foot+=D2->foot;		
		D1->foot+=((D1->inches + D2->inches)/12);
		D1->inches=((D1->inches + D2->inches)%12);
	}
}