#request for method and render_template for passing arguments...
from flask import Flask , request , render_template

app = Flask(__name__)



@app.route("/shopping")                 #Passing objects like list,tuples etc...
def shopping():
    food = ["Cheese","Tuna","Chicken","Pizza"]
    return render_template("shopping.html",food=food)

'''
#Take two URL and map into single function return value...
@app.route("/")                 #with multiple URL...
@app.route("/<user>")
def index(user=None):
    return render_template("user.html" , user=user)


@app.route("/profile/<name>")               #HTML templates...created in template directory...
def profile(name):
    return render_template("profile.html",name=name)   #using profile.html file...


@app.route("/")                                      #For home page...
def index():
    return "Method used : %s" % request.method             #by default the method is GET...


@app.route("/bacon" , methods=['GET','POST'])
def bacon():
    if request.method == 'POST':
        return "You are using POST"
    else:
        return "You are using GET"          #This will display due to default...


@app.route('/')                           #For home page...
def index():
    return "Hello Siddesh!"

@app.route('/tuna')
def tuna():
    return '<h2>Tuna is good</h2>'

@app.route("/profile/<username>")     #passing variable...
def profile(username):                #function name should be same...
    return 'Hey there %s' % username


@app.route("/post/<int:post_id>")     #passing integer...
def show_post(post_id):               #Here we can change function name...
    return 'Post ID is %s' % post_id
'''


if (__name__ == "__main__"):
    app.run()

