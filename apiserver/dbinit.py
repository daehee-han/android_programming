#
# DB Query SQL 도움말
# - https://www.tutorialspoint.com/sql/sql-insert-query.htm
# - https://www.tutorialspoint.com/sql/sql-update-query.htm
import sqlite3

conn = sqlite3.connect('data.db')
c = conn.cursor()

## 테이블 STUDENTS
try:
  c.execute('''CREATE TABLE students
               (name text, email text, phone text, age int)''')
  c.execute("INSERT INTO students VALUES ('kim','kim@gmail.com','010-1234-0001', 10)")
  c.execute("INSERT INTO students VALUES ('park','park@gmail.com','010-1234-0002', 20)")
  c.execute("INSERT INTO students VALUES ('lee','lee@gmail.com','010-1234-0003', 30)")
  c.execute("INSERT INTO students VALUES ('han','han@gmail.com','010-1234-0004', 40)")
  conn.commit()
  print('Created STUDENTS')
except:
  print('Skip STUDENTS')
  pass



## 테이블 STOCKS
try:
  c.execute('''CREATE TABLE stocks
               (date text, trans text, symbol text, qty real, price real)''')
  
  c.execute("INSERT INTO stocks VALUES ('2006-01-05','BUY','RHAT',100,35.14)")
  purchases = [('2006-03-28', 'BUY', 'IBM', 1000, 45.00),
               ('2006-04-05', 'BUY', 'MSFT', 1000, 72.00),
               ('2006-04-06', 'SELL', 'IBM', 500, 53.00),
              ]
  c.executemany('INSERT INTO stocks VALUES (?,?,?,?,?)', purchases)
  conn.commit()
  print('Created STOCKS')
except:
  print('Skip STOCKS')
  pass
