/**
 * Class BinaryTree implements a binary tree based on its recursive definition.
 * Please refer to the lecture 10 and tutorial week 10 for the detail of the concept and binary tree ADT.
 * @author (nxthang) 
 * @version (1.0)
 */
package DSA_TUT10.Example1;
public class BinaryTree
{
    BTNode root;
    BinaryTree leftSubTree;
    BinaryTree rightSubTree;
    
    /**
     * Constructor for objects of class BinaryTree
     */
    public BinaryTree()
    {
        root = null;
        leftSubTree = null;
        rightSubTree = null;
    }
    
    public void buildTree(String rootValue, BinaryTree left, BinaryTree right)
    {
        root = new BTNode(rootValue);
        leftSubTree = left;
        rightSubTree = right;
    }
    
    public void buildTreeByValue(String rootValue, String leftValue, String rightValue)
    {
        root = new BTNode(rootValue);
        leftSubTree = new BinaryTree();
        leftSubTree.setTreeValue(leftValue);
        rightSubTree = new BinaryTree();
        rightSubTree.setTreeValue(rightValue);
    			
    }
    
    public boolean isEmpty()
    {
        return root == null && leftSubTree == null && rightSubTree == null;


    }
    
    public void makeEmpty()
    {
        root = null;
        leftSubTree = null;
        rightSubTree = null;
    }
    
    public String getTreeValue()
    {
        return root != null ? root.getLabel() : null;

    }
    
    public void setTreeValue(String label)
    {
        if (root != null)
            root.setLabel(label);
        else
            root = new BTNode(label);
    }
    
    public boolean isLeaf()
    {
        return root != null && leftSubTree == null && rightSubTree == null;

    }
    
    public BinaryTree getLeftSubTree()
    {
        return leftSubTree;

    }
    
    public void setLeftSubTree(BinaryTree left)
    {
        leftSubTree = left;

    }
    
    public BinaryTree getRightSubTree()
    {
        return rightSubTree;

    }
    
    public void setRightSubTree(BinaryTree right)
    {
        rightSubTree = right;

    }   
    
    public void preOrderTraversal(BinaryTree t)
    {
        if (t != null && t.root != null) {
            System.out.print(t.root.getLabel() + " ");
            preOrderTraversal(t.leftSubTree);
            preOrderTraversal(t.rightSubTree);
        }
    }
    public void inOrderTraversal(BinaryTree t) {
        if (t != null && t.root != null) {
            inOrderTraversal(t.leftSubTree);
            System.out.print(t.root.getLabel() + " ");
            inOrderTraversal(t.rightSubTree);
        }
    }
    public void postOrderTraversal(BinaryTree t) {
        if (t != null && t.root != null) {
            postOrderTraversal(t.leftSubTree);
            postOrderTraversal(t.rightSubTree);
            System.out.print(t.root.getLabel() + " ");
        }
    }
    
    public int getDepth(BinaryTree t)
    {
        if (t == null || t.root == null)
            return 0;
        else {
            int leftDepth = getDepth(t.leftSubTree);
            int rightDepth = getDepth(t.rightSubTree);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
    
    public int countLeaves(BinaryTree t)
    {
        if (t == null)
            return 0;
        else if (t.isLeaf())
            return 1;
        else
            return countLeaves(t.leftSubTree) + countLeaves(t.rightSubTree);
    }
    
    public int iPathLength(BinaryTree t, int depth)//IPL(t,0)
    {
        return iPathLengthHelper(t, 0);

    }
    private int iPathLengthHelper(BinaryTree t, int depth) {
        if (t == null || t.root == null)
            return 0;
        else
            return depth + iPathLengthHelper(t.leftSubTree, depth + 1) + iPathLengthHelper(t.rightSubTree, depth + 1);
    }



    public int countNodes(BinaryTree t)
    {
        if (t == null)
            return 0;
        else
            return 1 + countNodes(t.leftSubTree) + countNodes(t.rightSubTree);
    }
    }

