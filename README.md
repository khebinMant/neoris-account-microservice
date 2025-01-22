# neoris-account-microservice

# Contacto

- Ante cualquier duda de como correr el proyecto estoy a las ordenes
  `mantillgka@gmail.com`


## Descripción

# 💾 🗄️  Correlo localmente

### Configuración

- Clona este reposiotrio utilizando `git clone https://github.com/khebinMant/neoris-customer-microservice`
- Es necesario tener instalado el JDK para Java 17.
- Postman u otra herramienta como Thunder Client o Insonmia para el test de la API

### Pasos
- Abrir el proyecto con el IDE a gusto de preferencia IntelliJ
- Esperar a que se descargue las dependencias y se configure el proyecto
- Ejecutar el comando './gradlew clean build -x test'
- Correr el proyecto que arranca desde CustomerApplication en el paquete neoris-customer-services
- Es importante levantar primero este micro servicio porque es independiente y de este depende el otro micro servicio
- Listo lo tienes levantado localmente en el `http://localhost:8081/accountApi/`
- En consideración no es necesario ejecutar ningún .sql el proyecto al levantarse ejecuta un semillero
  con la información necesario para hacer las pruebas dadas en el `Caso de Uso` del pdf proporcionado

- Es decir:
    - Se tiene Cuentas para `Jose Lema`, `Marianela Montalvo`,  `Juan Osorio` al igual como se muestra en el 
    - pdf `Caso de uso`.

### Pasos
- Para probar los endPoints abrir con POSTMAN la colección agregada en este mismo repositorio
- El nombre la colección es `neoris-test.postman_collection`


# 💾 🗄️  Correlo dockerizado
### Pasos
- Ejecutar los pasos descritos recordar que este micro servicio se expone fuera del contenedor en puerto 8081


## Build

```bash
./gradlew clean build -x test
```

## Run

Run with gradle

```bash
./gradlew neoris-account-services:bootRun
```

Run with jar

```bash
java -jar ./neoris-account-services/build/libs/neoris-account-services-1.0.0-SNAPSHOT.jar
```

## Build docker image

1) Build application

```shell
./gradlew clean build -x test
```

2) Build docker image

```shell
docker build --no-cache -t neoris-account-services:1.0.0-SNAPSHOT -f deploy/docker/Dockerfile .
```

**OPTIONAL** - Test Docker image

```shell
docker run -it --rm --env-file ./deploy/docker/.env --name neoris-account-services -p 8083:8080 neoris-account-services:1.0.0-SNAPSHOT
```