import heapq


class TicTacToeNode:
    def __init__(self, board, player, move=None):
        self.board = board
        self.player = player
        self.move = move

    def __lt__(self, other):
        return heuristic(self.board, self.player) < heuristic(other.board, other.player)


def print_board(board):
    for row in board:
        print(" ".join(row))
    print()


def is_winner(board, player):
    for i in range(3):
        if all(cell == player for cell in board[i]) or all(board[j][i] == player for j in range(3)):
            return True
    if all(board[i][i] == player for i in range(3)) or all(board[i][2 - i] == player for i in range(3)):
        return True
    return False


def is_board_full(board):
    return all(cell != ' ' for row in board for cell in row)


def game_over(board):
    for player in ['X', 'O']:
        if is_winner(board, player):
            return True, player
    if is_board_full(board):
        return True, 'Tie'
    return False, None


def heuristic(board, player):
    score = 0
    for i in range(3):
        for j in range(3):
            if board[i][j] == 'O':
                score += 1
            elif board[i][j] == 'X':
                score -= 1
    return score


def a_star_search(initial_node):
    open_set = []
    closed_set = set()

    heapq.heappush(open_set, (heuristic(
        initial_node.board, initial_node.player), initial_node))

    while open_set:
        _, current_node = heapq.heappop(open_set)

        if game_over(current_node.board)[0]:
            return current_node

        closed_set.add(tuple(map(tuple, current_node.board)))

        for i in range(3):
            for j in range(3):
                if current_node.board[i][j] == ' ':
                    new_board = [row[:] for row in current_node.board]
                    new_board[i][j] = current_node.player
                    new_player = 'X' if current_node.player == 'O' else 'O'
                    child_node = TicTacToeNode(
                        new_board, new_player, move=(i, j))

                    board_state = tuple(map(tuple, child_node.board))
                    if board_state not in closed_set:
                        heapq.heappush(open_set, (heuristic(
                            child_node.board, child_node.player), child_node))
                        closed_set.add(board_state)

    return None


def play_tic_tac_toe():
    board = [[' ' for _ in range(3)] for _ in range(3)]

    while not game_over(board)[0]:
        print_board(board)

        row = int(input("Enter row (1, 2, or 3):")) - 1
        col = int(input("Enter column (1, 2, or 3):")) - 1

        if row not in range(3) or col not in range(3):
            print(
                "Invalid input. Please enter a number between 1 and 3 for both row and column.")
            continue

        if board[row][col] == ' ':
            board[row][col] = 'X'
        else:
            print("Already occupied. Try again.")
            continue

        if game_over(board)[0]:
            break

        print("Move:")
        ai_node = a_star_search(TicTacToeNode(board, 'O'))
        ai_row, ai_col = ai_node.move
        board[ai_row][ai_col] = 'O'

    print_board(board)
    result = game_over(board)[1]
    if result == 'Tie':
        print("It's a tie!")
    else:
        print(f"{result} Wins!")


if __name__ == "__main__":
    play_tic_tac_toe()
