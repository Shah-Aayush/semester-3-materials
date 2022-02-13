import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0,number;
		boolean answer;
		System.out.print("Enter size of the Queue : ");
		number = sc.nextInt();
		Queue Q = new Queue(number);
		while(choice!=6){
			System.out.println("[1.]EnQueue (press 1)");
			System.out.println("[2.]DeQueue (press 2)");
			System.out.println("[3.]Front (press 3)");
			System.out.println("[4.]Rear (press 4)");
			System.out.println("[5.]Display (press 5)");
			System.out.println("[6.]Exit (press 6)");
			System.out.print("Enter Choice : ");
			choice = sc.nextInt();
			switch (choice) {
				case 1:
					System.out.print("Enter number : ");
					number = sc.nextInt();
					answer = Q.enQueue(number);
					if(answer)
					System.out.println(number + " is EnQueued into Queue :)");
					else
					System.out.println("Queue is Full :(");
					break;
				case 2:
					number = Q.deQueue();
					if(number != -1)
					System.out.println(number + " is DeQueued from Queue :)");
					else
					System.out.println("Queue is Empty :(");
					break;
				case 3:
					number = Q.front();
					if(number != -1)
					System.out.println("Front value : " + number);
					else
					System.out.println("Queue is Empty :(");
					break;
				case 4:
					number = Q.rear();
					if(number != -1)
					System.out.println("Rear value : " + number);
					else
					System.out.println("Queue is Empty :(");
					break;
				case 5: 
					Q.display();
					break;
				case 6:
					System.out.println("*** Thank You ***");
					break;
				default:
					System.out.println("Invalid Choice :(");
					break;
			}
		}
	}
}
class Queue{
	int front, rear, size, maxSize;
	int a[];
	public Queue(int maxSize){
		this.maxSize = maxSize;
		front = 0;
		this.size = 0;
		rear = -1;
		a = new int[this.maxSize];
	}
	boolean isFull(){
		if(this.size == this.maxSize)
		return true;
		else
		return false;
	}
	boolean isEmpty(){
		if(this.size == 0)
		return true;
		else
		return false;
	}
	boolean enQueue(int number){
		if(isFull()){
			return false;
		}
		else{
			this.rear++;
			this.a[rear] = number;
			this.size++;
			return true;
		}
	}
	int deQueue(){
		if(isEmpty())
		return -1;
		else{
			if(front!=(this.maxSize-1)){
				this.size--;
				return (a[this.front++]);
			}
			else{
				int number = a[this.front];
				front = 0;
				rear = -1;
				this.size--;
				return (number);
			}
			
		}
		
	}
	int front(){
		if(isEmpty())
		return -1;
		else
		return this.a[this.front];
	}
	int rear(){
		if(isEmpty())
		return -1;
		else
		return this.a[this.rear];
	}
	void display(){
		if(isEmpty())
		System.out.println("Queue is Empty :(");
		else
		for(int i=front;i<=rear;i++)
		System.out.println(a[i]);
	}
}
