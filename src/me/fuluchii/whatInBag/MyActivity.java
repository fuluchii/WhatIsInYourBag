package me.fuluchii.whatInBag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        CurrentBag currentBag = (CurrentBag)getApplicationContext();
        Log.i("test",currentBag.getItemMap().toString());

        View addBtn = findViewById(R.id.imageButton1);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),BagItemCategoryActivity.class);
                startActivity(intent);
            }
        });
    }

}
