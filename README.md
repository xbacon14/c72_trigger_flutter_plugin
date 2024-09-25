# Chainway C72 Trigger Plugin

Este plugin de Flutter está diseñado específicamente para el **dispositivo Chainway C72** y **solo funciona en este dispositivo**. Su única funcionalidad es escuchar cuando se presiona el gatillo del dispositivo.

## Funcionalidad

- **Dispositivo soportado**: Este plugin **solo funciona en el Chainway C72**.
- **Función principal**: Detecta el evento de presionar el gatillo del dispositivo.

### Uso

Para usar este plugin en tu aplicación Flutter, solo necesitas suscribirte al stream que escucha el evento de presionar el gatillo:

```dart
import 'package:my_keyboard_plugin/my_keyboard_plugin.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  String _triggerStatus = "No se ha presionado el gatillo";

  @override
  void initState() {
    super.initState();
    // Escuchar el evento de presionar el gatillo
    MyKeyboardPlugin.keyPressedStream.listen((int keyCode) {
      if (keyCode == 139 || keyCode == 280 || keyCode == 293) {
        setState(() {
          _triggerStatus = '¡Gatillo presionado!';
        });
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Chainway C72 Trigger Listener'),
        ),
        body: Center(
          child: Text(_triggerStatus),
        ),
      ),
    );
  }
}