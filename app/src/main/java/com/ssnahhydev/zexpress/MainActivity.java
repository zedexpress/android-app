package com.ssnahhydev.zexpress;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ShareCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TypefaceSpan;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.ssnahhydev.zexpress.utils.BottomNavigationViewHelper;
import com.ssnahhydev.zexpress.utils.CustomTypefaceSpan;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity
        //implements
        //NavigationView.OnNavigationItemSelectedListener,
        //SwipeRefreshLayout.OnRefreshListener
        {

//    private DrawerLayout mDrawerLayout = null;
//    private ActionBarDrawerToggle mDrawerToggle = null;
    private ProgressBar mainPb;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private BottomNavigationView bottomNavigationView;

    public static int showExitDialog = 1;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            int id = item.getItemId();

            Fragment fragment = new WebViewFragment();
            Bundle args = new Bundle();

//            if(id == R.id.nav_home){
//                args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/");
//                return true;
//            }else if( id == R.id.nav_promotion){
//                args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/boutique/");
//                return true;
//            }else if(id == R.id.nav_account){
//                args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/mon-compte/");
//                return true;
//            }

            switch (item.getItemId()){
                case R.id.navigation_home:

//                    Fragment fragment1 = new MainFragment();
//
//                          FragmentTransaction transaction = fragmentManager.beginTransaction();
//                          transaction.replace(R.id.content_main_constr, fragment1, "fragment");
//                          transaction.commit();
                        args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/");
                        fragment.setArguments(args);
                        FragmentTransaction ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.content_main_constr, fragment, "fragment");
                        ft.commit();

//                    Fragment frag = new MainFragment();
//                    FragmentTransaction transaction = fragmentManager.beginTransaction();
//                    transaction.replace(R.id.content_main_constr, frag, "fragment");
//                    transaction.addToBackStack("fragment");
//                    transaction.commit();


                    return true;
                case R.id.navigation_promotion:
                    args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/promotion/");
                        fragment.setArguments(args);
                        FragmentTransaction ft1 = fragmentManager.beginTransaction();
                        ft1.replace(R.id.content_main_constr, fragment, "fragment");
                        //ft1.addToBackStack("fragment");
                        ft1.commit();
                    return true;

                case R.id.navigation_panier:
                    args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/panier/");
                    fragment.setArguments(args);
                    FragmentTransaction ft2 = fragmentManager.beginTransaction();
                    ft2.replace(R.id.content_main_constr, fragment, "fragment");
                    //ft2.addToBackStack("fragment");
                    ft2.commit();
                    return true;

                case R.id.navigation_profile:
                    args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/mon-compte/");
                    fragment.setArguments(args);
                    FragmentTransaction ft3 = fragmentManager.beginTransaction();
                    ft3.replace(R.id.content_main_constr, fragment, "fragment");
                    //ft3.addToBackStack("fragment");
                    ft3.commit();
                    return true;
            }

            //replacing the fragment
//            if (fragment != null) {
//                fragment.setArguments(args);
//                FragmentTransaction ft = fragmentManager.beginTransaction();
//                ft.replace(R.id.content_main_constr, fragment, "fragment");
//                ft.addToBackStack("fragment");
//                ft.commit();
//
//            }
            return true;
        }
    };

    public void switchFragmentPanier(){
        Fragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/panier/");
        fragment.setArguments(args);

        FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.content_main_constr, fragment, "fragment");
                ft.addToBackStack("fragment");
                ft.commit();
    }

    public void switchFragmentContactUs(){
        Fragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/contact/");
        fragment.setArguments(args);

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.content_main_constr, fragment, "fragment");
        ft.addToBackStack("fragment");
        ft.commit();
    }

    public void switchFragmentShare(){
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView appName = toolbar.findViewById(R.id.tv_app_name);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/copperplate_regular.ttf");

        //appName.setTypeface(font);
        toolbar.setTitle(" ");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //mainPb = findViewById(R.id.pb_main);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        bottomNavigationView = findViewById(R.id.navigation);
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
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //mSwipeRefreshLayout = findViewById(R.id.swiperefresh_activity_main);
        //mSwipeRefreshLayout.setOnRefreshListener(this);

//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerToggle  = new ActionBarDrawerToggle(
//                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        mDrawerLayout.addDrawerListener(mDrawerToggle);
//        mDrawerToggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.setNavigationItemSelectedListener(this);
        //navigationView.setCheckedItem(R.id.nav_account);

        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        Intent i = getIntent();
        String ret = i.getStringExtra("item");

        if(ret != null){
            switch (ret){
                case "0":
                    //this.onNavigationItemSelected(navigationView.getMenu().getItem(0));
                    bottomNavigationView.setSelectedItemId(R.id.navigation_home);
                    break;
                case "1":
                    bottomNavigationView.setSelectedItemId(R.id.navigation_promotion);
                    break;

//                case "2":
//                    bottomNavigationView.setSelectedItemId(R.id.navigation_panier);
//                    break;

                case "3":
                    bottomNavigationView.setSelectedItemId(R.id.navigation_profile);
                    break;
                default:
                    bottomNavigationView.setSelectedItemId(R.id.navigation_home);

            }
        }else {
            //this.onNavigationItemSelected(navigationView.getMenu().getItem(0));
        }
    }

    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //getSupportFragmentManager().popBackStackImmediate();

        //if(MainActivity.showExitDialog == 1){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

            builder.setMessage("Voulez-vous vraiment quitter?")
                    .setNegativeButton("ANNULER", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    System.exit(0);
                }
            });

            builder.show();



