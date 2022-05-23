### @Embeddable & @Embedded
<b>Spring JPA 에서 제공하는 기능</b>으로, 다양한 값 타입(value type)으로 구성된 엔티티(Entity) 클래스를 더 나은 <b>추상화 및 재사용성을 위해 사용</b>됩니다.

##### User
~~~
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;

    private String firstName;
    private String middleName;
    private String LastName;

    private String city;
    private String street;
    private String zipcode;
}
~~~

 테이블의 구조는 괜찮지만  <span style='background-color:#f6f9fa'>Name</span>과  <span style='background-color:#f6f9fa'>Address</span>를 재사용하고 여러 엔티티에 사용하기에는 부적절합니다.  
<br>
Name과 Address 클래스를 만들고 <b>@Embeddable</b>을 사용하여 클래스가 다른 엔티티에 포함되어야 함을 선언합니다.

##### Name
~~~
@Embeddable
public class Name {
    private String firstName;
    private String middleName;
    private String LastName;
}
~~~

##### Address
~~~
@Embeddable
public class Address {
    private String city;
    private String street;
    private String zipcode;
}
~~~

이제 User 모델을 설게할때 Name과 Address 타입을 포함하여 생성합니다.

##### User
~~~
@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    
    @Embedded
    private Name name;
    
    @Embedded
    private Address address;
}
~~~