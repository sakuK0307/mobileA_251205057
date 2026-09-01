package jp.ac.meijou.android.s251205057;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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



        prefDataStore.getString("name").ifPresent(text ->{
            if("a".equals(text)){
                binding.imageView.setImageResource(R.drawable.ic_launcher_foreground);
                binding.textView.setText("Aの画像");
            }else if("b".equals(text)){
                binding.imageView.setImageResource(R.drawable.outline_accessibility_24);
                binding.textView.setText("Bの画像");
            }else{
                binding.textView.setText("知らない画像");
            }
        });

        binding.saveButton.setOnClickListener(view->{
            var text = binding.editTextText.getText().toString();
            if("a".equals(text)){
                binding.imageView.setImageResource(R.drawable.outline_accessible_24);
                binding.textView.setText("Aの画像");
            }else if("b".equals(text)){
                binding.imageView.setImageResource(R.drawable.outline_accessibility_24);
                binding.textView.setText("Bの画像");
            }else{
                binding.textView.setText("知らない画像");
            }
            prefDataStore.setString("name",text);
        });

        binding.resetButton.setOnClickListener(view ->{
            binding.editTextText.setText("");
        });
    }
}