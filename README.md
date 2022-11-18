# TicTacToe_Daniel

I am doing a code review by Daniel and his project TicTacToe. The code is easy to follow and it does the job. The changes I made was to condense the code a little by
using for-each loops. I am also changing a little how the Strings are printed to the console since there was lots of \n \r newline, making it harder to overview in the code
(in my opinion). I also changed how the switch blocks looked to condense the code. This was a common theme in the project, the code was good but very "fluffy". The original 
code was 417 lines or so and I got it down to just above 400 with just cosmetic changes.
Daniel is using Scanner to get user input and remembers to close them after usage to avoid memory leaks. 


Example on condensed switch-block:

![newCase](https://user-images.githubusercontent.com/91593947/202799306-1d3dd4aa-fa08-49cb-8c80-7b7fa88b5276.png)

Original switch-block:


![oldCase](https://user-images.githubusercontent.com/91593947/202799615-30d558cd-f07a-499c-b604-f13d7f61d719.png)

Another example of the condensing of switch block:

![anotherNewCase](https://user-images.githubusercontent.com/91593947/202799945-3f405e29-61ee-443c-b3d4-03152f8c1c51.png)

Original:

![anotherOldCase](https://user-images.githubusercontent.com/91593947/202800142-6f82e662-d3d6-4fdd-b2a3-a0868272e667.png)


As one can see, the condensed version is easier to comprehend and look at.
