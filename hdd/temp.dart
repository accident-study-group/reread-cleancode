class Solution {
  List<String> findWords(List<List<String>> board, List<String> words) {

    // 효율적으로 시작점을 찾을 수 있도록해주는 Set
    Map<String, List<Position>> firstCharacterOfWordsPosition = {};

    List<String> answer = [];

    for(int i = 0; i<words.length; i++){
      firstCharacterOfWordsPosition.addAll({words[i][0]:[]});
    }

    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[i].length; j++){
        if(firstCharacterOfWordsPosition.keys.contains(board[i][j])){
          firstCharacterOfWordsPosition[board[i][j]]?.add(Position(j,i));
        }
      }
    }

    for(int i = 0; i < words.length; i++){
      List<Position> firstCharectrorPositions = firstCharacterOfWordsPosition[words[i][0]]!;

      for(int j = 0; j < firstCharectrorPositions.length; j++){
        if(functionName(board, {}, firstCharectrorPositions[j], words[i], 1)){
          answer.add(words[i]);
          break;
        }
      }
    }


    return answer;

  }

  bool functionName(List<List<String>> board,Set<Position> history, Position nowPosition, String word, int nextIndex){
    if(nextIndex == word.length) return true;

    // X가 마지막이 아니라면 오른쪽으로 간다.
    if(nowPosition.x < board[nowPosition.y].length -1){
      if(!history.contains(Position(nowPosition.x+1, nowPosition.y))
          && board[nowPosition.y][nowPosition.x+1] == word[nextIndex]){
        history.add(nowPosition);
        if(functionName(board,history, Position(nowPosition.x+1, nowPosition.y), word, nextIndex+1)){
          return true;
        }
      }
    }

    if(nowPosition.y < board.length - 1){
      if(!history.contains(Position(nowPosition.x, nowPosition.y+1))
          && board[nowPosition.y + 1][nowPosition.x] == word[nextIndex]){
        history.add(nowPosition);
        if(functionName(board,history, Position(nowPosition.x, nowPosition.y+1), word, nextIndex+1)){
          return true;
        }
      }
    }

    if(nowPosition.x > 0){
      if(!history.contains(Position(nowPosition.x-1, nowPosition.y))
          && board[nowPosition.y][nowPosition.x-1] == word[nextIndex]){
        history.add(nowPosition);
        if(functionName(board,history, Position(nowPosition.x -1, nowPosition.y), word, nextIndex+1)){
          return true;
        }
      }
    }

    if(nowPosition.y > 0){
      if(!history.contains(Position(nowPosition.x, nowPosition.y-1))
          && board[nowPosition.y -1][nowPosition.x] == word[nextIndex]){
        history.add(nowPosition);
        if(functionName(board,history, Position(nowPosition.x, nowPosition.y-1), word, nextIndex+1)){
          return true;
        }
      }
    }

    return false;
  }

}


class Position {
  final int x;
  final int y;

  const Position(this.x, this.y);

  String toString() => "($x,$y)";  @override

  bool operator ==(Object other) =>
      other is Position &&
          x == other.x &&
          y == other.y;

  @override
  int get hashCode => x.hashCode ^ y.hashCode;
}