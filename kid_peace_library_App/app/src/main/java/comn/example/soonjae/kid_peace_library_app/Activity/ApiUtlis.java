package comn.example.soonjae.kid_peace_library_app.Activity;

import comn.example.soonjae.kid_peace_library_app.data.model.remote.RetrofitClient;
import comn.example.soonjae.kid_peace_library_app.data.model.remote.SOServiced;

/**
 * Created by soonjae on 18/12/17.
 */

public class ApiUtlis {

    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    public static SOServiced getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOServiced.class);
    }
}
