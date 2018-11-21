#
# DB Query SQL 도움말
# - https://www.tutorialspoint.com/sql/sql-insert-query.htm
# - https://www.tutorialspoint.com/sql/sql-update-query.htm
import sqlite3

conn = sqlite3.connect('data.db')
c = conn.cursor()

## 테이블 STUDENTS
try:
  table = 'students' # 테이블 이름
  c.execute('''DROP TABLE %s ''' % table)
  c.execute('''CREATE TABLE %s
               (name text, email text, phone text, age int)''' % table)
  print('Created %s' % table)
  conn.commit()
  
  c.execute("INSERT INTO %s VALUES ('kim','kim@gmail.com','010-1234-0001', 10)"  % table)
  c.execute("INSERT INTO %s VALUES ('park','park@gmail.com','010-1234-0002', 20)"  % table)
  c.execute("INSERT INTO %s VALUES ('lee','lee@gmail.com','010-1234-0003', 30)"  % table)
  c.execute("INSERT INTO %s VALUES ('han','han@gmail.com','010-1234-0004', 40)"  % table)
  print('Data Inserted into %s' % table)
  conn.commit()
  
except:
  raise
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
