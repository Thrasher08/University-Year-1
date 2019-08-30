import java.util.Arrays;

public class TaxChart {

	// Constructor associated with INCOMES array in BOGOFF class
	private static int[] INCOMES;

	TaxChart(int[] rangeList) {
		Arrays.sort(rangeList);
		INCOMES = rangeList;
	}

	public static void draw() {

		// X Axis
		Bar x = new Bar();
		// Y Axis
		Bar y = new Bar();

		// X Axis
		x.makeVisible();
		x.changeSize(200, 4);
		x.moveVertical(200);

		// Y Axis
		y.makeVisible();
		y.changeSize(4, 200);

		// For each value of i make new bar visible
		for (int i : INCOMES) {
			// Yellow bars (returnIncome)
			Bar value = new Bar();
			// Red bars (taxPayable)
			Bar tValue = new Bar();
			value.makeVisible();
			value.changeColour(Colour.YELLOW);
			// X & Y Axis != 600 Therefore 600A=200 A=200/600 A=1/3 To make
			// Graph Proportional: i/3
			value.moveHorizontal(i / 3);
			value.moveVertical((-TaxCalculator.returnIncome(i) / 3) + 200);
			value.changeSize(4, (TaxCalculator.returnIncome(i) / 3));

			tValue.makeVisible();
			tValue.changeColour(Colour.RED);
			tValue.moveHorizontal(i / 3);
			tValue.moveVertical((-TaxCalculator.taxPayable(i) / 3) + 200 + (-TaxCalculator.returnIncome(i) / 3));
			tValue.changeSize(4, (TaxCalculator.taxPayable(i) / 3));
		}
	}

	public static void printTable(int[] INCOMES) {

		System.out.println("Gross Income" + "     " + "Tax Payable" + "     " + "Net Income:");
		for (int i = 0; i < INCOMES.length; i++) {
			System.out.println(INCOMES[i] + "              " + TaxCalculator.taxPayable(INCOMES[i]) + "               "
					+ TaxCalculator.returnIncome(INCOMES[i]));
		}
	}
}
