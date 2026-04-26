# ===== BUILD STAGE =====
FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /build

# Copiar gradle wrapper y archivos de build
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Dar permisos al wrapper
RUN chmod +x gradlew

# Copiar código fuente
COPY src ./src

# Construir el jar
RUN ./gradlew clean build -x test


# ===== RUNTIME STAGE =====
FROM eclipse-temurin:21-jdk-alpine

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app

# Copiar el jar generado por Gradle
COPY --from=builder /build/build/libs/*.jar app.jar

RUN chown appuser:appgroup app.jar

USER appuser

EXPOSE 8080

ENV JAVA_OPTS="-XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
