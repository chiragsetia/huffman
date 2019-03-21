package huffman;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class MakingTree {

//	public static void main(String[] args) throws IOException {
//		FileImport file=new FileImport();
//		System.out.println((new MakingTree()).mapping(file.frequencyMap("text.txt")));
//	}
	HashMap<Character, String> old2New;
	HashMap<String,Character> new2Old;
	public BothMaps mapping(HashMap<Character, Integer> map) throws IOException {
		if(map.size()==0) {
			return null;
		}
		old2New=new HashMap<>();
		new2Old=new HashMap<>();
		ArrayList<TreeNode> listNode=new ArrayList<>();
		Set<Character> set=map.keySet();
		for(Character i:set) {
			listNode.add(new TreeNode(i,map.get(i)));
		}
		if(listNode.size()==1)
		{
			old2New.put(listNode.get(0).word,"0");
			new2Old.put("0",listNode.get(0).word);
			return new BothMaps(old2New,new2Old);
		}
		while(listNode.size()>1) {
			TreeNode left=listNode.remove(0);
			TreeNode right=listNode.remove(0);
			int sum=left.sum+right.sum;
			TreeNode newNode=new TreeNode('^',sum,left,right);
			int i=0;
			while(i<listNode.size()&&sum>listNode.get(i).sum)
			{
				i++;
			}
			listNode.add(i, newNode);
		}
		mapFromTree(listNode.get(0),"");
		//System.out.println(old2New+"\n"+new2Old);
		return new BothMaps(old2New,new2Old);
		//return null;
	}
	private void mapFromTree(TreeNode treeNode,String pattern) {
		if(treeNode.leaf) {
			old2New.put(treeNode.word,pattern);
			new2Old.put(pattern,treeNode.word);
			return;
		}
		mapFromTree(treeNode.left,pattern+"0");
		mapFromTree(treeNode.right,pattern+"1");
	}
}