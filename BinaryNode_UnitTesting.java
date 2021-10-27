import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BinaryNode_UnitTesting {

    /**
     * Setting up testing print outputs from methods being tested
     */
    private final ByteArrayOutputStream outputString1 = new ByteArrayOutputStream();
    private final PrintStream defaultOut1 = System.out;
    

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputString1));
    }

    @After
    public void resetStream() {
        System.setOut(defaultOut1);
    }
    // End of setup for testing print outputs

    /**
     * Testing Task 1
     *      Testing postorderTraverse() indirectly
     *      Testing postorderTraverse(BinaryNode<T> node) directly
     *          => Verifying its post order traversal printing
     */

    @Test
    public void postorderTraverse_Testing1() {

        BinaryTree<String> root1 = new BinaryTree<>();
		createTree1_NoTreePrint(root1);
        
        root1.postorderTraverse();

        // Used lineSeperator, normal \n did work, even if strings were identical
        String newLine = System.lineSeparator();
        String expectedTree1 = "D" + newLine + "E" + newLine + "B" + newLine + "G" + newLine + "F" 
        + newLine + "C" + newLine + "A";

        assertEquals(expectedTree1, outputString1.toString().trim());
    }

    @Test
    public void postorderTraverse_Testing2() {

        BinaryTree<String> root2 = new BinaryTree<>();
		createTree2_NoTreePrint(root2);
        
        root2.postorderTraverse();

        // Used lineSeperator, normal \n did work, even if strings were seemingly identical
        String newLine = System.lineSeparator();
        String expectedTree2 = "B" + newLine + "F" + newLine + "D" + newLine + "G" + newLine + "H" 
        + newLine + "E" + newLine + "C" + newLine + "A";

        assertEquals(expectedTree2, outputString1.toString().trim());
    }
    
    @Test
    public void postorderTraverse_binaryNodeMethod_Testing1() {
        
        BinaryTree<String> root1 = new BinaryTree<>();
        createTree1_NoTreePrint(root1);

        root1.postorderTraverse_callBinaryNodeMethod();

        // Used lineSeperator, normal \n did work, even if strings were seemingly identical
        String newLine = System.lineSeparator();
        String expectedTree1 = "D" + newLine + "E" + newLine + "B" + newLine + "G" + newLine + "F" 
        + newLine + "C" + newLine + "A";

        assertEquals(expectedTree1, outputString1.toString().trim());

    }

    @Test
    public void postorderTraverse_binaryNodeMethod_Testing2() {
        
        BinaryTree<String> root2 = new BinaryTree<>();
        createTree2_NoTreePrint(root2);

        root2.postorderTraverse_callBinaryNodeMethod();

        // Used lineSeperator, normal \n did work, even if strings were seemingly identical
        String newLine = System.lineSeparator();
        String expectedTree2 = "B" + newLine + "F" + newLine + "D" + newLine + "G" + newLine + "H" 
        + newLine + "E" + newLine + "C" + newLine + "A";

        assertEquals(expectedTree2, outputString1.toString().trim());

    }

    /**
     * Testing Task 2
     *      Testing getHeight_callBinaryNodeMethod() indirectly
     *      Testing getHeight_binaryNodeMethod()
     *          => Verifying its int height returned
     */

    @Test
    public void getHeight_callBinaryNodeMethod_Testing() {

        BinaryTree<String> root1 = new BinaryTree<>();
        BinaryTree<String> root2 = new BinaryTree<>();

		createTree1_NoTreePrint(root1);
        createTree2_NoTreePrint(root2);

        int expectedHeight1 = 4;
        int expectedHeight2 = 4;

        assertEquals(expectedHeight1, root1.getHeight_callBinaryNodeMethod());
        assertEquals(expectedHeight2, root2.getHeight_callBinaryNodeMethod());


    }

    /**
     * Testing Task 3
     *      Testing getNumberOfNodes() indirectly
     *      Testing getNumberOfNodes(BinaryNode<T> node) directly
     *          => Verifying its int number of nodes returned
     */

    @Test
    public void getNumberOfNodes_Testing() {

        BinaryTree<String> root1 = new BinaryTree<>();
        BinaryTree<String> root2 = new BinaryTree<>();

        createTree1_NoTreePrint(root1);
        createTree2_NoTreePrint(root2);

        int expectedNumNodes1 = 7;
        int expectedNumNodes2 = 8;

        assertEquals(expectedNumNodes1, root1.getNumberOfNodes());
        assertEquals(expectedNumNodes2, root2.getNumberOfNodes());

    }


    /**
     * Testing Task 4
     *      Testing createTree2(BinaryTree<String> tree) from DriverBT.java
     *          => Verifying the tree print of method
     *          => Verifying contents of tree using post order traversal print
     */
    @Test
    public void createTree2_Testing1() {
        
        BinaryTree<String> root1 = new BinaryTree<>();
        DriverBT.createTree2(root1);

        // Used lineSeperator, normal \n did work, even if strings were seemingly identical
        String newLine = System.lineSeparator();

        String expectedTree_Post =
        "Given Tree:\n" + newLine +
		"     A         " + newLine +
		"   /   \\      " + newLine +
		"  B     C      " + newLine +
		"       / \\    " + newLine +
		"      D    E   " + newLine +
		"     /    / \\ " + newLine +
		"    F    G    H";


        //String expectedTree2 = "B" + newLine + "F" + newLine + "D" + newLine + "G" + newLine + "H" 
        //+ newLine + "E" + newLine + "C" + newLine + "A";

        //root.postorderTraverse();

        assertEquals(expectedTree_Post, outputString1.toString().trim());

    }

    @Test
    public void createTree2_Testing2() {

        BinaryTree<String> root2 = new BinaryTree<>();
        DriverBT.createTree2(root2);

        // Used lineSeperator, normal \n did work, even if strings were seemingly identical
        String newLine = System.lineSeparator();
        String expectedTree2 = 
        "Given Tree:\n" + newLine +
		"     A         " + newLine +
		"   /   \\      " + newLine +
		"  B     C      " + newLine +
		"       / \\    " + newLine +
		"      D    E   " + newLine +
		"     /    / \\ " + newLine +
		"    F    G    H" + newLine + newLine +
        "B" + newLine + "F" + newLine + "D" + newLine + "G" + newLine + "H" 
        + newLine + "E" + newLine + "C" + newLine + "A";

        root2.postorderTraverse();

        assertEquals(expectedTree2, outputString1.toString().trim());

    }

    /**
     * Only used by JUnit Tests
     * Creates Tree just like those from driver class, without printing the actual tree
     */

    // Only used for JUnit testing
	private void createTree1_NoTreePrint(BinaryTree<String> tree) {
		// Leaves
		BinaryTree<String> dTree = new BinaryTree<>("D");
		BinaryTree<String> eTree = new BinaryTree<>("E");
		BinaryTree<String> gTree = new BinaryTree<>("G");

		// Subtrees:
		BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
		BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
		BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

		tree.setTree("A", bTree, cTree);
	} // end createTree1_NoTreePrint

    // Only used for JUnit testing
    private void createTree2_NoTreePrint(BinaryTree<String> tree)
	{ 

		// Leaves
		BinaryTree<String> bTree = new BinaryTree<>("B");
		BinaryTree<String> fTree = new BinaryTree<>("F");
		BinaryTree<String> gTree = new BinaryTree<>("G");	
		BinaryTree<String> hTree = new BinaryTree<>("H");

		// Subtrees:
		BinaryTree<String> eTree = new BinaryTree<>("E", gTree, hTree);
		BinaryTree<String> dTree = new BinaryTree<>("D", fTree, null);
		BinaryTree<String> cTree = new BinaryTree<>("C", dTree, eTree);

		tree.setTree("A", bTree, cTree);
	} // end createTree2_NoTreePrint

}
