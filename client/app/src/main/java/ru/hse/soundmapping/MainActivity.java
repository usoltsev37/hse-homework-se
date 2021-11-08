package ru.hse.soundmapping;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import ru.hse.soundmapping.model.Tour;
import ru.hse.soundmapping.model.User;

public class MainActivity extends AppCompatActivity {
    public static NavController navController;
    public static User currentUser = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        BottomNavigationView navView = findViewById(R.id.nav_view);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupWithNavController(navView, navController);

        if (Objects.equals(FirebaseAuth.getInstance().getCurrentUser(), null)) {
            navController.navigate(R.id.signInFragment);
        } else {
            navController.navigate(R.id.navigation_profile);
        }

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



}
