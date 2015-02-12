import re

paragraph = "Mr. Einstein wrote a letter to Prof Feynman"
regexp = r'(Mr|Prof)\.?\s+([A-Z][a-z]+)'

for m in re.finditer(regexp, paragraph):
    title = m.group(1)
    name = m.group(2)
    print title
    print name
    print "---------------"
