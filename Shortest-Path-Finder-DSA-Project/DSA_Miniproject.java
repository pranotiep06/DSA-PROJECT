package DSL_Assignments;
import java.util.*;
import java.util.Queue;

public class DSA_Miniproject {
	static void printpath(int src,int des,int[] arr, String[] stations) {
		ArrayList<Integer> ar=new ArrayList<Integer>();
		while(arr[des]!=des) {
			ar.add(des);
			des=arr[des];
		}
		ar.add(src);
		ArrayList<Integer> rev=new ArrayList<Integer>();
		for(int i=ar.size()-1;i>=0;i--) {
			rev.add(ar.get(i));
		}
		System.out.print("PATH :");
		for(int i=0;i<rev.size();i++) {
			
			System.out.print("-->"+stations[rev.get(i)]);
		}
		System.out.println();
	}
	static public void shortestPath(ArrayList<ArrayList<HashMap<Integer,Integer>>> adj,int N, int src,int des,int f)
    {
		int flag=f;
        int[] dist = new int[N+1];
        for(int i =0; i < N+1; i++)
            dist[i]=1000000000;
        
        int[] parent=new int[N+1];
        for(int i=0;i<parent.length;i++) {
        	parent[i]=i;
        }
        Queue<Integer> q=new LinkedList<>(); 
        String[] stations={"null","Katraj","Warje","Hadapsar","Kothrud","Karvenagar","MarketYard","Swargate","Pune Station","Deccan","Hinjewadi","Wagholi","Sangvi","Baner","Airport","Wakad","Pimpri","Chinchwad","Nigdi"};
        
        
        //ArrayList<String> path=new ArrayList<String>();
    
        dist[src] = 0;
        q.add(src);
    
        while(!q.isEmpty())
        {
         int node= q.poll();
         
         for(HashMap<Integer,Integer> it:adj.get(node))
           {
        	 for(int it2: it.keySet()) {
            if(dist[node] + it.get(it2) < dist[it2]){
                dist[it2]= dist[node]+ it.get(it2);
                parent[it2]=node;
                q.add(it2);
            }
            }
        	 
           }
        }
        if(flag==1) {
        System.out.println("Rs. "+dist[des]);
        }
        if(flag==2) {
        	 System.out.println(dist[des]+ " km");
        }
      printpath(src,des,parent,stations);
    }

