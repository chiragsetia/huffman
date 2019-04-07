package huffman;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class HashTable {
	public HashTable(HashMap<String, Character> new2Old){
		FileWriter file=null;
		try {
			file=new FileWriter("hashTable.txt");
			Iterator<String> i=new2Old.keySet().iterator();
			while(i.hasNext()) {
				String s=i.next();
				file.write(s+"¿");
				file.write(new2Old.get(s));
				file.write('\n');
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
