import json
import subprocess
with open("data.txt") as json_file:
    data = json.load(json_file)
    for p in data['Classes']:
        print("Test_Name: " + p["Test_name"])
        subprocess.call(['javac -cp junit-4.13-rc-1.jar'], shell=True)
