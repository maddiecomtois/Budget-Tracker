import java.util.ArrayList;
import java.util.Scanner;

/**
 * Keep track of monthly budget.
 * 
 * @author Maddie Comtois
 * @version 17/08/17
 */
public class BudgetMain {
	// input my monthly budget
	public static double TOTAL_BUDGET = 0;

	// create array lists to keep track of different purchases
	static ArrayList<Expenses> food = new ArrayList<Expenses>();
	static ArrayList<Expenses> transport = new ArrayList<Expenses>();
	static ArrayList<Expenses> clothes = new ArrayList<Expenses>();
	static ArrayList<Expenses> personal = new ArrayList<Expenses>();
	static ArrayList<Expenses> home = new ArrayList<Expenses>();
	static ArrayList<Expenses> savings = new ArrayList<Expenses>();
	public static Scanner in = new Scanner(System.in);

	/**
	 * This function presents the user with a menu of options to either add a
	 * purchase, view purchases, or exit
	 * 
	 */
	public static void presentMenu() {
		boolean updateData = true;
		while (updateData) {
			System.out.println("What would you like to do?");
			System.out.println("[1] Add expense\n" + "[2] View Purchases\n" + "[3] Exit");
			if (in.hasNextInt()) {
				int menuSelection = in.nextInt();
				in.nextLine();

				if (menuSelection == 1) {
					try {
						updateArrayList();

					} catch (Exception e) {
						System.out.println("That is invalid input");
						in.nextLine();
					}
				} else if (menuSelection == 2) {
					try {
						viewPurchases();

					} catch (Exception e) {
						System.out.println("That is invalid input");
						in.nextLine();
					}
				} else if (menuSelection == 3) {
					try {
						updateData = false;
						System.out.println("Have a good day");
						break;

					} catch (Exception e) {
						System.out.println("That is invalid input");
						in.nextLine();
					}
				} else {
					System.out.println("Sorry, that is not a valid menu option.");
				}
				System.out.print("Would you like to select another menu option? (y/n) ");
				String makeChanges = in.next();

				if (makeChanges.equalsIgnoreCase("n") || makeChanges.equalsIgnoreCase("no"))
					updateData = false;

			} else {
				String invalidInput = in.next();
				System.out.println("Sorry that was not a valid menu option.\n");
			}
		}
	}

	/**
	 * This method adds a purchase to the appropriate array list when selected from
	 * the menu
	 */
	public static void updateArrayList() {
		System.out.println("What type of expense?");
		System.out.println(
				"[1] Food\n" + "[2] Transport\n" + "[3] Clothes\n" + "[4] Personal\n" + "[5] Home\n" + "[6] Savings");
		if (in.hasNextInt()) {
			int menuSelection = in.nextInt();
			in.nextLine();

			System.out.println("What is the amount of the purchase?");
			double purchase = in.nextDouble();
			System.out.println("What is the date of the purchase? dd/mm/yy");
			String date = in.next();
			in.nextLine();
			System.out.println("Where did you make this purchase/any comments?");
			String comment = in.nextLine();

			if (menuSelection == 1) {
				try {
					food.add(new Expenses(purchase, date, comment, "Food"));
					System.out.println("Item added successfully");

				} catch (Exception e) {
					System.out.println("That is invalid input");
					in.nextLine();
				}
			} else if (menuSelection == 2) {
				try {
					transport.add(new Expenses(purchase, date, comment, "Transport"));
					System.out.println("Item added successfully");

				} catch (Exception e) {
					System.out.println("That is invalid input");
					in.nextLine();
				}
			} else if (menuSelection == 3) {
				try {
					clothes.add(new Expenses(purchase, date, comment, "Clothes"));
					System.out.println("Item added successfully");

				} catch (Exception e) {
					System.out.println("That is invalid input");
					in.nextLine();
				}

			} else if (menuSelection == 4) {
				try {
					personal.add(new Expenses(purchase, date, comment, "Personal"));
					System.out.println("Item added successfully");

				} catch (Exception e) {
					System.out.println("That is invalid input");
					in.nextLine();
				}
			} else if (menuSelection == 5) {
				try {
					home.add(new Expenses(purchase, date, comment, "Home"));
					System.out.println("Item added successfully");

				} catch (Exception e) {
					System.out.println("That is invalid input");
					in.nextLine();
				}
			} else if (menuSelection == 6) {
				try {
					savings.add(new Expenses(purchase, date, comment, "Savings"));
					System.out.println("Item added successfully");

				} catch (Exception e) {
					System.out.println("That is invalid input");
					in.nextLine();
				}
			} else {
				System.out.println("Sorry, that is not a valid menu option.");
			}
		}
	}

	/**
	 * This method calculates the total money spent on a particular purchase
	 * category
	 * 
	 * @param one of the array lists
	 * @return the total cost of purchases in the array list
	 */

	public static double calculateTotal(ArrayList<Expenses> arrayList) {
		double totalCost = 0;
		for (Expenses item : arrayList) {
			totalCost += item.getCost();
		}
		return totalCost;
	}

	/**
	 * This method prints out the entered purchases, total for each category, and
	 * remaining cash for the month
	 */
	public static void viewPurchases() {
		ArrayList<ArrayList<Expenses>> allExpenses = new ArrayList<ArrayList<Expenses>>();
		allExpenses.add(food);
		allExpenses.add(transport);
		allExpenses.add(clothes);
		allExpenses.add(personal);
		allExpenses.add(home);
		allExpenses.add(savings);
		double totalOfAllPurchases = 0;

		if (allExpenses.get(0) != null) {
			for (ArrayList<Expenses> expenses : allExpenses) {
				boolean typePrinted = false;
				System.out.println("Purchase      Date            Comment");
				System.out.println("----------------------------------------");
				for (Expenses purchase : expenses) {
					if (typePrinted == false) {
						System.out.println(purchase.getType());
						typePrinted = true;
					}
					System.out.printf("%-1s %-10.2f %-15s %-20s \n", "€", purchase.getCost(), purchase.getDate(),
							purchase.getComment());
				}
				System.out.printf("%6s %1s %4.2f", "Total: ", "€", calculateTotal(expenses));
				totalOfAllPurchases += calculateTotal(expenses);
				System.out.println();
				System.out.println();
			}
			System.out.println("Total spent this month: " + "€ " + totalOfAllPurchases);
			System.out.println("Remaining cash for the month: " + (TOTAL_BUDGET - totalOfAllPurchases));

		} else
			System.out.println("Sorry, you have not entered any purchases");

	}

	public static void main(String[] args) {
		presentMenu();

	}
}
