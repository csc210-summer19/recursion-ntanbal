/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Nour Tanbal
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n > 999) {
			if (n % 1000 < 10) {
				return intWithCommas(n / 1000) + ",00" + intWithCommas(n % 1000);
			}
			if (n % 1000 < 100) {
				return intWithCommas(n / 1000) + ",0" + intWithCommas(n % 1000);
			}
			return intWithCommas(n / 1000) + "," + intWithCommas(n % 1000);

		}
		return Integer.toString(n);
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {

		reverseArray(x, 0, x.length);

	}

	private void reverseArray(int[] x, int index, int len) {
		if (index == len / 2) {
			return;
		}
		int temp = x[index];
		x[index] = x[len - index - 1];
		x[len - index - 1] = temp;
		reverseArray(x, index + 1, len);

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return FindMax(a, 0, a.length, a[0]) - FindMin(a, 0, a.length, a[0]);
		}

	private int FindMin(int[] a, int index, int len, int min ) {
	if(index == len) {
		return min;
	}
	if(a[index] < min) {
		min = a[index];
	}
	return FindMin(a, index + 1, len, min);
	}

	private int FindMax(int[] a, int index, int len, int max) {
	  if(index == len ) {
		 
		  return max;
	  }
	  if(a[index] > max) {
		  max = a[index];
	  }
	  return FindMax(a, index + 1, len, max);
}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		return Sorted(nums, 1);
	}
	private boolean Sorted(int[] n, int index) {
		if ( n.length == 0) {
			return true;
		}
		if(index == n.length) {
			return true;
		}
		
		if(n[index - 1] > n[index]) {
			return false;
		}
		return Sorted(n, index + 1);
		
		
		
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return FindLtr(search, strs , 0);
	}
	private boolean FindLtr(String search, String[] strs,int index) {
		if(index == strs.length) {
			return false;
		}
		if(strs[index].equals(search)) {
			return true;
		}
		return FindLtr(search, strs, index + 1);
	}
}
