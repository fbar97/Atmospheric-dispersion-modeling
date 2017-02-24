
public class Nature extends Tile {
	private int treeDensity; 						

	public Nature(int treeDensity) {
		super();
		this.treeDensity = treeDensity;
	}

	@Override
	public Force strengthen(Force force) {
		// nature will preserve the load of the force upon strengthening.
		Force clone = force.clone();
		return clone;
	}

	@Override
	public Force weaken(Force force) {
		/*
		 * In this simulation nature will reduce the strength of a force
		 * proportional to the tree density. The load of a force cannot be
		 * negative.
		 */
		Force clone = force.clone();
		if ((Math.round((force.getLoad() - (force.getLoad() * (this.treeDensity / 100.0))))) > 0) {
			clone.setLoad((Math.round((force.getLoad() - (force.getLoad() * (this.treeDensity / 100.0))))));
		} else {
			clone.setLoad(0);
		}
		return clone;
	}

	@Override
	public boolean canPropagate() {
		if (this.treeDensity <= 50) {
			return true;
		}
		return false;
	}
}
