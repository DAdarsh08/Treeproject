package tree;

import java.util.Scanner;

public class TreeNode {
    int data;
    TreeNode next;

    public TreeNode(int data) {
        this.data = data;
    }
    public TreeNode()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value");
        data=sc.nextInt();

    }

}
