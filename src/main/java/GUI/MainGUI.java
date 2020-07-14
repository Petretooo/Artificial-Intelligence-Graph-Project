package GUI;

import Algorithms.BreadFirstSearch;
import Algorithms.DepthFirstSearch;
import Algorithms.SearchByCoordinates;
import Algorithms.SearchByCoordinatesAndWeigth;
import App.Graph;
import App.Node;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Map;

public class MainGUI extends JFrame {
    Graph graph = new Graph();
    void input(){

//        graph.addNode(new Node("A", 0, 10, 1));
//        graph.addNode(new Node("B", 20, 10, 1));
//        graph.addNode(new Node("C", 30, 20, 1));
//        graph.addNode(new Node("D", 10, 0, 1));
//        graph.addNode(new Node("E", 30, 0, 1));
//        graph.addNode(new Node("F", 40, 10, 1));
//
//
//        graph.addLink("A", "C", true);
//        graph.addLink("A", "D", true);
//        graph.addLink("A", "B", true);
//        graph.addLink("D", "E", true);
//        graph.addLink("F", "C", true);
//        graph.addLink("F", "B", true);
//        graph.addLink("F", "E", true);



//        graph.addNode(new Node("A", 8,13, 25));
//        graph.addNode(new Node("B", 22,13, 15));
//        graph.addNode(new Node("C", 24,13, 15));
//        graph.addNode(new Node("D", 0,6, 20));
//        graph.addNode(new Node("E", 6,6, 13));
//        graph.addNode(new Node("F", 12,6, 30));
//        graph.addNode(new Node("G", 19,6, 30));
//        graph.addNode(new Node("H", 23,6, 30));
//        graph.addNode(new Node("I", 28,6, 30));
//        graph.addNode(new Node("J", 8,0,17));
//        graph.addNode(new Node("K", 20,0, 21));
//        graph.addNode(new Node("L", 24,0, 42));
//
//        graph.addLink("A", "D", true);
//        graph.addLink("A", "F", true);
//        graph.addLink("A", "B", true);
//        graph.addLink("B", "C", true);
//        graph.addLink("B", "G", true);
//        graph.addLink("C", "I", true);
//        graph.addLink("D", "E", true);
//        graph.addLink("D", "J", true);
//        graph.addLink("E", "J", true);
//        graph.addLink("F", "G", true);
//        graph.addLink("F", "J", true);
//        graph.addLink("G", "H", true);
//        graph.addLink("G", "K", true);
//        graph.addLink("G", "L", true);
//        graph.addLink("H", "L", true);
//        graph.addLink("H", "I", true);
//        graph.addLink("I", "L", true);
//        graph.addLink("J", "K", true);
//        graph.addLink("K", "L", true);



        graph.addNode(new Node("A", 0, 0, 6));
        nodesShow.setText(nodesShow.getText() + "A" + ", ");
        graph.addNode(new Node("B", 1, 3, 8));
        nodesShow.setText(nodesShow.getText() + "B" + ", ");
        graph.addNode(new Node("C", 5, 0, 7));
        nodesShow.setText(nodesShow.getText() + "C" + ", ");
        graph.addNode(new Node("D", 5, 3, 6));
        nodesShow.setText(nodesShow.getText() + "D" + ", ");
        graph.addNode(new Node("G", 5, 6, 6));
        nodesShow.setText(nodesShow.getText() + "G" + ", ");
        graph.addNode(new Node("E", 9, 0, 5));
        nodesShow.setText(nodesShow.getText() + "E" + ", ");
        graph.addNode(new Node("F", 12, 0, 4));
        nodesShow.setText(nodesShow.getText() + "F" + ", ");
        graph.addNode(new Node("I", 9, 6, 8));
        nodesShow.setText(nodesShow.getText() + "I" + ", ");
        graph.addNode(new Node("H", 5, 8, 3));
        nodesShow.setText(nodesShow.getText() + "H" + ", ");

        graph.addLink("A", "B", true);
        model.addRow(new Object[]{"A","B"});
        graph.addLink("A", "D", true);
        model.addRow(new Object[]{"A","D"});
        graph.addLink("A", "C", true);
        model.addRow(new Object[]{"A","C"});
        graph.addLink("B", "G", true);
        model.addRow(new Object[]{"B","G"});
        graph.addLink("D", "G", true);
        model.addRow(new Object[]{"D","G"});
        graph.addLink("D", "C", true);
        model.addRow(new Object[]{"D","C"});
        graph.addLink("C", "E", true);
        model.addRow(new Object[]{"C","E"});
        graph.addLink("E", "F", true);
        model.addRow(new Object[]{"E","F"});
        graph.addLink("E", "H", true);
        model.addRow(new Object[]{"E","H"});
        graph.addLink("F", "I", true);
        model.addRow(new Object[]{"F","I"});
        graph.addLink("I", "H", true);
        model.addRow(new Object[]{"I","H"});


    }







