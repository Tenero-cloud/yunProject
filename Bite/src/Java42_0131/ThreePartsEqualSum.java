package Java42_0131;

public class ThreePartsEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int left = 0;
        int leftSum = A[0];
        int right = A.length - 1;
        int rightSum = A[A.length - 1];
        // while 的循环条件中使用减一是因为要分成三个部分, 不减一会分成两个部分
        while (left < right - 1) {
            if (leftSum == sum / 3 && rightSum == sum / 3) {
                // 三等分
                return true;
            }
            // 如果左边部分不相等
            if (leftSum != sum / 3) {
                // 更新 left 位置, 并且记录更新后的 leftSum 的值
                left++;
                leftSum += A[left];
            }
            // 如果右边部分不相等
            if (rightSum != sum / 3) {
                // 更新 right 的位置, 并记录更新后的 rightSum 的值
                right--;
                rightSum += A[right];
            }
        }
        // 找完还没找到, 返回 false
        return false;
    }
}


