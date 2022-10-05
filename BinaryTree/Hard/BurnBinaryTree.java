// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

import java.util.* ;

class BurnTree {

	TreeNode startNode; // to record the start Node 
	public int amountOfTime(TreeNode root, int start) {

		if(root == null) return 0;
		HashMap<TreeNode, TreeNode> parent = new HashMap<>();  // to record the parent of each node 
		HashSet<TreeNode> visit = new HashSet<>(); 
		int res=0;
		helper(root, start, parent, null); // find the startNode, and build the parent map 
		ArrayDeque<TreeNode> queue = new ArrayDeque<>();

		queue.add(startNode);    // BFS
		while(!queue.isEmpty()){
		   int size = queue.size();
		   boolean flag = false; 
		   for(int i=0; i<size; ++i){
			   TreeNode temp = queue.poll();
			   visit.add(temp); 
			   if(temp.left != null && !visit.contains(temp.left)){
					queue.add(temp.left);
					flag = true;
			   }

			   if(temp.right != null && !visit.contains(temp.right)){
					queue.add(temp.right);
					flag = true;
			   }

			   if(parent.get(temp) != null && !visit.contains(parent.get(temp))){
				   queue.add(parent.get(temp));
				   flag = true;
			   }
		   }
		   if(flag)
			   res++;
		}
		return res; 
	}

	public void helper(TreeNode root, int start, HashMap<TreeNode, TreeNode> map, TreeNode parent){ 
		if(root == null) return; 
		if(root.val == start) startNode = root;
		map.put(root, parent); 
		helper(root.left, start, map, root);
		helper(root.right, start, map, root);
	}
}

//Idea: graph + BFS
//Time O(n)
//Space O(1)