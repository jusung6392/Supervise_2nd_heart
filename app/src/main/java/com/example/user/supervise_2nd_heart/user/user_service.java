package com.example.user.supervise_2nd_heart.user;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.user.supervise_2nd_heart.R;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;

public class user_service extends Fragment {

    Context ct;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.user_service,container,false);
        final TextView tv = (TextView)v. findViewById(R.id.textView4); // 결과창
        ct = container.getContext();

        Button b1 = (Button)v.findViewById(R.id.button1);
        Button b2 = (Button)v.findViewById(R.id.button2);
        Button b3 = (Button)v.findViewById(R.id.button3);
        Button b4 = (Button)v.findViewById(R.id.button4);

        final EditText et1 = (EditText)v.findViewById(R.id.editText1);
        final EditText et2 = (EditText)v.findViewById(R.id.editText2);
        final EditText et3 = (EditText)v.findViewById(R.id.editText3);

        final Geocoder geocoder = new Geocoder(ct);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Address> list = null;

                try{
                    double d1 = Double.parseDouble(et1.getText().toString());
                    double d2 = Double.parseDouble(et2.getText().toString());

                    list = geocoder.getFromLocation(
                            d1,
                            d2,
                            10);

                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("test", "입출력 오류 - 서버에서 주소변환시 에러발생");
                }
                if (list != null) {
                    if (list.size()==0) {
                        tv.setText("해당되는 주소 정보는 없습니다");
                    } else {
                        tv.setText(list.get(0).toString());
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Address> list = null;

                String str = et3.getText().toString();
                try {
                    list = geocoder.getFromLocationName(
                            str, // 지역 이름
                            10); // 읽을 개수
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("test","입출력 오류 - 서버에서 주소변환시 에러발생");
                }

                if (list != null) {
                    if (list.size() == 0) {
                        tv.setText("해당되는 주소 정보는 없습니다");
                    } else {
                        tv.setText(list.get(0).toString());
                        //          list.get(0).getCountryName();  // 국가명
                        //          list.get(0).getLatitude();        // 위도
                        //          list.get(0).getLongitude();    // 경도
                    }
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 위도,경도 입력 후 지도 버튼 클릭 => 지도화면으로 인텐트 날리기
                double d1 = Double.parseDouble(et1.getText().toString());
                double d2 = Double.parseDouble(et2.getText().toString());

                Intent intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("geo:" + d1 + "," + d2));
                startActivity(intent);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 주소입력후 지도2버튼 클릭시 해당 위도경도값의 지도화면으로 이동
                List<Address> list = null;

                String str = et3.getText().toString();
                try {
                    list = geocoder.getFromLocationName
                            (str, // 지역 이름
                                    10); // 읽을 개수
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.e("test","입출력 오류 - 서버에서 주소변환시 에러발생");
                }

                if (list != null) {
                    if (list.size() == 0) {
                        tv.setText("해당되는 주소 정보는 없습니다");
                    } else {
                        // 해당되는 주소로 인텐트 날리기
                        Address addr = list.get(0);
                        double lat = addr.getLatitude();
                        double lon = addr.getLongitude();

                        String sss = String.format("geo:%f,%f", lat, lon);

                        Intent intent = new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(sss));
                        startActivity(intent);
                    }
                }
            }
        });

        return v;
    }
}
