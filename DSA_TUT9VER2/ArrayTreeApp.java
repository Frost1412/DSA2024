package DSAall.DSA_TUT9VER2;

public class ArrayTreeApp {
    public static void main(String[] args) {
        ArrayTree tree = new ArrayTree(10);
        tree.addNode("A", -1);
        tree.addNode("B", 0);
        tree.addNode("C", 0);
        tree.addNode("D", 1);
        tree.addNode("E", 1);
        tree.addNode("F", 2);
        tree.addNode("G", 2);
        System.out.println(tree);
        System.out.println();

        System.out.println("Parent of node 4: " + tree.getParent(4));
        System.out.println("Label of node 3: " + tree.getNodeLabel(3));

        tree.setNodeLabel("X", 3);
        System.out.println("Label of node 3 after update: " + tree.getNodeLabel(3));
        System.out.println(tree);
        System.out.println();

        System.out.println("Left most child of node 0: " + tree.leftMostChild(0));
        System.out.println("Right sibling of node 4: " + tree.rightSibling(4));
        System.out.println("Degree of node 0: " + tree.getDegree(0));
        System.out.println("Is node 6 a leaf? " + tree.isLeaf(6));
        System.out.println("Number of leaves in the tree: " + tree.countLeaves());
        System.out.println("Level of node 6: " + tree.getLevel(6));
        System.out.println("Depth of the tree: " + tree.getDepth());
        System.out.println("Position of node with label 'E': " + tree.search("E"));
    }
}
