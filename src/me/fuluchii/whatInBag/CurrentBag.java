package me.fuluchii.whatInBag;

import android.app.Application;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fuluchii.zhao
 */
public class CurrentBag extends Application {

    public void onCreate(){
        super.onCreate();
    }

    private final Map<String,List<String>> itemMap = new HashMap<String, List<String>>();

    public Map<String, List<String>> getItemMap() {
        return itemMap;
    }


}
