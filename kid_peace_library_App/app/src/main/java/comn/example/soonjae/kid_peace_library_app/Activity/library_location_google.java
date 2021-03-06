package comn.example.soonjae.kid_peace_library_app;


import android.content.DialogInterface;
import android.content.pm.PackageManager;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


public class library_location_google extends AppCompatActivity implements OnMapReadyCallback {

    //체크할 권한 배열
    String[] permission_list = {
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
    };
    // 현재 사용자 위치
    Location myLocation;
    //    TextView text;
    // 위치 정보를 관리하는 매니저
    LocationManager manager;

    //지도를 관리하는 객체
    GoogleMap map;

    //구글 서버로 부터 받아온 데이터를 저장할 리스트
    ArrayList<Double> lat_list;
    ArrayList<Double> lng_list;
    ArrayList<String> name_list;
    ArrayList<String> vicinity_list;
    //지도의 표시한 마커(주변장소표시)를 관리하는 객체를 담을 리스트
    ArrayList<Marker> markers_list;


    //types값배열
    String[] category_name_array = {
            "경기", "서울", "충청도", "전라도", "강원도", "경상도"
    };
    //types 값 배열
    String[] category_value_array = {
            "kyungki", "seoul", "choongchung", "zhenra", "gangwon", "kyungsang"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_location_google);

        //구글 맵 객체를 추출
        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment map_frag = (SupportMapFragment) fm.findFragmentById(R.id.fragment);
        map_frag.getMapAsync(this);

        lat_list = new ArrayList<>();
        lng_list = new ArrayList<>();
        name_list = new ArrayList<>();
        vicinity_list = new ArrayList<>();
        markers_list = new ArrayList<>();

//        text = (TextView)findViewById(R.id.text1);
        checkPermission();

    }

    public void checkPermission() {
        boolean isGrant = false;
        for (String str : permission_list) {
            if (ContextCompat.checkSelfPermission(this, str) == PackageManager.PERMISSION_GRANTED) {
            } else {
                isGrant = false;
                break;
            }
        }
        if (isGrant == false) {
            ActivityCompat.requestPermissions(this, permission_list, 0);
        }
    }

    // 사용자가 권한 허용/거부 버튼을 눌렀을 때 호출되는 메서드
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean isGrant = true;
        for (int result : grantResults) {
            if (result == PackageManager.PERMISSION_DENIED) {
                isGrant = false;
                break;
            }
        }
        // 모든 권한을 허용했다면 사용자 위치를 측정한다.
        if (isGrant == true) {
            getMyLocation();
        }
    }

    // 현재 위치를 가져온다.
    public void getMyLocation() {
        manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        // 권한이 모두 허용되어 있을 때만 동작하도록 한다.
        int chk1 = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION);
        int chk2 = ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION);
        if (chk1 == PackageManager.PERMISSION_GRANTED && chk2 == PackageManager.PERMISSION_GRANTED) {
            myLocation = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            showMyLocation();
        }
        // 새롭게 위치를 측정한다.
        GpsListener listener = new GpsListener();
        if (manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 10, listener);
        }
        if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, listener);
        }
    }

    // GPS Listener
    class GpsListener implements LocationListener {
        @Override
        public void onLocationChanged(Location location) {
            // 현재 위치 값을 저장한다.
            myLocation = location;
            // 위치 측정을 중단한다.
            manager.removeUpdates(this);
            // 지도를 현재 위치로 이동시킨다.
            showMyLocation();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }
    }

    public void showMyLocation() {
        // LocationManager.GPS_PROVIDER 부분에서 null 값을 가져올 경우를 대비하여 장치
        if (myLocation == null) {
            return;
        }
        // 현재 위치값을 추출한다.
        double lat = myLocation.getLatitude();
        double lng = myLocation.getLongitude();

        //위도 경도를 관리하는 객체를 생성
        LatLng position = new LatLng(lat, lng);

        //현재 위치를 설정한다.
        CameraUpdate update1 = CameraUpdateFactory.newLatLng(position);
        map.moveCamera(update1);

        //확대
        CameraUpdate update2 = CameraUpdateFactory.zoomTo(15);
        map.animateCamera(update2);

        //현재 위치 표시
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        map.setMyLocationEnabled(true);

        //지도모드 변경
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    //메뉴 항목을 터치하면 호출되는 메서드

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //id 추출
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                getMyLocation();    //현재 위치 측정
                break;
            case R.id.item2:
                showCategoryList();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // 주변 카테고리 리스트
    private void showCategoryList() {
        // 카테고리를 선택 할 수 있는 리스트를 띄운다.
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("검색 지역 선택");
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,category_name_array
        );
        DialogListener listener=new DialogListener();
        builder.setAdapter(adapter,listener);
        builder.setNegativeButton("취소",null);
        builder.show();
    }
    // 다이얼로그의 리스너   각 도별로 시점이동
    class DialogListener implements DialogInterface.OnClickListener{

        @Override
        public void onClick(DialogInterface dialogInterface, int i) {

            //다이얼로그 클릭시 발생되는이벤트
            String type = category_value_array[i];
            LatLng latLng = new LatLng(37.27466, 127.00964);
            map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
            map.animateCamera(CameraUpdateFactory.zoomTo(12));
        }
    }


