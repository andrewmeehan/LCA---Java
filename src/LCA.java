
import java.util.ArrayList;
import java.util.List;

class Node {
	int val;
	Node left, right;
	
	Node(int value){
		val=value;
		left=null;
		left=right;
	}
}

public class LCA {
	Node root;
	private List<Integer> leftPath = new ArrayList<>();
	private List<Integer> rightPath = new ArrayList<>();
	
	//clears left and right paths for Q, calls LCA function
	int findLowestCommonAncestor(int descendant1, int descendant2) {
		if(!leftPath.isEmpty()) {
			leftPath.clear();
		}if(!rightPath.isEmpty()) {
			rightPath.clear();
		}return findLowestCommonAncestor(root, descendant1, descendant2);
	}
	
	private int findLowestCommonAncestor(Node root, int descendant1, int descendant2) {
		
		if (!findPath(root, descendant1, leftPath) || !findPath(root, descendant2, rightPath)) { 
            System.out.println((leftPath.size() > 0) ? "descendant 1 is present" : "descendant 1 is missing"); 
            System.out.println((rightPath.size() > 0) ? "descendant 2 is present" : "descendant 2 is missing"); 
            return -1; 
        } 
  
        int i; 
        for (i = 0; i < leftPath.size() && i < rightPath.size(); i++) { 
            if (!leftPath.get(i).equals(rightPath.get(i))) 
                break; 
        } 
  
        return leftPath.get(i-1); 
    } 
      
    // Finds the path from root node to given root, stores path in list path[], returns true if path exists, otherwise falses   
    private boolean findPath(Node root, int n, List<Integer> path) { 
        if (root == null) { 
            return false; 
        } 
        
        path.add(root.val); 		//will remove root if not in path 
  
        if (root.val == n) { 
            return true; 
        } 
  
        if (root.left != null && findPath(root.left, n, path)) { 
            return true; 
        } 
  
        if (root.right != null && findPath(root.right, n, path)) { 
            return true; 
        } 
        
        path.remove(path.size()-1); //removing root if not needed
  
        return false; 
    } 
  
    
    public static void main(String[] args) 
    { 
        LCA tree = new LCA(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.right.left = new Node(4);
        tree.root.left.right = tree.root.right.left;
        tree.root.right.left.right = new Node(5);
        
  
        System.out.println("LCA(4, 1): " + tree.findLowestCommonAncestor(10,15)); 
        System.out.println("LCA(3, 2): " + tree.findLowestCommonAncestor(8,11)); 
        System.out.println("LCA(3, 5): " + tree.findLowestCommonAncestor(3,8)); 
        System.out.println("LCA(4, 3): " + tree.findLowestCommonAncestor(12,14)); 
      
    } 
}

