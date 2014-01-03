package net.mattcoffey.choppa;

import net.mattcoffey.choppa.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ChoppaActivity extends Activity {
	
	private SoundManager mSoundManager;
	private ImageView arnie;
	private Button button;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mSoundManager = new SoundManager();
        mSoundManager.initSounds(getBaseContext());
        mSoundManager.addSound(1, R.raw.clip);
        
        arnie = (ImageView)findViewById(R.id.arnie);
        button = (Button)findViewById(R.id.Button);
        button.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		LinearLayout layout = (LinearLayout) button.getParent();
        		layout.removeView(button);
        		button.setVisibility(Button.INVISIBLE);
        		arnie.setVisibility(ImageView.VISIBLE);
        		mSoundManager.playSound(1);
        	}
        });
    }
}