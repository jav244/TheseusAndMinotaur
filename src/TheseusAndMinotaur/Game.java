package TheseusAndMinotaur;
import java.util.ArrayList;
import java.util.List;

public class Game implements Saveable, Loadable, Moveable, Loader, Saver {

	private int depth = 0;
	private int width = 0;
	private Loader gameLoad;
	private Saver gameSave;
	
	private List<List<Cell>> level = new ArrayList<List<Cell>>();
	
	public Game(Loader gameLoad, Saver gameSave){
		this.gameLoad = gameLoad;
		this.gameSave = gameSave;
	}
	
	private void setLevel(){
		if(this.depth > 0 && this.width > 0){
			this.buildLevel();
		}
	}
	
	private void buildLevel(){
		for( int i = 0; i < depth; i++){
			List<Cell> row = new ArrayList<Cell>();
			for(int j = 0; j < width; j++){
				row.add(new Cell());
			}
			level.add(row);
		}
	}
	
	private Cell getCell(Point where){
		int x = where.across();
		int y = where.down();
		
		List<Cell> row = level.get(y);
		return row.get(x);
	}
	
	private void setCell(Cell cell, Point where){
		int x = where.across();
		int y = where.down();
		
		List<Cell> row = level.get(y);
		row.set(x, cell);
	}
	
	private Point getActor(Actor actor){
		Point place = null;
		
		for(int i = 0; i < this.depth; i ++){
			for(int j = 0; j < this.width; j++){
				Point point = new PointImpl(i, j);
				Cell cell = getCell(point);
				if (cell.actor == actor){
					place = point;
				}
			}
		}
		
		return place;
	}
	
	private Direction findVertical(Point currentThes, Point currentMin){
		Direction result = null;
		int minY = currentMin.down();
		int thesY = currentThes.down();
		
		if(thesY > minY){
			result = Direction.DOWN;
		} 
		else if(thesY < minY){
			result = Direction.UP;
		}
		return result;
	}
	
	private Direction findHorizontal(Point currentThes, Point currentMin){
		Direction result = null;
		int minX = currentMin.across();
		int thesX = currentThes.across();
		
		if(thesX > minX){
			result = Direction.RIGHT;
		} 
		else if(thesX < minX){
			result = Direction.LEFT;
		}
		return result;
	}
	
	private boolean isBlocked(Point curr, Point dest, Direction dir){
		boolean result = false;
		
		Cell destination = this.getCell(dest);
		Cell current = this.getCell(curr);
		
		if(dir == Direction.DOWN){
			if(destination.top == Wall.SOMETHING){
				result = true;
			}
		}
		if(dir == Direction.RIGHT){
			if(destination.left == Wall.SOMETHING){
				result = true;
			}
		}
		if(dir == Direction.LEFT){
			if(current.left == Wall.SOMETHING){
				result = true;
			}
		}
		if(dir == Direction.UP){
			if(current.top == Wall.SOMETHING){
				result = true;
			}
		}
		return result;
	}
	
	private boolean checkWithinGrid(Point where){
		boolean result = true;
		if(where.across() > width){
			result = false;
			throw new IllegalArgumentException("outside of grid width");
		}
		if(where.down() > depth){
			result = false;
			throw new IllegalArgumentException("outside of grid height");
		}
		return result;
	}

	@Override
	public void moveTheseus(Direction direction) {
		Point currentThes = this.wheresTheseus();
		Point destination = new PointImpl(
				currentThes.across() + direction.acrossAdjust, 
				currentThes.down() + direction.downAdjust);
		
		if(!this.isBlocked(currentThes, destination, direction)){
			if(this.getCell(destination).actor == Actor.MINOTAUR){
				this.addEmpty(currentThes);
			}else{
				this.addEmpty(currentThes);
				this.addTheseus(destination);
			}		
		}
	}

