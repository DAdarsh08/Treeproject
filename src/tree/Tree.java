package tree;

public class Tree {
   public TreeNode startnode;
   public void traverse()
   {
       if(startnode==null)
       {
           System.out.println("empth");
           return;
       }
       TreeNode curnode=startnode;
       while(curnode!=null)
       {
           System.out.print(" "+curnode.data);
           curnode=curnode.next;

       }
       System.out.println();
   }
   public void addfirstnode(int item)
   {
       TreeNode newnode=new TreeNode(item);
       newnode.next=startnode;
       startnode=newnode;



   }
}
