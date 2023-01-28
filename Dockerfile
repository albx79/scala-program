FROM sbtscala/scala-sbt:graalvm-ce-22.3.0-b2-java17_1.8.2_3.2.1 AS builder

COPY . .
RUN sbt test assembly

FROM openjdk:17-jdk-slim AS runtime

COPY --from=builder /root/target/scala-3.2.1/exercise.jar exercise.jar

ENTRYPOINT java -jar exercise.jar
