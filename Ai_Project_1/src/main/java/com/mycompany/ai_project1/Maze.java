
package com.mycompany.ai_project1;


import static com.mycompany.ai_project1.AStarSearch.aStarSearch;
import static com.mycompany.ai_project1.AStarSearch.printPathDetails;
import static com.mycompany.ai_project1.BestFirstSearch.bestFirstSearch;
import static com.mycompany.ai_project1.UniformCostSearch.uniformCostSearch;
import static com.mycompany.ai_project1.UniformCostSearch.printPathDetails;

import static com.mycompany.ai_project1.BestFirstSearch.printPathDetails;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
public class Maze extends javax.swing.JFrame {
    private Mode currentMode = Mode.FREE; // Default mode
    
private int[][] reflectedArray;

    final static int X = 1; 
    final static int C = 0; 
    final static int S = 2;  
    final static int E = 8;  
    final static int P=3;
private final List<Point> goals = new ArrayList<>();
int newStartI, newStartJ;
 int newEndI1=-1, newEndJ1=-1;
   
        int newEndI2 = -1, newEndJ2 = -1; 

 
private static int numRows,numCols;
    private static int [][]maze={{0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0}
        
    
    };
      int[][] arr;
    boolean repaint = false;
    int[][] savedMaze = clone();
    
   
    public Maze(int[][] maze, int numRows, int numCols) {
    setTitle("Maze");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.maze = maze; 
    reflectedArray = new int[maze.length][maze[0].length];
    
   
    initComponents();
    addMazePanel(); 
    setSize(1000, 700);
    setLocationRelativeTo(null);
    setVisible(true);
}
private void addMazePanel() {
    
    jPanel1.removeAll();
    
    
    MazePanel mazePanel = new MazePanel(maze);
    jPanel1.setLayout(new java.awt.BorderLayout());
    jPanel1.add(mazePanel, java.awt.BorderLayout.CENTER);
    
    
    jPanel1.revalidate();
    jPanel1.repaint();
}
     @Override
public int[][] clone() {

    if (maze == null) {
        return new int[0][0]; 
    }
    int[][] cloned = new int[maze.length][maze[0].length];
    for (int i = 0; i < maze.length; i++) {
        System.arraycopy(maze[i], 0, cloned[i], 0, maze[i].length);
    }
    return cloned;
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        AManhattenDistanceButton = new javax.swing.JButton();
        BFSManhattenDistanceButton = new javax.swing.JButton();
        UCSButton = new javax.swing.JButton();
        wallButton = new javax.swing.JButton();
        freeButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        goalButton = new javax.swing.JButton();
        ReturnButton = new javax.swing.JButton();
        AEuclideandistanceButton = new javax.swing.JButton();
        BFSEuclideandistanceButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        AManhattenDistanceButton.setText("A* With Manhattan Distance ");
        AManhattenDistanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AManhattenDistanceButtonActionPerformed(evt);
            }
        });

        BFSManhattenDistanceButton.setText("BFS With Manhattan Distance ");
        BFSManhattenDistanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BFSManhattenDistanceButtonActionPerformed(evt);
            }
        });

        UCSButton.setText("UCS");
        UCSButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UCSButtonActionPerformed(evt);
            }
        });

        wallButton.setText("Wall");
        wallButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wallButtonActionPerformed(evt);
            }
        });

        freeButton.setText("Free");
        freeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freeButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        goalButton.setText("Goal");
        goalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goalButtonActionPerformed(evt);
            }
        });

        ReturnButton.setText("Exit");
        ReturnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnButtonActionPerformed(evt);
            }
        });

        AEuclideandistanceButton.setText("A* With Euclidean Distance ");
        AEuclideandistanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AEuclideandistanceButtonActionPerformed(evt);
            }
        });

        BFSEuclideandistanceButton.setText("BFS With Euclidean Distance");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BFSManhattenDistanceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(startButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(freeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AManhattenDistanceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(goalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(wallButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AEuclideandistanceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BFSEuclideandistanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(ClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ReturnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addComponent(UCSButton, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(200, 200, 200))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(goalButton)
                    .addComponent(startButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(freeButton)
                    .addComponent(wallButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AManhattenDistanceButton)
                    .addComponent(AEuclideandistanceButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BFSManhattenDistanceButton)
                    .addComponent(BFSEuclideandistanceButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UCSButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReturnButton)
                    .addComponent(ClearButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(301, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UCSButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UCSButtonActionPerformed
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
        
        System.out.println("Path found for UCS:");
        printPathDetails(path);
    } else {
        System.out.println("No path found for UCS.");
    }
             repaint();
  // TODO add your handling code here:
    }//GEN-LAST:event_UCSButtonActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
    int cellSize = Math.min(jPanel1.getWidth() / maze.length, jPanel1.getHeight() / maze[0].length);
    int yOffset = (jPanel1.getWidth() - maze.length * cellSize) / 2;
    int xOffset = (jPanel1.getHeight() - maze[0].length * cellSize) / 2;

    int i = (evt.getY() - xOffset) / cellSize;
    int j = (evt.getX() - yOffset) / cellSize;

    if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length) {
        return; 
    }

    if (maze[i][j] == S || maze[i][j] == E) {
        return; 
    }
  
    updateStartAndGoalPositions(i, j);

    switch (currentMode) {
        case WALL:
            maze[i][j] = X; 
            reflectedArray[i][j] = X;
            break;
        case FREE:
            maze[i][j] = C; 
            reflectedArray[i][j] = C;
            break;
            
    }

    repaint(); // Repaint to reflect changes
    }//GEN-LAST:event_jPanel1MouseClicked

    private void freeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freeButtonActionPerformed
        currentMode = Mode.FREE;
    }//GEN-LAST:event_freeButtonActionPerformed

    private void wallButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wallButtonActionPerformed
        currentMode = Mode.WALL;
    }//GEN-LAST:event_wallButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        currentMode = Mode.START;
      
    }//GEN-LAST:event_startButtonActionPerformed

    private void goalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goalButtonActionPerformed
        currentMode = Mode.GOAL;
    }//GEN-LAST:event_goalButtonActionPerformed

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
        
        System.out.println("Path found for A* With Manhatten Distance:");
        printPathDetails(path);
    } else {
        System.out.println("No path found for A* With Manhatten Distance.");
    }
       repaint();

    }//GEN-LAST:event_AManhattenDistanceButtonActionPerformed

    private void ReturnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnButtonActionPerformed
