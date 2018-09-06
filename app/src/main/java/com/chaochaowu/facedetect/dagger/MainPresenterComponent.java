package com.chaochaowu.facedetect.dagger;

import com.chaochaowu.facedetect.ui.MainPresenter;

import dagger.Component;

/**
 * MainPresenter 的组件
 * @author chaochaowu
 */
@Component(modules = {FaceppServiceModule.class})
public interface MainPresenterComponent {
    void inject(MainPresenter mainPresenter);
}
