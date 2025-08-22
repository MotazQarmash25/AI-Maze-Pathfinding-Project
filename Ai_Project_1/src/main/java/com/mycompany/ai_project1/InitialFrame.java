
package com.mycompany.ai_project1;

import java.awt.Point;
import java.util.Random;


public class InitialFrame extends javax.swing.JFrame {
final static int X = 1;  
    final static int C = 0;  
    final static int S = 2;  
    final static int E = 8;  
    private int[][] maze;
    public InitialFrame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ManualMazeButton = new javax.swing.JButton();
        RandomMazeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ManualMazeButton.setText("Manual Maze Generator");
        ManualMazeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManualMazeButtonActionPerformed(evt);
            }
        });

        RandomMazeButton.setText("Random Maze Generator");
        RandomMazeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RandomMazeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ManualMazeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RandomMazeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(243, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(ManualMazeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RandomMazeButton)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ManualMazeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManualMazeButtonActionPerformed
   String input = javax.swing.JOptionPane.showInputDialog(this, 
        "Enter maze dimensions (rows , columns):", 
        "Manual Maze Generator", 
        javax.swing.JOptionPane.PLAIN_MESSAGE);
    
    if (input != null && !input.trim().isEmpty()) {
        String[] parts = input.split(",");
        
        if (parts.length == 2) {
            try {
                int numRows = Integer.parseInt(parts[0].trim());
                int numCols = Integer.parseInt(parts[1].trim());
                
        
                if (numRows >= 4 && numRows <= 21 && numCols >= 4 && numCols <= 21) {
                   
                    maze = new int[numRows][numCols];
                    
                    for (int i = 0; i < maze.length; i++) {
                        for (int j = 0; j < maze[i].length; j++) {
                            maze[i][j] = C; // Fill with free space
                        }
                    }
                    
                 
                    
                    
                    
                    Maze mazeGenerator = new Maze(maze, numRows, numCols);
                    mazeGenerator.setVisible(true);
                    
                 
                    this.dispose();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, 
                        "Dimensions must be between 4 and 21.", 
                        "Invalid Input", 
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                }
                
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, 
                    "Invalid input. Please enter numbers in the format 'rows , columns'.", 
                    "Invalid Input", 
                    javax.swing.JOptionPane.ERROR_MESSAGE);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, 
                "Please enter dimensions in the format 'rows , columns'.", 
                "Invalid Input", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    } 
    }//GEN-LAST:event_ManualMazeButtonActionPerformed

    private void RandomMazeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RandomMazeButtonActionPerformed
Random rand = new Random();
    
    
     int numRows = 4 + rand.nextInt(18); 
    int numCols = 4 + rand.nextInt(18); 
    maze = new int[numRows][numCols];

    Point start = new Point(rand.nextInt(numRows), rand.nextInt(numCols));

    boolean hasTwoGoals = rand.nextBoolean();

    Point goal1 = null;
    Point goal2 = null;

    do {
        goal1 = new Point(rand.nextInt(numRows), rand.nextInt(numCols));
    } while (goal1.equals(start)); 

  
    if (hasTwoGoals) {
        do {
            goal2 = new Point(rand.nextInt(numRows), rand.nextInt(numCols));
        } while (goal2.equals(start) || goal2.equals(goal1)); 
    }

    for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[i].length; j++) {
            
            if ((i == start.x && j == start.y) || (i == goal1.x && j == goal1.y) || (goal2 != null && i == goal2.x && j == goal2.y)) {
                continue; 
            }
            maze[i][j] = rand.nextInt(2); 
        }
    }

    maze[start.x][start.y] = S; 
    maze[goal1.x][goal1.y] = E; 
    if (goal2 != null) {
        maze[goal2.x][goal2.y] = E; 
    }

    
     MazeRandomGenerator mazeGenerator = new MazeRandomGenerator(maze);
    mazeGenerator.setVisible(true);


    this.dispose();
    }//GEN-LAST:event_RandomMazeButtonActionPerformed

    
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InitialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitialFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InitialFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ManualMazeButton;
    private javax.swing.JButton RandomMazeButton;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
