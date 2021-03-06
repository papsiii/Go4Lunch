package com.go4lunch.flooo.go4lunch.Controllers.ApiGooglePlace;

import com.go4lunch.flooo.go4lunch.Models.PlaceDetails;
import com.go4lunch.flooo.go4lunch.Models.PlaceNearBySearch;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GooglePlaceServiceAPI
{

    String KEY_API_MAPS = "AIzaSyDuI5YpDr6avmnSpJSapn4Pxa8lkS5bQk4";
    String type = "restaurant";
    String radius = "1000";
    String maxWidth = "2304";
    String baseUrl = "https://maps.googleapis.com/maps/api/place/";

    // Place NearBySearch
    @GET("nearbysearch/json?key="+KEY_API_MAPS+"&radius="+radius+"&type="+type)
    Observable<PlaceNearBySearch> getPlaceNearBySearch(@Query("location") String location);

    //Place Details
    @GET("details/json?key="+KEY_API_MAPS)
    Observable<PlaceDetails> getPlaceDetails(@Query("placeid") String placeId);

    // Use excludeFieldsWithoutExposeAnnotation() for ignore some fields

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(
                    new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();







}


