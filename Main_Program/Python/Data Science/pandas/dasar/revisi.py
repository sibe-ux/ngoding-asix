import tkinter as tk
from tkinter import Entry, LabelFrame, Menu, Place, StringVar, Tk, Variable, messagebox
from tkinter import ttk
from tkinter import filedialog
from tkinter.constants import DISABLED, S
from typing import Text, final
import pandas as pd
import numpy as np
import math
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt


frame_styles = {"relief": "groove",
                "bd": 3, "bg": "#BEB2A7",
                "fg": "#073bb3", "font": ("Arial", 9, "bold")}


class LoginPage(tk.Tk):

    def __init__(self, *args, **kwargs):

        tk.Tk.__init__(self, *args, **kwargs)

        main_frame = tk.Frame(self, bg="#708090", height=431, width=626)  # this is the background
        main_frame.pack(fill="both", expand="true")

        self.geometry("626x431")  # Sets window size to 626w x 431h pixels
        self.resizable(0, 0)  # This prevents any resizing of the screen
        title_styles = {"font": ("Trebuchet MS Bold", 16), "background": "blue"}

        text_styles = {"font": ("Verdana", 14),
                    "background": "blue",
                    "foreground": "#E1FFFF"}

        frame_login = tk.Frame(main_frame, bg="blue", relief="groove", bd=2)  # this is the frame that holds all the login details and buttons
        frame_login.place(rely=0.30, relx=0.17, height=130, width=400)

        label_title = tk.Label(frame_login, title_styles, text="Login")
        label_title.grid(row=0, column=1, columnspan=1)

        label_user = tk.Label(frame_login, text_styles, text="Username:")
        label_user.grid(row=1, column=0)

        label_pw = tk.Label(frame_login, text_styles, text="Password:")
        label_pw.grid(row=2, column=0)

        entry_user = ttk.Entry(frame_login, width=45, cursor="xterm")
        entry_user.grid(row=1, column=1)

        entry_pw = ttk.Entry(frame_login, width=45, cursor="xterm", show="*")
        entry_pw.grid(row=2, column=1)

        button = ttk.Button(frame_login, text="Login", command=lambda: getlogin())
        button.place(rely=0.70, relx=0.50)

        signup_btn = ttk.Button(frame_login, text="Register", command=lambda: get_signup())
        signup_btn.place(rely=0.70, relx=0.75)

        def get_signup():
            SignupPage()

        def getlogin():
            username = entry_user.get()
            password = entry_pw.get()
            # if your want to run the script as it is set validation = True
            validation = validate(username, password)
            if validation:
                tk.messagebox.showinfo("Login Successful",
                                    "Welcome {}".format(username))
                root.deiconify()
                top.destroy()
            else:
                tk.messagebox.showerror("Information", "The Username or Password you have entered are incorrect ")

        def validate(username, password):
            # Checks the text file for a username/password combination.
            try:
                with open("credentials.txt", "r") as credentials:
                    for line in credentials:
                        line = line.split(",")
                        if line[1] == username and line[3] == password:
                            return True
                    return False
            except FileNotFoundError:
                print("You need to Register first or amend Line 71 to     if True:")
                return False


class SignupPage(tk.Tk):

    def __init__(self, *args, **kwargs):

        tk.Tk.__init__(self, *args, **kwargs)

        main_frame = tk.Frame(self, bg="#3F6BAA", height=150, width=250)
        # pack_propagate prevents the window resizing to match the widgets
        main_frame.pack_propagate(0)
        main_frame.pack(fill="both", expand="true")

        self.geometry("250x150")
        self.resizable(0, 0)

        self.title("Registration")

        text_styles = {"font": ("Verdana", 10),
                    "background": "#3F6BAA",
                    "foreground": "#E1FFFF"}

        label_user = tk.Label(main_frame, text_styles, text="New Username:")
        label_user.grid(row=1, column=0)

        label_pw = tk.Label(main_frame, text_styles, text="New Password:")
        label_pw.grid(row=2, column=0)

        entry_user = ttk.Entry(main_frame, width=20, cursor="xterm")
        entry_user.grid(row=1, column=1)

        entry_pw = ttk.Entry(main_frame, width=20, cursor="xterm", show="*")
        entry_pw.grid(row=2, column=1)

        button = ttk.Button(main_frame, text="Create Account", command=lambda: signup())
        button.grid(row=4, column=1)

        def signup():
            # Creates a text file with the Username and password
            user = entry_user.get()
            pw = entry_pw.get()
            validation = validate_user(user)
            if not validation:
                tk.messagebox.showerror("Information", "That Username already exists")
            else:
                if len(pw) > 3:
                    credentials = open("credentials.txt", "a")
                    credentials.write(f"Username,{user},Password,{pw},\n")
                    credentials.close()
                    tk.messagebox.showinfo("Information", "Your account details have been stored.")
                    SignupPage.destroy(self)

                else:
                    tk.messagebox.showerror("Information", "Your password needs to be longer than 3 values.")

        def validate_user(username):
            # Checks the text file for a username/password combination.
            try:
                with open("credentials.txt", "r") as credentials:
                    for line in credentials:
                        line = line.split(",")
                        if line[1] == username:
                            return False
                return True
            except FileNotFoundError:
                return True

