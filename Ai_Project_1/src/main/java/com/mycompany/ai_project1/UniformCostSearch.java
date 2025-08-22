/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ai_project1;
import java.util.*;


class Node2 implements Comparable<Node2> {
    int x, y;
    int gCost; 
    Node2 parent;

    Node2(int x, int y, int gCost, Node2 parent) {
        this.x = x;
        this.y = y;
        this.gCost = gCost;
        this.parent = parent;
    }

    @Override
    public int compareTo(Node2 other) {
       
        return Integer.compare(this.gCost, other.gCost);
    }
}

public class UniformCostSearch {
    private static final int[] dx = {-1, 1, 0, 0}; 
    private static final int[] dy = {0, 0, -1, 1};

    public static List<Node2> uniformCostSearch(int[][] maze, int startX, int startY, List<int[]> goals) {
        PriorityQueue<Node2> openList = new PriorityQueue<>();
        boolean[][] closedList = new boolean[maze.length][maze[0].length];
        List<Node2> testedNodes = new ArrayList<>(); 

        Node2 startNode = new Node2(startX, startY, 0, null);
        openList.add(startNode);

        while (!openList.isEmpty()) {
            Node2 currentNode = openList.poll();
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
                    int newGCost = currentNode.gCost + 1;
                    Node2 neighbor = new Node2(newX, newY, newGCost, currentNode);

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

    private static List<Node2> reconstructPath(Node2 node) {
        List<Node2> path = new ArrayList<>();
        while (node != null) {
            path.add(node);
            node = node.parent;
        }
        Collections.reverse(path);
        return path;
    }

    public static void printPathDetails(List<Node2> path) {
        System.out.println("Number of steps for UCS: " + (path.size() - 1));
        System.out.println("Path for UCS: ");
        for (Node2 node : path) {
            System.out.print("(" + node.x + ", " + node.y + ") ");
        }
        System.out.println();
    }

    private static void printTestedNodes(List<Node2> testedNodes) {
        System.out.println("Nodes tested by UCS algorithm:");
        for (Node2 node : testedNodes) {
            System.out.print("(" + node.x + ", " + node.y + ") ");
        }
        System.out.println();
    }

}

