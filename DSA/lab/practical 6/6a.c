#include <stdio.h>
void swap(int *x, int *y){		//swaps two integers using pointer concept
	int temp = *x;
	*x = *y;
	*y = temp;
}
int partition(int arr[], int low, int high){	//
	int pivot = arr[high];		//considering last element as pivot element.
	int i,j;
	i = low-1;		//i will be the starting index of smaller elements
	for (j=low;j<high;j++) {
		if(arr[j]<pivot){		//in the current iteration, if the current element is smaller then pivot then swaps it and add it to smaller element portion
			i++;
			swap(&arr[j], &arr[i]);
		}
	}
	swap(&arr[high], &arr[i+1]);
	return (i+1);
}
void quickSort(int arr[], int low, int high){		//main function for the implementation of quicksort
	if(low<high){		//when in below quicksort functions, from statement 1 if high gets same as low or from statement 2 if low gets same as high then this recursion should stop.
		int pivot = partition(arr,low,high);
		quickSort(arr, low, pivot-1);		//statement 1
		quickSort(arr, pivot+1, high);		//statement 2
	}
}
void printArray(int arr[], int size){
	for(int i=0;i<size;i++)
		printf("%d ",arr[i]);
	printf("\n");
}
int main() {
	int arr[10],n;
	printf("Enter size of array : ");
	scanf("%d",&n);
	printf("Enter elements : \n");
	for(int i=0;i<n;i++)
	scanf("%d",&arr[i]);
//	int n = sizeof(arr)/sizeof(arr[0]);
	quickSort(arr, 0, n-1);
	printf("Sorted Array : ");
	printArray(arr, n);
}

/*
NOTES : 
QUICK SORT
	-Sorting : 
		-Sorting is the process of arranging the data in the some logical order.
		-This logical order may be ascending or descending in case of numeric values or dictionary order in case of alphanumeric values
		-Two types of sorting :
			1.Internal sorting	[quick sort is internal sorting ]
			2.External sorting
	
	-Quick Sort :
		-Quick sort is an algorithm of the divide and conquer type.That is, the problem of sorting a set is reduced to the problem of sorting two smaller set.
		
	-Working logic :
		-Procedure QUICKSORT
		-Algorithm PARTITION
		
*/