package huffman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Encoding {

//	public static void main(String[] args) throws IOException {
//		FileImport file=new FileImport();
//		reduceSizeFile("text.txt",(new MakingTree()).mapping(file.frequencyMap("text.txt")));
//	}
	public  void reducedSizeFile(String inputFile,String outputFile, HashMap<Character,String> map) {
		FileReader input=null;
		FileWriter output=null;
		try {
			input=new FileReader(inputFile);
			output=new FileWriter(outputFile+".bin");
			int value;
			while ((value=input.read())!=-1) {
				char ch=(char)value;
				output.write(map.get(ch));
			}
			
		}catch(FileNotFoundException e){
			System.out.println("File not found \n"+ e);
		} catch (IOException e) {
			System.out.println("Saving output file\n "+e);
			e.printStackTrace();
		}finally {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