    JTabbedPane pane = new JTabbedPane();
    JPanel graphPanel = new JPanel();

    JPanel leftPanelGraph = new JPanel();
    JPanel rightPanelGraph = new JPanel();
    JPanel rightUpPanel = new JPanel();
    JPanel rightDownPanel = new JPanel();

    JPanel upPanelGraph = new JPanel();
    JPanel midPanelGraph = new JPanel();
    JPanel downPanelGraph = new JPanel();

    JLabel nodeName = new JLabel("Node");
    JLabel coordinateX = new JLabel("Coordinate X");
    JLabel coordinateY = new JLabel("Coordinate Y");
    JLabel weightNode = new JLabel("Weight");

    JLabel firstNodeLabel = new JLabel("From");
    JLabel secondNodeLabel = new JLabel("To");

    JTextField nodeNameTField = new JTextField();
    JTextField coordinateXTField = new JTextField();
    JTextField coordinateYTField = new JTextField();
    JTextField weightNodeTField = new JTextField();

    JTextField firstNodeTField = new JTextField();
    JTextField secondNodeTField = new JTextField();

    DefaultTableModel model = new DefaultTableModel();
    JTable tableNodes = new JTable();
    JScrollPane scrollerNodes = new JScrollPane(tableNodes);

    JButton addButtonNode = new JButton("Add");
    JButton addButtonLink = new JButton("Add link");
    JLabel nodesShow = new JLabel("Nodes: ");


    JLabel algorithmNameLabel = new JLabel("Algorithms");
    JComboBox seachingAlgorithms = new JComboBox();
    JComboBox fromNode = new JComboBox();
    JComboBox toNode = new JComboBox();
    JButton searchButton = new JButton("Search");
    JLabel pathNodes = new JLabel("Path: ");
    JLabel lengthLabel = new JLabel("Length: ");

    JButton resetResultButton = new JButton("Resest Result");
    JButton resetEverything = new JButton("NEW");

    public MainGUI() throws SQLException {
        this.add(pane);

        this.setVisible(true);
        this.setSize(1000,600);

        this.setDefaultCloseOperation(MainGUI.EXIT_ON_CLOSE);

        pane.add(graphPanel, "Graph");

        graphPanel.setLayout(new GridLayout(1,2));
        graphPanel.add(leftPanelGraph, LEFT_ALIGNMENT);
        graphPanel.add(rightPanelGraph, RIGHT_ALIGNMENT);

        leftPanelGraph.setLayout(new GridLayout(2,1));
        leftPanelGraph.add(upPanelGraph);
        leftPanelGraph.add(downPanelGraph);

        upPanelGraph.setLayout(new GridLayout(14,1));
        upPanelGraph.add(nodeName);
        upPanelGraph.add(nodeNameTField);
        upPanelGraph.add(coordinateX);
        upPanelGraph.add(coordinateXTField);
        upPanelGraph.add(coordinateY);
        upPanelGraph.add(coordinateYTField);
        upPanelGraph.add(weightNode);
        upPanelGraph.add(weightNodeTField);

        upPanelGraph.add(addButtonNode);
        addButtonNode.addActionListener(new AddNode());

        upPanelGraph.add(firstNodeLabel);
        upPanelGraph.add(firstNodeTField);
        upPanelGraph.add(secondNodeLabel);
        upPanelGraph.add(secondNodeTField);

        upPanelGraph.add(addButtonLink);
        addButtonLink.addActionListener(new Addlink());

        downPanelGraph.add(algorithmNameLabel);
        downPanelGraph.add(seachingAlgorithms);
        seachingAlgorithms.addItem("");
        seachingAlgorithms.addItem("Bread First Search");
        seachingAlgorithms.addItem("Depth First Search");
        seachingAlgorithms.addItem("Search By Coordinates");
        seachingAlgorithms.addItem("Search By Coordinates and Weigth");
        downPanelGraph.add(fromNode);
        downPanelGraph.add(toNode);
        fromNode.setEnabled(false);
        toNode.setEnabled(false);
        seachingAlgorithms.addActionListener(new UnlockCombos());
        downPanelGraph.add(searchButton);
        searchButton.addActionListener(new Searhing());
        downPanelGraph.add(resetResultButton);
        resetResultButton.addActionListener(new ResetResult());
        downPanelGraph.add(resetEverything);
        resetEverything.addActionListener(new newEverything());

        rightPanelGraph.setLayout(new GridLayout(2,1));
        rightPanelGraph.add(rightUpPanel);
        rightPanelGraph.add(rightDownPanel);
        rightUpPanel.setLayout(new GridLayout(5,1));
        rightUpPanel.add(nodesShow);
        rightUpPanel.add(pathNodes);
        rightUpPanel.add(lengthLabel);

        tableNodes.setModel(model);
        model.addColumn("From");
        model.addColumn("To");
        rightDownPanel.add(scrollerNodes);

        input();


    }