class MenuBar(tk.Menu):
    def __init__(self, parent):
        tk.Menu.__init__(self, parent)

        menu_file = tk.Menu(self, tearoff=0)
        self.add_cascade(label="Main", menu=menu_file)
        menu_file.add_command(label="Back To Main", command=lambda: parent.show_frame(Some_Widgets))
        menu_file.add_separator()
        menu_file.add_command(label="Exit", command=lambda: parent.Quit_application())

        menu_pencari = tk.Menu(self, tearoff=0)
        self.add_cascade(label="Menu 2", menu= menu_pencari)
        menu_pencari.add_command(label="App", command=lambda: parent.show_frame(PagePertama))

        menu_pricing = tk.Menu(self, tearoff=0)
        self.add_cascade(label="About", menu=menu_pricing)
        menu_pricing.add_command(label="About Me", command=lambda: parent.show_frame(PageOne))

        # menu_operations = tk.Menu(self, tearoff=0)
        # self.add_cascade(label="Menu4", menu=menu_operations)
        # menu_operations.add_command(label="Page Two", command=lambda: parent.show_frame(PageTwo))
        # menu_positions = tk.Menu(menu_operations, tearoff=0)
        # menu_operations.add_cascade(label="Menu5", menu=menu_positions)
        # menu_positions.add_command(label="Page Three", command=lambda: parent.show_frame(PageThree))
        # menu_positions.add_command(label="Page Four", command=lambda: parent.show_frame(PageFour))

        # menu_help = tk.Menu(self, tearoff=0)
        # self.add_cascade(label="Menu6", menu=menu_help)
        # menu_help.add_command(label="Open New Window", command=lambda: parent.OpenNewWindow())


class MyApp(tk.Tk):

    def __init__(self, *args, **kwargs):

        tk.Tk.__init__(self, *args, **kwargs)
        main_frame = tk.Frame(self, bg="#84CEEB", height=600, width=1024)
        main_frame.pack_propagate(0)
        main_frame.pack(fill="both", expand="true")
        main_frame.grid_rowconfigure(0, weight=1)
        main_frame.grid_columnconfigure(0, weight=1)
        self.resizable(0, 0) 
        # prevents the app from being resized
        # self.geometry("1024x600") fixes the applications size
        self.frames = {}
        pages = (Some_Widgets, PageOne,PagePertama, PageTwo, PageThree, PageFour)
        for F in pages:
            frame = F(main_frame, self)
            self.frames[F] = frame
            frame.grid(row=0, column=0, sticky="nsew")
        self.show_frame(Some_Widgets)
        menubar = MenuBar(self)
        tk.Tk.config(self, menu=menubar)

    def show_frame(self, name):
        frame = self.frames[name]
        frame.tkraise()

    def OpenNewWindow(self):
        OpenNewWindow()

    def Quit_application(self):
        self.destroy()


class GUI(tk.Frame):
    def __init__(self, parent):
        tk.Frame.__init__(self, parent)
        self.main_frame = tk.Frame(self, bg="#BEB2A7", height=900, width=1100)
        # self.main_frame.pack_propagate(0)
        self.main_frame.pack(fill="both", expand="true")
        self.main_frame.grid_rowconfigure(0, weight=1)
        self.main_frame.grid_columnconfigure(0, weight=1)


