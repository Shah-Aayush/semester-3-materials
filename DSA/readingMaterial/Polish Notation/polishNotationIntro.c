/*
POLISH NOTATION
	->The method of writing operators of an expression either before their operands or after them is called the polish notation.
	Ways of writing :
		1.Infix Notation
		2.Prefix Notation
		3.Postfix Notation
		
Infix Notation : 
	->When the oprators exist between two operands then the expresion is called Infix Notation.
	->Example : A+B

Prefix Notation : 
	->When the operators are written before their operands then the expression is called the Prefix Notation.
	->Example : A+B (Infix)
				+AB (Prefix)
				
Postfix Notation : 
	->When the operators are written after their operands then the expression is called the Postfix Notation.
	->Exaple : A+B (Infix)
			   AB+ (Postfix)
		
EXAMPLES : 
	1.(A+B)*C 
		prefix : *+ABC
		postfix : AB+C*
	2.A+(B*C) = A+B*C 
		prefix : +A*BC
		postfix : ABC*+
	3.(A+B)/(C-D)
		prefix : /+AB-CD
		postfix : AB+CD-/
*/