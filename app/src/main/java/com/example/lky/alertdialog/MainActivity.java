package com.example.lky.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private AlertDialog.Builder builder;
    private AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.textView);
        Button bt1 = (Button) findViewById(R.id.button1);
        Button bt2 = (Button) findViewById(R.id.button2);
        Button bt3 = (Button) findViewById(R.id.button3);
        Button bt4 = (Button) findViewById(R.id.button4);
        Button bt5 = (Button) findViewById(R.id.button5);
        Button bt6 = (Button) findViewById(R.id.button6);
        Button bt7 = (Button) findViewById(R.id.button7);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        dialog1();
                        break;
                    case R.id.button2:
                        dialog2();
                        break;
                    case R.id.button3:
                        dialog3();
                        break;
                    case R.id.button4:
                        dialog4();
                        break;
                    case R.id.button5:
                        dialog5();
                        break;
                    case R.id.button6:
                        dialog6();
                        break;
                    case R.id.button7:
                        dialog7();
                        break;
                }
            }

        };
        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
        bt3.setOnClickListener(listener);
        bt4.setOnClickListener(listener);
        bt5.setOnClickListener(listener);
        bt6.setOnClickListener(listener);
        bt7.setOnClickListener(listener);
    }

    private void dialog1() {
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("提示");
        ad.setMessage("确认退出？");
        ad.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==DialogInterface.BUTTON_POSITIVE){
                    dialog.dismiss();
                    MainActivity.this.finish();
                }else if(which==DialogInterface.BUTTON_NEGATIVE){

                }
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"退出",listenter);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter);
        ad.show();
    }
    private void dialog2(){
        ad=new AlertDialog.Builder(this).create();
        ad.setTitle("你忙吗");
        ad.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:str="杜甫很忙";break;
                    case DialogInterface.BUTTON_NEGATIVE:str="杜甫很闲";break;
                    case DialogInterface.BUTTON_NEUTRAL:str="杜甫无所谓";break;
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"很忙",listenter);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"很闲",listenter);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL,"无所谓",listenter);
        ad.show();
    }
    private void dialog3(){
        ad=new AlertDialog.Builder(this).create();
        ad.setTitle("输入的");
        ad.setMessage("输入获奖感言");
        ad.setIcon(android.R.drawable.ic_dialog_dialer);
        final EditText et1=new EditText(this);
        ad.setView(et1);
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你的感言："+et1.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",listenter);
        ad.show();
        }
    private void dialog4(){
        final  String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener listener=new DialogInterface.OnMultiChoiceClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
       builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,bSelect,listener);
        ad=builder.create();
        ad.setTitle("多选框");
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你选了";
                for (int i = 0; i < bSelect.length; i++) {
                    if (bSelect[i]) {
                        str = str + "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",listenter);
        ad.show();
    }
    private void dialog5(){
        final  String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
           for(int i=0;i<bSelect.length;i++){
               if(i!=which){
                   bSelect[i]=false;
               }else{
                   bSelect[i]=true;
               }
           }
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,listener);
        ad=builder.create();
        ad.setTitle("单选");
        DialogInterface.OnClickListener listenter1 = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选了";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str=str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(AlertDialog.BUTTON_POSITIVE,"确定",listenter1);
        ad.show();
    }
    private void dialog6(){
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener listener= new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了"+item[which];
                tv1.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,listener);
        ad=builder.create();
        ad.setTitle("列表");
        DialogInterface.OnClickListener listener1= new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialg, int which) {
                ad.dismiss();
            }
    };
        ad.setButton(AlertDialog.BUTTON_POSITIVE,"确定",listener1);
        ad.show();
}
    private void dialog7(){
        LayoutInflater li=getLayoutInflater();
        View layout=li.inflate(R.layout.mylayout,null);
        final EditText et1= (EditText) layout.findViewById(R.id.editText);
        ad=new AlertDialog.Builder(this).create();
        ad.setTitle("自定义布局");
        ad.setView(layout);
        DialogInterface.OnClickListener listener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是："+et1.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE,"确定",listener);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listener);
        ad.show();
    }
}