package com.chaochaowu.facedetect.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaochaowu.facedetect.R;
import com.chaochaowu.facedetect.bean.FaceppBean;
import com.chaochaowu.facedetect.eventbus.FaceEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 用于展示面部识别的详情信息
 * @author chaochaowu
 */
public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.sex)
    TextView tvSex;
    @BindView(R.id.age)
    TextView tvAge;
    @BindView(R.id.tv_beauty)
    TextView tvBeautyTip;
    @BindView(R.id.beauty)
    TextView tvBeauty;
    @BindView(R.id.emotion)
    TextView tvEmotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onMessageEvent(FaceEvent event) {
        FaceppBean.FacesBean face = event.getFace();
        Bitmap photo = event.getBitmap();
        Bitmap faceMarkedPhoto = markFaceInThePhoto(photo, face);
        imageView.setImageBitmap(faceMarkedPhoto);
        displayFaceInfo(face);
    }

    private Bitmap markFaceInThePhoto(Bitmap bitmap, FaceppBean.FacesBean face) {
        Bitmap tempBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(tempBitmap);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        FaceppBean.FacesBean.FaceRectangleBean faceRectangle = face.getFace_rectangle();
        int top = faceRectangle.getTop();
        int left = faceRectangle.getLeft();
        int height = faceRectangle.getHeight();
        int width = faceRectangle.getWidth();
        canvas.drawRect(left, top, left + width, top + height, paint);
        return tempBitmap;
    }

    void displayFaceInfo(FaceppBean.FacesBean face) {

        String s = "";
        FaceppBean.FacesBean.AttributesBean attributes = face.getAttributes();
        FaceppBean.FacesBean.AttributesBean.AgeBean age = attributes.getAge();
        FaceppBean.FacesBean.AttributesBean.GenderBean gender = attributes.getGender();
        FaceppBean.FacesBean.AttributesBean.BeautyBean beauty = attributes.getBeauty();
        tvAge.setText(String.format("年龄：%s", age.getValue()));
        tvSex.setText(String.format("性别：%s", "Male".equals(gender.getValue()) ? "男" : "女"));
        double maleScore = beauty.getMale_score();
        double femaleScore = beauty.getFemale_score();
        tvBeauty.setText(String.format("%1.2f", "Male".equals(gender.getValue()) ? maleScore : femaleScore));
        FaceppBean.FacesBean.AttributesBean.EmotionBean emotion = attributes.getEmotion();
        s = new StringBuilder()
                .append("愤怒 ").append(emotion.getAnger()).append("%")
                .append("\n厌恶 ").append(emotion.getDisgust()).append("%")
                .append("\n恐惧 ").append(emotion.getFear()).append("%")
                .append("\n高兴 ").append(emotion.getHappiness()).append("%")
                .append("\n平静 ").append(emotion.getNeutral()).append("%")
                .append("\n伤心 ").append(emotion.getSadness()).append("%")
                .append("\n惊讶 ").append(emotion.getSurprise()).append("%\n\n")
                .toString();
        tvEmotion.setText(s);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        onBackPressed();
        return true;
    }
}
