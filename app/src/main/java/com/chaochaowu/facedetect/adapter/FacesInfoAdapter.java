package com.chaochaowu.facedetect.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chaochaowu.facedetect.R;
import com.chaochaowu.facedetect.bean.FaceppBean;

import java.util.List;



/**
 * MainActivity 中 recyclerView 的 Adapter，用于已识别面部信息的展示
 * 并为 item 设置点击事件用于 item 点击后跳转至面部识别详情界面
 * @author chaochaowu
 */
public class FacesInfoAdapter extends RecyclerView.Adapter<FacesInfoAdapter.MyViewHolder> {

    private Context mContext;
    private List<FaceppBean.FacesBean> faces;
    private Bitmap photo;
    private onItemClickListener listener;

    public void setListener(onItemClickListener listener) {
        this.listener = listener;
    }

    public FacesInfoAdapter(Context mContext, List<FaceppBean.FacesBean> faces, Bitmap photo) {
        this.mContext = mContext;
        this.faces = faces;
        this.photo = photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if (photo == null || faces.get(0).getAttributes() == null){
            holder.ivFace.setImageBitmap(null);
            holder.tvSex.setText("");
            holder.tvAge.setText("");
            holder.tvBeauty.setText("");
            holder.tvBeautyTip.setText("");
            return;
        }
        final FaceppBean.FacesBean face = faces.get(position);
        FaceppBean.FacesBean.FaceRectangleBean faceRectangle = face.getFace_rectangle();
        //将人脸从照片中抠出，并加上一定的 padding
        int left = faceRectangle.getLeft();
        int top = faceRectangle.getTop();
        int width = faceRectangle.getWidth();
        final int height = faceRectangle.getHeight();
        int widthPadding = width / 5;
        int heightPadding = height / 5;
        int x = (left - widthPadding) < 0 ? 0 : (left - widthPadding);
        int y = (top - heightPadding) < 0 ? 0 : (top - heightPadding);
        //防止增加 padding 后，抠图范围超过原来的照片
        int _width = ((x + width + widthPadding) > photo.getWidth()) ? photo.getWidth() - x : width + widthPadding;
        int _height = ((y + height + heightPadding) > photo.getHeight()) ? photo.getHeight() - y : height +heightPadding;
        Bitmap bitmap = Bitmap.createBitmap(photo, x, y,_width, _height);
        Glide.with(mContext).load(bitmap).into(holder.ivFace);

        String sex = face.getAttributes().getGender().getValue();
        holder.tvSex.setText(String.format("性别：%s", "Male".equals(sex) ? "男" : "女"));
        holder.tvAge.setText(String.format("年龄：%s", face.getAttributes().getAge().getValue()));
        holder.tvBeautyTip.setText(R.string.beauty);
        double maleScore = face.getAttributes().getBeauty().getMale_score();
        double femaleScore = face.getAttributes().getBeauty().getFemale_score();
        holder.tvBeauty.setText(String.format("%1.2f", "Male".equals(sex) ? maleScore : femaleScore));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(face,holder.tvBeauty);
            }
        });

    }

    @Override
    public int getItemCount() {
        return faces.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView ivFace;
        TextView tvSex;
        TextView tvAge;
        TextView tvBeauty;
        TextView tvBeautyTip;

        public MyViewHolder(View itemView) {
            super(itemView);
            ivFace = itemView.findViewById(R.id.face);
            tvSex = itemView.findViewById(R.id.sex);
            tvAge = itemView.findViewById(R.id.age);
            tvBeauty = itemView.findViewById(R.id.beauty);
            tvBeautyTip = itemView.findViewById(R.id.tv_beauty);
        }
    }

    public interface onItemClickListener{
        void onItemClicked(FaceppBean.FacesBean face, TextView tvBeauty);
    }

}
