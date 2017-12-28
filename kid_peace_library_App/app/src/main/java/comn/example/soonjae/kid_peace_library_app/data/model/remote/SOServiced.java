package comn.example.soonjae.kid_peace_library_app.data.model.remote;

import comn.example.soonjae.kid_peace_library_app.data.model.SOAnswersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by soonjae on 18/12/17.
 */

public interface SOServiced {

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers();

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers(@Query("tagged") String tags);


    }
