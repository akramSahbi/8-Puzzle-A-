package com.akram.sahbi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node implements Comparable<Node> 
{
	int i, j;
	Integer nodeVal;
	Integer[][] state = new Integer[3][3];
	List<Node> neighbors = new ArrayList<>();
	String pathToGoal = "";
	Integer costOfPath = 0;
	int searchDepth = 0;
	static int maxSearchDepth = 0;
	int f;
	public Node(Integer nodeVal, int i, int j, Integer[][] state, String pathToGoal,Integer costOfPath)
	{
		this.nodeVal = nodeVal;
		this.i = i;
		this.j = j;
		this.state = state;
		this.pathToGoal = pathToGoal;
		this.costOfPath = costOfPath;
		this.searchDepth = costOfPath;
		if(searchDepth > maxSearchDepth)
		{
			maxSearchDepth = searchDepth;
		}
		F();
	}
	
	private void F()
	{
		int g = costOfPath;
		int h = 0;
		Integer[][] goalState = {{0,1,2},{3,4,5},{6,7,8}};
		for(int i = 0; i < 3; i ++ )
		{
			for(int j = 0; j < 3; j++)
			{
				if(goalState[i][j] != state[i][j])
				{
					h++;
				}
			}
		}
		setF(g+h);
	}
	
	
	
	private void getRightNeighbor() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i, j1 = j + 1;
		Integer nodeValTemp;
		if(j + 1 < 3)
		{
			nodeValTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(nodeValTemp, i1, j1, stateTemp, pathToGoal+" Right", costOfPath+1);
			neighbors.add(tempNode);
		}
		
	}



	private void getLeftNeighbor() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i, j1 = j - 1;
		Integer nodeValTemp;
		if(j - 1 >= 0)
		{
			nodeValTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(nodeValTemp, i1, j1, stateTemp, pathToGoal+" Left", costOfPath+1);
			neighbors.add(tempNode);
		}
		
	}



	private void getBottomNeighbor() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i + 1, j1 = j;
		Integer nodeValTemp;
		if(i + 1 < 3)
		{
			nodeValTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(nodeValTemp, i1, j1, stateTemp, pathToGoal+" Bottom", costOfPath+1);
			neighbors.add(tempNode);
		}
		
	}



	private void getTopNeighbor() {
		Integer[][] stateTemp = new Integer[3][3];
		for(int k = 0; k < 3; k++)
		{
			for(int l = 0; l < 3; l++)
			{
				stateTemp[k][l] = state[k][l];
			}
		}
		int i1 = i - 1, j1 = j;
		Integer nodeValTemp;
		if(i - 1 >= 0)
		{
			nodeValTemp = stateTemp[i1][j1];
			Integer temp = stateTemp[i1][j1];
			stateTemp[i1][j1] = stateTemp[i][j];
			stateTemp[i][j] = temp;
			Node tempNode = new Node(nodeValTemp, i1, j1, stateTemp, pathToGoal+" Top", costOfPath+1);
			neighbors.add(tempNode);
		}
		
		
		
	}



	public Node() {
		super();
	}



	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public Integer getNodeVal() {
		return nodeVal;
	}

	public void setNodeVal(Integer nodeVal) {
		this.nodeVal = nodeVal;
	}

	public Integer[][] getState() {
		return state;
	}

	public void setState(Integer[][] state) {
		this.state = state;
	}



	public List<Node> getNeighbors() {
		
		getTopNeighbor();
		getBottomNeighbor();
		getLeftNeighbor();
		getRightNeighbor();
		
		
		
		return neighbors;
	}



	public String getPathToGoal() {
		return pathToGoal;
	}



	public void setPathToGoal(String pathToGoal) {
		this.pathToGoal = pathToGoal;
	}



	public void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nodeVal == null) ? 0 : nodeVal.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (nodeVal == null) {
			if (other.nodeVal != null)
				return false;
		} else if (!nodeVal.equals(other.nodeVal))
			return false;
		return true;
	}



	public Integer getCostOfPath() {
		return costOfPath;
	}



	public void setCostOfPath(Integer costOfPath) {
		this.costOfPath = costOfPath;
	}



	public int getSearchDepth() {
		return searchDepth;
	}



	public void setSearchDepth(int searchDepth) {
		this.searchDepth = searchDepth;
	}
	
	public int getMaxSearchDepth() {
		return maxSearchDepth;
	}

	public void setMaxSearchDepth(int maxSearchDepth) {
		this.maxSearchDepth = maxSearchDepth;
	}

	

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if(f < o.getF())
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	
}
