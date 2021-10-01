#include<stdio.h>
int main(){
	printf("Enter the number of elements : ");
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&a[n]);
	}
	for(int pick=0;pick<n;pick++){
		for(int comp=pick+1;comp<n;comp++){
			if(a[pick]>a[comp]){
				int temp=a[pick];
				a[pick]=a[comp];
				a[comp]=temp;
			}
		}
	}
	printf("Sorted : \n");
	for(int i=0;i<n;i++){
		printf("%d ",a[n]);
	}
	return 0;
}