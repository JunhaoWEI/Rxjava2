package com.example.weijunhao.rxjava2;

import android.content.Context;

import java.net.SocketException;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created by weijunhao on 2017/8/5.
 */

public abstract class BaseObserver<T> implements Observer<BaseBean<T>> {

    private static final int RESPONSE_CODE_OK = 200;

    private Context mContext;
    private int errorCode;
    private String errorMsg = "未知的错误！";

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull BaseBean<T> tBaseBean) {
        // TODO: 2017/8/5  取消loading dialog

        if (tBaseBean.getSratus() == RESPONSE_CODE_OK) {
            onSuccess(tBaseBean.getT());
        } else {
            onFail(tBaseBean.getMessage());
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        // TODO: 2017/8/5 取消loading dialog

        if (e instanceof HttpException) {
            errorMsg = ((HttpException) e).getMessage();
        } else if (e instanceof SocketException) {
            errorMsg = "服务器相应超时";
        }

        // TODO: 2017/8/5  其他的异常处理
        onFail(errorMsg);

    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(T t);

    protected abstract void onFail(String message);

    public BaseObserver(Context context, boolean showProgress) {
        mContext = context;
        if (showProgress) {
            // TODO: 2017/8/5 显示loading dialog
        }
    }
}
