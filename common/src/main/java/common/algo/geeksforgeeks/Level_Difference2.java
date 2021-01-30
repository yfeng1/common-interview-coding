package common.algo.geeksforgeeks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//import java.lang.Math;


// A Binary Tree node

class Level_Difference2
{
    // driver function to test the above functions
    public static void main(String args[])
    {

        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //Node root=null;
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root=null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }

            GfG g = new GfG();

            System.out.println(g.getLevelDiff(root));
            t--;

        }
    }
}


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

// A Binary Tree node
/* class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}  */
class GfG2
{   /*You are required to complete this function*/

    int odd = 0;
    int even = 0;

    int getLevelDiff(Node root)
    {
        int height = height(root);
        for (int i = 1; i <= height; i++) {
            if (i % 2 == 1) {
                odd +=  getLevelSum(root, i);
            } else {
                even += getLevelSum(root, i);
            }
        }
        return odd - even;
    }

    int getLevelSum(Node root, int level) {
        if (level == 1) {
            return root.data;
        }
        return getLevelSum(root.left, level - 1) + getLevelSum(root.right, level - 1);
    }

    int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

}