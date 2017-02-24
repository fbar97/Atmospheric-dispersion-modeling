
public abstract class Tile implements Modifiable {

	private int row = 0; 
	private int col = 0; 
	private String measurement; //reading of a Force's load at the current tile,rounded						
	private int PEOPLE_WASTE = 2; //represents a multiplier that acts on a pollutant load 
	private int CARS_WASTE = 5; //represents a multiplier for load contributed by car pollution.

	public int getPEOPLE_WASTE() {
		return PEOPLE_WASTE;
	}

	public int getCARS_WASTE() {
		return CARS_WASTE;
	}
	
	/*
	 * This method will determine whether or not the pollutant can propagate
	 * past this tile (for example, a large building would prevent propagation).
	 */
	public abstract boolean canPropagate();

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return col;
	}

	public void setColumn(int col) {
		this.col = col;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(double measurement) {
		this.measurement = "" + Math.round(measurement);
	}

	@Override
	public String toString() {
		return "row: " + this.getRow() + " col: " + this.getColumn();
	}

	@Override
	public Force weaken(Force force) {
		// Implement the weakening of the force 
		Force clone = force.clone();
		clone.decay();
		return clone;
	}
}
