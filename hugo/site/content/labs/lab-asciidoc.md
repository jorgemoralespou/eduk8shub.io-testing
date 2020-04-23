---
layout: lab
title:  "Asciidoc Lab Template"
tags: [template]
date: "2020-02-01"
description: Use this lab as template when you want to create a workshop using Asciidoc
author: "Graham Dumpleton"
template: true
githuburl: https://github.com/eduk8s/lab-asciidoc-sample

install: "kubectl apply -k https://github.com/eduk8s/lab-asciidoc-sample"
delete: "kubectl delete -k https://github.com/eduk8s/lab-asciidoc-sample"
example: |
    apiVersion: training.eduk8s.io/v1alpha1
    kind: Workshop
    metadata:
      name: lab-asciidoc-sample
    spec:
      vendor: eduk8s.io
      title: Lab template using Asciidoc
      description: Template for creating a Workshop using asciidoc
      url: https://github.com/eduk8s/lab-asciidoc-sample
      image: quay.io/eduk8s/lab-asciidoc-sample:master
      duration: 30m
      session:
        budget: medium
---
