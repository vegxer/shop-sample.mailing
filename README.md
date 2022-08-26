# Mailing

## Local run in development mode
1) Set following settings in application.yml file:
   ```
   spring.artemis.host - host of artemis
   spring.artemis.port - port of artemis
   spring.artemis.user
   spring.artemis.password
   spring.mail.username - user gmail
   spring.mail.password - password gmail
   ```
2) Build with Maven using command
    ```
    mvn clean package
    ```
3) Run with Maven using command
    ```
    mvn spring-boot:run
    ```
   
## Run with Docker
1) Build Docker image using command
   ```
   docker build -t vegxer/shop-sample/mailing:${MAILING_VERSION from docker/.env} -f ./docker/Dockerfile .
   ```
2) Go to directory 'docker'
3) Set environment variables in file .env
4) Run service using command
   ```
   docker-compose up -d
   ```

Service will be available only in docker network 'shop-sample-lan' by its host name