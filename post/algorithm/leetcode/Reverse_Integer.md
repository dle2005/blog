## 문제
Given a signed 32-bit integer <span style='background-color:#f6f9fa'>x</span>, return <span style='background-color:#f6f9fa'>x</span> with its digits reversed. If reversing <span style='background-color:#f6f9fa'>x</span> causes the value to go outside the signed 32-bit integer range <span style='background-color:#f6f9fa'>[-231, 231 - 1]</span>, then return <span style='background-color:#f6f9fa'>0</span>.  
부호 있는 32비트 정수 <span style='background-color:#f6f9fa'>x</span>이 주어지면 숫자가 반전된 <span style='background-color:#f6f9fa'>x</span>를 반환합니다. <span style='background-color:#f6f9fa'>x</span>를 반전하면 값이 부호 있는 32비트 정수 범위 <span style='background-color:#f6f9fa'>[-231, 231 - 1]</span>를 벗어나면 0을 반환합니다.  
<br>
<b> Assume the environment does not allow you to store 64-bit integers (signed or unsigned).</b>  
<b>65비트 정수(부호가 있거나 없는)를 저장할 수 없는 환경이라고 가정합니다.</b>
<br>
<br>

### Example 1:
~~~
Input: x = 123
Output: 321
~~~

### Example 2:
~~~
Input: x = -123
Output: -321
~~~

### Example 3:
~~~
Input: x = 120
Output: 21
~~~

<br>

### 제약조건:
- -231 <= x <= 231 - 1
<br>

## 문제 풀이
1. x를 다음과 같은 방법으로 반전합니다.
    - answer * 10 + x % 10
        - 반전한 값을 * 10하여 한자리 앞으로 옮김니다.
        - x의 10의 자리 수를 맨 뒤에 추가합니다.
    - while (x != 0) x가 0이 될때까지 반복합니다.
2. 32비트 정수 범위를 넘어가는지 확인합니다.
    - overflowCheck 변수를 사용하여 새로 구한 값을 역으로 계산했을 때, 이전 값과 같은지 비교합니다.
    - 범위를 넘어가는 경우 두 값이 다릅니다.    

## 소스코드
~~~
class Solution {
    public int reverse(int x) {
        int answer = 0;

        while (x != 0) {
            int overflowCheck = answer * 10 + x % 10;

            if ((overflowCheck - x % 10) / 10 != answer) {
                return  0;
            }

            x /= 10;
            answer = overflowCheck;
        }

        return answer;
    }
}
~~~
