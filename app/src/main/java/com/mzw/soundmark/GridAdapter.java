package com.mzw.soundmark;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by think on 2018/9/11.
 */

public class GridAdapter extends BaseAdapter{
    private List<Bean> list;
    private LayoutInflater layoutInflater;

    public GridAdapter(List<Bean> list, LayoutInflater layoutInflater) {
        this.list = list;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Bean getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Bean bean = list.get(position);

        final ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_item_layout, parent, false);
            holder = new ViewHolder();
            assert convertView != null;
            holder.textview = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textview.setText(bean.name);

        return convertView;
    }

    class ViewHolder{
        TextView textview;
    }
}
