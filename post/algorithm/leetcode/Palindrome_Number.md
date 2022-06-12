## 문제
Given an integer <span style='background-color:#f6f9fa'>x</span>, return <span style='background-color:#f6f9fa'>true</span> if <span style='background-color:#f6f9fa'>x</span> is palindrome integer.  
정수 <span style='background-color:#f6f9fa'>x</span>가 주어지면, <span style='background-color:#f6f9fa'>x</span>가 회문 정수이면 <span style='background-color:#f6f9fa'>true</span>를 반환하세요.  
<br>
An integer is a <b>palindrome</b> when it reads the same backward as forward.  
정수는 정방향과 역방향이 같을 때 <b>회문</b>입니다.  
<br>
For example, <span style='background-color:#f6f9fa'>121</span> is a palindrome while <span style='background-color:#f6f9fa'>123</span> is not.  
예를 들어, <span style='background-color:#f6f9fa'>121</span>은 회문이지만 <span style='background-color:#f6f9fa'>123</span>은 아닙니다.  
<br>
~~~
회문이란?

회문(回文) 또는 팰린드롬(palindrome)은 거꾸로 읽어도 제대로 읽는 것과 같은 문장이나 낱말, 숫자, 문자열(sequence of characters) 등이다. 보통 낱말 사이에 있는 띄어쓰기나 문장 부호는 무시한다.

출처: 회문 - 위키백과
~~~
<br>
<br>

### Example 1:
~~~
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
~~~

### Example 2:
~~~
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
~~~

### Example 3:
~~~
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
~~~

<br>

### 제약조건:
- -231 <= x <= 231 - 1
<br>

<b>Follow-up</b>: 
Could you solve it without converting the integer to a string?  
정수를 문자열로 변환하지 않고 해결할 수 있습니까?
<br>

## 문제 풀이 (시간복잡도 O(n))
1. 가운데를 기준으로 left, right로 나누어 계산하였습니다.
2. right가 left보다 커지기 전까지 반복을 하여 가운데를 기준으로 나눕니다.
3. left는 10씩 나누고, right는 뒤의 숫자를 붙여가며 구합니다.
4. 짝수인 경우 left == right로 계산되며, 홀수는 right를 10으로 나누어 계산합니다.

## 소스코드
~~~
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int left = x, right = 0;
        while (left > right) {
            right = right * 10 + left % 10;
            left /= 10;
        }

        return (left == right || left == right / 10);
    }
}
~~~