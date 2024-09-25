package py.com.exo.c72_trigger_button_plugin;

import android.app.Activity;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.EventChannel.EventSink;
import io.flutter.plugin.common.PluginRegistry;

public class C72TriggerButtonPlugin implements FlutterPlugin, ActivityAware, PluginRegistry.ViewDestroyListener {

  private EventChannel.EventSink eventSink;
  private Activity activity;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    new EventChannel(flutterPluginBinding.getBinaryMessenger(), "c72_trigger_plugin/event")
        .setStreamHandler(new EventChannel.StreamHandler() {
          @Override
          public void onListen(Object arguments, EventSink events) {
            eventSink = events;
          }

          @Override
          public void onCancel(Object arguments) {
            eventSink = null;
          }
        });
  }

  @Override
  public void onAttachedToActivity(ActivityPluginBinding binding) {
    this.activity = binding.getActivity();
    binding.addOnKeyListener(new PluginRegistry.OnKeyListener() {
      @Override
      public boolean onKey(int keyCode, KeyEvent event) {
        if (eventSink != null && event.getAction() == KeyEvent.ACTION_DOWN) {
          // Si la tecla es una de las que quieres escuchar
          if (keyCode == 139 || keyCode == 280 || keyCode == 293) {
            eventSink.success(keyCode); // Enviamos el keyCode a Flutter
            return true; // Indicamos que hemos manejado el evento
          }
        }
        return false; // No manejamos la tecla
      }
    });
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {
    activity = null;
  }

  @Override
  public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
    onAttachedToActivity(binding);
  }

  @Override
  public void onDetachedFromActivity() {
    activity = null;
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    eventSink = null;
  }

  @Override
  public boolean onViewDestroy() {
    return false;
  }
}