//        if(fragmentManager.getBackStackEntryAt(1) == 1){
//
//        }

//        if(fragmentManager.)
//
//        if(fragmentManager.getBackStackEntryCount() == 1){
//            new AlertDialog.Builder(MainActivity.this).setMessage("Voulez-vous vraiment quitter?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    finish();
//                    System.exit(0);
//                }
//            }).show();
//        }else {
//            fragmentManager.popBackStackImmediate();
//        }

        //}else {
          //  finish();
        //}


//        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
//            mDrawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

//        Typeface face = Typeface.createFromAsset(this.getAssets(),"font/copperplate_regular.ttf");    //  THIS
//        TypefaceSpan faceSpan = new TypefaceSpan("copperplate"); // OR  THIS
//        SpannableStringBuilder title = new SpannableStringBuilder("font_text");
//        title.setSpan(face, 0, title.length(), 0);
//        menu.add(Menu.NONE, R.id.navigation_home, 0, title); // THIS
//        MenuItem menuItem = menu.findItem(R.id.navigation_home); // OR THIS
//        menuItem.setTitle(title);
//        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_share:
                shareText();
                break;
            case R.id.action_contact_us:
                switchFragmentContactUs();
                break;
            case R.id.action_refresh:
                bottomNavigationView.setSelectedItemId(R.id.navigation_home);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
////         Handle navigation view item clicks here.
//        int id = item.getItemId();
//        Fragment fragment = new WebViewFragment();
//        Bundle args = new Bundle();
//
//        if(id == R.id.nav_home){
//            args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/");
//        }
////        else if (id == R.id.nav_do_order) {
////            args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/commande/");
////        }
//
//        else if (id == R.id.nav_account) {
//            args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/mon-compte/");
//        }
//
////        else if (id == R.id.nav_our_products) {
////            args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/boutique/");
////        }
//
//        else if (id == R.id.nav_share) {
//            shareText();
//
//        }
////        else if (id == R.id.nav_help) {
////            args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/#faq");
////
////        }
//
//        else if (id == R.id.nav_contact_us) {
//            args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/contact/");
//
//        } else if (id == R.id.nav_cart) {
//            args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/panier/");
//        }
//
//        else if (id == R.id.nav_promotion) {
//            args.putString(WebViewFragment.ARG_URL, "https://cafelabo.tg/zedexpress/promotion/");
//        }
//
//        //replacing the fragment
//        if (fragment != null) {
//            fragment.setArguments(args);
//            FragmentTransaction ft = fragmentManager.beginTransaction();
//            ft.replace(R.id.content_main_constr, fragment, "fragment");
//            //ft.addToBackStack("fragment");
//            ft.commit();
//        }
//        // Highlight the selected item has been done by NavigationView
//        //item.setChecked(true);
//
//        //mDrawerLayout.closeDrawers();
//        return true;
//    }

    private void shareText(){
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
//                bottomNavigationView.setSelectedItemId(R.id.navigation_home);
//                mSwipeRefreshLayout.setRefreshing(false);
//            }
//        }, 2000);
//    }

    public boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
