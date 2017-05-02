package TheseusAndMinotaur;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class SaveGame implements Saver {
	
	public SaveGame() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save(Saveable gameSaver) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(Saveable gameSaver, String fileName) {
		StringBuilder levelString = new StringBuilder();
		int width = gameSaver.getWidthAcross();
		int depth = gameSaver.getDepthDown();

		levelString.append(wallAbove(width, depth, gameSaver));
		levelString.append(wallLeft(width, depth, gameSaver));
		levelString.append(minLocation(gameSaver));
		levelString.append(thesLocation(gameSaver));
		levelString.append(exitLocation(gameSaver));
		
		try (BufferedWriter bWriter =
				new BufferedWriter(new FileWriter(fileName))) {
			
			bWriter.write(levelString.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
        
		
		//System.out.print(levelString);
	}

	@Override
	public void save(Saveable gameSaver, String fileName, String levelName) {
		// TODO Auto-generated method stub

	}
	
	private String wallAbove(int width, int depth, Saveable gameSaver){
		StringBuilder above = new StringBuilder();
		
		above.append("U=");
		
		for(int i = 0; i < depth; i++){
			for(int j = 0; j < width; j++){
				Point curr = new PointImpl(i,j);
				if(gameSaver.whatsAbove(curr) == Wall.SOMETHING){
					above.append("x");
				}
				else{
					above.append("o");
				}
			}
			if(depth -1 == i){
				above.append(";");
			}
			else{
				above.append(",");
			}
		}
		return above.toString();
	}
	
	private String wallLeft(int width, int depth, Saveable gameSaver){
		StringBuilder left = new StringBuilder();
		
		left.append("L=");
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < depth; j++){
				Point curr = new PointImpl(i,j);
				if(gameSaver.whatsLeft(curr) == Wall.SOMETHING){
					left.append("x");
				}
				else{
					left.append("o");
				}
			}
			if(width -1 == i){
				left.append(";");
			}
			else{
				left.append(",");
			}
		}
		return left.toString();
	}
	
	private String minLocation(Saveable gameSaver){
		StringBuilder min = new StringBuilder();
		
		min.append("M=");	
		Point minLoc = gameSaver.wheresMinotaur();
		
		if(minLoc != null){
			min.append(minLoc.across() + "," + minLoc.down() + ";");
		} else {
			min.append(0 + "," + 0 + ";");
		}

		return min.toString();
	}
	
	private String thesLocation(Saveable gameSaver){
		StringBuilder thes = new StringBuilder();
		
		thes.append("T=");
		Point thesLoc = gameSaver.wheresTheseus();

		if(thesLoc != null){
			thes.append(thesLoc.across() + "," + thesLoc.down() + ";");
		} else {
			thes.append(0 + "," + 0 + ";");
		}

		return thes.toString();
	}
	
	private String exitLocation(Saveable gameSaver){
		StringBuilder exit = new StringBuilder();
		
		exit.append("E=");
		Point exitLoc = gameSaver.wheresExit();
				
		if(exitLoc != null){
			exit.append(exitLoc.across() + "," + exitLoc.down() + ":");
		} else {
			exit.append(0 + "," + 0 + ":");
		}
		

		return exit.toString();
	}

}
