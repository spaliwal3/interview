import java.util.Iterator;
import java.util.*;

public class LinkedList <E extends Comparable <E>> implements Iterable<E>{

	private int size;
	private Node head;
	
	private class Node
	{
		E data;
		Node next;
	}

	@Override
	public Iterator<E> iterator() 
	{
		return (Iterator<E>) new LinkedListIterator();
	}
	
	
	private class LinkedListIterator
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
			curr.data = curr.next.data;
			curr.next = curr.next.next;
		}
		
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return head == null;
	}
	
	public void addFront(final E data)
	{
		if (data == null)
			return;
		
		Node n = new Node();
		n.data = data;
		
		if(!isEmpty())
		{
			n.next = head;
		}

		head = n;
		size++;
	}
	
	
	public E removeFront()
	{
		if(isEmpty())
			return null;
		
		Node temp = head;
		head = head.next;
		size--;
		return temp.data;
	}
	
	public E remove(final E data)
	{
		if(data ==null)
			return null;
		
		if(isEmpty())
			return null;
		
		if(head.data.compareTo((data)) == 0)
		{	removeFront();}
		
		Node curr = head;
		E temp = null;
		while(curr!=null)
		{
			if(curr.data.compareTo(data) == 0)
			{
				temp = curr.data;
				curr.data = curr.next.data;
				curr.next = curr.next.next;
				size--;
			}
			curr = curr.next;
		}
		
		return temp;
	}
	
	
	public boolean contains(final E data)
	{
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
	
	public String toString()
	{
		if(isEmpty())
			return " ";
		
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
	
	
	public static void main(String args[])
	{
		LinkedList<Integer> list = new LinkedList<Integer>();
		System.out.println(list.isEmpty());
		list.addFront(2);
		list.addFront(3);
		list.addFront(5);
		System.out.println(list.contains(5));
		
		
		list.addFront(6);
		System.out.println(list.toString());
		System.out.println(list.size());
		
		System.out.println("removed :"+list.remove(5));
		
		System.out.println(list.toString());
	}
}
