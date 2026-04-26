FROM eclipse-temurin:21-jdk-alpine

# Crear usuario no root (buena práctica obligatoria en clean architecture enterprise)
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Directorio de trabajo
WORKDIR /app

# Copiar el jar
COPY *.jar app.jar

# Propiedad del archivo para el usuario no root
RUN chown appuser:appgroup /app/app.jar

# Variables JVM optimizadas para contenedores
ENV JAVA_OPTS="\
-XX:MaxRAMPercentage=70 \
-XX:+UseContainerSupport \
-Djava.security.egd=file:/dev/./urandom"

# Cambiar a usuario no root
USER appuser

# Puerto (opcional pero recomendado si es API)
EXPOSE 8080

# Ejecutar aplicación
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
