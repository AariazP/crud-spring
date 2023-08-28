FROM ubuntu:latest
LABEL authors="alejandroarias"
RUN apt-get update -y && apt-get install neofetch -y