/*
SELECTION SORT
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order) from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

1) The subarray which is already sorted.
2) Remaining subarray which is unsorted.

In every iteration of selection sort, the minimum element (considering ascending order) from the unsorted subarray is picked and moved to the sorted subarray.
*/
#include <stdio.h>
void swap(int *xp, int *yp){
	int temp = *xp;
	*xp = *yp;
	*yp = temp;
}
void selectionSort(int arr[], int n){
	int minIndex;
	for(int i=0;i<n-1;i++){
		minIndex = i;
		for(int j=i+1;j<n;j++){
			if(arr[j]<arr[minIndex])
			minIndex = j;
		}
		swap(&arr[i], &arr[minIndex]);
	}
}
void printArray(int arr[],int n){
	for(int i=0;i<n;i++)
	printf("%d ",arr[i]);
	printf("\n");
}
int main() {
	int arr[] = {64,25,12,22,11};
	int n = sizeof(arr)/sizeof(arr[0]);
	
	printf("Unsorted array : ");
	printArray(arr, n);
	
	selectionSort(arr, n);
	
	printf("Sorted array : ");
	printArray(arr, n);
	return 0;
}