package DSAall.DSA_TUT9VER2;

public class ArrayBinaryTree {
    private String[] l;
    private int size = 0;

    public ArrayBinaryTree(int cap) {
        this.l = new String[cap];
    }

    public void addRoot(String label) {
        if (size == 0) {
            l[1] = label;
            ++size;
        } else {
            System.out.println("Root already exits");
        }
    }

    public int getLeftChild(int node) {
        return (2 * node <= size) ? 2 * node : -1; // left child = 2n
    }

    public int getRightChild(int node) {
        return (2 * node + 1 <= size) ? 2 * node + 1 : -1; // right child = 2n+1
    }

    public int getParent(int node) {
        return (node == 1) ? -1 : node / 2; // -1 is root
    }

    public String getNodeLabel(int node) {
        return (node >= 1 && node <= size) ? l[node] : null;
    }

    public void setNodeLabel(String label, int node) {
        if (node >= 1 && node <= size) {
            l[node] = label;
        } else {
            System.out.println("Invalid node.");
        }
    }

    public void addLeftChild(String label, int node) {
        int leftChild = 2 * node;

        if (leftChild <= l.length && l[node] != null) {
            l[leftChild] = label;
            size = Math.max(size, leftChild);

        } else {
            System.out.println("Invalid operation.");
        }
    }

    public void addRightChild(String label, int node) {
        int rightChild = 2 * node + 1;

        if (rightChild <= l.length && l[node] != null) {
            l[rightChild] = label;
            size = Math.max(size, rightChild);

        } else {
            System.out.println("Invalid operation.");
        }
    }

    // ex2 method
    public boolean isLeaf(int node) {
        return getLeftChild(node) == -1 && getRightChild(node) == -1;
    }

    public int countLeaves() {
        int count = 0;
        for (int i = 1; i <= size; i++) {
            if (isLeaf(i)) {
                count++;
            }
        }
        return count;
    }

    public int getLevel(int node) {
        int level = 0;
        while (node > 1) {
            node = getParent(node);
            level++;
        }
        return level;
    }

    public int getDepth() {
        int maxDepth = 0;
        for (int i = 1; i <= size; i++) {
            int depth = getLevel(i);
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }
        return maxDepth;
    }

    public void inOrderTravel(int node) {
        if (l[node] == null) {
            return;
        }

        int leftChild = getLeftChild(node);
        if (leftChild != -1) {
            inOrderTravel(leftChild);
        }

        System.out.print(getNodeLabel(node) + " ");

        int rightChild = getRightChild(node);
        if (rightChild != -1) {
            inOrderTravel(rightChild);
        }
    }

    public void preOrderTravel(int node) {
        if (l[node] == null) {
            return;
        }

        System.out.print(getNodeLabel(node) + " ");

        int leftChild = getLeftChild(node);
        if (leftChild != -1) {
            preOrderTravel(leftChild);
        }

        int rightChild = getRightChild(node);
        if (rightChild != -1) {
            preOrderTravel(rightChild);
        }
    }

    public void postOrderTravel(int node) {
        if (l[node] == null) {
            return;
        }

        int leftChild = getLeftChild(node);
        if (leftChild != -1) {
            postOrderTravel(leftChild);
        }

        int rightChild = getRightChild(node);
        if (rightChild != -1) {
            postOrderTravel(rightChild);
        }

        System.out.print(getNodeLabel(node) + " ");
    }

    public int search(String label) {
        for (int i = 1; i <= size; i++) {
            if (l[i] != null && l[i].equals(label)) {
                return i; 
            }
        }

        return -1; 
    }
}
