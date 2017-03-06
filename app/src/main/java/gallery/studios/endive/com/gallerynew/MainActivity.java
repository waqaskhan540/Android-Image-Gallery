package gallery.studios.endive.com.gallerynew;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.veinhorn.scrollgalleryview.MediaInfo;
import com.veinhorn.scrollgalleryview.ScrollGalleryView;
import com.veinhorn.scrollgalleryview.loader.DefaultImageLoader;
import com.veinhorn.scrollgalleryview.loader.DefaultVideoLoader;
import com.veinhorn.scrollgalleryview.loader.MediaLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static gallery.studios.endive.com.gallerynew.StaticImages.image_ids;

public class MainActivity extends FragmentActivity {



    private ScrollGalleryView scrollGalleryView;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        List<MediaInfo> infos = new ArrayList<MediaInfo>(image_ids.length);
        for(int i = 0;i< image_ids.length;i++){
            infos.add(MediaInfo.mediaLoader(new DefaultImageLoader(image_ids[i])));
        }

        scrollGalleryView = (ScrollGalleryView) findViewById(R.id.scroll_gallery_view);
        scrollGalleryView
                .setThumbnailSize(100)
                .setZoom(true)

                .setFragmentManager(getSupportFragmentManager())

                .addMedia(infos);

        Bundle extras = getIntent().getExtras();
        int imagePos = extras.getInt("imagePos");


        scrollGalleryView.setCurrentItem(imagePos);
    }

    private Bitmap toBitmap(int image) {
        return ((BitmapDrawable) getResources().getDrawable(image)).getBitmap();
    }
}