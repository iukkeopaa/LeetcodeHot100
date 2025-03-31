package Heap.Q215;

import java.util.Arrays;

public class BFPTR {
    // ��������������Ԫ�ص�λ��
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // �������ָ��������в�������
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

    // �ҵ������е� k С��Ԫ��
    public static int bfptr(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }
        // �ҵ���λ������λ��
        int pivot = medianOfMedians(arr, left, right);
        // �� pivot Ϊ��׼���л���
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

    // �ҵ���λ������λ��
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

    // �� pivot Ϊ��׼���л���
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
        System.out.println("�� " + k + " С��Ԫ����: " + result);
    }
}    