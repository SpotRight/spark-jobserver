# Preparing Spark-JobServer for SpotRight

** This build process and branch is to build spark-job-server.jar
which gets included in spark's classpath via --jars arg


1. cd to top of project

1. create a link of job-server/config to config

    ln -s job-server/config config

2. copy README.spotright/ip\* to config

    cp README.spotright/ip* config

3. run bin/server_package.sh with the desired config

    bash bin/server_package.sh ip

4. in /tmp/spark-jobserver find spark-job-server.jar that can be rsync'd
   
    up to spark master tmp/jars location
