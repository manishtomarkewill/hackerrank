import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanEncoder {
	
	final static int count[]=new int[256];
	
		//Encoding method
		public static EncodedResult encoding(String str){
			//int count[]=frequency(str);
			//Node rootNode=buildHuffmanTree(count);
			//final Map<Character,String> map=buildTable(rootNode);
			//decode(new EncodedResult(generateBinaryData(str,map),rootNode));
			//return new EncodedResult(generateBinaryData(str,map),rootNode);
			return null;
		}
		
		static class EncodedResult{
			final Node root;
			final String encodedBinaryData;
			public EncodedResult(String encodeBinaryData,Node root){
				this.root=root;
				this.encodedBinaryData=encodeBinaryData;
			}
			public Node getRoot(){
				return this.root;
			}
			public String getEncodedBinaryData(){
				return this.encodedBinaryData;
			}
		}
		
		//methods to generate Binary Data
		private static  String generateBinaryData(String str, Map<Character, String> map) {
			final StringBuilder sb=new StringBuilder();
			for(final char character:str.toCharArray()){
				sb.append(map.get(character));
			}
			System.out.print("Encoded result for String "+str+" is "+sb.toString());
			try {
				PrintWriter output=new PrintWriter(new File("EncodedOutput.txt"));
				output.println("Output    "+sb);
				output.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			return sb.toString();
		}
		
		private static Map<Character,String> buildTable(Node rootNode){
			Map<Character,String> hm=new HashMap<>();
			buildTableImpl(rootNode,"",hm);
			for(Entry<Character, String> map:hm.entrySet()){
				System.out.println(map.getKey()+" "+map.getValue());
			}
			return hm;
		}
		private static void buildTableImpl(Node node, String string, Map<Character, String> hm) {
			if(!node.isNodeLeaf()){
				buildTableImpl(node.leftChild,string+'0',hm);	
				buildTableImpl(node.rightChild,string+'1',hm);
			}else{
				hm.put(node.character,string);
			}
		}
	
	//method to count the frequencies of the input stream
	public static int[] frequency(String str){
		for(int i=0;i<str.length();i++){
			count[str.charAt(i)]++;
		}
		for(int j=0;j<count.length;j++){
			if(count[j]>0)
				System.out.printf("%c, count = %d \n", j, count[j]);
		}
		return count;
	}
	//Building the Huffman Tree
	private static Node buildHuffmanTree(final int []count){
		PriorityQueue<Node> pq=new PriorityQueue<>();
		for(char i=0;i<256;i++){
			if(count[i]>0)
				pq.add(new Node(i,count[i],null,null));
		}
		if(pq.size()==1){
			pq.add(new Node('\0',1,null,null));
		}
		while(pq.size()>1){
			Node left=pq.poll();
			Node right=pq.poll();
			Node parent=new Node('\0',left.count+right.count,left,right);
			pq.add(parent);
		}
		return pq.poll();
	}
	
	public static String decode(final EncodedResult result){
		final StringBuilder decoded=new StringBuilder();
		Node node=result.getRoot();
		for(int i=0;i<result.getEncodedBinaryData().length();){
			while(!node.isNodeLeaf()){
				char bit=result.getEncodedBinaryData().charAt(i);
				if(bit=='1'){
					node=node.rightChild;
				}else if(bit=='0'){
					node=node.leftChild;
				}
				i++;
			}
			decoded.append(node.character);
			node=result.getRoot();
		}
		try {
			PrintWriter output=new PrintWriter(new File("DecodedOutput.txt"));
			output.println("Output  "+decoded.toString());
			output.close();
			System.out.println("");
			System.out.println("Decoded  "+decoded.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return decoded.toString();
	}
	//Node class with its attributes
	static class Node implements Comparable<Node>{
		private char character;
		private int count;
		private  Node leftChild;
		private  Node rightChild;
		
		public  Node(char character,int count, Node leftChild, Node rightChild){
			this.character=character;
			this.count=count;
			this.leftChild=leftChild;
			this.rightChild=rightChild;
		}
		
		boolean isNodeLeaf(){
			return (this.leftChild==null && this.rightChild==null);
		}

		@Override
		public int compareTo(Node o) {
			int comparison=Integer.compare(this.count, o.count);
			if(comparison!=0)
				return comparison;
			return Integer.compare(this.character, o.character);
		}
	}

	public static void main(String[] args) {
		String str="aaaaaaabbbbbbcccccddddeeeffgx";
		/*try {
			Scanner sc= new Scanner(new File("Dictionary.txt"));
			while(sc.hasNextLine()){
				str=str+sc.nextLine()+ " ";
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		
		//final int [] freq=frequency(str);
		//Node node=buildHuffmanTree(freq);
		//Map<Character,String> map=buildTable(node);
		//System.out.println(node);
		encoding(str);
		int count[]=frequency(str);
		Node rootNode=buildHuffmanTree(count);
		final Map<Character,String> map=buildTable(rootNode);
		decode(new EncodedResult(generateBinaryData(str,map),rootNode));
	}

}
