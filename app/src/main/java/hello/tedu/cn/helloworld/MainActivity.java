package hello.tedu.cn.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 启动界面
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1;
    private Button btn_2;
    private EditText text_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1= findViewById(R.id.btn_1);
        btn_2= findViewById(R.id.btn_2);
        text_1=findViewById(R.id.text_1);
        
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);

    }

    /**
     * 按钮的点击时间的回调
     * @param v 点击的View
     */
    @Override
    public void onClick(View v) {
        if (v==btn_1){
//            Toast.makeText(this,"一般启动",Toast.LENGTH_SHORT).show();
            //获取输入框的内容
            String message = text_1.getText().toString();
            //创建意图，packageContext是启动activity，第二个参数是被启动的意图
            Intent intent=new Intent(this,basicActivity.class);
            //携带额外的数据
            intent.putExtra("message",message);
            startActivity(intent); //启动第二个activity，不带回调的启动
        }else if(v==btn_2){
//            Toast.makeText(this,"带回调的启动",Toast.LENGTH_SHORT).show();
            //获取输入框的内容
            String message = text_1.getText().toString();
            //创建意图，packageContext是启动activity，第二个参数是被启动的意图
            Intent intent=new Intent(this,basicActivity.class);
            //携带额外的数据
            intent.putExtra("message",message);
//            startActivity(intent); //启动第二个activity，不带回调的启动
            int requestCode=2;
            startActivityForResult(intent,requestCode);   //启动第二个activity，带回调的启动
        }
    }

    /**
     * 监听带回调的启动,如果requestCode和resultCode都匹配的话，那么就会需要的数据
     * @param requestCode 请求code
     * @param resultCode  返回的结果code
     * @param data      返回的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==2&&resultCode==-1){  //如果是我们定义的code，那么其中返回的就是我们需要的数据
            String result = data.getStringExtra("result");
            text_1.setText(result);
        }
    }
}
