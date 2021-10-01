//1.KRUSHKAL's ALGORITHM
/*
	->1st Algorithm for solving minimal Spanning Tree
		-Graph is weighted.
	->Condition : 
		->All nodes must be connected.
		->total cost minimum.
	->have to make tree [not cyclic]
	
	->KRUSKAL's ALGORITHM
		-It finds a safe edge to add to the growing forest by finding, of all the edges that connect any two trees in the forest, an edge [u,v] of least weight.
			->First of all we considering a graph of some nodes.
				-in which all nodes are itself forming a tree.[we are assuming this]
				-considering there is no edge at starting b/w any two nodes.
				-then considering a first edge which has minimal weight and which is connecting two nodes. these applies that those both nodes are now one single tree instead of two individual tree.
			
		-Procedures : [assume predefined]
			1.MAKE-SET(v)
			2.FIND-SET(u)	[one set represent one tree, returns value which is related to that node/tree]
			3.UNION(u,v)	[combined two nodes's trees and make a single tree of them]
		
		->ALGORITHM : 
			1. [initialize] A := ϕ (phi).
			2. [Loop] For each vertex v ∈ V[G] do step 3.
			3. MAKE-SET(v).
			4. Sort the edges of E into nondecereasing order by weight w.
			5. [Loop] For each edge [u,v] ∈ E taken in nondecreasing order by weight do step 6.
			6. If FIND-SET(u) ≠ FIND-SET(v) then : A := AU{[u,v]} , UNION(u,v).
			7. Return A
			
			
	->Example Diagram : 
		
		v1-----(e3 = 1)---v4
		| 	\			  |
	(e1 = 3) \			  (e8 = 5)
		|	 (e2 = 4)	  |
		|		 \		  |
		v2-(e4=2)-v3	  |
		|		 /	\	  |
	(e5 = 6)   /  (e7 = 3)|
		| (e6 = 2)	    \ |
		| /			     \|
		v5---(e9 = 1)-----v6
		
		->APPLYING ALGO : 
			1.making an empty set A.
				A = { ϕ }
			2.making set through MAKE-SET for every node.
				sets : 
					s1 = v1
					s2 = v2
					s3 = v3
					s4 = v4
					s5 = v5
					s6 = v6
			3.Sort edges : [in increasing order]
				sorted edges : 
					E = {e3,e9,e4,e6,e1,e7,e2,e8,e5}
			4.[Loop] 
				->For each edge in above set E we will extract them turn by turn from increasing order of their weight. 
				->then , we will see if the nodes which are connected by that edge, 
					-are in different set then merge their sets by UNION(u,v)
						->And then considering that edge in the set A.
					-are in same set then do nothing.	
						->here we will not consider this edge.
				->By this, we will extract every edges and check weather the nodes connecting them is in same set or not. if yes then merge and counting that edge otherwise doing nothing.
				-At last we have simply one single set as ans.
				->This set of the edges is called MINIMAL SPANNING TREE.
					->Also, There is no cycle in this tree.
			
			
*/

//KRUSHKAL's ALGO for finding minimum spanning tree
/*
	->Prerequisites : 
		-https://www.geeksforgeeks.org/union-find/
			-comment 1
				memset() is used to fill a block of memory with a particular value.
				The syntax of memset() function is as follows :

				 ptr ==> Starting address of memory to be filled		//as this is void pointer, any type of pointer can be taken
				 x   ==> Value to be filled
				 n   ==> Number of bytes to be filled starting from ptr to be filled
				
				void *memset(void *ptr, int x, size_t n);
			
			-comment 2
				Let us create the following graph  
				0  
				| \  
				|  \  
				1---2 
			
		-https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
		
	->Actual solving : 
		-https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
*/

//UNION FIND 1

