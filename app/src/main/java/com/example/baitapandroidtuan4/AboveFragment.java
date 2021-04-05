package com.example.baitapandroidtuan4;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitapandroidtuan4.ui.main.SendingInteface;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AboveFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AboveFragment extends Fragment implements View.OnClickListener, SendingInteface {


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btnRemove, btnAdd;
    private TextView tvVolume, tvGiaTien;

    public AboveFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AboveFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AboveFragment newInstance(String param1, String param2) {
        AboveFragment fragment = new AboveFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_above, container, false);
        btnRemove = view.findViewById(R.id.btnRemove);
        btnAdd = view.findViewById(R.id.btnAdd);
        tvVolume = view.findViewById(R.id.tvVolume);
        tvGiaTien = view.findViewById(R.id.tvGiaTien);


        // Inflate the layout for this fragment
        return view;

    }

    SendingInteface sendingInteface;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        sendingInteface = (SendingInteface) context;

    }

    private void tinhTien() {
        try {
            String txtGiaTien = tvGiaTien.getText().toString();
            txtGiaTien = txtGiaTien.substring(0, txtGiaTien.length()-2);
            int soLuong = Integer.parseInt(tvVolume.getText().toString());
            double giaTien = Double.parseDouble(txtGiaTien);

            Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
            intent.putExtra("giatien", soLuong * giaTien + " đ");
            getActivity().startActivity(intent);
//            sendingInteface.sendData(getText());
        } catch (Exception e) {

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAdd: {
                try {
                    int volume = Integer.parseInt(tvVolume.getText().toString());
                    volume++;
                    tvVolume.setText(volume);
                    tinhTien();
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Số lượng phải là số nguyên", Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case R.id.btnRemove: {
                try {
                    int volume = Integer.parseInt(tvVolume.getText().toString());
                    volume--;
                    if(volume < 0) {
                        Toast.makeText(getActivity(), "Số lượng phải >= 0", Toast.LENGTH_SHORT).show();
                    } else {
                        tvVolume.setText(volume);
                        tinhTien();
                    }

                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Số lượng phải là số nguyên", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

    @Override
    public void sendData(String data) {

    }
}