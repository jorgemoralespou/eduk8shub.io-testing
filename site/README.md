# eduk8s-hub.io

Site for eduk8s hub.

## Build the site locally
This site is built with [hugo](https://gethugo.io)

```bash
hugo server
```

## Build the site as a Docker image
If you want to build this site as a Dockerimage, you will need to build the Dockerfile and publish it.

```
docker build -t quay.io/jorgemoralespou/eduk8shub:latest .
docker push quay.io/jorgemoralespou/eduk8shub:latest
```

## Deploy the site on your k8s cluster
If you want to deploy this hub on k8s, you can do it with kubectl or kapp.

```
kubectl apply -f k8s
```

or

```
kapp deploy -a eduk8s-hub -n eduk8s -y
```

## Create a new lab entry
We provide templates for creating new labs. Just use hugo's capability of creating articles from an archetype.

```bash
hugo new labs/example.md
```

You'll find the file in labs/example.md. Go there and tweak the frontmatter as needed.

By default, the lab will be created as draft. If you want to see it rendered, start hugo like this:

```bash
hugo server -D
```

Once you're finished, remove the draft annotation in frontmatter and will be published.