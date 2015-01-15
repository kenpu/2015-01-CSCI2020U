# Packages

- Demonstrates how to create Java packages, and projects making use of multiple
  packages.

- Demonstrates the file management of Java projects with multiple packages.

- Demonstrates the usage of classpath.

# Organization

    .
    ├── MyProg.java
    ├── README.md
    ├── workspace-A
    │   └── data
    │       └── List.java
    └── workspace-B
        └── fruits
            └── Apple.java

# Compilation

Using command line option:

    javac -cp ./workspace-A:./workspace-B MyProg.java
    java -cp ./workspace-A:./workspace-B:. MyProg red green

Using environment variable:

    export CLASSPATH=./workspace-A:./workspace-B:. 
    javac MyProg.java
    java MyProg red green


