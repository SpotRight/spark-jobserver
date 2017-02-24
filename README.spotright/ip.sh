# Environment and deploy file
# For use with bin/server_deploy, bin/server_package etc.
DEPLOY_HOSTS="ip100.va.spotright.com"

APP_USER=nutch
APP_GROUP=hadoop
JMX_PORT=9999
# optional SSH Key to login to deploy server
#SSH_KEY=/path/to/keyfile.pem
INSTALL_DIR=/opt/spark-jobserver
LOG_DIR=/var/log/spark-jobserver
PIDFILE=spark-jobserver.pid
JOBSERVER_MEMORY=1500M
SPARK_VERSION=2.1.0
MAX_DIRECT_MEMORY=512M
SPARK_HOME=/opt/spark
SPARK_CONF_DIR=$SPARK_HOME/conf
# Only needed for Mesos deploys
SPARK_EXECUTOR_URI=/home/spark/spark-1.6.0.tar.gz
# Only needed for YARN running outside of the cluster
# You will need to COPY these files from your cluster to the remote machine
# Normally these are kept on the cluster in /etc/hadoop/conf
# YARN_CONF_DIR=/pathToRemoteConf/conf
# HADOOP_CONF_DIR=/pathToRemoteConf/conf
#
# Also optional: extra JVM args for spark-submit
# export SPARK_SUBMIT_OPTS+="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5433"
SCALA_VERSION=2.11.6
