## 문제
Given a string s, return the longest palindromic substring in s.  
문자열 s가 주어지면, s에서 가장 긴 회문(palindromic) 부분 문자열을 반환하세요.

<br>

~~~
회문이란?

회문(回文) 또는 팰린드롬(palindrome)은 거꾸로 읽어도 제대로 읽는 것과 같은 문장이나 낱말, 숫자, 문자열(sequence of characters) 등이다. 보통 낱말 사이에 있는 띄어쓰기나 문장 부호는 무시한다.

출처: 회문 - 위키백과
~~~

<br>

###Example 1:
~~~
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
~~~

### Example 2:
~~~
Input: s = "cbbd"
Output: "bb"
~~~ 

### 제약 사항:
- 1 <= s.length <= 1000
- s consist of only digits and English letters. (s는 숫자와 영문자로만 포함합니다.)

## 문제 풀이
!~~ 제가 푼 방법은 빠른 방법은 아닙니다... DP를 사용해서 푸는 방법도 있지만, 워낙 유명한 방법이고 비슷한 문제가 많으므로 다른 방식으로 접근해봤습니다. ~~!

1. 문자열의 길이부터 1이상까지 회문을 찾습니다.
    - 예제의 babad의 경우
        - b(0) ~ d(4) 길이 5
        - b(0) ~ a(3) 길이 4
        - a(1) ~ d(4) 길이 4
        - b(0) ~ b(2) 길이 3
2. 최대길이 부터 하나씩 줄여가며 회문을 찾아 리턴하는 방식입니다.


## 소스 코드
~~~
class Solution {
    public String longestPalindrome(String s) {
        for (int len = s.length(); len > 1; len--) {
            for (int idx = 0; idx + len <= s.length(); idx++) {
                boolean isValid = true;

                for (int i = 0; i < len / 2; i++) {
                    if (s.charAt(idx + i) != s.charAt(idx + len - i - 1)) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    return s.substring(idx, idx + len);
                }
            }
        }

        return s.substring(0, 1);
    }
}
~~~