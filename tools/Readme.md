### tools

#### diff.py

use example

`python diff.py fileName tag`

```
tools
|-- Readme.md 
|-- data.txt 
`-- diff.py 
```

data.txt content

```

leetcode inputs and result

tag1
["Skiplist","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","add","search","add","search","add","search","add","add","search","search","erase","search","erase","erase","erase","erase","erase","erase","erase","add","erase","erase","erase","search","erase","add","erase","erase","erase","add","erase","search","erase","erase","add","search","add","erase","add","erase","add","erase","erase","search","add","search","erase","erase","erase","add","erase","erase","search","add","erase","search","search","erase","add","add","add","search","search","search","erase","erase","erase","add","search","add","search","erase","erase","search","erase","add","search","add","add","erase","search","erase","erase","search","erase","add","erase","add","erase","erase","erase","search","search","search","search","erase","search","search","search","search","add","search","add","add","add","add","add","search","add","search","erase","search","add","add","search","add","search","search","search","search","search","search","search","search","search","search","search","search","search","search","search","search","search","search","search","search","search","search","search"]
[[],[10],[13],[2],[13],[0],[37],[0],[3],[16],[25],[32],[27],[18],[1],[6],[5],[10],[41],[10],[33],[14],[33],[2],[5],[18],[33],[38],[13],[16],[11],[38],[33],[34],[11],[0],[33],[22],[15],[30],[39],[34],[3],[20],[5],[24],[35],[0],[3],[42],[41],[2],[21],[26],[41],[20],[25],[30],[43],[2],[39],[16],[21],[34],[37],[24],[23],[32],[11],[32],[23],[22],[19],[28],[21],[18],[27],[20],[19],[22],[33],[44],[27],[20],[1],[12],[37],[36],[23],[32],[19],[14],[43],[22],[33],[26],[45],[40],[15],[28],[31],[26],[3],[4],[21],[10],[27],[14],[17],[4],[5],[26],[25],[32],[41],[20],[37],[8],[13],[34],[19],[0],[39],[18],[19],[14],[31],[4],[5],[28],[37],[4],[17],[8],[13],[0],[21],[42],[7],[34],[7],[28],[7],[2],[33],[34],[45],[22],[25],[34],[45],[28],[43],[20],[45],[20],[19],[16],[11],[38],[25],[0]]
[null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,true,null,true,null,true,null,null,true,true,false,true,true,true,false,false,false,false,false,null,false,true,false,false,true,null,false,true,true,null,false,false,false,true,null,false,null,false,null,true,null,true,false,false,null,true,true,false,false,null,false,false,true,null,false,true,false,true,null,null,null,true,false,false,false,false,true,null,true,null,false,true,false,false,false,null,false,null,null,true,false,false,true,true,true,null,false,null,true,false,false,false,true,false,false,true,true,true,true,false,null,true,null,null,null,null,null,false,null,true,false,true,null,null,false,null,true,true,true,true,true,true,true,false,false,false,true,false,true,true,true,false,true,true,true,true,true,false,true]
[null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,true,null,true,null,true,null,null,true,true,false,true,true,true,false,false,false,false,false,null,false,true,false,false,true,null,false,true,true,null,false,false,false,true,null,false,null,false,null,true,null,true,false,false,null,true,true,false,false,null,false,false,true,null,false,true,false,true,null,null,null,true,false,false,false,false,true,null,true,null,false,false,false,false,false,null,false,null,null,true,false,false,true,true,true,null,false,null,true,false,false,false,true,false,false,true,true,true,false,false,null,true,null,null,null,null,null,false,null,true,false,true,null,null,false,null,true,true,true,true,true,false,true,false,false,false,true,false,true,true,true,false,true,true,true,true,true,false,true]

```



```bash

python project/tools/diff.py  project/tools/data.txt tag1

