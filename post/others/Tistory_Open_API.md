티스토리의 Open API를 사용하여 블로그 글을 작성하는 방법 1탄입니다.  
여기서는 자바 언어를 사용하여 구현합니다.  
<br>
Open API를 사용하기에 앞서 몇가지 준비사항이 필요합니다.  
1. Open API 앱 등록 
2. 권한 허가하기
3. Access Token 획득하기
4. Category ID 카테고리 아이디

### Open API 앱 등록
아래 링크로 접속하여 앱 등록을 진행해야 합니다.  
https://www.tistory.com/guide/api/manage/register  
앱 등록 화면에서 아래 항목들을 설정하고 등록해주시면 됩니다.  
서비스 명: 블로그 이름  
서비스 URL: 블로그 주소  
서비스 형태: 웹서비스  
서비스 권한: 읽기, 쓰기  
CallBack: 블로그 주소 (서비스 URL과 동일)  
<br>
<b>앱 등록을 완료하면 App ID와 Secret Key를 보여줍니다.  
이 App ID와 Secret Key를 잘 저장해두셔야 합니다.</b>

### 권한 허가하기
인터넷 주소창에 아래 URL을 입력하여 들어가서 하가를 해주어야 합니다.  
https://www.tistory.com/oauth/authorize?client_id={AppID)&redirect_uri={서비스 URL}&response_type=code  
여기에서 사용되는 AppID는 앱 등록시 획득한 App ID이며 서비스 URL은 블로그 주소입니다.  
<br>
직접 입력하는게 어렵거나 귀찮으시면 아래 함수를 사용하여 URL을 구하면 됩니다.
~~~
    public static String getAuthenticationUrl(String clientId, String redirectUri) {
        return "https://www.tistory.com/oauth/authorize?client_id="
                + clientId
                + "&redirect_uri="
                + redirectUri
                + "&response_type=code";
    }
~~~

<b>허가하기 이후 이동한 화면의 주소에서 code={code}&state=spomeValue의 code 값을 저장해두어야 합니다.</b>

### Access Token 획득하기
다음으로 Open API에서 사용할 Access Token을 획득해야 합니다.  
<br>
아래 함수를 사용해서 tistory에 요청하여 access token을 획득합니다.  
<b>함수를 호출한 뒤 리턴 값의 access token을 저장해둡니다.</b>  
<br>
clientId: App ID  
clientSecret: Secret Key  
redirectUri: 블로그 주소  
~~~
    public static String getAccessToken(String clientId, String clientSecret, String redirectUri, String code) {
        try {
            String url = "https://www.tistory.com/oauth/access_token?"
                    + "client_id=" + clientId + "&"
                    + "client_secret=" + clientSecret + "&"
                    + "redirect_uri=" + redirectUri + "&"
                    + "code=" + code + "&"
                    + "grant_type=authorization_code";

            URL obj = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();

            return "Error";
        }
    }
~~~