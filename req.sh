#!/bin/bash

if [ "$1" == "-h" ] || [ "$1" == "--help" ]; then
    echo "Usage: $0 [endpoint] [data]"
    echo "Send a POST request with data to the specified endpoint."
    echo "If no data is provided, sends a GET request."
    echo "If no endpoint is provided, defaults to localhost."
    exit 0
fi

if [ -z "$1" ]; then
    url="http://localhost:8080/todo/"
else
    url="http://localhost:8080/todo/$1"
fi

if [ -z "$2" ]; then
    curl "$url"
else
    curl -d "$2" "$url"
fi
