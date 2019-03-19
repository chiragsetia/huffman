package huffman;

import java.io.FileNotFoundException; 
import java.io.FileReader; 
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class FileImport {
	private HashMap<Character, Integer> map;
	FileImport(){
		map=new HashMap<>();
	}
	public HashMap<Character, Integer> frequencyMap(String fileName) {
		FileReader file=null;
		try {
			
			file=new FileReader(fileName);
			int value;
			while ((value=file.read())!=-1) {
				char ch=(char)value;
				if(map.containsKey(ch)) {
					map.put(ch, map.get(ch)+1);
				}else
				{
					map.put(ch, 1);
				}
			}
			//System.out.println(map);
		}catch(FileNotFoundException e){
			System.out.println("File not found \n"+ e);
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
		map=sortByValue(map);
		return map;
	}
	
	// sorting of hashmap
	private HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> map) {
		// Create a list from elements of HashMap 
		if(map==null)
			return null;
        List<Map.Entry<Character, Integer> > list = 
               new LinkedList<Map.Entry<Character, Integer> >(map.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer> >() { 
            public int compare(Map.Entry<Character, Integer> o1,  
                               Map.Entry<Character, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>(); 
        for (Map.Entry<Character, Integer> value : list) { 
            temp.put(value.getKey(), value.getValue()); 
        } 
        return temp; 
	}
//	public static void main(String args[]) throws IOException {
//		FileImport fileImport =new FileImport();
//		System.out.println(fileImport.frequencyMap("text.txt"));
//	}
}
