package com.ssnahhydev.zexpress;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.app.ShareCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.ssnahhydev.zexpress.utils.BottomNavigationViewHelper;
import com.ssnahhydev.zexpress.utils.CustomTypefaceSpan;

/**
 * Created by SSNAHHY on 18/04/2018.
 */

public class WebViewActivity extends AppCompatActivity
        //implements SwipeRefreshLayout.OnRefreshListener
        {

    public static String WEB_URL_INTENT = "url";
    public static String WEB_TITLE_INTENT = "title";

    private WebView wvMainWeb = null;
    private ProgressBar progressBar;
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    //private SwipeRefreshLayout swipeRefreshLayout;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = new WebViewFragment();
            Bundle args = new Bundle();

            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    Intent intent = new Intent(WebViewActivity.this, MainActivity.class);
//                    intent.putExtra("item", "0");
//                    startActivity(intent);
//                    finish();
//                    //switchFragment1();
//                    return true;
//                case R.id.navigation_promotion:
//                    Intent intent2 = new Intent(WebViewActivity.this, MainActivity.class);
//                    intent2.putExtra("item", "1");
//                    startActivity(intent2);
//                    finish();
//                    return true;
//
//                case R.id.navigation_panier:
//                    Intent intent4 = new Intent(WebViewActivity.this, MainActivity.class);
//                    intent4.putExtra("item", "2");
//                    startActivity(intent4);
//                    finish();
//                    return true;
//
//                case R.id.navigation_profile:
//                    Intent intent3 = new Intent(WebViewActivity.this, MainActivity.class);
//                    intent3.putExtra("item", "3");
//                    startActivity(intent3);
//                    finish();
//                    return true;

                case R.id.navigation_home:
                    args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/");
                    fragment.setArguments(args);
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.content_main_constr1, fragment, "fragment");
                    ft.commit();
                    //switchFragment1();
                    return true;
                case R.id.navigation_promotion:
                    args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/promotion/");
                    fragment.setArguments(args);
                    FragmentTransaction ft1 = fragmentManager.beginTransaction();
                    ft1.replace(R.id.content_main_constr1, fragment, "fragment");
                    ft1.commit();
                    return true;

                case R.id.navigation_panier:
                    args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/panier/");
                    fragment.setArguments(args);
                    FragmentTransaction ft2 = fragmentManager.beginTransaction();
                    ft2.replace(R.id.content_main_constr1, fragment, "fragment");
                    ft2.commit();
                    return true;

                case R.id.navigation_profile:
                    args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/mon-compte/");
                    fragment.setArguments(args);
                    FragmentTransaction ft3 = fragmentManager.beginTransaction();
                    ft3.replace(R.id.content_main_constr1, fragment, "fragment");
                    ft3.commit();
                    return true;

            }
            return true;
        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView appName1 = toolbar.findViewById(R.id.tv_app_name1);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/copperplate_regular.ttf");

        //appName1.setTypeface(font);

