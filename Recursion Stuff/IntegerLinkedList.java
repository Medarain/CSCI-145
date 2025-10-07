public class IntegerLinkedList {
    private IntegerNode head;


    public boolean isEmpty() {
        return head == null;
    }

    public void insertFront(int val) {
        IntegerNode node = new IntegerNode(val);
        node.setNext(head);
        head = node;
    }

    public void insertBack(int val) {
        IntegerNode node = new IntegerNode(val);
            if (isEmpty()) {
            head = node;
        } else {
            IntegerNode cur = head;
            while (cur.getNext() != null) {
                cur = cur.getNext();
            }
            cur.setNext(node);
        }
    }
    
    public void print() {
        IntegerNode cur = head;
        while (cur != null) {
            System.out.printf("%d ", cur.getValue());
            cur = cur.getNext();
        }
        System.out.println();
    }

    public int get(int index) {
        IntegerNode cur = head;
        for (int i = 0; i < index; i++) {
            if(cur == null){
                System.out.println(i);
                System.out.println("Error: empty list !");
            }
            System.out.println(i);
            cur = cur.getNext();
        }
        return cur.getValue();
    }

    public void removeFront() {
        if(head != null){
            head = head.getNext();
        }
    }

    public void removeBack() {
        if (head != null) {
            if (head.getNext() == null) {
                head = null;
            } else {
                IntegerNode cur = head;
                while (cur.getNext().getNext() != null) {
                    cur = cur.getNext();
                }
                cur.setNext(null);
            }
        }
    }
    
    public void removeAt(int index) {
        IntegerNode cur = head;
        if (head == null) {
            System.out.println("IndexOutOfBounds");
            return;
        }
        if (index == 0) {
            head = head.getNext();
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            if (cur.getNext() == null) {
                System.out.println("IndexOutOfBounds");
                return;
            }else{
                cur = cur.getNext();
            }
        if (cur.getNext() == null) {
            System.out.println("IndexOutOfBounds");
            return;
        }else{
            cur.setNext(cur.getNext().getNext());
        }
    }
}
    public static void main(String[] args) {
        IntegerLinkedList list = new IntegerLinkedList();
        list.print();
        list.insertFront(5);
        list.insertFront(14);
        list.insertBack(10);
        list.print();
        System.out.println(list.get(2)); //print 10
        list.removeFront(); //removes 14?
        list.print();
        list.removeBack(); //removes 10?
        list.removeAt(1);
        list.print();
    }
}

