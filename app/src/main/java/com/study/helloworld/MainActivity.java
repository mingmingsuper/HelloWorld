package com.study.helloworld;

import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.study.helloworld.fragment.EditNameDialogFragment;
import com.study.helloworld.fragment.LoginDialogFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements LoginDialogFragment.LoginInputListener {

    private static String TAG = "MainActivity";

    public final static String EXTRA_MESSAGE = "com.study.helloworld.EXTRA_MSG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");
//        Button button = (Button) findViewById(R.id.button1);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i(TAG,"我点击了一个button");
//            }
//        });

//        Log.e("format date", formatTime(-788947200000l, "yyyy-MM-dd"));
        Log.e("hide phone middle", hiddenMiddle("131615"));
    }

    public static String hiddenMiddle(String phone) {
        if (phone != null && phone.length() > 6) {
//            return phone.replaceAll("(\\w{3})\\w*(\\w{3})", "$1****$2");
            int len = phone.length();
            StringBuilder builder = new StringBuilder();
            String start = phone.substring(0,3);
            builder.append(start);
            String end = phone.substring(len - 3, len);
            for (int i = 0; i < len - 6; i++) {
                builder.append("*");
            }
            builder.append(end);
            return builder.toString();
        }
        return phone;
    }

    private static String formatTime(long time, String formatStr)
    {
//        if (time <=0)
//        {
//            return null;
//        }

        SimpleDateFormat format = new SimpleDateFormat(formatStr);

        return format.format(new Date(time));
    }

    public void clickButton(View view) {
        Log.i(TAG, "我点击了一个button");
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, "你好，刘明明");
        startActivity(intent);
    }

    public void openDialog(View view) {
        EditNameDialogFragment editNameDialog = new EditNameDialogFragment();
        editNameDialog.show(getFragmentManager(), "EditNameDialog");
    }

    public void openLogin(View view) {
//        LoginDialogFragment loginDialog = new LoginDialogFragment();
//        loginDialog.mListener = this;
//        loginDialog.show(getFragmentManager(), "loginDialog");
        openDrawerLayout();
//        openCollapsingToolbarDemo();
    }


    public void setAlarmClick(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "起床")
                .putExtra(AlarmClock.EXTRA_HOUR, 18)
                .putExtra(AlarmClock.EXTRA_MINUTES, 10);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "你点击了Add", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "你点击了Remove", Toast.LENGTH_LONG).show();
                break;
            default:
        }

        return true;
    }

    @Override
    public void onLoginInputComplete(String username, String password) {
        String msg = "您的登录信息是用户名 " + username + "; 密码 " + password;
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }


    private void openDrawerLayout() {
        Intent intent = new Intent(this, DrawerLayoutDemoActivity.class);
        startActivity(intent);
    }

    private void openCollapsingToolbarDemo(){
        Intent intent = new Intent(this, CollapsingToolbarTestActivity.class);
        startActivity(intent);
    }
}
