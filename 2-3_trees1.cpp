#include <iostream>
#include <stdlib.h>
using namespace std;


class Node 
{
    int n;
    int key[3];    //array of keys...
    Node *child[4]; //array for child...
    bool leaf;
    Node *parent;
    public:
    Node* getNode();
    Node* getNode(int item);
    Node* splitNode(Node *root);
    Node* insert(Node *root , int item);
};

Node* Node :: getNode()
{
    Node *temp = new Node[10];
    temp->n = 0;
    for(int i=0;i<4;i++)
        temp->child[i] = NULL;
    return temp;
}


Node* Node :: getNode(int item)
{
    Node *temp = new Node[10];
    temp->n = 0;
    for(int i=0;i<4;i++)
        temp->child[i] = NULL;
    temp->key[0] = item;
    temp->n = 1;
    temp->leaf = true;
    temp->parent = NULL;
    return temp;
}


Node* Node :: splitNode(Node *node)
{
    if(node->n != 3)            //Base case to stop recursion...
        return node;  
    
    if(node->parent == NULL)   //splitting root node...
    {
        if(node->child[0] == NULL and node->child[1]==NULL)
        {
            node->child[0] = getNode(node->key[0]);
            node->child[1] = getNode(node->key[2]);
            node->key[0] = node->key[1];

            node->child[0]->parent = node;
            node->child[1]->parent = node;

            node->n = 1;
            node->leaf = false;
            return node;
        }
        else                    //To split root which has 4 children...
        {
            Node *temp = getNode(node->key[1]);
            temp->leaf = false;

            Node *Z = getNode();
            Z->leaf = false;
            Z->parent = temp;

            Z->key[0] = node->key[2];
            Z->n = 1;
            Z->child[0] = getNode();
            Z->child[0] = node->child[2];
            Z->child[0]->parent = Z;
            node->child[2] = NULL;
            Z->child[1] = getNode();
            Z->child[1] = node->child[3];
            Z->child[1]->parent = Z;
            node->child[3] = NULL;

            temp->child[1] = Z;     //roots right child...

            node->n = 1;

            temp->child[0] = node;  //root left child...

            return temp;
        }

    }
    else
    {
        if(node->child[0] == NULL and node->child[1]==NULL)
        {
            Node *temp = getNode();
            temp = node->parent;
            int j = temp->n;

            while(j>=0 and temp->child[j] != node)
            {
                temp->child[j+1] = getNode();
                temp->child[j+1] = temp->child[j];
                j--;
            }

            int i = temp->n - 1;
            while(i>=0 and temp->key[i] > node->key[1])
            {
                temp->key[i+1] = temp->key[i];
                i--;
            }
            temp->key[i+1] = node->key[1];
            temp->n += 1;
            temp->child[j+1] = getNode(node->key[2]);

            temp->child[j+1]->parent = temp;
            temp->child[j+1]->leaf = true;

            node->n = 1;
            temp->child[j] = getNode();
            temp->child[j] = node;
            temp->child[j]->parent = temp;
            temp->child[j]->leaf = true;

            if(temp->n != 3)           //else go to split in the bottom...
                return temp;      //return root...
        }
        else   //Need to work...
        {
            Node *temp = getNode();
            temp = node->parent;
            int j = temp->n;
            while(j>=0 and temp->child[j] != node)
            {
                temp->child[j+1] = temp->child[j];
                j--;
            }

            int i = temp->n - 1;
            while(i>=0 and temp->key[i] > node->key[1])
            {
                temp->key[i+1] = temp->key[i];
                i--;
            }
            temp->key[i+1] = node->key[1];

            Node *Z = getNode();;
            Z = temp->child[j+1];          //Newly formed child...

            Z->key[0] = node->key[2];
            Z->n = 1;
            Z->child[0] = node->child[2];
            node->child[2] = NULL;
            Z->child[0]->n = 1;
            Z->child[1] = node->child[3];
            node->child[3] = NULL;
            Z->child[1]->n = 1;

            node->n = 1;

        }
    }

    if(node->parent != NULL)
        node = splitNode(node->parent);
    return node;

}




Node* Node :: insert(Node *root , int item)
{
    if(root == NULL)       //base case to stop recursion...
        return getNode(item);

    if(root->leaf == true)
    {
        int i = root->n - 1;
        while(i>=0 and root->key[i] > item)
        {
            root->key[i+1] = root->key[i];
            i--;
        }
        root->key[i+1] = item;
        root->n += 1;

        if(root->n == 3)
            root = splitNode(root);
        return root;
    }
    else
    {
        int i = root->n-1;
        while(i>=0 and root->key[i] > item)               //decide which child for next insertion...
            i--;
        root = insert(root->child[i+1] , item);
        return root;
    }
}


int main()
{
	Node ob;
	Node *root = ob.getNode();
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
			case 5:exit(0);
			default:cout<<"Invalid choice\n";
					exit(0);
		}
	}	
	return 0;
}
