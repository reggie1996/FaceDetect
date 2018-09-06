package com.chaochaowu.facedetect.ui;

import android.graphics.Bitmap;

import com.chaochaowu.facedetect.bean.FaceppBean;

import java.util.List;

/**
 * @author chaochaowu
 */
public interface MainContract {

    interface View{

        void showProgress();
        void hideProgress();
        void displayPhoto(Bitmap photo);
        void displayFaceInfo(List<FaceppBean.FacesBean> faces);

    }

    interface Presenter{
        void getDetectResultFromServer(Bitmap photo);
    }
}
