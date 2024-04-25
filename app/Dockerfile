# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the compiled Java classes and the feature files into the container
COPY ./qa-interview-cyan.jar /app/qa-interview-cyan.jar

# Run the Java application when the container launches
CMD ["java", "-jar", "qa-interview-cyan.jar"]
