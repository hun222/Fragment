package com.hoonyeee.android.fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TwoFragment.backInterface{
    OneFragment one;
    TwoFragment two;
    String data = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //트랜잭션을 이용한 프래그먼트 화면전환
        one = new OneFragment();
        two = new TwoFragment();

        //1.프래그먼트 매니저 가져오기
        FragmentManager manager = getSupportFragmentManager();
        //2.트랜잭션 시작하기
        FragmentTransaction transaction = manager.beginTransaction();
        //3.프래그먼트 삽입처리
        transaction.add(R.id.frameLayout, one);
        //4.트랜잭션 완료처리 -> 프래그먼트가 액티비티 화면에 주입
        transaction.commit();
    }

    // 프래그먼트 two를 화면에 표시하는 함수
    /*
        addToBackStack()은 단순이 layout.xml만 담는게 아니라
        beginTransaction부터 commit까지를 담든다.
        그래서 backstack에서 뒤로가기 하면
        트랜잭션 전체를 rollback하는 형태로 동작한다.
     */
    public void next(){
        //1.프래그먼트 매니저 가져오기
        FragmentManager manager = getSupportFragmentManager();
        //2.트랜잭션 시작하기
        FragmentTransaction transaction = manager.beginTransaction();
        //3.프래그먼트 삽입처리
        transaction.add(R.id.frameLayout, two);
        //4. 프래그먼트를 backstack에 담아서 뒤로가기가 가능하게 만든다
        transaction.addToBackStack(null);

        //5.트랜잭션 완료처리 -> 프래그먼트가 액티비티 화면에 주입
        transaction.commit();
    }

    @Override
    public void back(String data) {
        this.data = data;
        Log.d("dataTag", data);
        super.onBackPressed();
    }
}
