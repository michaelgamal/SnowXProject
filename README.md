# SnowXProject

# This Project is analyzing a 2D Image and trying to find the HPship and HPTorbebo.

# The Input for this Applications is Three files 

     - The Scan Image which is the source image 
     - The Target ship sample image
     - The Target torbedo sample image.

# The application scans the source image and based on the a specific accuracy threshold

  start to extract the found object (torbedo or ship)


# The output of the application is system out line 

For each object found with the level confidence and the four point of the object boundaries as below:
    
 " I am 63% sure that there is a Torpedo in the area between points [  ] "


# Instructions to run the Application :

    - The entry point for the application is SnowXApplication. 
    - There is a resource folder in the application is "src/samples"
   
 1- Update the resource folder with the ".snw" files if required.

 2- Update the the file name and object name in the main method of "SnowXApplication".

 3- Update the accuracy level as well.

 4- Run the the "SnowXApplication" class or / export Jar file from the application and run it form the command line "java -jar SnowXApplication.jar".
    
     SnowXApplication.jar is the already exported jar file.


 
