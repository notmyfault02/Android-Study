# Koin - DI 라이브러리

## DI(Dependency Injection, 의존성 주입) 이란?

* 현재 객체가 다른 객체와 상호작용(참조)하고 있다면 현재 객체는 다른 객체에 의존성을 가진다.
* 클래스(모듈) 간의 결합도를 낮추기 위해 외부에서 객체 생성을 주입하는 것이다.
* 구성 요소간의 의존 관계가 소스코드 내부가 아닌 외부 설정 파일 등을 통해 정의되게 하는 디자인 패턴

### 장점

* 코드의 재사용성을 높혀준다.
* 테스트 코드 작성에 용이하다.

## 키워드 정리

* module - Koin 모듈을 정의할 때 사용
* factory - inject 하는 시점에 해당 객체를 생성
* single - 싱글톤 패턴으로 객체를 한 번만 생성, 전역적으로 사용 가능함
* bind - 생성할 객체를 다른 타입끼리 바인딩하고 싶을 때 사용
* get - 주입할 각 컴포넌트끼리의 의존성을 해결하기 위해 사용

## 초기 세팅

* build.gradle(module: app)

~~~groovy
dependencies {
  implementation 'org.koin:koin-android:2.0.1'
}
~~~

* AndroidManifest.xml

~~~xml
<application
	android:name=".MyApplication">
</application>
~~~

## Components

~~~kotlin
interface HelloRepository {
  fun giveHello(): String
}

class HelloRepositoryImpl(): HelloRepository {
  override fun giveHello() = "Hello"
}
~~~



~~~kotlin
class HelloPresenter(val repo: HelloRepository) {
  fun sayHello() = "${repo.giveHello()} from $this"
}
~~~

## Koin module 생성

~~~kotlin
val appModule = module {
  single<HelloRepository> { HelloRepositoryImpl() }
  
  factory { MySimplePresenter(get())}
}
~~~

## Koin Start

~~~kotlin
class MyApplication: Application() {
  override fun onCreate() {
    super.onCreate()
    startKoin {
      androidLogger()
      androidContext(this@MyApplication)
      modules(appModule)
    }
  }
}
~~~

## 의존성 주입

~~~kotlin
class MainActivity(): AppCompatActivity() {
  
  val firstPresenter: HelloPresenter by inject()
}
~~~

