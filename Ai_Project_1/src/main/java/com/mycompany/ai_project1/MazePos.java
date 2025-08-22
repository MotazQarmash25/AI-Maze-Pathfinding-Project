package com.mycompany.ai_project1;

public class MazePos {
    int i, j;

    MazePos(int i, int j) {
        this.i = i;
        this.j = j;
    }

    MazePos north() {
        return new MazePos(i-1 , j); 
    }

    MazePos east() {
        return new MazePos(i, j+1 );
    }

    MazePos south() {
        return new MazePos(i+1 , j);  
    }

    
    MazePos west() {
        return new MazePos(i, j-1);
    }

    int getX() {
        return i;  
    }

    int getY() {
        return j; 
    }
}
