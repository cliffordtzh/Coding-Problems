import os

root = os.getcwd()
qns_src = input("Which website is the new problem from?: ").capitalize()
if not qns_src in os.listdir():
    os.mkdir(qns_src)

qns_name = input("Whats the name of the question?: ").capitalize()
qns_folder = os.path.join(root, qns_src, qns_name)
if not os.path.isdir(qns_folder):
    os.mkdir(qns_folder)
    print("Go ahead champ :)")

else:
    print("Champ, its been done before :(")