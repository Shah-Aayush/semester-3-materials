//class GSSArray2 {		//GSS array -> Growable self - sorting array
//	
//	private static int lastIndex;
//	static int size;
//	private int[] arr2;
//	GSSArray2(int size){
//		this.size = size;
//		private int[] arr = new int[size];
//	}
//	public void insert(int number){
//		if(this.size == lastIndex-1){		//if array is full
//				this.increaseSize(2*this.size,number);
//		}
//		else{
//			lastIndex++;
//			arr[lastIndex] = number;
//		}
//	}
//	private void increaseSize(int doubleSize,int number){
//		arr2 = null;
//		arr2 = new int[doubleSize];
//		for(int i=0;i<this.size;i++){
//			arr2[i] = arr[i];
//		}
//		size = doubleSize;
//		lastIndex++;
//		arr2[this.lastIndex] = number;
//		arr = null;
////		int intArray[];    //declaring array
////		intArray = new int[20];  // allocating memory to array
//		arr = new int[doubleSize];
//		arr = arr2.clone();
//	}
//}