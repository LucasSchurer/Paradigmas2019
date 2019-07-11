## Build e Run

Na pasta principal do programa, realize os seguintes passos: 

```
javac -d bin src/*.java src/entity/*.java src/entity/block/nonsolid/*.java src/entity/block/solid/mineral/*.java src/entity/block/solid/nonmineral/*.java src/entity/tool/axe/*.java src/entity/tool/pickaxe/*.java src/entity/tool/shovel/*.java src/entity/tool/hoe/*.java src/entity/tool/combat/sword/*.java
cd src/
java -cp ../bin MinecraftApp
cd ../
```

Caso esteja em Windows, apenas utilize os arquivos .bat ./build e ./run.