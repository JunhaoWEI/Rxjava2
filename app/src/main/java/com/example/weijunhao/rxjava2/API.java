package com.example.weijunhao.rxjava2;



import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by weijunhao on 2017/8/5.
 */

public interface API {

    @GET("weather_mini")
    Observable<ResponseBody> getWeather(@Query("city") String city);
}
