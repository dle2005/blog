## 문제
Given an input string <span style='background-color:#f6f9fa'>s</span> and a pattern <span style='background-color:#f6f9fa'>p</span>, implement regular expression matching with support for <span style='background-color:#f6f9fa'>'.'</span> and <span style='background-color:#f6f9fa'>'*'</span> where:  
문자열 s와 패턴 p가 주어졌을때, '.'와 '*'와 일치하는 정규표현식을 구현하세요.
- <span style='background-color:#f6f9fa'>'.'</span> Matches any single character.​​​​ '.'은 한 문자와 일치합니다.
- <span style='background-color:#f6f9fa'>'*'</span> Matches zero or more of the preceding element. '*'은 0개 이상의 선행 요소와 일치합니다.  

The matching should cover the <strong>entire</strong> input string (not partial).
일치는 전체 문자열을 커버해야합니다. (부분이 아님)
<br>
<br>

### Example 1:
~~~
Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
~~~

### Example 2:
~~~
Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
~~~

### Example 3:
~~~
Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
~~~

<br>

### 제약조건:
- 1 <= s.length <= 20
- 1 <= p.length <= 30
- s contains only lowercase English letters. s는 오직 영어 소문자만 포함합니다.
- p contains only lowercase English letters, '.', and '*'. p는 오직 영어 소문자와 '.', 그리고 '*'을 포함합니다.
- It is guaranteed for each appearance of the character '*', there will be a previous valid character to match. 각 '*' 문자 등장시 이전에 유효한 문자가 있을것을 보장합니다.
<br>


## 문제 풀이 (시간복잡도 O(n))

## 소스코드
~~~

~~~
