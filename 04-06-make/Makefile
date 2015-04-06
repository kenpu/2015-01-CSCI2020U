CP = target

all: source doc target/util.jar

# ---------------- Java compilation -----------------------

source: target classes

classes: target/uoit/csci2020u/util/StringUtil.class \
	     target/Test_StringUtil.class

target:
	mkdir -p target

target/uoit/csci2020u/util/StringUtil.class : src/uoit/csci2020u/util/StringUtil.java
	javac -d target src/uoit/csci2020u/util/StringUtil.java

target/Test_StringUtil.class : src/uoit/csci2020u/util/Test_StringUtil.java
	javac -cp $(CP) -d target src/uoit/csci2020u/util/Test_StringUtil.java

# ---------------- Documentation ---------------------------

doc: classes
	mkdir -p doc
	javadoc -d doc -classpath $(CP) -sourcepath ./src uoit.csci2020u.util

# --------------- Jar file packaging ------------------------

target/util.jar : classes
	cd target; jar cvf util.jar uoit Test_StringUtil.class

# ------------- Testing
test: classes
	java -cp $(CP) Test_StringUtil
	java -cp target/util.jar Test_StringUtil


# Cleaning
#
clean:
	rm -rf doc
	rm -rf target