class Some_Widgets(GUI):  # inherits from the GUI class
    def __init__(self, parent, controller):
        GUI.__init__(self, parent)

        frame1 = tk.LabelFrame(self, frame_styles, text="This is a LabelFrame containing a Treeview")
        frame1.place(rely=0.01, relx=0.02, height=400, width=1000)
        frame_cens = tk.LabelFrame(self, frame_styles, text="This is a LabelFrame of centroids")
        frame_cens.place(rely=0.48, relx=0.40, height=200, width=450)
        
        file_frame = tk.LabelFrame(self, frame_styles,text='Open File')
        file_frame.place(height=120, width=400, relx=0.02, rely=0.48)
        
        kmeans_frame = tk.LabelFrame(self, frame_styles,text='K-Means')
        kmeans_frame.place(height=100, width=150, relx=0.02, rely=0.63)

        find_frame = tk.LabelFrame(self, frame_styles, text='Find Place')
        find_frame.place(height=100, width=250,relx=0.16, rely= 0.63)

        result_table_frame = tk.LabelFrame(self, frame_styles, text='Search Table')
        result_table_frame.place(height=180, width=450,relx=0.40, rely= 0.70)

        elbow_frame = tk.LabelFrame(self,frame_styles, text='elbow method')
        elbow_frame.place(height=280, width=160, relx=0.82, rely= 0.48)
        # final_result_frame = tk.LabelFrame(self, frame_styles, text='Result')
        # final_result_frame.place(height=120, width=600, relx=0.25, rely= 0.84)
        #button
        button1 = tk.Button (file_frame, text= 'Browse A File', command=lambda: file_dialog())
        button1.place(rely=0.65, relx=0.50)

        button2 = tk.Button (file_frame, text= 'Load File',command=lambda: load_excel_data())
        button2.place(rely=0.65, relx=0.30)

        button3 = tk.Button (file_frame, text= 'Reset',command=lambda: clear_data())
        button3.place(rely=0.65, relx=0.10)

        button4 = tk.Button(kmeans_frame, text='Hitung',command=lambda: kmeans())
        button4.place(rely= 0.65, relx= 0.30)
        
        buttonfind = tk.Button(elbow_frame, text='Search',command=lambda: elbow())
        buttonfind.place(rely= 0.82, relx= 0.35)

        text_elbow = tk.Text(elbow_frame, state=DISABLED)
        text_elbow.place(relx=0,rely=0, width=150, height=200)
        # button_result = tk.Button(final_result_frame, text='Check Result', command=lambda: cek_result())
        # button_result.place(rely=0.70, relx=0.01)

        # Label
        label_file = tk.Label(file_frame, text= "No File Selected")
        label_file.place(rely=0, relx= 0)

        label_iteration = tk.Label(kmeans_frame, text= "Stopped at iteration : ")
        label_iteration.place(rely=0, relx= 0)
        # var1 = StringVar()
        # var1.set('The Result is ...')
        # label_result = tk.Label(final_result_frame, width=52, text='The Result is ...', font= 25, bg= 'white', fg= 'red')
        # label_result.place(rely=0, relx=0.01)

        # Input/Entry
        
        entry1 = tk.Entry(find_frame, width= 30, cursor="xterm")
        entry1.place(rely=0.1, relx=0.12)

        entry2 = tk.Entry(kmeans_frame, width= 15, cursor="xterm")
        entry2.place(rely=0.3, relx=0.1)
        
        # This is a treeview.
        tv1 = ttk.Treeview(frame1)
        tv1.place(relheight=1, relwidth=0.995)
        treescroll = tk.Scrollbar(frame1,command=tv1.yview, orient='vertical')
        treescroll2 = tk.Scrollbar(frame1,command=tv1.xview, orient='horizontal')
        tv1.configure(yscrollcommand=treescroll.set, xscrollcommand=treescroll2.set)
        treescroll.pack(side="right", fill="y")
        treescroll2.pack(side="bottom", fill="x")

        tv2 = ttk.Treeview(frame_cens)
        tv2.place(relheight=1, relwidth=0.995)
        scroll = tk.Scrollbar(frame_cens,command=tv2.yview, orient='vertical')
        scroll2 = tk.Scrollbar(frame_cens,command=tv2.xview, orient='horizontal')
        tv2.configure(yscrollcommand=scroll.set, xscrollcommand=scroll2.set)
        scroll.pack(side="right", fill="y")
        scroll2.pack(side="bottom", fill="x")

        tv3 = ttk.Treeview(result_table_frame)
        tv3.place(relheight=1, relwidth=0.995)
        scroll_result = tk.Scrollbar(result_table_frame,command=tv3.yview, orient='vertical')
        scroll_result2 = tk.Scrollbar(result_table_frame,command=tv3.xview, orient='horizontal')
        tv3.configure(yscrollcommand=scroll_result.set, xscrollcommand=scroll_result2.set)
        scroll_result.pack(side="right", fill="y")
        scroll_result2.pack(side="bottom", fill="x")
        
        def file_dialog():
            filename = filedialog.askopenfilename(initialdir="/", 
            title="Select a File", 
            filetypes=(("csv files", "*.csv"),('All Files', '*.*')))
            label_file['text'] = filename          

        def load_excel_data():
            file_path = label_file['text']
            try:
                excel_filename = r"{}".format(file_path)
                if excel_filename[-4:] == ".csv":
                    df = pd.read_csv(excel_filename)
                else:
                    df = pd.read_excel(excel_filename)

            except ValueError:
                tk.messagebox.showerror("Information", 'the file you have chose is invalid')
                return None
            except FileNotFoundError:
                tk.messagebox.showerror("Information", f'no such file as{file_path}')
                return None
                
            clear_data()
            tv1['column'] = list(df.columns)
            tv1['show'] = "headings"
            for column in tv1['columns'] :
                tv1.heading(column, text=column)

            df_rows = df.to_numpy().tolist()
            for row in df_rows :
                tv1.insert("", "end", values=row)
            
        def init_centroids(k, data):
            '''
                This function will be used to initialize the centroids once in the beginning.

                Centroids will be randomly chosen as points(features) from the dataset, as this provides faster
                convergence. Another implementation
                can be assigning completely random numbers as centroids, but this is dangerous.

                :param k: (int) number of centroids
                :param data: (np-array) containing the features of the dataset
                :return: (list) 'k' number of randomly selected centroids from the dataset
                '''
            c = []
            # Generate a list of k random numbers between 0 and the # of features of dataset
            s = np.array([26, 16, 9, 39]).astype(int)

            # s = np.array([136, 56, 104, 27]).astype(int)
            # s = np.array([214, 4, 57, 67]).astype(int)
            # s = np.array([161, 80, 68, 133]).astype(int)

            # s = np.array([185, 54, 72, 196]).astype(int)

            # s = np.array([208, 203, 2, 175]).astype(int)
            # s = np.array([109, 117, 219, 29]).astype(int)
            # s = np.array([96, 119, 162, 208]).astype(int)

            # s = np.array([39, 37, 48, 53,36]).astype(int)
            # s = np.array([18, 62, 49, 21,4,89]).astype(int)
            # s = np.random.randint(low=1, high=len(data), size=k)
            # # Check if all members of 's' are unique, if not, generate again
            # while (len(s) != len(set(s))):
            #     s = np.random.randint(low=1, high=len(data), size=k)
            # # For every i in s, get ith feature from dataset, and add it to list
            print(s)
            for i in s:
                c.append(data[i])
                print(data[i])
            return c
        
        def euc_dist(a, b):
            '''
            This function calculates and returns the euclidean distance between two input vectors.

            This is a helper function for cal_dist() to calculate distance of any given point in
            data w.r.t. the centroids.

            :param a: (list) vector a
            :param b: (list) vector b
            :return: (float) euclidean distance between two input vectors
            '''
            sum = 0
            for i, j in zip(a, b):
                a = (i - j) * (i - j)
                sum = sum + a
            return math.sqrt(sum)

        def cal_dist(centroids, data):
            '''
            This function will be used to generate the distance table.

            For each point in the given dataset, this function will calculate its euclidean distance
            with respect to each centroid, and a distance table will be generated, which will then be
            used to update the centroid positions.

            :param centroids: (list) containing position of centroids
            :param data: (np-array) containing the features of the dataset
            :return: (list) containing the distances of each point w.r.t. each centroid
            '''
            c_dist = []
            # For each centroid c, iterate through all points in data to calculate its distance from c
            for i in centroids:
                temp = []
                for j in data:
                    temp.append(euc_dist(i, j))
                c_dist.append(temp)
            return c_dist

        def perf_clustering(k, dist_table):
            '''
            This function will perform clustering on the basis of distance table w.r.t. to all centroids.

            With reference to the distance table, for each point in the table, this function will compare
            its distance from all the centroids, and then cluster the point with the nearest centroid.

            :param k: (int) number of centroids
            :param dist_table: (list) containing the distances of each point w.r.t. each centroid
            :return: (list) containing clusters and indexes of respective members
            '''
            # create empty cluster list of size k
            clusters = []
            for i in range(k):
                clusters.append([])
            # start clustering data points, such that each point is clustered to nearest centroid
            for i in range(len(dist_table[0])):
                d = []
                for j in range(len(dist_table)):
                    d.append(dist_table[j][i])
                clusters[d.index(min(d))].append(i)
            return clusters

        def update_centroids(centroids, cluster_table, data):
            '''
            This function will update the centroids locations after each iteration

            After performing the clustering, some elements might have migrated from one cluster
            to the another cluster, so w.r.t. the new cluster table, this function will calculate and
            update the new centroid locations

            :param centroids: (list) containing position of centroids
            :param cluster_table: (list) containing clusters and indexes of respective members
            :param data: (np-array) containing the features of the dataset
            :return: (list) containing updated position of centroids
            '''
            for i in range(len(centroids)):
                # Update the centroid if there are some flowers within this centroid
                if (len(cluster_table[i]) > 0):
                    temp = []
                    # Copy features of cluster members to temp list
                    for j in cluster_table[i]:
                        temp.append(list(data[j]))
                    # Take mean of features of all members of cluster to get new centroid location
                    sum = [0] * len(centroids[i])
                    for l in temp:
                        sum = [(a + b) for a, b in zip(sum, l)]
                    centroids[i] = [p / len(temp) for p in sum]

            return centroids

        def check_n_stop(dist_mem, cluster_mem):
            '''
            This function will check if the stopping criteria has been met

            This function will help to check if there is a convergence to a solution, with the help of
            specified stopping criterias:
            In case of Iris-Dataset, we can use the following stopping criterias:
            --[1] The euclidean distances/distance table stays unchanged for 2 or more iterations.
            --[2] The cluster table stays unchanged for two or more iterations, i.e. no flower migrations

            :param dist_table: (list) containing the distances of each point w.r.t. each centroid
            :param cluster_table: (list) containing clusters and indexes of respective members
            :return: True, if stopping criteria is met, else False.
            '''

            # Check if distance table has not changed over past iterations
            c1 = all(x == dist_mem[0] for x in dist_mem)
            # Check if cluster table has not changed over past iterations
            c2 = all(y == cluster_mem[0] for y in cluster_mem)

            if c1:
                print("Stopping... Distance table has not changed from few iterations")
            elif c2:
                print("Stopping... Cluster table has not changed from few iterations")
            return c1 or c2

        def kmeans():
            try :
                file_path = label_file['text']
                excel_filename = r"{}".format(file_path)
                df = pd.read_csv(excel_filename)
                f1 = df['jumlah_banjir'].values
                f2 = df['jumlah_puting_beliung'].values
                f3 = df['jumlah_tanah_longsor'].values
                original_data = np.array(list(zip(f1, f2,f3)))
                data = np.array(list(zip(f1, f2,f3)))
                inp = entry2.get()
                k = int(inp)
                max_iterations = 100
                dist_mem = []
                cluster_mem = []
                # Initialize centroids
                centroids = init_centroids(k, data)
                # Calculate distance table
                distance_table = cal_dist(centroids, data)
                # Perform clustering based on above generated distance table
                cluster_table = perf_clustering(k, distance_table)
                # Update centroid location based on above generated cluster table
                newCentroids = update_centroids(centroids, cluster_table, data)

                # Add distance and cluster table to memory list
                dist_mem.append(distance_table)
                cluster_mem.append(cluster_table)

                # Repeat from step 2 till stopping criteria is met
                for i in range(max_iterations):
                    distance_table = cal_dist(newCentroids, data)
                    cluster_table = perf_clustering(k, distance_table)
                    newCentroids = update_centroids(newCentroids, cluster_table, data)

                    # Check for stopping criteria
                    # Maintain memory for past distance table and cluster table
                    dist_mem.append(distance_table)
                    cluster_mem.append(cluster_table)
                    # If distance/cluster has not changed over last 10 iterations, stop, else continue
                    if len(dist_mem) > 80:
                        dist_mem.pop(0)
                        cluster_mem.pop(0)
                        if check_n_stop(dist_mem, cluster_mem):
                            iter = ('Stopped at iteration #', i)
                            label_iteration['text'] = iter
                            break

                # Run the K-Means algorithm on the Iris-Dataset with k = 3, and max-iterations limited to 100

                dump = []
                indeks = dict()
                for i in range(len(newCentroids)):
                    # print("Centroid #", i, ": ", newCentroids[i])
                    # print("jumlah data : ", len(cluster_table[i]))
                    # print("Members of the cluster: ")
                    for j in range(len(cluster_table[i])):
                        # print(original_data[cluster_table[i][j]])
                        af = df[(df["jumlah_banjir"] == original_data[cluster_table[i][j]][0]) & (
                            df["jumlah_puting_beliung"] == original_data[cluster_table[i][j]][1]) &(
                            df["jumlah_tanah_longsor"] == original_data[cluster_table[i][j]][2])]
                        if len(af) > 1:
                            if indeks.setdefault(str(','.join([str(i) for i in af['id']]))) == None:
                                year = [str(i) for i in af['tahun']]
                                town = af['nama_kabupaten_kota'].values
                                p = str(','.join([str(i) for i in af['id']]))
                                cek = indeks.update({p:0})
                                z = indeks.setdefault(str(','.join([str(i) for i in af['id']])))
                                dump.append([str(i),town[z] ,year[z],
                                            original_data[cluster_table[i][j]], original_data[cluster_table[i][j]][0], original_data[cluster_table[i][j]][1], original_data[cluster_table[i][j]][2]])
                            else:
                                year = [str(i) for i in af['tahun']]
                                town = af['nama_kabupaten_kota'].values
                                p = str(','.join([str(i) for i in af['id']]))
                                test = indeks.setdefault(str(','.join([str(i) for i in af['id']])))
                                cek = indeks.update({p:test+1})
                                test = indeks.setdefault(str(','.join([str(i) for i in af['id']])))
                                dump.append([str(i),  town[test] ,year[test],
                                        original_data[cluster_table[i][j]], original_data[cluster_table[i][j]][0], original_data[cluster_table[i][j]][1], original_data[cluster_table[i][j]][2]])
                        else:
                            year = [str(i) for i in af['tahun']]
                            town = af['nama_kabupaten_kota'].values
                            dump.append([str(i), " ".join(af['nama_kabupaten_kota'].values) ," ".join(year),
                                        original_data[cluster_table[i][j]], original_data[cluster_table[i][j]][0], original_data[cluster_table[i][j]][1], original_data[cluster_table[i][j]][2]])
                # making new coloms
                cols = ["Centroid", "Nama Kabupaten/Kota","Tahun",
                        "Member of the cluster", "Jumlah Banjir", "Jumlah Puting Beliung", "Jumlah Tanah Longsor"]
                pd.DataFrame(dump)
                sf = pd.DataFrame(dump, columns=cols)
                # sf.to_csv("hasil_clustering_data.csv")
                # print(sf)
                clear_data()
                
                look_centroid(newCentroids,cluster_table)
                cari(newCentroids,cluster_table)
                tv1['column'] = list(sf.columns)
                tv1['show'] = "headings"
                for column in tv1['columns'] :
                    tv1.heading(column, text=column)

                sf_rows = sf.to_numpy().tolist()
                for row in sf_rows :
                    tv1.insert("", "end", values=row)
                
                
            except ValueError:
                tk.messagebox.showerror("Information", 'the file you have chose is invalid')
                return None
            except FileNotFoundError:
                tk.messagebox.showerror("Information", f'no such file as{file_path}')
                return None              

        def clear_data():     
            tv1.delete(*tv1.get_children())
            tv2.delete(*tv2.get_children())
            tv3.delete(*tv3.get_children())
            return None

        def look_centroid(newCentroids,cluster_table):  
            demp = []
            print(newCentroids)
            for i in range(len(newCentroids)):    
                demp.append([i, newCentroids[i],len(cluster_table[i])])
            col = ["Centroid", "Range Centroid","Jumlah Data"]
            pd.DataFrame(demp)
            jf = pd.DataFrame(demp, columns=col)
            clear_data()
            tv2['column'] = list(jf.columns)
            tv2['show'] = "headings"
            for column in tv2['columns'] :
                tv2.heading(column, text=column)

            jf_rows = jf.to_numpy().tolist()
            for row in jf_rows :
                tv2.insert("", "end", values=row)

        def elbow():
            file_path = label_file['text']
            excel_filename = r"{}".format(file_path)
            df = pd.read_csv(excel_filename)
            k_rng = range(1,10)
            sse = []
            
            for k in k_rng :
                km = KMeans(n_clusters = k)
                km.fit(df[['jumlah_banjir' , 'jumlah_puting_beliung', 'jumlah_tanah_longsor']])
                sse.append(km.inertia_)
            # print (sse)
            ier = sse
            text_elbow.configure(state='normal')
            text_elbow.delete(0.0, 'end')
            text_elbow.insert(0.0, (ier))
            text_elbow.configure(state='disabled')
            
            plt.plot(k_rng, sse)
            plt.title('The Elbow Method')
            plt.xlabel('K')
            plt.ylabel('Sum of Square Error')
            
            plt.show()
            

        def cari(newCentroids,cluster_table):
                file_path = label_file['text']
                excel_filename = r"{}".format(file_path)
                df = pd.read_csv(excel_filename)
                f1 = df['jumlah_banjir'].values
                f2 = df['jumlah_puting_beliung'].values
                f3 = df['jumlah_tanah_longsor'].values
                original_data = np.array(list(zip(f1, f2, f3)))
    
                dump = []
                indeks = dict()
                for i in range(len(newCentroids)):
                    for j in range(len(cluster_table[i])):
                        af = df[(df["jumlah_banjir"] == original_data[cluster_table[i][j]][0]) & (
                            df["jumlah_puting_beliung"] == original_data[cluster_table[i][j]][1])& (
                            df["jumlah_tanah_longsor"] == original_data[cluster_table[i][j]][2])]
                        if len(af) > 1:
                            if indeks.setdefault(str(','.join([str(i) for i in af['id']]))) == None:
                                year = [str(i) for i in af['tahun']]
                                town = af['nama_kabupaten_kota'].values
                                p = str(','.join([str(i) for i in af['id']]))
                                cek = indeks.update({p:0})
                                z = indeks.setdefault(str(','.join([str(i) for i in af['id']])))
                                dump.append([i,town[z] ,year[z],
                                            original_data[cluster_table[i][j]], original_data[cluster_table[i][j]][0], original_data[cluster_table[i][j]][1], original_data[cluster_table[i][j]][2]])
                            else:
                                year = [str(i) for i in af['tahun']]
                                town = af['nama_kabupaten_kota'].values
                                p = str(','.join([str(i) for i in af['id']]))
                                test = indeks.setdefault(str(','.join([str(i) for i in af['id']])))
                                cek = indeks.update({p:test+1})
                                test = indeks.setdefault(str(','.join([str(i) for i in af['id']])))
                                dump.append([i,  town[test] ,year[test],
                                        original_data[cluster_table[i][j]], original_data[cluster_table[i][j]][0], original_data[cluster_table[i][j]][1], original_data[cluster_table[i][j]][2]])
                        else:
                            year = [str(i) for i in af['tahun']]
                            town = af['nama_kabupaten_kota'].values
                            dump.append([i, " ".join(af['nama_kabupaten_kota'].values) ," ".join(year),
                                        original_data[cluster_table[i][j]], original_data[cluster_table[i][j]][0], original_data[cluster_table[i][j]][1], original_data[cluster_table[i][j]][2]])
                # making new coloms
                cols = ["Centroid", "Nama Kabupaten/Kota","Tahun",
                        "Member of the cluster", "Jumlah Banjir", "Jumlah Puting Beliung", "Jumlah Tanah Longsor"]
                pd.DataFrame(dump)
                sf = pd.DataFrame(dump, columns=cols)
                # df = pd.read_csv("ini-env\data banjirre.csv")
                search = sf[sf['Nama Kabupaten/Kota'].values == (str(entry1.get()))]
                # print(search)
                # clear_data()
                tv3["column"] = list(search.columns)
                tv3["show"] = "headings"
                for column in tv3["columns"]:
                    tv3.heading(column, text=column) # let the column heading = column name
                df_rows = search.to_numpy().tolist() # turns the dataframe into a list of lists
                for row in df_rows:
                    tv3.insert("", "end", values=row)
                return None

        # def cek_result():
        #     inp = entry1.get()
        #     if inp == 'KABUPATEN BOGOR' or inp == 'KABUPATEN SUKABUMI' or inp == 'KOTA BOGOR':               
        #         label_result['text'] = ('Wilayah ini tidak cocok sebagai tempat persawahan')
        #         # print('Wilayah ini tidak cocok sebagai tempat persawahan')
        #     elif inp == 'KABUPATEN BANDUNG' or inp == 'KABUPATEN GARUT' or inp =='KABUPATEN CIAMIS' or inp == 'KABUPATEN KUNINGAN' or inp =='KABUPATEN MAJALENGKA' or inp == 'KABUPATEN SUMEDANG' :
        #         label_result['text'] = ('Wilayah ini cocok sebagai tempat persawahan \ntetapi harus dengan syarat tertentu')
        #     elif inp == 'KABUPATEN CIANJUR' or inp == 'KABUPATEN TASIKMALAYA' or inp == 'KABUPATEN CIREBON' or inp == 'KABUPATEN INDRAMAYU' or inp == 'KABUPATEN SUBANG' or inp == 'KABUPATEN PURWAKARTA' or inp == 'KABUPATEN KAWARANG' or inp == 'KABUPATEN BEKASI' or inp == 'KABUPATEN BANDUNG BARAT' or inp == 'KABUPATEN PANGANDARAN' or inp == 'KOTA SUKABUMI' or inp == 'KOTA BANDUNG' or inp == 'KOTA CIREBON' or inp == 'KOTA BEKASI' or inp == 'KOTA DEPOK' or inp == 'KOTA CIMAHI' or inp == 'KOTA TASIKMALAYA' or inp == 'KOTA BANJAR':
        #         label_result['text'] = ('Wilayah ini cocok sebagai tempat persawahan')
        #     else :
        #         tk.messagebox.showinfo("Information", "WRONG INPUT.")
        #     return None
            
