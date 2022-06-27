 
/**
 * TODO - your comments here
 */
//Ehsanullah Nikfar
package lab4;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> extends AbstractList<T> {
	Node head, tail;
	int size;
	private int count_index;
	private Object p;

	protected class Node {
		T data;
		Node next;
		Node prev;

		protected Node() {
			data = null;
			next = null;
			prev = null;
		}
	}  // end of the Node class



	public MyLinkedList() {
		head = new Node();
		tail = new Node();
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	private Node getNth(int index) {
		if(index> size-1) {
			
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
			}
		Node p = head;
		for( int i=0; i <= index; i++ )
		  p = p.next;
		return p;
		
	}
	
	
	
	public boolean add(T data) {
		
		if(size == 0) {
		  Node s = new Node();
		  head.next = s;
		  s.prev =head;
		  s.next = tail;
		  tail.prev = s;
		  s.data = data;
		  size++;
		  return true;
		  
		  
		  
		}
		else {
		Node t = getNth(size-1);
		Node s = new Node();
		t.next = s;
		s.prev = t;
		s.next = tail;
		tail.prev = s;
		s.data = data;
		size++;
		return true;
		
		}}
	public void add(int index, T data) {
		if(index> size) {
			
		throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		}
		if(size == 0) {
			  Node s = new Node();
			  head.next = s;
			  s.prev =head;
			  s.next = tail;
			  tail.prev = s;
			  size++;}
			  
			  
	
		else if( index == size ) {
			Node t = getNth(size-1);
			Node s = new Node();
			t.next = s;
			s.prev = t;
			s.next = tail;
			tail.prev = s;
			s.data = data;
			size++;
			}
		else {
			Node p = getNth(index-1);
			Node q = getNth(index);
			Node s = new Node();
			p.next= s;
			s.prev = p;
			s.next = q;
			q.prev = s;
			s.data = data;
			size++;}
		}
	@Override
	public T get(int index) {
		if(index> size-1) {
			
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
			}
		else {
		Node p = getNth(index);
		return p.data;}
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
    public T set(int index, T data) {
     if(index> size) {
			
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
			}
    	
    	Node p = getNth(index);
    	T old_data = p.data;
    	p.data = data;
    	
		return old_data;
    	
    	}
    
    public T remove(int index) {
      if(index> size) {
			
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
			}

    
      
		
      else {
	     Node s = getNth(index);
		 Node p = getNth(index-1);
		 Node q = getNth(index+1);
		 T removed_data = s.data;
		 p.next = q;
		 q.prev = p;
		 size--;
		 return removed_data;
		 }
		
    	
    	
    }
    public void clear() {
    	head.next = tail;
		tail.prev = head;
		size = 0;
		count_index =-1;
    	
    	}
    public boolean isEmpty() {
    	if(size ==0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    	
    	
    }
    class MyLinkedListIterator implements ListIterator<T> {
    	Node p = head;
    	boolean forward_direction = false;
    	boolean backward_direction = false;
    	
    	int count_index=-1;
    	public MyLinkedListIterator() {
    		
    	}

    	@Override
    	public boolean hasNext() {
    		// TODO Auto-generated method stub
    		if(p.next!=tail) {
    			
    		  return true;
    		}
    		else {
    		
    		return false;}
    	}

    	@Override
    	public T next() {
    		
    		// TODO Auto-generated method stub
    		
    		if (this.hasNext() != true) {
    			throw new NoSuchElementException();
    			
    			
    		}
    		else {
    			
    			p = p.next; 
    			count_index++;
    			forward_direction = true;
    			backward_direction= false;
    			
    			return p.data;
    			
    		}
    		
    		
    	}

    	@Override
    	public boolean hasPrevious() {
    		// TODO Auto-generated method stub
    		if(p.prev!=head) {
    			
    			
      		  return true;
      		}
      		
      	
    		else {
    		
    		return false;}
    	}

    	@Override
    	public T previous() {
    		if (this.hasPrevious() != true) {
    			throw new NoSuchElementException();
    			
    			
    		}
    		else {
    			p = p.prev; 
    			count_index--;
    			forward_direction =false;
    			backward_direction= true;
    			return p.data;
    			
    		}
    		// TODO Auto-generated method stub
    		
    	}

    	@Override
    	public int nextIndex() {
    		// TODO Auto-generated method stub
    		return count_index;
    	}

    	@Override
    	public int previousIndex() {
    		// TODO Auto-generated method stub
    		return count_index;
    	}

    	@Override
    	public void remove() {
    		if(count_index == 0) {
    			
    			throw new IllegalStateException();
    		}
    		else if(backward_direction== false && forward_direction == false) {
          	  
          	  throw new IllegalStateException();
            }
    		else if(forward_direction = true){  
    			Node s = p.next;
    			Node r = p.prev;
    			
    			s.next = r;
    			r.prev = s;
    			backward_direction = false;
    			size--;
    			
    			
    		}
    		else if(backward_direction = true) {
    			Node s = p.prev;
    			Node r = p.prev.prev;
    			p.prev = r;
    			r.next= p;
    			forward_direction = false;
    			size--;
    			
    			
    			
    			
    		}
    		
    		
    			
    				
    				
    			}

		@Override
		public void set(T e) {
          if(count_index == 0) {
    			
    			throw new IllegalStateException();
    		}
          else if(backward_direction== false && forward_direction == false) {
        	  
        	  throw new IllegalStateException();
          }
          else if(forward_direction = true) {
        	  
        	  
        	  p.data = e;
        	  
          }
          else if (backward_direction = true){
        	  p.prev.data = e;
        	  
        	 
        	  
          }
          
			
			
			// TODO Auto-generated method stub
			
		}

		@Override
		public void add(T e) {
			
	     
			
			Node t = p.prev;
			Node s = new Node();
			t.next = s;
			s.prev = t;
			s.next = p;
			p.prev = s;
			s.data  = e;
			count_index=+1;}
	     
	     }
    	
    		
    	



	public Iterator<T> myIterator() {
		// TODO Auto-generated method stub
		
		return new MyLinkedListIterator() ;
	}

    	

    	

    	

    }
    
    
    
