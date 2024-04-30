package DSAall.DSA_TUT9VER2;

import java.util.*;

public class ArrayTree {
    private String[] l;
    private int[] p;
    private int n = 0;

    public ArrayTree(int cap) {
        this.l = new String[cap];
        this.p = new int[cap];
        Arrays.fill(p, -2);
    }

    public boolean isFull() {
        return n == l.length;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void addNode(String label, int parent) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Tree is full");
        }

        if (parent != -1) {
            int pos = parent + 1;
            while (p[pos] < parent && pos < n) {
                ++pos;
            }

            for (int i = n; i > pos; i--) {
                l[i] = l[i - 1];
                p[i] = p[i - 1];
            }

            l[pos] = label;
            p[pos] = parent;
            ++n;
            return;
        }

        l[n] = label;
        p[n] = parent;
        ++n;

    }

    public int getParent(int node) {
        if (node >= 0 && node < n) {
            return p[node];
        }

        return -1;
    }

    public String getNodeLabel(int node) {
        if (node >= 0 && node < n) {
            return l[node];
        }

        return null;
    }

    public void setNodeLabel(String label, int node) {
        if (node >= 0 && node < n) {
            l[node] = label;
        }
    }

    public int leftMostChild(int node) {
        for (int i = node + 1; i < n; i++) {
            if (p[i] == node) {
                return i;
            }
        }

        return -1;
    }

    public int rightSibling(int node) {
        if (node + 1 < n && p[node + 1] == p[node]) {
            return node + 1;
        }

        return -1;
    }

    // ex1 method

    public int getDegree(int node) {
        int degree = 0;
        for (int i = 0; i < n; i++) {
            if (p[i] == node) {
                degree++;
            }
        }

        return degree;
    }

    public boolean isLeaf(int node) {
        for (int i = 0; i < n; i++) {
            if (p[i] == node) {
                return false;
            }
        }

        return true;
    }

    public int countLeaves() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (isLeaf(i)) {
                count++;
            }
        }

        return count;
    }

    public int getLevel(int node) {
        int level = 0;
        while (node != -1) {
            node = getParent(node);
            level++;
        }

        return level - 1;
    }

    public int getDepth() {
        int maxLevel = 0;
        for (int i = 0; i < n; i++) {
            int level = getLevel(i);
            if (level > maxLevel) {
                maxLevel = level;
            }
        }

        return maxLevel;
    }

    public int search(String label) {
        for (int i = 0; i < n; i++) {
            if (l[i].equals(label)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        return "L: " + Arrays.toString(l) + "\nP: " + Arrays.toString(p);
    }
}