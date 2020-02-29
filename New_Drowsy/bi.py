import os,signal
import pandas as pd
pid = pd.read_csv('pid.csv',names=['prog','pid'])

print(pid['pid'][0])

if(pid['prog'][0]=='WORK1'):
    os.kill(pid['pid'][0],signal.SIGTERM)
