package comn.example.soonjae.kid_peace_library_app.adapter;

/**
 * Created by soonjae on 21/12/17.
 */

public class Data {
    String title,about;
    int photo,viewtype;

    public Data(int photo, int viewtype) {
        this.title = title;
        this.about = about;
        this.photo = photo;
        this.viewtype=viewtype;
    }

    public Data(String title, String about, int viewtype) {
        this.title = title;
        this.about = about;
        this.viewtype=viewtype;
    }

}