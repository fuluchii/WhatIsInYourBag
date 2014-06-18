package me.fuluchii.whatInBag;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

import java.util.ArrayList;

public class BagItemActivity extends ListActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemlist);
        final Context context = getApplicationContext();
        final Resources resources = context.getResources();

        //get category
        int position =(Integer)(getIntent().getExtras().get("categoryId"));
        String categoryName = resources.getStringArray(R.array.category_names)[position];
        String iconResourceId = categoryName+"Icons";
        final String[] itemNames = resources.getStringArray(resources.getIdentifier(categoryName,"array",this.getPackageName()));
        TypedArray icons = resources.obtainTypedArray(resources.getIdentifier(iconResourceId,"array",this.getPackageName()));

        ListAdapter adapter = new ImageListItemAdapter(context,R.layout.category_item,itemNames,icons);
        setListAdapter(adapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position =(Integer)(getIntent().getExtras().get("categoryId"));
                String categoryName = resources.getStringArray(R.array.category_names)[position];
                CurrentBag currentBag = (CurrentBag) getApplicationContext();

                if(!currentBag.getItemMap().containsKey(categoryName)){
                    currentBag.getItemMap().put(categoryName,new ArrayList<String>());
                }
                currentBag.getItemMap().get(categoryName).add(itemNames[i]);
                Intent intent = new Intent(context,MyActivity.class);
                startActivity(intent);
            }
        });


    }
}
