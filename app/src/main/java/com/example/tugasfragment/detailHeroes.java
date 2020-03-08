package com.example.tugasfragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class detailHeroes extends AppCompatActivity {
    ImageView ivDetail;
    TextView tvDetail, tvTitle;

    String title, desc;
    int gthumb;
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//        startActivity(intent);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tv);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivDetail = findViewById(R.id.iv_detail);
        tvDetail = findViewById(R.id.team_description);
        tvTitle = findViewById(R.id.team_title);

        getIncomingIntent();
        setIncomingIntent();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            gthumb = bundle.getInt("img_url",1);
            //Glide.with(getApplicationContext()).load(ivThumb).into(ivDetail);
            desc = bundle.getString("detail");
            title = bundle.getString("title");

//            twvDetail.setText(getDesc);
//            tvTitle.setText(getTitle);

        }


    }

    public void setIncomingIntent(){
        ivDetail.setImageResource(gthumb);
        tvDetail.setText(desc);
        tvTitle.setText(title);
    }
}

