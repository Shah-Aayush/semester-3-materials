class GSSArray {		//GSS array -> Growable self - sorting array
	
	private static int lastIndex;
	lastIndex = 0;
	static int size;
	int flag = 0;
	GSSArray(int size){
		this.size = size;
		private int[] arr = new int[size];
	}
	public void insert(int number){
		if(this.size == lastIndex-1 && flag == 0){		//if array is full
				this.increaseSize(2*this.size,number);
				this.flag = 1;
		}
		else if(this.size == lastIndex-1 && flag == 1){
			System.out.println("Cannot increase the size of the array again :(");
		}
		else if(this.size < lastIndex-1 && flag == 0){
			this.lastIndex++;
			this.arr[lastIndex] = number;
		}
		else{
			this.lastIndex++;
			this.arr2[lastIndex] = number;
		}
	}
	public void display(){
		for(int i=0;i<this.size;i++)
		if(flag==0)
		System.out.println(arr[i]);
		else
		System.out.println(arr2[i]);
	}
	private void increaseSize(int doubleSize,int number){
		private int[] arr2 = new int[doubleSize];
		for(int i=0;i<this.size;i++){
			this.arr2[i] = arr[i];
		}
		this.size = doubleSize;
		this.lastIndex++;
		this.arr2[this.lastIndex] = number;
	}
	public boolean delete(int data){
		int i;
		for(i=0;i<size;i++){
			if(data == arr[i]){
				while(i!=size-1){
					if(flag==0)
					arr[i]=arr[i+1];
					else
					arr2[i]=arr2[i+1];
					i++;
				}
				size--;
				lastIndex--;
				break;
			}	
		}
		if(i!=size-1)
		return false;
		else
		return true;
//		if(i!=size-1)
//		System.out.println("Element not found :(");
//		else
//		System.out.println("Element deleted successfully :)");
	}
}