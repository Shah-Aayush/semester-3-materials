#include <stdio.h>
void merge(int arr[], int l, int m, int r){
	int i,j,k;
	int n1 = m-l+1;		//number of elements in 1st temp array
	int n2 = r-m;		//number of elements in 2nd temp array
	
	int L[n1],R[n2];
	
	//copying the content of original array to temp array L[] and R[]
	for(i=0;i<n1;i++)
		L[i] = arr[l + i];
	for(i=0;i<n2;i++)
		R[i] = arr[m + 1 + i];
	
	//Merging these two temp arrays back to arr
	i=0;
	j=0;
	k=l;
	while(i<n1 && j<n2){
		if(L[i] <= R[j])
			arr[k++] = L[i++];
		else
			arr[k++] = R[j++];	
	}
	
	//copying the remaining elements of L[] and R[], if there are any.
	while(i<n1)
		arr[k++] = L[i++];
	while(j<n2)
		arr[k++] = R[j++];
	
}
void mergeSort(int arr[], int l, int r){	//where l is the left index and r is the right index of the subarray to be sorted
	if(l<r){
		int m = (l+r)/2;	//partition point

		mergeSort(arr, l , m);		//sort first subarray
		mergeSort(arr, m+1, r);		//sort second subarray
		merge(arr, l , m , r);		//merge both subarray
	}
}
void printArray(int arr[], int n){
	for(int i=0;i<n;i++)
		printf("%d ",arr[i]);
	printf("\n");
}
int main(int argc, char *argv[]) {
	int n;
	printf("Enter number of elements : ");
	scanf("%d",&n);
	int arr[n];
	for(int i=0;i<n;i++)
		scanf("%d",&arr[i]);
	
	mergeSort(arr, 0, n-1);
	printf("Sorted array : ");
	printArray(arr, n);
}