package com.example.adminjs.myapplication;

import android.app.Dialog;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.adminjs.myapplication.adapter.ColorAdapter;
import com.example.adminjs.myapplication.adapter.ZiTiAdapter;
import com.example.adminjs.myapplication.bean.ColorBean;
import com.example.adminjs.myapplication.bean.ZiTiBean;
import com.example.adminjs.myapplication.util.OnItemClickListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tet;
    private RecyclerView recyclerView;
    private Button add;
    private Button reduce;
    private Button huaxa;
    int size = 15;  //字体大小
    private TextView tv_size;
    Button style1,style2,style3,style4;
    private RecyclerView ziti_recy;
    Typeface tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tet = findViewById(R.id.tet);
        recyclerView = findViewById(R.id.recy);
        add = findViewById(R.id.tv_add);
        reduce = findViewById(R.id.tv_reduce);
        tv_size = findViewById(R.id.tv_size);
        ziti_recy = findViewById(R.id.recycle);
        huaxa = findViewById(R.id.huaxa);
        style1 = (Button) findViewById(R.id.tv_style1);
        style2 = (Button) findViewById(R.id.tv_style2);
        style3 = (Button) findViewById(R.id.tv_style3);
        style4 = (Button)findViewById(R.id.tv_style4);
        tet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initShow();
            }
        });
        initDate();
        initJia();
        initZi();
    }
    private void initZi() {
        //从asset 读取字体
        //得到AssetManager
        AssetManager mgr = getAssets();
        //根据路径得到Typeface
        tf1 = Typeface.createFromAsset(mgr, "fonts/fangsong.TTF");//仿宋
        tf2 = Typeface.createFromAsset(mgr, "fonts/SIMYOU.TTF");//幼圆-常规
        tf3 = Typeface.createFromAsset(mgr, "fonts/STXINGKA.TTF");//华文行楷
        tf4 = Typeface.createFromAsset(mgr, "fonts/BRUSHSCI.TTF");//BRUSHSCI斜体
        tf5 = Typeface.createFromAsset(mgr, "fonts/FZYTK.TTF");//方正姚体
        tf6 = Typeface.createFromAsset(mgr, "fonts/STHUPO.TTF");//华文琥珀
        tf7 = Typeface.createFromAsset(mgr, "fonts/simkai.ttf");//楷体-常规
        tf8 = Typeface.createFromAsset(mgr, "fonts/FZSTK.TTF");//方正舒体
        tf9 = Typeface.createFromAsset(mgr, "fonts/Raleway-Regular.ttf");//Raleway-常规
        tf10 = Typeface.createFromAsset(mgr, "fonts/SIMLI.TTF");//隶书
        final ArrayList<ZiTiBean> list = new ArrayList<>();
        list.add(new ZiTiBean("仿宋"));
        list.add(new ZiTiBean("幼圆-常规"));
        list.add(new ZiTiBean("华文行楷"));
        list.add(new ZiTiBean("BRUSHSCI斜体"));
        list.add(new ZiTiBean("方正姚体"));
        list.add(new ZiTiBean("华文琥珀"));
        list.add(new ZiTiBean("楷体-常规"));
        list.add(new ZiTiBean("方正舒体"));
        list.add(new ZiTiBean("Raleway-常规"));
        list.add(new ZiTiBean("隶书"));
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        ziti_recy.setLayoutManager(manager);
        ZiTiAdapter adapter = new ZiTiAdapter(this, list);
        ziti_recy.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               if (list.get(position).getName().equals("仿宋")){
                   tet.setTypeface(tf1);
               }
                if (list.get(position).getName().equals("幼圆-常规")){
                    tet.setTypeface(tf2);
                }
                if (list.get(position).getName().equals("华文行楷")){
                    tet.setTypeface(tf3);
                }
                if (list.get(position).getName().equals("BRUSHSCI斜体")){
                    tet.setTypeface(tf4);
                }
                if (list.get(position).getName().equals("方正姚体")){
                    tet.setTypeface(tf5);
                }
                if (list.get(position).getName().equals("华文琥珀")){
                    tet.setTypeface(tf6);
                }
                if (list.get(position).getName().equals("楷体-常规")){
                    tet.setTypeface(tf7);
                }
                if (list.get(position).getName().equals("方正舒体")){
                    tet.setTypeface(tf8);
                }
                if (list.get(position).getName().equals("Raleway-常规")){
                    tet.setTypeface(tf9);
                }
                if (list.get(position).getName().equals("隶书")){
                    tet.setTypeface(tf10);
                }
            }
        });
    }

    private void initJia() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size ++;    //字体++++
                tv_size.setText(size+"sp");
                tet.setTextSize(size);
            }
        });

        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size --;    //字体 ----
                tv_size.setText(size+"sp");
                tet.setTextSize(size);
            }
        });
        style1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tet.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));//加粗
            }
        });


        style2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tet.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));//斜体
            }
        });

        style3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tet.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC));//加粗斜体
            }
        });

        style4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tet.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));//正常
                tet.setText(Html.fromHtml(tet.getText().toString()));
            }
        });
        huaxa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //下划线
                tet.setText(Html.fromHtml("<u>"+tet.getText().toString()+"</u>"));
            }
        });
    }

    private void initDate() {
        final ArrayList<ColorBean> list = new ArrayList<>();
        list.add(new ColorBean("#000000"));
        list.add(new ColorBean("#FFFFFF"));
        list.add(new ColorBean("#9F8F9D"));
        list.add(new ColorBean("#9D2D1F"));
        list.add(new ColorBean("#F02F28"));
        list.add(new ColorBean("#FD8B42"));
        list.add(new ColorBean("#F9B73D"));
        list.add(new ColorBean("#3DB959"));
        list.add(new ColorBean("#2EBDB9"));
        list.add(new ColorBean("#1D44EB"));
        list.add(new ColorBean("#D88EAD"));
        list.add(new ColorBean("#EC4AAD"));
        list.add(new ColorBean("#760DCC"));
        LinearLayoutManager manager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(manager);
        ColorAdapter adapter = new ColorAdapter(this, list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                tet.setTextColor(Color.parseColor(list.get(position).getColor()));

            }
        });
    }

    private void initShow() {
        final Dialog dialog = new Dialog(this, R.style.BottomDialog);
        View contentview = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null);
        dialog.setContentView(contentview);
        dialog.setCanceledOnTouchOutside(false);
        final EditText title = contentview.findViewById(R.id.edit);
        TextView quxiao = contentview.findViewById(R.id.backd);
        TextView quer = contentview.findViewById(R.id.qrendh);
        title.setText(tet.getText().toString());
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        quer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tet.setText(title.getText().toString());
                dialog.dismiss();
            }
        });
        ViewGroup.LayoutParams layoutParams = contentview.getLayoutParams();
        layoutParams.width = (int) (this.getResources().getDisplayMetrics().widthPixels / 1.5);
        layoutParams.height = (int) (this.getResources().getDisplayMetrics().heightPixels / 2.5);
        dialog.getWindow().setGravity(Gravity.CENTER);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        CountDownTimer timer = new CountDownTimer(1 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                title.setTextColor(Color.BLUE);
            }

            @Override
            public void onFinish() {
                title.setTextColor(Color.parseColor("#737373"));
            }
        };
        timer.start();
    }
}
