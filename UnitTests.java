import static org.junit.Assert.*; 

import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.InputStreamReader; 
import java.util.ArrayList; 

import org.junit.Test; 


public class UnitTests { 
    private static int passed = 0;     

    @Test 
    public void testModifiable() { 
        Tester t = new Tester(); 
        Force f = new Force(24,"wind"); 
        assertEquals(f,t.strengthen(f)); 
        assertEquals(f,t.weaken(f)); 
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testTile(){ 
        Zone c = new Zone(); 
        Force f = new Force(24,"wind"); 
        c.setColumn(3); 
        assertEquals(3,c.getColumn()); 
        c.setRow(4); 
        assertEquals(4,c.getRow()); 
        assertEquals("row: 4 col: 3",c.toString()); 
        assertEquals(true,c.canPropagate()); 
        c.setMeasurement(100); 
        assertEquals("100",c.getMeasurement()); 
        assertEquals("wind has a load of 19",c.weaken(f).toString()); 
        assertEquals(24,f.getLoad(),0.0001); 
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testBuilding(){ 
        Building b = new Building(1,5,10); 
        assertEquals(1,b.getPeople()); 
        assertEquals(5,b.getCars()); 
        assertEquals(10,b.getHeight()); 
        assertEquals(true,b.canPropagate()); 
        b.setHeight(100); 
        assertEquals(false,b.canPropagate()); 
         
        Force force = new Force(100,"force"); 
        assertEquals("force has a load of 127",b.strengthen(force).toString()); 
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testHighway(){ 
        Highway c = new Highway(35); 
        Force f = new Force(24,"wind"); 
        c.setColumn(3); 
        assertEquals(3,c.getColumn()); 
        c.setRow(4); 
        assertEquals(4,c.getRow()); 
        assertEquals("row: 4 col: 3",c.toString()); 
        assertEquals(true,c.canPropagate()); 
        c.setMeasurement(100); 
        assertEquals("100",c.getMeasurement()); 
        assertEquals("wind has a load of 19",c.weaken(f).toString()); 
        assertEquals(24,f.getLoad(),0.0001);         
         
        Force force = new Force(100,"force"); 
        assertEquals("force has a load of 275",c.strengthen(force).toString());         
        assertNotEquals(0,++passed);         
    } 
     
    @Test 
    public void testIndustrialBuilding(){ 
        IndustrialBuilding b = new IndustrialBuilding(1,2,3,4); 
        assertEquals(1,b.getPeople()); 
        assertEquals(2,b.getCars()); 
        assertEquals(3,b.getHeight()); 
        assertEquals(true,b.canPropagate()); 
        b.setHeight(100); 
        assertEquals(true,b.canPropagate()); 
         
        Force force = new Force(100,"force"); 
        assertEquals("force has a load of 152",b.strengthen(force).toString());     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testBodyOfWater(){ 
        BodyOfWater c = new BodyOfWater(); 
        Force f = new Force(24,"wind"); 
        c.setColumn(3); 
        assertEquals(3,c.getColumn()); 
        c.setRow(4); 
        assertEquals(4,c.getRow()); 
        assertEquals("row: 4 col: 3",c.toString()); 
        assertEquals(true,c.canPropagate()); 
        c.setMeasurement(100); 
        assertEquals("100",c.getMeasurement()); 
        assertEquals("wind has a load of 19",c.weaken(f).toString()); 
        assertEquals(24,f.getLoad(),0.0001);     
         
        f = new Force(100,"wind"); 
        Force result = c.strengthen(f); 
        assertEquals(f.getLoad(),result.getLoad(), 0.001); 
        result = c.weaken(f); 
        assertEquals(80,result.getLoad(), 0.001);     
        assertNotEquals(0,++passed);         
    }     
     
    @Test 
    public void testNature(){ 
        Nature c = new Nature(33); 
        Force f = new Force(24,"wind"); 
        c.setColumn(3); 
        assertEquals(3,c.getColumn()); 
        c.setRow(4); 
        assertEquals(4,c.getRow()); 
        assertEquals("row: 4 col: 3",c.toString()); 
        assertEquals(true,c.canPropagate()); 
        c.setMeasurement(100); 
        assertEquals("100",c.getMeasurement()); 
        assertEquals("wind has a load of 16",c.weaken(f).toString()); 
        assertEquals(24,f.getLoad(),0.0001);     
         
        c = new Nature(51); 
        assertEquals("wind has a load of 12",c.weaken(f).toString());         
        assertEquals(false,c.canPropagate());         
         
        f = new Force(100,"wind"); 
        Force result = c.strengthen(f); 
        assertEquals(f.getLoad(),result.getLoad(), 0.001); 
        result = c.weaken(f); 
        assertEquals(49,result.getLoad(), 0.001);         
        assertNotEquals(0,++passed);         
    }         
     

    @Test 
    public void testMap1(){ 
        Map map = new Map(2,3); 
         
        BodyOfWater tile1 = new BodyOfWater();     
        BodyOfWater tile2 = new BodyOfWater(); 
        BodyOfWater tile3 = new BodyOfWater(); 
        Nature tile4 = new Nature(50); 
        Nature tile5 = new Nature(50);                 
        Nature tile6 = new Nature(33); 
         
        map.addTile(tile1); 
        assertEquals(tile1,map.getTile(0, 0)); 
        map.addTile(tile2); 
        assertEquals(tile2,map.getTile(0, 1));         
        map.addTile(tile3); 
        assertEquals(tile3,map.getTile(1, 0));     
        map.addTile(tile4); 
        assertEquals(tile4,map.getTile(1, 1));         
        map.addTile(tile5); 
        assertEquals(tile5,map.getTile(2, 0));     
        assertEquals(null,map.getTile(2, 1));     
         
        assertEquals(tile2,map.getNeighbors(tile1,Direction.EAST)[0]); 
        assertEquals(tile4,map.getNeighbors(tile1,Direction.EAST)[1]); 
        assertEquals(2,map.getNeighbors(tile1,Direction.EAST).length);                 
         
        assertEquals(tile3,map.getNeighbors(tile1,Direction.SOUTH)[0]); 
        assertEquals(tile4,map.getNeighbors(tile1,Direction.SOUTH)[1]);         
        assertEquals(2,map.getNeighbors(tile1,Direction.SOUTH).length);         
         
        assertEquals(0,map.getNeighbors(tile1,Direction.WEST).length);         
        assertEquals(0,map.getNeighbors(tile1,Direction.NORTH).length);             
         
        map.addTile(tile6);         
        assertEquals(tile3,map.getNeighbors(tile2,Direction.SOUTH)[0]); 
        assertEquals(tile4,map.getNeighbors(tile2,Direction.SOUTH)[1]); 
        assertEquals(2,map.getNeighbors(tile1,Direction.SOUTH).length);         
         
        assertNotEquals(0,++passed);         
                 
    } 
     
    @Test 
    public void testMap2(){ 
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
        assertEquals("class BodyOfWater 90            class BodyOfWater 0             class BodyOfWater 0             class Nature 0                 class Nature 0                 \nclass Nature 75                 class IndustrialBuilding 3161 class Nature 0                 class BodyOfWater 0             class BodyOfWater 0             \nclass Nature 2529             class Nature 2829             class Nature 1927             class Nature 0                 class Nature 0                 \nclass BodyOfWater 2546         class BodyOfWater 1735         class BodyOfWater 2965         class BodyOfWater 2230         class BodyOfWater 0             \nclass Highway 4061             class BodyOfWater 2668         class Building 2012             class Building 2123             class BodyOfWater 1911         \n",city.toString()); 
        assertNotEquals(0,++passed); 
    } 
     

    public class Zone extends Tile{ 

        @Override 
        public Force strengthen(Force f) { 
            return null; 
        } 

        @Override 
        public boolean canPropagate() { 
            return true; 
        } 
    }     
     
     
} 
