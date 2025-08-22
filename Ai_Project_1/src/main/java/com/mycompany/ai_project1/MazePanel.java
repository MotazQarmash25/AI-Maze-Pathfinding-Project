
package com.mycompany.ai_project1;

import java.awt.Color;
import java.awt.Graphics;


public class MazePanel extends javax.swing.JPanel {
 final static int X = 1;  
    final static int C = 0;  
    final static int S = 2;  
    final static int E = 8;  
    final static int P=3;
     private int[][] maze;
    private int cellSize = 30;
    public MazePanel(int[][] maze) {
        this.maze = maze;
        setPreferredSize(new java.awt.Dimension(maze[0].length * cellSize, maze.length * cellSize));
    }
    
  protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int rows = maze.length;
        int cols = maze[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Color color;
                switch (maze[i][j]) {
                    case X:
                        color = Color.BLACK;
                        break;
                    case S:
                        color = Color.RED;
                        break;
                    case E:
                        color = Color.GREEN;
                        break;
                    case P:
                        color=Color.BLUE;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.BLACK);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
