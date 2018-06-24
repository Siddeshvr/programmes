#include <iostream>
#include <stdlib.h>
#include <fstream>
using namespace std;

class Node
{
    int n;
    int key[4];
    bool leaf;
    Node *child[5];
    Node *parent;
    public:
    Node* getNode(int item);
    Node* getNode();
    Node* Insert(Node *root , int item);
    Node* Splitting(Node *node , int item);
    void write_item(Node *root , std::ofstream& ofile);
    void Graph(Node *root);
    void Traversal(Node *root);
};

Node* Node :: getNode()
{
    Node *temp = new Node[10];
    for(int i=0;i<5;i++)
        temp->child[i]=NULL;
    temp->n = 0;
    return temp;
}

Node* Node :: getNode(int item)
{
    Node *temp = new Node[10];
    temp->key[0] = item;
    temp->n = 0;
    for(int i=0;i<5;i++)
        temp->child[i]=NULL;
    temp->leaf = true;
    temp->n = 1;
    temp->parent = NULL;
    return temp;
}


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
    else if(root->n ==2)        //Node containing 3 childs...
    {
        Traversal(root->child[0]);
        cout<<root->key[0]<<" ";
        Traversal(root->child[1]);
        cout<<root->key[1]<<" ";
        Traversal(root->child[2]);
    }
    else                       //Node containing 4 childs...  
    {
        Traversal(root->child[0]);
        cout<<root->key[0]<<" ";
        Traversal(root->child[1]);
        cout<<root->key[1]<<" ";
        Traversal(root->child[2]);
        cout<<root->key[2]<<" ";
        Traversal(root->child[3]);
    }
}


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
    else if(root->n == 1 and root->child[0] != NULL)     //node with two childrens...
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
    else if(root->n==2 and root->child[2]!=NULL)   //node with 3 childrens...
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
    else if(root->n==3 and root->child[3] != NULL)
    {
        int k=0;
        while(k<4)
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
        write_item(root->child[3],ofile);  //4th child traversal...
    }
}


void Node :: Graph(Node *root)       
{
    ofstream ofile;
    ofile.open("diagram.dot");    //creating file...
    ofile<<"Graph{\n";
    write_item(root,ofile);
    ofile<<"}\n";
    ofile.close();
}


Node* Node :: Splitting(Node *node , int item)
{
    if(node->n != 3)
        return node;
    
    if(node->parent == NULL)
    {
        if(node->child[0]==NULL and node->child[1]==NULL)
        {
            node->child[0] = getNode(node->key[0]);
            node->child[1] = getNode(node->key[2]);
            node->key[0] = node->key[1];
            node->n = 1;

            int i = node->n -1;
            while(i>=0 and node->key[i]>item)
                i--;
             
            int j = node->n -1;
            while(j>=0 and node->child[i+1]->key[j] > item)
            {
                node->child[i+1]->key[j+1] = node->child[i+1]->key[j];
                j--;
            }
            
            node->child[i+1]->key[j+1] = item;
            node->child[i+1]->n = 2;
            
            node->child[0]->parent = node;
            node->child[1]->parent = node;
            node->leaf = false;

            return node;
        }
        else
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

            temp->child[1] = Z;
            node->n = 1;
            temp->child[0] = node;
            temp->child[0]->parent = temp;
            temp->child[0]->leaf = false;

            return temp->child[0];
        }
    }
    else
    {
        if(node->child[0]==NULL and node->child[1]==NULL)
        {
            Node *temp = getNode();
            temp = node->parent;

            if(temp->n == 3)
                temp = Splitting(temp , item); //Splitting the parent if full...

            int j = temp->n;
            while(j>=0 and temp->child[j] != node)
            {
                temp->child[j+1] = getNode();
                temp->child[j+1] = temp->child[j];
                j--;
            }
            int i = temp->n -1;
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

            i = temp->n -1;
            while(i>=0 and temp->key[i]>item)
                i--;
             
            j = temp->child[i+1]->n -1;
            while(j>=0 and temp->child[i+1]->key[j] > item)
            {
                temp->child[i+1]->key[j+1] = temp->child[i+1]->key[j];
                j--;
            }       
                 

            temp->child[i+1]->key[j+1] = item;
            temp->child[i+1]->n += 1;

            while(temp->parent != NULL)    //To return root...
                temp = temp->parent;

            return temp;
        }
        else                          //To split node which has childs...
        {
            Node *temp = getNode();
            temp = node->parent;

            int i = temp->n -1;
            while(i>=0 and temp->key[i] > node->key[1])
            {
                temp->key[i+1] = temp->key[i];
                i--;
            }
            temp->key[i+1] = node->key[1];
            temp->n += 1;

            i = temp->n -1;
            while(i>=0 and temp->child[i] != node)
            {
                temp->child[i+1] = getNode();
                temp->child[i+1] = temp->child[i];
                i--;
            }

            temp->child[i+1] = getNode(node->key[2]);
            temp->child[i+1]->leaf = false;
            temp->child[i+1]->parent = temp;

            temp->child[i+1]->child[0] = getNode();
            temp->child[i+1]->child[0] = node->child[2];

            temp->child[i+1]->child[1] = getNode();
            temp->child[i+1]->child[1] = node->child[3];

            Node *Z = getNode(node->key[0]);        //Z->n is 1...
            Z->leaf = false;
            Z->parent = temp;
            
            Z->child[0] = getNode();
            Z->child[0] = node->child[0];
            Z->child[0]->parent = Z;
            Z->child[1] = getNode();
            Z->child[1] = node->child[1];
            Z->child[1]->parent = Z;

            temp->child[i] = Z;                //New child of root...
        
            i = temp->n -1;
            while(i>=0 and temp->key[i] > item)     //To return particular child...
                i--;

            return temp->child[i+1];
        }
    }
}


Node* Node :: Insert(Node *root , int item)
{
    if(root == NULL)
        return getNode(item);
    
    if(root->leaf == true)
    {
        if(root->n == 3) 
            root = Splitting(root,item);
        else
        {
            int i = root->n - 1;
            while(i>=0 and root->key[i] > item)
            {
                root->key[i+1] = root->key[i];
                i--;
            }
            root->key[i+1] = item;
            root->n += 1;
        }

        while(root->parent != NULL)
            root = root->parent;
        return root;
    }
    else
    {
        int i = root->n -1;
        while(i>=0 and root->key[i]>item)
            i--;
        root = Insert(root->child[i+1] , item);
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
					root = ob.Insert(root,item);
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

