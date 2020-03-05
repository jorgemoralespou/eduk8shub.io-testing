FROM quay.io/jorgemoralespou/gohugoio:master as BUILD

COPY . /site
WORKDIR /site

ENTRYPOINT ["hugo"]

FROM centos/httpd-24-centos7 as RUN
COPY --from=BUILD /site/public/ /opt/rh/httpd24/root/var/www/html/