```
result content

```
 000       null       null "Skiplist"         [] 
 001       null       null      "add"       [10] 
 002       null       null      "add"       [13] 
 003       null       null      "add"        [2] 
 004       null       null      "add"       [13] 
 005       null       null      "add"        [0] 
 006       null       null      "add"       [37] 
 007       null       null      "add"        [0] 
 008       null       null      "add"        [3] 
 009       null       null      "add"       [16] 
 010       null       null      "add"       [25] 
 011       null       null      "add"       [32] 
 012       null       null      "add"       [27] 
 013       null       null      "add"       [18] 
 014       null       null      "add"        [1] 
 015       null       null      "add"        [6] 
 016       null       null      "add"        [5] 
 017       null       null      "add"       [10] 
 018       null       null      "add"       [41] 
 019       null       null      "add"       [10] 
 020       null       null      "add"       [33] 
 021       null       null      "add"       [14] 
 022       null       null      "add"       [33] 
 023       null       null      "add"        [2] 
 024       true       true   "search"        [5] 
 025       null       null      "add"       [18] 
 026       true       true   "search"       [33] 
 027       null       null      "add"       [38] 
 028       true       true   "search"       [13] 
 029       null       null      "add"       [16] 
 030       null       null      "add"       [11] 
 031       true       true   "search"       [38] 
 032       true       true   "search"       [33] 
 033      false      false    "erase"       [34] 
 034       true       true   "search"       [11] 
 035       true       true    "erase"        [0] 
 036       true       true    "erase"       [33] 
 037      false      false    "erase"       [22] 
 038      false      false    "erase"       [15] 
 039      false      false    "erase"       [30] 
 040      false      false    "erase"       [39] 
 041      false      false    "erase"       [34] 
 042       null       null      "add"        [3] 
 043      false      false    "erase"       [20] 
 044       true       true    "erase"        [5] 
 045      false      false    "erase"       [24] 
 046      false      false   "search"       [35] 
 047       true       true    "erase"        [0] 
 048       null       null      "add"        [3] 
 049      false      false    "erase"       [42] 
 050       true       true    "erase"       [41] 
 051       true       true    "erase"        [2] 
 052       null       null      "add"       [21] 
 053      false      false    "erase"       [26] 
 054      false      false   "search"       [41] 
 055      false      false    "erase"       [20] 
 056       true       true    "erase"       [25] 
 057       null       null      "add"       [30] 
 058      false      false   "search"       [43] 
 059       null       null      "add"        [2] 
 060      false      false    "erase"       [39] 
 061       null       null      "add"       [16] 
 062       true       true    "erase"       [21] 
 063       null       null      "add"       [34] 
 064       true       true    "erase"       [37] 
 065      false      false    "erase"       [24] 
 066      false      false   "search"       [23] 
 067       null       null      "add"       [32] 
 068       true       true   "search"       [11] 
 069       true       true    "erase"       [32] 
 070      false      false    "erase"       [23] 
 071      false      false    "erase"       [22] 
 072       null       null      "add"       [19] 
 073      false      false    "erase"       [28] 
 074      false      false    "erase"       [21] 
 075       true       true   "search"       [18] 
 076       null       null      "add"       [27] 
 077      false      false    "erase"       [20] 
 078       true       true   "search"       [19] 
 079      false      false   "search"       [22] 
 080       true       true    "erase"       [33] 
 081       null       null      "add"       [44] 
 082       null       null      "add"       [27] 
 083       null       null      "add"       [20] 
 084       true       true   "search"        [1] 
 085      false      false   "search"       [12] 
 086      false      false   "search"       [37] 
 087      false      false    "erase"       [36] 
 088      false      false    "erase"       [23] 
 089       true       true    "erase"       [32] 
 090       null       null      "add"       [19] 
 091       true       true   "search"       [14] 
 092       null       null      "add"       [43] 
 093      false      false   "search"       [22] 
 094       true      false    "erase"       [33] *    <---- difference
 095      false      false    "erase"       [26] 
 096      false      false   "search"       [45] 
 097      false      false    "erase"       [40] 
 098       null       null      "add"       [15] 
 099      false      false   "search"       [28] 
 100       null       null      "add"       [31] 
 101       null       null      "add"       [26] 
 102       true       true    "erase"        [3] 
 103      false      false   "search"        [4] 
 104      false      false    "erase"       [21] 
 105       true       true    "erase"       [10] 
 106       true       true   "search"       [27] 
 107       true       true    "erase"       [14] 
 108       null       null      "add"       [17] 
 109      false      false    "erase"        [4] 
 110       null       null      "add"        [5] 
 111       true       true    "erase"       [26] 
 112      false      false    "erase"       [25] 
 113      false      false    "erase"       [32] 
 114      false      false   "search"       [41] 
 115       true       true   "search"       [20] 
 116      false      false   "search"       [37] 
 117      false      false   "search"        [8] 
 118       true       true    "erase"       [13] 
 119       true       true   "search"       [34] 
 120       true       true   "search"       [19] 
 121       true      false   "search"        [0] *   <--- difference
 122      false      false   "search"       [39] 
 123       null       null      "add"       [18] 
 124       true       true   "search"       [19] 
 125       null       null      "add"       [14] 
 126       null       null      "add"       [31] 
 127       null       null      "add"        [4] 
 128       null       null      "add"        [5] 
 129       null       null      "add"       [28] 
 130      false      false   "search"       [37] 
 131       null       null      "add"        [4] 
 132       true       true   "search"       [17] 
 133      false      false    "erase"        [8] 
 134       true       true   "search"       [13] 
 135       null       null      "add"        [0] 
 136       null       null      "add"       [21] 
 137      false      false   "search"       [42] 
 138       null       null      "add"        [7] 
 139       true       true   "search"       [34] 
 140       true       true   "search"        [7] 
 141       true       true   "search"       [28] 
 142       true       true   "search"        [7] 
 143       true       true   "search"        [2] 
 144       true      false   "search"       [33] *  <---- difference
 145       true       true   "search"       [34] 
 146      false      false   "search"       [45] 
 147      false      false   "search"       [22] 
 148      false      false   "search"       [25] 
 149       true       true   "search"       [34] 
 150      false      false   "search"       [45] 
 151       true       true   "search"       [28] 
 152       true       true   "search"       [43] 
 153       true       true   "search"       [20] 
 154      false      false   "search"       [45] 
 155       true       true   "search"       [20] 
 156       true       true   "search"       [19] 
 157       true       true   "search"       [16] 
 158       true       true   "search"       [11] 
 159       true       true   "search"       [38] 
 160      false      false   "search"       [25] 
 161      true]      true]  "search"]       [0]] 

```