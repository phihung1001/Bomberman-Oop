package AI;

/**
 * Khai bao cac thuoc tinh cua Node.
 */
public class Node {
    Node parent;
    public int c, r;
    int gCost;
    int hCost;
    int fCost;
    boolean solid;
    boolean open;
    boolean checked;

    public Node(int col,int row)

    {
        this.c = col;
        this.r = row;
    }
}