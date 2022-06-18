# TheaterTickets
Zinc 2018 Challenge from codilit.com
https://app.codility.com/demo/results/training7AMFGZ-E3Z/

Thats my take to this challenge. Score for this code is 100%.

Given an n-element sequence of numbers a = (a1, a2, ..., an) ranging from 1 to n. 
Calculates how many different members of substrings in three a? Two substrings that 
are available are different if they differ at least one element. Example (1,2,1,1) have three 
different substrings: (1,2,1) (occurring two), (1,1,1,1) (occurring once) and 
(2,1,1) ( occurring once).

Let a [l:p]  mean al ,al+1 ,...,ap .

## Solution O (n)
First, for each prefix, let's count how many different values (single-element substrings) it 
contains. Let implikant1[i] denote this value for the i-element prefix, i.e. a[1-i]. We will plot the results in order 
of increasing length of the prefixes. Of course implikant1[i] = 1 (we only have one element). Now let's 
consider how to find implikant1[i] for  i> 1. If ai occurred before then implikant1 [i] = implikant1 [i− 1]. Otherwise 
implikant1 [i] = implikant1 [i− 1] + 1. We can use a counting table to check if ai occurred before.

Now let's move on to calculating implikant2. As before, we will calculate the values of this array from 
the shortest to the longest prefixes. Additionally, let pop [x] for  1⩽ x ⩽n denote the number of 
the last item in the reviewed items where x occurs.

First, for a single-element prefix we set implikant2 [1] = 0 (there are no two-element substrings) and write the 
information pop [a1] = 1 (the last occurrence of a1 at position number 1). Then we browse through the next prefixes. 
Suppose we calculate implikant2[i] for i> 1. Well,implikant2[i] to implikant2[i− 1] increased by the number of such 
two-element substrings ai, and which do not appear in ai-1.  The searched substrings are of the form (x, ai) - the 
second element has the value ai. All of these substrings in ai are implikant2[i− 1], because there are so many ways 
to choose x. But we should subtract the substrings that also appear in ai-1 If ai occurs for the first time, then we 
dont need to subtract. If, on the other hand, ai appeared before, let's take its previous occurrence as pop [ai]. 
Note that it is the second element of P1 [pop [ai] - 1] substrings (there are so many ways to select the element 
standing before the previous occurrence of a i). So we got that: 


### implikant2[i] = implikant2[i −1] + implikant1[i −1] - implikant1[pop [ai] - 1]


After computing 
implikant2[i] we update pop [ai] = i.


Now let's move on to determining the number of different three-element substrings a. We will count in groups taking 
into account the value of the last element. Well, let's count how many substrings there are, the last element of which is 
1,2, ..., n, respectively, and finally we sum these results. Let us consider how for the fixed z we find the number of 
different substrings in a of the form (x, y, z) for 1⩽ y ⩽n. If z does not appear in a, then there are no such substrings. 
Otherwise, let's take the last occurrence of z in a, which is at position pop [z]. The third element is fixed, and the first 
two elements can be selected in implikant2 [pop[z] - 1] ways, which is equal to the number of different three-element 
substrings ending in z. The total number of three-element substrings is z 
### from 1 to n implikant2[pop [z] - 1] 
which we can calculate in O (n) knowing implikant2.

Orginal explanation in polish on site :
http://www.deltami.edu.pl/temat/informatyka/algorytmy/2020/03/29/theater-tickets/
