/*
//lecture 1
GRAPH :
	->A graph is an abstract data type that meant to implement the graph concepts from mathematics
		->What is an Abstract data type :
			-1.Data structure
			-2.Set of Operations [to be applied on DS]
			the combination of these both is called abstract data type.
			like stack, queue these are abstract data type.
	->A graph is an collection of nodes, connected by edges

->graph has : 	
	-nodes/vertices
	-edges

->Data fit into graph structure :
	-Set of cities connected via rail route
		-nodes : cities
		-edges : routes
	-Set of people, where some are friends
		-nodes : persons
		-edges : friend of 
	-Connection among computers(routers)
		-nodes : routers
		-edges : connected through wires
	-Tree is graph

->This is not linear representation so there will not used stack/queue/linkedlist etc.

->Definition : 
	-In Computing : 
		->A graph is an abstract data structure that implements the mathematical definition of a graph
	-In mathematics : 
		->A graph G is composed by a set of N vertices or nodes, connected through a set E of edges, or links
		->G = (E,V)
		
		=>So the graph is made of two sets : 
			1.Set of edges
			2.Set of nodes/vertices
			G = {V,E}
				V = {v0,v1,v2,v3}
				G = {e0,e1,e2,e3,e4,e5}
				
DEFINITION OF GRAPH : 
	A graph G consists of two things : 
		-A set V of elements called Nodes (or points or vertices)
		-A set E of edges such that each edge e in E is identified with a unique(unordered) pair [u,v] of nodes in V, denoted by e = [u,v].
			->this edge connect two nodes therefor every edge is defined by [u,v] where u and v are nodes which are connected by the edge e.
		-We indicate the parts of the graph by writing G = (V,E)

//TERMINOLOGIES : 	
	
ADJACENT NODES : 
	->If e = [u,v], then u and v are nodes called end points of e. u and v are said to be adjacent nodes or neighbors.
	
DEGREE OF NODE : 
	->The degree of node u, written deg(u), is the number o edges containing u.
	 
ISOLATED NODE : 
	->If deg(u) = 0 , then u is called an isolated node.
	
PATH :
	->A path P of legth(number of edges) n from a node u to a node v is defined as a sequence of n+1 nodes.
	P = (v0,v1,v2,...,vn)
	
CLOSED PATH : 
	->The path is said to be closed if v0 = vn.
	P = (v0,v1,v3,...,v2,v0)
	
SIMPLE PATH : 
	-> The path is said to be simple if all the nodes are distinct, with the exception that v0 may equal vn.
	P = (v0,v1,v3,...,v2,v0) -simple
	P = (v0,v1,v2,...,v2,v0) -not simple as node/nodes is/are repeating
	
CONNECTED GRAPH : 
	->A graph G is said to be connected if there is a path between any two of its nodes.
		->You can traverse from any node to any node [path length doesn't matter]
		->if you cannot go atleast for one  from a specific node to a another specific node then it is not connected graph.

TREE : 
	->A connected graph T without any cycles/loop is called a tree graph or free tree or simply a tree.
	->This means in particular, that there is a unique simple path P between any two nodes u and v in T.
	->If T is finite tree with m nodes, then T will have m-1 edges. 
	->Its not always binary tree ! it can be any tree. [simple tree]
	
LABELLED GRAPH
	->A graph is to be labeled if its edges are assigned data.
	->A graph G is said to be weighted if each edge e in G is assigned a non negetive numerical value w(e) called the weight or length of e.
		->which is simply giving value to edge or assiging any data to edge which can be cost or any
	
MULTIPLE EDGES
	->Distinct edges e and e' are called multiple edges if they connect the same end points, that is , if e = [u,v] and e' = [u,v].
	
LOOP
	->An edge is called a loop if it has identical end points. That is , if e = [u,u].

MULTI-GRAPH
	->Multi-graph is a graph consiting of multiple edges and loops.[Simply, the graph which has both loop and multiple edges]


GRAPH TYPES :
	1.Directed Graph
	2.Undirected Graph
	
1.Directed Graph
	->If edges has also mentioned direction then the graph will called directed graph
	->ex. : if there is an edge e0 = (v0,v1) then we cannot write it as e0 = (v1,v0). as direction is changed in the second case.
	
	DEFINITION : 	
		->A directed graph G also called digraph or graph is same as multi-graph except that each edge e in G is assigned a direction , or in other words, each edge e is identified with an ordered pair (u,v) of nodes in G rather than an unordered pair [u,v].
		->Suppose G is directed graph with directed edges e = (u,v).Then e is also called an arc. [every edges which has a direction, that edge is also called an arc]

2.Undirected Graph
	->If edges is not mentioned direction then the graph will called undirected graph
	->ex. : if there is an edge e0 = [v0v1] then we can also write it as e0 = [v1v0]. 
	
	[small point from myside-> -[] is undirected and -() is directed]

COMPLETE GRAPH : 
	->A simple graph in which there exists an edge between every pair of vertices is called a complete graph.It is also knwon as a universal graph or clique.
	
NULL GRAPH : 
	->A graph without any edge is called a null graph.
	->In other words, every vertex in a null graph is an isolated vertex.
	->Which also means that every node's degree is ZERO.
	
SUB-GRAPH :
	->A graph G' = (V',E') is a sub-graph G = (V,E) if V' is a subset of V and E' is a subset of E. thus for G' to be a sub-graph of graph G , all the vertices and edges of G' should be in G.
	->In subset, the sub-edges set should contain only the edges which are present between the subset of vertices's nodes.

//lecture 2

->Basic INTRO : 
	->Graph is a set of nodes(vertices) and edges(lines connecting vertices)
	->Real world information is sometimes a graph 
	->To represent real world informatino in a computer program, we need a data structure called graph data structure.

GRAPH ADT : 
	->Just like other ADT's graph ADT(data structure and set of operations), is used.
	->To create Graph ADT, we need to represent graph data structure in some way.
		-ADT : Abstract Data Type
	
REPRESENTATION OF GRAPH DS(Data Structure)
	-There are three ways to represent graph data struture : 
		1.Adjacency Matrix
		2.Adjacency List
		3.Adjacency Set
		
1.ADJACENCY MATRIX
	->To represent graph we need number of vertices, number of edges and also their interconnections.
*/
	struct Graph{
		int V;	//number of Vertices/nodes
		int E;	//number of Edges
		int **Adj;	//two dimentional Array for representation of edge's connection
	};
	
