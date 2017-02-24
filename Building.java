
public class Building extends Tile {
	private int people; 
	private int cars; 
	private int height; 

	public Building(int people, int cars, int height) {
		super();
		this.people = people;
		this.cars = cars;
		this.height = height;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public int getCars() {
		return cars;
	}

	public void setCars(int cars) {
		this.cars = cars;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public Force strengthen(Force force) {
		/*
		 * The returned force's load will be incremented by the pollutants
		 * created by the number of cars and people.
		 */
		Force clone = force.clone();
		double carPol = this.cars * super.getCARS_WASTE();
		double peoplePol = this.people * super.getPEOPLE_WASTE();

		clone.setLoad(Math.round(force.getLoad() + carPol + peoplePol));
		return clone;
	}

	@Override
	public boolean canPropagate() {

		if (this.height < 100) {
			return true;
		}
		return false;
	}
}
