package com.example.simpleapp.ui.pichula;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import com.example.simpleapp.R;
import com.example.simpleapp.interfaces.IPaymentMethods;
import com.example.simpleapp.models.PaymentMethods;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PichulaFragment extends Fragment {

    private PichulaViewModel pichulaViewModel;

    //List<PaymentMethods> paymentMethods;
    ArrayList<String> listDatos;
    RecyclerView recycler;

    public static PichulaFragment newInstance() {
        return new PichulaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        pichulaViewModel =
                ViewModelProviders.of(this).get(PichulaViewModel.class);
        View root = inflater.inflate(R.layout.fragment_pichula, container, false);
        final TextView textView = root.findViewById(R.id.text_pichula);
        pichulaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
//        return inflater.inflate(R.layout.pichula_fragment, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this.getContext()));

        listDatos = new ArrayList<String>();

//        for (int i = 0; i <= 50; i++) {
////            listDatos.add("chulapi");
////        }
        this.getPaymentMethods();

        AdapterDatos adapter = new AdapterDatos(listDatos);
        recycler.setAdapter(adapter);
    }

    public void getPaymentMethods() {
        Log.e("CHULAPI", "HOLA MUNDO!!!!!!!!!!!!!!!!!!");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://80002.sos-delivery.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IPaymentMethods paymentMethods = retrofit.create(IPaymentMethods.class);

        Call<List<PaymentMethods>> call = paymentMethods.getPaymentMethods();

        call.enqueue(new Callback<List<PaymentMethods>>() {
            @Override
            public void onResponse(Call<List<PaymentMethods>> call, Response<List<PaymentMethods>> response) {
                if (!response.isSuccessful()) {
                    Log.e("CHULAPI", "ERROR: " + response.code());
                }

                List<PaymentMethods> paymentMethods = response.body();

                Log.e("CHULAPI", "HOLA MUNDO");

                for (PaymentMethods paymentMethod: paymentMethods) {
                    Log.e("CHULAPI", paymentMethod.getCode());
                    listDatos.add(paymentMethod.getCode());
                }
            }

            @Override
            public void onFailure(Call<List<PaymentMethods>> call, Throwable t) {
                Log.e("CHULAPI", "FALLA");
            }
        });
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        mViewModel = ViewModelProviders.of(this).get(PichulaViewModel.class);
//        // TODO: Use the ViewModel
//    }




}