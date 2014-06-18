package me.fuluchii.whatInBag;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author fuluchii.zhao
 */
public class ImageListItemAdapter extends ArrayAdapter<String> {

    private LayoutInflater inflater;

    private String[] mStrings;
    private TypedArray mIcons;

    private int mViewResourceId;

    public ImageListItemAdapter(Context ctx, int viewResourceId,
                                String[] strings, TypedArray icons) {
        super(ctx, viewResourceId, strings);

        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mStrings = strings;
        mIcons = icons;
        mViewResourceId = viewResourceId;
    }

    @Override
    public int getCount() {
        return mStrings.length;
    }


    @Override
    public String getItem(int position) {
        return mStrings[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(mViewResourceId,null);
        ImageView iconView = (ImageView)convertView.findViewById(R.id.category_icon);
        TextView textView = (TextView)convertView.findViewById(R.id.category_name);
        iconView.setImageDrawable(mIcons.getDrawable(position));
        textView.setText(mStrings[position]+" >");
        return convertView;
    }


}
