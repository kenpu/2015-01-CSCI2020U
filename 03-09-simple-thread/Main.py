import time
import threading
import random

class Echo(threading.Thread):
    def __init__(self, m):
        threading.Thread.__init__(self)
        self.m = m
        self.r = random.Random()

    def run(self):
        for i in range(20):
            self.randSleep()
            print "%d: %s" % (i, self.m)
        print "[%s] HAS WON...." % self.m

    def randSleep(self):
        time.sleep(self.r.randint(0, 1000) / 1000.0)

t1 = Echo("CSCI 2020U")
t2 = Echo("Sys Dev & Int")

t1.start()
t2.start()

t1.join();
t2.join();
print "========== ALL DONE ============"

