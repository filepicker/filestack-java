package com.filestack.internal;

import com.filestack.AppInfo;
import com.google.gson.JsonObject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CloudService {
  String URL = "https://cloud.filestackapi.com/";

  @POST("prefetch")
  Call<AppInfo> prefetch(@Body JsonObject body);

  @POST("folder/list")
  Call<JsonObject> list(@Body JsonObject body);

  // Cloudrouter requires the trailing slash
  @POST("store/")
  Call<JsonObject> store(@Body JsonObject body);

  @POST("/auth/logout")
  Call<ResponseBody> logout(@Body JsonObject body);
}
