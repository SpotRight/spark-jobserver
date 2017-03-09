# Preparing Spark-JobServer for SpotRight

** This build process and branch is to build the tar.gz deployment
of jobserver. NOTE the spark install included on the jobserver server
needs to have spark/jars/guava-14.0.1 REPLACED with guava-16.0.1 

1. cd to top of project

1. create a link of job-server/config to config

    ln -s job-server/config config

2. copy README.spotright/ip\* to config

    cp README.spotright/ip* config

3. run bin/server_package.sh with the desired config

    bash bin/server_package.sh ip

4. in /tmp/spark-jobserver find a job-server.tar.gz that can deploy the jobserver
