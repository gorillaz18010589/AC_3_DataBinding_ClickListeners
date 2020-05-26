package com.example.ac_3_databinding_clicklisteners;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.ac_3_databinding_clicklisteners.databinding.ActivityMainBinding;
//目的:OnClick事件觸發Toast 用DataBinding方始處理
//好處如果有多個按鈕,又是同個方法,不需要一個一個fivibyid設定OnClick,可用一個自己寫的方法統一處理
//參考影片:https://www.youtube.com/watch?v=g9cUCcGzNlo&list=PLJJzW__bab3Q8jYR7dJnNUeoGpHN2Ei1n&index=4
//1.寫一個ClickHandlers來綁定xml
//2.xml.data綁定這個寫好的類別
/*
<data>
        <variable
            name="clickHandler" //自訂綁定名稱
         type="com.example.ac_3_databinding_clicklisteners.MainActivity.MainActivityClickHandlers" /> 綁定的類別
</data>

//3.DataBindingUtil.setContentView設定為指定的xml
 activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

//4.物件實體化我寫Click類別
 mainActivityClickHandlers = new MainActivityClickHandlers(this);

//5.xml畫面綁定此類別
activityMainBinding.setClickHandler(mainActivityClickHandlers);



6.在xml設定MainActivityClickHandlers裡的onOkButtonClicked(View view)方法
 @{clickHandler::onOkButtonClicked} => @{1.name="clickHandler" //自訂類別名稱 ::(對應) 2.綁定類別裡的onOkButtonClicked}
 <Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:onClick="@{clickHandler::onOkButtonClicked}"
    android:text="ok" />
     -->
* */



public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandlers mainActivityClickHandlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //3.DataBindingUtil.setContentView設定為指定的xml
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        //4.物件實體化我寫Click類別
        mainActivityClickHandlers = new MainActivityClickHandlers(this);

        //5.xml畫面綁定此類別
        activityMainBinding.setClickHandler(mainActivityClickHandlers);

    }

    //1.寫一個ClickHandlers來綁定xml
    public class MainActivityClickHandlers {
        private Context context;//context屬性 讓這個類別都可以玩

        //因為 Toast.makeText需要Context才能玩,所以建構時直接初始化讓他可以玩
        public MainActivityClickHandlers(Context context){
            this.context = context;
        }

        //按下OK按鈕Toast
        public void onOkButtonClicked(View view){
            Toast.makeText(context,"按下OK按鈕",Toast.LENGTH_SHORT).show();
            Log.v("hank","MainActivityClickHandlers.onOkButtonClicked()");
        }

        //按下NO按鈕Toast
        public void onNoButtonClicked(View view){
            Toast.makeText(context,"按下NO按鈕",Toast.LENGTH_SHORT).show();
            Log.v("hank","MainActivityClickHandlers.onNoButtonClicked()");
        }
    }
}
