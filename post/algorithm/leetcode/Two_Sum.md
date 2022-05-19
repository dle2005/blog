## 문제
Given an array of integers <span style='background-color:#f6f9fa'>nums</span> and an integer <span style='background-color:#f6f9fa'>target</span>, return indices of the two numbers such that they add up to target.  
정수 배열 nums와 정수 대상이 주어지면, 대상을 만들수 있는 두 숫자의 인덱스를 반환하세요.
<br>
You may assume that each input would have <b>exactly one solution</b>, and you may not use the same element twice.  
각 입력에는 정확히 하나의 솔루션이 있다고 가정하고, 동일한 요소를 두 번 사용할 수 없습니다.
<br>
You can return the answer in any order.  
어떤 순서로든 정답을 반환할 수 있습니다.

<br>
<br>

### Example 1:
~~~
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
~~~

### Example 2:
~~~
Input: nums = [3,2,4], target = 6
Output: [1,2]
~~~

### Example 3:
~~~
Input: nums = [3,3], target = 6
Output: [0,1]
~~~

<br>

### 제약조건:
- 2 <= nums.length <= 104
- -109 <= nums[i] <= 109
- -109 <= target <= 109
- <b>Only one valid answer exists.</b> (하나의 유효한 답변만 존재합니다.)

<br>

<b>Follow-up</b>: Can you come up with an algorithm that is less than O(n2) time complexity?  
시간 복잡도를 O(n2)보다 작은 알고리즘을 생각해낼 수 있습니까?

<br>


## 문제 풀이 (시간복잡도 O(n))
Map을 사용해서 <b>시간복잡도 O(n)</b>으로 해결하는 방법입니다.  
1. nums 배열을 순회하며 map에 nums 배열의 요소들을 저장합니다.
    - key: nums 배열의 요소(정수), value: index 
2. map에서 'target - 요소'의 요소를 찾습니다.
    - 요소가 존재한다면, 두 요소로 타겟을 만들 수 있습니다.
    - 현재 요소의 index와 map에서 찾은 요소의 index를 반환합니다.

## 소스코드
~~~
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            
            map.put(nums[i], i);
        }
        
        return null;
    }
}
~~~

<br>

## 문제 풀이 (시간복잡도 O(n2))
<b>시간복잡도 O(n2)</b>로 푸는 방법은 쉽게 생각해볼 수 있습니다.  

nums의 두 개의 정수를 더하는 모든 경우의 수를 탐색하여 대상을 찾는 경우 리턴하면 됩니다.

## 소스 코드
~~~
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}
~~~