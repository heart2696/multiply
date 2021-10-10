package com.example.multiply;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.multiply.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private final Random random = new Random();
    private int answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        refreshQuiz();
        binding.again.setOnClickListener(v -> refreshQuiz());
        binding.buttonanswer.setOnClickListener(v -> checkanswer());

    }
    private void refreshQuiz (){
        int left =random.nextInt(10)+1;
        int right= random.nextInt(10)+1;

        binding.firstnum.setText(Integer.toString(left));
        binding.secondnum.setText(Integer.toString(right));
        binding.answer.setText("");
        answer=left*right;

    }
    private void checkanswer(){
        String string = binding.answer.getText().toString();

        if (string.isEmpty()){
            Toast.makeText(this, "정답을 입력해 주세요", Toast.LENGTH_SHORT).show();
            return;
        }
        int value=Integer.parseInt(string);
        if (value==answer){
            Toast.makeText(this, "정답입니다", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "정답이 아닙니다", Toast.LENGTH_SHORT).show();
        }

    }
}