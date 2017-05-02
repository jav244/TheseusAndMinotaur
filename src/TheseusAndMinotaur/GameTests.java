package TheseusAndMinotaur;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.runners.MethodSorters;
import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GameTests {

	public Moveable game;
	public Loadable gameLoader;
	public Saveable gameSaver;
	public Loader gameLoad;
	public Saver gameSave;
	
	@Before
	public void setup() {
		game = new Game(new LoadGame(), new SaveGame());
		gameLoader = (Loadable)game;
		gameSaver = (Saveable)game;
		gameLoad = (Loader)game;
		gameSave = (Saver)game;
		
		gameLoader.setWidthAcross(7);
		gameLoader.setDepthDown(7);
//		for (int i = 0; i < gameSaver.getWidthAcross(); i++) {
//			PointImpl point = new PointImpl(i, 0);
//			gameLoader.addWallAbove(point);
//		}
//		for (int j = 0; j < gameSaver.getDepthDown(); j++) {
//			PointImpl point = new PointImpl(0, j);
//			gameLoader.addWallLeft(point);
//		}
//		for (int k = 0; k < gameSaver.getWidthAcross(); k++) {
//			PointImpl point = new PointImpl(k, gameSaver.getDepthDown() - 1);
//			gameLoader.addWallAbove(point);
//		}
//		for (int l = 0; l < gameSaver.getDepthDown(); l++) {
//			PointImpl point = new PointImpl(gameSaver.getWidthAcross() - 1, l);
//			gameLoader.addWallLeft(point);
//		}
	}
	
	@Test
	public void test01_checkHeight() {				
		int expected = 7;
		int actual = gameSaver.getDepthDown();	
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test02_checkWidth() {				
		int expected = 7;
		int actual = gameSaver.getWidthAcross();	
		
		assertEquals(expected, actual);
	}
	
	
	// 1. up 1
	@Test
	public void test03_moveMinotaurUp_oneSpaceBetween_upTwo_theseusDead() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 1);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(3, 1);
		Point actual = gameSaver.wheresMinotaur();	
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());

	}
	

	// 2. up 2
	@Test
	public void test04_moveMinotaurUp_twoSpacesBetween_upTwo() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 0);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(3, 1);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 3. up 3
	@Test
	public void test05_moveMinotaurUp_threeSpacesBetween_upTwo() {
		Point whereMin = new PointImpl(3, 4);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 0);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(3, 2);
		Point actual = gameSaver.wheresMinotaur();
		
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 4. right 1
	@Test
	public void test06_moveMinotaurRight_oneSpaceBetween_rightTwo_theseusDead() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(5, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(5, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
		
	}
	
	// 5. right 2
	@Test
	public void test07_moveMinotaurRight_twoSpacesBetween_rightTwo() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(6, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();
				
		Point expected = new PointImpl(5, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 5. a) right 2 
	@Test
	public void test08_moveMinotaur_rightTwice_0_5() {
		Point whereMin = new PointImpl(0, 5);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(2, 4);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();		
		
		Point expected = new PointImpl(2, 5);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 6. right 3
	@Test
	public void test09_moveMinotaurRight_threeSpacesBetween_rightTwo() {
		Point whereMin = new PointImpl(2, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(6, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();		
		
		Point expected = new PointImpl(4, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());

	}
	
	// 7. down 1
	@Test
	public void test10_moveMinotaurDown_oneSpaceBetween_downTwo_theseusDead() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 5);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();		
		
		Point expected = new PointImpl(3, 5);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 8. down 2
	@Test
	public void test11_moveMinotaurDown_twoSpacesBetween_downTwo() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 6);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();

		Point expected = new PointImpl(3, 5);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 9. down 3
	@Test
	public void test12_moveMinotaurDown_threeSpacesBetween_downTwo() {
		Point whereMin = new PointImpl(3, 2);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 6);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();

		Point expected = new PointImpl(3, 4);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 10. left 1
	@Test
	public void test13_moveMinotaurLeft_oneSpaceBetween_leftTwo_theseusDead() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(1, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 11. left 2
	@Test
	public void test14_moveMinotaurLeft_twoSpacesBetween_leftTwo() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(0, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(1, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 12. left 3
	@Test
	public void test15_moveMinotaurLeft_threeSpacesBetween_leftTwo() {
		Point whereMin = new PointImpl(4, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(0, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(2, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	/*
	 * Using walls
	 */
	
	// 13. up 1 with wall
	@Test
	public void test16_moveMinotaurUp_oneSpaceBetweenButWall_upNone() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 1);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 3);
		gameLoader.addWallAbove(whereWall);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 14. up 2 with wall
	@Test
	public void test17_moveMinotaurUp_twoSpacesBetweenButWall_upOne() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 0);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 2);
		gameLoader.addWallAbove(whereWall);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(3, 2);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 15. up 3 with wall
	@Test
	public void test18_moveMinotaurUp_threeSpacesBetweenButWall_upTwo() {
		Point whereMin = new PointImpl(3, 4);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 0);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 2);
		gameLoader.addWallAbove(whereWall);
		
		
		game.moveMinotaur();

		
		Point expected = new PointImpl(3, 2);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());assertEquals(expected.down(), actual.down());
	}
	
	// 16. right 1 with wall
	@Test
	public void test19_moveMinotaurRight_oneSpaceBetweenButWall_rightNone() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(5, 3);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(4, 3);
		gameLoader.addWallLeft(whereWall);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 17. right 2 with wall
	@Test
	public void test20_moveMinotaurRight_oneSpaceBetweenButWall_rightOne() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(6, 3);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(5, 3);
		gameLoader.addWallLeft(whereWall);
		
		
		game.moveMinotaur();

		
		Point expected = new PointImpl(4, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 18. right 3 with wall
	@Test
	public void test21_moveMinotaurRight_oneSpaceBetweenButWall_rightTwo() {
		Point whereMin = new PointImpl(2, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(6, 3);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(5, 3);
		gameLoader.addWallLeft(whereWall);
		
		
		game.moveMinotaur();

		
		Point expected = new PointImpl(4, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 19. down 1 with wall
	@Test
	public void test22_moveMinotaurDown_oneSpaceBetweenButWall_downNone() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 5);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 4);
		gameLoader.addWallAbove(whereWall);
		
		
		game.moveMinotaur();

		
		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 20. down 2 with wall
	@Test
	public void test23_moveMinotaurDown_twoSpaceBetweenButWall_downOne() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 6);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 5);
		gameLoader.addWallAbove(whereWall);
		
		
		game.moveMinotaur();

		
		Point expected = new PointImpl(3, 4);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 21. down 3 with wall
	@Test
	public void test24_moveMinotaurDown_threeSpaceBetweenButWall_downTwo() {
		Point whereMin = new PointImpl(3, 2);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 6);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 5);
		gameLoader.addWallAbove(whereWall);
		
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(3, 4);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 22. left 1 with wall
	@Test
	public void test25_moveMinotaurDown_oneSpaceBetweenButWall_leftNone() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 3);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 3);
		gameLoader.addWallLeft(whereWall);
				
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 23. left 2 with wall
	@Test
	public void test26_moveMinotaurDown_twoSpacesBetweenButWall_leftOne() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(0, 3);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(2, 3);
		gameLoader.addWallLeft(whereWall);
		
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(2, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 24. left 3 with wall
	@Test
	public void test27_moveMinotaurDown_threeSpacesBetweenButWall_leftTwo() {
		Point whereMin = new PointImpl(4, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(0, 3);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(2, 3);
		gameLoader.addWallLeft(whereWall);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(2, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 25. no7
	@Test
	public void test28_moveMinotaur_RightDown_wall_downRight() {
		Point whereMin = new PointImpl(0, 0);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(2, 1);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(1, 0);
		gameLoader.addWallLeft(whereWall);
		
		game.moveMinotaur();

		Point expected = new PointImpl(1, 1);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 26. no8
	@Test
	public void test29_moveMinotaur_RightDown_walls_downDown() {
		Point whereMin = new PointImpl(0, 0);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(2, 1);
		gameLoader.addTheseus(whereThes);
		Point whereWall1 = new PointImpl(1, 0);
		gameLoader.addWallLeft(whereWall1);
		Point whereWall2 = new PointImpl(1, 1);
		gameLoader.addWallLeft(whereWall2);
		
				
		game.moveMinotaur();
		
		Point expected = new PointImpl(0, 1);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 27. no9
	@Test
	public void test30_moveMinotaur_RightDown_rightDown() {
		Point whereMin = new PointImpl(0, 0);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 2);
		gameLoader.addTheseus(whereThes);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(1, 1);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 28. no10
	@Test
	public void test31_moveMinotaur_RightDown_wall_rightNone() {
		Point whereMin = new PointImpl(0, 0);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 2);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(1, 1);
		gameLoader.addWallAbove(whereWall);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(1, 0);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 29. no11
	@Test
	public void test32_moveMinotaur_RightDown_wall2_downRight() {
		Point whereMin = new PointImpl(0, 0);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 2);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(1, 0);
		gameLoader.addWallLeft(whereWall);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(1, 1);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 30. no6
	@Test
	public void test33_moveMinotaur_RightDown_wallCorner_rightNone() {
		Point whereMin = new PointImpl(0, 0);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(2, 1);
		gameLoader.addTheseus(whereThes);
		Point whereWall1 = new PointImpl(2, 0);
		gameLoader.addWallLeft(whereWall1);
		Point whereWall2 = new PointImpl(1, 1);
		gameLoader.addWallAbove(whereWall2);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(1, 0);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 31. no12
	@Test
	public void test34_moveMinotaur_RightDown_2walls_downDown() {
		Point whereMin = new PointImpl(0, 0);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 2);
		gameLoader.addTheseus(whereThes);
		Point whereWall1 = new PointImpl(1, 0);
		gameLoader.addWallLeft(whereWall1);
		Point whereWall2 = new PointImpl(1, 1);
		gameLoader.addWallLeft(whereWall2);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(0, 2);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 32. no13
	@Test
	public void test35_moveMinotaur_RightDown_2wallsCorner_downNone() {
		Point whereMin = new PointImpl(0, 0);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 2);
		gameLoader.addTheseus(whereThes);
		Point whereWall1 = new PointImpl(1, 0);
		gameLoader.addWallLeft(whereWall1);
		Point whereWall2 = new PointImpl(1, 1);
		gameLoader.addWallLeft(whereWall2);
		Point whereWall3 = new PointImpl(0, 2);
		gameLoader.addWallAbove(whereWall3);
		
		
		game.moveMinotaur();
		
		Point expected = new PointImpl(0, 1);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}

	/*
	 * DOWN-LEFT M @ 3, 3
	 * 
	 */
	
	// 33. no7
	@Test
	public void test36_moveMinotaur_downLeft_wall_leftDown() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(2, 5);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 4);
		gameLoader.addWallAbove(whereWall);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(2, 4);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 34. no8
	@Test
	public void test37_moveMinotaur_downLeft_2walls_leftNone() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(2, 5);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 4);
		gameLoader.addWallAbove(whereWall);
		Point whereWall2 = new PointImpl(2, 4);
		gameLoader.addWallAbove(whereWall2);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(2, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 35. no9
	@Test
	public void test38_moveMinotaur_downLeft_leftLeft() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 4);
		gameLoader.addTheseus(whereThes);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(1, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 36. no10
	@Test
	public void test39_moveMinotaur_downLeft_wall_leftLeft() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 4);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 4);
		gameLoader.addWallLeft(whereWall);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(1, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 37. no11
	@Test
	public void test40_moveMinotaur_downLeft_wall_leftLeft2() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 4);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 4);
		gameLoader.addWallAbove(whereWall);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(1, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 38. no6
	@Test
	public void test41_moveMinotaur_downLeft_wallCorner_leftLeft() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(2, 5);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 4);
		gameLoader.addWallLeft(whereWall);
		Point whereWall2 = new PointImpl(3, 5);
		gameLoader.addWallAbove(whereWall2);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(2, 4);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 39. no12
	@Test
	public void test42_moveMinotaur_downLeft_2walls_leftLeft() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 4);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(2, 4);
		gameLoader.addWallAbove(whereWall);
		Point whereWall2 = new PointImpl(3, 4);
		gameLoader.addWallAbove(whereWall2);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(1, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// 40. no13
	@Test
	public void test43_moveMinotaur_downLeft_2wallsCorner_leftNone() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(1, 4);
		gameLoader.addTheseus(whereThes);
		Point whereWall0 = new PointImpl(2, 3);
		gameLoader.addWallLeft(whereWall0);
		Point whereWall1 = new PointImpl(2, 4);
		gameLoader.addWallAbove(whereWall1);
		Point whereWall2 = new PointImpl(3, 4);
		gameLoader.addWallAbove(whereWall2);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(2, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	/*
	 * Others
	 */
	
//	@Test
//	public void moveMinotaur_rightTwice_0_6() {
//		Point whereMin = new Point(0, 6);
//		gameLoader.addMinotaur(whereMin);
//		Point whereThes = new Point(1, 4);
//		gameLoader.addTheseus(whereThes);
//		
//		game.moveMinotaur();
//		
//		Point expected = new Point(2, 6);
//		Point actual = gameSaver.wheresMinotaur();
//		
//		assertEquals(expected.across(), actual.across());
//		assertEquals(expected.down(), actual.down());
//	}
	
	// right->up
	@Test
	public void test44_moveMinotaur_rightUp() {
		Point whereMin = new PointImpl(2, 4);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(3, 2);
		gameLoader.addTheseus(whereThes);
		
		game.moveMinotaur();
		

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	// left->up->death
	@Test
	public void test45_moveMinotaur_leftUp_death() {
		Point whereMin = new PointImpl(1, 1);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(0, 0);
		gameLoader.addTheseus(whereThes);
		
		
		game.moveMinotaur();

		Point expected = new PointImpl(0, 0);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test46_moveTheseus_leftOne() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveTheseus(Direction.LEFT);

		Point expected = new PointImpl(2, 3);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test47_moveTheseus_rightOne() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveTheseus(Direction.RIGHT);

		Point expected = new PointImpl(4, 3);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test48_moveTheseus_downOne() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveTheseus(Direction.DOWN);

		Point expected = new PointImpl(3, 4);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test49_moveTheseus_upOne() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveTheseus(Direction.UP);

		Point expected = new PointImpl(3, 2);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test50_moveTheseus_upOneButWall() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 3);
		gameLoader.addWallAbove(whereWall);
		
		game.moveTheseus(Direction.UP);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test51_moveTheseus_leftOneButWall() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 3);
		gameLoader.addWallLeft(whereWall);
		
		game.moveTheseus(Direction.LEFT);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test52_moveTheseus_rightOneButWall() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(4, 3);
		gameLoader.addWallLeft(whereWall);
		
		game.moveTheseus(Direction.RIGHT);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test53_moveTheseus_downOneButWall() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		Point whereWall = new PointImpl(3, 4);
		gameLoader.addWallAbove(whereWall);
		
		game.moveTheseus(Direction.DOWN);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test54_addTwoThes_deleteOldOne() {
		Point whereThes = new PointImpl(4, 4);
		gameLoader.addTheseus(whereThes);

		Point whereThes2 = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes2);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test55_addTwoMin_deleteOldOne() {
		Point whereMin = new PointImpl(4, 4);
		gameLoader.addMinotaur(whereMin);

		Point whereMin2 = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin2);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test56_addTwoExit_deleteOldOne() {
		Point whereExit = new PointImpl(4, 4);
		gameLoader.addExit(whereExit);

		Point whereExit2 = new PointImpl(3, 3);
		gameLoader.addExit(whereExit2);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresExit();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test57_testingFileLoad_minPlace(){
		String filename = "levelDef.txt";
		this.gameLoad.load(gameLoader, filename);
		
		Point expected = new PointImpl(1,0);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test58_testingFileLoad_thesPlace(){
		String filename = "levelDef2.txt";
		this.gameLoad.load(gameLoader, filename);
		
		Point expected = new PointImpl(2,2);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test59_testingFileLoad_exitPlace(){
		String filename = "levelDef3.txt";
		this.gameLoad.load(gameLoader, filename);
		
		Point expected = new PointImpl(4,1);
		Point actual = gameSaver.wheresExit();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test60_testingFileSave(){
		//String fileLoadName = "..\\theseus and minotuar\\levelDef2.txt";
		String fileLoadName = "levelDef2.txt";
		this.gameLoad.load(gameLoader, fileLoadName);
		
		String fileSaveName = "levelSave.txt";
		this.gameSave.save(gameSaver, fileSaveName);
		
//		Point expected = new PointImpl(3,1);
//		Point actual = gameSaver.wheresExit();
//		
//		assertEquals(expected.across(), actual.across());
//		assertEquals(expected.down(), actual.down());
		
	}
	
	@Test
	public void test61_testingFileSave2(){
		gameLoader.setDepthDown(5);
		gameLoader.setWidthAcross(5);
		
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		Point whereMin = new PointImpl(2, 2);
		gameLoader.addMinotaur(whereMin);
//		Point whereExit = new PointImpl(1, 1);
//		gameLoader.addExit(whereExit);
		Point whereWall = new PointImpl(4, 3);
		gameLoader.addWallLeft(whereWall);
		Point whereWall2 = new PointImpl(3, 3);
		gameLoader.addWallAbove(whereWall2);
		
		String fileSaveName = "levelSave2.txt";
		this.gameSave.save(gameSaver, fileSaveName);
		
//		Point expected = new PointImpl(3,1);
//		Point actual = gameSaver.wheresExit();
//		
//		assertEquals(expected.across(), actual.across());
//		assertEquals(expected.down(), actual.down());
		
	}
	
	@Test
	public void test62_moveMinotaur_onToExit_shouldStaySamePos() {
		Point whereMin = new PointImpl(2, 3);
		gameLoader.addMinotaur(whereMin);
		Point whereThes = new PointImpl(2, 0);
		gameLoader.addTheseus(whereThes);
		Point whereExit = new PointImpl(2,1);
		gameLoader.addExit(whereExit);
		
		game.moveMinotaur();

		Point expected = new PointImpl(2, 2);
		Point actual = gameSaver.wheresMinotaur();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test63_moveTheseusNowhere() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		
		game.moveTheseus(Direction.NONE);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(expected.across(), actual.across());
		assertEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test64_deleteOldTheseus() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		
		Point whereThes2 = new PointImpl(4, 4);
		gameLoader.addTheseus(whereThes2);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresTheseus();
		
		assertNotEquals(expected.across(), actual.across());
		assertNotEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test65_deleteOldMinotaur() {
		Point whereMin = new PointImpl(3, 3);
		gameLoader.addMinotaur(whereMin);
		
		Point whereMin2 = new PointImpl(4, 4);
		gameLoader.addMinotaur(whereMin2);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresMinotaur();
		
		assertNotEquals(expected.across(), actual.across());
		assertNotEquals(expected.down(), actual.down());
	}
	
	@Test
	public void test66_deleteOldExit() {
		Point whereExit = new PointImpl(3, 3);
		gameLoader.addExit(whereExit);
		
		Point whereExit2 = new PointImpl(4, 4);
		gameLoader.addExit(whereExit2);

		Point expected = new PointImpl(3, 3);
		Point actual = gameSaver.wheresExit();
		
		assertNotEquals(expected.across(), actual.across());
		assertNotEquals(expected.down(), actual.down());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test67_minimumWidthOf4() {
		gameLoader.setWidthAcross(3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test68_minimumHeightOf4() {
		gameLoader.setDepthDown(3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test69_addMinOutOfGrid() {
		gameLoader.addMinotaur(new PointImpl(9,9));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test70_addTheOutOfGrid() {
		gameLoader.addTheseus(new PointImpl(9,9));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test71_addExitOutOfGrid() {
		gameLoader.addExit(new PointImpl(9,9));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test72_addWallLeftOutOfGrid() {
		gameLoader.addWallLeft(new PointImpl(9,9));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test73_addWallAboveOutOfGrid() {
		gameLoader.addWallAbove(new PointImpl(9,9));
	}

	@Test
	public void test74_moveTheseus_upOneButMinotaur() {
		Point whereThes = new PointImpl(3, 3);
		gameLoader.addTheseus(whereThes);
		
		Point whereMin = new PointImpl(3,2);
		gameLoader.addMinotaur(whereMin);
		
		game.moveTheseus(Direction.UP);

		Point expected = null;
		Point actual = gameSaver.wheresTheseus();
		
		assertEquals(actual, expected);
	}
}
