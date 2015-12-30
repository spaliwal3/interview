import java.util.Iterator;


public class DoublyLinkedList<E extends Comparable<E>> implements Iterable<E>
{
	private int size;
	private Node head;
	private Node tail;
	
	private class Node
	{
		E data;
		Node next;
		Node prev;
	}
	
	
	public boolean isEmpty()
	{	return head == null;}
	
	public int size()
	{	return size;}
	
	public void add(final E data)
	{
		if(data==null)
			throw new NullPointerException();
		if(isEmpty())
		{	addFront(data);
			return;
		}
		
		Node n = head;
		Node curr;
		for(curr =head; curr != null; curr = curr.next)
		{	}
		
		n.data = data;
		curr.next = n;
		n.prev = curr;
		tail = n;
		size++;
			
	}
	
	public void addFront(final E data)
	{
		if(data==null)
			throw new NullPointerException();
		
		Node n= new Node();
		n.data = data;
		
		if(isEmpty())
		{	
			head = n;
			tail = n;
			//tail.next =null;
			size++;
			return;
		}
		
		n.next = head;
		head.prev =n;
		head =n;
		size++;
	}

	public E remove(final E data)
	{
		if(data == null)
			return null;
		if(isEmpty())
			return null;
		
		if(head.data.compareTo(data) == 0)
			return removeFront();
				
		E temp = null;
		for(Node curr =head; curr != null; curr = curr.next)
		{
			if(curr.data.compareTo(data) == 0)
			{	temp = curr.data;
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;
				size--;
			}
		}
		return temp;
	}
	
	private E removeFront() 
	{
		if(isEmpty())
			return null;
		
		E temp = head.data;
		head = head.next;
		head.prev = null;
		size--;
		return temp;
	}

	
	public String toString()
	{
		if(isEmpty())
			return " [] ";
		
		StringBuilder sb = new StringBuilder();
		Node curr = head;
		
		sb.append("[");
		while(curr != null)
		{
			sb.append(curr.data + ",");
			curr = curr.next;
		}
		
		sb.append("]");
		return sb.toString();
	}


	@Override
	public Iterator<E> iterator() 
	{
		return (Iterator<E>) new DoublyLinkedListIterator();
	}
	
	
	private class DoublyLinkedListIterator
	{
		Node curr = head;
		
		private boolean hasNext()
		{
			return curr.next == null;
		}
		
		private E next()
		{
			Node temp = curr;
			curr = curr.next;
			return temp.data;
		}
		
		private void remove()
		{	
		
		}
		
	}
	

	private boolean contains(final E data) {
		if(data ==null)
			throw new NullPointerException();
		
		if(isEmpty())
			return false;
		
		Node curr = head;
		while(curr!=null)
		{
			if(curr.data.compareTo(data) == 0)
			{
				return true;
			}
			curr = curr.next;
		}
		
		return false;
	}
	
	public static void main(String args[])
	{
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		
		System.out.println("current list :" + list.toString());
		System.out.println("List empty: "+ list.isEmpty());
		list.addFront(2);
		list.addFront(3);
		list.addFront(5);
		System.out.println("conatins 5 :"+list.contains(5));
		
		
		list.addFront(6);
		System.out.println("current list :" + list.toString());
		System.out.println("size :"+list.size());
		
		System.out.println("removed :"+list.remove(6));
		
		System.out.println("current list :"+ list.toString());
		System.out.println("head: "+list.head.data);
		System.out.println("tail: "+list.tail.data);
	}
}