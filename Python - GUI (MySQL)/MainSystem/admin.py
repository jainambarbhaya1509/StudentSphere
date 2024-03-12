import tkinter as tk
from tkinter import *
from tkinter import ttk
import mysql.connector
import pyttsx3
from PIL import Image, ImageTk
import main as m
from main import window

engine = pyttsx3.init()

def verifyAdmin(username, password):
    '''
    In this function i have established a connection to my database "python_mini_project" and table "admin_data"
    this function verifies weather the admin data is registered in database or not
    if data is there then success message is displayed else failure
    '''

    try:
        con = mysql.connector.connect(
        host="localhost",
        user="root",
        password="",
        database="python_mini_project"
    )
        print("Database Status: Connection Established Successfully")

        cursor = con.cursor()
        sql = "select * from admin_data where username=%s and password=%s"
        val = (username, password)
        cursor.execute(sql,val)
        result = cursor.fetchone()
        if result:
            print("Login Status: Login Success")
            return True
        else:
            print("Login Status: Login Failure")
            return False
        
    except:
        print("Database Status: There was an error connecting to the database")

    finally:
        if con:
            con.close()
            print("Database Status: Connecton Revoked Successfully")
            print()

def adminWindow():
    '''
    In this function i have created a login window for admin
    which have input fields such as username and password as well as submit button to submit the form
    '''

    # creating a window
    admin = tk.Tk()
    admin.title("SBMP Student Profile RMS: Admin Panel")
    icon = PhotoImage(file = "Python Mini Project\\Images\\Project-Icon.png")
    admin.iconphoto(False, icon)

    # setting window on the center of the screen
    window_width = 1000
    window_height = 500

    screen_width = admin.winfo_screenwidth()
    screen_height = admin.winfo_screenheight()

    x = (screen_width/2) - (window_width/2)
    y = (screen_height/2) - (window_height/2)

    admin.geometry('%dx%d+%d+%d' % (window_width, window_height, x, y))
    admin.resizable(width=False, height=False)

    admin.configure(bg='white')
    
    # setting canvas frame - start
    canvas = Canvas(admin, width=window_width, height=40, bg="blue")
    canvas.create_text(470, 20, text="Admin Login", fill="white", font=("Helvetica", 12, "bold"))
    canvas.pack()
    # setting canvas frame - end

    canvas = Canvas(width=600, height=145)
    canvas.configure(bg="white")
    canvas.place(x=350,y=150)
    image = PhotoImage(file="Python Mini Project\\Images\\sbmp.png")
    cropped_image = image.subsample(2, 2)
    canvas.create_image(0, 0, anchor=NW, image=cropped_image)

    # setting login fields --> Username & Password

    username_label = tk.Label(admin, text="Username: ", bg="white",font=("Helvatica", 10, "bold"))
    username_text = tk.Entry(admin, width=20, font=("Helvetica", 11), relief="groove", bd=2)
    username_text.place(x=100,y=150)
    username_label.place(x=20,y=150)

    password_label = tk.Label(admin, text="Password: ", bg="white",font=("Helvatica", 10, "bold"))
    password_text = tk.Entry(admin, show="*", width=20, font=("Helvetica", 11), relief="groove", bd=2)
    password_text.place(x=100,y=220)
    password_label.place(x=20,y=220)
    

    def login():
        '''
        this function displays the label on screen to notify the user weather it is a success or a failure
        the result is retrned to "verifyAdmin()" and it checks wether the admin data exists or not
        ''' 
        result = verifyAdmin(username_text.get(), password_text.get())
        if result:
            status_label = tk.Label(admin, text="You have been successfully logged in!", bg="green", fg="white")
            status_label.place(x=50,y=90)
            admin.update()
            engine.say("Login Successful")
            engine.runAndWait()
            admin.after(500, admin.destroy)
            m.window()

        else:
            status_label = tk.Label(admin, text="There was an error logging you in!", bg="red", fg="white")
            status_label.place(x=60,y=90)
            admin.update()
            engine.say("Login failed please enter correct id or password")
            engine.runAndWait()

    # adding a submit button 
    submit_button = tk.Button(admin, text="Submit", command=login, width=30, bg="blue", fg="white") # the command attribute will run the "login()" function
    submit_button.place(x=40,y=285)

    admin.mainloop()

# Calling the function 
adminWindow()