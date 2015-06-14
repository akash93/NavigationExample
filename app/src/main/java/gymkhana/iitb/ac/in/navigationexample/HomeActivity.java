package gymkhana.iitb.ac.in.navigationexample;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        /**
         * Setup the toolbar
         */
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
        /**
         * Setup the navigation view
         */
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_menu);
        if (navigationView!=null){
            setupDrawerContent(navigationView);
        }

        /**
         * Show default fragment
         */
        Fragment fragment = new ListViewFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,fragment).commit();

    }

    /**
     * Need to override this method for menu item call backs
     * @param item the menu item clicked
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }


        return super.onOptionsItemSelected(item);
    }

    /**
     * Setup listeners for @param navigationView
     * to show the appropriate Fragment
     */
    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                Fragment fragment = null;
                switch (menuItem.getItemId()){
                    case R.id.menu_list:
                        fragment=new ListViewFragment();
                        break;
                    case R.id.menu_recycler:
                        fragment= new RecyclerViewFragment();
                        break;
                }
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container,fragment).commit();
                return true;
            }
        });
    }

    /**
     * Helper method to generate dummy data for lists
     * @param context to get string from strings.xml
     * @return {@link List<ListObject>} of items containing
     * relevant list data
     */
    public static List<ListObject> populateListItems(Context context){
        List<ListObject> listObjects = new ArrayList<>();
        String textContent = context.getResources().getString(R.string.random_text);
        for (int i = 0; i <50 ; i++) {
            if (i%2==0){
                listObjects.add(new ListObject(R.drawable.beach,"Beach",textContent));
            }else{
                listObjects.add(new ListObject(R.drawable.safari,"Safari",textContent));
            }
        }
        return listObjects;
    }
}
