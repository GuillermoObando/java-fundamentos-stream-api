# Ejercicio de Implementación de la API Stream de Java

## Descripción General
Este ejercicio ayuda a los estudiantes de fundamentos de Java a entender los conceptos de programación funcional reimplementando la funcionalidad principal de la API Stream. Los estudiantes trabajarán con expresiones lambda, referencias a métodos e interfaces funcionales siguiendo principios de desarrollo guiado por tests.

## Objetivos de Aprendizaje
- Comprender los conceptos de programación funcional en Java
- Aprender cómo funcionan las expresiones lambda y las referencias a métodos
- Entender el concepto de operaciones intermedias vs terminales
- Practicar con interfaces funcionales (Predicate, Function, Consumer, Supplier)
- Experimentar con la metodología de desarrollo guiado por tests

## Estructura del Proyecto
```
java-fundamentos/
├── dev.arol.javafundamentos.stream.CustomStream.java          # Interfaz que define la API Stream
├── CustomStreamImpl.java      # Clase de implementación (contiene TODOs)
├── dev.arol.javafundamentos.stream.CustomStreamTest.java      # Tests unitarios que guían la implementación
└── README.md                 # Este archivo
```

## Empezando

### Requisitos Previos
- Java 11 o superior
- JUnit 5 (para ejecutar los tests)
- IDE con soporte para Java (IntelliJ IDEA, Eclipse, VS Code)

### Configuración
1. Importa el proyecto en tu IDE
2. Asegúrate de que JUnit 5 esté en tu classpath
3. Ejecuta los tests para ver los fallos actuales

## Instrucciones del Ejercicio

### Fase 1: Entendiendo la Estructura
1. **Examina la Interfaz**: Estudia `dev.arol.javafundamentos.stream.CustomStream.java` para entender los métodos que necesitas implementar
2. **Revisa los Tests**: Mira `dev.arol.javafundamentos.stream.CustomStreamTest.java` para entender el comportamiento esperado
3. **Analiza el Esqueleto**: Comprueba `CustomStreamImpl.java` para ver la estructura

### Fase 2: Guía de Implementación
**¡Sigue los tests en orden!** Cada test está numerado y se construye sobre la funcionalidad anterior:

#### Test 1-3: Operaciones Básicas
- `test01_toList()` - Implementa el método `toList()` primero (base para probar otros métodos)
- `test02_count()` - Implementa el método `count()`
- `test03_forEach()` - Implementa el método `forEach()`

#### Test 4-5: Transformaciones Principales
- `test04_filter()` - Implementa el método `filter()` usando Predicate
- `test05_map()` - Implementa el método `map()` usando Function

#### Test 6-7: Control de Stream
- `test06_limit()` - Implementa el método `limit()`
- `test07_skip()` - Implementa el método `skip()`

#### Test 8-10: Operaciones Avanzadas
- `test08_distinct()` - Implementa el método `distinct()`
- `test09_sorted()` - Implementa el método `sorted()`
- `test10_peek()` - Implementa el método `peek()`

#### Test 11-15: Operaciones Terminales
- `test11_findFirst()` - Implementa el método `findFirst()`
- `test12_findAny()` - Implementa el método `findAny()`
- `test13_anyMatch()` - Implementa el método `anyMatch()`
- `test14_allMatch()` - Implementa el método `allMatch()`
- `test15_noneMatch()` - Implementa el método `noneMatch()`

#### Test 16-17: Operaciones de Reducción
- `test16_reduce()` - Implementa `reduce()` sin identidad
- `test17_reduce()` - Implementa `reduce()` con identidad

#### Test 18: Transformación Avanzada
- `test18_flatMap()` - Implementa el método `flatMap()`

#### Test 19-20: Integración
- `test19_chaining()` - Prueba el encadenamiento de métodos
- `test20_complexChaining()` - Prueba combinaciones complejas de operaciones

### Fase 3: Consejos de Implementación

#### Conceptos Clave a Recordar:
1. **Inmutabilidad**: Las operaciones de stream deben devolver nuevos streams, no modificar los existentes
2. **Evaluación Perezosa**: En streams reales, las operaciones intermedias son perezosas (aunque esta versión simplificada es ansiosa)
3. **Cortocircuito**: Operaciones como `anyMatch()` deben parar tan pronto como se determine el resultado
4. **Interfaces Funcionales**: Usa las interfaces funcionales proporcionadas correctamente
   - `Predicate<T>` - toma T, devuelve boolean
   - `Function<T, R>` - toma T, devuelve R
   - `Consumer<T>` - toma T, devuelve void