    private class AddNode implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nodeName = nodeNameTField.getText();
            int X = Integer.parseInt(coordinateXTField.getText());
            int Y = Integer.parseInt(coordinateYTField.getText());
            double weight = Double.parseDouble(weightNodeTField.getText());
            Node node = new Node(nodeName, X, Y, weight);
            try {
                graph.addNode(node);
                nodesShow.setText(nodesShow.getText() + nodeName + ", ");
            }catch (IllegalArgumentException | NullPointerException s){
                s.printStackTrace();
            }
            nodeNameTField.setText("");
            coordinateXTField.setText("");
            coordinateYTField.setText("");
            weightNodeTField.setText("");
        }
    }

    private class Addlink implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String from = firstNodeTField.getText();
            String to = secondNodeTField.getText();
            try {
                graph.addLink(from, to, true);
                model.addRow(new Object[]{from,to});
            }catch (NullPointerException s){
                s.printStackTrace();
            }
            tableNodes.setModel(model);

            firstNodeTField.setText("");
            secondNodeTField.setText("");
        }
    }

    private class UnlockCombos implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String algoName = seachingAlgorithms.getSelectedItem().toString();
            if(algoName.equals("")){
                fromNode.setEnabled(false);
                toNode.setEnabled(false);
            }else {
                fillCombos();
                fromNode.setEnabled(true);
                toNode.setEnabled(true);
            }
        }
    }

    private class Searhing implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String algoName = seachingAlgorithms.getSelectedItem().toString();

            if(algoName.equals("Search By Coordinates")){
                SearchByCoordinates byCordinates = new SearchByCoordinates(graph);
                byCordinates.search(fromNode.getSelectedItem().toString(), toNode.getSelectedItem().toString());
                pathNodes.setText(pathNodes.getText() + byCordinates.name);
                lengthLabel.setText(lengthLabel.getText() + byCordinates.length);
                byCordinates.name = "";
                graph.resetGraph();
            }else if(algoName.equals("Bread First Search")){
                BreadFirstSearch bfs = new BreadFirstSearch(graph);
                bfs.search(fromNode.getSelectedItem().toString(), toNode.getSelectedItem().toString());
                bfs.name = new StringBuilder(bfs.name).reverse().toString();
                pathNodes.setText(pathNodes.getText() + bfs.name);
                lengthLabel.setText(lengthLabel.getText() + bfs.length);
                bfs.name = "";
                graph.resetGraph();
            }else if(algoName.equals("Depth First Search")){
                DepthFirstSearch dfp = new DepthFirstSearch(graph);
                dfp.search(fromNode.getSelectedItem().toString(), toNode.getSelectedItem().toString());
                pathNodes.setText(pathNodes.getText() + dfp.name);
                lengthLabel.setText(lengthLabel.getText() + dfp.length);
                dfp.name = "";
                graph.resetGraph();
            }else if(algoName.equals("Search By Coordinates and Weigth")){
                SearchByCoordinatesAndWeigth sbcw = new SearchByCoordinatesAndWeigth(graph);
                sbcw.search(fromNode.getSelectedItem().toString(), toNode.getSelectedItem().toString());
                pathNodes.setText(pathNodes.getText() + sbcw.name);
                lengthLabel.setText(lengthLabel.getText() + sbcw.length);
                sbcw.name = "";
                graph.resetGraph();
            }




        }
    }

    public void fillCombos(){
        fromNode.removeAllItems();
        toNode.removeAllItems();
        for (Map.Entry<String, Node> n: graph.getAllNodes().entrySet()) {
            fromNode.addItem(n.getValue().name);
            toNode.addItem(n.getValue().name);
        }
    }


    private class ResetResult implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            graph.resetGraph();
            pathNodes.setText("Path: ");
            lengthLabel.setText("Length: ");

        }
    }

    private class newEverything implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            graph.resetGraph();
            graph.getAllNodes().clear();
            pathNodes.setText("Path: ");
            nodesShow.setText("Nodes: ");
            lengthLabel.setText("Length: ");
            model = new DefaultTableModel();
            model.addColumn("From");
            model.addColumn("To");
            tableNodes.setModel(model);
        }
    }
}
