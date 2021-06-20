docker run --tty \
           --network camel-kafka-jpa_local \
           -v /Users/aqua-len/IdeaProjects/camel-kafka-jpa/data/superheroes.txt:/superheroes.txt\
           confluentinc/cp-kafkacat \
           bash -c "
            cat /superheroes.txt | kafkacat  \
           -b broker:29092 \
            -P -t main \
            -H publisher='superheroes'"
