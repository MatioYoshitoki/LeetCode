import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int flag = 0;
        int base = 0;
        ListNode p = head;
        List<ListNode> list = new ArrayList<>();
        do {
            list.add(p);
        }while ((p = p.next)!=null);
        ListNode[] arrayTmp = new ListNode[list.size()];
        list.toArray(arrayTmp);
        for (int i = 0; i < list.size(); i++) {
            if (flag<=((k-1)/2)){
                exchange(arrayTmp, base, k+base-1, i);
                flag++;
            }else if (flag==k-1){
                base=i+1;
                flag=0;
            }else {
                flag++;
            }
        }
        for (int i = 0; i < list.size()-1; i++) {
            arrayTmp[i].next = arrayTmp[i+1];
        }
        arrayTmp[arrayTmp.length-1].next=null;
        return arrayTmp[0];
    }

    public void exchange(ListNode[] list, int start, int end, int now){
        if (start < 0 || end >= list.length || now < start || now > end){
            return;
        }
        int exchangeIndex = end-(now-start);
        ListNode tp1 = list[now];
        ListNode tp2 = list[exchangeIndex];
        list[now] = tp2;
        list[exchangeIndex] = tp1;
    }

    public static ListNode initLink(int[] i){
        ListNode node = new ListNode(i[0]);
        ListNode tmp = node;
        for (int v = 1; v < i.length; v++) {
            tmp.next = new ListNode(i[v]);
            tmp = tmp.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ReverseKGroup().reverseKGroup(initLink(new int[]{1, 2, 3, 4, 5}), 3);
        System.out.println(node.val);
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}