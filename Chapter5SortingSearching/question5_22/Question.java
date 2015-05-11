/**
    5.22    Find all inversion Pairs in array
    Inversion Count for an array indicates – how far (or close) the array is from being sorted. If array is already sorted then inversion count is 0. If array is sorted in reverse order that inversion count is the maximum. 
    Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
    Example:
    The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
    http://www.geeksforgeeks.org/counting-inversions/
 */

package question5_22;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public static List<List<Integer>> findInversionSlow(int[] array) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=0; i<array.length-1; i++){
            for(int j=i; j<array.length; j++){
                if(array[i]>array[j]){
                    List<Integer> newPair = new ArrayList<Integer>();
                    newPair.add(array[i]);
                    newPair.add(array[j]);
                    result.add(newPair);
                }
            }
        }
        return result;
    }
    
    public static List<List<Integer>> findInversionFast(int[] array) {
        List<List<Integer>> pairs = new ArrayList<List<Integer>>();
        mergeSort(array, 0, array.length-1, pairs);
        
        return pairs;
    }
    
    public static void mergeSort(int[] array, int left, int right, List<List<Integer>> pairs){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(array, left, mid, pairs);
            mergeSort(array, mid+1, right, pairs);
            merge(array, left, mid, right, pairs);
        }
    }
    
    public static void merge(int[] array, int left, int mid, int right, List<List<Integer>> pairs){
        int[] temp = new int[array.length];
        int index = left;
        int indexLeft = left;
        int indexRight = mid+1;
        while(indexLeft<=mid && indexRight<=right){
            if(array[indexLeft]<=array[indexRight]){
                temp[index++] = array[indexLeft++];
            } else if(array[indexLeft]>array[indexRight]) {
                for(int i=mid+1; i<=indexRight; i++){
                    List<Integer> pair = new ArrayList<Integer>();
                    pair.add(array[indexLeft]);
                    pair.add(array[i]);
                    pairs.add(pair);
                }

                temp[index++] = array[indexRight++];
            }
        }
        
        if(indexLeft<=mid){
            temp[index++] = array[indexLeft++];
            while(indexLeft<=mid){
                for(int i=mid+1; i<=right; i++){
                    List<Integer> pair = new ArrayList<Integer>();
                    pair.add(array[indexLeft]);
                    pair.add(array[i]);
                    pairs.add(pair);
                }
                temp[index++] = array[indexLeft++];
            }
        }

        while(indexRight<=right){
            temp[index++] = array[indexRight++];
        }
        for(int i=left; i<=right; i++){
            array[i] = temp[i];
        }
        
    }
    
    
    
    public static void main(String[] args) {
        int[] array = {2,4,1,3,5};
        List<List<Integer>> pairs = findInversionFast(array);
        for(List<Integer> pair : pairs){
            for(Integer element : pair){
                System.out.print(element+" ");
            }
            System.out.println();
        }
        
        
    }

}
