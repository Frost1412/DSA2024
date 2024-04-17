/**
 * Write a description of class GraphBFS here.
 * @author (nxthang) 
 * @version (1.0)
 */
package DSAall.DSA_TUT11.Example1;
public class GraphBFS
{
    private static int n=7;
    private static int[][] a = {
    		{0,1,0,0,1,0,0},
    		{1,0,1,0,0,0,1},
    		{0,1,0,0,0,1,0},
    		{0,0,0,0,1,1,0},
    		{1,0,0,1,0,1,0},
    		{0,0,1,1,1,0,0},
    		{0,1,0,0,0,0,0} 
    		};
//	      						    A B C D E F G
//                               A {0,1,0,0,1,0,0},
//                               B {1,0,1,0,0,0,1},
//                               C {0,1,0,0,0,1,0},
//                               D {0,0,0,0,1,1,0},
//                               E {1,0,0,1,0,1,0},
//                               F {0,0,1,1,1,0,0},
//                               G {0,1,0,0,0,0,0}                                
                               
    private static GVertex[] v;                               
    
    /**
     * Constructor for objects of class GraphBFS
     */
    public GraphBFS()
    {
    	
    }
    
    public static void BFS(int s)
    {
    	for (GVertex V : v ) {
    		V.setColor('w');
    	}
    	ArrayQueue Q = new ArrayQueue();
    	v[s].setColor('y'); 
    	Q.enqueue(s);
    	
    	while(!Q.isEmpty()){
    		int u = Q.dequeue();
    		System.out.print(v[u].getLabel()); 
    		for (int i = 0; i < s+1; i++ ) {
    			if (a[u][i] == 1) {
    				if (v[i].getColor() == 'w') {
    					v[i].setColor('y');
    					Q.enqueue(i);
    				}
    			}
    		}
    	}
    	System.out.println();
    }
    
    public static void main(String[]args)
    {
        v = new GVertex[n];     //Create an empty list of n vertices
        // Initialize vertex's label
        v[0]=new GVertex('A');
        v[1]=new GVertex('B');
        v[2]=new GVertex('C');
        v[3]=new GVertex('D');
        v[4]=new GVertex('E');
        v[5]=new GVertex('F');
        v[6]=new GVertex('G');

        System.out.println("BFS traversal from vertex v[0]");
        BFS(0);
        System.out.println("BFS traversal from vertex v[6]");
        BFS(6);
        
    }
}