class PagePertama(GUI):
    def __init__(self, parent, controller):
        GUI.__init__(self, parent)
        text_styles = {"font": ("Verdana", 14),
                    "background": "#BEB2A7",
                    "foreground": "black"}

        frame1 = tk.LabelFrame(self, frame_styles, text="This is a LabelFrame containing a Treeview")
        frame1.place(rely=0.01, relx=0.02, height=400, width=1000)

        file_frame = tk.LabelFrame(self, frame_styles,text='Open File')
        file_frame.place(height=120, width=400, relx=0.56, rely=0.48)

        find_frame = tk.LabelFrame(self, frame_styles, text='Find Place')
        find_frame.place(height=350, width=550,relx=0.02, rely= 0.48)

        tv1 = ttk.Treeview(frame1)
        tv1.place(relheight=1, relwidth=0.995)
        treescroll = tk.Scrollbar(frame1,command=tv1.yview, orient='vertical')
        treescroll2 = tk.Scrollbar(frame1,command=tv1.xview, orient='horizontal')
        tv1.configure(yscrollcommand=treescroll.set, xscrollcommand=treescroll2.set)
        treescroll.pack(side="right", fill="y")
        treescroll2.pack(side="bottom", fill="x")

        button1 = tk.Button (file_frame, text= 'Browse A File', command=lambda: file_dialog())
        button1.place(rely=0.65, relx=0.75)

        button2 = tk.Button (file_frame, text= 'Load File',command=lambda: load_excel_data())
        button2.place(rely=0.65, relx=0.55)

        button_proses = tk.Button (find_frame, text_styles,text= 'Proses', command=lambda: proses())
        button_proses.place(rely=0.5, relx=0.5)

        button_reset = tk.Button (find_frame, text_styles,text= 'Reset', command=lambda: clear_data())
        button_reset.place(rely=0.5, relx=0.3)

        # Label
        label_file = tk.Label(file_frame, text= "No File Selected")
        label_file.place(rely=0.01, relx= 0.01)

        label_input_Kota = tk.Label(find_frame, text_styles, text='Nama Kabupaten/Kota : ')
        label_input_Kota.place(relx=0.02, rely=0.02)

        label_input_centroid = tk.Label(find_frame, text_styles, text='Centroid ke                : ')
        label_input_centroid.place(relx=0.02, rely=0.16)

        label_input_tahun = tk.Label(find_frame, text_styles, text='Tahun                       : ')
        label_input_tahun.place(relx=0.02, rely=0.3)

        entry_kota = tk.Entry(find_frame, width= 40, cursor="xterm")
        entry_kota.place(rely=0.04, relx=0.47)

        entry_centroid = tk.Entry(find_frame, width= 40, cursor="xterm")
        entry_centroid.place(rely=0.18, relx=0.47)

        entry_tahun = tk.Entry(find_frame, width= 40, cursor="xterm")
        entry_tahun.place(rely=0.31, relx=0.47)

        def file_dialog():
            filename = filedialog.askopenfilename(initialdir="/", 
            title="Select a File", 
            filetypes=(("csv files", "*.csv"),('All Files', '*.*')))
            label_file['text'] = filename

        def load_excel_data():
            file_path = label_file['text']
            try:
                excel_filename = r"{}".format(file_path)
                if excel_filename[-4:] == ".csv":
                    df = pd.read_csv(excel_filename)
                else:
                    df = pd.read_excel(excel_filename)

            except ValueError:
                tk.messagebox.showerror("Information", 'the file you have chose is invalid')
                return None
            except FileNotFoundError:
                tk.messagebox.showerror("Information", f'no such file as{file_path}')
                return None
                
            clear_data()
            tv1['column'] = list(df.columns)
            tv1['show'] = "headings"
            for column in tv1['columns'] :
                tv1.heading(column, text=column)

            df_rows = df.to_numpy().tolist()
            for row in df_rows :
                tv1.insert("", "end", values=row)
        
        def clear_data():     
            tv1.delete(*tv1.get_children())
            # tv2.delete(*tv2.get_children())
            # tv3.delete(*tv3.get_children())
            return None
        
        def proses():
            file_path = label_file['text']
            excel_filename = r"{}".format(file_path)
            df = pd.read_csv(excel_filename, names=[
                "Centroid","Nama Kabupaten/Kota","Tahun","Member of the cluster","Jumlah Banjir","Jumlah Puting Beliung","Jumlah Tanah Longsor"],skipinitialspace=True)
            # cari = df[(df['Nama Kabupaten/Kota']==str(entry_kota.get()))]
            # cari = df[(df['Nama Kabupaten/Kota']==str(entry_kota.get())) & (df['Tahun']==int(entry_tahun.get()))]
            # if not entry_centroid.get() :
            #     cari = df[(df['Nama Kabupaten/Kota']==str(entry_kota.get())) & (df['Tahun']==str(entry_tahun.get()))]
            #     # cari = df[df['Tahun']==str(entry_tahun.get())]
            #     dump = cari
            #     print (cari)
            #     if not str(entry_tahun.get())  :
            #         cari = df[df['Nama Kabupaten/Kota']==str(entry_kota.get())]
            #         dump = cari
            #         print (cari)

            dump = ""
            # centroid + kota + tahun
            if entry_centroid.get() :
                if entry_kota.get() :
                    if entry_tahun.get() :
                        cari = df[(df['Centroid']==str(entry_centroid.get())) & (df['Tahun']==str(entry_tahun.get())) 
                        & (df['Nama Kabupaten/Kota']==str(entry_kota.get()))]
                        dump = cari
                        print(cari)
                    # centroid + kota
                    if not entry_tahun.get() :
                        cari = df[(df['Centroid']==str(entry_centroid.get())) & (df['Nama Kabupaten/Kota']==str(entry_kota.get()))]
                        dump = cari
                        print(cari)
                # centroid + tahun
                elif not entry_kota.get():
                    if entry_tahun.get() :
                        cari = df[(df['Centroid']==str(entry_centroid.get())) & (df['Tahun']==str(entry_tahun.get()))]
                        dump = cari
                        print(cari)
                    # centroid only
                    elif not entry_tahun.get() :
                        cari = df[df['Centroid']==str(entry_centroid.get())]
                        dump = cari
                        print(cari)
            # kota + tahun
            elif not entry_centroid.get() :
                if entry_kota.get() : 
                    if entry_tahun.get() :
                        cari = df[(df['Tahun']==str(entry_tahun.get())) & (df['Nama Kabupaten/Kota']==str(entry_kota.get()))]
                        dump = cari
                        print(cari)
                    # kota only
                    elif not entry_tahun.get() :
                        cari = df[df['Nama Kabupaten/Kota']==str(entry_kota.get())]
                        dump = cari
                        print(cari)
                # tahun only
                elif not entry_kota.get() :
                    if entry_tahun.get():
                        cari = df[df['Tahun']==str(entry_tahun.get())]
                        dump = cari
                        print(cari)

            clear_data()
            tv1["column"] = list(dump.columns)
            tv1["show"] = "headings"
            for column in tv1["columns"]:
                tv1.heading(column, text=column) # let the column heading = column name

            df_rows = dump.to_numpy().tolist() # turns the dataframe into a list of lists
            for row in df_rows:
                tv1.insert("", "end", values=row)
            return None
        

