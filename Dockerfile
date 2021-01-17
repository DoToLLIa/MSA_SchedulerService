FROM dotollia/msa_basedockerimage:0.3
ARG PROJECT_VERSION=0.3
RUN mkdir /SchedulerService
COPY . /MSA_SchedulerService
RUN cd /MSA_SchedulerService && \
    mvn clean package &&  \
    mv /MSA_SchedulerService/target/SchedulerService-${PROJECT_VERSION}.jar /SchedulerService.jar && \
    rm -r /MSA_SchedulerService
EXPOSE 8080
CMD ["java", "-jar", "/SchedulerService.jar"]