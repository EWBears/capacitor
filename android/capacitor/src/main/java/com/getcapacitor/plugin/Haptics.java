package com.getcapacitor.plugin;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.HapticFeedbackConstants;

import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

/**
 * Haptic engine plugin, also handles vibration.
 *
 * If you'd like to use this plugin for vibration,
 * add the following permissions to * your AndroidManifest.xml:
 * <uses-permission android:name="android.permission.VIBRATE"/>
 */
@NativePlugin()
public class Haptics extends Plugin {

  @PluginMethod()
  public void vibrate(PluginCall call) {
    Context c = this.getContext();
    int duration = call.getInt("duration", 300);

    if(!hasPermission(Manifest.permission.VIBRATE)) {
      call.error("Can't vibrate: Missing VIBRATE permission in AndroidManifest.xml");
      return;
    }

    if (Build.VERSION.SDK_INT >= 26) {
      ((Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(duration, VibrationEffect.DEFAULT_AMPLITUDE));
    } else {
      ((Vibrator) c.getSystemService(Context.VIBRATOR_SERVICE)).vibrate(duration);
    }

    call.success();
  }

  @PluginMethod()
  public void impact(PluginCall call) {
    this.bridge.getWebView().performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
    call.success();
  }

  @PluginMethod()
  public void selectionStart(PluginCall call) {
    // Not yet implemented
    call.success();
  }

  @PluginMethod()
  public void selectionChanged(PluginCall call) {
    // Not yet implemented
    call.success();
  }

  @PluginMethod()
  public void selectionEnd(PluginCall call) {
    // Not yet implemented
    call.success();
  }
}
