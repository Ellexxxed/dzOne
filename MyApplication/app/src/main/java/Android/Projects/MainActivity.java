package Android.Projects;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // Создадим поля
    private float Spongecakes = 10; // Бисквитные коржи
    private int SpongecakesDiscount = 26; // Cкидка на бисквитные коржи
    private float Cream = 14; // Сливки
    private int CreamDiscount = 5; // Скидка на сливки
    private float Fruit = 3; // Фрукты
    private int FruitDiscount = 12; // Скидка на фрукты
    private float Nuts = 5; // Орехи
    private int NutsDiscount = 55; // Скидка на орехи
    private float Berries = 7; // Ягоды
    private float account = 45; // Баланс на счету

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка покупки

    // вывод на экран полученных данных
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanseState) { // Создание жизненного цикла активности
        super.onCreate(savedInstanseState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активности представления activiti_main

        possibilityOut = findViewById(R.id.possibilityOut);
        balanceOut = findViewById(R.id.balanceOut);

        // запонение экрана

        if (possibility()) { // если имеется возможность купить ингридиенты
            possibilityOut.setText("Имеется достаточно средств для покупки ингридиентов");
            balanceOut.setText("Остаток от покупки " + balance() + " монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки ингридиентов");
            balanceOut.setText(" - ");
        }
    }

    // метод подсчета стоимости ингридиентов
    private float calculation() {
        // Создание и инцелизация переменной подсчета стоимости
        float count = (Spongecakes * (100 - SpongecakesDiscount) + Cream * (100 - CreamDiscount)
                + Fruit * (100 - FruitDiscount)
                + Nuts * (100 - NutsDiscount)) / 100 + Berries;
        return count; // возврат подсчитанного значения
    }

    // Метод определения возможности бюджета покупки ингридиентов
    private boolean possibility () {
        if (calculation() <= account) { // если стоимость ингридиентов меньше имеющихся средств
            return true; // то возврат инстинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // Метод определения возможной сдачи
    private float balance () {
        if (possibility()) { // если имеется возможность купить ингридиенты
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных  средств
        }
    }
}