/*
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
struct Edge{
	int source,destination;
};
struct Graph{
	int V, E;
	struct Edge* Edges;
};
struct Graph* createGraph(int V, int E){
	struct Graph* G = (struct Graph*)malloc(sizeof(struct Graph));
	G->V = V;
	G->E = E;
	G->Edges = (struct Edge*)malloc(G->E*(sizeof(struct Edge)));
	return G;
}
int find(int parent[], int i){	//utility function to find the subset of an element at index i.
	if(parent[i] == -1)
		return i;
	return find(parent, parent[i]);
}
void Union(int parent[], int x, int y){
//	int xset = find(parent, x);
//	int yset = find(parent, y);
//	if(xset!=yset)
//		parent[xset] = yset;
	//all the above conditions are useless.
	parent[x] = y;
}
int isCycle(struct Graph* G){
	int *parent = (int*)malloc(G->V * sizeof(int));
	//refer comment 1
	memset(parent, -1, sizeof(int)*G->V);	//filling -1 value by default
	for (int i=0;i<G->E;i++) {
		int x = find(parent, G->Edges[i].source);
		int y = find(parent, G->Edges[i].destination);
		
		if(x==y)
			return 1;
		
		Union(parent, x, y);
	}
	return 0;
}
int main(){
	//refer comment 2
	int V = 3,E = 3;
	struct Graph *G = createGraph(V, E);
	
	//add edge 0-1
	G->Edges[0].source = 0;
	G->Edges[0].destination = 1;
	//add edge 1-2
	G->Edges[1].source = 1;
	G->Edges[1].destination = 2;
	//add edge 0-2
	G->Edges[2].source = 0;
	G->Edges[2].destination = 2;
	
	if(isCycle(G))
		printf("Graph contains Cycle");
	else
		printf("Graph doesn't contains Cycle");
	return 0;
}
*/

/*
//union by rank and path compression
#include "stdio.h"
#include "stdlib.h"
struct Edge{
	int source, destination;
};
struct Graph{
	int V,E;
	struct Edge *edges;
};
struct subset{
	int parent;
	int rank;
};
struct Graph* createGraph(int V, int E){
	struct Graph *G = (struct Graph*) malloc(sizeof(struct Graph));
	G->V = V;
	G->E = E;
	G->edges = (struct Edge*)malloc(G->E * sizeof(struct Edge));
	return G;
}
int find(struct subset subsets[], int i){	//uses path compression technique
	if(subsets[i].parent != i)
		subsets[i].parent = find(subsets,subsets[i].parent);
	return subsets[i].parent;
}
void Union(struct subset subsets[], int x, int y){		//uses union by rank
	int xroot = find(subsets,x);
	int yroot = find(subsets,y);
	
	//The tree whose rank is smaller then the other, it will be attached to that bigger rank tree.
	if (subsets[xroot].rank < subsets[yroot].rank)
	subsets[xroot].parent = yroot;
	else if (subsets[xroot].rank > subsets[yroot].rank)
	subsets[yroot].parent = xroot;
	else{
		subsets[yroot].parent = xroot;
		subsets[xroot].rank++;
	}
}
int isCycle(struct Graph *G){
	int V = G->V;
	int E = G->E;
	struct subset *subsets = (struct subset*)malloc(V*sizeof(struct subset));
	for (int v=0;v<V;v++) {
		subsets[v].parent = v;
		subsets[v].rank = 0;
	}
	for(int e=0;e<E;e++){
		int x = find(subsets, G->edges[e].source);	
		int y = find(subsets, G->edges[e].destination);	
		
		if(x==y)
			return 1;
		
		Union(subsets, x, y);
	}
	return 0;
}
int main(){
	int V = 3,E = 3;
	struct Graph *G = createGraph(V, E);
	
	//add edge 0-1
	G->edges[0].source = 0;
	G->edges[0].destination = 1;
	//add edge 1-2
	G->edges[1].source = 1;
	G->edges[1].destination = 2;
	//add edge 0-2
	G->edges[2].source = 0;
	G->edges[2].destination = 2;
	
	if(isCycle(G))
		printf("Graph contains cycle");
	else
		printf("Graph doesn't contains cycle");
}
*/

