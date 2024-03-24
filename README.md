# RabbitMQ Microservices Proof of Concept

This repository contains a proof of concept project demonstrating the usage of RabbitMQ messaging system with two microservices.

## Overview

The project consists of the following components:

1. **Microservice A**: A sample microservice that acts as a producer, sending messages to RabbitMQ.
2. **Microservice B**: Another sample microservice that acts as a consumer, receiving messages from RabbitMQ.
3. **RabbitMQ Configuration**: Configuration files and scripts required to set up RabbitMQ for communication between microservices.

## Prerequisites

Before running this project, ensure that the following prerequisites are met:

- Docker is installed on your machine.
- Docker Compose is installed.
- [RabbitMQ](https://www.rabbitmq.com/download.html) is installed and running.

## Setup

1. Clone this repository to your local machine:

    ```bash
    git clone https://github.com/yourusername/rabbitmq-microservices-poc.git
    ```

2. Navigate to the cloned repository:

    ```bash
    cd rabbitmq-microservices-poc
    ```

3. Start RabbitMQ and the microservices using Docker Compose:

    ```bash
    docker-compose up -d
    ```

4. Wait for the services to start up. You can monitor the logs to ensure everything is running smoothly:

    ```bash
    docker-compose logs -f
    ```

## Usage

1. Once the services are up and running, Microservice A will automatically start producing messages to RabbitMQ.
2. Microservice B, configured as a consumer, will listen for messages on the RabbitMQ queue and process them accordingly.
3. Monitor the logs of Microservice B to see the messages being consumed:

    ```bash
    docker-compose logs -f microservice_b
    ```

## Cleanup

To stop and remove the services, use the following command:

```bash
docker-compose down
