package comn.example.soonjae.kid_peace_library_app;

import comn.example.soonjae.kid_peace_library_app.service.RetrofitClient;
import comn.example.soonjae.kid_peace_library_app.service.UserService;

/**
 * Created by soonjae on 27/12/17.
 */

public class ApiUtils{



    public static final String BASE_URL = "http://127.0.0.1:5000/";

    public static UserService getUserService(){

        return RetrofitClient.getClient(BASE_URL).create(UserService.class);



}


}
