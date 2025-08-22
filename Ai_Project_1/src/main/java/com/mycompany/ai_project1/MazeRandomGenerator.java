/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ai_project1;

import static com.mycompany.ai_project1.AStarSearch.aStarSearch;
import static com.mycompany.ai_project1.AStarSearch.printPathDetails;
import static com.mycompany.ai_project1.BestFirstSearch.bestFirstSearch;
import static com.mycompany.ai_project1.BestFirstSearch.printPathDetails;
import static com.mycompany.ai_project1.UniformCostSearch.uniformCostSearch;
import static com.mycompany.ai_project1.UniformCostSearch.printPathDetails;
import static com.mycompany.ai_project1.Maze.C;
import static com.mycompany.ai_project1.Maze.E;
import static com.mycompany.ai_project1.Maze.P;
import static com.mycompany.ai_project1.Maze.S;
import static com.mycompany.ai_project1.Maze.X;
import static com.mycompany.ai_project1.UniformCostSearch.printPathDetails;
import static com.mycompany.ai_project1.UniformCostSearch.uniformCostSearch;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;


public class MazeRandomGenerator extends javax.swing.JFrame {
    final static int X = 1;  
    final static int C = 0;  
    final static int S = 2;  
    final static int E = 8; 
    int newStartI, newStartJ;
 int newEndI1=-1, newEndJ1=-1;
   
        int newEndI2 = -1, newEndJ2 = -1; 


    private static int [][]maze;
   public MazeRandomGenerator(int[][] maze) {
    this.maze = maze;
    int goalCount = 0;  
    for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[0].length; j++) {
            if (maze[i][j] == S) {
               newStartI = i;
                newStartJ = j;
            } else if (maze[i][j] == E) {
                goalCount++;
                if (goalCount == 1) {
                    newEndI1 = i;
                    newEndJ1 = j;
                } else if (goalCount == 2) {
                   newEndI2 = i;
                    newEndJ2 = j;
                }
            }
        }
    }

    
    if (goalCount == 1) {
        newEndI2 = -1;
        newEndJ2 = -1;
    }

    System.out.println("The maze contains " + goalCount + " goal(s).");

    initComponents();
    addMazePanel();  
}

private void addMazePanel() {
    
    jPanel1.removeAll();
    
    
    MazePanel mazePanel = new MazePanel(maze);
    jPanel1.setLayout(new java.awt.BorderLayout());
    jPanel1.add(mazePanel, java.awt.BorderLayout.CENTER);
    
 
    jPanel1.revalidate();
    jPanel1.repaint();
}
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        AManhattenDistanceButton = new javax.swing.JButton();
        UCSButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();
        BFSManhattenDistanceButton = new javax.swing.JButton();
        AEuclideandistanceButton = new javax.swing.JButton();
        BFSEuclideandistanceButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 349, Short.MAX_VALUE)
        );

        AManhattenDistanceButton.setText("A* with Manhattan Distance ");
        AManhattenDistanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AManhattenDistanceButtonActionPerformed(evt);
            }
        });

        UCSButton.setText("UCS");
        UCSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UCSButtonActionPerformed(evt);
            }
        });

        ReturnButton.setText("Exit");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        BFSManhattenDistanceButton.setText("BFS with Manhattan  Distance");
        BFSManhattenDistanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSManhattenDistanceButtonActionPerformed(evt);
            }
        });

        AEuclideandistanceButton.setText("A* with Euclidean Distance");
        AEuclideandistanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AEuclideandistanceButtonActionPerformed(evt);
            }
        });

        BFSEuclideandistanceButton.setText("BFS with Euclidean Distance");
        BFSEuclideandistanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSEuclideandistanceButtonActionPerformed(evt);
            }
        });

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BFSManhattenDistanceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AManhattenDistanceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UCSButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AEuclideandistanceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BFSEuclideandistanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(ClearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AManhattenDistanceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AEuclideandistanceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BFSManhattenDistanceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BFSEuclideandistanceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UCSButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ReturnButton)
                    .addComponent(ClearButton))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AManhattenDistanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AManhattenDistanceButtonActionPerformed
