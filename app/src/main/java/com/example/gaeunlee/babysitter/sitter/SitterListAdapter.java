package com.example.gaeunlee.babysitter.sitter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaeunlee.babysitter.R;
import com.example.gaeunlee.babysitter.dto.Sitter;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class SitterListAdapter extends ArrayAdapter<Sitter> {

    private List<Sitter> sitters;

    public SitterListAdapter(Context context, int resource, List<Sitter> objects) {
        super(context, resource, objects);
        sitters = objects;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item_sitter, parent, false);
        }


// 리스트에서 포지셔닝 구함
         Sitter sitter = sitters.get(position);



// 이름이랑 나이 스킬  만 데이터 받아옴
        TextView sitterName = (TextView) convertView.findViewById(R.id.sitter_name_list);
        sitterName.setText(sitter.getName());

        TextView sitterSkill = (TextView) convertView.findViewById(R.id.sitter_skills_list);
        sitterSkill.setText(sitter.getSkills());

        TextView sitterAge = (TextView) convertView.findViewById(R.id.sitter_age_list);
        sitterAge.setText(sitter.getSitter_age() + "");




// 이미지뷰에 비트맵 셋 : 비트맵으로 애셋 폴더에서 엄마 이름 = 이미지 이름 같음
        ImageView iv = (ImageView) convertView.findViewById(R.id.sitter_imageView );
        Bitmap bitmap = getBitmapFromAsset(sitter.getGender());
        iv.setImageBitmap(bitmap);


        return convertView;
    }







    private Bitmap getBitmapFromAsset(String gender) {

        AssetManager assetManager = getContext().getAssets();
        InputStream stream = null;

        try {
            stream = assetManager.open(gender + ".png");
            return BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}