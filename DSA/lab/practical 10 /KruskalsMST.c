//19BCE245
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

	int V,E;
	printf("Enter the number of vertices : ");
	scanf("%d",&V);
	printf("Enter the number of edges : ");
	scanf("%d",&E);
	struct Graph *G = createGraph(V, E);
	printf("Add edges : \n");
	for(int i=0;i<E;i++){
		printf("Add edge no.%d\n",i+1);
		printf("Enter source : ");
		scanf("%d",&G->edges[i].source);
		printf("Enter destination : ");
		scanf("%d",&G->edges[i].destination);
		printf("Enter weight : ");
		scanf("%d",&G->edges[i].weight);
	}
 		
	KruskalMST(G);
	
	return 0;
}
/*	SAMPLE INPUT
	add like this : 
			V = 4;
			E = 5;
	//adding edge 0-1
	G->edges[0].source = 0;
	G->edges[0].destination = 1;
	G->edges[0].weight = 20;
	//adding edge 0-2
	G->edges[1].source = 0;
	G->edges[1].destination = 2;
	G->edges[1].weight = 5;
	//adding edge 0-3
	G->edges[2].source = 0;
	G->edges[2].destination = 3;
	G->edges[2].weight = 1;
	//adding edge 1-3
	G->edges[3].source = 1;
	G->edges[3].destination = 3;
	G->edges[3].weight = 7;
	//adding edge 2-3
	G->edges[4].source = 2;
	G->edges[4].destination = 3;
	G->edges[4].weight = 10;
	
	which will look like this : 
		
		       20
			0--------1
			|  \     |
		   5|   1\   |7
			|      \ |
			2--------3
				10
		
*/

/*	SAMPLE OUTPUT
	Minimum Spanning tree : 
	Number  Source  Destination  Weight
	1.]          2            3       4
	2.]          0            3       5
	3.]          0            1      10
	Minimum cost of spanning tree : 19
*/