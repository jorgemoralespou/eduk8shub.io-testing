---
layout: lab
title:  "Tekton - Cloud Native CD"
date:   2020-02-28 12:00:00 +0100
img: "tekton.png"
categories: [lab]
description: Cloud Native Continuous Delivery using Kubernetes primitives
author: "Daniel Helfand"
githuburl: https://github.com/danielhelfand/lab_tekton_fundamentals

install: "kubectl apply -k github.com/danielhelfand/lab_tekton_fundamentals"
install_notes: |
  Tekton must also be installed on your cluster hosting the workshop. You can install it using the following command:
  kubectl apply --filename https://storage.googleapis.com/tekton-releases/pipeline/previous/v0.11.0-rc1/release.yaml
delete: "kubectl delete -k github.com/danielhelfand/lab_tekton_fundamentals"
---
