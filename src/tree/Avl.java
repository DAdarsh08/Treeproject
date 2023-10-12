package tree;

public class Avl {
    public class Node{
        private int val;
        private  Node left;
        private Node right;
        private int height;

        public Node(int val) {
            this.val = val;
        }
        public int getValue() {
            return val;
        }
    }
    public Avl()
    {

    }
    private Node root;

    private int height(Node node)
    {
        if(node==null)
        {
            return -1;
        }
        return node.height;
    }
    public  int height()
    {
        return height(root);
    }
   public void insert(int value)
   {
       root=insert(value,root);
   }
   private Node insert(int value, Node node)
   {
       if(node==null)
       {
           node=new Node(value);
           return node;
       }
       if(value<node.val)
       {
           node.left=insert(value,node.left);

       }
       if(value>node.val)
       {
           node.right=insert(value,node.right);
       }
       node.height = Math.max(height(node.left), height(node.right)) + 1;
       return rotate(node);

   }

    private Node rotate(Node node) {
        if (height(node.left) - height(node.right) > 1)//left heavy
        {
            if (height(node.left.left) - height(node.left.right) > 0)//left left case
            {
                return rightrotate(node);
            }
            if (height(node.left.left) - height(node.left.right) < 0)//left right case;
            {
                node.left = leftrotate(node.left);
                return rightrotate(node);
            }


        }
        if (height(node.left) - height(node.right) < -1)//left heavy
        {
            if (height(node.right.left) - height(node.right.right) < 0)//right right  case
            {
                return leftrotate(node);
            }
            if (height(node.right.left) - height(node.right.right) > 0)//right left case;
            {
                node.right = rightrotate(node.left);//child
                return leftrotate(node);
            }



        }
        return node;
    }
    private Node rightrotate(Node p)
    {
        //what all thing we don't need to touch;
        Node c=p.left;
        Node t=c.right;

        c.right=p;
        p.left=t;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return c;

    }
    private Node leftrotate(Node c)
    {
        //what all thing we don't need to touch;
        Node p=c.right;
        Node t=p.left;

        p.left=c;
        c.right=t;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return p;

    }



    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }
    private void display(Node node, String details) {
        if(node==null)
        {
            return;
        }
        System.out.println(details + node.val);
        display(node.left, "Left child of " + node.val + " : ");
        display(node.right, "Right child of " + node.val + " : ");
    }
    public void prettyDisplay()
    {
        prettyDisplay(this.root,0);
    }

    private void prettyDisplay(Node node, int level) {
        if(node==null)
        {
            return;
        }
        prettyDisplay(node.right, level + 1);
        if(level!=0)
        {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.getValue());
        }else{
            System.out.println(node.getValue());
        }
        prettyDisplay(node.left, level + 1);
    }

}