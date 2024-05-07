def is_safe(board, row, col, n):
    for i in range(row):
        if board[i][col] == 1:
            return False

    for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    for i, j in zip(range(row, -1, -1), range(col, n)):
        if board[i][j] == 1:
            return False

    return True


def solve_n_queens(board, row, n):
    if row >= n:
        return True

    for i in range(n):
        if is_safe(board, row, i, n):
            board[row][i] = 1
            if solve_n_queens(board, row + 1, n):
                return True
            board[row][i] = 0

    return False


def print_board(board):
    for row in board:
        print(" ".join(map(str, row)))


def main():
    n = int(input("Enter the number of queens (n): "))
    board = [[0] * n for _ in range(n)]

    if solve_n_queens(board, 0, n):
        print("Solution exists! One possible arrangement is:")
        print_board(board)
    else:
        print("No solution exists for this configuration.")


if __name__ == "__main__":
    main()
