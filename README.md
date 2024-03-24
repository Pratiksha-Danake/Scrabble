## Scrabble
#### Enum Multiplier
    - ZERO
    - DOUBLE
    - TRIPLE
    
#### class InvalidInputWordException 
    - custom exception class to throw user defined exception for invalid word

#### class PointAllocator
##### state
    - final private Map<Integer, List<Character>> scores
##### Behaviours
    - public Map<Integer, List<Character>> getScores()

#### class ScoreCalculator
##### state
    - PointAllocator pointAllocator
##### Behaviours
    - public int calculateWordScore(String word, Multiplier letterMultiplier, char letterToMultiplyScore, Multiplier wordMultiplier)
    - private int calculateCharacterScore(Character ch, Multiplier letterMultiplier)
    
#### class Scrabble
##### state
    - ScoreCalculator scoreCalculator
##### Behaviours
    - public int getScoreForWord(String word, Multiplier letterMultiplier, char letterToMultiplyScore, Multiplier wordMultiplier) throws InvalidInputWordException




