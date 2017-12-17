# PIWORKS_Pyramid
PIWORKS_Pyramid

Q1. Write code for below problem. The input below is just an example and you should implement independent from the input.
You will have a TRIANGLE input from a file and you need to find the maximum sum of the numbers according to given rules below;

1. You will start from the top and move downwards to an adjacent number as in below.
2. You are only allowed to walk downwards and diagonally.
3. You can only walk over NON PRIME NUMBERS.

According to above rules the maximum sum of the numbers from top to bottom in below example is 24.

       *1
      *8 4
     2 *6 9
    8 5 *9 3

As you can see this has several paths that fits the rule of NOT PRIME NUMBERS; 1>8>6>9, 1>4>6>9, 1>4>9>9
1 + 8 + 6 + 9 = 24.  As you see 1, 8, 6, 9 are all NOT PRIME NUMBERS and walking over these yields the maximum sum.

Q2. According to assignment in Q1 that you implemented what is the maximum sum of below input? It means please take this pyramid as an input (as file or constants directly inside the code) for your implementation and solve by using it.
!!!Don't forget to think below file input as PYRAMID!!!
(You can delete the space rows after the each row , Input must not consist the empty line)

215

193 124

117 237 442

218 935 347 235

320 804 522 417 345

229 601 723 835 133 124

248 202 277 433 207 263 257

359 464 504 528 516 716 871 182

461 441 426 656 863 560 380 171 923

381 348 573 533 447 632 387 176 975 449

223 711 445 645 245 543 931 532 937 541 444

330 131 333 928 377 733 017 778 839 168 197 197

131 171 522 137 217 224 291 413 528 520 227 229 928

223 626 034 683 839 53  627 310 713 999 629 817 410 121

924 622 911 233 325 139 721 218 253 223 107 233 230 124 233





*SOLUTION*

Used only a basic Integer ArrayList for solution; 
For reach each element of the Pyramid using a Tree algorithm  like DFS(Depth First Search ).
Left and right side sub-pyramid root element is found with the index mapping and recursion is deployed for the each sub pyramid and 
Algorithm each sub-recursion  returned the max sum of the sub_pyramid.


