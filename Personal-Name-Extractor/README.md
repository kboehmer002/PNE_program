# Personal Name Extractor

CS350, Old Dominion Univ., Spring 2022

Group 1

* [Stories](https://trello.com/b/CraKZi2U/personal-name-extractor)
* [Reports Webpage](https://cs.odu.edu/~cs_jpete020/reports/home.html)

# Commands
## PNE Training
`gradle -q run --args="secretTrainingPassword123" < src\main\resources\trainFileName.txt > src\main\resources\output.txt`

## Run PNE
`gradle -q run < src\main\resources\testFile.txt > src\main\resources\output.txt`

# Design
[Design Notes](https://www.cs.odu.edu/~tkennedy/cs350/latest/Protected/nameExtractionDesignNotes/)
```
@startuml
left to right direction

hide empty members

class Cataloger{

  Cataloger()

  void processInputDoc();
}

class Extractor{
  const Int K = 5
  String markPersonalNames(Block block)
  Boolean shingling(Collection<string> tempWindow)
}

class Trainer{
  void trainCataloger(Block block)
}

class Block{
  String rawBlock
  Collection<Token> tokens
}

class Token{
  String rawToken
  Classification nameClassification
  FeatureSet features
}

class FeatureSet{
  merge()
}

class Classification{
}

Cataloger *----- Extractor
Cataloger *----- Trainer




@enduml
}
```
