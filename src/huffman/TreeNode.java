package huffman;

public class TreeNode {
	//TreeNode parent;
	TreeNode left;
	TreeNode right;
	char word;
	int sum;
	boolean leaf;
	TreeNode(char word, int sum){
		this.word=word;
		this.sum=sum;
		//parent=null;
		left=null;
		right=null;
		leaf=true;
	}
	TreeNode(char word, int sum, TreeNode left, TreeNode right){
		this.word=word;
		this.sum=sum;
		//parent=null;
		this.left=left;
		this.right=right;
		leaf=false;
	}
}
