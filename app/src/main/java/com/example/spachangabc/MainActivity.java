package com.example.spachangabc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static LinearLayout square ;
    public static ImageView imageAA ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        square = findViewById(R.id.backchng);
        imageAA =findViewById(R.id.img_chg);

        Intent intent = new Intent(this, SpamABC.class);
        startService(intent);

    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater inflaterAA = getMenuInflater();
//        inflaterAA.inflate(R.menu.spikmain,menu);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.spikmain,menu);
        return true;
    }

//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.spiktest:
//                Toast.makeText(this,"喜歡吃南瓜^^",Toast.LENGTH_SHORT).show();
//                return true;
//
//                default:
//                    return super.onContextItemSelected(item);
//        }
//    }
}
