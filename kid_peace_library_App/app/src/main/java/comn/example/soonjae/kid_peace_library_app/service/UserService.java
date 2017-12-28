package comn.example.soonjae.kid_peace_library_app.service;

import comn.example.soonjae.kid_peace_library_app.ResObj;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by soonjae on 27/12/17.
 */

public interface UserService {

    @POST("api/v1.0/login")
    Call<ResObj> login(@Path("username")String username ,@Path("password") String password);




}
