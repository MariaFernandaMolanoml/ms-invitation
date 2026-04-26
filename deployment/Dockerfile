FROM eclipse-temurin:21-jdk-alpine AS builder

WORKDIR /build

# Copiar TODO el proyecto (multi-module)
COPY . .

RUN chmod +x gradlew

# Construir desde raíz (Gradle maneja los módulos)
RUN ./gradlew clean build -x test


FROM eclipse-temurin:21-jdk-alpine

RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /app

# Buscar jar generado (ajusta si tienes módulo específico de boot)
COPY --from=builder /build/**/build/libs/*.jar app.jar

RUN chown appuser:appgroup app.jar

USER appuser

EXPOSE 8080

ENV JAVA_OPTS="-XX:MaxRAMPercentage=70 -Djava.security.egd=file:/dev/./urandom"

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
