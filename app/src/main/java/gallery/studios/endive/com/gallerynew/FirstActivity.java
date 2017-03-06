package gallery.studios.endive.com.gallerynew;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by MWaqas on 2/22/2017.
 */

public class FirstActivity extends Activity implements View.OnClickListener{

    private Button galleryBtn,aboutBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        galleryBtn = (Button) findViewById(R.id.btnGallery);
        aboutBtn = (Button) findViewById(R.id.btnAbout);

        galleryBtn.setOnClickListener(this);
        aboutBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnGallery:
                Intent gallery = new Intent(this,GalleryActivity.class);
                startActivity(gallery);
                break;

            case R.id.btnAbout:
                Intent about = new Intent(this, AboutActivity.class);
                startActivity(about);
                break;
        }
    }
}
