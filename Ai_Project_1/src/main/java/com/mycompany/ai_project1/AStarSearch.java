
package com.mycompany.ai_project1;

import java.util.*;

class Node implements Comparable<Node> {
    int x, y;
    int gCost, hCost;
    Node parent;

    Node(int x, int y, int gCost, int hCost, Node parent) {
        this.x = x;
        this.y = y;
        this.gCost = gCost;
        this.hCost = hCost;
        this.parent = parent;
    }

    int getFCost() {
        return gCost + hCost;
    }

   @Override
    public int compareTo(Node other) {
        int fComparison = Integer.compare(this.getFCost(), other.getFCost());
        if (fComparison != 0) {
            return fComparison;
        }

        int hComparison = Integer.compare(this.hCost, other.hCost);
        if (hComparison != 0) {
            return hComparison;
        }

       
        return Integer.compare(this.gCost, other.gCost);
    }

    int getHCost() {
return hCost;   
    }
    }


public class AStarSearch {
    private static final int[] dx = {-1, 1, 0, 0}; 
    private static final int[] dy = {0, 0, -1, 1};
   private static int f;
   
    public static List<Node> aStarSearch(int[][] maze, int startX, int startY, List<int[]> goals,int f) 
    {
        PriorityQueue<Node> openList = new PriorityQueue<>();
        boolean[][] closedList = new boolean[maze.length][maze[0].length];
        List<Node> testedNodes = new ArrayList<>(); 
        Node startNode0;
        Node startNode1;
        
if(f==0){
         startNode0 = new Node(startX, startY, 0, calculateManhattanDistance(startX, startY, goals), null);
                 openList.add(startNode0);

}
else 
{
 startNode1 = new Node(startX, startY, 0, calculateEuclideanDistance(startX, startY, goals), null);
        openList.add(startNode1);
}
        while (!openList.isEmpty()) {
            Node currentNode = openList.poll();
            testedNodes.add(currentNode); 

            if (isGoal(currentNode.x, currentNode.y, goals)) {
                printTestedNodes(testedNodes); 

                return reconstructPath(currentNode);
            }

            closedList[currentNode.x][currentNode.y] = true;

            for (int i = 0; i < 4; i++) {                               //(up, down, left, right)
                int newX = currentNode.x + dx[i];
                int newY = currentNode.y + dy[i];

                if (isValid(maze, newX, newY) && !closedList[newX][newY]) {
                    int newGCost = currentNode.gCost + 1;
                    int newHCost = calculateManhattanDistance(newX, newY, goals);
                    int newHCost1 = calculateEuclideanDistance(newX, newY, goals);
                     Node neighbor;
                    if (f==0){
                     neighbor = new Node(newX, newY, newGCost, newHCost, currentNode);
                    }
                    else{
                     neighbor = new Node(newX, newY, newGCost, newHCost1, currentNode);

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
    
    private static List<Node> reconstructPath(Node node) {
        List<Node> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }



    public static void printPathDetails(List<Node> path) {
        System.out.println("Number of steps for A*: " + (path.size() - 1));
        System.out.println("Path for A*: ");
        for (Node node : path) {
            System.out.print("(" + node.x + ", " + node.y + ") ");
        }
        System.out.println();
     
    }

    private static void printTestedNodes(List<Node> testedNodes) {
        System.out.println("Nodes tested by A* algorithm:");
        for (Node node : testedNodes) {
            System.out.print("(" + node.x + ", " + node.y + ") ");
        }
        System.out.println();
    }

}

