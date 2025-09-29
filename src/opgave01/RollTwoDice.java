package examples;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;     //Vi bruger statiske
    static int sum = 0;
    static int gentagelser = 0;
    static int maxSum = 0;
    static int[] faceCounts = new int[6]; //Vis forekomster af slag

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul to terninger.");
        printRules();
        System.out.println();

        playTwoDie();

        System.out.println();
        System.out.println("Tak for at spille!");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul to terninger");
        System.out.println("Spilleren ruller to terninger, så længe man lyster.");
        System.out.println("=====================================================");
    }

    private static void playTwoDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul to terning? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] faces = rollDice();

            // udskriv med for-loop
            System.out.print("Du rullede: ");
            for (int i = 0; i < faces.length; i++) {
                System.out.print(faces[i]);
                if (i < faces.length - 1) {
                    System.out.print(" og ");
                }
            }
            System.out.println("\n");

            updateStatistics(faces, faceCounts);

            System.out.print("Rul to terninger? ('ja/nej') ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] faces = new int[2]; // array med 2 pladser
        for (int i = 0; i < faces.length; i++) {
            faces[i] = (int) (Math.random() * 6) + 1;// slå en terning
        }
        return faces;
    }

    private static void updateStatistics(int[] faces, int[] faceCounts) {
        rollCount += 2;
        sum += faces[0] + faces[1];
        if (faces[0] + faces[1] > maxSum) {
            maxSum = faces[0] + faces[1];
        }
        if (faces[0] == faces[1]) {
            gentagelser++;

        }
        for (int i = 0; i < faces.length; i++) {
            faceCounts[faces[i] - 1]++;
        }


    }


    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("Summen af antal slag: " + sum);
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
        System.out.println("Antal gentagelser af samme terning " + gentagelser);
        System.out.println("Det største antal øjne du slog i ét kast: " + maxSum);
        for (int i = 0; i < faceCounts.length; i++) {
            System.out.print((i + 1) + "'ere " + faceCounts[i] + ";    ");
        }
    }


}