maze[newStartI][newStartJ] = 0;
    maze[newEndI1][newEndJ1] = 0;
    
    if (newEndI2 != -1 && newEndJ2 != -1) {
        maze[newEndI2][newEndJ2] = 0;
    }

    AStarSearch A = new AStarSearch();
    int startX = newStartI, startY = newStartJ;
    List<int[]> goals = new ArrayList<>();
    goals.add(new int[]{newEndI1, newEndJ1}); 
    
    if (newEndI2 != -1 && newEndJ2 != -1) {
        goals.add(new int[]{newEndI2, newEndJ2});
    }

    List<Node> path = aStarSearch(maze, startX, startY, goals,0);
    maze[newStartI][newStartJ] = S;
    maze[newEndI1][newEndJ1] = E;

    if (newEndI2 != -1 && newEndJ2 != -1) {
        maze[newEndI2][newEndJ2] = E;
    }

    if (path != null) {
       for (Node node : path) {
            maze[node.x][node.y] = P;
        }
        maze[newStartI][newStartJ] = S;
        maze[newEndI1][newEndJ1] = E;

        if (newEndI2 != -1 && newEndJ2 != -1) {
            maze[newEndI2][newEndJ2] = E;
        }
        
        System.out.println("Path found for A* Manhatten Distance:");
        printPathDetails(path);
    } else {
        System.out.println("No path found for A* Manhatten Distance.");
    }
       repaint();

    }//GEN-LAST:event_AManhattenDistanceButtonActionPerformed

    private void UCSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UCSButtonActionPerformed
