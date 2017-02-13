package com.example.techflitter_01.myapplication.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.percentagelib.PatientBean;
import com.example.techflitter_01.myapplication.R;

import java.util.List;


public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.MyViewHolder> {

    private List<PatientBean> vPatientList;
    private Context vContext;
    ItemClickListner mItemClickListnerl;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView vPatientName, vPatientPercentage, vPatientContact;
        LinearLayout row_view;

        public MyViewHolder(View view) {
            super(view);
            vPatientName = (TextView) view.findViewById(R.id.PatientName);
            vPatientPercentage = (TextView) view.findViewById(R.id.PatientPercentage);
            vPatientContact = (TextView) view.findViewById(R.id.PatientContact);
            row_view = (LinearLayout) view.findViewById(R.id.row_view);
        }
    }


    public PatientListAdapter(Context vContext, List<PatientBean> vPatientList, ItemClickListner mItemClickListnerl) {
        this.vContext = vContext;
        this.vPatientList = vPatientList;
        this.mItemClickListnerl = mItemClickListnerl;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_patient_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final PatientBean patientBean = vPatientList.get(position);
        holder.vPatientName.setText(patientBean.getName());
        holder.vPatientPercentage.setText(patientBean.getPercentage() + " %");
        holder.vPatientContact.setText(patientBean.getContact());
        holder.row_view.setTag(position);
        holder.row_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemClickListnerl.onItemClick(Integer.parseInt(view.getTag().toString()), patientBean);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vPatientList != null ? vPatientList.size() : 0;
    }

    public void setvPatientList(List<PatientBean> vPatientList) {
        this.vPatientList = vPatientList;
        notifyDataSetChanged();
    }

    public interface ItemClickListner {
        public void onItemClick(int pos, PatientBean bean);
    }
}
