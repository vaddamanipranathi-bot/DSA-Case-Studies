class BSTNode {
    int score;
    BSTNode left, right;

    BSTNode(int score) {
        this.score = score;
        left = right = null;
    }
}

public class SportsBST {

    BSTNode root;

    BSTNode insert(BSTNode root, int score) {
        if (root == null)
            return new BSTNode(score);

        if (score < root.score)
            root.left = insert(root.left, score);
        else if (score > root.score)
            root.right = insert(root.right, score);

        return root;
    }

    boolean search(BSTNode root, int key) {
        if (root == null)
            return false;

        if (root.score == key)
            return true;

        if (key < root.score)
            return search(root.left, key);

        return search(root.right, key);
    }

    void inorder(BSTNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.score + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        SportsBST tree = new SportsBST();

        int[] scores = {50, 80, 30, 70, 90, 60};

        for (int score : scores)
            tree.root = tree.insert(tree.root, score);

        System.out.println("Player Scores in Ascending Order:");
        tree.inorder(tree.root);

        if (tree.search(tree.root, 70))
            System.out.println("\nScore 70 Found");
        else
            System.out.println("\nScore 70 Not Found");
    }
}