/*
TOPOLOGICAL SORTING - How to find all topological orderings of a graph.

	-It is a linear ordering of its vertices such that for every directed edge uv for vertex u to v, u comes before vertex v in the ordering.
	-Graph should be DAG [Directed Acyclic Graph].
	-Every DAG will have atleast one topological ordering.
	
	jenny's video lecture : https://youtu.be/dis_c84ejhQ
	
(up)  2--->3
 /	  |  /(up)
1	  | /
 \  (down)	
(down)4--->5
	
	
	-Find out the indegree of every vertices.	(the edges which coming towards that specific vertix.)
	-linear ordering : select the vertice which have zero indegree.[0,1,2,...]
		-outgoing edge will be deleted with this first vertices.
		
			2--->3
			|  /(up)
			| /
		 (down)	
			4--->5
	
	=>  3
	    /\
		|
		|
		4--->5
		
	=>  3
	    
		
		
		    5
	=>  
	    
		
		
		    5
		
	or=> 3 
	    
		
		
		    
	=>There are two topological ordering possible : 12435/12453
	->If a graph has cycle then we cannot able to find out the topological ordering because if we proceed to find that then at some point we have one situation that no vertice will have zero indegree. so we cannot proceed further.
*/