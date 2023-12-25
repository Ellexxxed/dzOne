package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // задание полей

    int robotCost = 35000; // стоимость робота
    int saving = 700; // счёт пользователя
    int allwance = 1700; // ежемесечная стипендия
    double interestRate = 9.0; // годовая процентная ставка по накоплениям
    int[] monthlySaving = new int[100]; // создание массива ежемесячных накоплений

    // создание дополнительных полей для вывода на экран поолученных значений
    private TextView countOut; // поле вывода количества месяцев накоплений
    private TextView manyMonthOut; // поле выписки по ежемесячным накоплениям
    private String i;

    // Вывод на экран полученных значений

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double percentMonth = interestRate / 12; // Месячная процентная ставка по накоплениям

        TextView textView = findViewById(R.id.textResult);

        for(int i = 1; i <= 60; i++)
            saving += saving * percentMonth / 100;

        if (saving >= robotCost) {

            textView.append("Мы копили:" + i + "месяцев");
             break;
        }

    }
}    