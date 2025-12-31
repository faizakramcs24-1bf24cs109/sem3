#include <stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node* left;
    struct node* right;

};
struct node* create(){
    struct node* newnode=(struct node*)malloc(sizeof(struct node));
    printf("enter value for root");
    scanf("%d",&newnode->data);
    newnode->left=newnode->right=NULL;
    return newnode;
    
}
void insert(struct node* root, struct node* temp){
if(temp->data < root-> data){
    if(root->left!=NULL){
        insert(root->left,temp);
    }else{
        root->left=temp;
    }
}
if(temp->data > root-> data){
    if(root->right!=NULL){
        insert(root->right,temp);
    }else{
        root->right=temp;
    }
}
}
void preorder(struct node *root)
{
if(root!=NULL)
{
printf("%d ",root->data);
preorder(root->left);
preorder(root->right);
}
}
void preorders(struct node* root) {
if (root != NULL) {
printf("%d ", root->data);
preorders(root->left);
preorders(root->right);
}
}
void inorder(struct node* root) {
if (root != NULL) {
inorder(root->left);
printf("%d ", root->data);
inorder(root->right);
   }
}

int main(){
    char ch='y';
    struct node* root=NULL;
    struct node* temp=NULL;
    do{
        temp=create();
        if(root==NULL){root=temp;}
        else{
            insert(root, temp);
            printf("you want o enter more");
            getchar();
            scanf("%c",&ch);
        }
    }while(ch=='y'|| ch=='Y');
    printf("traverssal preoder");
    preorder(root);
}
