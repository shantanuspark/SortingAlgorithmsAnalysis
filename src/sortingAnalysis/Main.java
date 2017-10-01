package sortingAnalysis;

import java.util.Random;
import javax.swing.SwingUtilities;


public class Main {

	public static void main(String[] args) {
		
		int n = 100;
		Random rand = new Random();
		SortingAlgorithms algos = new SortingAlgorithms();
		long start, stop = 0;
		Integer test[];
		
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LineChart("Algorithm Analysis").setVisible(true);
            }
        });
		
		while (n <= 100000) {
			
			Integer[] a = new Integer[n];
			
			for(int i = 0; i < n; i++) {
				a[i] = rand.nextInt(100000);
			}
			
			test = a.clone();
			start = System.currentTimeMillis();
			algos.split(test,0,a.length-1);
			stop = System.currentTimeMillis();
			LineChart.dataset.addValue(stop-start, "Merge Sort", Integer.toString(n));
			
			test = a.clone();
			start = System.currentTimeMillis();
			algos.selectionSort(test);
			stop = System.currentTimeMillis();
			LineChart.dataset.addValue(stop-start, "Selection Sort", Integer.toString(n));
			
			test = a.clone();
			start = System.currentTimeMillis();
			algos.insertionSort(test);
			stop = System.currentTimeMillis();
			LineChart.dataset.addValue(stop-start, "Insertion Sort", Integer.toString(n));
			
			test = a.clone();
			start = System.currentTimeMillis();
			algos.bubbleSort(test);
			stop = System.currentTimeMillis();
			LineChart.dataset.addValue(stop-start, "Bubble Sort", Integer.toString(n));
			
			n*=10;
		}
		
	}	

}
