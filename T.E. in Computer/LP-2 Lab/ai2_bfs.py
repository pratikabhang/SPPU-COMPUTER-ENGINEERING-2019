class Graph:
    def __init__(self):
        self.graph = {}

    def add_edge(self, u, v):
        if u not in self.graph:
            self.graph[u] = []
        if v not in self.graph:
            self.graph[v] = []

        self.graph[u].append(v)
        self.graph[v].append(u)

    def bfs(self, start):
        visited = {vertex: False for vertex in self.graph}
        queue = [start]
        visited[start] = True

        while queue:
            current = queue.pop(0)
            print(current, end=' ')

            for neighbor in self.graph[current]:
                if not visited[neighbor]:
                    queue.append(neighbor)
                    visited[neighbor] = True
        print()


num_vertices = int(input("Enter the number of vertices: "))
num_edges = int(input("Enter the number of edges: "))
g = Graph()

for _ in range(num_edges):
    u, v = map(int, input("Enter edge (u v): ").split())
    g.add_edge(u, v)

start_vertex = int(input("Enter the starting vertex for BFS : "))
print(f"BFS starting from vertex {start_vertex}:")
g.bfs(start_vertex)
