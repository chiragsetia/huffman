package huffman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Decoding {

	public static void main(String[] args) {
		System.out.println();
	}
	public void fileBack(String reducedFile,String orginal,HashMap<String, Character> map) {
		FileReader input=null;
		FileWriter output=null;
		try {
			input=new FileReader(reducedFile+".bin");
			output=new FileWriter(orginal);
			int value;
			String s1="";
			while ((value=input.read())!=-1) {
				char ch=(char)value;
				s1+=ch;
				if(map.containsKey(s1)) {
					output.write(map.get(s1));
					s1="";
				}
			}
			
		}catch(FileNotFoundException e){
			System.out.println("File not found \n"+ e);
		} catch (IOException e) {
			
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
