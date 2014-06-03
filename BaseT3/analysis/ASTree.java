package analysis;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import analysis.ASTNode.*;

public class ASTree
{
	private Node root;
	private List<String> errors;

	public ASTree(Node root)
	{
		this.root = root;
		errors = new ArrayList<String>();
	}

	public Node getRoot()
	{
		return root;
	}

	public void print()
	{
		search(root);
		for(int i=0;i<errors.size();i++)
		{
			System.out.println(errors.get(i));
		}
		print(root, "", "");
	}
	
	private void search(Node nd)
	{
		nd.toString();
		for(int i=0;i<nd.errors.size();i++)
		{
			errors.add(nd.errors.get(i));
		}
		Node aux = nd.leftChild();
		if(aux == null) {
			return;
		}
		while(aux.rightBrotherp()) {
			search(aux);
			aux = aux.rightBrother();
		}
		search(aux);
	}
	private void print(Node nd, String prefix1, String prefix2)
	{
		System.out.printf("%s%s\n", prefix1, nd.toString());
		Node aux = nd.leftChild();

		if(aux == null) {
			return;
		}

		while(aux.rightBrotherp()) {
			print(aux, prefix2 + "|-- ", prefix2 + "|   ");
			aux = aux.rightBrother();
		}
		print(aux, prefix2 + "|-- ", prefix2 + "    ");
	}
}
