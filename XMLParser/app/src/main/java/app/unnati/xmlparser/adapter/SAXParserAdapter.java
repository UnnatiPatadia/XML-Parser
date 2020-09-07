package app.unnati.xmlparser.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import app.unnati.xmlparser.R;
import app.unnati.xmlparser.parserModel.SAXModel;

public class SAXParserAdapter extends BaseAdapter {

    //the list values in the List of type SAXModel
    private List<SAXModel> list;
    //activity context
    private Context context;

    public SAXParserAdapter(List<SAXModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(R.layout.list_row, null, false);

        //getting the view elements of the list from the view
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtSalary = view.findViewById(R.id.txtSalary);

        //getting the hero of the specified position
        SAXModel saxModel = list.get(position);

        txtName.setText(list.get(position).getName());
        txtSalary.setText(list.get(position).getSalary());

        return view;
    }
}

