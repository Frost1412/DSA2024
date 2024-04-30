package DSAall.DSA_TUT9VER2;

public class ArrayBinaryTreeApp {
    public static void main(String[] args) {
        ArrayBinaryTree tree = new ArrayBinaryTree(10);

        // add root
        tree.addRoot("1");

        // add children
        tree.addLeftChild("2", 1);
        tree.addRightChild("3", 1);
        tree.addLeftChild("4", 2);
        tree.addRightChild("5", 2);
        tree.addLeftChild("6", 3);

        // check leaf nodes
        System.out.println("Is node 4 a leaf? " + tree.isLeaf(4));
        System.out.println("Is node 2 a leaf? " + tree.isLeaf(2));

        // count leaves
        System.out.println("Number of leaves: " + tree.countLeaves());

        // get level of nodes
        System.out.println("Level of node 4: " + tree.getLevel(4));
        System.out.println("Level of node 5: " + tree.getLevel(5));

        // get depth of the tree
        System.out.println("Depth of the tree: " + tree.getDepth());

        // in order
        System.out.print("In-order traversal: ");
        tree.inOrderTravel(1);
        System.out.println();

        // pre order
        System.out.print("Pre-order traversal: ");
        tree.preOrderTravel(1);
        System.out.println();

        // post order
        System.out.print("Post-order traversal: ");
        tree.postOrderTravel(1);
        System.out.println();

        // search for a label
        System.out.println("Position of label '1': " + tree.search("3"));
        System.out.println("Position of label '7': " + tree.search("7"));
    }
}
