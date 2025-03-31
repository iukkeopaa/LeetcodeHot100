package Heap.Q215;

import java.util.Arrays;

public class BFPTR {
    // 交换数组中两个元素的位置
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 对数组的指定区间进行插入排序
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 找到数组中第 k 小的元素
    public static int bfptr(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        // 找到中位数的中位数
        int pivot = medianOfMedians(arr, left, right);
        // 以 pivot 为基准进行划分
        int pivotIndex = partition(arr, left, right, pivot);
        int rank = pivotIndex - left + 1;
        if (k == rank) {
            return arr[pivotIndex];
        } else if (k < rank) {
            return bfptr(arr, left, pivotIndex - 1, k);
        } else {
            return bfptr(arr, pivotIndex + 1, right, k - rank);
        }
    }

    // 找到中位数的中位数
    private static int medianOfMedians(int[] arr, int left, int right) {
        int n = right - left + 1;
        if (n <= 5) {
            insertionSort(arr, left, right);
            return arr[left + n / 2];
        }
        int numMedians = n / 5;
        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = subLeft + 4;
            insertionSort(arr, subLeft, subRight);
            swap(arr, left + i, subLeft + 2);
        }
        return bfptr(arr, left, left + numMedians - 1, numMedians / 2 + 1);
    }

    // 以 pivot 为基准进行划分
    private static int partition(int[] arr, int left, int right, int pivot) {
        for (int i = left; i <= right; i++) {
            if (arr[i] == pivot) {
                swap(arr, i, right);
                break;
            }
        }
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int k = 3;
        int result = bfptr(arr, 0, arr.length - 1, k);
        System.out.println("第 " + k + " 小的元素是: " + result);
    }
}    