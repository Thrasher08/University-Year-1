
public class BOGOFF {

	public static int[] INCOMES = { 25, 50, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450,
			500, 550 };

	public static void main(String[] args) {
		taxTables();
	}

	public static void taxTables() {

		new TaxChart(INCOMES);
		TaxChart.draw();
		TaxChart.printTable(INCOMES);

	}

}