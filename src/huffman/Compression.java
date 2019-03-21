package huffman;

public class Compression {
	public static void main(String args[]) {
		String str="111111111111111111111111111111111111111111111111111111111111111";
		System.out.println(string2Long(str));
	}
	protected static String string2Long(String bytes) {
		long sum=0L;
		for(int i=0;i<63;i++) {
			if((bytes.charAt(i)-'0')==0)
				sum+=0;
			else {
				sum+=(power(i)*(bytes.charAt(i)-'0'));
				//System.out.println((int)(bytes.charAt(i))+" "+i+" "+power(i));
			}
		}
		return Long.toString(sum);
	}
	private static long power(int t) {
		long result=1L;
		long m=2L;
		while(t>0) {
			if(t%2!=0) {
				result*=m;
			}
			t=t/2;
			m=m*m;
		}
		return result;
	}
	protected static String long2String(long t) {
		String str="";
		for(int i=0;i<63;i++) {
			int mod=(int) (t%2);
			str+=Integer.toString(mod);
			t=t/2L;
		}
		return str;
	}
}
