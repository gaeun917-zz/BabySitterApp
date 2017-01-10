package com.example.gaeunlee.babysitter;

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

import com.example.gaeunlee.babysitter.dto.Children;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;





public class ChildrenListAdapter extends ArrayAdapter<Children> {

    private List<Children> childrens;

    public ChildrenListAdapter(Context context, int resource, List<Children> objects) {
        super(context, resource, objects);
        childrens = objects;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.list_item, parent, false);
        }


// 리스트에서 포지셔닝 구함
        Children children = childrens.get(position);



// 이름이랑 사진만 데이터 받아옴
        TextView nameText = (TextView) convertView.findViewById(R.id.child_name_main);
        nameText.setText(children.getFirst_name());




// 이미지뷰에 비트맵 셋 : 비트맵으로 애셋 폴더에서 엄마 이름 = 이미지 이름 같음
        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView_main );
        Bitmap bitmap = getBitmapFromAsset(children.getGender());
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