package au.com.bottomsheet;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetBehavior bottomSheetBehavior;
    Button expand, collapse, hide, show;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        expand = (Button) findViewById(R.id.e1);
        collapse = (Button) findViewById(R.id.c1);
        hide = (Button) findViewById(R.id.h1);
        show = (Button) findViewById(R.id.s1);

        final Button t1 = (Button) findViewById(R.id.b1);
        t1.setOnClickListener(this);

        expand.setOnClickListener(this);
        collapse.setOnClickListener(this);
        hide.setOnClickListener(this);
        show.setOnClickListener(this);

        View bsm = findViewById(R.id.bsm1);
        bottomSheetBehavior = BottomSheetBehavior.from(bsm);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == bottomSheetBehavior.STATE_EXPANDED) {

                    t1.setText("Collapse");
                    flag = 1;
                } else if (newState == bottomSheetBehavior.STATE_COLLAPSED) {

                    t1.setText("Expand");
                    flag = 0;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.e1:

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                break;

            case R.id.b1:

                if (flag == 0) {

                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else if (flag == 1) {

                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
                break;


            case R.id.c1:

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

                break;

            case R.id.h1:

                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

                break;

            case R.id.s1:

                new MyBottomSheetDialogFragment().show(getSupportFragmentManager(), MainActivity.class.getSimpleName());

                break;

            default:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
        }
    }
}
