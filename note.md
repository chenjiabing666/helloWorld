# 记录

## Activity
- startActivity(Intent intent) ： 启动另外一个activity,
    - intent： 需要启动的意图
- startActivityForResult(intent,requestCode)： 带回调的启动，一旦被调用的页面按了返回按钮将会通过设置的onActivityResult这个方法监听到返回的结果
    - intent： 指定的意图，其中可以设置额外携带的数据
    - requestCode： 请求码，起到一个匹配的作用

- setResult(int resultCode, Intent data)： 设置返回结果，如果启动这个activity的页面设置了回调的话，那么这个返回的结果将会被监听
    - resultCode： 结果码
    - data：返回意图，其中携带了返回给调用方的数据，使用putExxxx方法

- public Intent getIntent()： 得到启动当前activity的意图

- finish(): 结束当前的activity
    - 一般用于返回，返回的按钮监听有两种方式
        - 直接使用setClickListener()
        - 在xml中使用`android:onClick="back1"`这个属性指定方法，这个back1是在activity中定义的方法，格式如下：
        ```java
                /**
                 * 定义back1，用于按钮的监听,需要在<Button />这个标签中添加android:onClick="back1"这个属性
                 * @param v 固定的参数
                 */
                public void back1(View v){
                    finish(); //结束当前的activity
                }
        ```


## Toast
- Toast.makeText(Content content,str,int duration)
    - content ：一般传入的activity
    - str： 显示的内容
    - duration ： 显示的时间间隔，0 或者1 Toast.LENGTH_SHORT



## Intent
- 意图

### 显示调用
- Intent(Context packageContext, Class<?> cls)
    - packageContext：调用的activtiy
    - cls : 被调用的activity


### 携带额外的数据
- 一个界面跳转到另外一个面，在意图中携带额外的数据，在另外一边我们就可以获取额外数据加之使用
- public Intent putExtra(key,value)： 实际上是一个Map
    - key： 指定的key
    - value：指定的值，可以是多种类型




