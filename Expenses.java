
/**
 * Class for transportation
 * 
 * @author Maddie Comtois
 * @version 17/08/17
 */
public class Expenses {
	private double cost;
	private String date;
	private String comment;
	private String type;

	public Expenses(double ct, String d, String c, String t) {
		cost = ct;
		date = d;
		comment = c;
		type = t;
	}

	public double getCost() {
		return cost;
	}

	public String getDate() {
		return date;
	}

	public String getComment() {
		return comment;
	}

	public String getType() {
		return type;
	}
}
