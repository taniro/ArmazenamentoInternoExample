package tads.eaj.com.armazenamentointernoexample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    String FILENAME = "hello_file";
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);

        // Read File and Content
        readFile();

    }

    public void readFile() {
        // Read File and Content
        FileInputStream fin ;
        try {
            //abre o arquivo chamado FILENAME para LEITURA
            fin = openFileInput(FILENAME);
            int size;
            String newText = "";

            // read inside if it is not null (-1 means empty)
            while ((size = fin.read()) != -1) {
                // add & append content
                newText += Character.toString((char) size);
            }

            editText.setText(newText);
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarTextoClick(View v){

        //Write file and content
        FileOutputStream fos;

        try {
            //abre o arquivo chamado FILENAME para ESCRITA
            fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(editText.getText().toString().getBytes());
            fos.close();
            Toast.makeText(this, "Salvo!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void readFileClick(View v) {
        // Read File and Content
        FileInputStream fin ;
        try {
            //abre o arquivo chamado FILENAME para LEITURA
            fin = openFileInput(FILENAME);
            int size;
            String newText = "";

            // le enquanto é possível
            while ((size = fin.read()) != -1) {
                Log.i( "Leu", ""+(char)size);
                // add & append content
                newText += Character.toString((char) size);
            }

            Toast.makeText(this, newText, Toast.LENGTH_SHORT).show();
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
