/*
	HUFFMAN CODING
		-Data compression, variable length coding algo, in which size of data is to be reduced.
		-Fixed length coding.
			-When we have msg like ABBCDB...BEAB then we dont need to apply 8bit on every character. we just have unique 5 characters so that we can represent it in 3 bit also [2^3 = 8 ==>upto8 unique character we can use 3bit] so we will make table like this : 
			A	000
			B	001	
			C	010	
			D	011
			E	100 and we will also encode the msg using this format and we will send the msg along with this table to receiver. 
			-Before this technique is applied suppose we required 160 bits as 8*20 [8bit per character * 20 character] .
			-After applying this technique we requreid 3*20=60bit for msg and 5*8[real char] + 5*3[encoded char]= 55bit
				SO TOTAL OF 115bit required. which is less then the origianl msg.
			->THIS IS FIXED LENGTH CODING as every char is represented with fixed 3 bits but in variable coding, some variable can also be represented with two bit/one bit etc. thats why its variable length coding.
		
	=>VARIABLE LENGTH CODING {HAFFMAN CODING}
		-msg : ABBCDBCCDAABBEEEBEAB
		
		->Table : 
			char | frequency/count
			A		4
			B		7
			C		3
			D		2	
			E		4
		
		->Arranging in increasing order: 
			 2 3 4 4 7
			 D C E A B
			[we can also take A first instead of E. it is upto you as both have the same frequency.]
		
		-Two least frequency character : [priority queue - less frequceny ~ more priority]
		->Making tree : 
		2 3 4 4 7
		D C E A B
		
		=>taking first two least terms and making tree: 
			5
		   / \
		2(D)  3(C)			//consider this as a whole node and retrace the tree.
		=>	4 4 5 7
			E A ^ B
		
		=>taking first two least terms and making tree: 
			8
		   / \
		4(E)  4(A)
		=>	5 7 8
			^ B	^
		
		=>taking first two least terms and making tree: 
			12
		   / \
		5(^)  7(B)
		=>	8 12	=> 20
			^ ^
		
		->FINAL TREE : 
				 20
			   /   \
			 8	    12
			/ \     / \
		 4(E) 4(A) 5   7
				   /\
				2(D) 3(C)
				
		->Traverse the tree : 0 will be assgined to the left side and 1 will be assigined to the right side.
				
		->HAFFMAN FINAL TREE : 
				 20
			   0/   \1
			 8	    12
		   0/ \1   0/ \1
		 4(E) 4(A) 5   7
				  0/\1
				2(D) 3(C)
			=>ALL characters will be in leaf node.		
		->Table : 
			char | frequency/count | coding
			A		4			01
			B		7			11
			C		3			101
			D		2			100
			E		4			000
			=>THIS IS VARIABLE LENGTH CODING
			->WHICH CHARACTER HAS GREATER FREQUENCY WILL HAVE LOWER BIT HAFFMAN CODING.
			->VICE VERSA OPPOSITE FOR LOWER FREQ.
		=>TOTAL NUMBER OF BITS : 
			4*2 + 7*2 + 3*3 + 2*3 + 4*2
			=45bits for the above msg.
			-Along with this msg we also have to send either the tree or the above table so that receiver can decode this msg.
			-For sending table : 
				8*5 + 2 + 2 + 3 + 3 + 2 = 52bits
			==>TOTAL BITS : 45 + 52 = 97bits.
		
	->TIME COMPLEXITY OF THIS CODING IS : theta(nLog n) .
	
	->Prefix code rule : No code should be prefix of another code.
		-If this condition is satisfied then only there will be no abiguity to another reciever side while decoding the msg.
		-The Haffman coding is always following this rule.
		
	-POINTS : 
		-Discovered by David Hoffman in 1951.
		-encoding follows the prefix rule.
		-Most generated char. will get the small code and least generated char will get the large code.
		-Time complexity : THETHA(nLogn)
		
	
->EXAMPLES : 
	1.A text is made up of the characters a b c d e each occuering with the probability 0.11, 0.40, 0.16, 0.09, 0.24 respectively. The optimal Huffman coding tech. will have the average length of ?

		->Here we have probability instead of frequecy so that we will arrange it according to increasing order of their probablity.
		->Table : 
		char | Probablity | coding
		A		.11			
		B		.40			
		C		.16			
		D		.09			
		E		.24	
		
		->Table : -1step
		char | Probablity | coding
		D		.09			
		A		.11			
		C		.16			
		E		.24	
		B		.40		
		
		->Table : -2step
		char | Probablity | coding
		C		.16	
		D,A		.20			
		E		.24	
		B		.40		
		
		->Table : -3step
		char | Probablity | coding
		E		.24	
		D,A,C	.36	
		B		.40		
		
		->Table : -4step
		char | Probablity | coding
		B			.40			
		D,A,C,E		.60	
		
		->Table : -5step
		char | Probablity | coding
		D,A,C,E,B		1.00			
		
		
		1
		.40(B)-.60
			   .24(E)-.36
					  .16(C)-.20
							 .09(D)-.11(A)
								
		
		->Table : 
		char | Probablity | coding |total bits
		A		.11			1111	4
		B		.40			0		1
		C		.16			110		3
		D		.09			1110	4
		E		.24			10		2
		
		total bits : SIGMA(Pi*Bits)
		.11*4 + .4*1 + .16*3 + .09*4 + .24*2 
		=2.16 bits per symbol.
		
		->for 100 character = 216bits.


*/
#include <stdio.h>

int main(int argc, char *argv[]) {
	
}