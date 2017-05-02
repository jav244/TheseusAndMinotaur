package TheseusAndMinotaur;

public interface Saveable {
	int getWidthAcross();
	int getDepthDown();
	Wall whatsAbove(Point where);
	Wall whatsLeft(Point where);
	Point wheresTheseus();
	Point wheresMinotaur();
	Point wheresExit();
}
