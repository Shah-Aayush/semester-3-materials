import java.util.Scanner;

public class Main{
		public static void main(String args[]){
			Scanner sc = new Scanner(System.in);
			int choice = 0,number;
			boolean answer;
			Stack st = new Stack();
			while(choice!=5){
				System.out.println("[1.]push (press 1)");
				System.out.println("[2.]pop (press 2)");
				System.out.println("[3.]peek (press 3)");
				System.out.println("[4.]display (press 4)");
				System.out.println("[5.]exit (press 5)");
				System.out.print("Enter Choice : ");
				choice = sc.nextInt();
				switch (choice) {
					case 1:
						System.out.print("Enter number : ");
						number = sc.nextInt();
						answer = st.push(number);
						if(answer)
						System.out.println(number + " is pushed into Stack :)");
						else
						System.out.println("Stack OverFlow :(");
						break;
					case 2:
						number = st.pop();
						if(number != -1)
						System.out.println(number + " is poped from Stack :)");
						else
						System.out.println("Stack UnderFlow :(");
						break;
					case 3:
						number = st.peek();
						if(number != -1)
						System.out.println("Peek value : " + number);
						else
						System.out.println("Stack UnderFlow :(");
						break;
					case 4: 
						st.display();
						break;
					case 5:
						System.out.println("*** Thank You ***");
						break;
					default:
						System.out.println("Invalid Choice :(");
						break;
				}
			}
		}
	}
	
	class Stack {
		static final int max = 100;
		int top;
		int a[] = new int[max];	//size of the stack
		Stack(){	//constructor
			top = -1;
		}
		boolean isEmpty(){
			if(top<0)
			return true;
			else 
			return false;
	//		return (top<0);
		}
		boolean isFull(){
			if(top>=(max-1))
			return true;
			else 
			return false;
		}
		boolean push(int x){
			if(isFull()){
	//			System.out.println("Stack OverFlow :(");
				return false;
			}
			else{
				a[++top] = x;
	//			System.out.println(x + " is pushed into Stack :)");
				return true;
			}
		}
		int pop(){
			if(isEmpty()){
	//			System.out.println("Stack UnderFlow :(");
				return -1;
			}
			else
			return (a[top--]);
		}
		int peek(){
			if(top<0){
				System.out.println("Stack UnderFlow :(");
				return -1;
			}
			else{
				return (a[top]);
			}
		}
		void display(){
			if(top<0){
				System.out.println("Stack UnderFlow :(");
			}
			else{
				for(int i=0;i<=top;i++)
				System.out.println(a[i]);
			}
		}
	}