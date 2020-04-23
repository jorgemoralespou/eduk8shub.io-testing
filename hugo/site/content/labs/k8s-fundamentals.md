---
layout: lab
title: "Kubernetes fundamentals"
img: kubernetes.png
categories: [kubernetes, foundations]
tags: ["basic"]
date: 2020-01-01
description: An interactive workshop on Kubernetes fundamentals
githuburl: https://github.com/eduk8s-labs/lab-k8s-fundamentals
duration: "1 hour"
author: "Graham Dumpleton"

install: "kubectl apply -k github.com/eduk8s-labs/lab-k8s-fundamentals"
install_notes: "Note that this workshop requires that your Kubernetes cluster have persistent volumes of type ReadWriteOnce (RWO) and ReadWriteMany (RWX) available. Your cluster must also be configured to handle the Ingress resource type. If either of these conditions are not met, you will not be able to perform all steps of the workshop."
delete: "kubectl delete -k github.com/eduk8s-labs/lab-k8s-fundamentals"
example: |
    apiVersion: training.eduk8s.io/v1alpha1
    kind: Workshop
    metadata:
      name: lab-k8s-fundamentals
    spec:
      vendor: eduk8s.io
      title: Kubernetes Fundamentals
      description: Workshop on getting started with Kubernetes
      url: https://github.com/eduk8s-labs/lab-k8s-fundamentals
      image: quay.io/eduk8s-labs/lab-k8s-fundamentals:master
      duration: 1h
      session:
        budget: medium
---
CONTENT:
If you want to review the workshop content, you can browse the files and subdirectories under [workshop/content](https://github.com/eduk8s-labs/lab-k8s-fundamentals/tree/master/workshop/content).

## Install the workshop
To deploy the workshop, [install the eduk8s operator](http://localhost:1313/pages/install/), then run:

```bash 
kubectl apply -k github.com/eduk8s-labs/lab-k8s-fundamentals
```

{{< note >}}
Note that this workshop requires that your Kubernetes cluster have persistent volumes of type ReadWriteOnce (RWO) and ReadWriteMany (RWX) available. Your cluster must also be configured to handle the Ingress resource type. If either of these conditions are not met, you will not be able to perform all steps of the workshop.
{{< /note >}}

## Delete the workshop
To delete the workshop when finished, run:

```bash
kubectl delete -k github.com/eduk8s-labs/lab-k8s-fundamentals
```

## Example workshop
If you want to manually create an instance of the workshop, just create an instance of this CRD with the following content:

```yaml
apiVersion: training.eduk8s.io/v1alpha1
kind: Workshop
metadata:
  name: lab-k8s-fundamentals
spec:
  vendor: eduk8s.io
  title: Kubernetes Fundamentals
  description: Workshop on getting started with Kubernetes
  url: https://github.com/eduk8s-labs/lab-k8s-fundamentals
  image: quay.io/eduk8s-labs/lab-k8s-fundamentals:master
  duration: 1h
  session:
    budget: medium
```