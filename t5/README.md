# Random Picker

Programa para randomização de listas, apresentando duas interfaces: Uma por linha de comando, e a outra utilizando de JavaFX.

## Build

Dentro da pasta src, execute:
```
javac -d ../classes/ *.java
```

Para rodar o aplicativo que utiliza do terminal:
```
java -cp ../classes; RandomPickerCmd someFile.txt
```

Para rodar o aplicativo que utiliza de JavaFX:
```
java -cp ../classes; RandomPickerGUI
```