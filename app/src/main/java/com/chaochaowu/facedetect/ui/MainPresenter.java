package com.chaochaowu.facedetect.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.widget.Toast;

import com.chaochaowu.facedetect.BuildConfig;
import com.chaochaowu.facedetect.Utils;
import com.chaochaowu.facedetect.bean.FaceppBean;
import com.chaochaowu.facedetect.dagger.DaggerMainPresenterComponent;
import com.chaochaowu.facedetect.dagger.FaceppServiceModule;
import com.chaochaowu.facedetect.retrofit.FaceppService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author chaochaowu
 */
public class MainPresenter implements MainContract.Presenter{

    private static final String TAG = "MainPresenter";

    @Inject
    FaceppService faceppService;

    private MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        DaggerMainPresenterComponent.builder()
                .faceppServiceModule(new FaceppServiceModule())
                .build()
                .inject(this);
    }

    @Override
    public void getDetectResultFromServer(final Bitmap photo) {
        String s = Utils.base64(photo);
        faceppService.getFaceInfo(BuildConfig.API_KEY, BuildConfig.API_SECRET, s, 1, "gender,age,smiling,emotion,beauty")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FaceppBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mView.showProgress();
                    }

                    @Override
                    public void onNext(FaceppBean faceppBean) {
                        handleDetectResult(photo,faceppBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.hideProgress();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideProgress();
                    }
                });
    }

    private void handleDetectResult(Bitmap photo,FaceppBean faceppBean) {
        List<FaceppBean.FacesBean> faces = faceppBean.getFaces();
        if (faces == null || faces.size() == 0) {
            mView.displayFaceInfo(null);
        } else {
            Bitmap photoMarkedFaces = markFacesInThePhoto(photo, faces);
            mView.displayPhoto(photoMarkedFaces);
            mView.displayFaceInfo(faces);
        }
    }

    private Bitmap markFacesInThePhoto(Bitmap bitmap, List<FaceppBean.FacesBean> faces) {
        Bitmap tempBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Canvas canvas = new Canvas(tempBitmap);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);

        for (FaceppBean.FacesBean face : faces) {
            FaceppBean.FacesBean.FaceRectangleBean faceRectangle = face.getFace_rectangle();
            int top = faceRectangle.getTop();
            int left = faceRectangle.getLeft();
            int height = faceRectangle.getHeight();
            int width = faceRectangle.getWidth();
            canvas.drawRect(left, top, left + width, top + height, paint);
        }
        return tempBitmap;
    }

}
