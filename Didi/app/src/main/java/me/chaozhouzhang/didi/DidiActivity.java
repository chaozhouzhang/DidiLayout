package me.chaozhouzhang.didi;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tencentmap.mapsdk.map.MapView;

import static me.chaozhouzhang.didi.DidiLayout.State.EXPANDED;

/**
 * @author zhangchaozhou
 */
public class DidiActivity extends AppCompatActivity {
    private static final String TAG = "DidiActivity";

    private DidiLayout mLayout;


    private LinearLayout mLlNav;

    private TextView mTvBack;

    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_didi);


        mMapView = findViewById(R.id.map);


        mLayout = (DidiLayout) findViewById(R.id.sliding_layout);
        mLlNav = findViewById(R.id.ll_nav);
        mLayout.addPanelSlideListener(new DidiLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                Log.i(TAG, "onPanelSlide, offset " + slideOffset);
            }

            @Override
            public void onStateChanged(View panel, DidiLayout.State previousState, DidiLayout.State newState) {
                Log.i(TAG, "onStateChanged " + newState);
                if (newState == EXPANDED) {
                    mTvBack.setVisibility(View.VISIBLE);
                    ViewCompat.setTranslationY(mLlNav, -mLlNav.getHeight());
                } else {
                    mTvBack.setVisibility(View.GONE);
                    ViewCompat.setTranslationY(mLlNav, 0);
                }
            }

            @Override
            public void onMainSlide(float mainViewOffset) {


                System.out.println("onMainSlide:" + mainViewOffset);
//            ViewCompat.setTranslationY(mLlNav, mainViewOffset);
            }
        });
        mLayout.setFadeOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mLayout.setState(DidiLayout.State.COLLAPSED);
            }
        });


        mTvBack = findViewById(R.id.tv_back);
        mTvBack.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mLayout.setState(DidiLayout.State.COLLAPSED);
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (mLayout != null && (mLayout.getState() == EXPANDED || mLayout.getState() == DidiLayout.State.ANCHORED)) {
            mLayout.setState(DidiLayout.State.COLLAPSED);
        } else {
            super.onBackPressed();
        }
    }

    public void toast8(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast7(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast6(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast5(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast4(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast3(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast2(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast1(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast9(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast10(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }


    public void toast11(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast12(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast13(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast14(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }


    public void toast15(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast16(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

    public void toast17(View view) {
        Toast.makeText(this, System.currentTimeMillis() + "", Toast.LENGTH_LONG).show();
    }

}
