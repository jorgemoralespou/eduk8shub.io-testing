---
layout: lab
title: Buildpacks
img: buildpacks.png
categories: [kubernetes, tools, builds]
tags: ["intermediate"]
date: 2020-03-01
description: Lab on Cloud Native Buildpacks.
githuburl: https://github.com/eduk8s-tests/lab-kpack-testing
duration: "30 minutes"
author: "Graham Dumpleton"
test: true

install: "kubectl apply -k github.com/eduk8s-tests/lab-kpack-testing"
install_notes: | 
  You need to have kpack installed on the cluster for this workshop. You can install it by doing
  kubectl apply -f https://github.com/pivotal/kpack/releases/download/v0.0.8/release-0.0.8.yaml

delete: "kubectl delete -k github.com/eduk8s-tests/lab-kpack-testing"
example: ""
---