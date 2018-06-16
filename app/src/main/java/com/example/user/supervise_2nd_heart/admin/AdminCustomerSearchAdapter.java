package com.example.user.supervise_2nd_heart.admin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.user.supervise_2nd_heart.R;
import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.List;

public class AdminCustomerSearchAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    private LayoutInflater inflate;
    private ViewHolder viewHolder;



    public AdminCustomerSearchAdapter(List<String> list, Context context ){
        this.list = list;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = inflate.inflate(R.layout.admin_custmer_row_listview,null);

            viewHolder = new ViewHolder();
            viewHolder.label = (TextView)view.findViewById(R.id.label);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.label.setText(list.get(i));

        return view;
    }

    class ViewHolder{
        public TextView label;
    }
}
