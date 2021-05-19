/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.

Example

For

grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
the output should be
sudoku2(grid) = true;

For

grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
the output should be
sudoku2(grid) = false.

The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.

Input/Output

[execution time limit] 3 seconds (java)

[input] array.array.char grid

A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.

[output] boolean

Return true if grid represents a valid Sudoku puzzle, otherwise return false
*/

boolean sudoku2(char[][] grid) {
    //Rows
    for(int x=0; x<9; x++){
        HashSet set = new HashSet<>();
        for(int y=0; y<9; y++){
            if(grid[x][y]!='.'){
              if(!set.add(grid[x][y])) return false;
            }
        }
    }
    
    //Columns
    for(int y=0; y<9; y++){
        HashSet set = new HashSet<>();
        for(int x=0; x<9; x++){
            if(grid[x][y]!='.'){
              if(!set.add(grid[x][y])) return false;
            }
        }
    }
    
    //3x3
    int row = 0;
    int col = 0;
    for(int z=0; z<9; z++){
        HashSet set = new HashSet<>();
        for(int x=row; x<row+3; x++){
            for(int y=col; y<col+3; y++){
                if(grid[x][y]!='.'){
                    if(!set.add(grid[x][y])) return false;
                }
            }
        }
        row+=3;
        if(row>8){
            col+=3;
            row=0;
        }
        
    }
    
    return true;
}
