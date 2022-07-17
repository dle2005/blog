
### 들어가기 전에
<b>Spring boot 프로젝트</b>를 생성하면 <b>build.gradle</b> 파일에 다음의 코드들이 추가되어있는것을 볼 수 있습니다.
~~~
group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'
~~~
위의 코드 중 <b>'sourceCompatibility'</b>는 무엇인지에 대한 글입니다.

### sourceCompatibility란?
sourceCompatibility란 Java 버전과 일치하는 값으로 <b>컴파일에서 사용하는 JDK 버전</b>입니다.  
<b>소스 코드에서 사용할 수 있는 Java 버전을 해당 버전 값으로 제한</b> 합니다.  
컴파일 단계에서 에러를 감지하여, 실수로 더 높은 버전의 Java 기능을 사용하는 것을 방지합니다.

### targetCompatibility
sourceCompatibility와 유사한 targetCompatibility 기능이 있습니다.  
<br>
targetCompatibility는 <b>생성된 클래스 파일의 버전을 제어</b>합니다.  
<b>프로그램에서 실행할 수 있는 가장 낮은 Java 버전</b>을 의미합니다.
여기에서 정한 버전 이상의 Java 버전을 사용해야 하며, 마찬가지로 컴파일 단계에서 에러를 감지합니다.  
<br>
Spring boot 프로젝트 생성 시에 sourceCompatibility는 자동으로 추가가 되지만, targetCompatibility는 추가가 되지 않습니다. 필요한 경우 직접 추가하여 사용하시면 됩니다.
~~~
group = 'com.example'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'
targetCompatibility = '11'
~~~