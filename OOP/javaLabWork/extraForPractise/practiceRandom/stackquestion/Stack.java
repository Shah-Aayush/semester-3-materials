class Stack {
	int sizeInt,sizeChar;
	int topInt,topChar;
	int[] arrInt = new arr[10];
	char[] arrChar = new arr[10];
	Stack(int size){
		this.sizeInt = size;
		this.topInt = -1;
	}
	Stack(int size,char number){
		this.sizeChar = size;
		this.topChar = -1;
	}
	void display(int number){
		for(int i=0;i<this.sizeInt;i++){
			System.out.println(arrInt[i] + " ");
		}
		System.out.println();
	}
	void display(char number){
		for(int i=0;i<this.sizeChar;i++){
			System.out.println(arrChar[i] + " ");
		}
		System.out.println();
	}
	void createStack(int size){
		this.size = size;
		this.top = -1;
//		static int[] arr = new arr[this.size];
	}
	int isEmpty(int number){
		if(this.topInt == -1)
		return 1;
		else
		return 0;
	}
	int isEmpty(char number){
		if(this.topChar == -1)
		return 1;
		else
		return 0;
	}
	int isFull(int number){
		if(this.topInt == (this.size-1))
		return 1;
		else
		return 0;
	}
	int isFull(char number){
		if(this.topChar == (this.size-1))
		return 1;
		else
		return 0;
	}
	int peek(int number){
		if(this.isEmpty() == 0)
		return arrInt[this.topInt];
		else
		return -1;
	}
	char peek(char number){
		if(this.isEmpty() == 0)
		return arrInt[this.topChar];
		else
		return -1;
	}
	int pop(int number){
		if(this.isEmpty() == 0){
			int data = arrInt[this.topInt];
			this.topInt--;
			return data;
		}
		else{
			System.out.println("StackUnderFlow :(");
			return -1;
		}
	}
	char pop(char number){
		if(this.isEmpty() == 0){
			int data = arrChar[this.topChar];
			this.topChar--;
			return data;
		}
		else{
			System.out.println("StackUnderFlow :(");
			return -1;
		}
	}
	void push(int data){
		if(this.isFull() == 0){
			this.top++;
			arrInt[this.top] = data;
		}
		else{
			System.out.println("StackOverFlow :(");
		}
	}
	void push(char data){
		if(this.isFull() == 0){
			this.top++;
			arrchar[this.top] = data;
		}
		else{
			System.out.println("StackOverFlow :(");
		}
	}
}