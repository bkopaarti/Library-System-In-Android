package com.ritstudent.librarysystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.ritstudent.librarysystem.fragments.BorrowBooksFragment;
import com.ritstudent.librarysystem.fragments.ProfileFragment;

public class StudenntDashboardActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    CoordinatorLayout coordinatorLayout;
    Toolbar toolbar;
    FrameLayout frameLayout;
    NavigationView navigationView;
    MenuItem previousMenuItem = null;
    ActionBar ab;
    ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studennt_dashboard);
        drawerLayout = findViewById(R.id.drawerLayout);
        coordinatorLayout = findViewById(R.id.coordinatorlayout);
        toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frame);
        navigationView = findViewById(R.id.NavigationView);
        setSupportActionBar(toolbar);
        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Dashboard");
        //openDashboard();

       actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (previousMenuItem != null) {
                    previousMenuItem.setChecked(false);
                }
                menuItem.setCheckable(true);
                previousMenuItem = menuItem;

                switch (menuItem.getItemId()) {
                    case R.id.profileMenu: {

                        //Fragment profile=new ProfileFragment();
//                Bundle bundle =new Bundle();
//                bundle.putString("name", username);
//                bundle.putString("email", email);
//                bundle.putString("mobile_number", phno);
//                bundle.putString("address", address);
//                profile.arguments = bundle;
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.frame, ProfileFragment.class, null)
                                .setReorderingAllowed(true)
                                .addToBackStack("name") // name can be null
                                .commit();
                        ab.setTitle("My Profile");
                        drawerLayout.closeDrawers();
                        Toast.makeText(StudenntDashboardActivity.this, "Profile Fragment", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.borrowMenu: {
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.frame, BorrowBooksFragment.class, null)
                                .setReorderingAllowed(true)
                                .addToBackStack("name") // name can be null
                                .commit();
                        drawerLayout.closeDrawers();

                        Toast.makeText(StudenntDashboardActivity.this, "Borrower Fragment", Toast.LENGTH_SHORT).show();
                    }
                    case R.id.logoutMenu: {
//                supportFragmentManager.beginTransaction()
//                AlertDialog dialog =new AlertDialog.Builder(this);
//                dialog.setTitle("Confirmation")
//                dialog.setMessage("Are ou sure ou want to log out?")
//                dialog.setPositiveButton("Yes") { text, listener ->
//                        logsharedPreferences.edit().clear().apply()
//                    val logintent = Intent(this, LoginActivity::class.java)
//                    startActivity(logintent)
//                    finish()
//                }
//                dialog.setNegativeButton("No") { text, listener ->
//
//                }
//                dialog.create()
//                dialog.show()
//                drawerLayout.closeDrawers()
                    }
                }
                return false;
            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }    }

//    fun openDashboard() {
//        val fragment = HomeFragment()
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.frame, fragment)
//        transaction.commit()
//        supportActionBar?.title = "All Restaurants"
//        navigationView.setCheckedItem(R.id.homeMenu)
//    }
//
//    override fun onBackPressed() {
//        val frag = supportFragmentManager.findFragmentById(R.id.frame)
//
//        when (frag) {
//            !is HomeFragment -> openDashboard()
//            else -> super.onBackPressed()
//        }
