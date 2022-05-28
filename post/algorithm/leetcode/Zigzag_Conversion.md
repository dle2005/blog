## 문제
The string <span style='background-color:#f6f9fa'>"PAYPALISHIRING"</span> is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)  
문자열 <span style='background-color:#f6f9fa'>"PAYPALISHIRING"</span>은 다음과 같이 주어진 수의 행들에 지그재그 패턴으로 작성되어있습니다.(가독성을 높이기 위해 이 패턴을 고정 글꼴로 표시할 수 있습니다.)
<br>
~~~
P   A   H   N
A P L S I I G
Y   I   R
~~~
And then read line by line: <span style='background-color:#f6f9fa'>"PAYPALISHIRING"</span>  
그런 다음 한 줄씩 읽습니다: <span style='background-color:#f6f9fa'>"PAYPALISHIRING"</span>  
<br>
문자열을 가져가고 주어진 수의 행들을 변환하는 코드를 작성하세요:
~~~
string convert(string s, int numRows);
~~~

### Example 1:
~~~
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
~~~

### Example 2:
~~~
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
~~~

### Example 3:
~~~
Input: s = "A", numRows = 1
Output: "A"
~~~

<br>

### 제약조건:
- 1 <= s.length <= 1000
- s consists of English letters (lower-case and upper-case), ',' and '.'.
- 1 <= numRows <= 1000
<br>

## 문제 풀이
StringBuilder 배열을 사용함으로 같은 줄의 문자들을 동시에 저장하여 사용하도록 하였습니다.
<br>
단어를 배열하는 방향은 '아래'와 '대각선 위' 두가지 입니다.  
boolean 타입의 down 변수는 방향을 나타냅니다.  
<br>
어떤 행에 저장할지 cur_row 변수를 사용하였습니다.  
행은 방향에 따라서 이동하도록 하였습니다.  
맨 아래를 도달한경우와 다시 맨 위를 도달한 경우 방향을 변경하도록 하였습니다.

## 소스코드
~~~
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        StringBuilder[] zigzag = new StringBuilder[numRows];
        int idx = 0, cur_row = 0;
        boolean down = true;

        for (int i = 0; i < numRows; i++) {
            zigzag[i] = new StringBuilder();
        }

        while (idx != s.length()) {
            zigzag[cur_row].append(s.charAt(idx++));

            cur_row = down ? cur_row + 1 : cur_row - 1;
            down = (cur_row == numRows - 1 || cur_row == 0) != down;
        }

        StringBuilder answer = new StringBuilder();
        for (StringBuilder sb : zigzag) {
            answer.append(sb);
        }

        return answer.toString();
    }
}
~~~
