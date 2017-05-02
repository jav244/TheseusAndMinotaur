package TheseusAndMinotaur;

public class PointImpl implements Point {

	private int across;
	private int down;
	
	public PointImpl(int across, int down) {
		this.across = across;
		this.down = down;
	}

	@Override
	public int across() {
		return across;
	}

	@Override
	public int down() {
		return down;
	}

}
