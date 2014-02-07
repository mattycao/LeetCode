public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length == 0) return false;
        for(int i = 0; i < 9; ++i) {
            boolean[] rValid = {false, false, false, false, false, false, false, false, false};
            for(int j = 0; j < 9; ++j) {
                // for row
                if(!checked(board[i][j], rValid))
                    return false;
            }
            boolean[] cValid = {false, false, false, false, false, false, false, false, false};
            // for column
            for(int j = 0; j < 9; ++j) {
                if(!checked(board[j][i], cValid))
                    return false;
            }
        }
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                boolean[] valid = {false, false, false, false, false, false, false, false, false};
                for(int t = i * 3; t < i * 3 + 3; ++t) {
                    for(int l = j * 3; l < j * 3 + 3; ++l) {
                        if(!checked(board[t][l], valid)) 
                            return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean checked(char num, boolean[] valid) {
        if(num == '.')
            return true;
        if(valid[num - '1'] == true)
            return false;
        else {
            valid[num - '1'] = true;
            return true;
        } 
    }
}