FROM openjdk:8-jdk

LABEL maintainer="anstnsp@naver.com"

## check dns resource
RUN apt-get update && apt-get install dpkg-reconfigure -y

## Set the timezone to KST
ENV TZ=Asia/Seoul
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# Non-root user `app`
RUN useradd --create-home -s /bin/bash app
WORKDIR /home/app

# Set up environment variables
ENV JAVA_OPTS -Dfile.encoding=UTF-8 -Djava.awt.headless=true

ARG SERVICE_NAME
ENV SERVICE_NAME "${SERVICE_NAME}"
RUN echo "SERVICE_NAME ${SERVICE_NAME}"
ADD ./${SERVICE_NAME}/build/libs/*.jar ${SERVICE_NAME}.jar
RUN echo $(ls .)
RUN sh -c "touch ${SERVICE_NAME}.jar"

COPY docker-entrypoint.sh /usr/local/bin
RUN ln -s /usr/local/bin/docker-entrypoint.sh ./entrypoint.sh

RUN chown -R app:app /home/app

# Change to user `app`
USER app

ENTRYPOINT ["/usr/local/bin/docker-entrypoint.sh"]

CMD ["/bin/sh", "-c", "java ${JAVA_OPTS} -jar ${SERVICE_NAME}.jar"]
