//tc-O(v+elogn)

import java.util.*;

public class dijkstras {
    //create edge
    static class Edge{
        int src;
        int des;
        int wt;

        public Edge(int s,int d,int wt){
            this.src=s;
            this.des=d;
            this.wt=wt;
        }
    }
    //create graph
static void createGraph(ArrayList<Edge>[] graph){
    for(int i=0;i<graph.length;i++){
        graph[i]=new ArrayList<>();
    }

graph[0].add(new Edge(0,1,2));
graph[0].add(new Edge(0,2,4));

graph[1].add(new Edge(1,2,1));
graph[1].add(new Edge(1,3,7));

graph[2].add(new Edge(2,4,3));

graph[3].add(new Edge(3,5,1));

graph[4].add(new Edge(4,3,2));
graph[4].add(new Edge(4,5,5));
}
//create pair class comparable for priority queue
static class Pair implements Comparable<Pair>{
    int node;
    int dist;

    Pair(int node, int d){
        this.node=node;
        this.dist=d;
    }

    public int compareTo(Pair p){
        return this.dist - p.dist;
    }
}
//create priority queue 
static void dijktra(ArrayList<Edge>[] graph,int src){
    int[] dis=new int[graph.length];
    for(int i=0;i<dis.length;i++){
        if(i!=src){
        dis[i]=Integer.MAX_VALUE;
        }
    }

    //priority queue
    PriorityQueue<Pair> pq=new PriorityQueue<>();
    pq.add(new Pair(src ,0));

    //boolean visited 
    boolean[] vis = new boolean[graph.length];
   

    //main logic

    while(!pq.isEmpty()){
        Pair curr=pq.remove();

        if(!vis[curr.node]){
            vis[curr.node]=true;

            //neighbors
            for(int i=0;i<graph[curr.node].size();i++){
                Edge e=graph[curr.node].get(i);
                int u=e.src;
                int v=e.des;
                int wt=e.wt;

                if(dis[u]+wt<dis[v]){
                    dis[v]=dis[u]+wt;
                    pq.add(new Pair(v, dis[v]));

                }
            }
        }

    }
    //print distance from src
    for(int i=0;i<dis.length;i++){
        System.out.print(dis[i]+" ");

    }
}

public static void main(String[] args){
    int v=6;
    ArrayList<Edge>[] graph=new ArrayList[v];
    createGraph(graph);
    dijktra(graph, 0);
}
    
}
