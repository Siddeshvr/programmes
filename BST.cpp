#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <graphviz/gvc.h>
using namespace std;


class Node
{
public:
	int key;
	Node *left,*right;
	Node* newNode(int item);
	Node* insert(Node *root,int key);
	Node* minValueNode(Node *node);
	Node* del(Node *root,int key);
	void write_item(Node *root,std::ofstream& ofile);
	void Graph(Node *root);
	void Sort(Node *root);
};

Node* Node :: newNode(int item)
{
	Node *temp = new Node[10];
	temp->key = item; 
	temp->left = temp->right = NULL;
	return temp;
}

Node* Node :: insert(Node *root,int key)
{
	if(root == NULL)
		return newNode(key);

	if(key < root->key)
		root->left = insert(root->left , key);

	else if(key > root->key)
		root->right = insert(root->right , key);

	return root;
}

Node* Node :: minValueNode(Node *node)
{
	Node *current = node;
	while(current->left != NULL)
		current = current->left;
	return current;
}

Node* Node :: del(Node *root,int key)
{
	if(root == NULL)
		return root;

	if(key < root->key)
		root->left = del(root->left , key);
	else if(key > root->key)
		root->right = del(root->right , key);
	else
	{
		if(root->left == NULL)
		{
			Node *temp = root->right;
			delete root;
			return temp;
		}
		else if(root->right == NULL)
		{
			Node * temp = root->left;
			delete root;
			return temp;
		}
		Node *temp = minValueNode(root->right);
		root->key = temp->key;
		root->right = del(root->right,temp->key);
	}
	return root;
}

void Node :: write_item(Node *root , std::ofstream& ofile)
{
	if(root != NULL)
	{
		if(root->left != NULL)
			ofile<<root->key<<"--"<<root->left->key<<";"<<endl;
		if(root->right != NULL)
			ofile<<root->key<<"--"<<root->right->key<<";"<<endl;
		write_item(root->left,ofile);
		write_item(root->right,ofile);
	}
}

void Node :: Graph(Node *root)
{
	ofstream ofile;
	ofile.open("diagram.dot");
	ofile<<"Graph{\n";
	write_item(root,ofile);
	ofile<<"}\n";
	ofile.close();
}


void Node :: Sort(Node *root)           //Inorder traversal for sorted items...
{
	if(root != NULL)
	{
		Sort(root->left);
		cout<<root->key<<" ";
		Sort(root->right);
	}
}


int main()
{
	Node ob;
	Node *root;
	root = NULL;
	int c;
	while(true)
	{
		cout<<"\n1.Insert \n2.Delete\n3.Display graph\n4.Sorted order\n5.exit\n";
		cout<<"Enter your choice : ";
		cin>>c;
		switch(c)
		{
			case 1:cout<<"Enter an inserting element : ";
					int item;
					cin>>item;
					root = ob.insert(root,item);
					break;
			case 2:cout<<"Enter a key to delete : ";
					int key;
					cin>>key;
					root = ob.del(root,key);
					break;
			case 3:ob.Graph(root);
					break;
			case 4:cout<<"Sorted order : ";
					ob.Sort(root);
					break;
			case 5:exit(0);
			default:cout<<"Invalid choice\n";
					exit(0);
		}
	}	
	return 0;
}
