import java.util.Scanner;

public class TaxCalculator {
	public static void main(String[] args) {

		Scanner inputIncome = new Scanner(System.in);
		int income = inputIncome.nextInt();

		// The amount of of tax
		System.out.println("Tax Payable: Åí" + taxPayable(income));

		// The income remaining after tax
		System.out.println("Remaining Income: Åí" + returnIncome(income));
	}

	public static int taxPayable(int income) {

		double store = income;

		// Tax values
		double[] tax = { 0, 0.10, 0.20, 0.40, 0.60, 1.20 };
		double taxReturn = 0;

		if (store <= 100) {
			taxReturn = store * tax[0];
		}

		if (store >= 101.0 && store <= 150.0) {
			taxReturn = (store - 100) * tax[1];
		}

		if (store >= 151.0 && store <= 200.0) {
			taxReturn = (tax[0] * 100) + (tax[1] * 50) + (tax[2] * (store - (100 + 50)));
		}

		if (store >= 201.0 && store <= 300.0) {
			taxReturn = (tax[0] * 100) + (tax[1] * 50) + (tax[2] * 50) + (tax[3] * (store - (100 + 50 + 50)));
		}

		if (store >= 301.0 && store <= 400.0) {
			taxReturn = (tax[0] * 100) + (tax[1] * 50) + (tax[2] * 50) + (tax[3] * 100)
					+ (tax[4] * (store - (100 + 50 + 50 + 100)));
		}

		if (store >= 401.0) {
			taxReturn = (tax[0] * 100) + (tax[1] * 50) + (tax[2] * 50) + (tax[3] * 100) + (tax[4] * 100)
					+ (tax[5] * (store - (100 + 50 + 50 + 100 + 100)));
		}

		// Return rounded value of taxReturn
		return (int) Math.round(taxReturn);

	}

	public static int returnIncome(int income) {

		// iRemaining is the remaining income after tax
		int iRemaining = income - taxPayable(income);
		return iRemaining;
	}
}