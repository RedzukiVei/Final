# Recolector Celestial 🎮
¡Bienvenido al proyecto de **Recolector Celestial**! 🌌

## 📋 Descripción del Proyecto

Recolector Celestial es un juego dinámico donde los usuarios deben recolectar objetos mientras esquivan obstáculos. A medida que avanza el juego, la dificultad incrementa, y se guardan las puntuaciones más altas en una base de datos para fomentar la competencia.

### Características:
- **Pantalla de inicio**: Acceso al juego o a las puntuaciones guardadas.
- **Juego interactivo**: Recolecta objetos y evita fallos mientras acumulas puntos.
- **Pantalla de puntuaciones**: Visualiza las puntuaciones más altas.
- **Opciones de pausa**: Pausa el juego y regresa al menú principal si lo deseas.
- **Pantalla de game over**: Reintenta o vuelve al menú principal después de perder.

## 📂 Estructura del Proyecto

El proyecto está dividido en las siguientes carpetas:

### **1. Fragmentos**
- `StartFragment`: Pantalla inicial para iniciar el juego o visualizar puntuaciones.
- `GameFragment`: Lógica y vista principal del juego.
- `PauseFragment`: Menú de pausa con opciones para reanudar o salir.
- `GameOverFragment`: Muestra la puntuación final y opciones para reiniciar.
- `ScoresFragment`: Lista de puntuaciones guardadas.

### **2. Archivos de Layout (XML)**
- Diseños para cada fragmento, incluyendo botones y vistas necesarias.

### **3. ViewModels**
- `GameViewModel`: Maneja la lógica del juego, como la puntuación y los fallos.
- `ScoresViewModel`: Administra las puntuaciones almacenadas en la base de datos.

### **4. Adaptadores**
- `ScoreAdapter`: Adaptador para mostrar las puntuaciones en un RecyclerView.

### **5. Base de Datos**
- `Room Database`: Implementación de Room para manejar las puntuaciones.


## 🛠️ Tecnologías Utilizadas

- **Kotlin**: Lenguaje principal para el desarrollo.
- **Android Studio**: IDE para el desarrollo del proyecto.
- **Room**: Base de datos local para almacenamiento de puntuaciones.
- **ViewModel y LiveData**: Arquitectura MVVM para gestionar datos y UI.
- **RecyclerView**: Para la lista de puntuaciones.

## 🚀 Instalación y Uso

### Requisitos previos:
- Tener instalado **Android Studio**.
- Un dispositivo físico o emulador con **Android 7.0 (API 24)** o superior.

### Pasos para instalar:
1. Clona este repositorio:
   ```bash
   git clone https://github.com/RedzukiVei/Final.git

Estado actual del producto: En proceso (debido al que el autor le dio un bajon emocional con muchos eventos x que le dificultaron el proceso de programación y que incluye cosas que le llaman la atención que le dificultan luego)
