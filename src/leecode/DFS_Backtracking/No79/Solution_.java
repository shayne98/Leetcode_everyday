package leecode.BFS_DFS.No79;

/**
 * @author 小羊Shaun
 * @version 1.0
 */

class Solution_ {
    public boolean exist(char[][] board, String word) {
        int rowMax = board.length - 1;      // Highest row index.
        int colMax = board[0].length - 1;   // Highest column index.
        char[] wordC = word.toCharArray();  // word String converted to char[].
        char firstLetter = wordC[0];        // First letter of the word

        // If the word is too long to possibly fit on the board, then
        // immediately return false.
        if (wordC.length > (rowMax + 1) * (colMax + 1))  return false;

        // Build a bit mask 'boardLetters' of all letters in the board.  This
        // bitmask will be used later to check if all letters in the word,
        // exist within the board.  If any letter in the word is not in the
        // board then quickly return a false, without any searching the board.
        //
        // Also build a matrix boardLetters[][] which has the same dimensions
        // as the board, but contains bit masks that indicate which letters
        // are in the surrounding squares of the board.  This will speed-up
        // the search by determining if any surrounding squares contain the
        // next letter of the word, BEFORE having to look in the surrounding
        // squares.
        //
        // Since this leetcode problem allows both uppercase and lowercase
        // letters, both types of bitmasks must be long variables.  The long
        // variables are 64-bits so they can contain a bit for each of the
        // 52 letters (26 uppercase + 26 lowercase = 52 letters and so we
        // need more than the 32-bits of an int variable).  The "1L <<" in
        // some of the expressions in the code below, forces the "<<"
        // shift-left operation to be a long, because the "L" after the
        // "1" indicates that the "1" is a long constant.  The "1" could also
        // be made a long by "(long)1" to cast the "1" to be a long.  Without
        // either of these methods indicating the "1" is a long, the code
        // will perform the "<<" shift-left operation as a 32-bit int and the
        // code would fail.
        long[][] nextLetters = new long[rowMax + 1][colMax + 1];
        // Bit-masks of letters in surrounding board squares.
        long boardLetters = 0;      // Bit-mask of all letters in the board.
        long cBit;
        for (int row = 0; row <= rowMax; row++) {
            for (int col = 0; col <= colMax; col++) {
                cBit = 1L << (board[row][col] - '@');
                boardLetters |= cBit;
                if (row > 0)  nextLetters[row - 1][col] |= cBit;
                if (col > 0)  nextLetters[row][col - 1] |= cBit;
                if (row < rowMax)  nextLetters[row + 1][col] |= cBit;
                if (col < colMax)  nextLetters[row][col + 1] |= cBit;
            }
        }

        // Check to see if all letters in the word exist in the board.
        // If any letters not found in the board, then the word CANNOT exist
        // anywhere in the board so return false.  This skips searching the
        // board when the word cannot be on the board.
        for (int pos = wordC.length - 1; pos >= 0; pos--)
            if (((1L << (wordC[pos] - '@')) & boardLetters) == 0)
                return false;

        // If the word length is only 1 letter, then no search is needed and
        // the word is found.  We previously verified that all letters in the
        // word can be found on the board.  But is the word length is only
        // 1 letter, and that one letter has been previously verified to
        // exist on the board, then the entire 1-letter word exists on the
        // board, and we can return true without any further searching.
        if (wordC.length == 1)  return true;

        // Loop through all squares of the board looking for a square that
        // contains the first letter of the word.  When finding a square
        // with the same letter as the first letter of the word, then start
        // a recursive search for the entire word within the board.
        for (int row = 0; row <= rowMax; row++) {
            for (int col = 0; col <= colMax; col++) {
                if (board[row][col] == firstLetter &&
                        checkWord(row, col, 0, wordC, board, nextLetters))
                    return true;
            }
        }
        return false;
    }


    // Recursive method to check if the current letter in the word is
    // found at the current board position.  If found, then call
    // this method recursively to check the surrounding squares of the
    // board for the next letter, or if at end of word, then return true
    // to show the entire word was found in the board.
    //
    // During recursion, after matching a letter from the word with a
    // letter from the board, then temporarily replace that letter in
    // the board with a "*" so that the square of the board can't be
    // used again if the same letter occurs later in the word.  When
    // returning from recursion, replace the "*" with the letter that
    // was originally in that square of the board.
    private boolean checkWord(int row, int col, int pos, char[] wordC,
                              char[][] board, long[][] nextLetters)  {
        if (row < 0 || row >= board.length ||
                col < 0 || col >= board[0].length)
            return false;           // If current board square is outside
        //   the boundary of the board, then
        //   not a valid search path.
        char c = board[row][col];   // Get current board letter.
        if (wordC[pos++] != c)  return false;
        // If current letter from word does
        //   not match current board square,
        //   then word not on this search path.
        if (pos == wordC.length)  return true;
        // If end of word, then word found!!!
        if ((1L << (wordC[pos] - '@') & nextLetters[row][col]) == 0)
            return false;           // If next letter from word not in any
        //   surrounding square, then no match.
        board[row][col] = '*';      // Temporarily replace square with "*".
        // board[row][col] ^= 128;      // Temporarily mark square as used.
        if (checkWord(row, col+1, pos, wordC, board, nextLetters) ||
                checkWord(row, col-1, pos, wordC, board, nextLetters) ||
                checkWord(row+1, col, pos, wordC, board, nextLetters) ||
                checkWord(row-1, col, pos, wordC, board, nextLetters))
            return true;            // Recurse to check surrounding squares
        //   for remainder of the word.  Return
        //   true if entire word found in board.
        board[row][col] = c;        // Restore square with original letter.
        // board[row][col] ^= 128;        // Restore square to unused.
        return false;               // Word not found on this search path.
    }
}