
public class BodyOfWater extends Tile {

	@Override
	public Force strengthen(Force f) {
		// In our simulation a body of water will preserve the load of the force
		// upon strengthening.
		Force clone = f.clone();
		return clone;
	}

	@Override
	public boolean canPropagate() {
		// A force can strengthen over a body of water.
		return true;
	}
}