InitialFrame f=new InitialFrame();
f.setVisible(true);
                    
                   
                    this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_ReturnButtonActionPerformed

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

    private void BFSManhattenDistanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSManhattenDistanceButtonActionPerformed
maze[newStartI][newStartJ] = 0;
    maze[newEndI1][newEndJ1] = 0;

    if (newEndI2 != -1 && newEndJ2 != -1) {
        maze[newEndI2][newEndJ2] = 0;
    }

    BestFirstSearch b = new BestFirstSearch();
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
                System.out.println("Path found for BFS Manhatten Distance:");

        printPathDetails(path);
    } else {
        System.out.println("No path found for BFS Manhatten Distance:.");
    }
       repaint();

        }//GEN-LAST:event_BFSManhattenDistanceButtonActionPerformed

    private void AEuclideandistanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEuclideandistanceButtonActionPerformed
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
        
        System.out.println("Path found for A* With Euclodian Distance:");
        printPathDetails(path);
    } else {
        System.out.println("No path found for A* With Euclodian Distance:.");
    }
       repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_AEuclideandistanceButtonActionPerformed

    private void BFSEuclideandistanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BFSEuclideandistanceButtonActionPerformed
maze[newStartI][newStartJ] = 0;
    maze[newEndI1][newEndJ1] = 0;

    if (newEndI2 != -1 && newEndJ2 != -1) {
        maze[newEndI2][newEndJ2] = 0;
    }

    BestFirstSearch b = new BestFirstSearch();
    int startX = newStartI, startY = newStartJ;
    List<int[]> goals = new ArrayList<>();
    goals.add(new int[]{newEndI1, newEndJ1}); 
    
    if (newEndI2 != -1 && newEndJ2 != -1) {
        goals.add(new int[]{newEndI2, newEndJ2}); 
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
                System.out.println("Path found for BFS Euclidean Distance:");

        printPathDetails(path);
    } else {
        System.out.println("No path found for BFS Euclidean Distance.");
    }
       repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_BFSEuclideandistanceButtonActionPerformed

    private boolean isValidPosition(int i, int j) {
        return i >= 0 && i < maze.length && j >= 0 && j < maze[i].length;
    }
    
  

    

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
            case P:
            return Color.BLUE;
            default:
                return Color.WHITE;
        }
    }
    
   
