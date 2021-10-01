//infix to postfix conversion rules : 
/*
1. Print operands as they arrive.
2. If stack is empty or contains a left paranthesis on top, push the incoming operator onto the stack.
3.If incoming symbol is '(' , push it onto stack
4. If incoming symbol is '(' , pop the  stack & print te operators until left paranthesis is found.
5. If incoming symbol has higher precedence order than the top of the stack , push it on the stack.
6. If incoming symbol has lower precedence than the top of the stack, pop & print the top. then test the incoming operator against the new top of the stack.
7. If incoming operator has equal precedence with the top of the stack, use associativity rule.
8. At the end of the expressino, pop & print all operators of stack.
9.	Associativity [ LEFT TO RIGHT ] then pop & print the top of the stack & then push the incoming operator.
	[ RIGHT TO LEFT ] then push the incoming operator. 
	
*/