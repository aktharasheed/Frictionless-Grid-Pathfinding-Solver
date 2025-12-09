package com.company;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the Sliding Puzzle Solver");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to the puzzle file:");
        String path = scanner.nextLine(); // User specifies the file path
        try {
            PuzzleSolver solver = new PuzzleSolver(path);
            List<String> solutionSteps = solver.solve();
            if (solutionSteps.isEmpty()) {
                System.out.println("No path found from start to finish.");
            } else {
                int stepNum = 1;
                for (String step : solutionSteps) {
                    System.out.println(stepNum + ". " + step);
                    stepNum++;
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
