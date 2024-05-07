import heapq


class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.graph = [[] for _ in range(vertices)]

    def add_edge(self, u, v, weight):
        self.graph[u].append((v, weight))
        self.graph[v].append((u, weight))

    def prim_mst(self):
        pq = []
        mst = []
        visited = set()

        start_vertex = int(
            input("Enter the starting vertex (0 to {}): ".format(self.vertices - 1)))
        if start_vertex < 0 or start_vertex >= self.vertices:
            print("Invalid starting vertex.")
            return []

        for neighbor, weight in self.graph[start_vertex]:
            heapq.heappush(pq, (weight, start_vertex, neighbor))

        visited.add(start_vertex)

        while pq:
            weight, u, v = heapq.heappop(pq)
            if v not in visited:
                visited.add(v)
                mst.append((u, v, weight))
                for neighbor, weight in self.graph[v]:
                    heapq.heappush(pq, (weight, v, neighbor))

        return mst


num_vertices = int(input("Enter the number of vertices: "))

g = Graph(num_vertices)

num_edges = int(input("Enter the number of edges: "))
for _ in range(num_edges):
    u, v, weight = map(int, input("Enter edge (u v weight): ").split())
    g.add_edge(u, v, weight)

minimum_spanning_tree = g.prim_mst()

if minimum_spanning_tree:
    print("\nMinimum Spanning Tree:")
    for edge in minimum_spanning_tree:
        print(f"Edge: {edge[0]} - {edge[1]}, Weight: {edge[2]}")
else:
    print("Invalid input or graph disconnected.")
