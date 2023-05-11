package org.adaschool.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.bumptech.glide.Glide;

import org.adaschool.retrofit.Dto.BreedsListDto;
import org.adaschool.retrofit.Dto.RandomImageDto;
import org.adaschool.retrofit.databinding.ActivityMainBinding;
import org.adaschool.retrofit.services.DogApiService;

import java.util.Map;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DogApiService dogApiService = RetrofitInstance.getRetrofitInstance().create(DogApiService.class);

        Call<RandomImageDto> call = dogApiService.getRandomImage();
        call.enqueue(new Callback<RandomImageDto>() {
            @Override
            public void onResponse(Call<RandomImageDto> call, Response<RandomImageDto> response) {
                if (response.isSuccessful()) {
                    String dog = response.body().getMessage();
                    loadDogInfo(dog);
//                    Map<String, String[]> breeds = response.body().getMessage();
//                    for (Map.Entry<String, String[]> entry : breeds.entrySet()) {
//                        Log.d(TAG, "Raza: " + entry.getKey());
//                        for (String subRaza : entry.getValue()) {
//                            Log.d(TAG, "Subraza: " + subRaza);
//                        }
//                    }
                } else {
                    Log.e(TAG, "Error en la respuesta de la API");
                }
            }

            @Override
            public void onFailure(Call<RandomImageDto> call, Throwable t) {
                Log.e(TAG, "Error al llamar a la API", t);
            }

        });

    }

    private void loadDogInfo(String dog) {
        String dogImageUrl = dog;
        String[] listDog = dog.split("/");
        String dogName = listDog[listDog.length - 2];
        binding.textView.setText(dogName);
        Glide.with(this)
                .load(dogImageUrl)
                .into(binding.imageView);
    }


}