package ru.hse.soundmapping.ui.navigationbar.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;
import ru.hse.soundmapping.MainActivity;
import ru.hse.soundmapping.R;
import ru.hse.soundmapping.model.User;

import java.util.Objects;

public class ProfileFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        System.out.println("onCreate ProfileFragment");

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        if (Objects.equals(MainActivity.currentUser, null)) {
            MainActivity.currentUser = new User()
                    .setUserMail(currentUser.getEmail())
                    .setName(currentUser.getDisplayName())
                    .setAvatarUrl(Objects.requireNonNull(currentUser.getPhotoUrl()).toString());
        }
        String personImage = MainActivity.currentUser.getAvatarUrl();
        CircleImageView profileImageView = root.findViewById(R.id.profile_image);
        Glide.with(root.getContext()).load(personImage).into(profileImageView);
        TextView nameTextView = root.findViewById(R.id.name);
        nameTextView.setText(currentUser.getDisplayName());
        TextView emailTextView = root.findViewById(R.id.email);
        emailTextView.setText(currentUser.getEmail());
        return root;
    }
}
