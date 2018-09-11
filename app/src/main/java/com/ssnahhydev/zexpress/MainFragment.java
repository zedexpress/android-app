package com.ssnahhydev.zexpress;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by SSNAHHY on 17/05/2018.
 */

public class MainFragment extends Fragment {

//    ImageView first;
//    ImageView sec;
//    ImageView third;
//    ImageView fourth;
    FragmentManager myFragmentManager;
    Fragment fragment = new WebViewFragment();
    Bundle args = new Bundle();
    FragmentTransaction transaction;

    RelativeLayout bouffe;
    RelativeLayout electronique;
    RelativeLayout fleurs;
    RelativeLayout gift;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
//        bouffe = view.findViewById(R.id.rly_bouffe);
//        bouffe.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myFragmentManager = getActivity().getSupportFragmentManager();
//                args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/store-listing/");
//                fragment.setArguments(args);
//                transaction = myFragmentManager.beginTransaction();
//                transaction.replace(R.id.content_main_constr, fragment, "fragment");
//                transaction.addToBackStack("fragment");
//                transaction.commit();
//            }
//        });
//
//        electronique = view.findViewById(R.id.rly_electronique);
//        electronique.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myFragmentManager = getActivity().getSupportFragmentManager();
//                args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/?id=sidebar_product_filter&wpf=1&wpf_category=electronique");
//                fragment.setArguments(args);
//                transaction = myFragmentManager.beginTransaction();
//                transaction.replace(R.id.content_main_constr, fragment, "fragment");
//                transaction.addToBackStack("fragment");
//                transaction.commit();
//            }
//        });
//
//        fleurs = view.findViewById(R.id.rly_coin_fleur);
//        fleurs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myFragmentManager = getActivity().getSupportFragmentManager();
//                args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/store-listing/");
//                fragment.setArguments(args);
//                transaction = myFragmentManager.beginTransaction();
//                transaction.replace(R.id.content_main_constr, fragment, "fragment");
//                transaction.addToBackStack("fragment");
//                transaction.commit();
//            }
//        });
//
//        gift = view.findViewById(R.id.rly_cadeau);
//        gift.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myFragmentManager = getActivity().getSupportFragmentManager();
//                args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/store-listing/");
//                fragment.setArguments(args);
//                transaction = myFragmentManager.beginTransaction();
//                transaction.replace(R.id.content_main_constr, fragment, "fragment");
//                transaction.addToBackStack("fragment");
//                transaction.commit();
//            }
//        });
//        first = view.findViewById(R.id.first_item);
//        first.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Fragment f = new WebViewFragment();
//                Bundle args = new Bundle();
//
//                args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/?id=sidebar_product_filter&wpf=1&wpf_category=jai-faim");
//                f.setArguments(args);
//
//                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//                fragmentTransaction.replace(R.id.content_main_constr, f, "fragment");
//                fragmentTransaction.commit();
//            }
//        });
        return view;
    }

}
