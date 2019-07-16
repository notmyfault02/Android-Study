# How to Databinding
* __xml에 데이터를 바인딩하여 불필요한 코드를 줄이는 방법__
* 보통 MVVM 패턴에서 사용됨

## 데이터 바인딩 설정
* 모듈 단위 build.gradle 상단에 아래 코드를 넣는다

~~~gradle
apply plugin: "kotlin-kapt"

android {
    ....
    dataBinding {
        enabled = true
    }
}
~~~

## ViewModel 만들기
~~~kotlin
class ViewModel() : ViewModel() {
    val text = ObservableField<String>("")

    fun showText(view: View) {
        Toast.makeText(view.context, "${text.get()}",
        Toast.LENGTH_SHORT).show()
    }
}
~~~

### Observable이 뭘까요?
* 데이터 바인딩에서는 ObservableField 를 포함한 데이터 바인딩 라이브러리에 있는 Observable을 이용해서 UI의 데이터에 접근할 수 있다.
* ObservableField<>, 원시타입은 get()과 set() 메소드를 이용해서 데이터에 접근할 수 있다.
* Observable 혹은 BaseObservable을 상속받는 사용자 지정 클래스 또한 UI의 데이터에 접근할 수 있다.


## 데이터 바인딩 레이아웃 파일
* 데이터 바인딩 레이아웃 파일은 __layout__ 의 루트 태그로 시작하고 그 뒤에 __data__ 요소와 __view__ 루트 요소가 나온다.

~~~xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data>
        <variable name="viewModel" type="com.github.notmyfault02.text.ViewModel"/>
    </data>

    <LinearLayout android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:inputType="text"
                android:text="@={viewModel.text}" />

            <TextView
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="@={viewModel.text}" />

            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:onClick="@{(view) -> viewModel.showText(view)}"
                android:text="Touch!" />
    </LinearLayout>
</layout>
~~~
### `<layout>`
* 데이터바인딩을 위해 루트 태그를 layout으로 바꿔준다.
* layout를 루트 태그로 두고, data 태그 안에 variable 태그를 넣어 이름과 타입을 지정한다.

### variable
* data 태그 안에 variable을 넣어 뷰모델 참고 가능
* name은 변수 이름, type은 변수 타입

### ViewModel 참조
* ViewModel의 데이터에 접근할 때는 ` @{} ` 안에 참조할 데이터를 적는다.

### 2-Way Data Binding
* xml 코드를 보면 EditText의 값이 바뀔 때 TextView의 값도 바뀐다.
* `android:text` 의 값이 `@={viewModel.text}` 이다.

### 리스너 바인딩
* 데이터 바인딩에서는 `android:onClick` 등의 이벤트가 발생했을 때 수행할 동작을 바인딩 할 수 있다.
* 메소드 바인딩 시 람다식을 이용하여 `@{()-> viewModel.doSomeThing()}` 호출한다

## Activity에 ViewModel Binding하기
~~~kotlin
val binding = DataBindingUtil.setContextView<ActivityMainBinding>(this, R.layout.activity_main)
binding.vm = ViewModel()
~~~

* Activity 파일에 이 코드를 작성해준다. setContextView는 지운다.
* 데이터바인딩 클래스는 레이아웃의 이름에서 언더라인을 지워주고 Binding을 붙인다
* `activity_main` -> `ActivityMainBinding`
* `binding.vm = ViewModel()` 로 ViewModel을 바인딩해준다.

## ViewModel은 어떻게 하나요?