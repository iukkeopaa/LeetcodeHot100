package Array.Q189;

public class ArrayRotation {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    //ʹ����ʱ����
    public void rotate2(int nums[], int k) {
        int length = nums.length;
        int temp[] = new int[length];
        //��ԭ����ֵ�ŵ�һ����ʱ�����У�
        for (int i = 0; i < length; i++) {
            temp[i] = nums[i];
        }
        //Ȼ���ڰ���ʱ�����ֵ���·ŵ�ԭ���飬���������ƶ�kλ
        for (int i = 0; i < length; i++) {
            nums[(i + k) % length] = temp[i];
        }
    }


    //������
    public void rotate3(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse1(nums, 0, length - 1);//�ȷ�תȫ����Ԫ��
        reverse1(nums, 0, k - 1);//�ڷ�תǰk��Ԫ��
        reverse1(nums, k, length - 1);//���ŷ�תʣ���
    }

    //�������д�[start��end]֮���Ԫ����������,Ҳ���Ƿ�ת
    public void reverse1(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public void rotate4(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse1(nums, 0, length - k - 1);//�ȷ�תǰ���
        reverse1(nums, length - k, length - 1);//���ŷ�ת����k��
        reverse1(nums, 0, length - 1);//����ڷ�תȫ����Ԫ��
    }



    //�� n �� k �����Լ�� ���� 1 ��ʱ��1 �α����Ϳ�����ɽ��������� n=5,k=3
    //�� n �� k �����Լ�� ������ 1 ��ʱ��1 �α������޷���ɵ�����Ԫ�ع�λ����Ҫ m (���Լ��) ��


    public static void rotate5(int[] nums, int k) {
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            index = (index + k) % length;
            if (visited[index]) {
                //������ʹ����ٴη��ʵĻ��������ԭ�ش�ת������
                //�����ٷ��ʵ�ǰԪ���ˣ�����ֱ�Ӵ�������һ��Ԫ�ؿ�ʼ
                index = (index + 1) % length;
                hold = nums[index];
                i--;
            } else {
                //�ѵ�ǰֵ��������һ��λ�ã�����֮ǰҪ����һ��λ�õ�
                //ֵ����¼����
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }




    public void rotate6(int[] nums, int k) {
        int len  = nums.length;
        k = k % len;
        int count = 0;         // ��¼����λ�õĴ�����n��ͬѧһ����Ҫ��n��
        for(int start = 0; count < len; start++) {
            int cur = start;       // ��0λ�ÿ�ʼ��λ��
            int pre = nums[cur];
            do{
                int next = (cur + k) % len;
                int temp = nums[next];    // ��������...
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            }while(start != cur)  ;     // ѭ����ͣ���ص���ʼλ�ã���������

        }
    }



    public static void main(String[] args) {
        //��һ�����

//        int[] nums = {1, 2, 3, 4, 5, 6, 7};
//        int k = 3;
        //�ڶ������
        int[] mums1={1,2,3,4,5,6};
        int k1=4;
//        rotate5(nums, k);
//        for (int num : nums) {
//            System.out.print(num + " ");
//        }
        rotate5(mums1,k1);
        for (int num : mums1){
            System.out.print(num+" ");
        }
    }
}    