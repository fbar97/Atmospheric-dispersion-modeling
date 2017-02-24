
public class Highway extends Tile {
	private int carDensity; 

	public Highway(int carDensity) {
		
		super();
		this.carDensity = carDensity;
	}

	@Override
	public Force strengthen(Force force) {
		/*
		 * The returned force's load will be incremented by the pollutants
		 * created by the number of cars on the highway.
		 */
		Force clone = force.clone();
		int polCars = carDensity * super.getCARS_WASTE();
		clone.setLoad(clone.getLoad() + polCars);
		return clone;
	}

	@Override
	public boolean canPropagate() {
		
		return true;
	}
}
