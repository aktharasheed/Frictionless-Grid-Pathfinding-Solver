package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PuzzleSolver {
    private char[][] grid;
    private Point start;
    private Point end;

    public PuzzleSolver(String filePath) throws FileNotFoundException {
        parseFile(filePath);
    }

    private void parseFile(String filePath) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            List<char[]> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine().toCharArray());
            }
            grid = lines.toArray(new char[lines.size()][]);

            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[y].length; x++) {
                    if (grid[y][x] == 'S') {
                        start = new Point(x, y);
                    } else if (grid[y][x] == 'F') {
                        end = new Point(x, y);
                    }
                }
            }
        }
    }

    public List<String> solve() {
        Map<Point, Point> path = new HashMap<>();
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        path.put(start, null);

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.equals(end)) {
                return reconstructPath(path);
            }

            for (Point next : getNeighbors(current)) {
                if (!path.containsKey(next)) {
                    path.put(next, current);
                    queue.add(next);
                }
            }
        }
        return new ArrayList<>(); // return empty list if no path found
    }

    private List<String> reconstructPath(Map<Point, Point> path) {
        LinkedList<String> steps = new LinkedList<>();
        for (Point at = end; at != null; at = path.get(at)) {
            if (path.get(at) != null) {
                steps.addFirst(String.format("Move from (%d, %d) to (%d, %d)",
                        path.get(at).y + 1, path.get(at).x + 1, at.y + 1, at.x + 1));
            } else {
                steps.addFirst(String.format("Start at (%d, %d)", at.y + 1, at.x + 1));
            }
        }
        return steps;
    }

    private List<Point> getNeighbors(Point p) {
        List<Point> neighbors = new ArrayList<>();
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up
        for (int[] d : directions) {
            int x = p.x, y = p.y;
            while (canMove(x + d[0], y + d[1])) {
                x += d[0];
                y += d[1];
                if (grid[y][x] == 'F') {
                    neighbors.add(new Point(x, y));
                    break;
                }
            }
            if (x != p.x || y != p.y) {
                neighbors.add(new Point(x, y));
            }
        }
        return neighbors;
    }

    private boolean canMove(int x, int y) {
        return x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && grid[y][x] != '0';
    }
}
