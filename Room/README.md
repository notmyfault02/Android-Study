# Room

* Room은 Database Object를 매핑하는 라이브러리로서, Android Application에서  **데이터베이스에 쉽게 접근할 수 있도록**  합니다.
* SQLite의 추상 레이어를 제공하여 SQLite의 기능을 모두 사용할 수 있습니다
* Room을 사용하면 컴파일 시간을 체크할 수 있으면 상용구 코드의 반복을 줄일 수 있습니다

## Room의 구성 요소

1. Entity
   * Database 안에 있는 테이블을 Java나 Kotlin 클래스로 나타낸 것입니다.
   * 데이터 모델 클래스라고 볼 수 있습니다 
2. DAO
   * Database Access Object (데이터베이스 접근 Object)
   * 데이터베이스에 접근하여 insert, delete 등을 수행하는 메소드를 포함합니다
3. Database
   * 데이터베이스 홀더를 포함합니다
   * 앱에 영구 저장되는 데이터에 접근하기 위한 액세스 지점입니다.



![room_architecture](https://developer.android.com/images/training/data-storage/room_architecture.png)