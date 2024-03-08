## How to add the alg4 library

Download the algs4.jar Library:

You can download the algs4.jar file from the algs4 website.
Add algs4.jar to Your Project's Libraries:

- In IntelliJ IDEA, open your project.
- Copy the algs4.jar file to a directory within your project, e.g., lib.
- Right-click on the lib directory in your project.
- Choose "Add as Library..." from the context menu.
- IntelliJ IDEA will detect the JAR file and add it as a library to your project.

Configure Module Dependencies:

- Open your project settings:
- Navigate to File > Project Structure (or press Ctrl + Alt + Shift + S).
- Go to the Modules section.
- Select your module.
- Go to the Dependencies tab.
- Click on the + button.
- Choose JARs or directories.
- Navigate to the lib directory within your project and select algs4.jar.
- Click "OK" to add it as a dependency for your module.
- Verify Import:

Now, you should be able to import edu.princeton.cs.algs4.StdIn in your Java classes without any errors.

# Compiling

We can use the main() of InteractivePercolationVisualizer to 
start an interactive viewer that tests our implementation of the
percolation class.

