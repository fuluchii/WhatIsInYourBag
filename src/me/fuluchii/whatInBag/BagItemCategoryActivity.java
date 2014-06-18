package me.fuluchii.whatInBag;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class BagItemCategoryActivity extends ListActivity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category);

        Context context = getApplicationContext();
        Resources resource = context.getResources();

        String[] items = resource.getStringArray(R.array.category_names);
        TypedArray icons = resource.obtainTypedArray(R.array.country_icons);
        setListAdapter(new ImageListItemAdapter(context,R.layout.category_item,items,icons));

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent itemIntent = new Intent(getApplicationContext(),BagItemActivity.class);
                itemIntent.putExtra("categoryId",position);
                startActivity(itemIntent);
            }
        });
    }
}
