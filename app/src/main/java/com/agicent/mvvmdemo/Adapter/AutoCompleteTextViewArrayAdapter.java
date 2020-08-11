package com.agicent.mvvmdemo.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.agicent.mvvmdemo.R;
import com.agicent.mvvmdemo.utils.AndroidUtils;


import java.util.ArrayList;
import java.util.List;

//import com.hummingbird.android.R;
//import com.hummingbird.android.utils.AndroidUtils;

public class AutoCompleteTextViewArrayAdapter extends ArrayAdapter<String> {

    private final Context mContext;
    private final List<String> tagsAll;
    private final List<String> suggestions;
    private final int mLayoutResourceId;

    public AutoCompleteTextViewArrayAdapter(Context context, int resource, List<String> tags) {
        super(context, resource, tags);
        this.mContext = context;
        this.tagsAll = (ArrayList<String>)tags;
        this.suggestions = new ArrayList<String>(tagsAll);
        this.mLayoutResourceId = resource;
    }

    public int getCount() {
        return suggestions.size();
    }

    public String getItem(int position) {
        return suggestions.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            if (convertView == null) {
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                convertView = inflater.inflate(mLayoutResourceId, parent, false);
            }
            //Department department = getItem(position);
            TextView name = (TextView) convertView.findViewById(R.id.autoText);
            name.setText(getItem(position));
        } catch (Exception e) {
            e.printStackTrace();
        }

        convertView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    AndroidUtils.hideKeyBoard(mContext);
                }
                return false;
            }
        });

        convertView.setScrollBarSize(10);
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {

            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                List<String> suggestedTags = new ArrayList<>();
                if (charSequence != null) {
                    for (String tag : tagsAll) {
                        if (tag.toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                            suggestedTags.add(tag);
                        }
                    }
                    filterResults.values = suggestedTags;
                    filterResults.count = suggestedTags.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults filterResults) {
                suggestions.clear();
                if (filterResults != null && filterResults.count > 0) {
                    // avoids unchecked cast warning when using mDepartments.addAll((ArrayList<Department>) results.values);
                    for (Object object : (List<?>) filterResults.values) {
                        if (object instanceof String) {
                            suggestions.add((String) object);
                        }
                    }
                    notifyDataSetChanged();
                } else if (constraint == null) {
                    // no filter, add entire original list back in
                    suggestions.addAll(tagsAll);
                    notifyDataSetInvalidated();
                }
            }
        };
    }
}
