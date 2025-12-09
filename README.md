# Frictionless-Grid-Pathfinding-Solver

This is a pathfinding solution designed to solve a sliding puzzle on a grid, commonly found in video games.

The puzzle involves moving a piece from a starting point ('S') to a finish point ('F') across a grid containing obstacles. The movement is "frictionless," meaning the piece slides in a chosen direction until it hits an obstacle or the edge of the grid.

How It Works (Algorithms & Tech)
Core Logic: Uses a combination of the Breadth-First Search (BFS) algorithm to guarantee the shortest path (fewest moves) and a modified Dijkstra's Algorithm to guide the search efficiently.
Data Structure: The grid layout is stored and managed using a 2D Character Array.
Path Reconstruction: A Hash Map tracks the predecessor for each step, allowing the program to rebuild and display the optimal sequence of moves once the finish is reached.
Language: Implemented in Java/Python (insert your language here).

Complexity
The algorithm's performance is analyzed with a time complexity of $O(N \cdot M + V \log V)$ and space complexity of $O(N \cdot M)$, where $N \times M$ is the grid size4.
