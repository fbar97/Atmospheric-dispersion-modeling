//Run to simulate a force moving through a city
public class Main {

	public static void main(String[] args) {
		
		Map city = new Map(5,5);		

		BodyOfWater chesapeake1 = new BodyOfWater();	
		BodyOfWater chesapeake2 = new BodyOfWater();
		BodyOfWater chesapeake3 = new BodyOfWater();
		Nature forest1 = new Nature(50);
		Nature forest8 = new Nature(50);		
		
		Nature forest2 = new Nature(33);
		IndustrialBuilding factory = new IndustrialBuilding(20, 15, 50, 30);
		Nature forest3 = new Nature(29);
		BodyOfWater chesapeake4 = new BodyOfWater();
		BodyOfWater chesapeake9 = new BodyOfWater();		
		
		Nature forest4 = new Nature(40);
		Nature forest5 = new Nature(80);
		Nature forest6 = new Nature(90);
		Nature forest7 = new Nature(85);	
		Nature forest9 = new Nature(85);		
		
		BodyOfWater chesapeake5 = new BodyOfWater();	
		BodyOfWater chesapeake6 = new BodyOfWater();
		BodyOfWater chesapeake7 = new BodyOfWater();		
		BodyOfWater chesapeake8 = new BodyOfWater();	
		BodyOfWater chesapeake10 = new BodyOfWater();			
		
		Highway road = new Highway(1000);
		BodyOfWater pond1 = new BodyOfWater();	
		Building houseSmall = new Building(2, 1, 25);
		Building houseTall = new Building(200, 45, 250);		
		BodyOfWater pond2 = new BodyOfWater();			
		

		city.addTile(chesapeake1);
		city.addTile(chesapeake2);
		city.addTile(chesapeake3);
		city.addTile(forest1);
		city.addTile(forest8);
		
		city.addTile(forest2);		
		city.addTile(factory);
		city.addTile(forest3);
		city.addTile(chesapeake4);
		city.addTile(chesapeake9);
		
		city.addTile(forest4);
		city.addTile(forest5);	
		city.addTile(forest6);
		city.addTile(forest7);	
		city.addTile(forest9);
		
		city.addTile(chesapeake5);
		city.addTile(chesapeake6);
		city.addTile(chesapeake7);
		city.addTile(chesapeake8);
		city.addTile(chesapeake10);	
		
		city.addTile(road);		
		city.addTile(pond1);	
		city.addTile(houseSmall);	
		city.addTile(houseTall);	
		city.addTile(pond2);			
		
		Force smoke = new Force(100,"cruise ship smoke stack");
		
		city.propagate(smoke, 0, 0, Direction.SOUTH);
		System.out.println(city.toString());
	}

}
