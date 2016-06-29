/* CreditCardPayOff.java
 * Author: Alyssa Lagimoniere
 * Submission Date: 1/30/15
 * 
 * Purpose: The purpose of this project is to apply knowledge of 
 * variables, assignments, expressions, type casting, input, output, 
 * and basic algorithm design. We are trying to compute the 
 * number of months it will take to pay off credit card debt.
 * We also will have to figure out an algorithm displaying
 * how much is being overpaid to the credit card company.
 * 
 * Statement of Academic Honesty: 
 * 
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with 
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer
 * Science at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia. 
 */

import java.util.Scanner;
public class CreditCardPayOff {

	public static void main(String[] args) {
		
		//Define scanner
		Scanner keyboard = new Scanner(System.in);

		// Declare variables
		double principal;
		double annualInterestRate;
		double monthlyPayment;
		double monthsNeeded;
		int monthsNeededInt;
		double totalAmountPaid;
		double totalInterestPaid;
		double overpayment;
		
		//Tell user to enter values 
		System.out.print("Principal: \t\t\t");
		principal = keyboard.nextDouble();
		System.out.print("Annual Interest Rate (%): \t");
		annualInterestRate = keyboard.nextDouble();
		System.out.print("Monthly Payment: \t\t");
		monthlyPayment = keyboard.nextDouble();
		
		//Computations
		monthsNeeded = (Math.log(monthlyPayment) - Math.log(monthlyPayment - (annualInterestRate/1200.0) * principal))/Math.log((annualInterestRate/1200.0) + 1.0);
		monthsNeededInt = (int)Math.ceil(monthsNeeded);
		totalAmountPaid = monthsNeededInt * monthlyPayment;
		totalInterestPaid = totalAmountPaid - principal;
		
		//Overpayment algorithm --> Take the monthly payment and multiply by the ceiling number of months needed and subtract that from the actual numbers of months needed multiplied by the monthly payment
		overpayment = ((monthlyPayment * monthsNeededInt) - (monthlyPayment * monthsNeeded));
		
		//Print
		System.out.println("");
		System.out.println("Months Needed to Pay Off: \t" + monthsNeededInt);
		System.out.printf("Total Amount Paid: \t\t" + "$%.2f\n", totalAmountPaid);
		System.out.printf("Total Interest Paid: \t\t" + "$%.2f\n", totalInterestPaid);
		System.out.printf("Overpayment: \t\t\t" + "$%.2f\n", overpayment);
	}

}
