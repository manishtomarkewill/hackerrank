
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
}
public class p104 {
	TreeNode root;
	
	 public static int maxDepth(TreeNode root) {
		 if(root==null)
			 return 0;
		 else if(root.left==null && root.right==null)
			 return 1;
		 else{
			 return Math.max((1+maxDepth(root.left)),1+maxDepth(root.right));
		 }
		 
	    }
	
public static void main(String[] args) {
		p104 tree=new p104();
		tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(9);
        tree.root.left.left = new TreeNode(20);
        tree.root.left.left.left = new TreeNode(15);
        tree.root.left.left.left.left = new TreeNode(7);
		
        System.out.println(maxDepth(tree.root));
	}

}
