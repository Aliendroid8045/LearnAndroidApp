package com.example.koshik.learningandroid;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by koshik on 05-01-2017.
 */

public class CustomAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> expandListTitle;
    private HashMap<String, List<String>> expandableListDetail;

    public CustomAdapter(Context context, List<String> expandListTitle, HashMap<String, List<String>> expandableListDetail) {
        this.context = context;
        this.expandableListDetail = expandableListDetail;
        this.expandListTitle = expandListTitle;
    }


    @Override
    public int getGroupCount() {
        return 0;
    }

    @Override
    public int getChildrenCount(int listPosition) {

        return this.expandableListDetail.get(this.expandListTitle.get(listPosition)).size();
    }

    @Override
    public int getGroupTypeCount() {
        return this.expandListTitle.size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandListTitle.get(listPosition);
    }

    @Override
    public Object getChild(int listPosition, int expandableListPosition) {
        return this.expandableListDetail.get(this.expandListTitle.get(listPosition))
                .get(expandableListPosition);
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public long getChildId(int listPosition, int expandableListPosition) {
        return expandableListPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpandable, View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.group, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.listTitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);

        return convertView;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandableListText = (String) getChild(listPosition, expandedListPosition);

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.listitem, null);
        }
        TextView expandableTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        expandableTextView.setText(expandableListText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandableListPosition) {
        return true;
    }
}
