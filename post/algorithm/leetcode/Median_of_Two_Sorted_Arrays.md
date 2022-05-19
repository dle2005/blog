## 문제
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.  
크기가 각각 m 및 n인 두 개의 정렬된 배열 nums1 및 num2가 주어질 때, 두 개의 정렬된 배열의 중간값을 반환합니다.
<br>
The overall run time complexity should be O(log (m+n)).  
전체 시간복잡도는 O(log(m+n))이어야 합니다.

<br>
<br>

###Example 1:
~~~
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
~~~

### Example 2:
~~~
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
~~~ 

### 제약 사항:
- nums1.length == m
- nums2.length == n
- 0 <= m <= 1000
- 0 <= n <= 1000
- 1 <= m + n <= 2000
- -106 <= nums1[i], nums2[i] <= 106

## 문제 풀이
1. 각 배열의 인덱스를 저장하는 변수를 설정합니다.
2. 중간값을 찾을때까지 값들을 저장할 배열을 만듭니다.
    - 배열을 안만들고도 할 수 있지만, 편의상 배열을 만들고 저장하도록 하였습니다.
3. 인덱스의 합이 중간값일 때까지 값을 비교하며 저장합니다.
4. 리턴부분의 식을 적용하면 홀수인 경우와 짝수인 경우 모두 커버할 수 있습니다.


## 소스 코드
~~~
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int i1 = 0, i2 = 0;
        int[] sum = new int[(n + m) / 2 + 1];

        while (i1 + i2 != sum.length) {
            if (i1 == n) {
                sum[i1 + i2] = nums2[i2++];
            } else if (i2 == m) {
                sum[i1 + i2] = nums1[i1++];
            } else {
                sum[i1 + i2] = nums1[i1] < nums2[i2] ? nums1[i1++] : nums2[i2++];   
            }
        }
        
        return (sum[(n + m) / 2] + sum[(n + m - 1) / 2]) / 2.0;
    }
}
~~~