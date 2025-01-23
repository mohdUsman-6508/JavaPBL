package JavaBasics;

import java.util.Scanner;

public class UnitConverter {

    float kmToMiles(float distance) {
        float distanceInMiles;
        distanceInMiles = distance * 0.6213f;
        printResult("Km", "Miles", distanceInMiles);
        return distanceInMiles;
    }

    float degCToF(float temperature) {
        float temperatureInDegF;
        temperatureInDegF = (temperature * (float) (9.0 / 5.0)) + 32;
        printResult("℃", "℉", temperatureInDegF);
        return temperatureInDegF;
    }

    float kgToPounds(float weight) {
        float weightInPounds;
        weightInPounds = weight * 2.204f;
        printResult("Kg", "Pounds", weightInPounds);
        return weightInPounds;
    }

    public void printResult(String fromUnit, String toUnit, float result) {
        System.out.println("--------------------------");
        System.out.println("( " + fromUnit + " )" + "-->" + "( " + toUnit + " ) : " + result + " " + toUnit);
        System.out.println("--------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UnitConverter unitConverter = new UnitConverter();
        System.out.println("Welcome!");

        while (true) {
            System.out.println("Choose unit to convert:");
            System.out.println("--------------------------");
            System.out.println("1. Temperature ( ℃ to ℉ )");
            System.out.println("2. Distance ( Kms to Miles )");
            System.out.println("3. Weight ( Kg to Pounds )");
            System.out.println("--------------------------");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter Temperature( ℃ ): ");
                    float tempInDegC = sc.nextFloat();
                    sc.nextLine();
                    unitConverter.degCToF(tempInDegC);
                }
                break;

                case 2:
                    System.out.println("Enter Distance( Kms )");
                    float distInKms = sc.nextFloat();
                    sc.nextLine();
                    unitConverter.kmToMiles(distInKms);
                    break;

                case 3:
                    System.out.println("Enter Weight( Kgs )");
                    float weightInkgs = sc.nextFloat();
                    sc.nextLine();
                    unitConverter.kgToPounds(weightInkgs);
                    break;

                default:
                    System.out.println("Invalid Input");
                    return;
            }

            System.out.println("To convert more enter 0");
            int isContinue = sc.nextInt();
            if (isContinue != 0) {
                System.out.println("Thanks for using our app:)");
                break;
            }
        }
    }
}
