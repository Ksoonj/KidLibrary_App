package comn.example.soonjae.kid_peace_library_app;

import java.util.ArrayList;

/**
 * Created by soonjae on 08/12/17.
 */

public class MyData {
    public String word;
    public String meaning;

    // 화면에 표시될 문자열 초기화
    public MyData(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }

    // 입력받은 숫자의 리스트생성
    public static ArrayList<MyData> createContactsList(int numContacts) {
        ArrayList<MyData> contacts = new ArrayList<MyData>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new MyData("Person ", "wohahahaha"));
        }

        return contacts;
    }
}

