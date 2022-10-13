package thuat_toan;

public class AlgorithmSort {

    void insertionSort(int a[], int array_size) {
        int i, j, last;
        for (i=1; i < array_size; i++) {
            last = a[i];
            j = i;
            while ((j > 0) && (a[j-1] > last)) {
                a[j] = a[j-1];
                j = j - 1; }
            a[j] = last;
        }
    }
    void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
    void selectionSort(int a[], int n){
        int i, j, min, temp;
        for (i = 0; i < n-1; i++) {
            min = i;
            for (j = i+1; j < n; j++){
                if (a[j] < a[min]) min = j;
            }
            swap(a[i], a[min]);
        }
    }
    void bubbleSort(int a[], int n){
        int i, j;
        for (i = (n-1); i >= 0; i--) {
            for (j = 1; j <= i; j++){
                if (a[j-1] > a[j])
                    swap(a[j-1],a[j]);
            }
        }
    }
}
