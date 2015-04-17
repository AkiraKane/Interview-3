/**
    5.2     Common Sorting algorithm
    Implementation of Bubble sort
    O(n^2)
     
    Implementation of Selection Sort
    O(n^2)
     
    Implementation of Merge sort
    O(nlogn)
     
    Implementation of quick sort
    O(nlogn)
     
    Heap sort
    O(nlogn)
 */
package question5_2;

public class Question {
    // bubble sort
    public static void bubbleSort(int[] array){
        for(int i=array.length-1; i>0;i--){
            for(int j=0; j<i; j++){
                // compare array[i] with array[i+1], put the bigger one at the higher position
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
    
    // insertion sort
    public static void insertionSort(int[] array){
        for(int i=array.length-1; i>0; i--){
            // find the index of the largest element, swap it with position i
            int large = Integer.MIN_VALUE;
            int largeIndex=-1;
            for(int j=0; j<=i; j++){
                if(array[j]>large){
                    largeIndex=j;
                    large = array[j];
                }
            }
            //swap
            int temp = array[largeIndex];
            array[largeIndex] = array[i];
            array[i] = temp;
        }
    }

    // merge sort O(n2)
    public static void mergeSort(int[] array, int low, int high){
        if(low<high){
            int middle = (low+high)/2;
            mergeSort(array, low, middle);
            mergeSort(array, middle+1, high);
            merge(array, low, middle, high);
        }
    }
    
    public static void merge(int[] array, int low, int middle, int high){
        int[] helper = new int[array.length];
        
        for(int i=low; i<=high; i++){
            helper[i] = array[i];
        }
        
        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;
        
        while(helperLeft<=middle && helperRight<=high){
            if(helper[helperLeft]<=helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        
//        if(helperLeft>middle){
//            for(int i=helperRight; i<=high; i++){
//                array[current+i-helperRight]=helper[i];
//            }
//        } else if(helperRight>high){
//            for(int i=helperLeft; i<=middle; i++){
//                array[current+i-helperLeft]=helper[i];
//            }
//        }
        
        for(int i=helperLeft; i<=middle; i++){
            array[current+i-helperLeft]=helper[i];
        }
    }
    
    // quick sort
    public static void quickSort(int[] arr, int left, int right){
        int index = partition(arr, left, right);
        if(left<index-1){
            quickSort(arr, left, index-1);
        }
        if(index<right){
            quickSort(arr, index,  right);
        }
    }
    
    public static int partition(int[] arr, int left, int right){
        int pivot = arr[(left+right)/2];
        while(left<=right){
            while(arr[left]<pivot) left++;
            while(arr[right]>pivot) right--;
            if(left<=right){
                //swap(arr, left, right);
                int temp = arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                
                left++;
                right--;
            }
            
            
        }
        
        return left;
    }
    
    
    public static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array1 = {4,3,5,1,2};
        bubbleSort(array1);
        print(array1);
        
        int[] array2 = {4,3,5,1,2};
        insertionSort(array2);
        print(array2);
        
        int[] array3 = {5,4,3,2,1,0};
        mergeSort(array3, 0, array3.length-1);
        print(array3);
        
        int[] array4 = {4,3,5,1,2};
        quickSort(array4, 0, array4.length-1);
        print(array4);
    }

}
