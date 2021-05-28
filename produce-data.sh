docker run --tty \
           --network camel-kafka-jdbc_camel-kafka-jdbc \
           -v /Users/aqua-len/IdeaProjects/camel-kafka-jdbc/data/test-data-in.txt:/test-data-in.txt\
           confluentinc/cp-kafkacat \
           bash -c "
            cat /test-data-in.txt | kafkacat  \
           -b broker:29092 \
            -P -t main \
            -H publisher='Marvel Comics'"
