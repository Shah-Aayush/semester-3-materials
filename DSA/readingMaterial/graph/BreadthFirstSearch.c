//BREADTH FIRST SEARCH 
/*
->GRAPH TRAVERSAL :
	->To solve problems on graphs, we need a mechanism for traversing the graphs.
	->Graph traversal algorithms are also known as graph search algorithms.

GRAPH TRAVERSAL ALGORITHMS : 
	1.Breadth First Search (BFS)
	2.Depth First Search (DFS)

1.BFS : 
	->BFS uses queue data structure.
	->Similar to level order traversing in tree.

LOGIC : 
	->During execution of algorithms, each node N of G will be in one of three states called status of N :
		-STATUS = 1(Ready State)
		-STATUS = 2(Waiting State)
		-STATUS = 3(Processed State)
	
ALGORITHM : 
	Algorithm BFS : This algorithm executes a breadth first search on a graph G beginning at a starting node A.
	1.Initialize all nodes to the ready state (STATUS = 1).
	2.Put the starting node A in QUEUE and change its status to waiting state.
	3.[LOOP]
		-Reapeat steps 4 and 5 until QUEUE is empty : 
		4.Remove the front node N of QUEUE.
			-Process N and change the status of N to the processed state (STATUS = 3)
		5.Add to the rear of QUEUE all the neighbors of N that are in the ready state (STATUS = 1), and change their status to the waiting state (STATUS = 2).
		[End of step 3 loop]
	6.Exit.
*/

//CODE : 
#include "stdio.h"
#include "stdlib.h"
#include "stdbool.h"
struct Graph{
	int V;
	char *label; 
	bool *visited; 
	int E;
	int *Adj;
};
//struct V{
//	char label;
//	bool visited;
//}
struct Graph* adjMatrixOfGraph(){
	
	int u,v;
	struct Graph *G = (struct Graph *)malloc(sizeof(struct Graph));
	if(G==NULL){
		printf("Memory Allocation Failed :(\n");
		return NULL;
	}
	
	printf("Enter number of nodes : ");
	scanf("%d",&G->V);
	
	G->visited = (bool*)malloc(G->V*sizeof(bool));
	for(int i=0;i<G->V;i++)
	*(G->visited+i) = false;
//	bool visited[G->V];
//	for(int i=0;i<G->V;i++)
//	visited[i] = false;
	
	G->label = (char*)malloc(G->V*sizeof(char));
	for(int i=0;i<G->V;i++){
		printf("Enter label for vertex of index %d : ",i);
		scanf("%c",&*(G->label + i));
	}
	
	printf("Enter number of edges : ");
	scanf("%d",&G->V);
	
	G->Adj = (int *)malloc((G->V)*(G->V)*sizeof(int));
	for(u=0;u<G->V;u++)
		for(v=0;v<G->V;v++)
			*(G->Adj+(u*G->V)+v) = 0;
	
	printf("Enter node numbers in a pair that connects an edge : ");
	for(int i=0;i<G->E;i++){
		scanf("%d %d",&u,&v);
		*(G+(u+G->V)+v) = 1;
		*(G+(v+G->V)+u) = 1;
	}
	return G;
}
struct Queue{
	int rear;
	int front;
	int count;
	int capacity;
	int *array;
};
struct Queue* createQueue(int capacity){
	struct Queue* queue = (struct Queue *)malloc(sizeof(struct Queue));
	queue->capacity = capacity;
	queue->front = 0;
	queue->count = 0;
	queue->rear = -1;
	queue->array = (int*)malloc(queue->capacity * sizeof(int));
	return queue;
}
bool isFull(struct Queue* queue){
	return (queue->count == queue->capacity);
}
bool isEmpty(struct Queue queue){
	return (queue->count == 0);
}
void enQueue(struct Queue *queue, int item){
	if(isFull(queue)){
		return;
	}
	queue->rear = ((queue->rear)+1)%queue->capacity;
	queue->array[queue->rear] = item;
	queue->count++;
}
int deQueue(struct Queue *queue){
	if(isEmpty(queue))
	return 0;
	int item = queue->array[queue->front];
	queue->front = ((queue->front)+1)%queue->capacity;
	queue->count--;
	return item;
}
void breadthFirstSearch(struct Graph *G){
	struct Queue *queue = createQueue(G->V);
	
	int i;
	*(G->visited) = true;
	enQueue(queue, 0);
	int notVisitedVertex;
	while (!isEmpty(queue)) {
		int tempVertex = deQueue(queue);
		printf("%c ",*(G->label+tempVertex));
		while()
	}
}
int main(){
	struct Graph *G;
	G = adjMatrixOfGraph();
	
	printf("Breadth First Search : ");
	return 0;
}