//O(V+E)
import java.util.ArrayList;

public class cycledetectiondirected {

    static class Edge{
        int src;
        int des;

        public Edge(int s , int d){
            this.src=s;
            this.des=d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));
    }

    static boolean isCycle(ArrayList<Edge>[] graph){
        boolean[] st=new boolean[graph.length];
        boolean[] vis=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            
            if(!vis[i]){
                if(isCycleUtil(graph, i, vis, st)){
                    return true;
                }
            }
        
        }
        return false;
        
    }
    static boolean isCycleUtil(ArrayList<Edge>[] graph, int curr , boolean[] vis, boolean[] st){
        vis[curr]=true;
        st[curr]=true;

        for(int i =0; i < graph[curr].size();i++){
                Edge e=graph[curr].get(i);
                if(st[e.des]){
                    return true;
                }
                if(!vis[e.des] && isCycleUtil(graph, e.des, vis, st)){
                    return true;
                }

        }
        st[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge>[] graph=new ArrayList[v];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
    
}
