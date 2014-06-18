package me.fuluchii.whatInBag;

import android.content.Context;
import android.content.res.TypedArray;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.zip.Inflater;

/**
 * @author fuluchii.zhao
 */
public class DetailItemListAdapter extends ArrayAdapter<String> {

    private Inflater inflater;

    private TypedArray icons;
    private String[] detailItems;

    public DetailItemListAdapter(Context context, int textViewResourceId, List<String> objects,TypedArray icons) {
        super(context, textViewResourceId, objects);



    }
}
