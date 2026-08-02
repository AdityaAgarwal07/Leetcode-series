/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    List<Integer> ans;
    public List<Integer> postorder(Node root) {
        ans = new ArrayList<>();
        find(root);
        return ans;
    }
    private void find(Node node){
        if(node == null) return;
        for(Node nn : node.children) find(nn);
        ans.add(node.val);
    }
}