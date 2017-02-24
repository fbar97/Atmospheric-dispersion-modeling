
public class IndustrialBuilding extends Building {
	private double emissions; // This attribute keeps track of the amount of emissions 
	
	private int EMISSIONS_CONSTANT = 10; //represents a multiplier that acts on a pollutant load 

	public IndustrialBuilding(int people, int cars, int height, double emissions) {

		super(people, cars, height);
		this.emissions = emissions;
	}

	@Override
	public Force strengthen(Force force) {
		/*
		 * The returned force's load will be incremented by the pollutants
		 * created by the number of emissions, after strengthening the force
		 * through the parent's method.
		 */

		Force clone = super.strengthen(force);
		int polEmissions = (int) Math.round(EMISSIONS_CONSTANT * this.emissions);
		clone.setLoad(clone.getLoad() + polEmissions);
		return clone;

	}

	@Override
	public boolean canPropagate() {
		
		return true;
	}
}
