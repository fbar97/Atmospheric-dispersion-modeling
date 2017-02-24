
public class Force {
	private double load; //how much pollutant exists.
	private String name; 

	public Force(double load, String name) {
		
		this.load = load;
		this.name = name;
	}

	public double getLoad() {
		return load;
	}

	public void setLoad(double load) {
		this.load = load;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void decay() {
		// This will reduce the load to 80% of its original strength.
		this.setLoad((this.load - (this.load * .2)));
	}

	public Force clone() {

		Force clone = new Force(this.load, this.name);
		return clone;
	}

	@Override
	public String toString() {

		String type = "";
		if (this.getLoad() > 100) {
			type += "force";
		} else {
			type += "wind";
		}
		return type + " has a load of " + Math.round(this.getLoad());
	}
}
