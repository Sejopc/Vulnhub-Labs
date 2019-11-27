#!/bin/bash

ifconfig eth0 192.168.2.240/24
ip route add 192.168.2.0/24 dev eth0
ip route add 0.0.0.0 via 192.168.2.1 dev eth0
