# 🧩 AI Maze Pathfinding Project

## 📌 Overview
This project is a **Java Swing GUI application** that demonstrates how different **AI pathfinding algorithms** work in a maze environment.  
The application visualizes **search algorithms** step by step, showing how they explore the maze and eventually find (or fail to find) a path.

It is designed for **educational purposes** to help students and developers understand:
- How **A***, **Best-First Search**, and **Uniform Cost Search (UCS)** operate.
- The effect of different **heuristics** (Manhattan vs Euclidean).
- How paths are reconstructed and displayed both in the GUI and console.

---

## 🚀 Features
- **Maze visualization** with walls, start point, and one or multiple goals.
- **Algorithms supported**:
  - A* Search (Manhattan & Euclidean heuristics).
  - Best-First Search (Manhattan & Euclidean heuristics).
  - Uniform Cost Search (UCS).
- **Dynamic maze updates** (paths highlighted in GUI).
- **Console output** includes:
  - Number of steps.
  - Full path coordinates.
  - Nodes visited (for UCS).

---

## 📂 Project Structure

```
com.mycompany.ai_project1/
│
├── MazeRandomGenerator.java      # Main GUI window with buttons to run algorithms
├── UniformCostSearch.java        # UCS algorithm implementation
├── AStarSearch.java              # A* Search algorithm (with heuristics)
├── BestFirstSearch.java          # Best-First Search algorithm
├── Maze.java                     # Maze representation (grid, constants)
├── InitialFrame.java             # Startup frame/menu
├── Node.java                     # Node class for A* (x,y, costs, parent)
├── Node1.java                    # Node class for Best-First Search
├── Node2.java                    # Node class for UCS
└── MazePanel.java                # Swing panel that draws the maze
```

---

## 🧑‍💻 Class Responsibilities

### 🔹 `MazeRandomGenerator`
- Handles GUI layout (buttons, panels).
- Initializes the maze grid and identifies start (`S`) and goal(s) (`E`).
- Provides buttons for running:
  - A* (Manhattan & Euclidean).
  - Best-First Search (Manhattan & Euclidean).
  - UCS.
- Displays paths in the GUI by coloring the grid.

### 🔹 `UniformCostSearch`
- Implements UCS using a **priority queue** ordered by cost.
- Explores nodes until a goal is reached.
- Reconstructs the path using parent pointers.
- Prints tested nodes and final path.

### 🔹 `AStarSearch`
- Implements A* algorithm.
- Supports two heuristics:
  - Manhattan distance.
  - Euclidean distance.
- Returns the path from start to goal if found.

### 🔹 `BestFirstSearch`
- Greedy search that selects nodes based on heuristic value.
- Supports Manhattan and Euclidean distance heuristics.

### 🔹 `Maze`
- Defines the maze grid.
- Constants:
  - `X` → Wall
  - `C` → Empty Cell
  - `S` → Start
  - `E` → End/Goal
  - `P` → Path

### 🔹 `InitialFrame`
- Entry point window with navigation to the main maze generator.

### 🔹 `Node`, `Node1`, `Node2`
- Helper classes representing maze nodes for different algorithms.
- Store coordinates, costs, and parent references for path reconstruction.

---

## ▶️ How to Run

### 1. Clone the Repository


### 2. Open in an IDE
- Open the project in **NetBeans**, **IntelliJ IDEA**, or **Eclipse**.
- Make sure you are using **Java 8+**.

### 3. Run the Main Class
Run:
```java
MazeRandomGenerator.java
```

### 4. Use the GUI
- **Select algorithm**: A*, Best-First, or UCS.
- **Choose heuristic**: Manhattan or Euclidean (for A* and Best-First).
- **View results**:
  - Path shown in GUI.
  - Detailed path and nodes printed in console.

---


## ✅ Example Console Output

```
The maze contains 1 goal(s).
Path found for A* Manhattan Distance:
Number of steps: 12
Path: (0,0) (1,0) (2,0) ... (5,5)

Nodes tested by UCS algorithm:
(0,0) (1,0) (2,0) ...
```

---

## 🛠️ Technologies Used
- **Java (Swing GUI)**  
- **PriorityQueue** for UCS.  
- **Object-Oriented Programming (OOP)** principles.  

---

## 📜 License
This project is for **educational purposes**.  
You are free to use and modify it.
