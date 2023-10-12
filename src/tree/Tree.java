package tree;

public class Tree {
   public TreeNode root;
    public  void post()
    {
        post(root);
    }
    public int getHeight()
    {
        if(root==null)
            return 0;
        return height(root);
    }
    private int height(TreeNode node)
    {
        if(node==null)
        {
            return 0;
        }
        return 1+ Math.max(height(node.left),height(node.right));
//        return node.height;
    }

    public void post(TreeNode node)
    {
        if(node==null)
        {

            return;
        }

        post(node.left);
        post(node.right);
        System.out.println(node.data);

    }

   public  void pre()
   {
       pre(root);
   }
   public void pre(TreeNode node)
   {
       if(node==null)
       {

           return;
       }
       System.out.println(node.data);
       pre(node.left);
       pre(node.right);

   }
    public  void inorder()
    {
        inorder(root);
    }
    public void inorder(TreeNode node)
    {
        if(node==null)
        {

            return;
        }

        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);



    }
    public boolean search(int item)
    {
        return search(item,root,false);
    }
    public boolean search(int item,TreeNode node,boolean ans)
    {
        if (node==null) {
            return false;

        }
        if(item==node.data)
        {
            return true;
        }

         if(item<node.data)
        {
           ans= search(item,node.left,ans);

        }
         if(item>node.data)
         {
            ans= search(item,node.right,ans);
         }
         return ans;


    }
    public TreeNode delete(int target)
    {
       return root=delete(root,target);
    }
    private TreeNode delete(TreeNode node,int target)
    {
        if(node==null)
        {
            return node;
        }
        if(target< node.data)
        {
            node.left=delete(node.left,target);

        } else if (target>node.data) {
            node.right=delete(node.right,target);

        }
        else {
            if(node.left==null)//to delete single node as well as leaf
            {
                return node.right;
            }
            if(node.right==null)//to delete single node as well as leaf
            {
                return node.left;
            }
            node.data=min(node.right);//if it has  both the nodes
            node.right=delete(node.right, node.data);

        }
        return node;

    }

    private int min(TreeNode node) {
        int min=node.data;
        while(node.left!=null)
        {
            min=node.left.data;
            node=node.left;
        }
        return min;
    }

    public void addfirstnode(int item)
   {
       root=addfirstnode(item,root);


   }
   public void displayheight()
   {
       System.out.println("---->"+root.height);
   }
   public TreeNode addfirstnode(int item,TreeNode node)
   {
       if(node==null)
       {
           node=new TreeNode(item);
           return node;
       }
       if(item<node.data)
       {
           node.left=addfirstnode(item,node.left);
       }
       if(item> node.data)
       {
           node.right=addfirstnode(item,node.right);
       }
      // node.height = Math.max(height(node.left), height(node.right)) + 1;

       return node;

   }
}
