package huffman;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.io.File;

public class Decoding {

	public static void main(String[] args) {
		System.out.println();
	}
	public void fileBack(String reducedFile,String orginal,HashMap<String, Character> map) {
		FileReader input=null;
		FileWriter output=null;
		FileWriter temp=null;
		try {
			input=new FileReader(reducedFile+".txt");
			output=new FileWriter(orginal);
			temp=new FileWriter("temp.txt");
			int value;
			String s1="";
			int flag=0;
			//int i=1;
			while ((value=input.read())!=-1) {
				//System.out.println(i++);
				if(value=='¿') {
					flag=1;
				}else if(flag==1) {
					s1+=(value-'0');
				}else {
					s1+=binaryStringForm(value);
				}
				temp.write(s1);
				s1="";
			}
			input.close();
			temp.close();
			input=new FileReader("temp.txt");
			//System.out.println(value);
			while ((value=input.read())!=-1) {
				s1+=(char)(value);
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
			File file=new File("temp.txt");
			file.delete();
		}
	}
	private String binaryStringForm(int value) {
		String str=Integer.toString(value,2);
		for(int i=str.length();i<7;i++) {
			str='0'+str;
		}
		return str;
	}
}
