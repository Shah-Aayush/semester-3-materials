/*
Write a program to implement Binary search operation on a given set of integers.
*/

/*
LOGIC USED : 
	->We are first stroing the indput in the structure (here structure named arr). in which one value and other one is index.
	->then we apply quicksort algorithm
	->then we apply binary search algorithm for searching the specific integer value 'x'.
	->the binary search function will return the new index of the struct arr element which is after sorting. So to know the original index before sorting of that specific structure element's value, we will get it by structure member 'Index'.
*/
#include <stdio.h>

struct arr{		//struct for storing the value and original index of value in the array
	int Value,Index;
};

//SORTING STARTS
void swap(struct arr *x, struct arr *y){		//swaps two struct arr 
	struct arr temp;
	temp.Value = x->Value;		//temp = *x;
	temp.Index = x->Index;
	
	x->Value = y->Value;		//*x = *y;
	x->Index = y->Index;
	
	y->Value = temp.Value;		//*y = temp;
	y->Index = temp.Index;		
	
}
int partition(struct arr a[], int low, int high){
	int i = low-1;		//i will be index of smaller element
	int pivot = a[high].Value; 
	for (int j = low;j <= high-1;j++) {
		if(a[j].Value < pivot){		
			i++;		//incresing the index of smaller element
			swap(&a[i],&a[j]);		
		}
	}
	swap(&a[i+1], &a[high]);
	return i+1;
}
void quickSort(struct arr a[], int low, int high){	//here low is starting index and high is ending index
	if(low<high){
		int pi = partition(a, low, high);
		quickSort(a, low, pi-1);
		quickSort(a, pi+1, high);
	}
}
//SORTING ENDS

//BINARY SEARCH OPERATION STARTS
int binarySearch(struct arr a[], int l, int r, int x){		//recursive binary search operation function which returns  element x's index from sorted array arr[]. if it is not present then returns -1.
	if(r>=1){		
		int middle = (l + r)/2;
		if(a[middle].Value == x)
			return middle;
		
		if(a[middle].Value>x)
			return binarySearch(a, l, middle-1, x);
			
		return binarySearch(a, middle+1, r, x);
	}
	
	return -1;
}
//BINARY SEARCH OPERATION ENDS

//DRIVER PROGRAM
int main() {
	int n,x;
	printf("Enter the size of the array : ");
	scanf("%d",&n);
	struct arr a[n];
	printf("Enter %d integers : \n",n);
	for (int i=0;i<n;i++) {
		a[i].Index = i;		//storing the index in structure member 'Index'.
		scanf("%d",&a[i].Value);
	}
	printf("Enter integer to find its Index : ");
	scanf("%d",&x);
	
//	printf("Unsorted : ");		//prints unsorted array 
//	for(int i=0;i<n;i++)
//	printf("%d ",a[i].Value);
//	printf("\n");
	
	quickSort(a, 0, n-1);		//applying Quick Sort algo.
	
//	printf("Sorted : ");		//prints sorted array
//	for(int i=0;i<n;i++)
//	printf("%d ",a[i].Value);
//	printf("\n");
	
	int index = binarySearch(a, 0, n-1, x);		//applying Binary Search algo.
	
	if(index!=-1)
		printf("Index of %d is %d :)\n",x,a[index].Index);		// this function will return the new index which is after sorting. Old index of that specific structure element is stored in the structure member named 'Index'.
	else
		printf("Integer is not present in the given array :(\n");
		
	return 0;
}