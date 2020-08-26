import socket
import time

def ConnectToJava():
    s = socket.socket()
    port = 8192
    host = 'localhost'


    s.connect((host, port))
    while True:
        x = 'input()'
        s.send("hello world!".encode('utf-8'))
        #data = s.recv(1024)
        #print('Received', repr(data))
        time.sleep(5)

    s.close()




if __name__ == '__main__':
    ConnectToJava()