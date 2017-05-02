package TheseusAndMinotaur;

public enum Direction {
	UP(0,-1),
	RIGHT(1,0),
	DOWN(0,1),
	LEFT(-1,0),
	NONE(0,0);
	
	public int acrossAdjust;
	public int downAdjust;
	
	private Direction(int across, int down){
		acrossAdjust = across;
		downAdjust = down;
	}
}