/*		
	->	this **Adj type of pointer can contain two dimentional Array.
	->This pointer variable will be used to point 2 dimentional array
*/
	struct Graph* adjMatrixOfGraph(){
		int u, v;		//both represents nodes
		int i;			//for 'for' loop
		struct Graph *G = (struct Graph *)malloc(sizeof(struct Graph));
		if(G==NULL){
			printf("Memory Allocation failed :(\n");
			return;
		}
		printf("Enter number of nodes and number of edges : ");
		scanf("%d %d",&G->V,&G->E);
		//Now we have to create the 2 dimentional array dinemically, so we will use malloc function
		//creating a 2d matrix from malloc from the number of nodes and edges.
		G->Adj = (int)malloc((G->V)*(G->V)*sizeof(int));
		//not typecasting in C will not give any error but in C++ it will give error. So typecasting in c is a good practise.
		//matrix will be Nodes*Nodes
		//We want to put zeros in all the cells of 2d matrix so we will do this by 2 for loops.
		for(u = 0;u<G->V;u++){
			for(v = 0;v<G->V;v++){
				G->Adj[u][v] = 0;
			}	
		}
		/*
		//after assiging zeros to every cell, we want to assgin ONE in each pair of nodes which are connected by the edge
		//matrix : 
				A 	B 	C 	D
			A	0	1	1	1
			B	1	0	1	0
			C	1	1	0	1
			D	1	0	1	0
			->1(lets consider first one in the matrix) in cell shows that the A and B nodes are connected by an edge.
			->second 1 in 1st row: A and C
			->third 1 in 1st row : A and D
			and so on...
			
			
			GRAPH :
				->this is undirected graph.
				A-B
				|\|
				D-C
			E0 = (A,B) | (0,1)
			E1 = (A,D) | (0,3)
			E2 = (C,D) | (2,3)
			E3 = (B,C) | (1,2)
			E4 = (A,C) | (0,2)
			The above input we want from the user.
			so we will run the for loop for each edge then asking the input for each edge of the connecting noods
		*/
		printf("Enter node numbers in a pair that connects an edge : \n");
		//input for each edge
		for(i = 0;i<G->E;i++){
			scanf("%d %d",&u,&v);
			//as this is an undirected graph we will assign 1 to both cells of that both nodes.
			G->Adj[u][v] = 1;
			G->Adj[v][u] = 1;
		}
		return G;
	}
/*
//FOR USING ABOVE CODE IN CODING use this:
//	correction : use *(G->Adj+(i*G->V)+j) in place of G->Adj[i][j].
//	and correct the **Adj as *Adj.[do not take double pointer.]
	#include <stdio.h>
	#include <stdlib.h>
	struct Graph{
		int V;	
		int E;	
		int **Adj;	
	};
	int main(int argc, char *argv[]) {
		
	}
	struct Graph* adjMatrixOfGraph(){
		int u, v;		
		int i;			
		struct Graph *G = (struct Graph *)malloc(sizeof(struct Graph));
		if(G==NULL){
			printf("Memory Allocation failed :(\n");
			return (NULL);
		}
		printf("Enter number of nodes and number of edges : ");
		scanf("%d %d",&G->V,&G->E);
		G->Adj = (int**)malloc((G->V)*(G->V)*sizeof(int));
		for(u = 0;u<G->V;u++){
			for(v = 0;v<G->V;v++){
				G->Adj[u][v] = 0;
			}	
		}
		printf("Enter node numbers in a pair that connects an edge : \n");
		for(i = 0;i<G->E;i++){
			scanf("%d %d",&u,&v);
			G->Adj[u][v] = 1;
			G->Adj[v][u] = 1;
		}
		return G;
	} 
*/	
	
