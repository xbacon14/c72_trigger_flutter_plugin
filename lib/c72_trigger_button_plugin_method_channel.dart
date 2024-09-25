import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

import 'c72_trigger_button_plugin_platform_interface.dart';

/// An implementation of [C72TriggerButtonPluginPlatform] that uses method channels.
class MethodChannelC72TriggerButtonPlugin extends C72TriggerButtonPluginPlatform {
  /// The method channel used to interact with the native platform.
  @visibleForTesting
  final methodChannel = const MethodChannel('c72_trigger_button_plugin');

  @override
  Future<String?> getPlatformVersion() async {
    final version = await methodChannel.invokeMethod<String>('getPlatformVersion');
    return version;
  }
}
