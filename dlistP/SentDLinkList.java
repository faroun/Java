package dlistP;

public class SentDLinkList <T>
{
    private Node<T> head,tail;
    private Node<T> current;

    public SentDLinkList()
    {
    	head = current = new Node<T>();
    	tail = new Node<T>();
    	head.next = tail;
    	tail.previous = head;
    }

    public boolean empty()
    {
    	return head.next == tail;
    }

    public boolean last()
    {
    	return current.next == tail;
    }

    public boolean full()
    {
    	return false;
    }

    public void findFirst()
    {
        current = head.next;
    }

    public void findNext() 
    {
        current = current.next;
    }

    public T retrieve()
    {
        return current.data;
    }

    public void update(T val)
    {
    	current.data = val;
    }

    public void insert(T val)
    {
    	Node<T> tmp = new Node<T>(val);
    	tmp.next = current.next;
    	tmp.previous = current;
    	current.next.previous = tmp;
    	current.next = tmp;
    	current = tmp;
    }

    public void remove()
    {
    	Node<T> tmp = current.previous;
    	tmp.next = current.next;
    	current.next.previous = tmp;

        if (empty())
        	current = head;
        else if (current.next == tail)
            current = head.next;
        else
            current = current.next;
    }

    public void insertAtFront(T val)
    {
		Node<T> tmp = new Node<T>(val);
		tmp.next = head.next;
		tmp.previous = head;
		head.next.previous = tmp;
		head.next = current = tmp;
    }

    public void insertAtEnd(T val)
    {
    	Node <T> tmp = tail.previous;
    	tail.previous = new Node<T>(val);
    	current = tail.previous;
    	current.next = tail;
    	current.previous = tmp;
    	tmp.next = current;
    }

    public void removeFront()
    {
    	current = head.next;
    	head.next = current.next;
    	head.next.previous = head;
    	
    	if (empty())
    		current = head;
    	else
    		current = head.next;
    }

    public void removeEnd()
    {
    	Node <T> tmp = tail.previous;
    	tail.previous = tmp.previous;
    	tmp.previous.next = tmp.next;

    	if (empty())
    		current = head;
    	else
    		current = head.next;
    }
}
