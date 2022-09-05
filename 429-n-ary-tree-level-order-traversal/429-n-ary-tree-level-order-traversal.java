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
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();        
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        res.add(new ArrayList<Integer>(){{add(root.val);}});        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> numList = new ArrayList<>();
            while(size-- > 0){
                Node node = queue.poll();
                List<Node> nodeList = node.children;
                if(nodeList != null && !nodeList.isEmpty()){                    
                    for(Node child : nodeList){
                        numList.add(child.val);
                        queue.offer(child);
                    }                    
                }
            }
            
            if(!numList.isEmpty()) res.add(numList);
        }
        
        return res;
    }
}