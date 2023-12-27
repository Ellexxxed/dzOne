package com.example.home3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private String text = "У Лукоморья дуб зелёный, златая цепь на дубе том: " +
            "И днём и ночью кот учёный всё ходит по цепи кругом. " +
            "Идёт на право - песнь заводит, налево - сказку говорит, " +
            "Там чудеса, там Леший бродит, Русалка на ветвях сидит." +
            "Там на неведомых дорожках следы невиданных зверей, " +
            "Избушка там на курьих ножках стоит без окон, без дверей. " +
            "Там лес и дол видений полны, там о заре прихлынут волны на бред песчаный и пустой, " +
            "И тридцать витязей прекрасных чредой из вод выходят ясных. " +
            "Там королевич мимоходом пленяет грозного царя. " +
            "Там в облаках, перед народом, через леса, через моря колдун несёт богатыря. " +
            "В темнице, там, царевна тужит, а бурый волк ей верно служит. " +
            "Там ступа, с Бабою Ягой, идёт бредет сама собой, " +
            "Там царь Кащей над златом чахнет, там Русский дух, там Русью пахнет. " +
            "И там я был, и мёд я пил, у моря видел дуб зелёный, " +
            "Под ним сидел и кот учёный, свои, мне, сказки говорил. ";

    private int numOfSimv; // Количество символов
    private int numOfWords; // Количество слов
    private int numOfL; // Количество "Л"
    private boolean hasWordsOf5; // Количество слов из 5 букв
    private String startOfA; // начинается на "А"

    // Создание поля для вывода значений на экран.
    private TextView infoApp; // Вывод инфы анализа строчки

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        numOfSimv = countSimv(text);
        numOfWords = countWords(text);
        numOfL = countOfL(text);
        hasWordsOf5 = hasWordsOfFive(text);
        startOfA = startsA(text);

        //привязка полей к разметке
        infoApp = findViewById(R.id.infoApp);

        // вывод инфы
        infoApp.settext("Число сиолов в строке " + numOfSimv + "\n" +
                "Число слов в строке " + numOfWords + "\n" +
                "Наличие слов из 5 букв " + hasWordsOf5 + "\n" +
                "Наличие слов на букву А " + startOfA);
    }

    private int countWords(String stringText) {
        String[] words = stringText.split("\\s+");

        return words.length;
    }
    // определение количества символов
    private int numOfSimv(String StringText) {
        return StringText.length();
    }

    // подсчёт символов
    private int countSimv(String stringText) {
        return stringText.length();
    }

    // подсчёт букв "л"
    private int getNumOfL(String stringText){
        String[] chars = stringText.split("");
        int count = 0;
        for(String c : chars) {
            if (c.equals("л") || c.equals("Л")) {
                count++;
            }
        }
        return count;
    }

    //определение слов из 5 букв

    private boolean hasWordsOfFive(String stringText) {
        String[] words = stringText.split("\\s+");
        for(String word : words) {
            if (word.length() == 5) {
                return true;
            }
        }
        return false;
    }

    private String startsA (String str) {
        String[] words = str.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.startsWith("а") || word.startsWith("А")) {
                sb.append(word).append(" ");
            }
        }
        return sb.toString();
    }
}