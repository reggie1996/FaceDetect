package com.chaochaowu.facedetect.retrofit;

import com.chaochaowu.facedetect.bean.FaceppBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * retrofit 面部识别请求的网络服务
 * @author chaochaowu
 */
public interface FaceppService {

    /**
     * @param apikey
     * @param apiSecret
     * @param imageBase64
     * @param returnLandmark
     * @param returnAttributes
     * @return
     */
    @POST("facepp/v3/detect")
    @FormUrlEncoded
    Observable<FaceppBean> getFaceInfo(@Field("api_key") String apikey,
                                       @Field("api_secret") String apiSecret,
                                       @Field("image_base64") String imageBase64,
                                       @Field("return_landmark") int returnLandmark,
                                       @Field("return_attributes") String returnAttributes);

}
