package arrays;

public class ArrayIntro {

	public static void main(String[] args) {
		
//		dataType[] arrayName;
//		arrayName = new Datatype[n]
//					OR			(where n is the number of string the maximum value in the array)
//		dataType[] arrayName = new dataType[n];
		
//		there are two types for making array ...

//		type 1 : int[] marks;
//				 marks = new int[5]
		
//		type 2 : int[] marks = new int[5]
		
//		example 1:
		
//		int[] marks = new int[5];
		
//		 OR int marks[] = new int[5]; --> only for 1 array... -->for defining 2 arrays in 1 line we must use above syntex
//		because if we use int marks[] , classes ; then only marks will be array and classes will be simple int variable --> for this we use int[] classes , marks;
//		in arrays index always starts with 0 in this all values stored with contigues ...means location of all is consequetively
//	by default in all locations values stored in  them is zero -->0	
		
//		System.out.println(marks[0]);
//		System.out.println(marks[1]);
//		System.out.println(marks[5]);
		
//		in marks[5] it will show error because we  only defined till 5 means 0,1,2,3,4 this is RUN TIME ERROR
//		but in eclipse when syntex is wrong and then when eclipse shows error then it's COMPILE TIME ERROR
		
//		example 2
		
//		 int[] age= {2,5,45,56,3};
//		 in this example we didnt define the max value for array then it will assume (default) that the lengh is 5
		
//		example 3 
		
		double[] marks = {1.2,3.14,2.0,6.7,5.9};
		System.out.println(marks[0]);
		
//		we can also edit value in this array...ex.
		
		marks[0]=9.9;
		
//		  
		
//		for getting all values from an array we should not do this stuffs as shown above we should simply run LOOP as shown below
		
		
	}

}
