package tree;

public class TreeMain {
    public static void main(String[] args) {
        Tree t=new Tree();
        t.addfirstnode(10);
        t.addfirstnode(5);
        t.addfirstnode(6);
        t.addfirstnode(1);
        t.addfirstnode(15);
        t.addfirstnode(20);
        t.addfirstnode(11);
        t.inorder();
        System.out.println();
        System.out.println(t.getHeight());

        System.out.println();
        t.delete(11);
        t.inorder();

        //
    }

}
