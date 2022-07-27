#py
import itertools
import sys

def toList(source: str) -> list[str]:
  removeHeadAndTail = source[1 : len(source) - 1]
  return list(itertools.takewhile(lambda x : len(str.strip(x)) > 0, removeHeadAndTail.split(",")))

def getDiff(a : str, b : str, ops : str, opsData : str) -> list:
  lsA = toList(a)
  lsB = toList(b)
  lsOps = toList(ops)
  lsOpsD = toList(opsData)
  ans = []
  minLen = min(len(lsA), len(lsB))
  for index in range(0, min(len(lsA), len(lsB))):
    ans.append(DiffRes(lsA[index], lsB[index], index, lsOps[index], lsOpsD[index], lsA[index] == lsB[index]))
    # if lsA[index] != lsB[index]:
    #   ans.append(DiffRes(lsA[index], lsB[index], index, lsOps[index], lsOpsD[index]))
  for i in range(minLen, len(lsA)):
    ans.append(DiffRes(lsA[i], "~~", i, lsOps[index], lsOpsD[index]))
  for i in range(minLen, len(lsB)):
    ans.append(DiffRes("~~", lsB[i], i, lsOps[index], lsOpsD[index]))
  return ans

class DiffRes:
  def __init__(self, a : str, b : str , index : int, op : str, opData : str, same : bool) -> None:
    self.a = a
    self.b = b
    self.index = index
    self.op = op
    self.opData = opData
    self.same = same

  def __str__(self) -> str:
    return f"{self.index : 04} {self.a : >10} {self.b: >10} {self.op: >10} {self.opData: >10} { '' if self.same else '*'}"

def getData(file : str, tag : str) :
  ans = []
  read = False
  count = 0
  with open(file, mode="r", encoding="utf-8") as f :
    for line in f.readlines():
      if read  and count < 4:
        ans.append(line)
        count += 1
      if read and count >= 4:
        break
      if not read and line.strip() == tag.strip():
        read = True
  return ans

def showDiff(file : str, tag : str):
  data = getData(file, tag)
  diffs = getDiff(data[2], data[3], data[0], data[1])
  for el in diffs:
    print(el)

if __name__ == "__main__":
  if len(sys.argv) < 3 : 
    print("param too short")
  else :
    file = sys.argv[1]
    tag = sys.argv[2]
    showDiff(file, tag)