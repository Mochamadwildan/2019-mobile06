package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BMI;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BMIFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BMIFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BMIFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate thbe layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bmi, container, false);
        final EditText tinggiBadan = view.findViewById(R.id.tinggi);
        final EditText beratBadan = view.findViewById(R.id.berat);

        Button calculate = view.findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick (View view) {
                if (mListener != null) {
                    String heightString = tinggiBadan.getText().toString();
                    String beratString = beratBadan.getText().toString();

                    if (!TextUtils.isEmpty(heightString) && !TextUtils.isEmpty(beratString)) {
                        float tinggi = Float.parseFloat(heightString);
                        float berat = Float.parseFloat(beratString);
                        BMI bmi = new BMI (berat, tinggi);
                        mListener.onCalculateBMIClicked(bmi.BMIRange());
                    } else {
                        Toast.makeText(getActivity(),"Pilih berat dan tinggi mu", Toast.LENGTH_SHORT).show();
                    }
                }

            }

        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);

        void onCalculateBMIClicked(String bmiRange);
    }
}
