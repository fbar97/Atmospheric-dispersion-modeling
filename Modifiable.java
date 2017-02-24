
public interface Modifiable {

	// The purpose of this interface is to strengthen or weaken a Force.

	/*
	 * This method will clone the incoming argument and increase the clone's
	 * load, finally returning the clone.
	 */
	public Force strengthen(Force f);
	
	/*
	 * This method will clone the incoming argument and reduce the clone's load,
	 * finally returning the clone.
	 */
	public Force weaken(Force f);


}
