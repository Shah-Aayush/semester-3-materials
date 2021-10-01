/*
Heap Sort
	->One main application of Heap ADT is sorting, called Heap Sort.
	
	-LOGIC 
		-Insert all elements of an unsorted array into the Heap
		-Remove the maximum element (root node element) from the heap and exchange it with the last value of array.
		-Heapify
		-Repeat the process until heap remains with single element
		
*/

///*
//mysirg code
//#include <stdio.h>
//struct Heap{
//	int *array;
//	int count;
//	int capacity;
//}
//
//int main() {
//	
//}
//*/




/*
//GFG
Heap Sort Algorithm for sorting in increasing order:
1. Build a max heap from the input data.
2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of the tree.
3. Repeat step 2 while size of heap is greater than 1.
*/


/*
//GFG code
#include "stdio.h"
void swap(int *x, int *y){
	int temp = *x;
	*x = *y;
	*y = temp;
}
void heapify(int arr[], int n, int i){
	int largest = i;
	int l = 2*i+1;
	int r = 2*i+2;
	
	if(l<n && arr[l] > arr[largest])
	largest = l;
	if(r<n && arr[r] > arr[largest])
	largest = r;
	
	if(largest != i){
		swap(&arr[i], &arr[largest]);
		heapify(arr, n, largest);
	}
}
void heapSort(int arr[], int n){
	
	for(int i=n/2-1;i>=0;i--)
		heapify(arr, n, i);
	
	for(int i=n-1; i>0; i--){
		swap(&arr[0], &arr[i]);
		heapify(arr, i, 0);
	}
}
void printArray(int arr[], int n){
	for(int i=0;i<n;i++)
		printf("%d ",arr[i]);
	printf("\n");
}
int main(){
	int arr[] = {12,11,13,5,6,7};
	int n = sizeof(arr)/sizeof(arr[0]);
	heapSort(arr, n);
	printArray(arr, n);
	return 0;
}
*/
