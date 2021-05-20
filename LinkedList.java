public class LinkedList {
  public Node head = null;

  public void addFirst(int data) {
    Node newNode = new Node(data);

    // if linked list is empty, make new node as head
    if (this.head == null) {
      this.head = newNode;
    } else {
      // else, make new node as head
      // & new node points to next node (old head)
      newNode.next = this.head;
      this.head = newNode;
    }
  }

  public void addLast(int data) {
    Node newNode = new Node(data);
    newNode.next = null;

    // if linked list is empty, make new node as head
    if (this.head == null) {
      this.head = newNode;
    } else {
      // else, traverse till last node and add there
      Node tail = this.head;
      while (tail.next != null) {
        tail = tail.next;
      }

      tail.next = newNode;
    }
  }

  public Node removeLast() throws Exception {
    Node curr = this.head;
    Node tail = curr;
    // traverse till second last node
    // store second last node to tail
    // remove and return last node
    while (curr.next != null) {
      tail = curr;
      curr = curr.next;
    }
    tail.next = null;
    return curr;
  }

  public Node removeFirst() throws Exception {
    // remove and return first node
    // make second node become new head
    Node oldHead = this.head;
    Node newHead = this.head.next;
    this.head = newHead;
    return oldHead;
  }

  public Node getFirst() {
    return this.head;
  }

  public Node getLast() {
    Node tail = this.head;
    while (tail.next != null) {
      tail = tail.next;
    }
    tail.next = null;
    return tail;
  }

  public void showList() {
    Node curr = this.head;
    String str = "";

    // traverse & print linked list
    // if list is empty, print empty string
    while (curr != null) {
      str += curr.data;
      if (curr.next != null) {
        str += "->";
      }
      curr = curr.next;
    }
    System.out.println(str);
  }

  public void reverseList() {
    // create a new reverse list
    LinkedList newList = new LinkedList();

    Node curr = this.head;
    while (curr != null) {
      newList.addFirst(curr.data);
      curr = curr.next;
    }

    // copy new reverse list to original list
    Node newNode = newList.head;
    Node currNode = this.head;

    while (currNode != null) {
      currNode.data = newNode.data;
      currNode = currNode.next;
      newNode = newNode.next;
    }
  }

  public static void main(String[] args) throws Exception {
    LinkedList lst = new LinkedList();
    lst.addFirst(1);
    lst.addLast(2);
    Node first = lst.getFirst();
    System.out.println(first.data);
    Node last = lst.getLast();
    System.out.println(last.data);
    lst.showList();
    lst.reverseList();
    try {
      last = lst.removeLast();
      System.out.println(last.data);
    } catch (Exception e) {
      // throw exception if list is empty
      System.out.println("List is empty");
    }

    try {
      first = lst.removeFirst();
      System.out.println(first.data);
    } catch (Exception e) {
      // throw exception if list is empty
      System.out.println("List is empty");
    }
  }
}
