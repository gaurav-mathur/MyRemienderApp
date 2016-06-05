package com.gaurav.myreminder.CustomAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gaurav.myreminder.Screens.AddReminder;
import com.gaurav.myreminder.Screens.HomeScreen;
import com.gaurav.myreminder.R;
import com.gaurav.myreminder.RoundImage;

/**
 * Created by Gaurav Mathur on 15-May-16.
 */
public class SideNavAdapter extends BaseAdapter {

    String [] itemList;
    HomeScreen context;
    RoundImage roundedImage;
    int [] itemIcon;
    private static LayoutInflater inflater=null;

    public SideNavAdapter(HomeScreen activity, String[] list, int[] imgList ){
        itemList = list;
        itemIcon = imgList;
        context = activity;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return itemList.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
//        Bitmap bm = BitmapFactory.decodeResource(context.getResources(),itemIcon [position]);
//        roundedImage = new RoundImage(bm);
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.side_nav_list_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView);
        holder.img=(ImageView) rowView.findViewById(R.id.imageView);
        holder.tv.setText(itemList[position]);
        holder.img.setImageResource(itemIcon [position]);
       // holder.img.setImageDrawable(roundedImage);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent addrem = new Intent(context,AddReminder.class);
                context.startActivity(addrem);
                context.getDrawerClosed();
                Toast.makeText(context, "You Clicked "+itemList[position], Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }

}
