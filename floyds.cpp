#include <iostream>
using namespace std;

#define V 4
#define INF 99999

void print(int dist[V][V])
{
	cout<<"Shortest distance between every pair of verties\n";
	for(int i=0;i<V;i++)
	{
		for(int j=0;j<V;j++)
		{
			if(dist[i][j] == INF)
				cout<<"∞ ";
			else
				cout<<dist[i][j]<<" ";
		}
		cout<<endl;
	}
}

void floyd(int graph[V][V])
{
	int dist[V][V];
	for(int i=0;i<V;i++)
		for(int j=0;j<V;j++)
			dist[i][j] = graph[i][j];

	for(int k=0;k<V;k++)
		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
				if(dist[i][k] + dist[k][j] < dist[i][j])
					dist[i][j] = dist[i][k]+dist[k][j];

	print(dist);
}

int main()
{
	int graph[V][V] = {{0  ,5  ,INF,10 },
					   {INF,0  ,3  ,INF},
					   {INF,INF,0  ,1  },
					   {INF,INF,INF,0  }
					  };
	floyd(graph);
	return 0;
}