/*
//lecture 3	(chapter 53 in playlist)
ADJACENCY LIST : 
	->We will use LinkedList in this method.
	->STRUCUTRE :
		->for listNode
		->for Actual graph 
	->Adj will point a list node 
	
	ex : 
		V=4
		E=5
		and directed Graph : 
			A--->B
			|^\  |
    downArrow  \ downArrow
			D<---C
			
			numbering : 
			A = 0
			B = 1
			C = 2
			D = 3
			
	->We will make an array of size equal to number of vertices.		
		
	->Adj will point this list node : 
		vertexNo | next
	0			 |
	1			 |
	2			 |
	3			 |
	
	->We are creating a Graph which has adj named pointer of type struct listnode.
	->then we will allot memory to adj of NoOfVertices*listnode.
	->we are also making two int typed variable for userinput of one edge's source and destination's node's number.
	->we are also making two struct list node type variable named temp and t.
		->In which through temp we will crete new node of list type
		->for t, 
	->we are alloting the memory to graph to store the data.
	->then we are taking input from user for number of edges and vertices.
	->for each vertices, we will run 'for loop' for 
		-assiging its node number [which is same as its index number]
		-assiging next to it self.[in next pointer of any vertices it will be address of itself which means those nodes's 'nexts' are selfpointing.]
	->for each edges, we will run 'for loop' for
		-taking input from user for source and destination of edge.
		-after it we will create temp pointer, and allot it memory of listNode.
			-we will store the information of that edge in this temp pointer.
			-like, source location will be used as that new made node's next we will point to original vertex node.
			-and the last node of that source node, which will contain null in the next of that last node, we will assign the address of newly made node to it.
	->
	
*/
//STRUCUTRE 
struct ListNode{
	int vertexNo;
	struct ListNode *next;
};
struct Graph{
	int V;			//V = 4
	int E;			//E = 5
	struct ListNode *Adj;	
};
struct Graph* adjListOfGraph(){
	int x,y;
	
	struct ListNode *t;
	struct Graph *G;
	G = (struct Graph *)malloc(sizeof(struct Graph));
	printf("Enter number of vertex and number of edges : ");
	scanf("%d %d",&G->V,&G->E);
	G->Adj = (struct ListNode *)malloc(G->V*sizeof(struct ListNode));
	for(int i=0;i<G->V;i++){
		(G->Adj+i)->vertexNo = i;	//vertexNo is same as index of that vertex
		(G->Adj+i)->next = G->Adj+i;		//self pointing
	}
	for(int i=0;i<G->E;i++){
		printf("Enter Edge (Source node, Destination node)");
		scanf("%d %d",&x,&y);
		struct ListNode *temp;
		temp = (struct ListNode *)malloc(sizeof(struct ListNode));
		temp->vertexNo = y;	//destination node's vertexNo will assgined to new made node's vertex.
		temp->next = G->Adj+x;		//new made node's next will contain the address of the source node
		
		//below operation is for assiging the newly made node's address to the last node's next of the adjecency list.
		//that last node of adjecency list will always contain the address of the first node.
		t = G->Adj+x;	
		while(t->next!=G->Adj+x)
		t = t->next;	
		t->next = temp;	
	}
	return (G);
}
/*
//for executing the above code use below format : 
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	
}
struct ListNode{
	int vertexNo;
	struct ListNode *next;
};
struct Graph{
	int V;			
	int E;		
	struct ListNode *Adj;	
};
struct Graph* adjListOfGraph(){
	int x,y;
	
	struct ListNode *t;
	struct Graph *G;
	G = (struct Graph *)malloc(sizeof(struct Graph));
	printf("Enter number of vertex and number of edges : ");
	scanf("%d %d",&G->V,&G->E);
	G->Adj = (struct ListNode *)malloc(G->V*sizeof(struct ListNode));
	for(int i=0;i<G->V;i++){
		(G->Adj+i)->vertexNo = i;	
		(G->Adj+i)->next = G->Adj+i;
	}
	for(int i=0;i<G->E;i++){
		printf("Enter Edge (Source node, Destination node)");
		scanf("%d %d",&x,&y);
		struct ListNode *temp;
		temp = (struct ListNode *)malloc(sizeof(struct ListNode));
		temp->vertexNo = y;	
		temp->next = G->Adj+x;		
		t = G->Adj+x;	
		while(t->next!=G->Adj+x)
		t = t->next;	
		t->next = temp;	
	}
	return (G);
}
*/