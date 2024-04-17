/**
 * Class BinarySearchTree implements a binary search tree. Please refer to the lecture 10 for details.
 * @author (nxthang)
 * @version (1.0)
 */
package DSAall.DSA_TUT10.Example2;
public class BinarySearchTree
{
    BSTNode root;
    BinarySearchTree leftSubTree;
    BinarySearchTree rightSubTree;

    /**
     * Constructor for objects of class BinarySearchTree
     * Create an empty binary search tree
     */
    public BinarySearchTree()
    {
    this.root = null;
    this.leftSubTree = null;
    this.rightSubTree = null;
    }

    public void addRoot(int value)
    {
        root = new BSTNode(value);

    }

    public boolean isEmpty()
    {
        return root == null;

    }

    public int getTreeValue()
    {
        return root != null ? root.getKey() : Integer.MIN_VALUE;

    }

    public BinarySearchTree getRightSubTree()
    {
        return rightSubTree;

    }

    public BinarySearchTree getLeftSubTree()
    {
        return leftSubTree;

    }

    public void setRightSubTree(BinarySearchTree right)
    {
        rightSubTree = right;

    }

    public void setLeftSubTree(BinarySearchTree left)
    {
        leftSubTree = left;

    }

    public boolean insert(int key, BinarySearchTree t)
    {
        if (t == null)
            return false;
        if (key < t.getTreeValue()) {
            if (t.getLeftSubTree() == null) {
                t.setLeftSubTree(new BinarySearchTree());
                t.getLeftSubTree().addRoot(key);
                return true;
            } else {
                return insert(key, t.getLeftSubTree());
            }
        } else if (key > t.getTreeValue()) {
            if (t.getRightSubTree() == null) {
                t.setRightSubTree(new BinarySearchTree());
                t.getRightSubTree().addRoot(key);
                return true;
            } else {
                return insert(key, t.getRightSubTree());
            }
        } else {
            return false; // key already exists
        }
    }

    public int getMax(BinarySearchTree t)
    {
        if (t.getRightSubTree() == null)
            return t.getTreeValue();
        else
            return getMax(t.getRightSubTree());
    }

    public int getMin(BinarySearchTree t)
    {
        if (t.getLeftSubTree() == null)
            return t.getTreeValue();
        else
            return getMin(t.getLeftSubTree());
    }

    public boolean search(int key, BinarySearchTree t)
    {
        if (t == null)
            return false;
        else if (key == t.getTreeValue())
            return true;
        else if (key < t.getTreeValue())
            return search(key, t.getLeftSubTree());
        else
            return search(key, t.getRightSubTree());
    }
    public void preOrderTraversal(BinarySearchTree t)
    {
        if (t != null && t.root != null) {
            System.out.print(t.root.getKey() + " ");
            preOrderTraversal(t.getLeftSubTree());
            preOrderTraversal(t.getRightSubTree());
        }
    }
    }