//    class NetworkThread extends Thread {
//        String type_keyword;
//        public NetworkThread(String type_keyword){
//            this.type_keyword=type_keyword;
//        }
//        @Override
//        public void run() {
//            try{
//                //데이터를 담아놓을 리스트를 초기화한다.
//                lat_list.clear();
//                lng_list.clear();
//                name_list.clear();
//                vicinity_list.clear();
//
//                // 접속할 페이지 주소
//                String site="https://maps.googleapis.com/maps/api/place/nearbysearch/json";
//                site+="?location="+myLocation.getLatitude()+","
//                        +myLocation.getLongitude()
//                        +"&radius=1000&sensor=false&language=ko"
//                        +"&key=AIzaSyCs-UXo7-EeUIun*******************";
//                if(type_keyword!=null && type_keyword.equals("all")==false){
//                    site+="&types="+type_keyword;
//                }
//                // 접속
//                URL url=new URL(site);
//                URLConnection conn=url.openConnection();
//                // 스트림 추출
//                InputStream is=conn.getInputStream();
//                InputStreamReader isr =new InputStreamReader(is,"utf-8");
//                BufferedReader br=new BufferedReader(isr);
//                String str=null;
//                StringBuffer buf=new StringBuffer();
//                // 읽어온다
//                do{
//                    str=br.readLine();
//                    if(str!=null){
//                        buf.append(str);
//                    }
//                }while(str!=null);
//                String rec_data=buf.toString();
//                // JSON 데이터 분석
//                JSONObject root=new JSONObject(rec_data);
//                //status 값을 추출한다.
//                String status=root.getString("status");
//                // 가져온 값이 있을 경우에 지도에 표시한다.
//                if(status.equals("OK")){
//                    //results 배열을 가져온다
//                    JSONArray results=root.getJSONArray("results");
//                    // 개수만큼 반복한다.
//                    for(int i=0; i<results.length() ; i++){
//                        // 객체를 추출한다.(장소하나의 정보)
//                        JSONObject obj1=results.getJSONObject(i);
//                        // 위도 경도 추출
//                        JSONObject geometry=obj1.getJSONObject("geometry");
//                        JSONObject location=geometry.getJSONObject("location");
//                        double lat=location.getDouble("lat");
//                        double lng=location.getDouble("lng");
//                        // 장소 이름 추출
//                        String name=obj1.getString("name");
//                        // 대략적인 주소 추출
//                        String vicinity=obj1.getString("vicinity");
//                        // 데이터를 담는다.
//                        lat_list.add(lat);
//                        lng_list.add(lng);
//                        name_list.add(name);
//                        vicinity_list.add(vicinity);
//                    }
////                    showMarker();
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),"가져온 데이터가 없습니다.",Toast.LENGTH_LONG).show();
//                }
//
//            }catch (Exception e){e.printStackTrace();}
//        }
//
//    }

    // 지도에 마커를 표시한다
//    public void showMarker(){
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                // 지도에 마커를 표시한다.
//                // 지도에 표시되어있는 마커를 모두 제거한다.
////                for(Marker marker : markers_list){
////                    marker.remove();
////                }
////                markers_list.clear();
//                // 가져온 데이터의 수 만큼 마커 객체를 만들어 표시한다.
//                for(int i= 0 ; i< lat_list.size() ; i++){
//                    // 값 추출
//                    double lat = lat_list.get(i);
//                    double lng = lng_list.get(i);
//                    String name=name_list.get(i);
//                    String vicinity=vicinity_list.get(i);
//                    // 생성할 마커의 정보를 가지고 있는 객체를 생성
//                    MarkerOptions options=new MarkerOptions();
//                    // 위치설정
//                    LatLng pos=new LatLng(lat,lng);
//                    options.position(pos);
//                    // 말풍선이 표시될 값 설정
//                    options.title(name);
//                    options.snippet(vicinity);
//                    // 아이콘 설정
//                    //BitmapDescriptor icon= BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher);
//                    //options.icon(icon);
//                    // 마커를 지도에 표시한다.
//                    Marker marker=map.addMarker(options);
//                    markers_list.add(marker);
//                }
//            }
//        });
//    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.map = googleMap;
        Double lat;
        Double lng;

        for (int idx = 0; idx <10;idx++) {

            //좌표설정
            LatLng seoul = new LatLng(37.71824, 126.68862);
            //데이터들을 리스트화 시켜 차례로 찍기

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(seoul).title("경기도 파주시 보리책노리터");

            map.addMarker(markerOptions);
        }

    }
}
