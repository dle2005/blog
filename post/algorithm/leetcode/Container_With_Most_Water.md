## 문제
You are given an integer array <span style='background-color:#f6f9fa'>height</span> of length <span style='background-color:#f6f9fa'>n</span>.  
길이가 n인 정수 배열 'height'가 제공됩니다.  
<br>
There are <span style='background-color:#f6f9fa'>n</span> vertical lines drawn such that the two endpoints of the <span style='background-color:#f6f9fa'>ith</span> line are <span style='background-color:#f6f9fa'>(i, 0)</span> and <span style='background-color:#f6f9fa'>(i, height[i])</span>.  
i번째 선의 두 끝점이 (i, 0) 및 (i, height[i])가 되도록 n개의 수직선이 그려집니다.  
<br>
Find two lines that together with the x-axis form a container, such that the container contains the most water.  
컨테이너에 가장 많은 물이 포함되도록 컨테이너의 x축과 함께 형성하는 두 개의 선을 찾으세요.
<br>
Return the maximum amount of water a container can store.  
컨테이너가 저장할 수 있는 최대 물의 양을 반환하세요.
<br>

Notice that you may not slant the container.  
컨테이너를 기울이면 안 됩니다.

<br>
<br>

### Example 1:
~~~
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
~~~

### Example 2:
~~~
Input: height = [1,1]
Output: 1
~~~

<br>

### 제약조건:
- n == height.length
- 2 <= n <= 105
- 0 <= height[i] <= 104

<br>

## 문제 풀이
가장 많은 양의 물을 담기 위해서는 두 기둥 사이의 공간의 크기가 최대가 되는 기둥을 찾아야 합니다. 공간의 크기는 <b> 높이 * 넓이 </b> 입니다.  
<br>
왼쪽 끝 기둥과 오른쪽 끝 기둥에서 시작해서 넓이를 구하는 두 기둥을 욺직이며 가장 공간의 크기가 큰 경우를 찾습니다.  
<br>
왼쪽과 오른쪽 기둥을 비교하여 더 작은 기둥을 움직여야 더 큰 공간을 찾을 수 있는 경우가 생깁니다.

## 소스코드
~~~
class Solution {
    public static int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, getArea(left, right, height));

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static int getArea(int left, int right, int[] height) {
        int w = right - left, h = Math.min(height[left], height[right]);
        return w * h;
    }
}
~~~