class PageOne(GUI):
    def __init__(self, parent, controller):
        GUI.__init__(self, parent)



        label1 = tk.Label(self.main_frame, font=("Verdana", 20), text="Page One")
        label1.pack(side="top")


class PageThree(GUI):
    def __init__(self, parent, controller):
        GUI.__init__(self, parent)

        label1 = tk.Label(self.main_frame, font=("Verdana", 20), text="Page Three")
        label1.pack(side="top")


class PageFour(GUI):
    def __init__(self, parent, controller):
        GUI.__init__(self, parent)

        label1 = tk.Label(self.main_frame, font=("Verdana", 20), text="Page Four")
        label1.pack(side="top")


class PageTwo(GUI):
    def __init__(self, parent, controller):
        GUI.__init__(self, parent)

        label1 = tk.Label(self.main_frame, font=("Verdana", 20), text="Page Two")
        label1.pack(side="top")


class OpenNewWindow(tk.Tk):

    def __init__(self, *args, **kwargs):

        tk.Tk.__init__(self, *args, **kwargs)

        main_frame = tk.Frame(self)
        main_frame.pack_propagate(0)
        main_frame.pack(fill="both", expand="true")
        main_frame.grid_rowconfigure(0, weight=1)
        main_frame.grid_columnconfigure(0, weight=1)
        self.title("Here is the Title of the Window")
        self.geometry("500x500")
        self.resizable(0, 0)

        frame1 = ttk.LabelFrame(main_frame, text="This is a ttk LabelFrame")
        frame1.pack(expand=True, fill="both")

        label1 = tk.Label(frame1, font=("Verdana", 20), text="OpenNewWindow Page")
        label1.pack(side="top")

        


top = LoginPage()
top.title("Login")
root = MyApp()
root.withdraw()
root.title("32180025")

root.mainloop()