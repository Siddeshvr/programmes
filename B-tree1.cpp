#include <iostream>
#include <stdlib.h>
#include <fstream>
using namespace std;

class Node
{
    int n;
    int key[10];
    Node *child[11];
    Node *parent;
    bool leaf;
    public:
    int t;   //degree...
    Node* getNode();
    Node* Insert(Node *root , int item);
    Node* Splitting(Node *node , int item);
    void Traversal(Node *root);
    void write_item(Node *root , std::ofstream& ofile);
    void Graph(Node *root);
};

Node* Node :: getNode()
{
    Node *temp = new Node[10];
    for(int i=0;i < 2*t;i++)
        temp->child[i] = NULL;
    temp->n = 0;
    return temp;
}


void Node :: write_item(Node *root , std::ofstream& ofile)
{
    if(root == NULL)
        return;

    if(root->child[0]==NULL)
    {
        ofile<<'"';
        for(int j=0; j<root->n; j++)
            ofile<<root->key[j]<<",";
        ofile<<'"';
    }
    else 
    {
        for(int i=0; i<root->n+1; i++)
        {
            ofile<<'"';
            for(int j=0; j<root->n; j++)
                ofile<<root->key[j]<<",";
            ofile<<'"';
            ofile<<"--"<<'"';
            for(int j=0; j<root->child[i]->n; j++)
                ofile<<root->child[i]->key[j]<<",";
            ofile<<'"';

            write_item(root->child[i],ofile);
        }
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


void Node :: Traversal(Node *root)    
{
    int i;
    for(i=0;i<root->n;i++)
    {
        if(root->leaf == false)
            Traversal(root->child[i]);
        cout<<" "<<root->key[i];
    }
    if(root->leaf == false)
        Traversal(root->child[i]);
}


Node* Node :: Splitting(Node *node , int item)
{
    if(node->parent == NULL)
    {
        if(node->child[0]==NULL and node->child[1]==NULL)
        {
            node->child[0] = getNode();
            int i=0;
            while(i < t-1)
            {
                node->child[0]->key[i] = node->key[i];
                i++;
            }
            node->child[0]->n = i;
            node->child[0]->parent = node;
            node->child[0]->leaf = true;

            node->child[1] = getNode();
            i=0;
            int j=t;
            while(i < t-1)
            {
                node->child[1]->key[i] = node->key[j];
                i++;
                j++;
            }
            node->child[1]->n = i;
            node->child[1]->parent = node;
            node->child[1]->leaf = true;

            node->key[0] = node->key[t-1];
            node->n = 1;

            i = node->n -1;
            while(i>=0 and node->key[i]>item)
                i--;

            j = node->child[i+1]->n -1;
            while(j>=0 and node->child[i+1]->key[j] > item)
            {
                node->child[i+1]->key[j+1] = node->child[i+1]->key[j];
                j--;
            }

            node->child[i+1]->key[j+1] = item;
            node->child[i+1]->n += 1;

            node->leaf = false;

            return node;
        }
        else
        {
            Node *temp = getNode();
            temp->key[0] = node->key[t-1];
            temp->n = 1;
            temp->leaf = false;
            temp->parent = NULL;

            Node *Z = getNode();      //To make 2nd child...
            int i=0;
            int j=t;
            while(i < t-1)
            {
                Z->key[i] = node->key[j];
                i++;
                j++;
            }
            Z->n = i;
            Z->parent = temp;
            Z->leaf = false;
            
            int k = t;
            for(int i=0;i<t;i++)
            {
                Z->child[i] = getNode();
                Z->child[i] = node->child[k];
                Z->child[i]->parent = Z;
                node->child[k] = NULL;
                k++;
            }

            temp->child[1] = Z;
            node->n = t-1;              //............................
            temp->child[0] = node;
            temp->child[0]->parent = temp;
            temp->child[0]->leaf = false;

            i = temp->n -1;
            while(i>=0 and temp->key[i] > item)
                i--;
            return temp->child[i+1];
        }
    }
    else
    {
        if(node->child[0]==NULL and node->child[1]==NULL)
        {
            Node *temp = getNode();
            temp = node->parent;

            if(temp->n == 2*t-1) 
                temp = Splitting(temp , item); //Splitting the parent if full...

            int j = temp->n;
            while(j>=0 and temp->child[j] != node)
            {
                temp->child[j+1] = getNode();
                temp->child[j+1] = temp->child[j];
                j--;
            }
            int i = temp->n -1;
            while(i>=0 and temp->key[i] > node->key[t-1])
            {
                temp->key[i+1] = temp->key[i];
                i--;
            }

            temp->key[i+1] = node->key[t-1];
            temp->n += 1;
            temp->child[j+1] = getNode();
            i=0;
            int k=t;
            while(i < t-1)
            {
                temp->child[j+1]->key[i] = node->key[k];   //writing values to new node...
                i++;
                k++;
            }
            temp->child[j+1]->n = i;

            temp->child[j+1]->parent = temp;
            temp->child[j+1]->leaf = true;

            node->n = t-1;                 //.............................................
            temp->child[j] = node;
            temp->child[j]->parent = temp;

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

            if(temp->n == 2*t-1) 
                temp = Splitting(temp , item); //Splitting the parent if full...


            int i = temp->n -1;
            while(i>=0 and temp->key[i] > node->key[t-1])
            {
                temp->key[i+1] = temp->key[i];
                i--;
            }
            temp->key[i+1] = node->key[t-1];
            temp->n += 1;

            i = temp->n -1;
            while(i>=0 and temp->child[i] != node)
            {
                temp->child[i+1] = getNode();
                temp->child[i+1] = temp->child[i];
                i--;
            }

            temp->child[i+1] = getNode();
            int j=0;
            int k=t;
            while(j < t-1)
            {
                temp->child[i+1]->key[j] = node->key[k];   //writing values to new node...
                j++;
                k++;
            }
            temp->child[i+1]->n = j;

            temp->child[i+1]->parent = temp;
            temp->child[i+1]->leaf = false;


            k = t;
            for(int j=0;j<t;j++)
            {
                temp->child[i+1]->child[j] = getNode();
                temp->child[i+1]->child[j] = node->child[k];
                temp->child[i+1]->child[j]->parent = temp->child[i+1];
                node->child[k] = NULL;
                k++;
            }

            node->n = t-1;                        //.................................................
            temp->child[i] = node;
            temp->child[i]->parent = temp;
            temp->child[i]->leaf = false;
        
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
    {
        Node *temp = new Node[10];
        temp = getNode();
        temp->key[0] = item;
        temp->n = 1;
        temp->leaf = true;
        temp->parent = NULL;      //First make as NULL , then assign...
        return temp;
    }
    
    if(root->leaf == true)
    {
        if(root->n == 2*t-1)  
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
    cout<<"Enter degree 't' value : ";
	Node ob;   
    cin>>ob.t;
    int item;
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
			case 1:srand(time(0));
					item = (rand() % (100-0+1))+0 ;
                    //cout<<item<<endl;           //To know which item generated...
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