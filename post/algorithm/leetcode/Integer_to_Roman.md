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
Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
~~~

### Example 2:
~~~
Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
~~~

### Example 3:
~~~
Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
~~~

<br>

### 제약조건:
- 1 <= num <= 3999
<br>

## 문제 풀이
1. 기본 로마 숫자 7가지와 빼기가 사용되는 6가지 경우에 대해서 LinkedHashMap을 사용해서 저장합니다. 
    - 큰 숫자부터 비교하기 위해서 순서가 있는 LinkedHashMap을 사용했습니다.
2. 큰 숫자부터 비교하면서 나누었을 때 0인지 검사합니다.
    - 나누었을 때 0인 경우 해당 숫자를 뺄 수 있기 때문입니다.
3. 2의 조건이 성립하면, 로마 숫자 사용할 수 있는 반복 횟수 만큼 추가해줍니다.
     - num 을 숫자로 나누었을 때 나오는 숫자가 반복 횟수가 됩니다.
     - 반복해서 추가는 repeat() 함수를 사용합니다.
4. 숫자를 로마 숫자를 추가한 만큼 빼줍니다.

## 소스코드
~~~
static private final Map<Integer, String> romanSymbolMap = new LinkedHashMap<>() {
        {
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }
    };

    public static String intToRoman(int num) {
        StringBuilder answer = new StringBuilder();

        for (Map.Entry<Integer, String> entry : romanSymbolMap.entrySet()) {
            if (num / entry.getKey() != 0) {
                answer.append(entry.getValue().repeat(num / entry.getKey()));
                num -= entry.getKey() * (num / entry.getKey());
            }
        }

        return answer.toString();
    }
~~~
