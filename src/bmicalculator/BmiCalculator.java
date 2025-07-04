package bmicalculator;

import java.util.Scanner;
import java.util.Locale;
public class BmiCalculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input.useLocale(Locale.US);
		
		System.out.println("Welcome to BMI Calculator");
        System.out.println("Please sign in to continue.");
        String correctUsername = "Pearl";
        String correctPassword = "@Pz0010120906085";

        boolean signedIn = false;

        while (!signedIn) {
            System.out.print("Enter username: ");
            String username = input.next();

            System.out.print("Enter password: ");
            String password = input.next();

            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Sign in successful!\n");
                signedIn = true;
            } else {
                System.out.println("Incorrect username or password. Please try again.\n");
            }
        }

		
		char repeat = 0;
		do {
			int unitChoice = getUnitChoice(input);
			double weight = (unitChoice == 1) ? getValidInput(input, "Enter your weight in kilograms :", 10, 600)
					:getValidInput(input, "Enter your weight", 22, 1300);
			
			double height = (unitChoice == 1) ? getValidInput(input, "Enter your height in meters : ", 0.5, 2.5)
					:getValidInput(input, "Enter your weight in inches", 20, 100);
			
			double bmi = calculateBMI(unitChoice, weight, height);
			
			 System.out.println("\nBMI Calculation Results");
	         System.out.println("Unit System: " + (unitChoice == 1 ? "Metric (kg, m)" : "Imperial (lbs, in)"));
	         System.out.println("Weight: " + weight + (unitChoice == 1 ? " kg" : " lbs"));
	         System.out.println("Height: " + height + (unitChoice == 1 ? " m" : " in"));
	         System.out.printf("BMI: %.2f\n", bmi);
	         System.out.println("\n");
	         
	         if (bmi < 18.5) {
	             System.out.println("Category: Underweight");
	            } else if (bmi < 24.9) {
	             System.out.println("Category: Normal weight");
	            } else if (bmi < 29.9) {
	             System.out.println("Category: Overweight");
	            } else {
	             System.out.println("Category: Obesity");
	            }
			
	         System.out.print("Would you like to calculate another BMI? (Y/N): ");
	         repeat = input.next().charAt(0);
	         System.out.println();
	         
	         
			System.out.println("THANK YOU ");
			
			
			
			System.out.println();
		} while (repeat == 'Y' || repeat == 'y');
	}	
	public static int getUnitChoice(Scanner input) { 
		int choice;
		
		while(true) {
			System.out.println("Select prefered unit:\n" 
					+ "1. Metric (kg, m)\n"
					+ "2. Imperial (ibs, in)\n"
					+ "Please select either option 1 or option 2");
			if(input.hasNextInt()) {
				choice = input.nextInt();
				if(choice == 1 || choice == 2) {
				break;
				} else {
					System.out.println("Invalid choice. Please enter 1 or 2");
				}
			} else {
				System.out.println("invalid input. Please enter a number (1 or 2");
				input.next();
			}
		}
		
		return choice;
	}
	public static double getValidInput(Scanner input, String prompt, double min, double max) {
		double value;
		
		while(true) {
			System.out.println(prompt);
			if(input.hasNextDouble()) {
				value = input.nextDouble();
				if(value >= min && value <= max) {
					break;
				} else {
					System.out.printf("Please enter a value betwee %.1f and %.1f./n", min, max);
				} 
				}else {
					System.out.println("Invalid input. Please enter a value");
					input.next();
		}
		}
		
		return value;
	}
	
	public static double calculateBMI(int unitChoice, double weight, double height) {
		double totalBMI;
		
		if(unitChoice == 1) {
			totalBMI = weight / (height * height);
		} else {
			totalBMI = (703 * weight) / (height / height);
		}
		
		
		return totalBMI;
	}

}
