package com.example.oracleandroid;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText getEmpNo;
    private EditText getName;
    private EditText getDeptNm;
    private EditText getTelNo;
    private Button signUpButton;
    private RetrofitService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getEmpNo = (EditText) findViewById(R.id.getEmpNo);
        getName = (EditText) findViewById(R.id.getName);
        getDeptNm = (EditText) findViewById(R.id.getDeptNm);   // email 형태 : AutoCompleteTextView
        getTelNo = (EditText) findViewById(R.id.getTelNo);
        signUpButton = (Button) findViewById(R.id.signUpButton);

        service = RetrofitClient.getClient().create(RetrofitService.class);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getEmpNoText = getEmpNo.getText().toString();
                String getNameText = getName.getText().toString();
                String getDeptNmText = getDeptNm.getText().toString();
                String getTelNoCheckText = getTelNo.getText().toString();

                System.out.println("getEmpNoText = " + getEmpNoText);
                System.out.println("getNameText = " + getNameText);
                System.out.println("getDeptNmText = " + getDeptNmText);
                System.out.println("getTelNoCheckText = " + getTelNoCheckText);
                startSignUp(new SignUpData(getEmpNoText, getNameText, getDeptNmText, getTelNoCheckText));
            }
        });

    }

    // 유효성 검사 및 회원가입 메서드 호출
//    private void attemptSignUp() {
//        getEmpNo.setError(null);
//        getName.setError(null);
//        getDeptNm.setError(null);
//        getTelNo.setError(null);
//
//        boolean cancel = false;
//        View focusView = null;
//
//        String getEmpNoText = getEmpNo.getText().toString();
//        String getNameText = getName.getText().toString();
//        String getDeptNmText = getDeptNm.getText().toString();
//        String getTelNoCheckText = getTelNo.getText().toString();
//
//        // 이름 유효성 검사사
//        if (getEmpNoText.isEmpty()) {
//            getEmpNo.setError("이름을 입력해주세요.");
//            focusView = getEmpNo;
//            cancel = true;
//        }
//
//        // 아이디 유효성 검사
//        if (idText.isEmpty()) {
//            id.setError("아이디 입력해주세요.");
//            focusView = id;
//            cancel = true;
//        }
//
//        // 비밀번호 유효성 검사
//        if (passwordText.isEmpty()) {
//            password.setError("비밀번호를 입력해주세요.");
//            focusView = password;
//            cancel = true;
//        } else if (!isPasswordValid(passwordText)) {
//            password.setError("6자 이상의 비밀번호를 입력해주세요.");
//            focusView = password;
//            cancel = true;
//        }
//
//        if (cancel) {
//            focusView.requestFocus();
//        } else {
//            startSignUp(new SignUpData(nameText, idText, passwordText, passwordCheckText));
//        }
//
//    }

    // 회원가입 처리
    private void startSignUp(SignUpData data) {
        // enqueue()에 파라미터로 넘긴 콜백 - 통신이 성공/실패 했을 때 수행할 동작을 재정의
        service.userSignUp(data).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                SignUpResponse result = response.body();

                if (result.getCode() == 200) {
                    Toast.makeText(MainActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "회원가입 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("회원가입 에러 발생", t.getMessage());

            }
        });
    }

//    private boolean isPasswordValid(String passwordText) {
//        return passwordText.length() >= 8;
//    }

}