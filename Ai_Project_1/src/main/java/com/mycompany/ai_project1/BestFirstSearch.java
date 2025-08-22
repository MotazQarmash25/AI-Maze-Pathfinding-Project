
package com.mycompany.ai_project1;

import java.util.*;


class Node1 implements Comparable<Node1> {
    int x, y;
    int hCost; // Only hCost is needed for Best-First Search
    Node1 parent;

    Node1(int x, int y, int hCost, Node1 parent) {
        this.x = x;
        this.y = y;
        this.hCost = hCost;
        this.parent = parent;
    }

    @Override
    public int compareTo(Node1 other) {
        return Integer.compare(this.hCost, other.hCost);
    }
}

public class BestFirstSearch {
    private static final int[] dx = {-1, 1, 0, 0}; 
    private static final int[] dy = {0, 0, -1, 1};
      private static int f;

    public static List<Node1> bestFirstSearch(int[][] maze, int startX, int startY, List<int[]> goals,int f) {
       
        PriorityQueue<Node1> openList = new PriorityQueue<>();
        boolean[][] closedList = new boolean[maze.length][maze[0].length];
        List<Node1> testedNodes = new ArrayList<>(); // List to track tested nodes
Node1 startNode;
Node1 startNode1;
if(f==0){
         startNode = new Node1(startX, startY, calculateManhattanDistance(startX, startY, goals), null);
                 openList.add(startNode);

}
else if(f==1){
startNode1 = new Node1(startX, startY,  calculateEuclideanDistance(startX, startY, goals), null);
        openList.add(startNode1);

}

        while (!openList.isEmpty()) {
            Node1 currentNode = openList.poll();
            testedNodes.add(currentNode); 

            if (isGoal(currentNode.x, currentNode.y, goals)) {
                printTestedNodes(testedNodes);
                return reconstructPath(currentNode);
            }

            closedList[currentNode.x][currentNode.y] = true;

            for (int i = 0; i < 4; i++) {
                int newX = currentNode.x + dx[i];
                int newY = currentNode.y + dy[i];

                if (isValid(maze, newX, newY) && !closedList[newX][newY]) {
                    int newHCost = calculateManhattanDistance(newX, newY, goals);
                    int newHCost1 = calculateEuclideanDistance(newX, newY, goals);
                                        Node1 neighbor ;
if(f==0){
                     neighbor = new Node1(newX, newY, newHCost, currentNode);
}
else{
                         neighbor = new Node1(newX, newY, newHCost1, currentNode);

}
                    openList.add(neighbor);
                }
            }
        }
        printTestedNodes(testedNodes); 
        return null; 
    }

    private static boolean isValid(int[][] maze, int x, int y) {
        return x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0;
    }

    private static boolean isGoal(int x, int y, List<int[]> goals) {
        for (int[] goal : goals) {
            if (goal[0] == x && goal[1] == y) {
                return true;
            }
        }
        return false;
    }

    private static int calculateManhattanDistance(int x, int y, List<int[]> goals) {
        int minDistance = Integer.MAX_VALUE;
        for (int[] goal : goals) {
            int distance = Math.abs(x - goal[0]) + Math.abs(y - goal[1]);
            minDistance = Math.min(minDistance, distance);
        }
        return minDistance;
    }
private static int calculateEuclideanDistance(int x, int y, List<int[]> goals) {
        double minDistance = Double.MAX_VALUE;
        for (int[] goal : goals) {
            double distance = Math.sqrt(Math.pow(x - goal[0], 2) + Math.pow(y - goal[1], 2));
            minDistance = Math.min(minDistance, distance);
        }
        return (int) minDistance;
}
    private static List<Node1> reconstructPath(Node1 node) {
        List<Node1> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void printPathDetails(List<Node1> path) {
        System.out.println("Number of steps for BFS: " + (path.size() - 1));
        System.out.println("Path for BFS: ");
        for (Node1 node : path) {
            System.out.print("(" + node.x + ", " + node.y + ") ");
        }
        System.out.println();
    }

    private static void printTestedNodes(List<Node1> testedNodes) {
        System.out.println("Nodes tested by BFS algorithm:");
        for (Node1 node : testedNodes) {
            System.out.print("(" + node.x + ", " + node.y + ") ");
        }
        System.out.println();
    }

  
}