#### Errores Comunes:
- No modifiques la lista original - siempre crea nuevas instancias
- Maneja casos extremos (streams vacíos, valores null)
- Presta atención a la preservación del orden en operaciones como `distinct()`
- Recuerda que `reduce()` con identidad siempre devuelve un valor, sin identidad devuelve Optional

### Fase 4: Probando tu Implementación

#### Ejecutando Tests Individuales:
```bash
# Ejecutar un método de test específico
java -cp .:junit-platform-console-standalone.jar org.junit.platform.console.ConsoleLauncher --select-method=dev.arol.javafundamentos.stream.CustomStreamTest#test01_toList_shouldReturnAllElements

# Ejecutar todos los tests
java -cp .:junit-platform-console-standalone.jar org.junit.platform.console.ConsoleLauncher --select-class=dev.arol.javafundamentos.stream.CustomStreamTest
```

#### Integración con IDE:
- La mayoría de IDEs permiten ejecutar métodos de test individuales
- Usa esto para centrarte en implementar un método a la vez
- Los tests verdes indican implementación exitosa

## Patrón de Implementación de Ejemplo

Así es como podrías abordar el método `filter()`:

```java
import dev.arol.javafundamentos.stream.CustomStream;

@Override
public CustomStream<T> filter(Predicate<T> predicate) {
   List<T> filtered = new ArrayList<>();
   for (T element : elements) {
      if (predicate.test(element)) {
         filtered.add(element);
      }
   }
   return new CustomStreamImpl<>(filtered);
}
```

## Desafíos Avanzados (Opcional)

Una vez que completes la implementación básica:

1. **Añadir Más Operaciones**: Implementa métodos Stream adicionales como `dropWhile()`, `takeWhile()`
2. **Optimización de Rendimiento**: Considera la evaluación perezosa para operaciones intermedias
3. **Procesamiento Paralelo**: Añade soporte para operaciones de stream paralelas
4. **Collectors Personalizados**: Implementa un patrón collector para operaciones terminales más complejas

## Conceptos Clave de Programación Funcional Aprendidos

### Expresiones Lambda
- Sintaxis: `(parámetro) -> expresión`
- Ejemplo: `n -> n * 2`, `(a, b) -> a + b`

### Referencias a Métodos
- Método estático: `Integer::parseInt`
- Método de instancia: `String::toUpperCase`
- Constructor: `ArrayList::new`

### Interfaces Funcionales
- `Predicate<T>`: `boolean test(T t)`
- `Function<T, R>`: `R apply(T t)`
- `Consumer<T>`: `void accept(T t)`
- `Supplier<T>`: `T get()`

### Operaciones de Stream
- **Intermedias**: Devuelven streams, se pueden encadenar
- **Terminales**: Devuelven resultados finales, terminan el stream

## Resolución de Problemas

### Problemas Comunes:
1. **UnsupportedOperationException**: Aún no has implementado el método
2. **ClassCastException en sorted()**: Asegúrate de que tus objetos implementen Comparable
3. **NullPointerException**: Maneja valores null en tus predicados y funciones
4. **Fallos de test**: Comprueba que estás preservando el orden y manejando casos extremos

### Consejos de Depuración:
- Usa `peek()` para depurar operaciones intermedias
- Imprime resultados intermedios para entender el flujo de datos
- Prueba con casos simples primero, luego casos complejos

## Preguntas de Reflexión

Después de completar el ejercicio, considera:
1. ¿Cómo hacen las expresiones lambda el código más legible?
2. ¿Cuáles son los beneficios de las operaciones inmutables?
3. ¿En qué se diferencia el enfoque funcional de la programación imperativa?
4. ¿Cuándo usarías `map()` vs `flatMap()`?
5. ¿Por qué algunas operaciones son "terminales" y otras "intermedias"?

## Próximos Pasos
- Explora la documentación real de la API Stream de Java
- Aprende sobre collectors y operaciones de stream más avanzadas
- Estudia streams paralelos y sus implicaciones de rendimiento
- Practica patrones de programación funcional en otros contextos