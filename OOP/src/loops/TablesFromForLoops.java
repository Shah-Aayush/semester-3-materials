package loops;

public class TablesFromForLoops {

	public static void main(String[] args) {
//		tables upto 20 from nested for loops...
		int result;
		for(int i=1;i<=20;i++){
			{ System.out.print(i+" ");
				for(int j=1;j<=10;j++) {
					result = i*j;
					System.out.print(result + " ");
				}
				System.out.println();
			}
		}
	}

}
