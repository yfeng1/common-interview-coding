package common.algo.geeksforgeeks;

import java.util.*;
import java.lang.Integer;
//import java.lang.Math;
import java.io.*;
// A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
class Level_Difference
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
class GfG
{   /*You are required to complete this function*/

    Queue<Node> q = new LinkedList<>();
    Queue<Node> q2 = new LinkedList<>();
    boolean isOdd = true;
    int odd = 0;
    int even = 0;

    int getLevelDiff(Node root)
    {
        // Your code here	
        q.add(root);
        while (!q.isEmpty() || !q2.isEmpty()) {
            if (isOdd) {
                Node current = q.remove();
                odd += current.data;
                if (current.left != null) {
                    q2.add(current.left);
                }
                if (current.right != null) {
                    q2.add(current.right);
                }
                if (q.isEmpty())
                    isOdd = false;
            } else {
                Node current = q2.remove();
                even += current.data;
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
                if (q2.isEmpty())
                    isOdd = true;
            }

        }
        return  odd-even;
    }

}