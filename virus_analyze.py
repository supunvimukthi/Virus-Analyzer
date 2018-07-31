import hashlib
from tkinter import Tk
from tkinter.filedialog import askopenfilename
import MySQLdb

db = MySQLdb.connect(host="localhost",    # your host, usually localhost
                     user="root",         # your username
                     passwd="",           # your password
                     db="virusdb")        # name of the data base

cur = db.cursor()



Tk().withdraw() 
filename = askopenfilename()

md5_hash = hashlib.md5()
with open(filename,"rb") as f:
    # Read and update hash in chunks of 4K
    for byte_block in iter(lambda: f.read(4096),b""):
        md5_hash.update(byte_block)
    print(filename)
    print(md5_hash.hexdigest())

cur.execute("select * from virus_db where MD5='"+md5_hash.hexdigest()+"'")
if cur.rowcount>0:
    for row in cur.fetchall():
        print ("Virus Name : "+row[1])
        print ("Virus Type : "+row[3])
else:
    print ("File is Clean")
db.close()

#select a file and check it against the database



