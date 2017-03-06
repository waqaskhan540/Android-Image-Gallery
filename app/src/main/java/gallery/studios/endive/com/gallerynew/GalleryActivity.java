package gallery.studios.endive.com.gallerynew;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import static gallery.studios.endive.com.gallerynew.StaticImages.image_ids;
import static gallery.studios.endive.com.gallerynew.StaticImages.image_titles;

/**
 * Created by MWaqas on 1/28/2017.
 */

public class GalleryActivity extends Activity {

    private RecyclerView recyclerView;
    private AdView adview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);

        adview = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adview.loadAd(adRequest);

        recyclerView = (RecyclerView)findViewById(R.id.imagegallery);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<CreateList> createLists = prepareData();
        MyAdapter adapter = new MyAdapter(getApplicationContext(), createLists);
        recyclerView.setAdapter(adapter);

    }


    private ArrayList<CreateList> prepareData(){

        ArrayList<CreateList> theimage = new ArrayList<>();
        for(int i = 0; i< image_titles.length; i++){
            CreateList createList = new CreateList();
            createList.setImage_title(image_titles[i]);
            createList.setImage_ID(image_ids[i]);
            theimage.add(createList);
        }
        return theimage;
    }
    public class CreateList {

        private String image_title;
        private Integer image_id;

        public String getImage_title() {
            return image_title;
        }

        public void setImage_title(String android_version_name) {
            this.image_title = android_version_name;
        }

        public Integer getImage_ID() {
            return image_id;
        }

        public void setImage_ID(Integer android_image_url) {
            this.image_id = android_image_url;
        }
    }
}
