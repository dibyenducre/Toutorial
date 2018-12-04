package com.app.myquestiontest;

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


public class OneFragment extends Fragment implements TwoFragment.TwoFragmentListner {
    // TODO: Rename parameter arguments, choose names that match

    GetValueInterface getValueInterface;


    public OneFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(">>ONE>>", "onCreate");
        getValueInterface = (GetValueInterface)getActivity();

        Bundle b = getArguments();
        String s = (String) b.get("iData");
        Log.d(">>ONE--GET>>", s);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //View view = inflater.inflate(R.layout.fragment_one, container, false);
        Log.d(">>ONE>>", "onCreateView");


        return inflater.inflate(R.layout.fragment_one, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d(">>ONE>>", "onAttach");

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d(">>ONE>>", "onViewCreated");

        Button button = (Button)view.findViewById(R.id.btn_one);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getValueInterface.getValueFrom("one CLick");

              /*  TwoFragment twoFragment = new TwoFragment(OneFragment.this);
                FragmentTransaction ft = getChildFragmentManager().beginTransaction();
                // ft.addToBackStack("TWO");
                ft.add(R.id.container, twoFragment);
                ft.commit();*/

            }
        });


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(">>ONE>>", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(">>ONE>>", "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(">>ONE>>", "onResume");

    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(">>ONE>>", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.d(">>ONE>>", "onStop");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(">>ONE>>", "onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(">>ONE>>", "onDestroyView");
    }


    @Override
    public void onDetach() {
        super.onDetach();

        Log.d(">>ONE>>", "DETACH");

    }

    @Override
    public void getResult(String value) {
        Log.d("FRAG >>>GET Va------ ",value);
    }
}
