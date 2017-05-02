package TheseusAndMinotaur;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LoadGame implements Loader{

	public LoadGame() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void load(Loadable gameLoader, String filename) {
		File file = new File(filename);
		Map<String, String[]> levelMap = this.fileLoad(file);
			
		for (Entry<String, String[]> entry : levelMap.entrySet()) {
			String key = entry.getKey();
			String[] value = entry.getValue();
		 	this.addWallsPlayers(key, value, gameLoader);
		 }
	}
	
	private Map<String, String[]> fileLoad(File file){
		
		StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String text = null;

            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {
                contents.append(text);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String contentString = contents.toString();
        return this.splitMap(contentString);
	}
	
	private Map<String, String[]> splitMap(String contents){
		Map<String, String[]> level = new HashMap<String, String[]>();
		
		String cleanCon = contents.replace(":", "");
		String[] lines = cleanCon.split(";");
		
		for(String line : lines){
			String key = line.split("=")[0];
			String[] value = line.split("=")[1].split(",");
			level.put(key, value);
		}	
	    return level;
	}
	
	private void addWallsPlayers(String key, String[] value, Loadable gameLoader){
		if(key.contains("U")){
			gameLoader.setDepthDown(value.length);
			for(int i = 0; i < value.length; i++){
				for(int j = 0; j < value[0].length(); j++){
					char curr = value[i].charAt(j);
					if(curr == 'x'){
						Point currPos = new PointImpl(i, j);
						gameLoader.addWallAbove(currPos);
					}
				}	
			}
		}
		
		if(key.contains("L")){
			gameLoader.setWidthAcross(value.length);

			for(int i = 0; i < value[0].length(); i++){
				for(int j = 0; j < value.length; j++){
					char curr = value[j].charAt(i);
					if(curr == 'x'){
						Point currPos = new PointImpl(j, i);
						gameLoader.addWallLeft(currPos);
					}
				}
			}	
		}
		
		if (key.contains("M")){
			int x = Integer.parseInt(value[0]);
			int y = Integer.parseInt(value[1]);
			
			Point MinPos = new PointImpl(x,y);
			gameLoader.addMinotaur(MinPos);
		}
		
		if (key.contains("T")){
			int x = Integer.parseInt(value[0]);
			int y = Integer.parseInt(value[1]);
			
			Point ThesPos = new PointImpl(x,y);
			gameLoader.addTheseus(ThesPos);

		}
		
		if (key.contains("E")){
			int x = Integer.parseInt(value[0]);
			int y = Integer.parseInt(value[1]);
			
			Point ExitPos = new PointImpl(x,y);
			gameLoader.addExit(ExitPos);

		}
	}	

}
