from flask import Flask, url_for, render_template, request, flash, redirect, json
import requests


app = Flask(__name__)
app.secret_key = "123"

@app.route('/')
def index():
    return "welcome to Tanqed !"

@app.route('/register')
def register_init():
    return render_template("register.html")


def ServerRegister(user,psd):
    params = {
        'email': user,
        'password': psd
    }
    url = 'http://54.201.208.226:8086/reg/user/new'
    r = requests.post(url, json = params).text

    return r


@app.route('/register', methods=['POST'])
def register():
    form = request.form
    username = form.get('username')
    password = form.get('password')
    re = ServerRegister(username, password)
    if not username:
        flash("please input email !")
    elif not password:
        flash("please input password !")
    else:
        flash(re)

    return render_template("register.html")



if __name__ == '__main__':
    app.run(host='0.0.0.0')
    app.debug = True
    app.run()
