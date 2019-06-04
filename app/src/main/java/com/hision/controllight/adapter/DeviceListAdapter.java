package com.hision.controllight.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


import com.hision.controllight.R;
import com.hision.controllight.bean.LogoInfosBean;
import com.hision.controllight.utils.ToastUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.DeviceViewHolder> {

    Context context;
    public DeviceListAdapter.OnDeviceListSelectListener listener = null;
    private List<LogoInfosBean> data;
    /** 存储选中的图片 */
    private HashMap<Integer, String> chosenDevices = new HashMap();
    /** 存储选中的状态 */
    private HashMap<Integer, Boolean> checkStates  = new HashMap();

    List selectedDevices = new ArrayList<>();

    public DeviceListAdapter(Context context, ArrayList data){
        this.context = context;
        this.data = data;
    }

    public void setLister(DeviceListAdapter.OnDeviceListSelectListener listener){
        this.listener = listener;
    }
    @NonNull
    @Override
    public DeviceListAdapter.DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_device_layout, parent, false);
        return new DeviceListAdapter.DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DeviceListAdapter.DeviceViewHolder holder, final int position) {


        final CheckBox checkBox = holder.itemView.findViewById(R.id.local_device_item);
        final CircleImageView cImg = holder.itemView.findViewById(R.id.device_status);
        final TextView device_address = holder.itemView.findViewById(R.id.device_address);
        final TextView device_sn = holder.itemView.findViewById(R.id.device_sn);
        /** 通过map存储checkbox选中状态,放置rv复用机制导致的状态混乱状态 */

        String name = data.get(position).getName() != null ? data.get(position).getName() : "LOGO";
        device_address.setText(name);

        device_sn.setText("NO.:" + data.get(position).getSn());

        checkBox.setOnCheckedChangeListener(null);
        checkBox.setChecked(checkStates.containsKey(position));
        checkBox.setVisibility(View.INVISIBLE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener){
                    listener.onDeviceListSelect(holder.itemView,position,data.get(position).getSn());
                }
            }
        });


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){

                    checkStates.put(position,true);
                    data.get(position).setSelected(true);
                    chosenDevices.put(position,data.get(position).getSn());
                }else{
                    // 从选中列表中移除
                    checkStates.remove(position);
                    chosenDevices.remove(position);
                }

                if (listener != null){
                    selectedDevices.clear();
                    Iterator it = chosenDevices.entrySet().iterator();
                    while(it.hasNext()){
                        Map.Entry entry = (Map.Entry)it.next();
                        selectedDevices.add(entry.getValue());
                    }

//                    listener.onDeviceListSelect(holder.itemView,position, selectedDevices);
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    class DeviceViewHolder extends RecyclerView.ViewHolder{

        public DeviceViewHolder(View itemView) {
            super(itemView);
        }
    }

    /** 自定义的本地视频选择监听器 */
    public interface OnDeviceListSelectListener{
        void onDeviceListSelect(View view, int position, String device);
    }

}