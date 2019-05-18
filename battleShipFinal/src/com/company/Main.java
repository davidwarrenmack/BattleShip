package com.company;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main
{
    public static void main(String[] args)
    {
        String rowLetters = "ABCDEFGHIJ";
        char[] charArray = rowLetters.toCharArray();
        String caseFourString;
        String caseThreeString;
        String caseTwoString;
        String caseOneString;
        String[] toSplit;

        char carrierRowChar = 'Z';
        int carrierSize = 5;
        int carrierRow = 1000;
        int carrierCol = 1000;
        char carrierDir;
        String carrierPosition = "";
        String carrierRange = "";

        char batshipRowChar;
        int batshipSize = 4;
        int batshipRow;
        int batshipCol;
        char batshipDir;
        String batshipPosition = "";
        String batshipRange = "";

        char cruRowChar;
        int cruSize = 3;
        int cruRow;
        int cruCol;
        char cruDir;
        String cruPosition = "";
        String cruRange = "";

        char subRowChar;
        int subSize = 3;
        int subRow;
        int subCol;
        char subDir;
        String subPosition = "";
        String subRange = "";

        char destRowChar;
        int destSize = 2;
        int destRow;
        int destCol;
        char destDir;
        String destPosition = "";
        String destRange = "";

        System.out.println("\n\n\n\n\n\n\n\n\nWelcome to... \n\n\n\n\n\t\t\t***-----** B A T T L E S H I P *" +
                "*-----***  \n\n\n\n");
        Scanner scanner = new Scanner(System.in);
        int whilelooper = 100;
        while (whilelooper == 100)
        {
            System.out.print("Please enter your carrier(5) position here: ");
            carrierPosition = scanner.next();
            toSplit = carrierPosition.split("(?<=\\D)(?=\\d)");
            carrierRowChar = toSplit[0].toUpperCase().charAt(0);
            carrierCol = Integer.parseInt(toSplit[1]);
            carrierRow = findIndex(charArray, carrierRowChar) + 1;
            if ((carrierRow >= 0 && carrierRow < 11) && (carrierCol > 0 && carrierCol < 11))
            {
                System.out.println("You entered: " + carrierPosition.toUpperCase());
                whilelooper = 0;

            }
            else
            {
                System.out.println("That is not a valid board position, try again");
                whilelooper = 100;
            }
        }
        whilelooper = 100;
        while (whilelooper == 100)
        {
            System.out.println("\t(N)orth\t(S)outh\t(E)ast\t(W)est\n");
            System.out.print("Enter your carriers bearings(direction) here: ");
            carrierDir = scanner.next().toUpperCase().charAt(0);
            switch (carrierDir)
            {
                case 'N':
                    if ((carrierRow - carrierSize) >= 0)
                    {
                        System.out.println("Nice you selected: North");
                        whilelooper = 0;
                        carrierRange = carrierPosition.toUpperCase()
                                + (--carrierRowChar) + (carrierCol)
                                + (--carrierRowChar) + (carrierCol)
                                + (--carrierRowChar) + (carrierCol)
                                + (--carrierRowChar) + (carrierCol);
                    }
                    else
                    {
                        System.out.println("Out of bounds");
                        whilelooper = 100;
                    }
                    break;
                case 'E':
                    if ((carrierCol + carrierSize) <= 11)
                    {
                        System.out.println("Nice you selected: East");
                        whilelooper = 0;
                        carrierRange = carrierPosition.toUpperCase()
                                + carrierRowChar + (carrierCol + 1)
                                + carrierRowChar + (carrierCol + 2)
                                + carrierRowChar + (carrierCol + 3)
                                + carrierRowChar + (carrierCol + 4);
                    }
                    else
                    {
                        System.out.println("Out of bounds");
                        whilelooper = 100;
                    }
                    break;
                case 'S':
                    if ((carrierRow + carrierSize) < 11)
                    {
                        System.out.println("Nice you selected: South");
                        whilelooper = 0;
                        carrierRange = carrierPosition.toUpperCase()
                                + (++carrierRowChar) + (carrierCol)
                                + (++carrierRowChar) + (carrierCol)
                                + (++carrierRowChar) + (carrierCol)
                                + (++carrierRowChar) + (carrierCol);
                    }
                    else
                    {
                        System.out.println("Out of bounds");
                        whilelooper = 100;
                    }
                    break;
                case 'W':
                    if ((carrierCol - carrierSize) > 0)
                    {
                        System.out.println("Nice you selected: West");
                        whilelooper = 0;
                        carrierRange = carrierPosition.toUpperCase()
                                + carrierRowChar + (carrierCol - 1)
                                + carrierRowChar + (carrierCol - 2)
                                + carrierRowChar + (carrierCol - 3)
                                + carrierRowChar + (carrierCol - 4);
                    }
                    else
                    {
                        System.out.println("Out of bounds");
                        whilelooper = 100;
                    }
                    break;
                default:
                    System.out.println("I'm sorry that is not a valid direction, try again please");
                    whilelooper = 100;
            }
        }
        while (whilelooper == 0)
        {
            System.out.print("Please enter your Battleship(4) position here: ");
            scanner = new Scanner(System.in);
            batshipPosition = scanner.next();
            System.out.println("You entered: " + batshipPosition.toUpperCase());
            if ((carrierRange.contains(batshipPosition.toUpperCase())))
            {
                System.out.println("Invalid move, Carrier already exists there!");
                whilelooper = 0;
            }
            else
            {
                whilelooper = 100;
            }
        }
        while (whilelooper == 100)
        {
            toSplit = batshipPosition.split("(?<=\\D)(?=\\d)");
            batshipRowChar = toSplit[0].toUpperCase().charAt(0);
            batshipCol = Integer.parseInt(toSplit[1]);
            batshipRow = findIndex(charArray, batshipRowChar) + 1;
            System.out.print("Enter your Battleships bearings(direction) here: ");
            batshipDir = scanner.next().toUpperCase().charAt(0);
            switch (batshipDir)
            {
                case 'N':
                    batshipRange = batshipPosition.toUpperCase()
                            + (--batshipRowChar) + (batshipCol)
                            + (--batshipRowChar) + (batshipCol)
                            + (--batshipRowChar) + (batshipCol);
                    batshipRowChar = toSplit[0].toUpperCase().charAt(0);
                    if ((batshipRow - batshipSize) >= 0)
                    {
                        caseFourString = "" + (batshipRowChar--) + (batshipCol);
                        caseThreeString = "" + (batshipRowChar--) + (batshipCol);
                        caseTwoString = "" + (batshipRowChar--) + (batshipCol);
                        caseOneString = "" + (batshipRowChar) + (batshipCol);
                        if (carrierRange.contains("" + caseFourString))
                        {
                            System.out.println("collision at " + caseFourString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: North");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                case 'E':
                    batshipRange = batshipPosition.toUpperCase()
                            + batshipRowChar + (batshipCol + 1)
                            + batshipRowChar + (batshipCol + 2)
                            + batshipRowChar + (batshipCol + 3);
                    batshipCol = Integer.parseInt(toSplit[1]);
                    if ((batshipCol + batshipSize) < 11)
                    {
                        caseFourString = "" + (batshipRowChar) + (batshipCol++);
                        caseThreeString = "" + (batshipRowChar) + (batshipCol++);
                        caseTwoString = "" + (batshipRowChar) + (batshipCol++);
                        caseOneString = "" + (batshipRowChar) + (batshipCol);
                        if (carrierRange.contains("" + caseFourString))
                        {
                            System.out.println("collision at " + caseFourString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: East");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                case 'S':
                    batshipRange = batshipPosition.toUpperCase()
                            + (++batshipRowChar) + (batshipCol)
                            + (++batshipRowChar) + (batshipCol)
                            + (++batshipRowChar) + (batshipCol);
                    batshipRowChar = toSplit[0].toUpperCase().charAt(0);
                    if ((batshipRow + batshipSize) < 11)
                    {
                        caseFourString = "" + (batshipRowChar++) + (batshipCol);
                        caseThreeString = "" + (batshipRowChar++) + (batshipCol);
                        caseTwoString = "" + (batshipRowChar++) + (batshipCol);
                        caseOneString = "" + (batshipRowChar) + (batshipCol);
                        if (carrierRange.contains("" + caseFourString))
                        {
                            System.out.println("collision at " + caseFourString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: South");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                case 'W':
                    batshipRange = batshipPosition.toUpperCase()
                            + batshipRowChar + (batshipCol - 1)
                            + batshipRowChar + (batshipCol - 2)
                            + batshipRowChar + (batshipCol - 3);
                    batshipCol = Integer.parseInt(toSplit[1]);
                    if ((batshipCol - batshipSize) >= 0)
                    {
                        caseFourString = "" + (batshipRowChar) + (batshipCol--);
                        caseThreeString = "" + (batshipRowChar) + (batshipCol--);
                        caseTwoString = "" + (batshipRowChar) + (batshipCol--);
                        caseOneString = "" + (batshipRowChar) + (batshipCol);
                        if (carrierRange.contains("" + caseFourString))
                        {
                            System.out.println("collision at " + caseFourString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: East");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                default:
                    whilelooper = 100;
            }
        }
        while (whilelooper == 0)
        {
            System.out.print("Please enter your Cruiser(3) position here: ");
            cruPosition = scanner.next();
            System.out.println("You entered: " + cruPosition.toUpperCase());
            if ((carrierRange.contains(cruPosition.toUpperCase())))
            {
                System.out.println("Invalid move, Carrier already exists there!");
                whilelooper = 0;
            }
            else if ((batshipRange.contains(cruPosition.toUpperCase())))
            {
                System.out.println("Invalid move, Battleship already exists there!");
                whilelooper = 0;
            }
            else
            {
                whilelooper = 100;
            }
        }
        while (whilelooper == 100)
        {
            toSplit = cruPosition.split("(?<=\\D)(?=\\d)");
            cruRowChar = toSplit[0].toUpperCase().charAt(0);
            cruCol = Integer.parseInt(toSplit[1]);
            cruRow = findIndex(charArray, cruRowChar) + 1;
            System.out.print("Enter your Cruisers bearings(direction) here: ");
            cruDir = scanner.next().toUpperCase().charAt(0);
            switch (cruDir)
            {
                case 'N':
                    cruRange = cruPosition.toUpperCase()
                            + (--cruRowChar) + (cruCol)
                            + (--cruRowChar) + (cruCol);
                    cruRowChar = toSplit[0].toUpperCase().charAt(0);
                    if ((cruRow - cruSize) >= 0)
                    {
                        caseThreeString = "" + (cruRowChar--) + (cruCol);
                        caseTwoString = "" + (cruRowChar--) + (cruCol);
                        caseOneString = "" + (cruRowChar) + (cruCol);
                        if (carrierRange.contains("" + caseThreeString) || batshipRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: North");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                case 'E':
                    cruRange = cruPosition.toUpperCase()
                            + cruRowChar + (cruCol + 1)
                            + cruRowChar + (cruCol + 2);
                    cruCol = Integer.parseInt(toSplit[1]);
                    if ((cruCol + cruSize) < 11)
                    {
                        caseThreeString = "" + (cruRowChar) + (cruCol++);
                        caseTwoString = "" + (cruRowChar) + (cruCol++);
                        caseOneString = "" + (cruRowChar) + (cruCol);
                        if (carrierRange.contains("" + caseThreeString) || batshipRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: East");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                case 'S':
                    cruRange = cruPosition.toUpperCase()
                            + (++cruRowChar) + (cruCol)
                            + (++cruRowChar) + (cruCol);
                    cruRowChar = toSplit[0].toUpperCase().charAt(0);
                    if ((cruRow + cruSize) < 11)
                    {
                        caseThreeString = "" + (cruRowChar++) + (cruCol);
                        caseTwoString = "" + (cruRowChar++) + (cruCol);
                        caseOneString = "" + (cruRowChar) + (cruCol);
                        if (carrierRange.contains("" + caseThreeString) || batshipRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: South");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                case 'W':
                    cruRange = cruPosition.toUpperCase()
                            + cruRowChar + (cruCol - 1)
                            + cruRowChar + (cruCol - 2);
                    cruCol = Integer.parseInt(toSplit[1]);
                    if ((cruCol - cruSize) > 0)
                    {
                        caseThreeString = "" + (cruRowChar) + (cruCol--);
                        caseTwoString = "" + (cruRowChar) + (cruCol--);
                        caseOneString = "" + (cruRowChar) + (cruCol);
                        if (carrierRange.contains("" + caseThreeString) || batshipRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: East");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                default:
                    whilelooper = 100;
            }
        }
        while (whilelooper == 0)
        {
            System.out.print("Please enter your Submarine(3) position here: ");
            scanner = new Scanner(System.in);
            subPosition = scanner.next();
            System.out.println("You entered: " + subPosition.toUpperCase());
            if ((carrierRange.contains(subPosition.toUpperCase())))
            {
                System.out.println("Invalid move, Carrier already exists there!");
                whilelooper = 0;
            }
            else if ((batshipRange.contains(subPosition.toUpperCase())))
            {
                System.out.println("Invalid move, Battleship already exists there!");
                whilelooper = 0;
            }
            else if ((cruRange.contains(subPosition.toUpperCase())))
            {
                System.out.println("Invalid move, Cruiser already exists there!");
                whilelooper = 0;
            }
            else
            {
                whilelooper = 100;
            }
        }
        while (whilelooper == 100)
        {
            toSplit = subPosition.split("(?<=\\D)(?=\\d)");
            subRowChar = toSplit[0].toUpperCase().charAt(0);
            subCol = Integer.parseInt(toSplit[1]);
            subRow = findIndex(charArray, subRowChar) + 1;
            System.out.print("Enter your Submarines bearings(direction) here: ");
            subDir = scanner.next().toUpperCase().charAt(0);
            switch (subDir)
            {
                case 'N':
                    subRange = subPosition.toUpperCase()
                            + (--subRowChar) + (subCol)
                            + (--subRowChar) + (subCol);
                    subRowChar = toSplit[0].toUpperCase().charAt(0);
                    if ((subRow - subSize) >= 0)
                    {
                        caseThreeString = "" + (subRowChar--) + (subCol);
                        caseTwoString = "" + (subRowChar--) + (subCol);
                        caseOneString = "" + (subRowChar) + (subCol);
                        if (carrierRange.contains("" + caseThreeString) || batshipRange.contains("" + caseThreeString)
                                || cruRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString)
                                || cruRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString)
                                || cruRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: North");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                case 'E':
                    subRange = subPosition.toUpperCase()
                            + subRowChar + (subCol + 1)
                            + subRowChar + (subCol + 2);
                    subCol = Integer.parseInt(toSplit[1]);
                    if ((subCol + subSize) <= 11)
                    {
                        caseThreeString = "" + (subRowChar) + (subCol++);
                        caseTwoString = "" + (subRowChar) + (subCol++);
                        caseOneString = "" + (subRowChar) + (subCol);
                        if (carrierRange.contains("" + caseThreeString) || batshipRange.contains("" + caseThreeString)
                                || cruRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString)
                                || cruRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString)
                                || cruRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: East");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                case 'S':
                    subRange = subPosition.toUpperCase()
                            + (++subRowChar) + (subCol)
                            + (++subRowChar) + (subCol);
                    subRowChar = toSplit[0].toUpperCase().charAt(0);
                    if ((subRow + subSize) < 11)
                    {
                        caseThreeString = "" + (subRowChar++) + (subCol);
                        caseTwoString = "" + (subRowChar++) + (subCol);
                        caseOneString = "" + (subRowChar) + (subCol);
                        if (carrierRange.contains("" + caseThreeString) || batshipRange.contains("" + caseThreeString)
                                || cruRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString)
                                || cruRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString)
                                || cruRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: South");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                case 'W':
                    subRange = subPosition.toUpperCase()
                            + subRowChar + (subCol - 1)
                            + subRowChar + (subCol - 2);
                    subCol = Integer.parseInt(toSplit[1]);
                    if ((subCol - subSize) > 0)
                    {
                        caseThreeString = "" + (subRowChar) + (subCol--);
                        caseTwoString = "" + (subRowChar) + (subCol--);
                        caseOneString = "" + (subRowChar) + (subCol);
                        if (carrierRange.contains("" + caseThreeString) || batshipRange.contains("" + caseThreeString)
                                || cruRange.contains("" + caseThreeString))
                        {
                            System.out.println("collision at " + caseThreeString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString)
                                || cruRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 100;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString)
                                || cruRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 100;
                        }
                        else
                        {
                            System.out.println("Nice you selected: East");
                            whilelooper = 0;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 100;
                    }
                    break;
                default:
                    whilelooper = 100;
            }
        }
        while (whilelooper == 0)
        {
            System.out.print("Please enter your Destroyer(2) position here: ");
            scanner = new Scanner(System.in);
            destPosition = scanner.next();
            System.out.println("You entered: " + destPosition.toUpperCase());
            if ((carrierRange.contains(destPosition.toUpperCase())))
            {
                System.out.println("Invalid move, Carrier already exists there!");
                whilelooper = 0;
            }
            else if ((batshipRange.contains(destPosition.toUpperCase())))
            {
                System.out.println("Invalid move, Battleship already exists there!");
                whilelooper = 0;
            }
            else if ((cruRange.contains(destPosition.toUpperCase())))
            {
                System.out.println("Invalid move, Cruiser already exists there!");
                whilelooper = 0;
            }
            else if ((subRange.contains(destPosition.toUpperCase())))
            {
                System.out.println("Invalid move, Submarine already exists there!");
                whilelooper = 0;
            }
            else
            {
                whilelooper = 100;
            }
        }
        whilelooper = 0;
        while (whilelooper == 0)
        {
            toSplit = destPosition.split("(?<=\\D)(?=\\d)");
            destRowChar = toSplit[0].toUpperCase().charAt(0);
            destCol = Integer.parseInt(toSplit[1]);
            destRow = findIndex(charArray, destRowChar) + 1;
            System.out.print("Enter your Destroyers bearings(direction) here: ");
            destDir = scanner.next().toUpperCase().charAt(0);
            switch (destDir)
            {
                case 'N':
                    destRange = destPosition.toUpperCase() + (--destRowChar) + (destCol);
                    destRowChar = toSplit[0].toUpperCase().charAt(0);
                    if ((destRow - destSize) >= 0)
                    {
                        caseTwoString = "" + (destRowChar--) + (destCol);
                        caseOneString = "" + (destRowChar) + (destCol);
                        if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString)
                                || cruRange.contains("" + caseTwoString)
                                || subRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 0;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString)
                                || cruRange.contains("" + caseOneString)
                                || subRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 0;
                        }
                        else
                        {
                            System.out.println("Nice you selected: North");
                            whilelooper = 100;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 0;
                    }
                    break;
                case 'E':
                    destRange = destPosition.toUpperCase() + destRowChar + (destCol + 1);
                    destCol = Integer.parseInt(toSplit[1]);
                    if ((destCol + destSize) < 11)
                    {
                        caseTwoString = "" + (destRowChar) + (destCol++);
                        caseOneString = "" + (destRowChar) + (destCol);
                        if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString)
                                || cruRange.contains("" + caseTwoString)
                                || subRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 0;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString)
                                || cruRange.contains("" + caseOneString)
                                || subRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 0;
                        }
                        else
                        {
                            System.out.println("Nice you selected: East");
                            whilelooper = 100;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 0;
                    }
                    break;
                case 'S':
                    destRange = destPosition.toUpperCase() + (++destRowChar) + (destCol);
                    destRowChar = toSplit[0].toUpperCase().charAt(0);
                    if ((destRow + destSize) < 11)
                    {
                        caseTwoString = "" + (destRowChar++) + (destCol);
                        caseOneString = "" + (destRowChar) + (destCol);
                        if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString)
                                || cruRange.contains("" + caseTwoString)
                                || subRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 0;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString)
                                || cruRange.contains("" + caseOneString)
                                || subRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 0;
                        }
                        else
                        {
                            System.out.println("Nice you selected: South");
                            whilelooper = 100;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 0;
                    }
                    break;
                case 'W':
                    destRange = destPosition.toUpperCase() + destRowChar + (destCol - 1);
                    destCol = Integer.parseInt(toSplit[1]);
                    if ((destCol - destSize) > 0)
                    {
                        caseTwoString = "" + (destRowChar) + (destCol--);
                        caseOneString = "" + (destRowChar) + (destCol);
                        if (carrierRange.contains("" + caseTwoString) || batshipRange.contains("" + caseTwoString)
                                || cruRange.contains("" + caseTwoString)
                                || subRange.contains("" + caseTwoString))
                        {
                            System.out.println("collision at " + caseTwoString);
                            whilelooper = 0;
                        }
                        else if (carrierRange.contains("" + caseOneString) || batshipRange.contains("" + caseOneString)
                                || cruRange.contains("" + caseOneString)
                                || subRange.contains("" + caseOneString))
                        {
                            System.out.println("collision at " + caseOneString);
                            whilelooper = 0;
                        }
                        else
                        {
                            System.out.println("Nice you selected: East");
                            whilelooper = 100;
                        }
                    }
                    else
                    {
                        System.out.println("Invalid move, that's out of bounds!");
                        whilelooper = 0;
                    }
                    break;
                default:
                    whilelooper = 0;
            }
        }
        System.out.println("\n\t\tCongratulations on successfully launching your fleet!\n\n\t\t\t\tThe"
                + " US Navy is the finest naval force in the world thanks in large part to sailors like "
                + "you!!\n\t\t\nCarrier coordinates: \t\t" + carrierRange);
        System.out.println("Battleship coordinates: \t" + batshipRange);
        System.out.println("Cruiser coordinates: \t\t" + cruRange);
        System.out.println("Submarine coordinates: \t\t" + subRange);
        System.out.println("Destroyer coordinates: \t\t" + destRange);
    }

    private static int findIndex(char[] arr, char t)
    {
        int len = arr.length;
        return IntStream.range(0, len).filter(i -> t == arr[i]).findFirst().orElse(-1000);
    }
}