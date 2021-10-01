//FLOYD-WARSHALL'S ALGORITHM 
//chapter 54 from mysirg playlist
/*
FLOYD-WARSHALL'S ALGORITHM for all pair shortest path 
->Purpose : 
	-The Floyd Warshall Algorithm is for solving the All pair shortest path problem
	-The problem is to find shortest distances between every pair of vertices in a given edge weighted directed graph.
	
->Ex :
		10
	V0--->V3
5	|	  up
	down   |	1
	V1--->V2
		3
		-Every edges are directed and has weight.[it is showed next to each edge]
		-for example, for going from v0 to v3, we have two paths 
			-first one is of weight 10 and 1 edge 
			-second one is of weight 9 and 3 edges
			the second path is better as its weight is smaller than first.
			the problem is to find this better path.
			
		->It is not necessory that two nodes have always a path like for going to v0 from v1, there is no path so we will call that distance between them is INFINTE.
		->We have to find the shortest path for every node to every node so for 4 nodes, we have 16 possibilites.
		
		
		->Matrix : 
			-this is initial informatino : 
					V0 	V1 	V2 	V3
				V0	0	5	-	-
				V1	-	0	3	-
				V2	-	-	0	1
				V3	-	-	-	0
		
		->We are only represeting direct edges from any nodes. so if there is no direct edge between two nodes then it's distance will be considered as infinite so we will represent it here as '-'.
		->For this we will create graph by matrix representation.
		->We want our output as this :
			-input :  
					V0 	V1 	V2 	V3
				V0	0	5	-	-
				V1	-	0	3	-
				V2	-	-	0	1
				V3	-	-	-	0
			-output :
					V0 	V1 	V2 	V3
				V0	0	5	8	9
				V1	-	0	3	4
				V2	-	-	0	1
				V3	-	-	-	0
		-> the shortest path will be assigined in the matrix.
		->dist[i][j] is simply showing the distance from i to j node.	
*/

//PRINT SOLUTION : 

//MAIN FUNCTION : 
	#include "stdio.h"
	#include "stdlib.h"
	# define INFINITY 99999
	struct Graph{
		int V;	
		int E;	
		int **Adj;	
	};
	void printSolution(struct Graph *G){
		for(int i=0;i<G->V;i++){
			for(int j=0;j<G->E;j++){
				if(G->Adj[i][j] == INFINITY)
				printf("%15s ","INFINITY");
				else
				printf("%15d ",G->Adj[i][j]);
			}
			printf("\n");
		}
	}
	//FLOYD-MARSHALL FUNCTION :
	void floydWarshall(struct Graph *G){
		int dist[G->V][G->V];
		//copying the all values of G into dist.
		for(int i=0;i<G->V;i++){
			for(int j=0;j<G->V;j++){
				dist[i][j] = G->Adj[i][j];
			}
		}
		//algo
		for(int k=0;k<G->V;k++){
			for(int i=0;i<G->V;i++){
				for(int j=0;j<G->V;j++){
					if(dist[i][k] + dist[k][j] < dist[i][j])
					dist[i][j] = dist[i][k]+dist[k][j];
				}	
			}
		}
		//assiging it to original 
		for(int i=0;i<G->V;i++)
			for(int j=0;j<G->V;j++)
				G->Adj[i][j] = dist[i][j];
		
	}
	int main(){
		struct Graph *G;
		int matrix[4][4] = {{0,5,INFINITY,10},{INFINITY,0,3,INFINITY},{INFINITY,INFINITY,0,1},{INFINITY,INFINITY,INFINITY,0}};		//this is temp matrix which's values we will be assign to our actual adj.
		G = (struct Graph *)malloc(sizeof(struct Graph));
		G->V = 4; 		//number of verties
		G->E = 4;		//number of edges
		G->Adj = (int **)malloc((G->V)*(G->V)*sizeof(int));		//2d array making
		for(int i=0;i<G->V;i++){
			for(int j=0;j<G->V;j++){
//				*(G->Adj+(i*G->V)+j) = matrix[i][j];		//this is for if you declared adj as single pointer
				G->Adj[i][j] = matrix[i][j];
			}
		}
		//above code snippet assigns the temp's matrix value to our adj.
		printf("Original Distance : \n");
		printSolution(G);
		floydWarshall(G);
		printf("Matrix below shows the shortes distances between every node : \n");
		printSolution(G);
		return 0;
	}
	
/*
	//USE THIS BELOW CODE FOR CODING : 
		
	#include "stdio.h"
	#include "stdlib.h"
	# define INFINITY 99999
	struct Graph{
		int V;	
		int E;	
		int *Adj;	
	};
	void printSolution(struct Graph *G){
		for(int i=0;i<G->V;i++){
			for(int j=0;j<G->E;j++){
				if(*(G->Adj+(i*G->V)+j) == INFINITY)
				printf("%10s ","INFINITY");
				else
				printf("%10d ",*(G->Adj+(i*G->V)+j));
			}
			printf("\n");
		}
	}
	//FLOYD-MARSHALL FUNCTION :
	void floydWarshall(struct Graph *G){
		int dist[G->V][G->V];
		//copying the all values of G into dist.
		for(int i=0;i<G->V;i++){
			for(int j=0;j<G->V;j++){
				dist[i][j] = *(G->Adj+(i*G->V)+j);
			}
		}
		//algo
		for(int k=0;k<G->V;k++){
			for(int i=0;i<G->V;i++){
				for(int j=0;j<G->V;j++){
					if(dist[i][k] + dist[k][j] < dist[i][j])
					dist[i][j] = dist[i][k]+dist[k][j];
				}	
			}
		}
		//assiging it to original 
		for(int i=0;i<G->V;i++)
			for(int j=0;j<G->V;j++)
				*(G->Adj+(i*G->V)+j) = dist[i][j];
		
	}
	int main(){
		struct Graph *G;
		int matrix[4][4] = {{0,5,INFINITY,10},{INFINITY,0,3,INFINITY},{INFINITY,INFINITY,0,1},{INFINITY,INFINITY,INFINITY,0}};		
		G = (struct Graph *)malloc(sizeof(struct Graph));
		G->V = 4; 		//number of verties
		G->E = 4;		//number of edges
		G->Adj = (int *)malloc((G->V)*(G->V)*sizeof(int));		//2d array making
		for(int i=0;i<G->V;i++){
			for(int j=0;j<G->V;j++){
//				*(G->Adj+(i*G->V)+j) = matrix[i][j];		//this is for if you declared adj as single pointer
				*(G->Adj+(i*G->V)+j) = matrix[i][j];
			}
		}
		//above code snippet assigns the temp's matrix value to our adj.
		printf("Original Distance : \n");
		printSolution(G);
		floydWarshall(G);
		printf("Matrix below shows the shortes distances between every node : \n");
		printSolution(G);
		return 0;
	}
*/