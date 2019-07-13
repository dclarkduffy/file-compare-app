import java.io.File;
import java.util.ArrayList;
import java.io.*;

public class FileCompare {
	static int fileCount = 0;
	static ArrayList<File> files = new ArrayList<File>();
	static ArrayList<ArrayList<String>> fileContents = new ArrayList<ArrayList<String>>();
	
	private static String line;
	private static FileReader fileReader;
	private static BufferedReader bufferedReader;
	
	public static void addFile(File file) {
		files.add(file);
		fileCount++;
	}
	
	public static void removeFile(File file) {
		files.remove(file);
		for(File f : files) {
			System.out.println(f.getName());
		}
	}
	
	public static int getFileCount() {
		return files.size();
	}
	
	public static ArrayList<File> getFileList() {
		return files;
	}
	
	public static void addFileContentsToList() {
		int index = 0;
		for(File file : files) {
			try {
				fileReader = new FileReader(file.getPath());
				bufferedReader = new BufferedReader(fileReader);
				fileContents.add(new ArrayList<String>());
				while((line = bufferedReader.readLine()) != null) {
			        fileContents.get(index).add(line);
				}
				bufferedReader.close();
				index++;
			}catch(FileNotFoundException ex) {
				System.out.println("Unable to open file '" + file.getName() + "'"); 
				ex.printStackTrace();
			} catch(IOException ex) {
		        System.out.println("Error reading file '" + file.getName() + "'");                  
		            // Or we could just do this: 
		            // ex.printStackTrace();
		    }
		}
	}
	
	public static void runComparison() {
		try {
			addFileContentsToList();
			for(int i = 0; i < fileContents.size(); i++) {
				System.out.println("File: " + i);
				for(int j = 0; j < fileContents.get(i).size(); j++) {
					System.out.println(fileContents.get(i).get(j));
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}