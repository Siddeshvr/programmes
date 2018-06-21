#include <limits.h>
#include "Fun_test.cpp"
#include <gtest/gtest.h>

class Insert : public ::testing::Test 
{
    protected:
    virtual void SetUp(){}
    virtual void TearDown(){}
};

TEST_F(Insert,root)
{
    Node ob;
    Node *root = NULL;
    root = ob.insert(root,10);
    EXPECT_EQ(1,root->n);
    root = ob.insert(root,30);
    EXPECT_EQ(2,root->n);
    root = ob.insert(root,50);
    EXPECT_EQ(1,root->n);
    
    /*
    int expected[] = {10,30,50};
    int actual[] = {ob.Traversal(root)};
    EXPECT_EQ(memcmp(expected,actual,2*sizeof(int)),0);
    */
}

class Splitting : public ::testing::Test
{
    protected:
    virtual void SetUp(){}
    virtual void TearDown(){}
};

TEST_F(Splitting,split)
{
    Node ob;
    Node *root;
    root = ob.getNode(10);
    //root->key[0] = 10;
    root->key[1] = 20;
    root->key[2] = 30;
    root->n = 3;
    root = ob.splitNode(root);
    EXPECT_EQ(1,root->n);
    EXPECT_EQ(20,root->key[0]);
    EXPECT_EQ(10,root->child[0]->key[0]);
    EXPECT_EQ(30,root->child[1]->key[0]);
}

int main(int argc, char **argv) 
{
    testing::InitGoogleTest(&argc, argv);
    return RUN_ALL_TESTS();
}