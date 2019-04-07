package huffman;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		//System.out.print((int)'¿');
		try {
			BothMaps result=(new MakingTree().mapping((new FileImport().frequencyMap("text.txt"))));
			System.out.println(result.new2Old);
			new HashTable(result.new2Old);
			new Encoding().reducedSizeFile("text.txt", "output",result.old2New);
			new Decoding().fileBack("output","orginal.txt");
			System.out.println("done");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
