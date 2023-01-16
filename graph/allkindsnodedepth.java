import java.util.Stack;

public  class allkindsnodedepth{
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int height;
        int sumDepth;
        TreeNode(){
            this.left=null;
            this.right=null;
            this.height=1;
            this.sumDepth=0;
        }
    }
    public class helper{
        int depth=0;
        int height=0;
        int sumDepth=0;
    }
    public int findDepth(TreeNode root,int depth){
        if(root==null)return 0;
        return findDepth(root.left, depth)+findDepth(root.right, depth+1)+depth;
    }
    // it take o(nlog(n)) and o(h) space complexity
    // public int giveAllDepth(TreeNode root){
    //     int ans=0;
    //     Stack<TreeNode>st=new Stack<>();
    //     st.add(root);
    //     while(st.size()>1){

    //         TreeNode currNode =st.pop();
    //         if(currNode==null)continue;
    //         ans+=findDepth(currNode, 0);
    //         st.add(currNode.left);
    //         st.add(currNode.right);
    //     }
    //     return ans;
    // }


    // it take o(nlog(n)) and o(h) recursion stack space complexity
    // public int giveSumAllDepth(TreeNode root){
    //     if(root==null)return 0;
    //     return giveSumAllDepth(root.left)+giveSumAllDepth(root.right)+findDepth(root, 0);

    // }

    // it take o(n)time and o(n)space complexity
    // public void fillAllDepth(TreeNode root){
    //      if(root==null)return;
    //      fillAllDepth(root.left);
    //      fillAllDepth(root.right);
    //      int height=(root.left==null?0:root.left.height)+(root.right==null?0:root.right.height);
    //      int sumDepth=(root.left==null?0:root.left.sumDepth)+(root.right==null?0:root.right.sumDepth)+height;
    //      root.height=height+1;
    //      root.sumDepth=sumDepth;
    // }

    // public int giveSumAllDepth(TreeNode root){
    //     if(root==null)return 0;
    //     return giveSumAllDepth(root.left)+giveSumAllDepth(root.right)+root.sumDepth;
    // }
  

    // it takes o(n) time and o(h)space
    
    public helper fillAllDepth(TreeNode root){
         if(root==null)return new helper();
         helper l=fillAllDepth(root.left);
         helper r=fillAllDepth(root.right);
         int height=l.height+r.height;
         helper ans=new helper();
         ans.height=height+1;
         ans.depth=l.depth+r.depth+height;
         ans.sumDepth=l.sumDepth+r.sumDepth+ans.depth;
         return ans;
         
    }

    public int giveSumAllDepth(TreeNode root){
        if(root==null)return 0;
        return fillAllDepth(root).sumDepth;
    }
     






}