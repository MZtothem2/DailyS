package kr.co.md00to22.dailys;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityMain extends AppCompatActivity {
    @BindView(R.id.list_recyclerview) RecyclerView recyclerView;
    @BindView(R.id.fnb) FloatingActionButton fnb;

    ArrayList<Memo> memoes=new ArrayList<>();
    RcMemoAdapter memoAdapter;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        //외부메모리사용에 대한 동적 퍼미션
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            int permissionResult=checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE); //사용자에게는 외부저장소 하나만 물어보고 읽기/쓰기까지 상세히는 묻지 않음
            if(permissionResult==PackageManager.PERMISSION_DENIED){
                String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions, 100); //->다이얼로그 뜸
            }
        }

        // Toolbar
        setSupportActionBar((Toolbar)findViewById(R.id.read_toolbar));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //recyclerView설정
        testMemo();
        memoAdapter=new RcMemoAdapter(memoes, ActivityMain.this);
        recyclerView.setAdapter(memoAdapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(ActivityMain.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        //fnb설정

        fnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityMain.this, ActivityWriteMemo.class));
            }
        });



}//onCreate()..


    // MENU Settings...
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.read_menu, menu);

        //SearchView 설정
        MenuItem item=menu.findItem(R.id.menu_read_search);
        searchView=(SearchView)item.getActionView();
        searchView.setQueryHint("검색");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchView.setQuery("",true);
                searchView.setIconified(true);  //돋보기모양으로 바꾸기
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //todo : 검색문자 포함된 메모 recyclerview에 띄우기
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){



            case R.id.menu_read_modify:
                break;

            case R.id.menu_read_admincate:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 100:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this, "카메라 앱 사용 가능", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "카메라 기능 사용 제한", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }//onRequestPermissionsResult method


    void testMemo(){

        Memo tesetmemo=new Memo("테스트메모", "", false, "", false);
        tesetmemo.getTexts().add("메모테스트중...");

        memoes.add(tesetmemo);
        memoes.add(tesetmemo);
        memoes.add(tesetmemo);
        memoes.add(tesetmemo);
        memoes.add(tesetmemo);
        memoes.add(tesetmemo);
        memoes.add(tesetmemo);

    }//testMemo()
}
