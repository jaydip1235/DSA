class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // Find the middle element of the current subarray
        int mid = left + (right - left) / 2;

        // Create a new TreeNode with the middle element as the root
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively construct the left and right subtrees
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);

        return root;
    }

    // A sample method to print the binary tree (in-order traversal)
    public static void printTree(TreeNode root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.val + " ");
            printTree(root.right);
        }
    }

    public static void main(String[] args) {
        // Example input array
        int[] nums = {-10, -3, 0, 5, 9};

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the sortedArrayToBST method to convert the array to a BST
        TreeNode root = solution.sortedArrayToBST(nums);

        // Print the BST using in-order traversal
        printTree(root);
    }
}
