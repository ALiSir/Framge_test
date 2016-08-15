package com.alisir.framge_test;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.ContentFrameLayout;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private Button btn1;
    private Button btn2;
    private Button btn3;

    private FristFragment fristFragment;
    private SecondFragment secondFragment;
    private ThridFragment thridFragment;

    //fragment管理器
    private FragmentManager fm;
    //fragment事务管理器
    private FragmentTransaction fmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);

        btn1.setOnClickListener(new onMyClick());
        btn3.setOnClickListener(new onMyClick());
        btn2.setOnClickListener(new onMyClick());

        //fragment页面管理
        initFragment();

    }

    private void initFragment(){

        fristFragment = new FristFragment();
        secondFragment = new SecondFragment();
        thridFragment = new ThridFragment();

        fm = getFragmentManager();
        fmt = fm.beginTransaction();
        fmt.replace(R.id.framelayout,fristFragment);
        fmt.commit();
    }

    class onMyClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.button:
                    fmt = fm.beginTransaction();
                    fmt.replace(R.id.framelayout,fristFragment);
                    fmt.commit();
                    Toast.makeText(MainActivity.this,"第一个页面",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button2:
                    fmt = fm.beginTransaction();
                    fmt.replace(R.id.framelayout,secondFragment);
                    fmt.commit();
                    Toast.makeText(MainActivity.this,"第二个页面",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button3:
                    fmt = fm.beginTransaction();
                    fmt.replace(R.id.framelayout,thridFragment);
                    fmt.commit();
                    Toast.makeText(MainActivity.this,"第三个页面",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}
