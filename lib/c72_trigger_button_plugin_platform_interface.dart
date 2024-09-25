import 'package:plugin_platform_interface/plugin_platform_interface.dart';

import 'c72_trigger_button_plugin_method_channel.dart';

abstract class C72TriggerButtonPluginPlatform extends PlatformInterface {
  /// Constructs a C72TriggerButtonPluginPlatform.
  C72TriggerButtonPluginPlatform() : super(token: _token);

  static final Object _token = Object();

  static C72TriggerButtonPluginPlatform _instance = MethodChannelC72TriggerButtonPlugin();

  /// The default instance of [C72TriggerButtonPluginPlatform] to use.
  ///
  /// Defaults to [MethodChannelC72TriggerButtonPlugin].
  static C72TriggerButtonPluginPlatform get instance => _instance;

  /// Platform-specific implementations should set this with their own
  /// platform-specific class that extends [C72TriggerButtonPluginPlatform] when
  /// they register themselves.
  static set instance(C72TriggerButtonPluginPlatform instance) {
    PlatformInterface.verifyToken(instance, _token);
    _instance = instance;
  }

  Future<String?> getPlatformVersion() {
    throw UnimplementedError('platformVersion() has not been implemented.');
  }
}
