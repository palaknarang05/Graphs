import java.util.*;

public class dfs {
   static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        //vertex 0
        graph[0].add(new Edge(0, 1, 5));

        //vertex-1

        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2 , 1));
        graph[1].add(new Edge(1, 3 , 3));

        //vertex-2

        graph[2].add(new Edge(2, 1 , 1));
        graph[2].add(new Edge(2, 3 , 1));
        graph[2].add(new Edge(2, 4 , 2));


        //vertex-3
        graph[3].add(new Edge(3, 2 , 1));
        graph[3].add(new Edge(3, 1 , 3));

        //vertex4

        graph[4].add(new Edge(4, 2 , 1));


    }

    public static void dfs(ArrayList<Edge> graph[],int curr,  boolean[] vis){
      
        System.out.print(curr+" ");
        vis[curr]=true;
        
        for(int i=0;i<graph[curr].size();i++){
          
                Edge e1=graph[curr].get(i);
                  if(!vis[e1.dest]){
                dfs(graph,e1.dest,vis);

            }
        }

    }
    public static void main(String[] args){
        int v=5;
        ArrayList<Edge> graph[]=new ArrayList[v];
          
        createGraph(graph);
        dfs(graph,0,new boolean[v]);
    }

    
}
