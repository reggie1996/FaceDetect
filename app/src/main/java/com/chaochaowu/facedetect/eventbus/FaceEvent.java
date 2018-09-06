package com.chaochaowu.facedetect.eventbus;

import android.graphics.Bitmap;

import com.chaochaowu.facedetect.bean.FaceppBean;

/**
 * 在 EventBus 中，用于 MainActivity 和 DetailActivity 之间面部识别信息的传递
 * @author chaochaowu
 */
public class FaceEvent {

    private Bitmap bitmap;
    private FaceppBean.FacesBean face;

    public FaceEvent(Bitmap bitmap, FaceppBean.FacesBean face) {
        this.bitmap = bitmap;
        this.face = face;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public FaceppBean.FacesBean getFace() {
        return face;
    }
}
