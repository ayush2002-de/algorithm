import java.util.*;
public class aStar{
    public class Node{
        int hurustic;
        int distFromstart;
        int x;
        int y;
        int pastX;
        int pastY;
        Node(int i,int j,int val){
            hurustic=(int)1e9;
            distFromstart=(int)1e9;
            x=i;
            y=j;
        }

    }
    public int manhattan(int x1,int y1,int x2,int y2){
        return 0;
    }
    public  String astar(int graph[][],int startX,int startY,int endX,int endY){
          String ans="";
          int dir[][]=new int [][]{{0,1},{1,0},{0,-1},{-1,0}};
          Node graph1[][]=createNodeGraph(graph);
          PriorityQueue<Node>pq=new PriorityQueue<>();
          graph1[startX][startY].hurustic=manhattan(startX,startY,endX,endY);
          graph1[startX][startY].distFromstart=manhattan(startX,startY,endX,endY);
          pq.add(graph1[startX][startY]);
          while(pq.isEmpty()){
            Node n=pq.remove();
            if(endX==n.x && endY==n.y){
                break;
            }
            for(int d[]:dir){
                int ni=n.x+d[0];
                int nj=n.y+d[1];
                if(valid(ni,nj,graph1)){

                }
            }


          }

          return ans;
    }
    public boolean valid(int i,int j,Node graph[][]){
        return true;
    }
    public Node [][] createNodeGraph(int graph[][]){
       Node Graph[][]=new Node[graph.length][graph[0].length];
       for(int i=0;i<graph.length;i++){
        for(int j=0;j<graph[0].length;j++){
            Graph[i][j]=new Node(i,j,graph[i][j]);
        }
       }
       return Graph;
    }
    
}