#include "stdio.h"
#include "string.h"
//making structure for saving record of employee
struct employee{
	char name[20];			//name of employee
	long int salary,mobileNo;	//ID and mobile number
	int age,id;
};
int addRecord(struct employee *a,int );
void display(struct employee [],int );
int modifyRecord(struct employee *a,int );
int deleteRecord(struct employee *a,int );
int main(){
	int choice,count=0;
	struct employee a[100];	//creating a structure array for 100 employees
	printf("*************** EMPLOYEE MANAGEMENT SYSTEM ****************\n");
	printf("MENU : \n");
		printf("[1.] Add record     (press 1)\n");	
		printf("[2.] List of record (press 2)\n");
		printf("[3.] Modify record  (press 3)\n");
		printf("[4.] Delete record  (press 4)\n");
		printf("[5.] Exit           (press 5)\n");
		scanf("%d",&choice);
	while (choice!=5) {			//created a while loop for repeating the process until user choose 'exit'
		if(choice==1){
			count = addRecord(a, count);
		}
		else if(choice==2){
			display(a,count);
		}
		else if(choice==3){
			count=modifyRecord(a,count);
		}
		else if(choice==4){
			count=deleteRecord(a,count);
		}
		printf("MENU : \n");
			printf("[1.] Add record     (press 1)\n");
			printf("[2.] List of record (press 2)\n");
			printf("[3.] Modify record  (press 3)\n");
			printf("[4.] Delete record  (press 4)\n");
			printf("[5.] Exit           (press 5)\n");
			scanf("%d",&choice);		//on the basis of choice running the while loop again if user don't choose 'exit'.
			if(choice<1 || choice>5)
			printf("Invalid Choice :(\n");
	}
	printf("\n************************ THANK YOU ************************\n");
	return 0;
}
void display(struct employee a[],int count)
{
	printf("List of Record : ");	//shows the list of Record
	int i;
	for(i=0;i<count;i++)
	{
		printf("\n");
		printf("\nId = %d",a[i].id);
		printf("\nName = %s",a[i].name);
		printf("\nSalary = %ld",a[i].salary);
		printf("\nMobile Number = %ld",a[i].mobileNo);
	}
	printf("\n\n");
}
int addRecord(struct employee *a,int count){		//adds a record to the structure pointer 
	printf("\nEnter the details of employee ID : %d\n",count+1);
	a[count].id=count+1;
	printf("Enter employee's Name : ");
	scanf(" %[^\n]",a[count].name);
	printf("Enter employee's Age : ");
	scanf("%d",&a[count].age);
	printf("Enter employee's Salary : ");
	scanf("%ld",&a[count].salary);
	printf("Enter employee's Mobile Number : ");
	scanf("%ld",&a[count++].mobileNo);
	printf("Data saved successfully !\n");
	return count;
}
int modifyRecord(struct employee *a,int count){		//modify a record in a structure pointer.
	int sampleID,flag=0;
	printf("Enter the id of the employee for modifying his data : ");
	scanf("%d",&sampleID);
	for(int i=0;i<count;i++){		//this loop searchs for the id which user enetered, then gives facility to modify its data.
		if(sampleID==(i+1)){
			flag=1;
			printf("\nModify the details of employee ID : %d\n",sampleID);
			a[count].id=count;
			printf("employee's OLD Name : ");
			printf(" %s",a[sampleID-1].name);
			printf("\nEnter employee's NEW Name : ");
			scanf(" %[^\n]",a[sampleID-1].name);
			printf("employee's OLD Age : ");
			printf(" %d",a[sampleID-1].age);
			printf("\nEnter employee's NEW Age : ");
			scanf("%d",&a[sampleID-1].age);
			printf("employee's OLD Salary : ");
			printf(" %ld",a[sampleID-1].salary);
			printf("\nEnter employee's NEW Salary : ");
			scanf("%ld",&a[sampleID-1].salary);
			printf("employee's OLD Mobile Number : ");
			printf(" %ld",a[sampleID-1].mobileNo);
			printf("\nEnter employee's NEW Mobile Number : ");
			scanf("%ld",&a[sampleID-1].mobileNo);
			printf("Data saved successfully !\n");
			break;			//as id was already found and after modifying its data, this statements ends the loop so searching process for that id ends.
		}
	}
	if(flag==0){
		printf("ID not found :(\n");	//if user enetered the ID which is not presented in the record then this printf function shows that ID not found.
	}
	return count;
}
int deleteRecord(struct employee *a,int count){		//deletes the desired record from the employee's Record.
	int sampleID;
	printf("Enter the ID number of employee for deleting his information : ");
	scanf("%d",&sampleID);
	if(sampleID>count)
	printf("ID not found :(\n");		//if user enters wrong ID.
	for(int i=sampleID-1;i<count;i++){		//append the records to the structure array which are after the ID (which is just deleted).
		strcpy(a[i].name,a[i+1].name);
		a[i].age=a[i+1].age;
		a[i].salary=a[i+1].salary;
		a[i].mobileNo=a[i+1].mobileNo;
	}
	printf("Record deleted Successfully !\n");
	count--;		//doing 'count-1' as 1 data deleted.
	return count;
}

