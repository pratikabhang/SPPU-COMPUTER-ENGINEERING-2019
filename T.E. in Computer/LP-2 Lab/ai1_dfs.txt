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

    def dfs_recursive(self, v, visited):
        visited[v] = True
        print(v, end=' ')

        for neighbor in self.graph[v]:
            if not visited[neighbor]:
                self.dfs_recursive(neighbor, visited)

    def dfs(self, start):
        visited = {vertex: False for vertex in self.graph}
        self.dfs_recursive(start, visited)
        print()


num_vertices = int(input("Enter the number of vertices: "))
num_edges = int(input("Enter the number of edges: "))
g = Graph()
for i in range(num_edges):
    u, v = map(int, input("Enter edge (u v): ").split())
    g.add_edge(u, v)
start_vertex = int(input("Enter the starting vertex for DFS: "))
print(f"DFS starting from vertex {start_vertex}:")
g.dfs(start_vertex)
