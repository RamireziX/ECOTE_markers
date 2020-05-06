```
The goal of the program is to check the structure of markers in a text file (similar to XML file). 
Such marker looks like this:
<marker_name> </marker_name>
where:
‘< ‘ - opening of starting marker
‘</’ - opening of closing marker
>  - closing of a marker
marker_name - identifier of a marker
For example: <mark1> some text </mark1>
The program will read a text file on input and check its correctness. 
Then the user will be informed whether there are any errors, and if so, 
what was the error and where it is located in the file (line number)
