package huffman;

import java.util.HashMap;

public class BothMaps {
HashMap<Character, String> old2New;
HashMap<String,Character> new2Old;
BothMaps(HashMap<Character, String> old2New,HashMap<String,Character> new2Old)
{
	this.old2New=old2New;
	this.new2Old=new2Old;
}
}
