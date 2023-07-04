package sg.edu.rpc346.id22035553.song;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    public class DisplayActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        }
    }

    EditText etSongTitle, etSinger, etYear;
    RadioButton rb1, rb2, rb3, rb4, rb5;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSongTitle = findViewById(R.id.etSongTitle);
        etSinger = findViewById(R.id.etSinger);
        etYear = findViewById(R.id.etYear);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        rb5 = findViewById(R.id.rb5);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = etSongTitle.getText().toString();
                String singers = etSinger.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int stars = getSelectedStars();

                DBHelper dbHelper = new DBHelper(MainActivity.this);
                dbHelper.insertTask(title, singers, year, stars);

                etSongTitle.setText("");
                etSinger.setText("");
                etYear.setText("");
                rb1.setChecked(true);
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch new activity to display records
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }

    private int getSelectedStars() {
        if (rb1.isChecked()) {
            return 1;
        } else if (rb2.isChecked()) {
            return 2;
        } else if (rb3.isChecked()) {
            return 3;
        } else if (rb4.isChecked()) {
            return 4;
        } else if (rb5.isChecked()) {
            return 5;
        }
        return 0;
    }
}
