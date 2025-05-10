FROM ubuntu:20.04

ENV DEBIAN_FRONTEND=noninteractive \
    TZ=Etc/UTC \
    GRADLE_VERSION=8.3 \
    GRADLE_HOME=/opt/gradle

RUN apt-get update && \
    
    apt-get install -y openjdk-11-jdk wget unzip xvfb gnupg2 curl software-properties-common && \
    \
    #Google Chrome
    wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" \
           > /etc/apt/sources.list.d/google-chrome.list' && \
    apt-get update && \
    apt-get install -y google-chrome-stable && \
    \
    #Chromedriver
    CHROME_DRIVER_VERSION=$(curl -sS https://chromedriver.storage.googleapis.com/LATEST_RELEASE) && \
    wget -q -O /tmp/chromedriver.zip \
         https://chromedriver.storage.googleapis.com/${CHROME_DRIVER_VERSION}/chromedriver_linux64.zip && \
    unzip /tmp/chromedriver.zip -d /usr/local/bin/ && \
    chmod +x /usr/local/bin/chromedriver && \
    \
    #Gradle
    wget -q -P /tmp https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip && \
    unzip -q /tmp/gradle-${GRADLE_VERSION}-bin.zip -d /opt && \
    ln -s /opt/gradle-${GRADLE_VERSION} ${GRADLE_HOME} && \
    rm /tmp/gradle-${GRADLE_VERSION}-bin.zip && \
    \
    
    rm -rf /var/lib/apt/lists/*


ENV PATH=${GRADLE_HOME}/bin:/usr/lib/jvm/java-11-openjdk-amd64/bin:$PATH

WORKDIR /app
COPY . /app


CMD ["bash"]

