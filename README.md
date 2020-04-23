# eduk8s hub (hub.eduk8s.io)
Site for eduk8s hub.

## Deploy

### Use kapp for deploying your app

**TODO**
We find [kapp](https://get-kapp.io/) to be a better tool than kubectl for deployment of your application in Kubernetes. If you have *kapp* installed, you can easily try this application:

```bash
kapp deploy -a hub -f ./k8s/deploy.yaml -y
```

### Use ytt for deploying your app
[ytt](https://get-ytt.io/) is a fantastic templating engine for Kubernetes that gives us a lot of flexibility. If you have *ytt* installed, you can easily customize your deployment:

```bash
ytt -f k8s | kapp deploy -y --diff-changes -a eduk8shub -f-
```

#### Customize any value
If you want to customize any of the possible values you can, either provide a values.yml file or provide specific values via command line:

```bash
ytt -f k8s --data-value-yaml namespace.name=eduk8shub | kapp deploy -y --diff-changes -a eduk8shub -f-
```

### Use kbld to build your container image
If you're in the building process, and you want to use the image you're building in the the deployment, [kbld](https://get-kbld.io/) is your tool. If you have *kbld* installed, you can use it very easily:

```bash
ytt -f k8s --data-value-yaml namespace.name=eduk8shub  --data-value-yaml image.build=true | kbld -f - | kapp deploy -y --diff-changes -a eduk8shub -f-
```

If you want to build your container by compiling locally your java application (faster), use:

```bash
mvn package
ytt -f k8s --data-value-yaml namespace.name=eduk8shub  --data-value-yaml image.build=true --data-value-yaml dockerfile=docker/Dockerfile.innerloop | kbld -f - | kapp deploy -y --diff-changes -a eduk8shub -f-
```

If you don't have maven locally, or you want to build your application archive (.jar file) it in a container, use:
```bash
ytt -f k8s --data-value-yaml namespace.name=eduk8shub  --data-value-yaml image.build=true --data-value-yaml dockerfile=docker/Dockerfile.outerloop | kbld -f - | kapp deploy -y --diff-changes -a eduk8shub -f-
```

### Delete your application
If you want to delete your application, it can be done in an easy command, anywhere:

```bash
kapp delete -a eduk8shub
```

## Build your container
There's 4 ways to build your container image:

* Build your application locally using maven and the SpringBoot Cloud Native Buildpacks (CNB).
* Build your application locally and then create the container image with a Docker multi-stage build. This will mostly be used for local development as it benefits from maven cache
* Build your application and container image with a Docker multi-stage build. This will be slower, but it doesn't depend on having maven installed.
* Build your application and image with a Buildpack

### Option 1: Spring-Boot maven build plugin

```
mvn package spring-boot:build-image
docker tag k8s/eduk8shub:cnb k8s/eduk8shub:latest
```

### Option 2: Inner loop build

```
mvn package
docker build -t "k8s/eduk8shub:innerloop" -f docker/Dockerfile.innerloop .
docker tag k8s/eduk8shub:innerloop k8s/eduk8shub:latest
```

### Option 3: Outer loop build

```
docker build -t "k8s/eduk8shub:outerloop" -f docker/Dockerfile.outerloop .
docker tag k8s/eduk8shub:outerloop k8s/eduk8shub:latest
```


### Option 4: Inner/Outer loop build

```
mvn clean package spring-boot:build-image
docker tag docker.io/library/wildwest:1.0 k8s/eduk8shub:latest
```

## Split configuration
Currently we have 2 profiles:
* development profile: `application-default.yaml`
* production profile: `application.yaml`

In development, we have the hub configuration in `application-default.yaml` although you can split configuration into multiple files and start your Boot application this way:

```
java -jar hub-0.0.1-SNAPSHOT.jar --spring.config.location=classpath:/application.yaml,classpath:/hub.yaml
```

Although in Kubernetes, you only need to place the files in `file:./config/*/` and they will be automatically loaded