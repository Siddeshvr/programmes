#include <iostream>
#include <fstream>  //header file for file managing...
#include <stdlib.h>
using namespace std;

class Node 
{
    int n;
    int key[3];    //array of keys...
    Node *child[4]; //array for child...
    bool leaf;
    Node *parent;  //variable for parent of a node...
    public:
    Node* getNode();
    Node* getNode(int item);
    Node* splitNode(Node *root);
    Node* insert(Node *root , int item);
    void Traversal(Node *root);
    void write_item(Node *root , std::ofstream& ofile);
    void Graph(Node *root);
};

//Return empty node...
Node* Node :: getNode()
{
    Node *temp = new Node[10];
    temp->n = 0;
    for(int i=0;i<4;i++)
        temp->child[i] = NULL;
    return temp;
}

//Returns weighted node...
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

//to write a file...
void Node :: write_item(Node *root , std::ofstream& ofile)
{
    if(root == NULL)   //to exit from recursion if no further nodes...
        return;
    
    if(root->leaf == true and root->parent==NULL)   //only for root node...
    {
        ofile<<'"';
        for(int i=0;i<root->n;i++)
            ofile<<root->key[i]<<",";
        ofile<<'"';
    }
    else if(root->n == 1)     //node with two childrens...
    {
        int k=0;
        while(k<2 and root->child[0]!=NULL)  //To process both childrens...
        {
            ofile<<'"';
            for(int i=0;i<root->n;i++)
                ofile<<root->key[i]<<" ";
            ofile<<'"'<<"--"<<'"';
            for(int i=0;i<root->child[k]->n;i++)
                ofile<<root->child[k]->key[i]<<" ";
            ofile<<'"'<<endl;
            k++;
        }
        write_item(root->child[0],ofile);  //left child traversal...
        write_item(root->child[1],ofile);  //right child traversal...
    }
    else if(root->child[2]!=NULL)   //node with 3 childrens...
    {
        int k=0;
        while(k<3)
        {
            ofile<<'"';
            for(int i=0;i<root->n;i++)
                ofile<<root->key[i]<<" ";
            ofile<<'"'<<"--"<<'"';
            for(int i=0;i<root->child[k]->n;i++)
                ofile<<root->child[k]->key[i]<<" ";
            ofile<<'"'<<endl;
            k++;
        }
        write_item(root->child[0],ofile);  //1st child traversal...
        write_item(root->child[1],ofile);  //2nd child traversal...
        write_item(root->child[2],ofile);  //3rd child traversal...
    }
}

//To create Graph using Graphviz...
void Node :: Graph(Node *root)       
{
    ofstream ofile;
    ofile.open("diagram.dot");    //creating file...
    ofile<<"Graph{\n";
    write_item(root,ofile);
    ofile<<"}\n";
    ofile.close();
}

//Inorder traversal to display elements in sorted order...
void Node :: Traversal(Node *root)    
{
    if(root == NULL)        //Base case of recursion...
        return;

    if(root->leaf == true)
        for(int i=0;i<root->n;i++)
            cout<<root->key[i]<<" ";
    else if(root->n == 1)           //Node containing 2 childs...
    {
        Traversal(root->child[0]);
        for(int i=0;i<root->n;i++)
            cout<<root->key[i]<<" ";
        Traversal(root->child[1]);
    }
    else            //Node containing 3 childs...
    {
        Traversal(root->child[0]);
        cout<<root->key[0]<<" ";
        Traversal(root->child[1]);
        cout<<root->key[1]<<" ";
        Traversal(root->child[2]);
    }
}

//To split full node...
Node* Node :: splitNode(Node *node)
{
    if(node->n != 3)            //Base case to stop recursion...
        return node;  
    
    if(node->parent == NULL)   //splitting root node...
    {
        if(node->child[0] == NULL and node->child[1]==NULL)  //when root has no childs...
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
    else   //if node is not root...
    {
        if(node->child[0] == NULL and node->child[1]==NULL)   //If that node has no childs...
        {
            Node *temp = getNode();   //To make temp as nodes parent...
            temp = node->parent;
            int j = temp->n;

            while(j>=0 and temp->child[j] != node)         //To create nodes new sibling...
            {
                temp->child[j+1] = getNode();
                temp->child[j+1] = temp->child[j];
                j--;
            }

            int i = temp->n - 1;
            while(i>=0 and temp->key[i] > node->key[1])   //to insert middle value to parent in sorted order...
            {
                temp->key[i+1] = temp->key[i];
                i--;
            }
            temp->key[i+1] = node->key[1];        //Inserting at correct address...
            temp->n += 1;
            temp->child[j+1] = getNode(node->key[2]);

            temp->child[j+1]->parent = temp;
            temp->child[j+1]->leaf = true;

            node->n = 1;
            temp->child[j] = getNode();
            temp->child[j] = node;
            temp->child[j]->parent = temp;
            temp->child[j]->leaf = true;

            if(temp->n != 3)           //If node->parent(temp) is not full return...else split by recursion...
                return temp;      
        }
        else                          //To split node which has childs...
        {
            Node *temp = getNode();
            temp = node->parent;
            int j = temp->n;
            while(j>=0 and temp->child[j] != node)   //To create nodes new sibling...
            {
                temp->child[j+1] = getNode();
                temp->child[j+1] = temp->child[j];
                j--;
            }

            int i = temp->n - 1;
            while(i>=0 and temp->key[i] > node->key[1])     //to insert middle value to parent in sorted order...
            {
                temp->key[i+1] = temp->key[i];
                i--;
            }
            temp->key[i+1] = node->key[1];         //To insert at correct address...
            temp->n += 1;

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

            temp->child[j+1] = Z;     

            node->n = 1;
            temp->child[j] = node;  

            return temp;          
        }
    }
    if(node->parent != NULL)           
        node = splitNode(node->parent);   //To check whether node->parent is full or not...if full split...
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

        if(root->n == 3)           //If node is full , split...
            root = splitNode(root);

        while(root->parent != NULL)     //To search for root...
            root = root->parent;
        return root;             //Return root...
    }
    else
    {
        int i = root->n-1;
        while(i>=0 and root->key[i] > item)               //decide which child for next insertion...
            i--;
        root = insert(root->child[i+1],item);
        return root;
    }
}

int main()
{
	Node ob;
	Node *root;  //Initail root which is NULL...
	root = NULL;
	int c;
	while(true)
	{
		cout<<"\n1.Insert \n2.Display graph\n3.Sorted order\n4.exit\n";
		cout<<"Enter your choice : ";
		cin>>c;
		switch(c)
		{
			case 1:cout<<"Enter an inserting element : ";
					int item;
					cin>>item;
					root = ob.insert(root,item);
					break;
            case 2:ob.Graph(root);
                    break;
            case 3:if(root == NULL)
                        cout<<"Empty\n";
                    else
                    {
                        cout<<"Sorted order : ";
                        ob.Traversal(root);
                    }
                    break;
			case 4:exit(0);
			default:cout<<"Invalid choice\n";
					exit(0);
		}
	}	
	return 0;
}
