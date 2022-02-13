/*
3. Calculate time difference between two time periods using structure and pointer.
*/
#include<stdio.h>
#include<string.h>
struct time24hour{		//declaring structure for 24 hour format 
	int hour;
	int minute;
	float second;
};
struct time12hour{		//declaring strucutre for 12 hour format
	int hour;
	int minute;
	float second;
	char amORpm[3];
};
int main(){
	struct time12hour t1,t2,*t1ptr,*t2ptr;
	struct time24hour T1,T2,*T1ptr,*T2ptr;
	t1ptr=&t1;
	t2ptr=&t2;
	T1ptr=&T1;
	T2ptr=&T2;
	
	int choice;		//for giving user to choice between 12 hour format and 24 hour format.
	printf("Select the format : \n[1.] 12 hour format  (press 1)\n[2.] 24 hour format  (press 2)\n");
	scanf("%d",&choice);
	if(choice==1){		//if user selected 12 hour format
		printf("Enter the details for starting time : \n");
		printf("Hour : ");
		scanf("%d",&t1.hour);
		printf("Minute : ");
		scanf("%d",&t1.minute);
		printf("Second : ");
		scanf("%f",&t1.second);
		printf("'am' or 'pm' : ");
		scanf(" %s",t1.amORpm);
		printf("Enter the details for ending time : \n");
		printf("Hour : ");
		scanf("%d",&t2.hour);
		printf("Minute : ");
		scanf("%d",&t2.minute);
		printf("Second : ");
		scanf("%f",&t2.second);
		printf("'am' or 'pm' : ");
		scanf(" %s",t2.amORpm);
		if(strcmp(t1ptr->amORpm, t2ptr->amORpm)==0){	//is two time period are in same range that is 'am' or 'pm'
			if(t1ptr->second>t2ptr->second){
				t2ptr->minute--;
				t2ptr->second=60+t2ptr->second-t1ptr->second;
			}
			else{
				t2ptr->second=t2ptr->second-t1ptr->second;
			}
			if(t1ptr->minute>t2ptr->minute){
				t2ptr->hour--;
				t2ptr->minute=60+t2ptr->minute-t1ptr->minute;
			}
			else{
				t2ptr->minute=t2ptr->minute-t1ptr->minute;
			}
			t2ptr->hour=t2ptr->hour-t1ptr->hour;
		}
		else{		//if two time period in in different range i.e. one is in 'am' and other one is in 'pm'
			t2ptr->hour+=12;
			if(t1ptr->second>t2ptr->second){
				t2ptr->minute--;
				t2ptr->second=60+t2ptr->second-t1ptr->second;
			}
			else{
				t2ptr->second=t2ptr->second-t1ptr->second;
			}
			if(t1ptr->minute>t2ptr->minute){
				t2ptr->hour--;
				t2ptr->minute=60+t2ptr->minute-t1ptr->minute;
			}
			else{
				t2ptr->minute=t2ptr->minute-t1ptr->minute;
			}
			t2ptr->hour=t2ptr->hour-t1ptr->hour;
		}
		printf("Difference between these two time periods is : \nHours : %d\nMinutes : %d\nSeconds : %f\n",t2.hour,t2.minute,t2.second);
	}
	else if(choice==2){		//if user selected 24 hour format
		printf("Enter the details for starting time : \n");
		printf("Hour : ");
		scanf("%d",&T1.hour);
		printf("Minute : ");
		scanf("%d",&T1.minute);
		printf("Second : ");
		scanf("%f",&T1.second);
		printf("Enter the details for ending time : \n");
		printf("Hour : ");
		scanf("%d",&T2.hour);
		printf("Minute : ");
		scanf("%d",&T2.minute);
		printf("Second : ");
		scanf("%f",&T2.second);
		if(T1ptr->second>T2ptr->second){		//if seconds of first time period are greater than second time period [substraction along with conversion]
			T2ptr->minute--;
			T2ptr->second=60+T2ptr->second-T1ptr->second;
		}
		else{		//if seconds of first time period are less than second time period [simply substraction]
			T2ptr->second=T2ptr->second-T1ptr->second;
		}
		if(T1ptr->minute>T2ptr->minute){
			T2ptr->hour--;
			T2ptr->minute=60+T2ptr->minute-T1ptr->minute;
		}
		else{
			T2ptr->minute=T2ptr->minute-T1ptr->minute;
		}
		T2ptr->hour=T2ptr->hour-T1ptr->hour;
		printf("Difference between these two time periods is : \nHours : %d\nMinutes : %d\nSeconds : %f\n",T2.hour,T2.minute,T2.second);
	}
	else{		//if user selected wrong number
		printf("Invalid Choice :(\n");
	}
	return 0; 
}