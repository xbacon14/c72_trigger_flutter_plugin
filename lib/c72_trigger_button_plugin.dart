import 'package:flutter/services.dart';

class C72TriggerButtonPlugin {
  static const EventChannel _eventChannel =
      EventChannel('c72_trigger_plugin/event');

  // Método para escuchar teclas presionadas
  static Stream<int> get keyPressedStream {
    return _eventChannel.receiveBroadcastStream().cast<int>();
  }
}
