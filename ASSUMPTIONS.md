# Assumptions

* We use Int to represent the value of the nodes in the triangle. 
  It could as well be Float, or any type that can be summed and compared
* It's a triangle. We know that each row has 1 more element than the previous row.
* We convert the numbers into "triangles", starting from the bottom row
  and working our way up to the root. As we go, we compute the cost
  associated to each triangle
* The costs of the nodes in the bottom row is simply the value
  associated with that node
* The cost of non-bottom nodes is the cost of the "cheapest" child,
  plus the value of the node itself
* We use a greedy algorithm to determine the minimal path, navigating
  from the root, picking at each step the child with the smallest cost
