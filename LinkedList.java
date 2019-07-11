import java.util.Arrays;

/**
 * This generic collection class uses a singly-linked data structure to store
 * store elements. Many operations are already implemented using recursion. Use
 * them as examples of public methods that send the first to private helper
 * methods. The private helpers must use recursion instead of loops.
 * 
 * E get(int) void removeAll(E) void duplicateAll(E)
 * 
 * @author Rick Mercer and Nour Tanbal
 */
public class LinkedList<E extends Comparable<E>> {
	// extends Comparable<E> means the type must be comparable to avoid CT errors

	// Inner class
	private class Node {
		private E data;
		private Node next;

		public Node(E element) {
			data = element;
			next = null;
		}

		public Node(E element, Node reference) {
			data = element;
			next = reference;
		}
	}

	// Instance variables
	private Node first;
	private int n;

	// Construct an empty list
	public LinkedList() {
		first = null;
		n = 0;
	}

	// Add an element at the end of this list O(1)
	public void addLast(E el) {
		if (first == null)
			first = new Node(el);
		else // call a recursive helper method that needs the ref to first
			addLast(el, first);
		n++;
	}

	// This recursive method runs O(n). A stack push is like a loop
	// iteration
	private void addLast(E el, Node ref) {
		if (ref.next == null)
			ref.next = new Node(el, ref.next);
		else {
			addLast(el, ref.next);
		}
	}

	// Find out how many elements are in the list O(1)
	public int size() {
		return n;
	}

	// Find the maximum value in this list using the element's compareTo method
	public E max() {
		if (size() == 0)
			return null;
		// else, call the recursive method that needs a reference to the first element
		return max(first, first.data);
	}

	private E max(Node ref, E largest) {
		if (ref.next == null)
			return largest;
		else {
			if (ref.data.compareTo(largest) > 0)
				largest = ref.data;
			return max(ref.next, largest);
		}
	}

	// Find out how often the same element exists using the type's equals method
	public int occurencesOf(E search) {
		// Call the recursive helper method
		return count(search, first);
	}

	// This method runs O(n), the same runtime as a loop
	private int count(E search, Node ref) {
		if (ref == null)
			return 0;
		else if (search.equals(ref.data))
			return 1 + count(search, ref.next);
		else
			return 0 + count(search, ref.next);
	}

	// Return a reference to the element at the given index.
	// Precondition: 0 >= index < size
	public E get(int index) {
		return get(first, 0, index);
	}

	private E get(Node ref, int startIndex, int stopIndex) {

		if (startIndex == stopIndex) {
			return (E) ref.data;
		}

		return get(ref.next, startIndex + 1, stopIndex);
	}

	// Complete method removeAll(E el) so all elements that
	// equals el are removed from this LinkedList<E>.
	public void removeAll(E el) {
		removeEl(el, first, null);
	}

	private void removeEl(E el, Node ref, Node prev) {

		if (ref == null)
			return;

		if (ref.data.equals(el)) {
			n--;
			if (prev == null) {
				first = ref.next;
			} else {
				prev.next = ref.next;
			}
			ref = ref.next;
			removeEl(el, ref, prev);
		} else {
			removeEl(el, ref.next, ref);
		}
	}

	// Duplicate el next to each occurrence of el in this list.
	public void duplicateAll(E el) {
		DuplicateEl(el, first);
	}

	private void DuplicateEl(E el, Node ref) {
		if (ref == null) {
			return;
		}
		if (ref.data.equals(el)) {
			ref.next = new Node(ref.data, ref.next);
			n++;
			DuplicateEl(el, ref.next.next);
		} else {
			DuplicateEl(el, ref.next);

		}
	}

}