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
			output=new FileWriter(outputFile+".txt");
			int value;
			String str="";
			while ((value=input.read())!=-1) {
				char ch=(char)value;
				str+=map.get(ch);
				if(str.length()>=7) {
					output.write((char)Integer.parseInt(str.substring(0, 7), 2));//for coversion of string to int and radix tell use our source base in this case is binary
					str=str.substring(7);
				}
//				while(i<str.length()) {
//					if(str.charAt(i)=='0') {
//						outputwrite(false);
//					}else
//						output.(true);
//					i++;
//				}
////				if(str.length()>=63) {
////					output.write(Compression.string2Long(str.substring(0, 63)));
////					output.write(',');
////					str=str.substring(63);
////				}
////				//output.write();
////			}
////			if(str.length()!=0) {
////				output.write('/');
////				output.write(str);
			}
			if(str.length()!=0) {
				output.write('¿'+str);
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
