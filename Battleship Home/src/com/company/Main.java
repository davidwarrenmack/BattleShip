package com.company;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main
{

    public static void main(String[] args)
    {
        String rowLetters = "ABCDEFGHIJ";
        char[] charArray = rowLetters.toCharArray();

        char carrierRowChar;
        int carrierSize = 5;
        int carrierRow;
        int carrierCol;
        char carrierDir;
        String carrierPosition;
        String carrierRange = "Sample jargon";

        char batshipRowChar = 'Z';
        int batshipSize = 4;
        int batshipRow = 0;
        int batshipCol = 0;
        char batshipDir = 'D';
        String batshipPosition = "";
        String batshipRange = "";

        System.out.println("Welcome to battleship");
        System.out.println("Please enter your carrier(5) position here: ");
        Scanner scanner = new Scanner(System.in);
        carrierPosition = scanner.next();
        String[] toSplit = carrierPosition.split("(?<=\\D)(?=\\d)");
        carrierRowChar = toSplit[0].toUpperCase().charAt(0);
        carrierCol = Integer.parseInt(toSplit[1]);
        carrierRow = findIndex(charArray, carrierRowChar) + 1;
        System.out.println("Your position is: " + carrierPosition.toUpperCase());
        int whilelooper = 100;
        while (whilelooper == 100) {
            System.out.println("Enter your ships direction here: ");
            carrierDir = scanner.next().toUpperCase().charAt(0);
            switch (carrierDir) {
                case 'N':
                    if ((carrierRow - carrierSize) > 0) {
                        System.out.print("Nice you selected: North\nPosition Validated ");
                        whilelooper = 0;
                        carrierRange = carrierPosition.toUpperCase() + (--carrierRowChar) + (carrierCol) + (--carrierRowChar) + (carrierCol) + (--carrierRowChar) + (carrierCol) + (--carrierRowChar) + (carrierCol);
                        System.out.println(carrierRange);
                    }
                    else {
                        System.out.println("Out of bounds");
                        whilelooper = 100;
                    }
                    break;
                case 'E':
                    if ((carrierCol + carrierSize) <= 11) {
                        System.out.print("Nice you selected: East\nPosition Validated ");
                        whilelooper = 0;
                        carrierRange = carrierPosition.toUpperCase() + carrierRowChar + (carrierCol + 1) + carrierRowChar + (carrierCol + 2) + carrierRowChar + (carrierCol + 3) + carrierRowChar + (carrierCol + 4);
                        System.out.println(carrierRange);
                    }
                    else {
                        System.out.println("Out of bounds");
                        whilelooper = 100;
                    }
                    break;
                case 'S':
                    if ((carrierRow + carrierSize) < 11) {
                        System.out.print("Nice you selected: South\nPosition Validated ");
                        whilelooper = 0;
                        carrierRange = carrierPosition.toUpperCase() + (++carrierRowChar) + (carrierCol) + (++carrierRowChar) + (carrierCol) + (++carrierRowChar) + (carrierCol) + (++carrierRowChar) + (carrierCol);
                        System.out.println(carrierRange);
                    }
                    else {
                        System.out.println("Out of bounds");
                        whilelooper = 100;
                    }
                    break;
                case 'W':
                    if ((carrierCol - carrierSize) > 0) {
                        System.out.print("Nice you selected: West\nPosition Validated");
                        whilelooper = 0;
                        carrierRange = carrierPosition.toUpperCase() + carrierRowChar + (carrierCol - 1) + carrierRowChar + (carrierCol - 2) + carrierRowChar + (carrierCol - 3) + carrierRowChar + (carrierCol - 4);
                        System.out.println(carrierRange);
                    }
                    else {
                        System.out.println("Out of bounds");
                        whilelooper = 100;
                    }
                    break;
                default:
                    System.out.println("invalid direction brah, try again plz");
                    whilelooper = 100;
            }
        }
        System.out.println("Please enter your Battleship(4) position here: ");
        scanner = new Scanner(System.in);
        batshipPosition = scanner.next();
        toSplit = batshipPosition.split("(?<=\\D)(?=\\d)");
        batshipRowChar = toSplit[0].toUpperCase().charAt(0);
        batshipCol = Integer.parseInt(toSplit[1]);
        batshipRow = findIndex(charArray, batshipRowChar) + 1;
        System.out.println("Your position is: " + batshipPosition.toUpperCase());
        if ((carrierRange.contains(batshipPosition.toUpperCase()))) {
            batshipDir = 'P'; //for poop
        }
        else {
            System.out.println("Invalid Move ");
        }
        whilelooper = 100;
        while (whilelooper == 100) {
            if (batshipDir != 'P') {
                System.out.println("Enter your ships direction here: ");
                batshipDir = scanner.next().toUpperCase().charAt(0);
            }
            switch (batshipDir) {
                case 'N':
                    batshipRange = batshipPosition.toUpperCase() + (--batshipRowChar) + (batshipCol) + (--batshipRowChar) + (batshipCol) + (--batshipRowChar) + (batshipCol);
                    System.out.println(batshipRange);
                    batshipRow = findIndex(charArray, batshipRowChar) + 1;
                    if ((batshipRow - batshipSize) > 0) {

                        String caseFourString = "" + batshipRowChar + (batshipCol - 4);
                        String caseThreeString = "" + batshipRowChar + (batshipCol - 3);
                        String caseTwoString = "" + batshipRowChar + (batshipCol - 2);
                        String caseOneString = "" + batshipRowChar + (batshipCol - 1);
                        if (carrierRange.contains(caseFourString)) {
                            System.out.println("Invalid Position at " + caseFourString);
                            carrierSize = 0;
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains(caseThreeString)) {
                            System.out.println("Invalid Position at " + caseThreeString);
                            carrierSize = 0;
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains(caseTwoString)) {
                            System.out.println("Invalid Position at " + caseTwoString);
                            carrierSize = 0;
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains(caseOneString)) {
                            System.out.println("Invalid Position at " + caseOneString);
                            carrierSize = 0;
                            whilelooper = 100;
                        }
                        else {
                            System.out.println("Valid Move");
                            whilelooper = 0;
                        }

                        //todo add a switch statement for a case for each carrier coordinate including a default containing loop value and print statement
                        // from below, continue loops for each ship class and decrease coordinates in switch as ship size shortens

                        System.out.print("Nice you selected: North\nPosition Validated ");
                        whilelooper = 0;

                    }
                    else {
                        System.out.println("Invalid move");
                        whilelooper = 100;
                    }
                    break;
                case 'E':
                    batshipRange = batshipPosition.toUpperCase() + batshipRowChar + (batshipCol + 1) + batshipRowChar + (batshipCol + 2) + batshipRowChar + (batshipCol + 3);
                    System.out.println(batshipRange);
                    if ((batshipCol + batshipSize) <= 11) {
                        System.out.print("Nice you selected: East\nPosition Validated ");
                        whilelooper = 0;
                    }
                    else {
                        System.out.println("Invalid move");
                        whilelooper = 100;
                    }
                    break;
                case 'S':
                    batshipRange = batshipPosition.toUpperCase() + (++batshipRowChar) + (batshipCol) + (++batshipRowChar) + (batshipCol) + (++batshipRowChar) + (batshipCol);
                    System.out.println(batshipRange);
                    if ((batshipRow + batshipSize) < 11) {
                        System.out.print("Nice you selected: South\nPosition Validated ");
                        whilelooper = 0;
                    }
                    else {
                        System.out.println("Invalid move");
                        whilelooper = 100;
                    }
                    break;
                case 'W':
                    batshipRange = batshipPosition.toUpperCase() + batshipRowChar + (batshipCol - 1) + batshipRowChar + (batshipCol - 2) + batshipRowChar + (batshipCol - 3);
                    System.out.println(batshipRange);
                    if ((batshipCol - batshipSize) > 0) {
                        System.out.print("Nice you selected: West\nPosition Validated");
                        whilelooper = 0;
                    }
                    else {
                        System.out.println("Invalid move");
                        whilelooper = 100;
                    }
                    break;
                default:
                    System.out.println("Invalid move");
                    whilelooper = 100;
            }


        }
    }


    public static int findIndex(char arr[], char t)
    {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .findFirst()
                .orElse(-1000);
    }
}
