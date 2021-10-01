/*
DEPTH FIRST SEARCH (DFS)
->Graph traversal algo is typical then other data structure as there can be cycle made so it is chances for one node to repeat so its travrsing algo is typical then other's

	->DFS uses stack
	->During execution of algorithms, each node N of G will be in one of three states called status of N :
		-STATUS = 1 (Ready State)
		-STATUS = 2 (Waiting State)
		-STATUS = 3 (Processed State)
	
	->The Node from we will start traversing it is called source node.
	->We can start from any node i.e. we can consider any node as source node for any tree traversal algo.
	
	ALGORITHM DFS : This algo rithm executes a depth-first seach on a graph G beginning at a starting node A.
		1.Initialize all nodes to the ready state (STATUS = 1)
		2.Push the starting node A onto STACK and change its status to the waiting state. (STATUS - 2).
		3.[LOOP]
			->Repeat steps 4 and 5 until STACK is empty:
			4. Pop the top node N of STACK. Process N and change its status to the processed state.(STATUS = 3).
			5.Push onto STACK all the neighbors of N that are still in the ready state (STATUS = 1), and change thier status the waiting state(STATUS = 2).
			6.Exit
	
*/