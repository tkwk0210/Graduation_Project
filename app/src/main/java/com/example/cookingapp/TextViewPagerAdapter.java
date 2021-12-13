package com.example.cookingapp;

import static com.example.cookingapp.R.drawable.*;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class TextViewPagerAdapter extends PagerAdapter {
    String URL[] = { "http://15.164.123.111/dashboard/",
            "http://15.164.123.111/dashboard/bbs/board.php?bo_table=free",
            "http://15.164.123.111/dashboard/bbs/board.php?bo_table=best",
            "http://15.164.123.111/dashboard/bbs/board.php?bo_table=qa",
            "http://15.164.123.111/dashboard/bbs/board.php?bo_table=notice"};
    int res[] = { main_first, main_second, main_third, main_fourth, main_first };

    // LayoutInflater 서비스 사용을 위한 Context 참조 저장.
    private Context mContext = null ;

    public TextViewPagerAdapter(ArrayList arrayList) {

    }

    // Context를 전달받아 mContext에 저장하는 생성자 추가.
    public TextViewPagerAdapter(Context context) {
        mContext = context ;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = null ;
        int index;
        Intent Pager_intent = new Intent(mContext, MainActivity.class);

        if (mContext != null) {
            //LayoutInflater를 통해 "/res/layout/page.xml"을 뷰로 생성.
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.page, container, false);

            TextView textView = view.findViewById(R.id.text_pager) ;
            textView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.bg_custom_textview));

            textView.setText((++position) + "/5");
            index = position;
            Pager_intent.putExtra("pos", index);
            textView.setBackgroundResource(res[index-1]);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(container.getContext(), index + " 네~", Toast.LENGTH_SHORT).show();
                    // 게시판으로 이동
                    textView.setBackgroundResource(res[index]);
                    Intent intent = new Intent(mContext, recipeActivity.class);
                    intent.putExtra("load_URL", URL[(index-1)]);
                    mContext.startActivity(intent);
                }
            });
        }

        // 뷰페이저에 추가.
        container.addView(view) ;

        return view ;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // 뷰페이저에서 삭제.
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        // 전체 페이지 수는 10개로 고정.
        return 5;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == (View)object);
    }
}
