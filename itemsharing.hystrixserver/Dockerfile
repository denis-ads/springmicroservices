FROM java:8-jre

ADD ./target/monitoring.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/monitoring.jar", "--spring.profiles.active=docker"]

EXPOSE 8989 8080