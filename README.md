# Polynomial-Calculus
[Version 1.00] <br/>
Feb 22, 2021 <br/>

## CONTACT INFORMATION


Contact Name:		  Trong Nguyen <br/>
Contact Email:		trong0dn@gmail.com

## DESCRIPTION

- PolyCalc short for Polynomial Calculus is a small program that takes the
derivative or integrates polynomial functions. 

- The application is composed of the following four files:
  - Main.java
  - mymath/CalcUI.java
  - mymath/Poly.java
  - mymath/PolyCalc.java

## INSTALLATION

This program has only been created and tested for Windows 10.

<b> > Installation Dependencies </b>
  
The application should work with the most recent version of Java programming 
language updated to at least JDK 16. 

No other supplementary libraries and testing file with modular dependencies
are required to run this application.

## USAGE

<b> > Compiling the program </b>

Open Command Prompt on Windows OS and navigate to the directory containing 
'mymath' package. Compile the .java files in the following order to generate 
the .class files.

<pre>
>>> javac mymath/Poly.java
>>> javac mymath/PolyCalc.java
>>> javac mymath/PolyUI.java
>>> javac Main.java
</pre>

Then to run the program in Command Prompt.

<pre>
>>> java Main
</pre>

<b> > Sample Game Shell Input & Ouputs </b>

<pre>
Welcome to the PolyCalc App!
This application has three basic polynomial calculus functions:
-> Evaluate
-> Derivative
-> Integrate
Enter the coefficients of the polynomial separated by space: 
For example: 3.0x^2 + 2.0x^1 + 1.0, would be: 3 2 1
>>> 3 2 1
Polynomial >>> 3.0x^2 + 2.0x^1 + 1.0
Input correct? [y/n]
y
Select one of the following functions:
 [e] Evaluate
 [d] Derivative
 [i] Integrate
 [b] Enter new polynomial
 [x] Exit the program
>>> e
x = 1
Evaluate:
3.0x^2 + 2.0x^1 + 1.0
with x = 1 >>> 6.0
Select one of the following functions:
 [e] Evaluate
 [d] Derivative
 [i] Integrate
 [b] Enter new polynomial
 [x] Exit the program
>>> 2
Must select a function!
Select one of the following functions:
 [e] Evaluate
 [d] Derivative
 [i] Integrate
 [b] Enter new polynomial
 [x] Exit the program
>>> d
Differentiate: 6.0x^1 + 2.0
Select one of the following functions:
 [e] Evaluate
 [d] Derivative
 [i] Integrate
 [b] Enter new polynomial
 [x] Exit the program
>>> x
Exiting. Good-bye!
</pre>

## CREDITS

Thanks to the TAs and Instructor of my Object-Oriented Software Development
course for the initial idea.
