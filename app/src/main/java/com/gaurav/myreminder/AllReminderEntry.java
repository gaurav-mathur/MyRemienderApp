package com.gaurav.myreminder;

/**
 * Created by Gaurav Mathur on 29-May-16.
 */
public class AllReminderEntry {

    public String mName;
    public boolean mIsSeparator;

    public AllReminderEntry(String name, boolean isSeparator) {
        mName = name;
        mIsSeparator = isSeparator;
    }
    public void setName(String name) {
        mName = name;
    }
    public void setIsSection(boolean isSection) {
        mIsSeparator = isSection;
    }
}
