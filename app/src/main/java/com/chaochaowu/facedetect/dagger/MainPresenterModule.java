package com.chaochaowu.facedetect.dagger;

import com.chaochaowu.facedetect.ui.MainContract;
import com.chaochaowu.facedetect.ui.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * 提供Presenter
 * @author chaochaowu
 */
@Module
public class MainPresenterModule {
    MainContract.View mView;

    public MainPresenterModule(MainContract.View mView) {
        this.mView = mView;
    }

    @Provides
    MainPresenter providesPresenter() {
        return new MainPresenter(mView);
    }
}
