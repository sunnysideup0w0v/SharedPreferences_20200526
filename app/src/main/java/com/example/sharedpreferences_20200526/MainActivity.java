package com.example.sharedpreferences_20200526;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.sharedpreferences_20200526.databinding.ActivityMainBinding;
import com.example.sharedpreferences_20200526.utils.ContextUtil;

public class MainActivity extends BaseActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        binding.idSaveCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    ContextUtil.setIdSave(mContext, true);
//                } else {
//                    ContextUtil.setIdSave(mContext, false);
//                }
                ContextUtil.setIdSave(mContext, isChecked);
            }
        });
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isIdSave = binding.idSaveCheckBox.isChecked();
                if(isIdSave){
//                    Toast.makeText(mContext, "아이디 저장 필요", Toast.LENGTH_SHORT).show();
                    String inputId = binding.emailEdt.getText().toString();
                    ContextUtil.setUserId(mContext, inputId);
                }
//                else {
//                    Toast.makeText(mContext, "아이디 저장 불필요", Toast.LENGTH_SHORT).show();
//                }
            }
        });
        binding.signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext,SignUpActivity.class);
                startActivity(myIntent);
            }
        });

    }

    @Override
    public void setValues() {
        binding.emailEdt.setText(ContextUtil.getUserId(mContext));
        binding.idSaveCheckBox.setChecked(ContextUtil.isIdSave(mContext));
    }
}
