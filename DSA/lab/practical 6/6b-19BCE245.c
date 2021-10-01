#include <stdio.h>
void swap(int *x, int *y){		//swap two integers
	int temp = *x;
	*x = *y;
	*y = temp;
}
void heapify(int arr[], int n, int i){		//heapify function which does heaplification
	int largest = i;	//assuming starting index as largest element's integer
	int l = 2*i+1;		//index of left child of largest element
	int r = 2*i+2;		//index of right child of largest element
	
	if(l<n && arr[l] > arr[largest])	//if left child is greater than parent 
	largest = l;
	if(r<n && arr[r] > arr[largest])	//if right child is greater than parent
	largest = r;
	
	if(largest != i){		//if value of largest is changed from initial value which was 'i'
		swap(&arr[i], &arr[largest]);		//swap the new largest element with the previously assumed largest index
		heapify(arr, n, largest);	//heapilification recursively
	}
}
void heapSort(int arr[], int n){
	for(int i=n/2-1;i>=0;i--)	//Building heap 
		heapify(arr, n, i);
	
	for(int i=n-1; i>0; i--){	//sorting
		swap(&arr[0], &arr[i]);		//extracting one element and moving it to last position
		heapify(arr, i, 0);		//heapiflication
	}
}
void printArray(int arr[], int n){
	for(int i=0;i<n;i++)
		printf("%d ",arr[i]);
	printf("\n");
}
int main(){
	int n;
	printf("Enter size of the array : ");
	scanf("%d",&n);
	int arr[n];
	printf("Enter elements : ");
	for(int i=0;i<n;i++)
		scanf("%d",&arr[i]);
	heapSort(arr, n);
	printf("Sorted array : ");
	printArray(arr, n);
	return 0;
}