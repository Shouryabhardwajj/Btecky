// Java implementation of Circle Sort
import java.io.*;
import java.util.*;

class GFG {
	// Java function to swap the elements of an array
	public static void swap(int[] arr, int i, int j) {
		int t=arr[i];
		arr[i]=arr[j];
		arr[j]=t;
}

// Function to perform circular swaps recursively
// This function returns true if there was a swap
// operation performed.
public static boolean circleSortRec(int a[], int low, int high)
{
	boolean swapped = false;

	// base case
	if (low == high)
		return false;

	// storing the upper and lower bounds
	// of list to be used later in the
	// recursive case
	int lo = low, hi = high;

	while (lo < hi)
	{
		// swaps the pair of elements
		// if true
		if (a[lo] > a[hi])
		{
			swap(a,lo,hi);
			swapped = true;
		}
		lo++;
		hi--;
	}

	// special case arises only for list
	// of odd size
	if (lo == hi)
		if (a[lo] > a[hi + 1])
		{
			swap(a,low,hi+1);
			swapped = true;
		}

	// recursive case to check the
	// traverse lists as sub lists
	int mid = (high - low) / 2;
	boolean firstHalf = circleSortRec(a, low, low+mid);
	boolean secondHalf = circleSortRec(a, low+mid+1, high);

	return swapped || firstHalf || secondHalf;
}

// This function mainly calls circleSortRec
public static void circleSort(int a[], int n)
{
	// Keep calling circleSortRec while
	// there is a swap operation.
	while (circleSortRec(a, 0, n-1))
	{
	;
	}
}

	// Driver code
	public static void main(String[] args)
	{
		int a[] = {6, 5, 3, 1, 8, 7, 2, 4};
		int n = a.length;

		System.out.print("Unsorted : ");
		for (int i=0; i<n; i++)
			System.out.print(a[i]+" ");

		circleSort(a, n);

		System.out.print("\nSorted : ");
		for (int i=0; i<n; i++)
			System.out.print(a[i]+" ");
	}
}

// This code is contributed by Pushpesh Raj
