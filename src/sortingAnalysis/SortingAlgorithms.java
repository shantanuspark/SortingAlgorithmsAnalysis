package sortingAnalysis;

public class SortingAlgorithms {

	public void bubbleSort(Integer[] a) {
		for(int i = 1; i<a.length; i++) {
			for(int j = 0; j<i; j++) {
				if(a[i]<a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}
	
	public void insertionSort(Integer[] a) {
		for(int i = 1; i<a.length; i++) {
			int index = a[i];
			int j = i;
			while( j > 0 && a[j-1] > index) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = index;
		}
	}
	
	public void selectionSort(Integer[] a) {
		int min, minIndex, temp;
		for(int i = 0; i<a.length-1; i++) {
			min = a[i];
			minIndex = i;
			for(int j = i+1; j<a.length; j++) {
				if(a[j]<min) {
					min = a[j];
					minIndex = j;
				}
			}
			temp = a[i];
			a[i] = a[minIndex];
			a[minIndex] = temp;
		}
	}
	
	
	/***
	 * Merge method of merge sort, sorts and merges splitted arrays
	 * @param a - Array to sort
	 * @param first - starting index of split
	 * @param mid - index of split
	 * @param last - last index of split
	 */
	public void merge(Integer[] a, int first, int mid, int last) {
		Integer[] temp = new Integer[a.length];
		int i,j,k = -1;
		i = first;
		j = mid;
		//Check first part and second part simultaneously
		while(i <= mid-1 && j<=last) {
			//If value in first split is greater then second add it to temp
			if(a[i] <= a[j]) {
				k++;
				temp[k] = a[i];
				i++;
			} //If value in second split is greater then first add it to temp
			else {
				k++;
				temp[k] = a[j];
				j++;
			}
		}
		//If second part is added completely to the temp but first part still contains some elements
		if(i <= mid-1 ) {
			for(int itr = i; itr <= mid-1; itr++) {
				k++;
				temp[k] = a[itr];
			}
		}
		//If first part is added completely to the temp but second part still contains some elements
		if(j <= last) {
			for(int itr = j; itr <= last; itr++) {
				k++;
				temp[k] = a[itr];
			}
		}
		//copy the temp array back to a
		for(int itr = 0; itr <= k; itr++) {
			a[first+itr] = temp[itr];
		}
	}
	
	/***
	 * Sorts the elements of an array between left index and right index
	 * @param a - array to sort
	 * @param leftIndex - left index to start sorting from
	 * @param rightIndex - right index to stop sorting at
	 */
	public void split(Integer a[], int leftIndex, int rightIndex) {
		if (leftIndex != rightIndex) {
			int mid = (leftIndex + rightIndex) / 2;
			//recursively split the array
			split(a, leftIndex, mid);
			//recursively split the array
			split(a, mid+1, rightIndex);
			//merge left and right portions
			merge(a,leftIndex, mid+1, rightIndex);
		}
	}
	
	public int partition(Integer[] a, int left, int right) {
		int pivot = a[left];
		int i = left;
		int j = right;
		while(i < j) {
			while(i < right && a[i] <= pivot) {
				i++;
			}
			while(a[j] > pivot) {
				j--;
			}
			if (i < j) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		a[left] = a[j];
		a[j] = pivot;
		return j;
	}
	
	public void qSplit(Integer[] a, int left, int right) {
		if(left < right) {
			int p = partition(a, left, right);
			qSplit(a, left, p-1);
			qSplit(a,p+1,right);
		}
	}
	
}
