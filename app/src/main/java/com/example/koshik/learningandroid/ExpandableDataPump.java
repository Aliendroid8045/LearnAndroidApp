package com.example.koshik.learningandroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by koshik on 05-01-2017.
 */

public class ExpandableDataPump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> myExpandableList = new HashMap<String, List<String>>();

        List<String> introAndroid = new ArrayList<String>();
        introAndroid.add("What is Android?");
        introAndroid.add("Android Architecture");
        introAndroid.add("How Android System work?");
        introAndroid.add("Basic Building Component of Android.");

        List<String> coreComponent = new ArrayList<String>();
        coreComponent.add("Activity");
        coreComponent.add("Broadcast Receiver");
        coreComponent.add("Content Provider");
        coreComponent.add("Services");

        List<String> basicAndroid = new ArrayList<String>();
        basicAndroid.add("Intent");
        basicAndroid.add("Permission");
        basicAndroid.add("Fragment");
        basicAndroid.add("Fragment Communication");

        myExpandableList.put("Android Introduction ", introAndroid);
        myExpandableList.put("Android Component", coreComponent);
        myExpandableList.put("Intent and Fragment", basicAndroid);
        return myExpandableList;


    }
}
