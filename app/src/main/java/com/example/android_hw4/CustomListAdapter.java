package com.example.android_hw4;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;

class CustomListAdapter implements ListAdapter {
    ArrayList<Note> arrayList;
    Context context;
    public CustomListAdapter(Context context, ArrayList<Note> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
    @Override
    public boolean isEnabled(int position) {
        return true;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Note subjectData=arrayList.get(position);
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.adapter_view_layout, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            TextView idtext=convertView.findViewById(R.id.textView1);
            TextView tittle=convertView.findViewById(R.id.textView2);
            TextView contenttext=convertView.findViewById(R.id.textView3);
            tittle.setText(subjectData.title);
            idtext.setText(String.valueOf(subjectData.id));
            contenttext.setText(subjectData.getContent());
            Button EditButton =convertView.findViewById(R.id.SmallEditButton);
            EditButton.setOnClickListener(new NewListener(subjectData.id,subjectData.title,subjectData.getContent()));
        }
        return convertView;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }
    @Override
    public boolean isEmpty() {
        return false;
    }

}
class NewListener implements View.OnClickListener
{

    int id;
    String title;
    String content;
    public NewListener(int id,String title,String content) {
        this.id = id;
        this.content=content;
        this.title=title;
    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent(v.getContext(), EditNoteActivity.class);
        intent.putExtra("id",id);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        // intent.setFlags(intent.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY); // Adds the FLAG_ACTIVITY_NO_HISTORY flag
        v.getContext().startActivity(intent);
    }

}