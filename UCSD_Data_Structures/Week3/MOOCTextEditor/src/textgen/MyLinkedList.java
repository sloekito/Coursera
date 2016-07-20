package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = null;
		this.tail = null;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		LLNode<E> newNode = new LLNode(element);
		newNode.data = element;
		newNode.next = null;
		
		// TODO: Implement this method
		if(head == null)
		{
			this.head = newNode;
			this.tail = newNode;
			this.size++;
			return true;
		}
		else
		{
			LLNode<E> cur = head;
			while(cur.next != null) 
			{
				cur = cur.next;
			}			
			cur.next = newNode;
			newNode.prev = cur;		
			this.tail = newNode;
			this.size++;
			return true;
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		IndexOutOfBoundsException e = new IndexOutOfBoundsException();
		// TODO: Implement this method.	
		if(head == null) {						
			throw e;
		}
		LLNode<E> cur = head;
		int i = 0;
		while(i != index) 
		{
			if(cur.next == null) {
				throw e;
			}
			cur = cur.next;
			i++;
		} 
		return cur.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element) 
	{
		// TODO: Implement this method

		LLNode<E> newNode = new LLNode(element);
		newNode.data = element;
		newNode.next = null;
		
		if(head == null)
		{
			head = newNode;
			head.next = null;
			tail = newNode;
		}
		else
		{
			LLNode<E> cur = head;
			int i = 0;
			while(i != index) 
			{
				cur = cur.next;
				i++;
			}
			cur = newNode;
			cur.next = null;
			tail = newNode;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		return null;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