//        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout_activity_webview);
//        swipeRefreshLayout.setOnRefreshListener(this);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        MainActivity.showExitDialog = 2;

        progressBar = findViewById(R.id.pb_activity);
        bottomNavigationView = findViewById(R.id.navigation1);
        Menu m = bottomNavigationView.getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu != null && subMenu.size() > 0) {
                for (int j = 0; j < subMenu.size(); j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            //applyFontToMenuItem(mi);
        }

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        //Récupération des infos INTENT
        Intent mIntent = getIntent(); // gets the previously created intent
        if (mIntent != null) {
            this.setTitle(mIntent.getStringExtra(WEB_TITLE_INTENT));
        }


        //Init main webview content
        wvMainWeb = findViewById(R.id.main_activity_webview);

        //if (wvMainWeb != null) {

            wvMainWeb.setWebChromeClient(new WebChromeClient());
            WebSettings webSettings = wvMainWeb.getSettings();
            webSettings.setJavaScriptEnabled(true);


            wvMainWeb.setWebViewClient(new WebViewClient() {

                @Override
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    //Log.e("WebViewClient", description);
                    //new AlertDialog.Builder(view.getContext()).setMessage("Error msg").setPositiveButton("ok", null).show();
                    startActivity(new Intent(WebViewActivity.this, MainActivity.class));
                    finish();

                }


                //Little trick to remove nav part
                // http://stackoverflow.com/questions/32828230/how-remove-header-from-webview-on-android
                public void onPageFinished(WebView view, String url) {
                    wvMainWeb.loadUrl("javascript:(function() { " +
                            "var navigation = document.getElementsByTagName('nav')[0];"
                            + "navigation.parentNode.removeChild(navigation);" +
                            "})()");

                    progressBar.setVisibility(View.INVISIBLE);
                    //wvMainWeb.loadUrl(getIntent().getStringExtra(WEB_URL_INTENT));
                }
                /*
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {

                    if(Uri.parse(url).getHost() != null){
                        if (Uri.parse(url).getHost().equals("devt2.esens.fr")) {
                            // This is my web site, so do not override; let my WebView load the page
                            return false;
                        }
                    }

                    // Otherwise, the link is not for a page on my site, so launch another Activity that handles URLs
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;

                }*/
            });


            wvMainWeb.loadUrl(mIntent.getStringExtra(WEB_URL_INTENT));


        //}

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

//        switch (item.getItemId()) {
//            case android.R.id.home:
//                goBack();
//                return true;

            int id = item.getItemId();

            switch (id){
                case R.id.action_share:
                    shareText();
                    break;
                case R.id.action_contact_us:
                    switchFragmentContactUs();
                    break;
                case R.id.action_refresh:
                    wvMainWeb.reload();
                    break;
            }


            /*case R.id.action_refresh:
                reloadWebView();
                return true;*/

        return super.onOptionsItemSelected(item);

    }

    private void switchFragmentContactUs() {
        Fragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/contact/");
        fragment.setArguments(args);

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content_main_constr1, fragment, "fragment");
        ft.addToBackStack("fragment");
        ft.commit();
    }

    private void shareText() {
        String mimeType = "text/plain";
        String title = "Partager ZEDEXPPRESS avec:";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(title)
                .setText("Telecharger ZEDEXPRESS qui est une application qui vous permet de faire livrer vos produits, de vous faire " +
                        "transporter et de suivre en temps réel le cheminement de vos produits: " +
                        "https://cafelabo.tg/zedexpress")
                .startChooser();
    }

    private void switchFragmentPanier() {
        Fragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/panier/");
        fragment.setArguments(args);

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content_main_constr, fragment, "fragment");
        ft.addToBackStack("fragment");
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        //getFragmentManager().popBackStackImmediate();
        //super.onBackPressed();
        goBack();
    }

    /*
        *Gestion du retour arriere avec le navigateur
        */
    private void goBack(){

        fragmentManager.popBackStack();

        if(wvMainWeb!=null && wvMainWeb.canGoBack()){
            wvMainWeb.goBack();
        }else{
            NavUtils.navigateUpFromSameTask(this);
        }

    }

    public void reloadWebView(){

        if(wvMainWeb!=null){
            wvMainWeb.reload();
        }
    }

            private void applyFontToMenuItem(MenuItem mi) {
                Typeface font = Typeface.createFromAsset(getAssets(), "fonts/copperplate_regular.ttf");
                SpannableString mNewTitle = new SpannableString(mi.getTitle());
                mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                mi.setTitle(mNewTitle);
            }




//    @Override
//    public void onRefresh() {
//        new Handler().postDelayed(new Runnable() {
//            @Override public void run() {
//                wvMainWeb.reload();
//                swipeRefreshLayout.setRefreshing(false);
//            }
//        }, 2000);
//    }
}

