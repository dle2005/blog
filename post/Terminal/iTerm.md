Mac에서 사용하는 터미널을 커스터마이징하여 꾸며보는 방법입니다.  
<br>
터미널을 꾸민다고 기본 앱인 'Terminal'을 커스터마이징 하는 것이 아니라, 터미널을 대체하는 <b>iterm2</b> 제품을 <b>사용</b>하여 커스터마이징 하는 방법입니다.

### 1. iTerm2 설치
iTerm2 공식 사이트에 들어가서 iTerm2를 설치해줍니다.  
https://iterm2.com/ 
<br>
iTerm2는 Mac OS에서 터미널을 대체하여 사용할 수 있는 가상 터미널 어플리케이션입니다. 기본 터미널보다 다양한 기능들을 제공합니다. 화면 분할, 검색 및 하이라이브, 마우스를 사용하지 않고 복사, 붙여넣기 등의 기능들이 있습니다.

### 2. Homebrew 설치
Hombrew 공식 사이트에 들어가서 Hombrew를 설치해줍니다.  
https://brew.sh/index_ko 
<br>
Hombrew는 brew를 사용할 수 있는 어플리케이션입니다. brew는 Mac OS에서 패키지 매니저의 기능을 하며 shell을 통해 프로그램을 다운로드 등 편리한 기능들을 제공합니다.

### 3. zsh & oh-my-zsh 설치
터미널에 아래 명령어들을 입력하여 zsh와 oh-my-zsh를 설치해줍니다.
~~~
// zsh 설치
brew install zsh

// oh-my-zsh 설치
sh -c "$(curl -fsSL https://raw.githubusercontent.com/robbyrussell/oh-my-zsh/master/tools/install.sh)"
~~~
<br>
zsh는 bash에서 개선된 버전으로 여러 추가 기능들을 제공합니다.  

oh-my-zsh는 zsh에서 가장 많이 사용되는 프레임워크로, 내장 플러그인과 테마등을 제공합니다.  

<br>
oh-my-zsh 설치 이후 아래와 같이 brew 명령어를 찾을 수 없다고 하면

~~~
 zsh: command not found: brew
~~~
터미널에 아래 명령어를 입력하여 에디터로 들어갑니다.  
~~~
vi ~/.zshrc // vi 외에 사용하시는 에디터를 사용해도 무방합니다.
~~~
아래 코드를 추가하여 줍니다.  
~~~
export PATH=/opt/bombrew/bin:$PATH
~~~
마지막으로 아래 명령어로 변경 파일을 적용시켜줍니다.  
~~~
source ~/.zshrc
~~~

### 4. Color Theme 적용
아래 사이트에서 원하는 Color Theme을 선택합니다. (Color Theme 이름을 선택하면 링크로 이동합니다.)
https://github.com/mbadolato/iTerm2-Color-Schemes

주소를 복사한 다음 curl을 사용하여 다운로드 해줍니다.  (curl은 github에서 파일 하나만 받을 수 있게 해줍니다.)  
~~~
// curl이 설치되어 있지 않다면 아래 명령어로 설치해줍니다.
brew install curl

// 저는 3024 Day를 설치했습니다.
curl -LO https://github.com/hongzimao/iTerm2-Color-Schemes/blob/master/schemes/3024%20Day.itermcolors
~~~

이제 다음과 같이 Color Theme을 적용시켜 줍니다.  
- Type CMD+i
- Navigate to Colors tab
- Click on Load Presets
- Click on Import
- Select the .itermcolors file(s) of the scheme(s) you'd like to use
- Click on Load Presets and choose a color scheme

### 5. ZSH THEME 변경
터미널에 아래 명령어를 입력하여 에디터로 들어갑니다.  
~~~
vi ~/.zshrc // vi 외에 사용하시는 에디터를 사용해도 무방합니다.
~~~
'ZSH_THEME' 을 찾아 <b>agnoster</b>로 변경해줍니다.  
agnoster는 가장 대중적으로 사용되는 Theme입니다.  
<img>

### 6. Font 변경
5번 까지 하고 나면 Font가 깨지는 현상이 일어날 것입니다.   
호환되는 Font를 다운로드하여 적용해줍니다.  
<br>
여기서는 아래 링크를 통해 D2Coding Font를 설치하겠습니다.  
https://github.com/naver/d2codingfont/releases/tag/VER1.3.2  
다운로드 받은 zip 파일 압축을 풀고 들어가서 D2Coding 파일의 'D2Coding-Ver1.3.2-20180524'을 클릭하여 서체 설치를 눌러줍니다.  
<br>
이제 다음과 같이 Font을 적용시켜 줍니다.  
<img>
