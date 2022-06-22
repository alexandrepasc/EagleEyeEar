FROM adoptopenjdk/openjdk11

RUN apt-get update --fix-missing

RUN apt-get install -y apt-utils \
    && apt-get install -y net-tools \
    && apt-get install -y nano

COPY EagleEyeEar*.jar /home/EagleEyeEar.jar

COPY EagleEyeWing*.jar /home/EagleEyeWing.jar

RUN mkdir /home/logs

WORKDIR /home

CMD java -jar -Xmx400M -Dport=$PORT /home/EagleEyeWing.jar