maze[newStartI][newStartJ] = 0;
    maze[newEndI1][newEndJ1] = 0;
    
    if (newEndI2 != -1 && newEndJ2 != -1) {
        maze[newEndI2][newEndJ2] = 0;
    }

    UniformCostSearch A = new UniformCostSearch();
    int startX = newStartI, startY = newStartJ;
    List<int[]> goals = new ArrayList<>();
    goals.add(new int[]{newEndI1, newEndJ1}); // Goal 1
    
    if (newEndI2 != -1 && newEndJ2 != -1) {
        goals.add(new int[]{newEndI2, newEndJ2}); // Goal 2
    }

    List<Node2> path = uniformCostSearch(maze, startX, startY, goals);
    maze[newStartI][newStartJ] = S;
    maze[newEndI1][newEndJ1] = E;

    if (newEndI2 != -1 && newEndJ2 != -1) {
        maze[newEndI2][newEndJ2] = E;
    }

    if (path != null) {
        for (Node2 node : path) {
            maze[node.x][node.y] = P;
        }
        maze[newStartI][newStartJ] = S;
        maze[newEndI1][newEndJ1] = E;

        if (newEndI2 != -1 && newEndJ2 != -1) {
            maze[newEndI2][newEndJ2] = E;
        }
        
        System.out.println("Path found for UCS: ");
        printPathDetails(path);
    } else {
        System.out.println("No path found for UCS.");
    }
             repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_UCSButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
        InitialFrame f=new InitialFrame();
        f.setVisible(true);

        // Close the InitialFrame
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_ReturnButtonActionPerformed

    private void BFSManhattenDistanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSManhattenDistanceButtonActionPerformed
        maze[newStartI][newStartJ] = 0;
        maze[newEndI1][newEndJ1] = 0;

        if (newEndI2 != -1 && newEndJ2 != -1) {
            maze[newEndI2][newEndJ2] = 0;
        }

        int startX = newStartI, startY = newStartJ;
        List<int[]> goals = new ArrayList<>();
        goals.add(new int[]{newEndI1, newEndJ1}); 

        if (newEndI2 != -1 && newEndJ2 != -1) {
            goals.add(new int[]{newEndI2, newEndJ2}); 
        }

        List<Node1> path = bestFirstSearch(maze, startX, startY, goals,0);

        maze[newStartI][newStartJ] = S;
        maze[newEndI1][newEndJ1] = E;

        if (newEndI2 != -1 && newEndJ2 != -1) {
            maze[newEndI2][newEndJ2] = E;
        }

        if (path != null) {
            for (Node1 node : path) {
                maze[node.x][node.y] = P;
            }
            maze[newStartI][newStartJ] = S;
            maze[newEndI1][newEndJ1] = E;

            if (newEndI2 != -1 && newEndJ2 != -1) {
                maze[newEndI2][newEndJ2] = E;
            }
            System.out.println("Path found for BFS Manhatten Distance :");

            printPathDetails(path);
        } else {
            System.out.println("No path found for BFSManhattenDistance.");
        }
        repaint();
    }//GEN-LAST:event_BFSManhattenDistanceButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                
                if (maze[i][j] == 3) {
                    maze[i][j] = 0; 
                }
            }
        }
        repaint();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void AEuclideandistanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEuclideandistanceButtonActionPerformed
   maze[newStartI][newStartJ] = 0;
        maze[newEndI1][newEndJ1] = 0;

        if (newEndI2 != -1 && newEndJ2 != -1) {
            maze[newEndI2][newEndJ2] = 0;
        }

        int startX = newStartI, startY = newStartJ;
        List<int[]> goals = new ArrayList<>();
        goals.add(new int[]{newEndI1, newEndJ1}); 

        if (newEndI2 != -1 && newEndJ2 != -1) {
            goals.add(new int[]{newEndI2, newEndJ2}); 
        }

        List<Node> path = aStarSearch(maze, startX, startY, goals,1);

        maze[newStartI][newStartJ] = S;
        maze[newEndI1][newEndJ1] = E;

        if (newEndI2 != -1 && newEndJ2 != -1) {
            maze[newEndI2][newEndJ2] = E;
        }

        if (path != null) {
            for (Node node : path) {
                maze[node.x][node.y] = P;
            }
            maze[newStartI][newStartJ] = S;
            maze[newEndI1][newEndJ1] = E;

            if (newEndI2 != -1 && newEndJ2 != -1) {
                maze[newEndI2][newEndJ2] = E;
            }
            System.out.println("Path found for A* Euclodian Distance:");

            printPathDetails(path);
        } else {
            System.out.println("No path found for A* Euclodian Distance.");
        }
        repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_AEuclideandistanceButtonActionPerformed

    private void BFSEuclideandistanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSEuclideandistanceButtonActionPerformed
   maze[newStartI][newStartJ] = 0;
        maze[newEndI1][newEndJ1] = 0;

        if (newEndI2 != -1 && newEndJ2 != -1) {
            maze[newEndI2][newEndJ2] = 0;
        }

        int startX = newStartI, startY = newStartJ;
        List<int[]> goals = new ArrayList<>();
        goals.add(new int[]{newEndI1, newEndJ1}); // Goal 1

        if (newEndI2 != -1 && newEndJ2 != -1) {
            goals.add(new int[]{newEndI2, newEndJ2}); // Goal 2
        }

        List<Node1> path = bestFirstSearch(maze, startX, startY, goals,1);

        maze[newStartI][newStartJ] = S;
        maze[newEndI1][newEndJ1] = E;

        if (newEndI2 != -1 && newEndJ2 != -1) {
            maze[newEndI2][newEndJ2] = E;
        }

        if (path != null) {
            for (Node1 node : path) {
                maze[node.x][node.y] = P;
            }
            maze[newStartI][newStartJ] = S;
            maze[newEndI1][newEndJ1] = E;

            if (newEndI2 != -1 && newEndJ2 != -1) {
                maze[newEndI2][newEndJ2] = E;
            }
            System.out.println("Path found for BFS Euclidean distance:");

            printPathDetails(path);
        } else {
            System.out.println("No path found for BFS Euclidean distance.");
        }
        repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_BFSEuclideandistanceButtonActionPerformed
    private Color getColor(int value) {
        switch (value) {
            case X:
                return Color.BLACK;
            case C:
                return Color.WHITE;
            case S:
                return Color.RED;
            case E:
                return Color.GREEN;
            default:
                return Color.WHITE;
        }
    }
    private int countGoals() {
    int goalCount = 0;
    for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[i].length; j++) {
            if (maze[i][j] == E) {
                goalCount++;
            }
        }
    }
    return goalCount;
}


  
  


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MazeRandomGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MazeRandomGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MazeRandomGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MazeRandomGenerator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MazeRandomGenerator(maze).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AEuclideandistanceButton;
    private javax.swing.JButton AManhattenDistanceButton;
    private javax.swing.JButton BFSEuclideandistanceButton;
    private javax.swing.JButton BFSManhattenDistanceButton;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton ReturnButton;
    private javax.swing.JButton UCSButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
