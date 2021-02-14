package com.kosmo.veve.F5_MyPage_Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kosmo.veve.R;
import com.kosmo.veve.http.UrlCollection;

public class F5_MyPage_Nutrient extends Fragment {

    private WebView webView;
    private WebSettings mWebSettings;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i("com.kosmo.kosmoapp","onCreateView:4");

        //프래그먼트 레이아웃 전개
        View view=inflater.inflate(R.layout.fragment_f5__my_page__nutrient,null,false);
        webView = view.findViewById(R.id.webview_nutrient);

        webView.setWebViewClient(new WebViewClient()); // 클릭시 새창 안뜨게
        mWebSettings = webView.getSettings(); //세부 세팅 등록
        mWebSettings.setJavaScriptEnabled(true); // 웹페이지 자바스클비트 허용 여부
        mWebSettings.setSupportMultipleWindows(false); // 새창 띄우기 허용 여부
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(false); // 자바스크립트 새창 띄우기(멀티뷰) 허용 여부
        mWebSettings.setLoadWithOverviewMode(true); // 메타태그 허용 여부
        mWebSettings.setUseWideViewPort(true); // 화면 사이즈 맞추기 허용 여부
        mWebSettings.setSupportZoom(false); // 화면 줌 허용 여부
        mWebSettings.setBuiltInZoomControls(false); // 화면 확대 축소 허용 여부
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); // 컨텐츠 사이즈 맞추기
        mWebSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 브라우저 캐시 허용 여부
        mWebSettings.setDomStorageEnabled(true); // 로컬저장소 허용 여부
        mWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);
        mWebSettings.setUseWideViewPort(true); // wide viewport를 유연하게 설정하고
        mWebSettings.setLoadWithOverviewMode(true); // 컨텐츠가 웹뷰 범위에 벗어날 경우  크기에 맞게 조절
        mWebSettings.setDefaultFontSize(40);
        mWebSettings.setDefaultZoom(WebSettings.ZoomDensity.FAR); // 화면을 유지
        webView.setInitialScale(35);



        webView.loadUrl(UrlCollection.MYPAGENUTRIENT); // 웹뷰에 표시할 웹사이트 주소, 웹뷰 시작

        return view;
    }

}