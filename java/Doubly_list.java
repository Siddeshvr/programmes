import java.util.Scanner;

class Doubly_list
{
    Node head;
    class Node
    {
        int data;
        Node prev,next;
        Node(int data){this.data=data;}
    }

    void insert(int item)
    {
        Node temp = new Node(item);
        temp.next = head;
        temp.prev = null;
        if(head != null) head.prev = temp;
        head = temp;
    }
    void append(Node prevNode,int data)
    {
        if(prevNode == null)
        {
            System.out.println("prev is Null...");
            return;
        }
        Node temp = new Node(data);
        temp.next = prevNode.next;
        temp.prev = prevNode;
        prevNode.next = temp;
        if(temp.next != null)
            temp.next.prev = temp;
    }
    void end(int item)
    {
        Node temp = new Node(item);
        Node last = head;
        temp.next = null;
        if(head == null)
        {
            temp.prev = null;
            head = temp;
            return;
        }
        while(last.next != null) last = last.next;
        last.next = temp;
        temp.prev = last;
    }
    void print(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data+" ");
            node = node.next;
        }
    }

    public static void main(String[] args)
    {
        Doubly_list ob = new Doubly_list();
        for(int i=0;i<5;i++)
            ob.insert(i);
        ob.print(ob.head);
        System.out.println();
        ob.append(ob.head.next,9);
        ob.end(10);
        ob.print(ob.head);
        System.out.println();
    }
}