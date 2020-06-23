package com.example.simpleapp.interfaces;

import com.example.simpleapp.models.PaymentMethods;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IPaymentMethods {
    @POST("web_service/api/v1/get_metodos_payment?token=app963&id_business=987")
    Call<List<PaymentMethods>> getPaymentMethods();
}
