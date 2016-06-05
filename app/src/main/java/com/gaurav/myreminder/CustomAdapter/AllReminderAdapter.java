package com.gaurav.myreminder.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gaurav.myreminder.AllReminderEntry;
import com.gaurav.myreminder.R;

import java.util.ArrayList;

/**
 * Created by Gaurav Mathur on 28-May-16.
 */
public class AllReminderAdapter extends BaseAdapter {

    // View Type for Separators
    private static final int ITEM_VIEW_TYPE_SEPARATOR = 0;
    // View Type for Regular rows
    private static final int ITEM_VIEW_TYPE_REGULAR = 1;
    // Types of Views that need to be handled
    // -- Separators and Regular rows --
    private static final int ITEM_VIEW_TYPE_COUNT = 2;

    private Context mContext;
    private ArrayList<AllReminderEntry> mList;

    public AllReminderAdapter(Context context, ArrayList list) {
        mContext = context;
        mList = list;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return ITEM_VIEW_TYPE_COUNT;
    }
    @Override
    public int getItemViewType(int position) {
        boolean isSection = mList.get(position).mIsSeparator;

        if (isSection) {
            return ITEM_VIEW_TYPE_SEPARATOR;
        }
        else {
            return ITEM_VIEW_TYPE_REGULAR;
        }
    }

    @Override
    public boolean isEnabled(int position) {
        return getItemViewType(position) != ITEM_VIEW_TYPE_SEPARATOR;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        //Contact contact = mList.get(position);
        int itemViewType = getItemViewType(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (itemViewType == ITEM_VIEW_TYPE_SEPARATOR) {
                // If its a section ?
                view = inflater.inflate(R.layout.all_reminder_header_item, null);
            }
            else {
                // Regular row
                view = inflater.inflate(R.layout.all_reminder_line_item, null);
            }
        }
        else {
            view = convertView;
        }


        if (itemViewType == ITEM_VIEW_TYPE_SEPARATOR) {
            // If separator

            TextView separatorView = (TextView) view.findViewById(R.id.separator);
            separatorView.setText(mList.get(position).mName);
        }
        else {
            // If regular

            // Set contact name and number
            TextView contactNameView = (TextView) view.findViewById(R.id.contact_name);

            contactNameView.setText( mList.get(position).mName);
        }

        return view;
    }
}
