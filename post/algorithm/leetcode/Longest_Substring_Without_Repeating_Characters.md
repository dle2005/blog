## 문제
Given a string s, find the length of the longest substring without repeating characters.  
문자열 s가 주어지면, 반복되는 문자가 없는 가장 긴 부분 문자열의 길이를 찾으세요.

<br>
<br>

### Example 1:
~~~
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
~~~

### Example 2:
~~~
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
~~~

### Example 3:
~~~
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
~~~

#### 제약 사항:
- 0 <= s.length <= 5 * 104
- s consists of English letters, digits, symbols and spaces. (s는 영문자, 숫자, 기호 및 공백으로 구성됩니다.)

## 문제 풀이
1. 반복되는 문자가 없는지 Map을 사용하여 검사합니다.
    - key: s의 i번째 문자, value: i
    - Map에 있는 경우 반복되는지 확인합니다.
2. 가장 긴 부분 문자열의 길이의 시작 부분을 front에 저장 합니다.
    - 반복되는 문자가 발생하고, 해당 문자가 문자열의 시작부분 보다 뒤에 있는 경우, front를 반복 문자열의 다음 위치로 조정합니다.
3. 가장 긴 부분 문자열은 front와 i || s의 길이로 구해집니다.
    - 반복되는 문자가 발생할 경우, 현재 부분 문자열의 길이를 구하고 가장 긴 부분 문자열인 경우 answer를 갱신합니다.
    - 반복되는 문자가 발생하지 않는 경우에 마지막에 s의 길이와 front를 통해 구합니다.    

## 소스 코드
~~~
import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = s.length() == 0 ? 0 : 1, front = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c) && map.get(c) >= front) {
                answer = Math.max(i - front, answer);
                front = map.get(c) + 1;
            }

            map.put(c, i);
        }
        answer = Math.max(s.length() - front, answer);

        return answer;
    }
}
~~~
