package List.Q206;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/3/28 ионГ8:28
 */

class Node{
    int val;
    Node next;
    Node(int x){
        val=x;
        next=null;
    }
}
public class Q206 {

    public static Node reverseList(Node head){
        Node pre=null;
        Node cur=head;
        while(head!=null){
            Node nexttemp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nexttemp;

        }
        return pre;
    }
}
