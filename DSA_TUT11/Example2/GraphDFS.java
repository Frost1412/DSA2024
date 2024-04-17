/**
 * Write a description of class GraphDFS here.
 * @author (nxthang) 
 * @version (1.0) 
 */
package DSAall.DSA_TUT11.Example2;
public class GraphDFS
{
    private static int n=7;
    private static GALVertex[] v;                               
    
    /**
     * Constructor for objects of class GraphDFS
     */
    public GraphDFS()
    {
    }
    
    public static void DFS(int u)
    {
    	v[u].setColor('y');
    	System.out.print(v[u].getLabel() + " ");
    	SLList temp = v[u].getAdjList();
    	for (int i = 0; i< temp.getLength() ; i++ ) {
//    		System.out.println(i);
    		SLNode tempN = temp.get(i);
//    		System.out.println(tempN);
    		int j = tempN.getData();
    		if (v[j].getColor() == 'w') {
    			DFS(j);
    		}
    	}
    }
    
    public static void DFS_Initialize()
    {
    	for (GALVertex V : v) {
    		V.setColor('w');
    	}
    }
    
    public static void main(String[]args)
    {
        v = new GALVertex[n];     //Create an empty list of n vertices
        // Initialize vertex's label
        v[0]=new GALVertex('A');  v[0].addToAdjList(1); v[0].addToAdjList(4);
        v[1]=new GALVertex('B');  v[1].addToAdjList(0); v[1].addToAdjList(2); v[1].addToAdjList(6);
        v[2]=new GALVertex('C');  v[2].addToAdjList(1); v[2].addToAdjList(5);   
        v[3]=new GALVertex('D');  v[3].addToAdjList(4); v[3].addToAdjList(5);
        v[4]=new GALVertex('E');  v[4].addToAdjList(0); v[4].addToAdjList(3); v[4].addToAdjList(5);
        v[5]=new GALVertex('F');  v[5].addToAdjList(2); v[5].addToAdjList(3); v[5].addToAdjList(4);
        v[6]=new GALVertex('G');  v[6].addToAdjList(1);

        System.out.println("DFS traversal from vertex v[0]");
        DFS_Initialize();
        DFS(0);
        System.out.println("");        
        System.out.println("DFS traversal from vertex v[6]");
        DFS_Initialize();        
        DFS(6);        
    }
}
