Enigma
======

This is the working code for a German Enigma machine used in WW2. This project was assigned for CS61B at UC Berkeley and the Project specs can be read here:
[Project 0](https://inst.eecs.berkeley.edu/~cs61b/fa12/labs/proj0.pdf)

Usage
-----

    java enigma.Main < INPUT-FILE
or

    java enigma.Main < INPUT-FILE > OUTPUT-FILE

The input file looks like this:

    * B III IV I AXLE
    FROM his shoulder Hiawatha
    Took the camera of rosewood
    Made of sliding folding rosewood
    Neatly put it all together
    In its case it lay compactly
    Folded into nearly nothing
    But he opened out the hinges
    Pushed and pulled the joints
    and hinges
    Till it looked all squares
    and oblongs
    Like a complicated figure
    In the Second Book of Euclid

The first line is the configuration file denoted by an "*". The first letter is B or C for the reflector being used. The next three roman numerals are the three rotors in their respective order. The last word denotes the inital positions of the reflector and the three rotors. 

Rotors
------

Rotor Permutation (as cycles) and the Notch that advances the next rotor:

    Rotor I (AELTPHQXRU) (BKNW) (CMOY) (DFG) (IV) (JZ) (S) Notch: Q
    Rotor II (FIXVYOMW) (CDKLHUP) (ESZ) (BJ) (GR) (NT) (A) (Q) Notch: E
    Rotor III (ABDHPEJT) (CFLVMZOYQIRWUKXSG) (N) Notch: V
    Rotor IV (AEPLIYWCOXMRFZBSTGJQNH) (DV) (KU) Notch: J
    Rotor V (AVOLDRWFIUQ)(BZKSMNHYC) (EGTJPX) Notch: Z
    Rotor VI (AJQDVLEOZWIYTS) (CGMNHFUX) (BPRK) Notches: Z and M
    Rotor VII (ANOUPFRIMBZTLWKSVEGCJYDHXQ) Notches : Z and M
    Rotor VIII (AFLSETWUNDHOZVICQ) (BKJ) (GXY) (MPR) Z and M
    Reﬂector B (AY) (BR) (CU) (DH) (EQ) (FS) (GL) (IP) (JX) (KN) (MO) (TZ) (VW)
    Reﬂector C (AF) (BV) (CP) (DJ) (EI) (GO) (HY) (KR) (LZ) (MX) (NW) (TQ) (SU)
    This shows the initial positons of the rotors. For more information see the PDF.