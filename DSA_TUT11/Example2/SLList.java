/**
 * Class SLList implement a linked-list data structure. Each element of the list is a string.
 * Please refer to Lecture 6 for the detail Linked-List ADT.
 * @author (nxthang) 
 * @version (1.0)
 */
package DSAall.DSA_TUT11.Example2;

public class SLList
{
    private SLNode head;

    /**
     * Constructor for objects of class SLList.
     * This constructor will create an empty list.
     */
    public SLList()
    {
    	this.head=null;
    }

    /**
     * This operation returns true if the list is empty, otherwise it returns false
     */

    public boolean isEmpty()
    {
    	return head==null;
    }

    /**
     * This is a private operation (supplementary operation). It returns the node at the pos position of the list.
     */    
    private SLNode traversing(int pos)
    {
    	SLNode current = this.head;
		int count = 1;
		while(count < pos) {
			count++;
			current = current.getNext();
		}
		return current;
    }
    
    /**
     * This operation adds a newNode into the beginning of the list
     */
    
    public void add(SLNode newNode)
    {
    	newNode.setNext(head);
		this.head = newNode;
    }
    
    /**
     * This operation returns the node at the pos position of the list.
     */    
    public SLNode get(int pos)
    {
        return this.traversing(pos); // Use the traversing method to get the node at the pos position.
    }

    /**
     * This operation returns the current length of the list. 
     */    
    public int getLength()
    {
        int length = 0;
        SLNode current = this.head;
        while (current != null) {
            length++;
            current = current.getNext();
        }
        return length;
    }
  
}