## 문제
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.  
로마 숫자는 I, V, X, L, C, D 그리고 M의 7가지 기호로 표시됩니다.  
<br>

|Symbol| Value |
|:---|:------|
|I             | 1     |
|V             | 5     |
|X             | 10    |
|L             | 50    |
|C             |100|
|D             |500|
|M             |1000|

<br>

For example, 2 is written as II in Roman numeral, just two one's added together.  
예를 들어, 2는 로마 숫자로 II로 표기되며, 일을 두번 더하면 됩니다.  
<br>
12 is written as XII, which is simply X + II.  
12는 XII로 표기되며, 단순히 X + II입니다.  
<br>
The number 27 is written as XXVII, which is XX + V + II.  
숫자 27은 XXVII로 표기되며, XX + V + II입니다.  
<br>
Roman numerals are usually written largest to smallest from left to right.  
로마 숫자는 일반적으로 왼쪽에서 오른쪽으로 큰 것에서 작은 것 순으로 표기합니다.  
<br>
However, the numeral for four is not IIII.  
그러나, 4에 대한 숫자는 IIII가 아닙니다.  
<br>
Instead, the number four is written as IV.  
대신에, 숫자 4는 IV로 표기됩니다.
<br>
Because the one is before the five we subtract it making four.  
1은 5보다 앞에 있기 때문에 빼서 4가 됩니다.  
<br>
The same principle applies to the number nine, which is written as IX.  
IX로 쓰여진 숫자 9에도 동일한 원칙이 적용됩니다.  
<br>
There are six instances where subtraction is used: 빼기가 사용되는 6가지 경우가 있습니다.
- I can be placed before V (5) and X (10) to make 4 and 9.
- X can be placed before L (50) and C (100) to make 40 and 90.
- C can be placed before D (500) and M (1000) to make 400 and 900.

Given an integer, convert it to a roman numeral.  
정수가 주어지면, 로마 숫자로 변환하세요.

<br>
<br>

### Example 1:
~~~
Input: s = "III"
Output: 3
Explanation: III = 3.
~~~

### Example 2:
~~~
Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
~~~

### Example 3:
~~~
Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
~~~

<br>

### 제약조건:
- 1 <= num <= 3999
  <br>

## 문제 풀이
1. 기본 로마 숫자 7가지와 빼기가 사용되는 6가지 경우에 대해서 HashMap을 사용하여 저장합니다.
2. 문자열을 순회하며 로마숫자의 값을 찾습니다.
- 빼기가 사용되는 경우를 찾기위해서 두 글자와, 한 글자로 나눠 탐색을 합니다.
    - 두 글자를 먼저 검사해서 빼기가 사용되는 경우를 먼저 확인할 수 있습니다.

## 소스코드
~~~
private static final Map<String, Integer> romanSymbolMap = new HashMap<>() {
        {
            put("M", 1000);
            put("CM", 900);
            put("D", 500);
            put("CD", 400);
            put("C", 100);
            put("XC", 90);
            put("L", 50);
            put("XL", 40);
            put("X", 10);
            put("IX", 9);
            put("V", 5);
            put("IV", 4);
            put("I", 1);
        }
    };

    public static int romanToInt(String s) {
        int answer = 0;

        for (int idx = 0; idx < s.length(); ) {
            String twoChSubStr = s.substring(idx, Math.min(s.length(), idx + 2));
            String oneChSubStr = s.substring(idx, idx + 1);

            if (romanSymbolMap.containsKey(twoChSubStr)) {
                answer += romanSymbolMap.get(twoChSubStr);
                idx += 2;
            } else {
                answer += romanSymbolMap.get(oneChSubStr);
                idx++;
            }
        }

        return answer;
    }
~~~
