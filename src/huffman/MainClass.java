package huffman;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(Systen.in);
		System.out.printLn("Enter the name of Input File(with txt extension): ");
		String input=scanner.nextLine();
		System.out.println("Enter the name of compressed file(without extension): ");
		String output=scanner.nextLine();
		System.out.println("Enter the name of decompressed file with extension: ");
		String orginal=scanner.nextLine();
		//System.out.print((int)'¿');
		try {
			BothMaps result=(new MakingTree().mapping((new FileImport().frequencyMap("text.txt"))));
			new Encoding().reducedSizeFile(input, output,result.old2New);
			new Decoding().fileBack(output,orginal, result.new2Old);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
