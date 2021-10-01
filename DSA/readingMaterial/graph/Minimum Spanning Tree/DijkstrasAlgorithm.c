//DIJKSTRA'sALGORITHM
/*
	->Shortest path :
		-A famous solution for shortest path problem was given by Dijkstra.
		-Dijkstra;s algorithm is generalization of BFS algorithm.
	->Distance Table
	vertex		Distance[v] 	Previous vertex which gave Distance[v](PIE[v])
	
	
	
	-The algorithm works by keeping the shortest distance of vertex v from the source in Distance table.
	-Distance[v] holds the distance from s to v.
	-The shortest distance of the source to itself is 0 
	-Distance[v] of all other vertices are set to INFINITY to indicate that those vertices are not yet processed.
	
	DIAGRAM :
	   /B----1---D
	 10 |     /  |
	A	2,3^ 9  6^,4    + EtoA with edge 7 
	 5	| __/    |
	   \C/----2---E

		AtoB 10
		AtoC 5
		EtoA 7
		CtoB 3
		CtoE 2
		CtoD 9
		EtoD 6
		BtoD 1
		BtoC 2
		DtoE 4
		
		->source node FIXED.
			-consider A as source node here for example.
->IMPORTANT POINTS ABOUT Dijkstra's ALGO:
	-It uses greedy method. [A greedy algorithm is a simple, intuitive algorithm that is used in optimization problems. The algorithm makes the optimal choice at each step as it attempts to find the overall optimal way to solve the entire problem.greedy->lalach]
	-It uses priority queue to store unvisited vertices by distance froms
	-Does not work with negative weight	
	
	
	-ALGORITHM : 
		1. INITIALIZE-SINGLE-SOURCE(G,s)
		2. S = ϕ , Q = V[G]
		3. Repeat thruogh steps 4 to 6 while Q ≠ ϕ.
			4. u = EXTRACT-MIN(Q) , S = SU{u}
			5. Repeat for each vertex v ∈ Adj[u]
			6. RELAX(u,v,w)
			7. Exit
		
		
		->APPLYTING ALGO : 
			-step 1,2
		V		d[v]		PIE[v]
		A		0			-
		B		∞ 			
		C		∞ 
		D		∞ 
		E		∞ 
			s = {ϕ}
			
			-step 3 4 5 6
			extract min = A (as it has minimum value 0 then other infinite values.)
			-A completed now.
			u = A	(source node)
			v = B,C (neighbours)
			step5 for each neighbours
			RELAX (u,v,w)
				-RELAX (A,B,10)
				
			->PROCEDURE RELAX(u,v,w)
				1. If d[v] >d[u] + w(u,v) , then d[v] = d[u] + w(u,v) , PIE[v] = u
				2. Return
			
			V		d[v]		PIE[v]
			A		0			-
			B		10 			A
			C		∞ 
			D		∞ 
			E		∞ 
				-RELAX (A,C,5)
			V		d[v]		PIE[v]
			A		0			-
			B		10 			A
			C		5			A 
			D		∞ 
			E		∞ 
			
			->in loop, going to step 3 again 
				in queue : ABCDE where A is completed then extracting C as it has min value i.e 5.
				now C is also completed
			->Neighbours of C :
				B D E
				RELAX (u,v,w)
					RELAX (C,B,3)
					RELAX (C,D,9)
					RELAX (C,E,2)
				->for RELAX (C,B,3)
					d[v]>d[u]+w
					10  >5   +3
					10>8
						->d[v] = 5+3 = 8
			V		d[v]		PIE[v]
			A		0			-
			B		8 			C
			C		5			A 
			D		∞ 
			E		∞ 
				->for RELAX (C,D,9)
					∞>5+9
			V		d[v]		PIE[v]
			A		0			-
			B		8 			C
			C		5			A 
			D		14			C 
			E		∞ 
				->for RELAX (C,E,2)
					∞>5+2		
			V		d[v]		PIE[v]
			A		0			-
			B		8 			C
			C		5			A 
			D		14			C 
			E		7			C
			->step 3 again
				->now a and c are complete
				now extract min = E
					now e also complete
					u = E
					v = A,D
					->RELAX(E,A,7)
						0>14 not true
					->RELAX(E,D,6)
						14>7+6 = 13
						true
			V		d[v]		PIE[v]
			A		0			-
			B		8 			C
			C		5			A 
			D		13			E 
			E		7			C
			->step 3 again
				->now A,C,E are completed
				->EXTRACT MIN = B
					B is also completed now
				u = B
				v = C D
				->RELAX(B,C,2)
					5>8 + 2 =10  =>not true
				->RELAX(B,D,1)
					13>8+1 =>true
					
			V		d[v]		PIE[v]
			A		0			-
			B		8 			C
			C		5			A 
			D		9			B 
			E		7			C	
			
			->step 3 again 
				->now only D is remaining
				u = D
				v = E
				RELAX(D,E,4)
				7>9+4 not true
				
				
			AtoB = 8 	(AtoCtoB)
			AtoC = 5	(Direct)
			AtoD = 9    (AtoCtoBtoD)
			AtoE = 7	(AtoCtoE)
			
				
*/