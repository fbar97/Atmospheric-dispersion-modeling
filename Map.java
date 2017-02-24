
import java.util.ArrayList;

public class Map {
	private Tile[][] map; 
	private int freeRow = 0;
	private int freeColumn = 0;  

	public Map(int height, int width) {
		this.map = new Tile[width][height];
	}

	public boolean addTile(Tile tile) {
		/*
		 * Adds the incoming tile to the next free location (starting in the top
		 * left corner and filling up each row before moving to the next one),
		 * If the map is already full, this method returns false, otherwise if it
		 * successfully placed the tile, it returns true.
		 */

		if (this.freeRow < this.map.length && this.freeColumn < this.map[freeRow].length) {
			this.map[freeRow][freeColumn] = tile;
			tile.setRow(freeRow);
			tile.setColumn(freeColumn);
			if (this.freeColumn == this.map[0].length - 1) {
				this.freeRow++;
				this.freeColumn = -1;
			}

			this.freeColumn++;
			return true;
		}
		return false;

	}

	public Tile getTile(int row, int col) {

		return this.map[row][col];
	}

	public Tile[] getNeighbors(Tile tile, Direction direction) {
		/*
		 * This returns an array of all the neighbors of the tile in the
		 * direction specified; a direction can return up to three neighboring
		 * tiles. Any tile that is touching the incoming tile in at least one
		 * point in the direction specified is considered a neighbor.
		 */
		ArrayList<Tile> neighbors = new ArrayList<Tile>();
		int startR = tile.getRow();
		int startC = tile.getColumn();
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map[i].length; j++) {
				switch (direction) {
				case EAST:
					if (this.map[i][j] != null
							&& (this.map[i][j].getRow() == startR || this.map[i][j].getRow() == startR + 1
									|| this.map[i][j].getRow() == startR - 1)
							&& (this.map[i][j].getColumn() == startC + 1) && (neighbors.size() < 3)) {
						neighbors.add(this.map[i][j]);
					}
					break;
				case SOUTH:

					if (this.map[i][j] != null
							&& (this.map[i][j].getRow() == startR + 1) && (this.map[i][j].getColumn() == startC - 1
									|| this.map[i][j].getColumn() == startC || this.map[i][j].getColumn() == startC + 1)
							&& (neighbors.size() < 3)) {
						neighbors.add(this.map[i][j]);

					}

					break;
				case WEST:
					if (this.map[i][j] != null
							&& this.map[i][j].getColumn() == startC - 1 && (this.map[i][j].getRow() == startR
									|| this.map[i][j].getRow() == startR - 1 || this.map[i][j].getRow() == startR + 1)
							&& (neighbors.size() < 3)) {
						neighbors.add(this.map[i][j]);
					}
					break;
				case NORTH:
					if (this.map[i][j] != null
							&& (this.map[i][j].getRow() == startR - 1) && (this.map[i][j].getColumn() == startC - 1
									|| this.map[i][j].getColumn() == startC || this.map[i][j].getColumn() == startC + 1)
							&& (neighbors.size() < 3)) {
						neighbors.add(this.map[i][j]);
					}

					break;
				}
			}
		}

		Tile[] neigh = new Tile[neighbors.size()];
		return (Tile[]) (neighbors.toArray(neigh));

	}

	public void propagate(Force force, int row, int column, Direction direction) {
		//propogates the force in the direction specified until the end of the map
		Tile tile = getTile(row, column);
		Force weaken = tile.weaken(force);
		Force strengthen = tile.strengthen(force);
		tile.setMeasurement((strengthen.getLoad() + weaken.getLoad()) / 2);
		Tile[] neighbors = getNeighbors(tile, direction);
		force.setLoad((strengthen.getLoad() + weaken.getLoad()) / 2);

		for (int i = 0; i < neighbors.length; i++)
			propagate(force, neighbors[i].getRow(), neighbors[i].getColumn(), direction);
	}

	@Override
	public String toString() {
		String map = "";
		for (int i = 0; i < this.map.length; i++) {
			for (int j = 0; j < this.map.length; j++) {
				String string = this.map[i][j].getClass() + " ";
				if (this.map[i][j].getMeasurement() != null) {
					string += this.map[i][j].getMeasurement();
					string = String.format("%0$-32s", string);
				} else {
					string += "0";
					string = String.format("%0$-32s", string);
				}
				map += string;
			}
			map += "\n";
		}
		return map;
	}

}