	 static void addEdge(ArrayList<ArrayList<HashMap<Integer,Integer>>> adj,int u, int v, int weight)
    {
        adj.get(u).add(new HashMap<>());
       adj.get(u)
            .get(adj.get(u).size() - 1)
            .put(v, weight);
  
        adj.get(v).add(new HashMap<>());
        adj.get(v)
            .get(adj.get(v).size() - 1)
            .put(u, weight);
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n=18,answer=0;                          //Number of stations and variables declared
        //Create Arraylist of Arraylist of hashmap and store key and value in hashmap
        //key as source of one arraylist,destination of arraylist inside it and value as cost or distance
        ArrayList<ArrayList<HashMap<Integer,Integer>>> adjp= new ArrayList<ArrayList<HashMap<Integer,Integer>>>();
        ArrayList<ArrayList<HashMap<Integer,Integer>>> adjd= new ArrayList<ArrayList<HashMap<Integer,Integer>>>();
        //Initializing arraylists inside arraylist
        for(int i =0; i<n+1; i++){
            adjp.add(new ArrayList<HashMap<Integer,Integer>>());
        }
        for(int i =0; i<n+1; i++){
            adjd.add(new ArrayList<HashMap<Integer,Integer>>());
        }
        addEdge(adjp,1,2,10);
        addEdge(adjp,1,5,10);
        addEdge(adjp,1,6,20);
        addEdge(adjp,2,4,5);
        addEdge(adjp,2,5,5);
        addEdge(adjp,3,6,10);
        addEdge(adjp,3,8,10);
        addEdge(adjp,4,5,5);
        addEdge(adjp,4,7,10);
        addEdge(adjp,4,9,5);
        addEdge(adjp,4,17,50);
        addEdge(adjp,4,10,20);
        addEdge(adjp,5,7,5);
        addEdge(adjp,5,9,5);
        addEdge(adjp,6,7,5);
        addEdge(adjp,6,8,10);
        addEdge(adjp,7,14,15);
        addEdge(adjp,7,8,10);
        addEdge(adjp,8,9,30);
        addEdge(adjp,8,11,5);
        addEdge(adjp,8,13,20);
        addEdge(adjp,8,14,10);
        addEdge(adjp,9,10,25);
        addEdge(adjp,9,12,15);
        addEdge(adjp,9,13,10);
        addEdge(adjp,10,12,15);
        addEdge(adjp,10,15,5);
        addEdge(adjp,11,14,5);
        addEdge(adjp,11,18,50);
        addEdge(adjp,12,16,10);
        addEdge(adjp,12,13,15);
        addEdge(adjp,13,16,10);
        addEdge(adjp,14,16,40);
        addEdge(adjp,14,17,40);
        addEdge(adjp,14,18,30);
        addEdge(adjp,15,17,5);
        addEdge(adjp,16,17,5);
        addEdge(adjp,17,18,10);
        
        addEdge(adjd,1,2,8);
        addEdge(adjd,1,5,9);
        addEdge(adjd,1,6,16);
        addEdge(adjd,2,4,5);
        addEdge(adjd,2,5,1);
        addEdge(adjd,3,6,9);
        addEdge(adjd,3,8,9);
        addEdge(adjd,4,5,3);
        addEdge(adjd,4,7,8);
        addEdge(adjd,4,9,2);
        addEdge(adjd,4,17,30);
        addEdge(adjd,4,10,17);
        addEdge(adjd,5,7,3);
        addEdge(adjd,5,9,4);
        addEdge(adjd,6,7,3);
        addEdge(adjd,6,8,6);
        addEdge(adjd,7,14,19);
        addEdge(adjd,7,8,5);
        addEdge(adjd,8,9,28);
        addEdge(adjd,8,11,4);
        addEdge(adjd,8,13,18);
        addEdge(adjd,8,14,8);
        addEdge(adjd,9,10,21);
        addEdge(adjd,9,12,11);
        addEdge(adjd,9,13,9);
        addEdge(adjd,10,12,12);
        addEdge(adjd,10,15,4);
        addEdge(adjd,11,14,5);
        addEdge(adjd,11,18,35);
        addEdge(adjd,12,16,6);
        addEdge(adjd,12,13,7);
        addEdge(adjd,13,16,6);
        addEdge(adjd,14,16,25);
        addEdge(adjd,14,17,26);
        addEdge(adjd,14,18,23);
        addEdge(adjd,15,17,8);
        addEdge(adjd,16,17,5);
        addEdge(adjd,17,18,6);
        
        do {
        String[] stations={"null","Katraj","Warje","Hadapsar","Kothrud","Karvenagar","MarketYard","Swargate","Pune Station","Deccan","Hinjewadi","Wagholi","Sangvi","Baner","Airport","Wakad","Pimpri","Chinchwad","Nigdi"};
        System.out.println("******************************************************* WELCOME TO PMPML PATH FINDER *******************************************************");
        for(int i=1;i<=18;i++){
            System.out.println("Enter value "+ i + " for "+ stations[i]);
        }
        System.out.println("********************************************************************************************************************************************");
        System.out.println("Enter the source STATION:");
        int src=sc.nextInt();
        if(src<1||src>18) {
        	System.out.println("Invalid Entry");
        }
        System.out.println("Enter the destination: ");
        int des=sc.nextInt();
        if(des<1||des>18) {
        	System.out.println("Invalid Entry");
        }
        System.out.println("Enter your choice\n1.Minimum cost from source to destination\n2.Minimum distance path from source to destination");
        int ans = sc.nextInt();
        if(ans==1) {
        System.out.println("\nThe shortest path from "+stations[src]+" to  "+stations[des]+" Price-wise: ");
        shortestPath(adjp, n, src,des,ans);
        }
        else if(ans==2) {
        System.out.println("\nThe shortest path from "+stations[src]+" to  "+stations[des]+" distance-wise: ");
       shortestPath(adjd, n, src,des,ans);
        }
        else {
        	System.out.println("INVALID CHOICE");
        }
        System.out.println("\nEnter 1 to continue\nEnter 0 to exit");
        answer=sc.nextInt();
	}
	while(answer==1);
	}

}
