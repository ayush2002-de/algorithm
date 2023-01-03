import java.util.*;
public class airport {
    public class Node{
        String airport;
        ArrayList<String>connection=new ArrayList<>();
        boolean isReachable=true;
        ArrayList<String>unreachableConnection=new ArrayList<>();
        Node(String airport){
            this.airport=airport;
        }

    }
    public int airportConnnection(String []airports,String [][]routes,String startingAirport){
        HashMap<String,Node>graph=createGraph(airports,routes);
        ArrayList<Node>unreachableAirportNodes=getUnreachableAirportNode(graph,airports,startingAirport);
        markUnreachableConnections(graph,unreachableAirportNodes);
        return getMin(graph,unreachableAirportNodes);

    }
    public  HashMap<String,Node> createGraph(String []airports,String [][]routes){
        HashMap<String,Node>graph=new HashMap<>();
        for(String airport:airports){
            graph.put(airport,new Node(airport));
        }
        for(String route[]:routes){
            graph.get(route[0]).connection.add(route[1]);
        }

        return graph;
    }
    
    public ArrayList<Node>getUnreachableAirportNode( HashMap<String,Node>graph,String []airports,String start){
        ArrayList<Node> unreachableAirportNodes=new ArrayList<>();
        HashSet<String>visited=new HashSet<>();
        depthFirstTraverseAirports(graph,start,visited);
        for(String airport:airports){
            if(visited.contains(airport))continue;
           Node  airportNode=graph.get(airport);
           airportNode.isReachable=false;
           unreachableAirportNodes.add(airportNode);
        }

        return unreachableAirportNodes;
    }
    public void depthFirstTraverseAirports(HashMap<String,Node>graph,String airport, HashSet<String>visited){
         if(visited.contains(airport))return;
         visited.add(airport);
         for(String connection:graph.get(airport).connection){
            depthFirstTraverseAirports(graph, connection, visited);
         }
    }
    public void markUnreachableConnections(HashMap<String,Node>graph, ArrayList<Node> unreachableAirportNodes){
        for(Node airportNode:unreachableAirportNodes){
            String airport = airportNode.airport;
            ArrayList<String>unreachableConnection=new ArrayList<>();
            depthFirstAddUnreachableConnection(graph, airport, unreachableConnection,new HashSet<>());
            airportNode.unreachableConnection=unreachableConnection;


        }
    }
    public void depthFirstAddUnreachableConnection(HashMap<String,Node>graph,String airport,ArrayList<String>unreachableConnection, HashSet<String>visited){
        if(graph.get(airport).isReachable)return;
        if(visited.contains(airport))return;
        visited.add(airport);
        unreachableConnection.add(airport);
        for(String connection:graph.get(airport).connection){
            depthFirstAddUnreachableConnection(graph, connection, unreachableConnection, visited);
        }

    }
    public int getMin(HashMap<String,Node>graph, ArrayList<Node> unreachableAirportNodes){
        int ans=0;
        Collections.sort(unreachableAirportNodes,(a,b)->{
            return b.unreachableConnection.size()-a.unreachableConnection.size();
        });

        for(Node airportNode :unreachableAirportNodes){
            if(airportNode.isReachable)continue;
            ans+=1;
            for(String connection :airportNode.unreachableConnection){
                graph.get(connection).isReachable=true;
            }
        }
        return ans;
    }
}
