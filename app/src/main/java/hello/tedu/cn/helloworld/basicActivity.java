package hello.tedu.cn.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class basicActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_3;
    private Button btn_4;
    private EditText text_2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        //获取View
        btn_3=findViewById(R.id.btn_3);
        btn_4=findViewById(R.id.btn_4);
        text_2=findViewById(R.id.text_2);

        Intent intent = getIntent();  //获取意图
        String msg = intent.getStringExtra("message");//获取指定key的数据
        text_2.setText(msg);//设置文本输入的携带过来的数据

//        btn_3.setOnClickListener(this);  //设置监听
    }

    @Override
    public void onClick(View v) {
        if (v==btn_3){
            finish();
        }else if(v==btn_4){
            Toast.makeText(this,"带回调的启动",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 定义back1，用于按钮的监听,需要在<Button />这个标签中添加android:onClick="back1"这个属性
     * @param v 固定的参数
     */
    public void back1(View v){
        finish(); //结束当前的activity
    }


    /**
     * 定义back2，用于按钮的监听,需要在<Button />这个标签中添加android:onClick="back1"这个属性
     * @param v 固定的参数
     */
    public void back2(View v){
        int responseCode=-1;
        Intent data=new Intent();  //新建一个意图
        data.putExtra("result",text_2.getText().toString());  //存放一个额外的数据
        setResult(responseCode,data);   //设置返回结果
        finish();  //关闭当前页面，即是返回上一层的页面
    }

}
