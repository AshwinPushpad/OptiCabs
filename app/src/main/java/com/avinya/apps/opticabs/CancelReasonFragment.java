package com.avinya.apps.opticabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.util.Log;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.avinya.apps.opticabs.databinding.FragmentCancelReasonBinding;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link BlankFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class CancelReasonFragment extends Fragment {

    //Using Data Binding and onCreateView() & onViewCreated()
//    private FragmentCancelReasonBinding binding;
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        // Initialize View Binding for the fragment
//        binding = FragmentCancelReasonBinding.inflate(inflater, container, false);
//
//        // Return the root view (the fragment's layout)
//        return binding.getRoot();
//    }
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        // Set an OnClickListener on the Submit button
//        binding.btnSubmit.setOnClickListener(v -> {
//            // Get the selected RadioButton's ID from the RadioGroup
//            int selectedId = binding.radioGroup.getCheckedRadioButtonId();
//
//            // If a RadioButton is selected
//            if (selectedId != -1) {
//                // Find the selected RadioButton
//                RadioButton selectedRadioButton = view.findViewById(selectedId);
//
//                // Get the text of the selected RadioButton
//                String selectedText = selectedRadioButton.getText().toString();
//
//                // Show the selected option (e.g., in a Toast message)
//                Toast.makeText(getActivity(), "Selected: " + selectedText, Toast.LENGTH_SHORT).show();
//            } else {
//                // No RadioButton is selected
//                Toast.makeText(getActivity(), "Please select an option", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        // Clear the binding object when the view is destroyed
//        binding = null;
//    }

    //Traditional Approach

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cancel_reason, container, false);

        RadioGroup radioGroup = view.findViewById(R.id.radio_group);
        Button submitButton = view.findViewById(R.id.btn_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get selected radio button ID
                int selectedId = radioGroup.getCheckedRadioButtonId();

                // If a reason is selected, handle it, otherwise show a toast
                if (selectedId != -1) {

                    RadioButton selectedReason = view.findViewById(selectedId);
                    String reason = selectedReason.getText().toString();

                    // Handle the cancellation reason (e.g., submit it to your backend)
                    Toast.makeText(getActivity(), "Cancelled for: " + reason, Toast.LENGTH_SHORT).show();
                    Log.d("TAG", "onClick: "+reason);
                } else {
                    Toast.makeText(getActivity(), "Please select a reason", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    // End of The mainClass Block
}