package opgave02;
/*Spillet Craps
I denne opgave skal der programmeres spillet Craps.
Spillets gang
Spillet består af en række kast med to terninger. Udfaldet af et kast er summen af de to terningers
øjne.
Det første kast kaldes ‘come out roll’. Spilleren vinder med det samme, hvis det første kast er 7
eller 11, og taber med det samme, hvis det første kast er 2, 3 eller 12. Hvis spillerens første kast er/4, 5, 6, 8, 9 eller 10, etableres dette tal som spillerens ‘point’. Spilleren bliver derefter ved med at
kaste, indtil han enten kaster sit ‘point’ igen eller kaster 7. Kaster han 7, har han tabt. Kaster han
sit ’point’, har han vundet*/


import java.util.Scanner;

public class Craps {
    private static int rollCount = 0;
    static int sum = 0;
    private static Scanner scanner = new Scanner(System.in);


    //Jeg har implementeret en løsning for jer, kan I tilføje lidt statistik der holder styr på
    //hvor mange gange man har tabt og vundet og udskrive efter hvert spil?
    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, Craps.");
        printRules();
        System.out.println();
        playCraps();
        System.out.println();
        System.out.println("Tak for at spille!");
        scanner.close();
    }


    private static void playCraps() {
        boolean playAnotherRound = anotherRound();
        while (playAnotherRound) {
            int comeOutRoll = rollDice();
            System.out.println("Du rullede " + comeOutRoll + " på dit come out roll");
            if (comeOutRoll == 7 || comeOutRoll == 11) {
                System.out.println("Tillykke du vandt!");
            } else if (comeOutRoll == 2 || comeOutRoll == 3 || comeOutRoll ==12) {
                System.out.printf("Øv, du tabte");
            } else {
                boolean won = rollForPoints(comeOutRoll);
            }
            playAnotherRound = anotherRound();
        }
    }

    private static boolean rollForPoints(int comeOutRoll) {
        System.out.println("Kaster efter " + comeOutRoll);
        while (true) {
            int roll = rollDice();
            System.out.println("Der blev kastet " + roll);
            if (roll == comeOutRoll) {
                System.out.println("Tillykke du vandt!");
                return true;
            } else if (roll == 7) {
                System.out.println("Øv, du tabte");
                return false;
            }
            System.out.println("Fortsætter med at rulle efter " + comeOutRoll);
        }
    }

    private static boolean anotherRound() {
        System.out.println("Ønsker du at spille en runde Craps (ja/nej)?");
        return scanner.nextLine().toLowerCase().equals("ja");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for Craps");
        System.out.println("Spilleren ruller to terninger");
        System.out.println("Spilleren vinder med det samme, hvis det første kast er 7\n" +
                "eller 11, og taber med det samme, hvis det første kast er 2, 3 eller 12. Hvis spillerens første kast er 4, 5, 6, 8, 9 eller 10, etableres dette tal som spillerens ‘point’. Spilleren bliver derefter ved med at\n" +
                "kaste, indtil han enten kaster sit ‘point’ igen eller kaster 7. Kaster han 7, har han tabt. Kaster han\n" +
                "sit ’point’, har han vundet");
        System.out.println("=====================================================");
    }

//    private static void playTwoDie() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Rul to terning? ('ja/nej') ");
//        String answer = scanner.nextLine();
//        while (!answer.equals("nej")) {
//            int[] faces = rollDice();
//
//            // udskriv med for-loop
//            System.out.print("Du rullede: ");
//            for (int i = 0; i < faces.length; i++) {
//                System.out.print(faces[i]);
//                if (i < faces.length - 1) {
//                    System.out.print(" og ");
//                }
//            }
//            System.out.println("\n");
//
//
//            System.out.print("Rul to terninger? ('ja/nej') ");
//            answer = scanner.nextLine();
//        }
//
//        printStatistics();
//        scanner.close();
//    }

    //I Craps er det kun antallet af øjne man er interesseret i, så rollDice() metoden kan simplificeres.
    public static int rollDice() {
        return ((int) (Math.random() * 6) + 1) + ((int) (Math.random() * 6) + 1);
    }

//    private static int[] rollDice() {
//        int[] faces = new int[2]; // array med 2 pladser
//        for (int i = 0; i < faces.length; i++) {
//            faces[i] = (int) (Math.random() * 6) + 1;// slå en terning
//        }
//
//        int rollSum = faces[0] + faces[1];   // beregn summen EFTER begge terninger er sat
//        sum += rollSum;                      // hvis du ønsker sum som total over hele spillet
//        System.out.println("Summen af dit slag: " + rollSum);
//
//        return faces;
//    }


    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
    }


    // Roll the 2 dice until point or 7 is rolled.
    // Return true, if point is rolled.
    /*public static boolean rollforPoint(int point) {
        if (rollSum == 7 || rollSum == 11) {
            System.out.println
            else if (rollSum == 2 || rollSum == 3 || rollSum == 12) {
                System.out.println
            } else () {
                System.out.println("Du skal slå igen,
            }
        }

        return false;*/
}

