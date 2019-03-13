# TestRabbitMQ
### Set up RabbitMq
#### The exchange (With Dead-Lettering)
1. Create an (direct) exchange to route all messages not acknowledged etc.
2. Create the Topic Exchange with Alternate Exchange in the arguments. Point it to the direct exchange in 1
#### The queues (With Dead-Lettering)
3. Create a Dead-Letter-Queue (with no arguments). Bind the direct exchange in 1 (with routing key error etc)
4. Create the topic queues, add 
    - x-dead-letter-exchange and point to the direct exchange in 1
    - x-dead-letter-routing-key and point it to the key in 3
    - Bind the exchange in 2
### Main Modules
1. ConsumerAuto
2. ProducerTopic
