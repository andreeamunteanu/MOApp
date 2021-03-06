package activities;

import com.example.moapplic.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


public class SlideShowActivity extends Activity implements
        AdapterView.OnItemSelectedListener, ViewSwitcher.ViewFactory {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(0);
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.slide_show);
       
        
        mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);
        mSwitcher.setFactory(this);
        mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));

        @SuppressWarnings("deprecation")
		Gallery g = (Gallery) findViewById(R.id.gallery);
        g.setAdapter(new ImageAdapter(this));
        g.setOnItemSelectedListener(this);
    }

    private void requestFeature() {
		// TODO Auto-generated method stub
		
	}

	public void onItemSelected(@SuppressWarnings("rawtypes") AdapterView parent, View v, int position, long id) {
        mSwitcher.setImageResource(mImageIds[position]);
    }

    public void onNothingSelected(@SuppressWarnings("rawtypes") AdapterView parent) {
    }

    @SuppressWarnings("deprecation")
	public View makeView() {
        ImageView i = new ImageView(this);
        i.setBackgroundColor(0xFF000000);
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        i.setLayoutParams(new ImageSwitcher.LayoutParams(
                LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        return i;
    }

    private ImageSwitcher mSwitcher;

    public class ImageAdapter extends BaseAdapter {
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        @SuppressWarnings("deprecation")
		public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);

            i.setImageResource(mThumbIds[position]);
            i.setAdjustViewBounds(true);
            i.setLayoutParams(new LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            i.setImageDrawable(getResources().getDrawable(R.drawable.abc_list_selector_background_transition_holo_dark));
            return i;
        }
        
        

        private Context mContext;

    }

    private Integer[] mThumbIds = { R.drawable.img1, R.drawable.img2,
           R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6,
           R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10  };

    private Integer[] mImageIds = { R.drawable.img1, R.drawable.img2,
            R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6,
            R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10  };



}