#### Intellij Custom Template 만들어 사용하기
Intellij에서 보통 템플릿이라고하면 <b>Live Template</b>을 생각할테지만, Live Template은 함수를 템플릿화하여 사용하기는 편해도 클래스 생성에서 사용하기는 불편한 점이 많다고 생각합니다.  
<br>
여기에서 소개해드릴 내용은 Class 파일을 Template으로 저장하여 쉽게 활용하는 방법입니다.  
<br>
Spring 프로젝트를 하며 Domain에서 @Entity, @Getter, @Id등 공통으로 사용되는 코드들을 매번 입력하지 않고 편하게 사용할 수 있습니다.
<br>
<br>
1. 우선 템플릿화할 파일을 작성합니다.

2. Intellij 상단의 Tools -> Save File as Template...를 선택해줍니다.

3. 저장할 Template 이름을 입력하시고 OK버튼을 선택해줍니다.

4. 이제 파일을 생성할때 새로 만든 템플릿이 목록에 추가되어있습니다. 해당 템플릿으로 클래스를 만들어 보겠습니다. 템플릿을 선택합니다.

5. 새로 만들 Class명을 입력합니다.

6. Test 클래스가 새로 만든 템플릿으로 만들어집니다. @Entity 등의 어노테이션들이 같이 생성됩니다.