private void updateStartAndGoalPositions(int i, int j) {
    switch (currentMode) {
        case START:
            if (maze[i][j] != X && maze[i][j] != E) { 
                if (newStartI != -1 && newStartJ != -1) {
                    maze[newStartI][newStartJ] = C; 
                    reflectedArray[newStartI][newStartJ] = C;
                }

                newStartI = i;
                newStartJ = j;
                maze[i][j] = S; 
                reflectedArray[i][j] = S;
            }
            break;

        case GOAL:
            if (maze[i][j] != S && maze[i][j] != X) { 
                
                if (maze[i][j] == E) {
                   
                    if (i == newEndI1 && j == newEndJ1) {
                        maze[newEndI1][newEndJ1] = C; 
                        reflectedArray[newEndI1][newEndJ1] = C;
                        goals.remove(new Point(newEndI1, newEndJ1));
                        
                        newEndI1 = i;
                        newEndJ1 = j;
                        maze[i][j] = E;
                        reflectedArray[i][j] = E;
                        goals.add(new Point(i, j));
                    } else if (i == newEndI2 && j == newEndJ2) {
                        
                        maze[newEndI2][newEndJ2] = C; 
                        reflectedArray[newEndI2][newEndJ2] = C;
                        goals.remove(new Point(newEndI2, newEndJ2));
                        
                        newEndI2 = i;
                        newEndJ2 = j;
                        maze[i][j] = E;
                        reflectedArray[i][j] = E;
                        goals.add(new Point(i, j));
                    }
                    return;
                }

             
                if (goals.size() == 2) {
                  
                    if (newEndI2 != -1 && newEndJ2 != -1) {
                        maze[newEndI2][newEndJ2] = C; // Clear the previous second goal
                        reflectedArray[newEndI2][newEndJ2] = C;
                        goals.remove(new Point(newEndI2, newEndJ2));
                    }
                    
                    newEndI2 = i;
                    newEndJ2 = j;
                    maze[i][j] = E;
                    reflectedArray[i][j] = E;
                    goals.add(new Point(i, j));
                } else if (goals.size() == 1) {
                   
                    newEndI2 = i;
                    newEndJ2 = j;
                    maze[i][j] = E;
                    reflectedArray[i][j] = E;
                    goals.add(new Point(i, j));
                } else {
                    // Set the first goal
                    newEndI1 = i;
                    newEndJ1 = j;
                    maze[i][j] = E;
                    reflectedArray[i][j] = E;
                    goals.add(new Point(i, j));
                }
            }
            break;
    }
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
            java.util.logging.Logger.getLogger(Maze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maze.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maze(maze, numRows, numCols).setVisible(true);
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
    private javax.swing.JButton freeButton;
    private javax.swing.JButton goalButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton startButton;
    private javax.swing.JButton wallButton;
    // End of variables declaration//GEN-END:variables
}
