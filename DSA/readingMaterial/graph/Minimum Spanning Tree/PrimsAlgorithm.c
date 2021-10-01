//PRIM's ALGORITHM
/*
	->Algorithm for solving the minimum spanning tree.
	->ALGO : 
		->Prim's algorithm has the property that the edges in the set A always form a single tree.	[in kruskal's algo we make a minimum spanning tree from a forest of many tree but here we will make it from a single tree only instead of making individual tree of every node from starting.]
		->The tree starts from an arbitary vertex r and grows until the tree spans all the vertices in V. 
		
	->Diagram :
	v1---(e1 = 3)---v2
	|              / |
	|   (e3 = 2)--/  |
	|    /       /   |
(e2 = 4)/		/ (e5 = 4)
	|  /       /     |
	| /       /      |
	|/       /       |
	v3		/-(e7 = 2)-v5
	|	(e6 = 7)     |
	|     /          |
(e4 = 5) /   	 (e9 = 6)
	|	/			 |
	|  /			 |
	v4---(e8 = 1)---v6
	
	->APPLYING ALGO : 
		->Considering Arbitary vertex : 
			R = v1 (starting arbitary vertex) 
		->PROCEDURES : here Q is queue which contains nodes in which we will extract the minimum.
			-EXTRACT - MIN (Q)
		
		ALGO :
			->Algorithm MSTPRIM(G,w,r)
			minimumSpanningTree - using - Prim'sAlgo (Graph, Weight, R[starting arbertary vertex]) : 
				-All vertices that are not in the tree reside in a min priority queue Q based on a key field. For each vertex v, key[v] is the minimum weight of any edges connecting v top a vertex in the tree;by convention, key[v] = ∞ (infinity) - if there is no such edge.
				-the field PIE(v) names the parent of v in the tree.
				
				->We will consider minimum edges from the various edges to join it to the tree [across various edges]
				->If there is no edge in the tree then by convention the distance/cost btw that tree and node / vertex V will be infinity.
				

		
			
			
			
			
			->ALGO 
				1. [LOOP] For each u∈ V[G], step2
				2. Key[u] := ∞, PIE(u) = NIL,
				3. Key[r] := 0
				4. Q := V[G]
				5. Repeat steps 6, to 8, While Q ≠ ϕ
				6. u := EXTRACT-MIN(Q)
				7. For each v ∈ Adj[u]
				8. If v ∈ Q and w(u,v) < key[v] 
					then : PIE[v]:=u, key[v] := w(u,v)
				9. Exit
			
			->Tracing algo : 
				1.running loop as 6 times (as there are 6 nodes)
				2.all key and pie will be infinity and NILL as starting 
				key	|  PIE
			1	∞		-
			2	∞		-
			3	∞		-
			4	∞		-
			5	∞		-
			6	∞		-
			
				3. key value of root node /starting node setting to zero.
				key	|  PIE
			1	0		-
			2	∞		-
			3	∞		-
			4	∞		-
			5	∞		-
			6	∞		-
			
				4. Making a queue of above diagram.
				5.loop : 6 to 7 till queue gets empty.
					
					6.extracting the node which has minimum key value
						-In starting all has infinity so we will extracting 1st.
						-u = v1.
						->Neighbours of u :
							V = v2,v3
							->if these neighbours are in queue, then 
							w(u,v) = w(v1,v2)
							if cost of this is less then key value of v2 then pie[v] = pie[v2] = v1.(this v1 is parent of v2 )
							
							
							for v2
							as 3<∞,
							key	|  PIE
						1	0		-
						2	3		v1
						3	∞		-
						4	∞		-
						5	∞		-
						6	∞		-
						w(u,v) = w(v1,v3)
						for v3
							if v3 is in queue?yes
								if 4<∞
								then parent will be v1.
							this is not final , can be updated
							now we will not consider v1 and finaling it to tree.
							key	|  PIE
						1	0		-
						2	3		v1
						3	4		v1
						4	∞		-
						5	∞		-
						6	∞		-
						
						->Now we will considering v2 as it has samllest key.
							->considering its neighbours.
							->4 times loop.
								-v1 [not run]
								-v3	[condition true as key[v3]<2 which is edge btw v2 and v3]
									-key[v3] = 2
									-pie[v3] = v2
									key	|  PIE
								1	0		-
								2	3		v1
								3	2		v2
								4	∞		-
								5	∞		-
								6	∞		-
								queue : v4 v5 
								-v4
									key	|  PIE
								1	0		-
								2	3		v1
								3	2		v2
								4	7		v2
								5	∞		-
								6	∞		-
								queue : v5
								-v5
									key	|  PIE
								1	0		-
								2	3		v1
								3	2		v2
								4	7		v2
								5	4		v2
								6	∞		-
								- now again checking for extract min 
									till now v1 and v2 is final.
									loop...
								->for v3.:
									v1,v2,v4
									v1 and v2 is completed.
									
									5<7
									key	|  PIE
								1	0		-
								2	3		v1
								3	2		v2
								4	5		v3
								5	4		v2
								6	∞		-
									now ,v3 is completed.
								-Extract min 
								 for v5 : 
									v2, v4 , v6
									v2 is already completed
									
									key	|  PIE
								1	0		-
								2	3		v1
								3	2		v2
								4	2		v5
								5	4		v2
								6	6		v5
								- now, v5 is comleted and v4 and v6 is remaining 
								-Extract v4
									v2,v3,v5,v6
									only v6 is remaining.
									key	|  PIE
								1	0		-
								2	3		v1
								3	2		v2
								4	2		v5
								5	4		v2
								6	1		v4
								-Extract v6
									key	|  PIE
								1	0		-
								2	3		v1
								3	2		v2
								4	2		v5
								5	4		v2
								6	1		v4
								as v4 and v5 already completed, 
								loop ended.
								
								
		->KEY : if that specific node is connecting to the tree then what will be the minimum cost of that.
		->PIE : this is parent node of that specific node/vertex.
		
							
*/