package Heap.Q215;

import java.util.Arrays;

public class BFPRT {

    // ��������
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

    // ��������
    private static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, storeIndex);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right);
        return storeIndex;
    }

    // ��������������Ԫ�ص�λ��
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // ѡ��� k С��Ԫ��
    private static int select(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        int numElements = right - left + 1;
        if (numElements < 5) {
            insertionSort(arr, left, right);
            return arr[left + k - 1];
        }
        int numMedians = numElements / 5;
        for (int i = 0; i < numMedians; i++) {
            int subLeft = left + i * 5;
            int subRight = subLeft + 4;
            int medianIndex = subLeft + 2;
            insertionSort(arr, subLeft, subRight);
            swap(arr, left + i, medianIndex);
        }
        int medianOfMedians = select(arr, left, left + numMedians - 1, numMedians / 2 + 1);
        int pivotIndex = -1;
        for (int i = left; i <= right; i++) {
            if (arr[i] == medianOfMedians) {
                pivotIndex = i;
                break;
            }
        }
        pivotIndex = partition(arr, left, right, pivotIndex);
        int rank = pivotIndex - left + 1;
        if (k == rank) {
            return arr[pivotIndex];
        } else if (k < rank) {
            return select(arr, left, pivotIndex - 1, k);
        } else {
            return select(arr, pivotIndex + 1, right, k - rank);
        }
    }

    // �����ṩ�Ĳ��ҵ� k СԪ�صķ���
    public static int bfptr(int[] arr, int k) {
        return select(arr, 0, arr.length - 1, k);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int k = 3;
        int result = bfptr(arr, k);
        System.out.println("�� " + k + " С��Ԫ����: " + result);
    }
}    