## 문제
Implement the <span style='background-color:#f6f9fa'>myAtoi(string s)</span> function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).  
문자열을 32비트 부호 있는 정수로 변환하는 <span style='background-color:#f6f9fa'>myAtoi(string s)</span>함수를 구현합니다(C/C++의 atoi함수와 유사).  

The algorithm for <span style='background-color:#f6f9fa'>myAtoi(string s)</span> is as follows:  
<span style='background-color:#f6f9fa'>myAtoi(string s)</span>의 알고리즘은 다음과 같습니다:
1. Read in and ignore any leading whitespace. 공백을 읽고 무시하세요.
2. Check if the next character (if not already at the end of the string) is '-' or '+'. 다음 문자(문자열 끝에 아직 없는 경우)가 '-' 또는 '+'인지 확인합니다. Read this character in if it is either. 둘 중 하나인 경우 이 문자를 읽으세요. This determines if the final result is negative or positive respectively. 이것은 최종 결과가 음수인지 양수인지를 결정합니다. Assume the result is positive if neither is present. 둘 다 없으면 결과가 양수라고 가정합니다.
3. Read in next the characters until the next non-digit character or the end of the input is reached. 다음 문자가 숫자가 아닌 문자 또는 입력의 끝에 도달할 때까지 다음 문자를 읽으세요. The rest of the string is ignored. 나머지 문자열은 무시됩니다.
4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). 이 숫자들을 정수로 변환합니다 (예: "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. 읽은 숫자가 없다면 정수는 0입니다. Change the sign as necessary (from step 2). 필요에 따라 부호를 변경합니다 (2단계로부터).
5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. 정수가 32비트 부호 있는 정수 범위 [-231, 231 - 1]를 벗어나면 해당 범위에 남아 있는 정수를 클램프합니다. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1. 특히, 정수가 -231보다 작은 경우 -231로, 231 -1보다 큰 정수는 231 -1로 고정해야 합니다.
6. Return the integer as the final result. 정수를 최종 결과로 반환하세요.

<b>Note:</b>: 
- Only the space character ' ' is considered a whitespace character. 공백 문자 ' '만 공백 문자로 간주됩니다.
- Do not ignore any characters other than the leading whitespace or the rest of the string after the digits. 공백 또는 숫자 뒤의 나머지 문자열 이외의 문자를 무시하지 마세요.
<br>


<span style='background-color:#f6f9fa'> 글 바탕 </span>

<br>
<br>

### Example 1:
~~~
Input: s = "42"
Output: 42
Explanation: The underlined characters are what is read in, the caret is the current reader position. 
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
The parsed integer is 42.
Since 42 is in the range [-231, 231 - 1], the final result is 42.
~~~

### Example 2:
~~~
Input: s = "   -42"
Output: -42
Explanation:
Step 1: "   -42" (leading whitespace is read and ignored)
            ^
Step 2: "   -42" ('-' is read, so the result should be negative)
             ^
Step 3: "   -42" ("42" is read in)
               ^
The parsed integer is -42.
Since -42 is in the range [-231, 231 - 1], the final result is -42.
~~~

### Example 3:
~~~
Input: s = "4193 with words"
Output: 4193
Explanation:
Step 1: "4193 with words" (no characters read because there is no leading whitespace)
         ^
Step 2: "4193 with words" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "4193 with words" ("4193" is read in; reading stops because the next character is a non-digit)
             ^
The parsed integer is 4193.
Since 4193 is in the range [-231, 231 - 1], the final result is 4193.
~~~

<br>

### 제약조건:
- 0 <= s.length <= 200
- s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

<br>

## 문제 풀이
문제 설명이 너무 복잡하고 이해하기 어려웠던 문제였습니다.  
1. 문자열의 첫번째 단어(?)에서만 계산합니다.
    - 첫번째 단어가 숫자가 아닐 수 있습니다.
        - if 문의 마지막 else에 해당, return 0;
    - 빈 문자열이 주어질 수 있습니다.
        - if 문의 처음에 해당, 길이 비교하여 return 0;
2. 단어의 앞에 부호가 붙어 있는 경우가 있습니다.
    - 부호가 있는 경우는 부호 뒤는 숫자로만 이루어져있습니다. 부호 뒤에 단어가 오는 경우는 없습니다.
    - 부호 뒤의 숫자를 계산한다음 부호를 붙여 return 합니다.
3. 숫자로만 이루어져있는 경우가 있습니다.

## 소스코드
~~~
class Solution {
    public static int myAtoi(String s) {
        String str = s.stripLeading().split("\\s+")[0];

        if (str.length() == 0) {
            return 0;
        } else if (str.charAt(0) == '+') {
            return convert(str.substring(1), false);
        } else if (str.charAt(0) == '-') {
            return convert(str.substring(1), true);
        } else if (Character.isDigit(str.charAt(0))) {
            return convert(str, false);
        } else {
            return 0;
        }
    }

    public static int convert(String s, boolean isNegative) {
        long value = 0;

        for (int idx = 0; idx < s.length() && Character.isDigit(s.charAt(idx)); idx++) {
            value = value * 10 + Character.getNumericValue(s.charAt(idx));

            if (value > Integer.MAX_VALUE) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        return (int) (isNegative ? -value : value);
    }
}
~~~
