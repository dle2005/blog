## 문제
You are given two <b>non-empty</b> linked lists representing two non-negative integers.  
두 개의 음이 아닌 정수를 나타내는 두 개의 비어 있지 않은 링크드리스트가 제공됩니다.  
<br>
The digits are stored in <b>reverse order</b>, and each of their nodes contains a single digit.   
숫자는 역순으로 저장되어 있으며, 각 노드에는 단일 숫자가 포함되어 있습니다.  
<br>
Add the two numbers and return the sum as a linked list.  
두 숫자를 더하고 합을 링크드리스트로 반환합니다.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
두 숫자에는 숫자 0 자체를 제외하고는, 앞에 0이 포함되어 있지 않다고 가정할 수 있습니다.  

<br>
<br>

### Example 1:

~~~
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
~~~

### Example 2:  
~~~
Input: l1 = [0], l2 = [0]
Output: [0]  
~~~

### Example 3:
~~~
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 ~~~

### 제약조건:
- The number of nodes in each linked list is in the range [1, 100]. (각 링크드리스트의 노드 숫자는 [1, 100] 범위입니다.)
- 0 <= Node.val <= 9
- It is guaranteed that the list represents a number that does not have leading zeros. (목록은 앞에 0이 없는 숫자를 나태내는 것을 보장합니다.)


<br>

## 문제 풀이
1. 문제에 주어진 ListNode를 사용해야 합니다.
    - ListNode에는 값과 다음 ListNode 객체 참조 변수가 있습니다.
    - 자료구조의 링크드 리스트와 유사합니다.
2. ListNode의 시작 위치를 저장해둬야 합니다.
    - 탐색 시 시작 위치를 저장해둬야 탐색이 가능합니다.
    - iterator가 없으며, ListNode는 이전 객체 참조가 불가능 합니다.
3. li과 l2가 모두 탐색될때까지 반복하며, 두 값을 더해 answer ListNode에 저장합니다.
    - 한 자리의 숫자만 저장할 수 있으므로 10을 초과하는 값은 저장해두었다가 다음 자리수에 합산해줍니다.



## 소스 코드
~~~
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode answer = listNode;
        int roundUp = 0;

        while (l1 != null || l2 != null) {
            int sum = roundUp;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            roundUp = sum / 10;
            sum %= 10;

            listNode.next = new ListNode(sum);
            listNode = listNode.next;
        }

        if (roundUp > 0) {
            listNode.next = new ListNode(roundUp);
        }

        return answer.next;
    }
    
}
~~~