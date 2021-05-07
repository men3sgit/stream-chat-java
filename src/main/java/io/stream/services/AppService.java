package io.stream.services;

import io.stream.models.App;
import io.stream.models.App.AppCheckSqsRequestData;
import io.stream.models.App.AppCheckSqsResponse;
import io.stream.models.App.AppGetRateLimitsResponse;
import io.stream.models.App.AppUpdateRequestData;
import io.stream.models.framework.StreamResponseObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AppService {
  @GET("app")
  @NotNull
  Call<App> get();

  @PATCH("app")
  @NotNull
  Call<StreamResponseObject> update(@NotNull @Body AppUpdateRequestData appSettings);

  @GET("rate_limits")
  Call<AppGetRateLimitsResponse> getRateLimits(
      @Nullable @Query("serverSide") Boolean serverSide,
      @Nullable @Query("android") Boolean android,
      @Nullable @Query("ios") Boolean ios,
      @Nullable @Query("web") Boolean web,
      @Nullable @Query("endpoints") String endpoints);

  @POST("check_sqs")
  Call<AppCheckSqsResponse> checkSqs(@NotNull @Body AppCheckSqsRequestData appCheckSqsRequestData);
}
