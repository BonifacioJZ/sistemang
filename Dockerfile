# Establecer la imagen base como gradle con JDK 17
FROM gradle:8.6.0-jdk17 as build

# Etiqueta para identificar a los autores
LABEL authors="bonifacio"

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el contenido del directorio actual al directorio de trabajo del contenedor
COPY . /app

# Ejecutar el comando 'gradle clean build' para construir el proyecto
RUN gradle  clean build -x test

# Cambiar a una nueva etapa de construcción basada en OpenJDK 17
FROM openjdk:17-bullseye

# Exponer el puerto 8080 para que pueda ser accedido desde fuera del contenedor
EXPOSE 8080

# Copiar el artefacto construido desde la etapa de construcción anterior al directorio de trabajo en esta etapa
COPY --from=build /app/build/libs/sistemang-0.0.1-SNAPSHOT.jar /app/sistemang-0.0.1-SNAPSHOT.jar

# Establecer el punto de entrada para ejecutar la aplicación cuando se inicie el contenedor
ENTRYPOINT ["java", "-jar", "/app/sistemang-0.0.1-SNAPSHOT.jar"]
