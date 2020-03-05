FROM quay.io/jorgemoralespou/gohugoio:master AS builder
COPY . /site/
WORKDIR /site/
RUN hugo && cp -R /site/public /dest

FROM centos/httpd-24-centos7 AS runtime
COPY --from=builder /dest/ /opt/rh/httpd24/root/var/www/html/


