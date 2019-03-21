package huffman;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		//System.out.print((int)'¿');
		try {
			BothMaps result=(new MakingTree().mapping((new FileImport().frequencyMap("text.txt"))));
			new Encoding().reducedSizeFile("text.txt", "output",result.old2New);
			new Decoding().fileBack("output","orginal.txt", result.new2Old);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
