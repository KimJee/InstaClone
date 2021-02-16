# Learning About Fragments

* How do we present data to users via the bottom navigation library?
  * Utilize a design support library [bottom-nav-bar](https://guides.codepath.org/android/Bottom-Navigation-Views)
  * Add regular dependencies [setup](https://guides.codepath.org/android/Design-Support-Library#setup)
  * Add new layout to our MainActivity.xml file (at the bottom)
 
 `    <com.google.android.material.bottomnavigation.BottomNavigationView
             android:id="@+id/bottom_navigation"
             android:layout_width="match_parent"
             android:layout_height="wrap_content"
             android:layout_alignParentBottom="true"
             app:menu="@menu/menu_bottom_navigation" /> `

* Click on the red lightbulb to define our bottom nav bar.
* Go to the 'design' tab and drag and drop items for each of the buckets at the bottom.
* Go to the attributes and under showAsAction to view. Set it to 'always'.
* Add an 'image' through the image attribute

* (1) Add it to out mainActivity
* (2) Link the attribute with 'findViewByID' in the constructor
* (3) Create a listener with the .setOnClickListener
* (4) Within that function, create a 'onNavigationItemSelected' listener

`        
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 return false;
             }
         });
`

* (5) Then within there, allow for each 'bucket' to navigate to the correct 'fragment'.
`                
                 Fragment fragment;
                 switch (item.getItemId()) {
                     case R.id.action_favorites:
                         fragment = fragment1;
                         break;
                     case R.id.action_schedules:
                         fragment = fragment2;
                         break;
                     case R.id.action_music:
                     default:
                         fragment = fragment3;
                         break;
                 }
                 fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                 return true;
`

* With Fragments, activities only pass data, and nothing should be within main activity

* Go to directory, and create a 'fragment' package
* Create a fragment template 
* Move over 'relevant UI elements to fragment'

* A fragment doesn't have the same lifecycle of an 'activity'
* Thus to create a constructor or the 'beginning' of the fragment,
    * Ctrl + o --> onViewCreated() 
* Move over 'logic' class elements into the fragment

* WARNING: findViewByID doesn't work because we're in the wrong context. 
-> view.findViewByID should work instead.

MainActivity.this -> getContext()

* After moving all the logic into the fragment file, in the 'main-activity', create a
* Fragment manager (as a class variable to main-activity)
* Also, within your activity_main, create a 'framelayout' in the xml

`
        <FrameLayout
            android:id="@+id/flContainer"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_above="@+id/bottomNavigation"
        />
`

This will hold a frame which your fragments will fill in for the app

`final FragmentManager fragmentManager = getSupportFragmentManager();`
Then add 
`fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();`
To the onNavigationSelected to commit the changes of the frame 

### Create a recycler view for the posts

* 0. Create layout for one row in the list
* 1. create the adapter
* 2. create the data source
* 3. set the adapter on the recycler view
* 4. set the layout manager on the recycler view


