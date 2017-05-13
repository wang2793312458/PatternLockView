package com.example.patternlockview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.PatternLockView.Dot;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private PatternLockView mPatternLockView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mPatternLockView = (PatternLockView) findViewById(R.id.pattern_lock_view);
    mPatternLockView.addPatternLockListener(mPatternLockViewListener);
  }

  private PatternLockViewListener mPatternLockViewListener = new PatternLockViewListener() {
    @Override
    public void onStarted() {

      Toast.makeText(MainActivity.this, "模式图开始 ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProgress(List<Dot> progressPattern) {
      Toast.makeText(MainActivity.this, "模式的进步: " +
          PatternLockUtils.patternToString(mPatternLockView, progressPattern), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onComplete(List<PatternLockView.Dot> pattern) {

      Toast.makeText(MainActivity.this, "模式完整: " +
          PatternLockUtils.patternToString(mPatternLockView, pattern), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCleared() {
      Toast.makeText(MainActivity.this, "模式已清除 ", Toast.LENGTH_SHORT).show();
    }
  };
}
