FROM maven:3.6.3-jdk-8
ARG PROJECT_VERSION=0.1
RUN mkdir /MSA_BankAccountGenerator
COPY . /MSA_BankAccountGenerator
RUN cd /MSA_BankAccountGenerator && \
    mvn clean package &&  \
    mv /MSA_SchedulerService/target/SchedulerService-${PROJECT_VERSION}.jar /SchedulerService.jar && \
    rm -r /MSA_SchedulerService
EXPOSE 8080
CMD ["java", "-jar", "/SchedulerService.jar"]