/*
 * 
 * 
 * Author 
 * Vaikunth Sridharan
 * 
 * 
 * 
 * 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class ShortestPathAlgorithm {

	private static List<ArrayList<Node>> adjancencyList = new ArrayList<ArrayList<Node>>();
	
	//Display Function
	public static void display(int numNodes, int[] keyDistances, int sourceNode) {

		for (int index = 1; index <= numNodes; index++) {

			if (keyDistances[index] != Integer.MAX_VALUE) {
				System.out.println("Shortest distance from  Source Node "
						+ sourceNode + " to Node " + index + " is: "
						+ keyDistances[index]);
			} else {
				System.out.println("There is no path connecting source node and "
						+ sourceNode + " Node " + index);
			}

		}

	}
	//The Core Algorithm for finding the shortest path
	public static int[] algorithm(int numNodes, int sourceNode) {

		// Here, I use an ArrayList of my nodes and maintain them as another
		// ArrayList

		PriorityQueue<Node> theHeapPriorityQueue = new PriorityQueue<Node>(
				numNodes, new Node());

		boolean[] visitedNodes = new boolean[numNodes + 1];
		int[] keyDistances = new int[numNodes + 1];

		for (int i = 0; i < keyDistances.length; i++) {
			keyDistances[i] = Integer.MAX_VALUE;
		}
		keyDistances[sourceNode] = 0;

		theHeapPriorityQueue.clear();

		theHeapPriorityQueue.add(new Node(sourceNode, 0));
		int nextNODE, weightW;
		for (; !theHeapPriorityQueue.isEmpty();) {

			// Extract the first element
			Node firstHeadNode = theHeapPriorityQueue.poll();
			nextNODE = firstHeadNode.nextNode; // Next node from the HEAP
			weightW = firstHeadNode.nodeCost;// It's Node Cost
			visitedNodes[nextNODE] = true;

			for (int i = 0; i < adjancencyList.get(nextNODE).size(); i++) {

				Node adjNode = adjancencyList.get(nextNODE).get(i);

				// It's next node shouldn't be visited
				if (!visitedNodes[(adjNode.nextNode)]) {
					int nextN = adjNode.nextNode;
					int edgweight = adjNode.nodeCost;
					// Getting the minimal distance by comparison
					if ((weightW + edgweight) < keyDistances[nextN]) {
						keyDistances[nextN] = weightW + edgweight;
					}
					theHeapPriorityQueue.add(new Node(nextN,
							keyDistances[nextN])); // Add to the Priority Queue
				}
			}
		}

		return keyDistances;

	}

	public static void main(String[] args) {
	
		/*
		 * 
		 * Read from command line if source node is not 0 else 0 is the source
		 * node by default
		 */

		int sourceNode = 0;
		double startTime = System.currentTimeMillis();
		// Read my input file
		BufferedReader bufferReader = null;
		try {
			if(args.length >0){
				sourceNode = Integer.parseInt(args[0]);
				bufferReader = new BufferedReader(new FileReader(args[1]));
			
			}
			else
				{
				System.out.println("OOPS!\nERROR : File name not provided as runtime argument\n\nUSAGE : java ShortestPathAlgorithm <sourcenodenumber> <Inputs/FileName.txt>\n\nNOTE  : Explore the input text files under Inputs folder and the source node argument should always be a number");
				
				}
			


		// First line which gives me the number of nodes

		int numNodes = Integer.valueOf(bufferReader.readLine());

		// Initializing the adjancency list of nodes
		for (int i = 0; i <= numNodes; i++) {
			adjancencyList.add(new ArrayList<Node>());
		}

		/*
		 * 
		 * numberOfNodes 
		 * first second third 
		 * .		. 		.
		 * . 		. 		.
		 * . 		.		.
		 * . 		. 		.
		 * . 		.		.
		 * . 		. 		.
		 * . 		. 		.
		 * 
		 * These are the three portions a, b and c which I extract from the
		 * input file
		 */

		while (bufferReader.ready()) {
			// Split the String
			
			String[] portions = bufferReader.readLine().replaceAll("\\s+","//").split("//");
			
			int first = Integer.parseInt(portions[0]);
			int second = Integer.parseInt(portions[1]);
			int third = Integer.parseInt(portions[2]);

			// Store the values in the list
			adjancencyList.get(first).add(new Node(second, third));
		}

		// Close the buffer stream
		bufferReader.close();
		/*
		 * Extract Min & Decrease key is used, the comparable interface helps to
		 * sort the nodes automatically when the first node is removed
		 * eventually the Minimum is extracted
		 * 
		 * If the node is visited then the visited array is updated, and
		 * maintained
		 * 
		 * The key distances are also maintained separately initially it will
		 * SourceNode ----- 0 OtherNodes ----- INFINITY
		 * 
		 * The priority Queue that maintains the minimum distance(Heap
		 * structure)
		 */

		int[] keyDistances = algorithm(numNodes, sourceNode);

		double duration = (System.currentTimeMillis() - startTime);

		display(numNodes, keyDistances, sourceNode);

		System.out.println("Program executed for " + duration / 60
				+ " nanoseconds");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NullPointerException e) {
			
		}
		catch (NumberFormatException e) {
			System.out.println("OOPS!\nERROR : File name not provided as runtime argument\n\nUSAGE : java ShortestPathAlgorithm <sourcenodenumber> <Inputs/FileName.txt>\n\nNOTE  : Explore the input text files under Inputs folder and the source node argument should always be a number");
		}

	}
}

