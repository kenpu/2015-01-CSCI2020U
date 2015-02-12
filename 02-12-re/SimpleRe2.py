import re

paragraph = "Mr. Einstein wrote a letter to Prof Feynman"
regexp = r'(Mr|Prof)\.?\s+([A-Z][a-z]+)'

for g in re.findall(regexp, paragraph):
    print "title: %s\nname: %s\n--------" % g