	@Override
	public void moveMinotaur() {
		int moves =2;
		while(moves > 0){
			Point currentMin = this.wheresMinotaur();
			Point currentThes = this.wheresTheseus();
			Point destination;
			
			Direction horizontal = this.findHorizontal(currentThes, currentMin);
			Direction vertical = this.findVertical(currentThes, currentMin);	
			
			if(horizontal != null && !this.isBlocked(currentMin, 
					destination = new PointImpl(
							currentMin.across() + horizontal.acrossAdjust, 
							currentMin.down() + horizontal.downAdjust), horizontal) 
					&& this.getCell(destination).actor != Actor.EXIT){
				
				this.addMinotaur(destination);	
				this.addEmpty(currentMin);
			} 
			else if(vertical != null && !this.isBlocked(currentMin,
					destination = new PointImpl(
							currentMin.across() + vertical.acrossAdjust, 
							currentMin.down() + vertical.downAdjust), vertical)
					&& this.getCell(destination).actor != Actor.EXIT){		
				
				this.addMinotaur(destination);
				this.addEmpty(currentMin);
			}
			moves--;
		}
	}

	@Override
	public int setWidthAcross(int widthAcross) {
		if(widthAcross < 4){
			throw new IllegalArgumentException("Minimum width of 4");
		}
		this.width = widthAcross;
		this.setLevel();
		return widthAcross;
	}

	@Override
	public int setDepthDown(int depthDown) {
		if(depthDown < 4){
			throw new IllegalArgumentException("Minimum height of 4");
		}
		this.depth = depthDown;
		this.setLevel();
		return depthDown;
	}
	
	@Override
	public void addWallAbove(Point where) {
		if(this.checkWithinGrid(where)){
			Cell cell = this.getCell(where);
			cell.top = Wall.SOMETHING;
			
			this.setCell(cell, where);
		}
		
	}

	@Override
	public void addWallLeft(Point where) {
		if(this.checkWithinGrid(where)){
			
		}
		Cell cell = this.getCell(where);
		cell.left = Wall.SOMETHING;
		
		this.setCell(cell, where);
	}

	@Override
	public void addTheseus(Point where) {
		if(this.checkWithinGrid(where)){
			Point currentThes = this.getActor(Actor.THESEUS);
			
			if(currentThes != null){
				this.addEmpty(currentThes);
			}
			
			Cell cell = this.getCell(where);
			cell.actor = Actor.THESEUS;
			
			this.setCell(cell, where);
		}
	}

	@Override
	public void addMinotaur(Point where) {
		if(this.checkWithinGrid(where)){
			Point currentMin = this.getActor(Actor.MINOTAUR);
			
			if(currentMin != null){
				this.addEmpty(currentMin);
			}
			
			Cell cell = this.getCell(where);
			cell.actor = Actor.MINOTAUR;
			
			this.setCell(cell, where);
		}	
	}

	@Override
	public void addExit(Point where) {
		if(this.checkWithinGrid(where)){
			Point currentExit = this.getActor(Actor.EXIT);
			
			if(currentExit != null){
				this.addEmpty(currentExit);
			}
			
			Cell cell = this.getCell(where);
			cell.actor = Actor.EXIT;
			
			this.setCell(cell, where);
		}
	}
	
	private void addEmpty(Point where){
		Cell cell = this.getCell(where);
		cell.actor = Actor.NONE;
		
		this.setCell(cell, where);
	}

	@Override
	public int getWidthAcross() {
		return this.width;
	}

	@Override
	public int getDepthDown() {
		return this.depth;
	}

	@Override
	public Wall whatsAbove(Point where) {
		return this.getCell(where).top;
	}

	@Override
	public Wall whatsLeft(Point where) {
		return this.getCell(where).left;
	}

	@Override
	public Point wheresTheseus() {
		 return this.getActor(Actor.THESEUS);
	}

	@Override
	public Point wheresMinotaur() {
		return this.getActor(Actor.MINOTAUR);
	}

	@Override
	public Point wheresExit() {
		return this.getActor(Actor.EXIT);
	}

	@Override
	public void save(Saveable gameSaver) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(Saveable gameSaver, String fileName) {
		this.gameSave.save(gameSaver, fileName);
		
	}

	@Override
	public void save(Saveable gameSaver, String fileName, String levelName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load(Loadable gameLoader, String filename) {
		this.gameLoad.load(gameLoader, filename);	
	}

}