//input and output are merged (as there is no meaning of showing it individually also this merged input output is easy to understand): 
	/*
		*************** EMPLOYEE MANAGEMENT SYSTEM ****************
		MENU : 
		[1.] Add record     (press 1)
		[2.] List of record (press 2)
		[3.] Modify record  (press 3)
		[4.] Delete record  (press 4)
		[5.] Exit           (press 5)
		1

		Enter the details of employee ID : 1
		Enter employee's Name : Aayush Shah
		Enter employee's Age : 19
		Enter employee's Salary : 20000
		Enter employee's Mobile Number : 1234567890
		Data saved successfully !
		MENU : 
		[1.] Add record     (press 1)
		[2.] List of record (press 2)
		[3.] Modify record  (press 3)
		[4.] Delete record  (press 4)
		[5.] Exit           (press 5)
		1

		Enter the details of employee ID : 2
		Enter employee's Name : Preet Patel
		Enter employee's Age : 19
		Enter employee's Salary : 25000
		Enter employee's Mobile Number : 2345678901
		Data saved successfully !
		MENU : 
		[1.] Add record     (press 1)
		[2.] List of record (press 2)
		[3.] Modify record  (press 3)
		[4.] Delete record  (press 4)
		[5.] Exit           (press 5)
		1

		Enter the details of employee ID : 3
		Enter employee's Name : Shivam Panchal
		Enter employee's Age : 18
		Enter employee's Salary : 30000
		Enter employee's Mobile Number : 1212232334
		Data saved successfully !
		MENU : 
		[1.] Add record     (press 1)
		[2.] List of record (press 2)
		[3.] Modify record  (press 3)
		[4.] Delete record  (press 4)
		[5.] Exit           (press 5)
		1

		Enter the details of employee ID : 4
		Enter employee's Name : Ansh Ray
		Enter employee's Age : 17
		Enter employee's Salary : 35000
		Enter employee's Mobile Number : 12345698765
		Data saved successfully !
		MENU : 
		[1.] Add record     (press 1)
		[2.] List of record (press 2)
		[3.] Modify record  (press 3)
		[4.] Delete record  (press 4)
		[5.] Exit           (press 5)
		2
		List of Record : 

		Id = 1
		Name = Aayush Shah
		Salary = 20000
		Mobile Number = 1234567890

		Id = 2
		Name = Preet Patel
		Salary = 25000
		Mobile Number = 2345678901

		Id = 3
		Name = Shivam Panchal
		Salary = 30000
		Mobile Number = 1212232334

		Id = 4
		Name = Ansh Ray
		Salary = 35000
		Mobile Number = 12345698765

		MENU : 
		[1.] Add record     (press 1)
		[2.] List of record (press 2)
		[3.] Modify record  (press 3)
		[4.] Delete record  (press 4)
		[5.] Exit           (press 5)
		3
		Enter the id of the employee for modifying his data : 1

		Modify the details of employee ID : 1
		employee's OLD Name :  Aayush Shah
		Enter employee's NEW Name : Aayush U Shah
		employee's OLD Age :  19
		Enter employee's NEW Age : 19
		employee's OLD Salary :  20000
		Enter employee's NEW Salary : 21000
		employee's OLD Mobile Number :  1234567890
		Enter employee's NEW Mobile Number : 1111111111
		Data saved successfully !
		MENU : 
		[1.] Add record     (press 1)
		[2.] List of record (press 2)
		[3.] Modify record  (press 3)
		[4.] Delete record  (press 4)
		[5.] Exit           (press 5)
		2
		List of Record : 

		Id = 1
		Name = Aayush U Shah
		Salary = 21000
		Mobile Number = 1111111111

		Id = 2
		Name = Preet Patel
		Salary = 25000
		Mobile Number = 2345678901

		Id = 3
		Name = Shivam Panchal
		Salary = 30000
		Mobile Number = 1212232334

		Id = 4
		Name = Ansh Ray
		Salary = 35000
		Mobile Number = 12345698765

		MENU : 
		[1.] Add record     (press 1)
		[2.] List of record (press 2)
		[3.] Modify record  (press 3)
		[4.] Delete record  (press 4)
		[5.] Exit           (press 5)
		4
		Enter the ID number of employee for deleting his information : 1
		Record deleted Successfully !
		MENU : 
		[1.] Add record     (press 1)
		[2.] List of record (press 2)
		[3.] Modify record  (press 3)
		[4.] Delete record  (press 4)
		[5.] Exit           (press 5)
		2
		List of Record : 

		Id = 1
		Name = Preet Patel
		Salary = 25000
		Mobile Number = 2345678901

		Id = 2
		Name = Shivam Panchal
		Salary = 30000
		Mobile Number = 1212232334

		Id = 3
		Name = Ansh Ray
		Salary = 35000
		Mobile Number = 12345698765

		MENU : 
		[1.] Add record     (press 1)
		[2.] List of record (press 2)
		[3.] Modify record  (press 3)
		[4.] Delete record  (press 4)
		[5.] Exit           (press 5)
		5

		************************ THANK YOU ************************

	*/