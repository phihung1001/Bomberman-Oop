package AI;

import Game.GamePanel;

import java.util.ArrayList;

public class ShortestPathFinder {
    int step = 0;
    GamePanel gamePanel;
    Node[][] node;
    ArrayList<Node> openList = new ArrayList<>();
    public ArrayList<Node> pathList = new ArrayList<>();

    Node start, goal, current;
    boolean Reached = false;


    /**
     * Khoi tao phuong thuc tim duong.
     */
    public ShortestPathFinder(GamePanel gp) {
        this.gamePanel = gp;
        initiateNodes();
    }

    /**
     * Tao mang Node 2 chieu.
     */
    public void initiateNodes() {
        node = new Node[16][16];
        for (int c = 0; c < 16; c++) {
            for (int r = 0; r < 16; r++) {
                node[c][r] = new Node(c, r);
            }
        }
    }

    /**
     * Reset qua trinh neu khong tim duoc duong di.
     */
    public void resetNodes() {
        for (int c = 0; c < 16; c++) {
            for (int r = 0; r < 16; r++) {
                node[c][r].open = false;
                node[c][r].checked = false;
                node[c][r].solid = false;
            }
        }
        openList.clear();
        pathList.clear();
        Reached = false;
        step = 0;
    }

    /**
     * Xet toa do ban dau va dich den.
     */
    public void setNodes(int startCol, int startRow, int goalCol, int goalRow) {
        resetNodes();
        start = node[startCol][startRow];
        current = start;
        goal = node[goalCol][goalRow];
        openList.add(current);
        for(int c = 0; c < 16; c++) {
            for (int r = 0; r < 16; r++) {
                int tileNum = gamePanel.tileM.mapTileNum[c][r];
                if (gamePanel.tileM.tile[tileNum].collision) {
                    node[c][r].solid = true;
                }
                getCost(node[c][r]);
            }
        }
    }

    /**
     * Tinh quang duong can di chuyen.
     */
    public void getCost(Node node) {
        int xDis = Math.abs(node.c - start.c);
        int yDis = Math.abs(node.r - start.r);
        node.gCost = xDis + yDis;
        xDis = Math.abs(node.c - goal.c);
        yDis = Math.abs(node.r - goal.r);
        node.hCost = xDis + yDis;
        node.fCost = node.gCost + node.hCost;
    }

    /**
     * Phuong thuc tim kiem toa do player.
     */
    public boolean search() {
        while (!Reached && step < 100) {
            int col = current.c;
            int row = current.r;
            current.checked = true;
            openList.remove(current);
            if (row - 1 >= 0) {
                openNode(node[col][row-1]);
            }
            if (col - 1 >= 0) {
                openNode(node[col-1][row]);
            }
            if (row + 1 < 16) {
                openNode(node[col][row+1]);
            }
            if (col + 1 < 16) {
                openNode(node[col+1][row]);
            }
            int bestIndex = 0;
            int bestFCost = 1000;
            for (int i = 0; i < openList.size(); i++) {
                if (openList.get(i).fCost < bestFCost) {
                    bestIndex = i;
                    bestFCost = openList.get(i).fCost;
                } else if (openList.get(i).fCost == bestFCost) {
                    if (openList.get(i).gCost < openList.get(bestIndex).gCost) {
                        bestIndex = i;
                    }
                }
            }
            if (openList.size() == 0) {
                break;
            }
            current = openList.get(bestIndex);
            if (current == goal) {
                Reached = true;
                trackThePath();
            }
            step++;
        }

        return Reached;
    }

    /**
     * Vach duong di cho quai.
     */
    public void openNode(Node node) {
        if (!node.open && !node.checked && !node.solid) {
            node.open = true;
            node.parent = current;
            openList.add(node);
        }
    }

    /**
     * Chay theo con duong da vach ra.
     */
    public void trackThePath() {
        Node current = goal;
        while (current != start) {
            pathList.add(0, current);
            current = current.parent;
        }
    }
}
