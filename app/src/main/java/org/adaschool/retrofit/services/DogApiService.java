package org.adaschool.retrofit.services;

import org.adaschool.retrofit.Dto.BreedsListDto;
import org.adaschool.retrofit.Dto.RandomImageDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DogApiService {
    @GET("api/breeds/list/all")
    Call<BreedsListDto> getAllBreeds();

    @GET("api/breeds/image/random")
    Call<RandomImageDto> getRandomImage();

    @GET("api/breed/{breed}/images")
    Call<BreedsListDto> getRandomImageBreed(@Path("breed") String breed);
}
