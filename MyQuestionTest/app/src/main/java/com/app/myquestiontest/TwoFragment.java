package com.app.myquestiontest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


@SuppressLint("ValidFragment")
public class TwoFragment extends Fragment {

    GetValueInterface getValueInterface;
    //TwoFragmentListner twoFragmentListner;

    public TwoFragment() {

        //twoFragmentListner = (TwoFragmentListner)context;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(">>Two>>", "onCreate");

        getValueInterface = (GetValueInterface)getActivity();

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(">>Two>>", "onCreateView");
        return inflater.inflate(R.layout.fragment_two, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d(">>TWO>>", "onAttach");
       // twoFragmentListner = (TwoFragmentListner)context;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d(">>TWO>>", "onViewCreated");

        Button button = (Button)view.findViewById(R.id.btn_two);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValueInterface.getValueFrom("TWO CLick");
                //twoFragmentListner.getResult("FRAGEMRN TWO");


            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(">>TWO>>", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(">>TWO>>", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(">>TWO>>", "onResume");

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(">>TWO>>", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d(">>TWO>>", "onStop");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(">>TWO>>", "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(">>TWO>>", "onDestroyView");
    }


    @Override
    public void onDetach() {
        super.onDetach();

       // twoFragmentListner = null;
        Log.d(">>TWO>>", "DETACH");

    }


    public interface TwoFragmentListner{
        public void getResult(String value);
    }
}
