package kr.co.md00to22.dailys;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityWriteMemo extends AppCompatActivity {
    @BindView(R.id.btn_cate) ImageView btnCategory;
    @BindView(R.id.btn_image) ImageView btnImage;
    @BindView(R.id.btn_check) ImageView btnCheckList;
    @BindView(R.id.btn_lock) ImageView btnLock;
    @BindView(R.id.btn_save) TextView btnSave;
    @BindView(R.id.attachImage) ImageView contentImage;
    @BindView(R.id.write_memo_content) EditText contentText;

    Uri imgUrl=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo_write);
        ButterKnife.bind(this);


        WriteBtnListner writeBtnListner=new WriteBtnListner();
        btnCategory.setOnClickListener(writeBtnListner);
        btnCheckList.setOnClickListener(writeBtnListner);
        btnImage.setOnClickListener(writeBtnListner);
        btnSave.setOnClickListener(writeBtnListner);
        btnLock.setOnClickListener(writeBtnListner);

    }

    void clickImage(){
        //카메라, 갤러리에서 이미지 가져오기
        AlertDialog.Builder builder=new AlertDialog.Builder(this);


    }

    void clickSave(){

        //외부메모리가 있는지 확인. 없으면 내부메모리 사용할 것(용량문제 알림띄우기)
        String state = Environment.getExternalStorageState();

        if(state.equals(Environment.MEDIA_MOUNTED)){
            //외부메모리 저장

        }else{
            //내부메모리 저징
        }
    }

    class WriteBtnListner implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String btntitle="";

            switch (v.getId()){
                case R.id.btn_cate:
                    btntitle="카테고리";
                    break;

                case R.id.btn_image:
                    btntitle="이미지삽입";
                    clickImage();
                    break;

                case R.id.btn_check:
                    btntitle="체크리스트 삽입";
                    break;

                case R.id.btn_lock:
                    btntitle="잠금";
                    break;


                case R.id.btn_save:
                    btntitle="저장";
                    clickSave();
                    break;


            }
            Toast.makeText(ActivityWriteMemo.this, btntitle+" 버튼", Toast.LENGTH_SHORT).show();
        }
    }
}
