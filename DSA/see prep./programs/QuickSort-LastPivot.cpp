/* C++ implementation of QuickSort */
#include <bits/stdc++.h> 
using namespace std;  
/* Function to print an array */
void printArray(int arr[], int size)  
{  
  int i;  
  for (i = 0; i < size; i++)  
    cout << arr[i] << " ";  
  cout << endl;  
}  
// A utility function to swap two elements  
void swap(int* a, int* b)  
{  
    cout<<"Swapping "<<*a<<" and "<<*b<<endl;
    int t = *a;  
    *a = *b;  
    *b = t;  
}  
  
/* This function takes last element as pivot, places  
the pivot element at its correct position in sorted  
array, and places all smaller (smaller than pivot)  
to left of pivot and all greater elements to right  
of pivot */
int partition (int arr[], int low, int high)  
{  
    int pivot = arr[high]; // pivot  
    cout<<"Pivot element : "<<pivot<<endl;
    int i = (low - 1); // Index of smaller element  
    
    for (int j = low; j <= high - 1; j++)  
    {  
        // If current element is smaller than the pivot  
        if (arr[j] < pivot)  
        {  
            cout<<arr[j]<<" is smaller than pivot : \t";
            i++; // increment index of smaller element  
            swap(&arr[i], &arr[j]);  
        } 
      else{
          cout<<arr[j]<<" is NOT smaller than pivot."<<endl;
      }
    }  
    cout<<"at last : changedValues i="<<i+1<<"\t\t";
    swap(&arr[i + 1], &arr[high]);  
    return (i + 1);  
}  
  
/* The main function that implements QuickSort  
arr[] --> Array to be sorted,  
low --> Starting index,  
high --> Ending index */
void quickSort(int arr[], int low, int high)  
{  
    cout<<"LOW : "<<low<<" HIGH : "<<high<<endl;
    if (low < high)  
    {  
        /* pi is partitioning index, arr[p] is now  
        at right place */
        cout<<"BEFORE pivot selection : ";
        printArray(arr,high+1);
        int pi = partition(arr, low, high);  
        cout<<"Partition from : "<<pi<<endl;
//        cout<<"Pivot element : "<<pi<<endl;
        cout<<"AFTER pivot selection : ";
        printArray(arr,high+1);
        // Separately sort elements before  
        // partition and after partition  
        quickSort(arr, low, pi - 1); 
        cout<<"After Sorting elements BEFORE Partition : ";
        printArray(arr,high+1);
        quickSort(arr, pi + 1, high); 
        cout<<"After Sorting elements AFTER Partition : ";
        printArray(arr,high+1);
    }  
}  
  

  
// Driver Code 
int main()  
{  
//    int arr[] = {10, 7, 8, 9, 1, 5};  //enter here
    int arr[] = {34,67,12,78,67,89,60,23,90,57};  //enter here
    int n = sizeof(arr) / sizeof(arr[0]);  
    quickSort(arr, 0, n - 1);  
    cout << "Sorted array: \n";  
    printArray(arr, n);  
    return 0;  
}  