#!/bin/bash
set -eo pipefail

# See https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/g1_gc_tuning.html

LOGICAL_PROCESSORS=8 # default value 8

if [[ -n "$NUM_OF_CPU_LIMIT" && ${NUM_OF_CPU_LIMIT} > 0 ]];then
   LOGICAL_PROCESSORS=${NUM_OF_CPU_LIMIT}
fi

# Collecting JMX Metrics
if [[ -n "${JMX_IS_ENABLED}" && "${JMX_IS_ENABLED}" == "true" ]];then
  JAVA_OPTS="${JAVA_OPTS} -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=9012 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false"
fi

export JAVA_OPTS="${JAVA_OPTS} -XX:ParallelGCThreads=${LOGICAL_PROCESSORS} ${JAVA_EXTRA_OPTS}"


exec "$@"
