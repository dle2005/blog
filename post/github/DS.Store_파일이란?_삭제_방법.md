### .DS_Store 파일이란?
- DS.Store 파일은 Desktop Services Store의 약자로, macOS 운영체제에서 Finder로 폴더를 볼 때마다 자동으로 생성됩니다.
- 숨김 파일로 존재하며, 이 파일은 해당 폴더를 공유하는 모든 곳에서 따라 다닙니다.
- 폴더의 사용자 정의 속성/메터데이터 등의 정보를 저장합니다.
- 이 파일을 통해 보안 침해가 발생할 수 있습니다.

<br>

### .DS_Store 파일 확인하기
확인할 경로에서 터미널에 다음의 명령어를 실행합니다.
~~~
ls -a | grep .DS_Store
~~~
<br>
git의 경우에는 별도의 설정을 하지 않으면 자동으로 .DS_Store 파일이 올라갑니다.  
<br><br>
git에 들어가서 .DS_Store 파일이 있는지 확인해보세요.

<br>

### .DS_Store 파일 제거하기
삭제할 경로에서 터미널의 다음의 명령어를 실행합니다.
~~~
rm .DS_Store
~~~
하지만, 모든 .DS_Store 파일을 위와 같은 방법으로 제거하기는 너무 많은 비용이 발생합니다.
<br>
근본적인 해결방법은 아래에 소개하겠습니다.
<br>
<b>git에서 .DS_Store 파일을 제거</b>하는 방법은 다음과 같습니다.
1. .DS_Store 파일을 제거합니다.
    - 위의 명령어들을 사용합니다.
    - git에 올라가있는 .DS_Store 파일이 없는 경우 1번은 생략하면 됩니다.
2. .gitignore 파일에 .DS_Store를 추가합니다.
     - gitignore 파일이 존재하지 않다면 아래의 명령어를 실행하시면 됩니다. 
        - echo .DS_Store >> .gitignore
    - gitignore 파일의 경로는 repository의 최상위에 위치합니다.
3. git push를 하여 gitignore 파일을 추가해줍니다.

<br>

### .DS_Store 생성하지 않도록 하는 방법
터미널을 열어 아래 명령어를 수행합니다.
~~~
com.apple.desktopservices DSDontWriteNetworkStores true
~~~
<br>
추후에 설정을 바꾸시고 싶다면 마지막 true 값을 false로 변경하시면 됩니다.
