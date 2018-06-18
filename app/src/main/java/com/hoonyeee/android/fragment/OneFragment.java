package com.hoonyeee.android.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
    Button btnNext;
    MainActivity activity = null;

    public OneFragment() {
        // Required empty public constructor
        // 여기에 코드입력하면 에러
    }

    // fragment생명주기 중 가장 먼저 호출
    // *interface로 대체해보기
    @Override
    public void onAttach(Context context) { // parameter가 Context지만 실제로는 상위의 Activity 클래스가 넘어온다.
        super.onAttach(context);
        //타입을 체크하는 예약어 사용
        if(context instanceof MainActivity)
            activity = (MainActivity)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //xml을 view로 만들어 넘겨준다.
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        //여기서 findViewById와 같은 화면처리
        btnNext = view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activity!=null)
                    activity.next();
            }
        });

        return view;
    }

}
