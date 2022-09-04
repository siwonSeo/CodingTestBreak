/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer,PriorityQueue<LocationNode>> map = new HashMap<>();
    
    class LocationNode{
        TreeNode node;
        int loc;
        int depth;
        LocationNode(TreeNode node, int loc, int depth){
            this.node = node;
            this.loc = loc;
            this.depth = depth;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<LocationNode> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue();
        queue.offer(new LocationNode(root,0,0));
        int level = 0;
        while(!queue.isEmpty()){
            int length = queue.size();
            for(int i = 0; i < length; i++){
                LocationNode locNode = queue.poll();
                TreeNode node = locNode.node;
                int loc = locNode.loc;
                
                if(map.containsKey(loc)){
                    map.get(loc).add(locNode);
                }else{
                    map.put(loc,new PriorityQueue<LocationNode>(
                    (a,b)-> {
                        if(a.depth==b.depth){
                            return a.node.val-b.node.val;
                        }else{
                            return a.depth-b.depth;
                        }
                    }
                    ){{add(locNode);}});
                }
                
                if(node.left != null){queue.offer(new LocationNode(node.left,loc-1,level+1));
                                      
                                     }
                if(node.right != null){queue.offer(new LocationNode(node.right,loc+1,level+1));

                                      }
            }
            ++level;
        }
        
        map.keySet().forEach(k->pq.add(k));
        while(!pq.isEmpty()){
            PriorityQueue<LocationNode> pqLc = map.get(pq.poll());
            List<Integer> list = new ArrayList<>();
            while(!pqLc.isEmpty()){
                LocationNode lNode = pqLc.poll();
                list.add(lNode.node.val);
            }
            res.add(list);
        }
        
        return res;
        
        
    }

}