//ACTUAL KRUSHKAL's ALGO
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct Edge{		//structure for representation of weighted edge
	int source, destination, weight;
};
struct Graph{		//structure for representation of connected undirected weighted graph
	int V,E;
	struct Edge *edges;
};
struct Graph* createGraph(int V, int E){		//creates a graph which have V vertices and E edges
	struct Graph *G = (struct Graph*)malloc(sizeof(struct Graph));
	G->V = V;
	G->E = E;
	G->edges = (struct Edge*)malloc(G->E * sizeof(struct Edge));
	return G;
}
struct subset{		//structure for representation of subset which will used in whether tree forms a cycle or not. This function represents every vertices as an individual tree which have rank means[similar to] height of the tree and parent which shows the parent vertice of that vertice.
	int rank,parent;
};
int find(struct subset subsets[],int i){		//finds the parent of given element i.
	if(subsets[i].parent != i)
		subsets[i].parent = find(subsets,subsets[i].parent);
		
	return subsets[i].parent;
}
void Union(struct subset subsets[], int x, int y){		//merges two vertices x and y on the besis of which vertices has greater rank.
	int xroot = find(subsets,x);
	int yroot = find(subsets,y);
	
	if(subsets[xroot].rank < subsets[yroot].rank)		//if the rank of y is greater than the rank of x then making y as a parent of x
		subsets[xroot].parent = yroot;
	else if(subsets[xroot].rank > subsets[yroot].rank)		//if the rank of x is greater than the rank of y then making x as a parent of y
		subsets[yroot].parent = xroot;
	else{		//if the rank of x and y are same then we can make any one has a parent of other. Here we are making x as a parent of y but here as both's rank are same then we have to increase the size of the parent tree also so as x is a parent here, we will increse the rank of x by 1.
		subsets[yroot].parent = xroot;
		subsets[xroot].rank++;		//We incresed the rank of x by only 1 because let us assume that x's rank is 3 and y's rank is also 3. This means that both x and y are 3 levels deep.then if we make x(which max deep is 3) as a parent of y then we are attaching a whole tree y (which is also 3 level deep) to x. so 1(x) + 3(y) = 4 is the new rank of x.		
	}
}
int myComp(const void *a, const void *b){		//for comparision of two edges by their weight. will used in qsort
	struct Edge *a1 = (struct Edge *)a;
	struct Edge *b1 = (struct Edge *)b;
	return (a1->weight > b1->weight);
}
void KruskalMST(struct Graph *G){		//function for construction of Minimum spanning tree using kruskals algo.
	int V = G->V;
	struct Edge result[G->V];		//for storing resultant MST (edges)
	int e = 0;		//index var for result[]
	int i = 0;		//index var for sorted edges
	
	qsort(G->edges, G->E, sizeof(G->edges[0]), myComp);	//sorts the edges in thier non-decreasing order
	
	struct subset *subsets = (struct subset*)malloc(G->V * sizeof(struct subset));		//Creating V subsets (for each vertices v there is one subset for it)
	
	for(int v = 0; v<G->V;v++){		//initializing every vertice's subset. every vertices is its own parent and rank (depth) of each is zero at starting as there is no another vertices is attached to them.
		subsets[v].parent = v;
		subsets[v].rank = 0;
	}
	
	while (e<((G->V)-1) && i<G->E) {		//minimum spanning tree has maximum V-1 vertices. so till in result array we get e = V-1 vertices, we will run the for loop and also if we checked each edges of graph then we can close the loop which means there can be less then V-1 edges in resultant MST edges.
		struct Edge nextEdge = G->edges[i++];		//extracting each edges one by one
		
		int x = find(subsets, nextEdge.source);		//finding parent of x
		int y = find(subsets, nextEdge.destination);		//finding parent of y
			
		if(x!=y){		//if both not belongs to same parent then adding it to result (MST)
			result[e++] = nextEdge;
			Union(subsets, x, y);		//merging both x and y as one single tree
		}
		
		//if both belongs to same parent then ignore it.
	}
	
	
	//printing MST 
	printf("Following are the edges in the constructed Minimum Spanning tree : \n");
	int minimumCost = 0;
	printf("Number  Source  Destination  Weight\n");
	for(int i=0;i<e;i++){
		printf("%d.] %10d %12d %7d\n",i+1,result[i].source,result[i].destination,result[i].weight);
		minimumCost += result[i].weight;
	}
	printf("Minimum cost of spanning tree : %d\n",minimumCost);
	return;
}
int main(){
//	       10
//		0--------1
//		|  \     |
//	   6|   5\   |15
//		|      \ |
//		2--------3
//			4
	int V = 5;
	int E = 5;
	struct Graph *G = createGraph(V, E);
	
	//add edge 0-1
	G->edges[0].source = 0;
	G->edges[0].destination = 1;
	G->edges[0].weight = 10;
	//add edge 0-2
	G->edges[1].source = 0;
	G->edges[1].destination = 2;
	G->edges[1].weight = 6;
	//add edge 0-3
	G->edges[2].source = 0;
	G->edges[2].destination = 3;
	G->edges[2].weight = 5;
	//add edge 1-3
	G->edges[3].source = 1;
	G->edges[3].destination = 3;
	G->edges[3].weight = 15;
	//add edge 2-3
	G->edges[4].source = 2;
	G->edges[4].destination = 3;
	G->edges[4].weight = 4;
	
	KruskalMST(G);
	
	return 0;
}