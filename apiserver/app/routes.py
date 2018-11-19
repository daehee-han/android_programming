
import io
import os
import datetime
import sqlite3

from flask import Flask, flash, redirect, render_template, \
     request, url_for, jsonify
from app import app

# https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=en

### URL Handling
HTML = '''
  <!doctype html>
  <title>API Server</title>
  <h1>API Server</h1>
  <p>  </p>
'''

@app.route('/')
@app.route('/index')
def index():
    return "Hello, This API Server"

@app.route('/api/students')
def students():
    conn = sqlite3.connect('data.db')
    c = conn.cursor()
    rows = c.execute("SELECT * FROM students") # Cursor object
    data = [r for r in rows]
    print(data)
    
    return jsonify(data)

@app.route('/api/students/<name>')
def students_name(name):
    conn = sqlite3.connect('data.db')
    c = conn.cursor()
    rows = c.execute("SELECT * FROM students WHERE name = '%s' " % name)  # Cursor object
    data = [r for r in rows]
    print(data)

    return jsonify(data)

@app.route('/api/students', methods=['POST'])
def students_post():
    # HTTP body 에 학생정보가 담겨 있음 - request.form
    print(request.form)
    for k, v in request.form.items():
        print(k, v)
    # SQL 예시 - "INSERT INTO students VALUES ('han','han@gmail.com','010-1234-0004', 40)"
    # SQL 도움말 - https://www.tutorialspoint.com/sql/sql-insert-query.htm
    d = request.form
    sql = "INSERT INTO students VALUES ('%s','%s','%s', %s)" % \
           (d['name'], d['email'], d['phone'], d['age'])
    try:
        conn = sqlite3.connect('data.db')
        c = conn.cursor()
        res = c.execute(sql)
        conn.commit()
        print(res)
        res = True
    except:
        res = False
        pass
    return jsonify(res)


@app.route('/api/students', methods=['PUT'])
def students_put():
    d = request.form
    # SQL 도움말 - https://www.tutorialspoint.com/sql/sql-update-query.htm
    sql = "UPDATE students SET (phone = '%s', age = '%s') WHERE name = '%s' " % \
           (d['phone'], d['age'], d['name'])
    try:
        conn = sqlite3.connect('data.db')
        c = conn.cursor()
        res = c.execute(sql)
        conn.commit()
        print(res)
        res = True
    except:
        res = False
        pass
    return jsonify(res)


@app.route('/api/students/name/<name>', methods=['DELETE'])
def students_delete():
    d = request.form
    sql = "DELETE FROM students WHERE name = '%s' " % (d['name'])
    try:
        conn = sqlite3.connect('data.db')
        c = conn.cursor()
        res = c.execute(sql)
        conn.commit()
        print(res)
        res = True
    except:
        res = False
        pass
    return jsonify(res)


@app.route('/api/stocks')
def stocks():
    conn = sqlite3.connect('data.db')
    c = conn.cursor()
    rows = c.execute("SELECT * FROM stocks")
    data = [r for r in rows]
    print(data)
    
    return jsonify(data)


@app.route('/api/stocks/<symbol>')
def stocks_symbol(symbol):
    conn = sqlite3.connect('data.db')
    c = conn.cursor()
    rows = c.execute("SELECT * FROM stocks WHERE symbol = '%s' " % symbol)
    data = [r for r in rows]
    print(data)

    return jsonify(data)



