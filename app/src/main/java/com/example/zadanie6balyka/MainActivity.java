package com.example.zadanie6balyka;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Date;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new TaskFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

        setContentView(R.layout.activity_main);
    }

    public static class Task {
        private UUID id;
        private String name;
        private Date date;
        private Boolean done;

        public Task() {
            id = UUID.randomUUID();
            date = new Date();
        }

        public void setName(String newName) {
            name = newName;
        }

        public void setDone(boolean b) {
            done = b;
        }
    }

    public class TaskFragment extends Fragment {
        Task task;

        public class onCreate {
            Task task = new Task();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_task, container, false);
            TextView nameField = view.findViewById(R.id.task_name);
            nameField.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    task.setName(savedInstanceState.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            return view;
        }
    }
}