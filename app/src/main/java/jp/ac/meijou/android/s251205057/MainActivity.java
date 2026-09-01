package jp.ac.meijou.android.s251205057;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.prefs.PreferencesFactory;

import jp.ac.meijou.android.s251205057.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        //setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //TextView textView = findViewById(R.id.text_view);
        //textView.setText(R.string.name);
        binding.textView.setText(R.string.text);

        binding.imageView.setImageResource(R.drawable.outline_accessibility_24);

        binding.button.setOnClickListener(view ->{binding.textView.setText(binding.editTextText.getText().toString());});




        prefDataStore = PrefDataStore.getInstance(this);

        binding.saveButton.setOnClickListener(view->{
            var text = binding.editTextText.getText().toString();
            prefDataStore.setString("name",text);
        });
    }
}